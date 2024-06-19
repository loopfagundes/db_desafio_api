package br.com.viacep.utils;

import com.github.javafaker.Faker;

public class FakeGenerator {

    public static String fakeZipCode(String numberCount, String nameProp, String key) {
        String fake = Faker.instance().number().digits(Integer.parseInt(numberCount)) + "/json";
        PropertiesData.setPropertiesData(nameProp, key, fake);
        return fake;
    }
}