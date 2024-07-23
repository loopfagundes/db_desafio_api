package br.com.viacep.endponits;

import br.com.viacep.utils.FakeGenerator;
import br.com.viacep.utils.PropertiesData;

public class EndpointConfig extends ServiceUrlPaths {

    protected static String baseUri() {
        return BASE_URI = PropertiesData.getPropertiesData("url", "BASE_URI");
    }

    protected static String basePathZipCode() {
        return BASE_PATH_ZIP_CODE = PropertiesData.getPropertiesData("url", "BASE_PATH_ZIP_CODE");
    }

    protected static String basePathZipCodeFormatting() {
        return BASE_PATH_ZIP_CODE_FORMATTING = PropertiesData.getPropertiesData("url", "BASE_PATH_ZIP_CODE_FORMAT");
    }

    protected static String basePathAddress() {
        return BASE_PATH_ADDRESS = PropertiesData.getPropertiesData("url", "BASE_PATH_ADDRESS");
    }

    protected static String basePathZipCodeErro() {
        return BASE_PATH_ZIP_CODE_ERRO = PropertiesData.getPropertiesData("url", "BASE_PATH_ZIP_CODE_ERRO");
    }

    protected static String basePathZipCodeFaker() {
        return BASE_PATH_ZIP_CODE_FAKER = FakeGenerator.fakeZipCode("url", "BASE_PATH_ZIP_CODE_FAKER");
    }

    protected static String basePathZipCodeEmpty() {
        return BASE_PATH_ZIP_CODE_EMPTY = PropertiesData.getPropertiesData("url", "BASE_PATH_ZIP_CODE_EMPTY");
    }

    protected static String basePathZipCodePublicAreaNotExist() {
        return BASE_PATH_PUBLIC_AREA_NOT_EXIST = PropertiesData.getPropertiesData("url", "BASE_PATH_PUBLIC_AREA_NOT_EXIST");
    }

    protected static String basePathZipCodeCityNotExist() {
        return BASE_PATH_CITY_NOT_EXIST = PropertiesData.getPropertiesData("url", "BASE_PATH_CITY_NOT_EXIST");
    }

    protected static String basePathZipCodeUFNotExist() {
        return BASE_PATH_UF_NOT_EXIST = PropertiesData.getPropertiesData("url", "BASE_PATH_UF_NOT_EXIST");
    }
}