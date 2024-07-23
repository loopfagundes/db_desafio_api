package br.com.viacep.utils;

import org.testng.annotations.DataProvider;

public class ZipCodeProvider {

    @DataProvider(name = "contractZipCodeInvalidProvider")
    public Object[][] contractZipCodeInvalidProvider() {
        return new Object[][]{
                {"123456"},
                {"79B42A91"},
                {"000000000"},
        };
    }

    @DataProvider(name = "zipCodeInvalidProvider")
    public Object[][] zipCodeInvalidProvider() {
        return new Object[][]{
                {"ghfghfghfgh"},
                {"*%$#@!(+"},
                {"74 852 9630"},
        };
    }
}