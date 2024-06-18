package br.com.viacep.utils;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class ExpectedJson {

    public static String json(String nameFile) throws IOException {
        return FileUtils.readFileToString(new File("src/test/resources/schemas/" + nameFile));
    }
}