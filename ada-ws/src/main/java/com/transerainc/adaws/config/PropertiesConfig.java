package com.transerainc.adaws.config;

import java.io.File;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;

import com.transerainc.adaws.constants.AdaConstants;

/**
 * @author varsha.shivaram
 */
@Configuration
public class PropertiesConfig {
    private static Logger LOGGER = LoggerFactory.getLogger(PropertiesConfig.class.getName());

    /**
     * @return
     */
    @Bean
    public static PropertyPlaceholderConfigurer properties() {
        final PropertyPlaceholderConfigurer propertyPlaceholderConfigurer = new PropertyPlaceholderConfigurer();
        final String configDir = System.getProperty("config.dir");

        LOGGER.info("*********** Config dir is {} ***********", configDir);

        if (StringUtils.isNotBlank(configDir)) {
            propertyPlaceholderConfigurer.setLocation(new FileSystemResource(String.format("%s%s%s", configDir,
                    File.separator, AdaConstants.DESKTOP_PROPERTIES_FILE_NAME)));
        } else {
            propertyPlaceholderConfigurer.setLocation(new ClassPathResource(AdaConstants.DESKTOP_PROPERTIES_FILE_NAME));
        }

        // Allow for other PropertyPlaceholderConfigurer instances.
        propertyPlaceholderConfigurer.setIgnoreUnresolvablePlaceholders(true);
        return propertyPlaceholderConfigurer;
    }

}
