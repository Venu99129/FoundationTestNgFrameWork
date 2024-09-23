package com.automation.utils;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    
    static Properties prop;
    
    public static void init() throws IOException {
        prop = new Properties();
        prop.load(new FileReader("src/test/resources/config/Config.properties"));
    }

    public static String getPropertyValue(String key){
        return prop.getProperty(key);
    }
}
