package br.com.viacep.utils.endponits;

import br.com.viacep.utils.FakeGenerator;
import br.com.viacep.utils.PropertiesData;

public class EndpointConfig extends ServiceUrlPaths {

    protected static String baseUri() {
        return BASE_URI = PropertiesData.getPropertiesData("url", "BASE_URI");
    }

    protected static String basePathZipCode() {
        return BASE_PATH_ZIP_CODE = PropertiesData.getPropertiesData("url", "BASE_PATH_ZIP_CODE");
    }

    protected static String basePathZipCodeFormat() {
        return BASE_PATH_ZIP_CODE_FORMAT = PropertiesData.getPropertiesData("url", "BASE_PATH_ZIP_CODE_FORMAT");
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