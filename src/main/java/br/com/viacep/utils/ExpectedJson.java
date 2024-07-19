package br.com.viacep.utils;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ExpectedJson {

    public static String json(String nameFile) throws IOException {
        return Files.readString(Path.of("src/test/resources/schemas/" + nameFile));
    }
}