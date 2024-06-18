package br.com.viacep.utils;

public class Endpoint {
    private static String BASE_URI;
    private static String BASE_PATH_ZIP_CODE;

    protected static String baseUri() {
        return BASE_URI = PropertiesData.getPropertiesData("url", "BASE_URI");
    }

    protected static String basePathZipCode() {
        return BASE_PATH_ZIP_CODE = PropertiesData.getPropertiesData("url", "BASE_PATH_ZIP_CODE");
    }
}