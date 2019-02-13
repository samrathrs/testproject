/**
 * 
 */
package com.transerainc.ara.prov;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.transerainc.ara.pojo.AraConfiguration;
import com.transerainc.tam.config.ConfigAgentHelperForXMLBean;

/**
 * @author pgujjeti
 *
 */
public class ConfigProvider {
	private final Logger lgr = LoggerFactory
			.getLogger(ConfigProvider.class);
	
	private String configAgentUrl;
	
	private String configXpath;
	
	private String baseUrl;

	private AraConfiguration araConfig;
	
	public ConfigProvider(String configAgentUrl, String configXpath) {
		this.configAgentUrl = configAgentUrl;
		this.configXpath = configXpath;
	}
	
	@PostConstruct
	public void init() throws Exception {
		// Get the configuration
		lgr.info("Initializing the component configuration");
		// Fetch and parse the config file xml
		String serverConfig = ConfigAgentHelperForXMLBean.sendQuery(
				configAgentUrl, configXpath, 16);
		lgr.info("ARA Configuration\n:{}", serverConfig);
		ObjectMapper om = new ObjectMapper();
		araConfig = om.readValue(serverConfig, AraConfiguration.class);
	}

	public String getConfigAgentUrl() {
		return configAgentUrl;
	}

	public void setConfigAgentUrl(String configAgentUrl) {
		this.configAgentUrl = configAgentUrl;
	}

	public String getConfigXpath() {
		return configXpath;
	}

	public void setConfigXpath(String configXpath) {
		this.configXpath = configXpath;
	}

	public AraConfiguration getAraConfig() {
		return araConfig;
	}

	public void setAraConfig(AraConfiguration araConfig) {
		this.araConfig = araConfig;
	}

	public String getBaseUrl() {
		return baseUrl;
	}

	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}
}
