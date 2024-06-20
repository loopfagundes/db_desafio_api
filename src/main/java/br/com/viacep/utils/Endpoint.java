package br.com.viacep.utils;

public class Endpoint {
    private static String BASE_URI;
    private static String BASE_PATH_ZIP_CODE;
    private static String BASE_PATH_ADDRESS;
    private static String BASE_PATH_ZIP_CODE_INVALID;
    private static String BASE_PATH_ZIP_CODE_FAKER;

    protected static String baseUri() {
        return BASE_URI = PropertiesData.getPropertiesData("url", "BASE_URI");
    }

    protected static String basePathZipCode() {
        return BASE_PATH_ZIP_CODE = PropertiesData.getPropertiesData("url", "BASE_PATH_ZIP_CODE");
    }

    protected static String basePathAddress() {
        return BASE_PATH_ADDRESS = PropertiesData.getPropertiesData("url", "BASE_PATH_ADDRESS");
    }

    protected static String basePathZipCodeInvalid() {
        return BASE_PATH_ZIP_CODE_INVALID = PropertiesData.getPropertiesData("url", "BASE_PATH_ZIP_CODE_INVALID");
    }

    protected static String basePathZipCodeFaker() {
        return BASE_PATH_ZIP_CODE_FAKER = FakeGenerator.fakeZipCode("8","url", "BASE_PATH_ZIP_CODE_FAKER");
    }
}