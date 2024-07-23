package br.com.viacep.utils;

import com.github.javafaker.Faker;

import java.util.Locale;

public class FakeGenerator {

    public static String fakeZipCode(String nameProp, String key) {
        Faker faker = new Faker(new Locale("pt-BR"));
        String zipCode = faker.address().zipCode() + "/json";
        PropertiesData.setPropertiesData(nameProp, key, zipCode);
        return zipCode;
    }
}