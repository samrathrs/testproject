/**
 *
 */
package com.transerainc.adaws.util;

import java.io.File;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import com.transerainc.adaws.constants.AdaConstants;
import com.transerainc.adaws.constants.AppParams;

/**
 * @author suresh.kumar
 */
@Component
public class PropertiesUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(PropertiesUtil.class);

    private final Properties adaProperties = new Properties();

    @PostConstruct
    public void load() {
        loadProperties(adaProperties, AdaConstants.DESKTOP_PROPERTIES_FILE_NAME);
    }

    public void loadProperties(final Properties properties, final String fileName) {

        LOGGER.info("Loading properties from {}", fileName);
        properties.clear();

        final String configDir = System.getProperty(AdaConstants.CONFIG_DIR);

        Resource resource = null;
        InputStream stream = null;

        try {
            resource = StringUtils.isNotBlank(configDir) ? new FileSystemResource(String.format("%s%s%s", configDir,
                    File.separator, fileName)) : new ClassPathResource(fileName);
            stream = resource.getInputStream();
            if (stream != null) {
                properties.load(stream);
            } else {
                LOGGER.warn("{} stream is null, couldn't load properties ...", fileName);
            }
        } catch (final Exception e) {
            LOGGER.error("Exception in reading properties from {}", fileName, e);
        } finally {
            IOUtils.closeQuietly(stream);
        }
    }

    /**
     * @return the adxProperties
     */
    public Properties getAdaProperties() {
        return adaProperties;
    }

    public String getAdaProperty(final String key) {
        return StringUtils.trim(adaProperties.getProperty(key));
    }

    
    public HashMap<String, String> getPropertiesMap() {
        HashMap<String, String> propsMap = new HashMap<String, String>();
        Set<Object> keys = adaProperties.keySet();
        if(keys != null) {
            for (Object key : keys) {
                propsMap.put((String) key, adaProperties.getProperty((String) key));
                LOGGER.info(key + " = " + adaProperties.getProperty((String) key));
            }
        }
        
        return propsMap;
    }
    
    // Get all the attributes from ada-ws.properties and put it in this map. Return value from this map.
    public Map<String, String> getInitParams() {
        final Map<String, String> initParams = new HashMap<String, String>();
        initParams.put(AppParams.APS_URL_FOR_ADA, adaProperties.getProperty("apsUrl"));
        //initParams.put(AppParams.PASSWORD_CHANGE_URL, getPasswordChangeUrl());
        //initParams.put(AppParams.PASSWORD_RESET_URL, getPasswordResetUrl());
        initParams.put(AppParams.PARAM_HELP_URL, adaProperties.getProperty("helpUrl"));
        initParams.put(AppParams.SUPERVISOR_ALERT_URL, adaProperties.getProperty("supervisorAlertUrl"));
        initParams.put(AppParams.FREE_FORM_SUPERVISOR_ALERT_ENABLED, adaProperties.getProperty("freeFormSupervisorAlertEnabled"));
        initParams.put(AppParams.UPDATE_TITLE_WITH_STATUS, adaProperties.getProperty("updateTitleWithStatus"));
        initParams.put(AppParams.FAILOVER_ENABLED, adaProperties.getProperty("failoverEnabled"));
        initParams.put(AppParams.HEART_BEAT_RETRY_FREEQUENCY, adaProperties.getProperty("heart.beat.rate"));
        //initParams.put(AppParams.PASSWORD_EXPIRY_WARNING_LIMIT, adaProperties.getProperty("passwordExpirationWarningInDays"));
        initParams.put(AppParams.SEATMAP_URL, adaProperties.getProperty("seatmapUrl"));
        //initParams.put(AppParams.COOKIE_PERSISTENCE, adaProperties.getProperty("cookiePersistence"));
        initParams.put(AppParams.SFDC_NAMESPACE, adaProperties.getProperty("sfdc.namespace"));
        initParams.put(AppParams.AIMURL, adaProperties.getProperty("aimUrl"));
        //initParams.put(AppParams.COOKIEPREFIX, adaProperties.getProperty("cookiePrefix"));
        initParams.put(AppParams.APP_VERSION, getAppVersion());
        return initParams;
    }
    
    public JSONObject getInitParamsAsJson(final JSONObject jsonData) throws JSONException {
        jsonData.put(AppParams.APS_URL_FOR_ADA, adaProperties.getProperty("apsUrl"));
        //jsonData.put(AppParams.PASSWORD_CHANGE_URL, getPasswordChangeUrl());
        //jsonData.put(AppParams.PASSWORD_RESET_URL, getPasswordResetUrl());
        jsonData.put(AppParams.PARAM_HELP_URL, adaProperties.getProperty("helpUrl"));
        jsonData.put(AppParams.SUPERVISOR_ALERT_URL, adaProperties.getProperty("supervisorAlertUrl"));
        jsonData.put(AppParams.FREE_FORM_SUPERVISOR_ALERT_ENABLED, adaProperties.getProperty("freeFormSupervisorAlertEnabled"));
        jsonData.put(AppParams.UPDATE_TITLE_WITH_STATUS, adaProperties.getProperty("updateTitleWithStatus"));
        jsonData.put(AppParams.FAILOVER_ENABLED, adaProperties.getProperty("failoverEnabled"));
        jsonData.put(AppParams.HEART_BEAT_RETRY_FREEQUENCY, adaProperties.getProperty("heart.beat.rate"));
        //jsonData.put(AppParams.PASSWORD_EXPIRY_WARNING_LIMIT, adaProperties.getProperty("passwordExpirationWarningInDays"));
        jsonData.put(AppParams.SEATMAP_URL, adaProperties.getProperty("seatmapUrl"));
        //jsonData.put(AppParams.COOKIE_PERSISTENCE, adaProperties.getProperty("cookiePersistence"));
        jsonData.put(AppParams.SFDC_NAMESPACE, adaProperties.getProperty("sfdc.namespace"));
        jsonData.put(AppParams.AIMURL, adaProperties.getProperty("aimUrl"));
        //jsonData.put(AppParams.COOKIEPREFIX, adaProperties.getProperty("cookiePrefix"));
        jsonData.put(AppParams.APP_VERSION, getAppVersion());

        return jsonData;
    }
    
    /**
     * @return the version of ADA-WS
     */
    private String getAppVersion() {
    	return null != adaProperties.getProperty("app.version") ? adaProperties
                .getProperty("app.version") : "";
	}

	/**
     * @return the passwordChangeUrl
     */
    /*
    public String getPasswordChangeUrl() {
        return null != adaProperties.getProperty("passwordChangeUrl") ? adaProperties
                .getProperty("passwordChangeUrl") : "";
    }
     */
    /**
     * @param properties 
     * @return the passwordResetUrl
     */
    /*
    public String getPasswordResetUrl() {
    	return null != adaProperties.getProperty("passwordResetUrl") ? adaProperties
                .getProperty("passwordResetUrl") : "";
    }
   */
}
