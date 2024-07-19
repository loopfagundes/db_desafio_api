package br.com.viacep.utils;

import org.everit.json.schema.Schema;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class JsonSchemaValidator {

    public static String readJsonFile(String filePath) throws IOException {
        return Files.readString(Path.of(filePath));
    }

    public static void validateJsonSchema(String jsonData, String schemaData) {
        JSONObject jsonSchema = new JSONObject(new JSONTokener(schemaData));
        Schema schema = SchemaLoader.load(jsonSchema);
        JSONObject jsonObject = new JSONObject(new JSONTokener(jsonData));
        schema.validate(jsonObject);
    }

    public static void main(String[] args) {
        extracted();
    }

    private static void extracted() {
        try {
            String schemaFile = "src/test/resources/schemas/validatorZipCode.json";
            String jsonFile = "src/test/resources/JSON/test.json";

            String schemaData = readJsonFile(schemaFile);
            String jsonData = readJsonFile(jsonFile);

            validateJsonSchema(jsonData, schemaData);
            System.out.println("JSON is valid against the schema");
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        } catch (org.everit.json.schema.ValidationException e) {
            System.err.println("JSON validation error: " + e.getMessage());
        }
    }
}