package com.automation.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesReader {

    private static PropertiesReader instance = null;
    private final Properties properties;
    private final Logger logger = LogManager.getLogger();

    private PropertiesReader() {
        properties = new Properties();
        try (InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("config.properties")) {
            if (inputStream != null) {
                properties.load(inputStream);
            } else {
                logger.error("config.properties file not found");
            }
        } catch (IOException e) {
            logger.error("Could not read properties file", e);
        }
    }

    public static synchronized PropertiesReader getInstance() {
        if (instance == null) {
            instance = new PropertiesReader();
        }
        return instance;
    }

    public String getProperty(String key) {
        // Check if the property is provided via the command line (-Dproperty=value)
        String systemProperty = System.getProperty(key);
        if (systemProperty != null) {
            return systemProperty;
        }
        // If not provided, fall back to the value from config.properties
        return properties.getProperty(key);
    }
}