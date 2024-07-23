package br.com.viacep.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ExpectedJson {

    public static String json(String folderName, String nameFile) throws IOException {
        return Files.readString(Path.of("src/test/resources/" + folderName + "/" + nameFile));
    }
}