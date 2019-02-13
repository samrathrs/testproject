package com.transerainc.adaws.taglibs;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.transerainc.adaws.constants.AdaConstants;

public class LookAndFeelCustomization extends TagSupport {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private static final Logger LOGGER = LoggerFactory.getLogger(LookAndFeelCustomization.class);

    private static final String CUSTOMIZATION = "custom-branding";
    private static final String CUSTOMIZATION_EXT = "Branding";
    private static final String CSS = "css";

    private String tenantName;
    private String appContext;
    private final String cssFileName;
    private final String defaultFileName;
    private final String defaultTheme;

    public LookAndFeelCustomization() {
        tenantName = null;
        appContext = "ada-ws";
        defaultFileName = BooleanUtils.toBoolean(System.getProperties().getProperty("bcc.data.center"))
                ? "custom-bcc.css" : "custom.css";
        cssFileName = BooleanUtils.toBoolean(System.getProperties().getProperty("bcc.data.center"))
                ? "custom-bcc.css" : "custom.css";
        defaultTheme = String.format("<link href=\"/ada-ws/css/%s\" rel=\"stylesheet\" type=\"text/css\"\\>",
                defaultFileName);
    }

    @Override
    public int doStartTag() {

        final String defaultLink = String.format("<link href=\"/%s/css/%s\" rel=\"stylesheet\" type=\"text/css\">",
                appContext, cssFileName);

        JspWriter out = null;
        try {
            LOGGER.debug("In dostart tag function");
            out = pageContext.getOut();

            // if customerName is not set then return default path
            if (StringUtils.isBlank(tenantName)) {
                out.println(defaultTheme);

                return 0;
            }
            final File propertiesFile = new File("./config/ada-ws.properties");
            FileInputStream fileStream;
            Properties props;
            props = System.getProperties();
            if (tenantName.contains("sas_cust_0") || tenantName.contains("sas_can")) tenantName = "Sungard";
            else if (tenantName.contains("OfficeDepot")) tenantName = "OfficeDepot";
            // FIXED COV 10201 
            final String cssPath = String.format("%s%s%s%s%s%s%s%s", props.getProperty("resourcePath"), File.separator,
                    CUSTOMIZATION, File.separator, tenantName, CSS, File.separator, cssFileName);
            
            fileStream = new FileInputStream(propertiesFile);
            final Properties properties = new Properties();
            properties.load(fileStream);
            final String customPath = properties.getProperty(AdaConstants.CUSTOM_PATH);
            
            // FIXED COV 10201 
            final String customDir=String.format("%s%s%s%s%s%s%s%s", customPath, File.separator,
            		CUSTOMIZATION_EXT, File.separator, tenantName, CSS, File.separator, cssFileName);
            boolean intdirExists = false;
            boolean extdirExists = false;

            final long t1 = System.currentTimeMillis();
            intdirExists = new File(cssPath).exists() ;
            extdirExists =  new File(customDir).exists();
            final long t2 = System.currentTimeMillis();

            LOGGER.trace("Time took for checking css file {} existence is {} ms", cssPath, t2 - t1);
            LOGGER.trace("CSS file {} is {} exists for customer {}", cssPath, intdirExists , extdirExists, tenantName);

            if (extdirExists) {

                out.println(String.format("<link href=\"/%s/%s/%s/css/%s\" rel=\"stylesheet\" type=\"text/css\">",
                		appContext, CUSTOMIZATION_EXT, tenantName, cssFileName));
            } else if(intdirExists){
            	out.println(String.format("<link href=\"/%s/%s/%s/css/%s\" rel=\"stylesheet\" type=\"text/css\">",
                        appContext, CUSTOMIZATION, tenantName, cssFileName));
            }else{
            	out.println(defaultTheme);
            }
        } catch (IOException e) {
            LOGGER.warn("Unable to fetch the customer specific css. ", e);
            try {
                if (null != out) {
                    out.println(defaultLink);
                }
            } catch (final Exception oex) {
                LOGGER.warn("Unable to get the default css . ", oex);
            }

        }
        return 0;
    }

    /**
     * @return the tenantName
     */
    public String getTenantName() {
        return tenantName;
    }

    /**
     * @param tenantName
     *            the tenantName to set
     */
    public void setTenantName(final String tenantName) {
        this.tenantName = tenantName;
    }

    /**
     * @return the appContext
     */
    public String getAppContext() {
        return appContext;
    }

    /**
     * @param appContext
     *            the appContext to set
     */
    public void setAppContext(final String appContext) {
        this.appContext = appContext;
    }

}
