package br.com.viacep.utils;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class JsonResponseSaver {

    public static void saveJson(String cep, String nameFileResponse) {
        try {
            String url = Endpoint.baseUri() + cep + "/json";
            String filePath = "src/test/resources/responses/" + nameFileResponse + ".json";
            saveJsonResponse(url, filePath);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }
    }

    private static void saveJsonResponse(String url, String filePath) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        if (response.statusCode() == 200) {
            writeToFile(response.body(), filePath);
            System.out.println("Response saved to " + filePath);
        } else {
            System.err.println("Failed to fetch response. HTTP status code: " + response.statusCode());
        }
    }

    private static void writeToFile(String data, String filePath) throws IOException {
        Path path = Paths.get(filePath);
        Files.createDirectories(path.getParent());
        Files.writeString(path, data);
    }
}