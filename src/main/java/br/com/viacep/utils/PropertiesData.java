package br.com.viacep.utils;

import java.io.File;
import java.util.Properties;

import static br.com.viacep.utils.FileOperations.getProperties;

public class PropertiesData {

    public static String getPropertiesData(String fileName, String property) {
        try {
            Properties properties = getProperties("properties" + File.separator + fileName + ".properties");
            return properties.getProperty(property);
        } catch (Exception e) {
            LoggerFactory.log_INFO("Não foi possível ler o arquivo " + e.getMessage());
            return null;
        }
    }

    public static void setPropertiesData(String fileName, String propKey, String propValue) {
        try {
            FileOperations.setProperties("properties" + File.separator + fileName + ".properties", propKey, propValue);
        } catch (Exception e) {
            LoggerFactory.log_INFO("Não foi possível ler o arquivo" + e.getMessage());
        }
    }
}