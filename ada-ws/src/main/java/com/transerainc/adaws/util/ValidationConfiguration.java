package com.transerainc.adaws.util;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ValidationConfiguration {

    private static Logger LOGGER = LoggerFactory.getLogger(ValidationConfiguration.class.getName());

    private static ValidationConfiguration instance = null;

    private Properties properties;

    private ValidationConfiguration() {
        super();
        init();
    }

    private void init() {
        final File propertiesFile = new File("./config/validation.properties");
        
		try (FileInputStream fileStream = new FileInputStream(propertiesFile)) {
            properties = new Properties();
            properties.load(fileStream);
        } catch (final Exception e) {
            LOGGER.error("Exception occured while loading validation properties " + e);
        }
    }

    public static ValidationConfiguration getInstance() {
        if (instance == null) {
            instance = new ValidationConfiguration();
        }
        return instance;
    }

    public String getProperty(final String s) {
        return (String) properties.get(s);
    }

    public Set<Object> getPropertyKeys() {
        return properties.keySet();
    }
}
