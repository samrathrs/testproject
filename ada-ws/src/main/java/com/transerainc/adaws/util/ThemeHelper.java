package com.transerainc.adaws.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Properties;

import javax.servlet.jsp.tagext.BodyTagSupport;

import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.transerainc.adaws.constants.AdaConstants;

public class ThemeHelper extends BodyTagSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final Logger LOGGER = LoggerFactory
			.getLogger(ThemeHelper.class);

	private static final String CUSTOMIZATION = "custom-branding";
	private static final String CUSTOMIZATION_EXT = "Branding";
	private static final String CSS = "css";

	private String tenantName;
	private String appContext;
	private final String cssFileName;
	private final String defaultFileName;
	private final String defaultTheme;
	private String cdnUrl = "";
	private static final String CDN_RESOURCES_BASE = "portal/resources";
	private static final String CUSTOM_THEME_CCS = "custom-theme.css";
	private static final String ADA_CUSTOM_THEME_CCS = "custom-agent-theme.css";

	public ThemeHelper() {
		tenantName = null;
		appContext = "ada-ws";
		defaultFileName = BooleanUtils.toBoolean(System.getProperties()
				.getProperty("bcc.data.center")) ? "custom-bcc.css"
				: "custom.css";
		cssFileName = BooleanUtils.toBoolean(System.getProperties()
				.getProperty("bcc.data.center")) ? "custom-bcc.css"
				: "custom.css";
		defaultTheme = String
				.format("<link href=\"/ada-ws/css/%s\" rel=\"stylesheet\" type=\"text/css\"\\>",
						defaultFileName);
	}

	public String getCustomCssUrl(String tenantName) {
		// JspWriter out = null;
		String customCssUrl = "";
		try {
			LOGGER.debug("In dostart tag function");
			// out = pageContxt.getOut();

			// if customerName is not set then return default path
			if (StringUtils.isBlank(tenantName)) {
				customCssUrl = defaultTheme;
				return customCssUrl;
			}

			final File propertiesFile = new File("./config/ada-ws.properties");
			FileInputStream fileStream;
			Properties props;

			props = System.getProperties();
			if (tenantName.contains("sas_cust_0")
					|| tenantName.contains("sas_can"))
				tenantName = "Sungard";
			else if (tenantName.contains("OfficeDepot"))
				tenantName = "OfficeDepot";
			final String cssPath = String.format("%s%s%s%s%s",
					props.getProperty("resourcePath"), File.separator,
					CUSTOMIZATION, File.separator, tenantName, CSS,
					File.separator, cssFileName);

			fileStream = new FileInputStream(propertiesFile);
			final Properties properties = new Properties();
			properties.load(fileStream);
			final String customPath = properties
					.getProperty(AdaConstants.CUSTOM_PATH);
			cdnUrl = properties.getProperty("cdnUrl");
			LOGGER.info("CDN URL is:  {}", cdnUrl);
			// FIXME COV - 11952
			final String customDir = String.format("%s%s%s%s%s%s%s%s", customPath,
					File.separator, CUSTOMIZATION_EXT, File.separator,
					tenantName, CSS, File.separator, cssFileName);
			boolean intdirExists = false;
			boolean extdirExists = false;

			final long t1 = System.currentTimeMillis();
			intdirExists = new File(cssPath).exists();
			extdirExists = new File(customDir).exists();
			final long t2 = System.currentTimeMillis();

			LOGGER.trace(
					"Time took for checking css file {} existence is {} ms",
					cssPath, t2 - t1);
			LOGGER.trace("CSS file {} is {} exists for customer {}", cssPath,
					intdirExists, extdirExists, tenantName);
			final String customThemeUrl = String.format("%s/%s/%s/css/%s",
					cdnUrl, CDN_RESOURCES_BASE, tenantName, CUSTOM_THEME_CCS);
			if (themeExists(customThemeUrl)) {
				if (extdirExists) {
					customCssUrl = String
							.format("<link href=\"/%s/%s/%s/css/%s\" rel=\"stylesheet\" type=\"text/css\">",
									appContext, CUSTOMIZATION_EXT, tenantName,
									cssFileName)
							+ "\r\n"
							+ "<link rel=\"stylesheet\" href=\""
							+ customThemeUrl + "\"/>";
				} else if (intdirExists) {
					customCssUrl = String
							.format("<link href=\"/%s/%s/%s/css/%s\" rel=\"stylesheet\" type=\"text/css\">",
									appContext, CUSTOMIZATION, tenantName,
									cssFileName)
							+ "\r\n"
							+ "<link rel=\"stylesheet\" href=\""
							+ customThemeUrl + "\"/>";
				} else {
					customCssUrl = "<link rel=\"stylesheet\" href=\""
							+ customThemeUrl + "\"/>";
				}
			} else {
				if (extdirExists) {
					customCssUrl = String
							.format("<link href=\"/%s/%s/%s/css/%s\" rel=\"stylesheet\" type=\"text/css\">",
									appContext, CUSTOMIZATION_EXT, tenantName,
									cssFileName);
				} else if (intdirExists) {
					customCssUrl = String
							.format("<link href=\"/%s/%s/%s/css/%s\" rel=\"stylesheet\" type=\"text/css\">",
									appContext, CUSTOMIZATION, tenantName,
									cssFileName);
				} else {
					customCssUrl = defaultTheme;
				}
			}
		} catch (IOException e) {
			LOGGER.warn("Unable to fetch the customer specific css. ", e);
		}
		return customCssUrl;
	}
	public String getAdaCustomCssUrl(String tenantName) {
		// JspWriter out = null;
		String customCssUrl = "";
		try {
			LOGGER.debug("In dostart tag function");
			// out = pageContxt.getOut();

			// if customerName is not set then return default path
			if (StringUtils.isBlank(tenantName)) {
				customCssUrl = defaultTheme;
				return customCssUrl;
			}

			final File propertiesFile = new File("./config/ada-ws.properties");
			FileInputStream fileStream;
			Properties props;

			props = System.getProperties();
			if (tenantName.contains("sas_cust_0")
					|| tenantName.contains("sas_can"))
				tenantName = "Sungard";
			else if (tenantName.contains("OfficeDepot"))
				tenantName = "OfficeDepot";
			final String cssPath = String.format("%s%s%s%s%s",
					props.getProperty("resourcePath"), File.separator,
					CUSTOMIZATION, File.separator, tenantName, CSS,
					File.separator, cssFileName);

			fileStream = new FileInputStream(propertiesFile);
			final Properties properties = new Properties();
			properties.load(fileStream);
			final String customPath = properties
					.getProperty(AdaConstants.CUSTOM_PATH);
			cdnUrl = properties.getProperty("cdnUrl");
			LOGGER.info("CDN URL is:  {}", cdnUrl);
			// FIXME COV - 11952
			final String customDir = String.format("%s%s%s%s%s%s%s%s", customPath,
					File.separator, CUSTOMIZATION_EXT, File.separator,
					tenantName, CSS, File.separator, cssFileName);
			boolean intdirExists = false;
			boolean extdirExists = false;

			final long t1 = System.currentTimeMillis();
			intdirExists = new File(cssPath).exists();
			extdirExists = new File(customDir).exists();
			final long t2 = System.currentTimeMillis();

			LOGGER.trace(
					"Time took for checking css file {} existence is {} ms",
					cssPath, t2 - t1);
			LOGGER.trace("CSS file {} is {} exists for customer {}", cssPath,
					intdirExists, extdirExists, tenantName);
			final String customThemeUrl = String.format("%s/%s/%s/css/%s",
					cdnUrl, CDN_RESOURCES_BASE, tenantName, ADA_CUSTOM_THEME_CCS);
			if (themeExists(customThemeUrl)) {
				if (extdirExists) {
					customCssUrl = String
							.format("<link href=\"/%s/%s/%s/css/%s\" rel=\"stylesheet\" type=\"text/css\">",
									appContext, CUSTOMIZATION_EXT, tenantName,
									cssFileName)
							+ "\r\n"
							+ "<link rel=\"stylesheet\" href=\""
							+ customThemeUrl + "\"/>";
				} else if (intdirExists) {
					customCssUrl = String
							.format("<link href=\"/%s/%s/%s/css/%s\" rel=\"stylesheet\" type=\"text/css\">",
									appContext, CUSTOMIZATION, tenantName,
									cssFileName)
							+ "\r\n"
							+ "<link rel=\"stylesheet\" href=\""
							+ customThemeUrl + "\"/>";
				} else {
					customCssUrl = "<link rel=\"stylesheet\" href=\""
							+ customThemeUrl + "\"/>";
				}
			} else {
				if (extdirExists) {
					customCssUrl = String
							.format("<link href=\"/%s/%s/%s/css/%s\" rel=\"stylesheet\" type=\"text/css\">",
									appContext, CUSTOMIZATION_EXT, tenantName,
									cssFileName);
				} else if (intdirExists) {
					customCssUrl = String
							.format("<link href=\"/%s/%s/%s/css/%s\" rel=\"stylesheet\" type=\"text/css\">",
									appContext, CUSTOMIZATION, tenantName,
									cssFileName);
				} else {
					customCssUrl = defaultTheme;
				}
			}
		} catch (IOException e) {
			LOGGER.warn("Unable to fetch the customer specific css. ", e);
		}
		return customCssUrl;
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

	private boolean themeExists(final String customThemeUrl) {
		boolean hasTheme = false;
		HttpURLConnection conn = null;
		try {
			final URL url = new URL(customThemeUrl);
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("HEAD");
			conn.connect();
			hasTheme = conn.getResponseCode() == 200;
		} catch (final Exception e) {
			LOGGER.warn("Unable to fetch tenant specific theme css", e);
		} finally {
			if (conn != null) {
				conn.disconnect();
			}
		}
		return hasTheme;
	}

}
