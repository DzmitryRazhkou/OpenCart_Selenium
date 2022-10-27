package com.qa.opencart.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    public static Properties properties;

    /**
     * This method is used to load properties from config.properties file
     *
     * @return Properties prop object
     */

    public static Properties initProp() {
        properties = new Properties();
        try {
            FileInputStream ip = new FileInputStream("src/main/java/com/qa/opencart/config/Config.properties");
            try {
                properties.load(ip);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return properties;
    }
}
