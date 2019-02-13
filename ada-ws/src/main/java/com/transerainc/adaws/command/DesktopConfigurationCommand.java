package com.transerainc.adaws.command;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.transerainc.adaws.config.DesktopConfigManager;
import com.transerainc.adaws.constants.AdaConstants;
import com.transerainc.adaws.constants.AppParams;
import com.transerainc.adaws.constants.CommandConstants;
import com.transerainc.adaws.constants.ContextConstants;
import com.transerainc.adaws.exception.InterpretationException;
import com.transerainc.adaws.json.PackageJsonData;
import com.transerainc.adaws.model.AdaResponse;
import com.transerainc.adaws.model.DesktopConfiguration;
import com.transerainc.adaws.model.TacgResponse;
import com.transerainc.adaws.service.AnalyzerServiceWrapper;
import com.transerainc.adaws.util.ParsingUtils;
import com.transerainc.adaws.util.PropertiesUtil;
import com.transerainc.adaws.util.StringUtils;
import com.transerainc.aha.gen.agent.AttributeDocument.Attribute;
import com.transerainc.tam.config.ConfigAgentHelperForXMLBean;
import com.transerainc.tam.config.ServerMapping;

/**
 * @author rajeev.lochanam
 */
@Component
public class DesktopConfigurationCommand implements ContextConstants {

	private static final Logger LOGGER = LoggerFactory.getLogger(DesktopConfigurationCommand.class.getName());

	private static final String CONFIG_AGENT_URL_PROPERTY_KEY = "config.agent.url";

	private static final String COMPONENT_TYPE_QUERY_FROM_SERVER_MAPPING_STRING_FORMAT_TEMPLATE = 
			"/server-mapping[@enterpriseId='%s' and @componentType='%s']";

	private static final String SERVER_KEY = "server";

	private static final String COMPONENT_TYPE_KEY = "componentType";

	@Autowired
	private DesktopConfigManager configMap;

	@Autowired
	private PackageJsonData packageJsonData;
	
	@Autowired
	private PropertiesUtil propertiesUtil;
	
	@Autowired
	private AnalyzerServiceWrapper analyzerUtil;

	/**
	 * @param tacgResp
	 * @return
	 * @throws InterpretationException
	 * @throws JSONException
	 */
	public AdaResponse processData(final TacgResponse tacgResp) throws InterpretationException, JSONException {
		final String agentSessionId = tacgResp.getAgentSessionId();

		long startTime = 0;
		if (LOGGER.isDebugEnabled()) {
			startTime = System.currentTimeMillis();
			LOGGER.debug(agentSessionId + " ===>> Starting create agent list command : " + startTime);
		}

		final com.transerainc.aha.gen.agent.DesktopConfigurationDocument.DesktopConfiguration desktopConf = tacgResp
				.getAgentList().getDesktopConfiguration();

		final DesktopConfiguration config = new DesktopConfiguration();

		packAgentInfo(tacgResp, config);

		config.setProtocolVersion(desktopConf.getProtocolVersion());
		config.setDefaultDn(desktopConf.getDefaultDn());

		if (desktopConf.getAuxiliaryList() != null) {
			config.setEnterpriseId(desktopConf.getAuxiliaryList().getEnterpriseId());
		}
		
		populateServerMapping(agentSessionId, config.getEnterpriseId());

		if (desktopConf.getAgentProfileXmlData() != null && !desktopConf.getAgentProfileXmlData().isEmpty()) {
			LOGGER.warn(agentSessionId + "Exception occured while converting agentProfileXmlData");
		}

		if (desktopConf.getAttributeArray() != null && desktopConf.getAttributeArray().length > 0) {
			processAppParam(desktopConf.getAttributeArray(), agentSessionId, config);
		}

		if (LOGGER.isDebugEnabled()) {
			final long endTime = System.currentTimeMillis() - startTime;
			LOGGER.debug(agentSessionId + " ===>> Finished processing element : " + endTime);
		}

		config.postInit();

		configMap.getConfigForAgent(agentSessionId).merge(config);

		final JSONObject jsonResponse = asJsonResponse(desktopConf, agentSessionId);

		if (LOGGER.isDebugEnabled()) {
			final long endTime = System.currentTimeMillis() - startTime;
			LOGGER.debug(agentSessionId + " ===>> Finished create agent list command : " + endTime);
		}

		return new AdaResponse(CommandConstants.AGENT_PROPERTY_CHANGED, jsonResponse.toString(), agentSessionId);
	}

	/**
	 * @param tacgResp
	 * @param config
	 */
	private void packAgentInfo(final TacgResponse tacgResp, final DesktopConfiguration config) {
		final com.transerainc.aha.gen.agent.DesktopConfigurationDocument.DesktopConfiguration desktopConf = tacgResp
				.getAgentList().getDesktopConfiguration();
		if (desktopConf != null) {
			config.setAgentId(desktopConf.getAgentId());
			config.setAgentName(desktopConf.getAgentName());
			config.setSiteId(String.valueOf(desktopConf.getSiteId()));
			config.setSiteName(desktopConf.getSiteName());

			final String teamIds = desktopConf.getTeamIds();
			final String teamNames = desktopConf.getTeamNames();
			final Map<String, String> teamMap = ParsingUtils.createMap(teamIds, teamNames);

			config.setTeamIdsCSV(teamIds);
			config.setTeamNamesCSV(teamNames);
			config.setAccessibleTeamMap(teamMap);
		}
	}

	/**
	 * @param desktopConf
	 * @param agentSessionId
	 * @return
	 * @throws InterpretationException
	 * @throws JSONException
	 */
	private JSONObject asJsonResponse(
			final com.transerainc.aha.gen.agent.DesktopConfigurationDocument.DesktopConfiguration desktopConf,
			final String agentSessionId) throws InterpretationException {
		final DesktopConfiguration conf = configMap.getConfigForAgent(agentSessionId);
		JSONObject jsonResponse = null;
		try {
			jsonResponse = packageJsonData.getDesktopConfigurationJson(desktopConf, agentSessionId);
			jsonResponse.put(CommandConstants.STD_STATUS, conf.getStatus());
			jsonResponse.put(CommandConstants.STD_SUB_STATUS, conf.getSubStatus());
		} catch (final JSONException e) {
			LOGGER.warn(agentSessionId + " ===>> Cannot interpret desktop configuration xml: " + desktopConf.xmlText(),
					e);
			throw new InterpretationException("Cannot interpret desktop configutaion xml: " + desktopConf.xmlText(), e);
		}
		LOGGER.info(agentSessionId + " ===>> Desktop configuration updated: " + jsonResponse.toString());
		return jsonResponse;
	}

	/**
	 * @param attributeArray
	 * @param agentSessionId
	 * @param config
	 */
	private void processAppParam(final Attribute[] attributeArray, final String agentSessionId,
			final DesktopConfiguration config) {
		long startTime = 0;
		if (LOGGER.isDebugEnabled()) {
			startTime = System.currentTimeMillis();
			LOGGER.debug(agentSessionId + " ===>> Starting processing params : " + startTime);
		}

		for (final Attribute attribute : attributeArray) {
			final String key = attribute.getName();
			final String value = StringUtils.isEmpty(attribute.getValue()) ? "" : attribute.getValue();
			if (LOGGER.isInfoEnabled()) {
				LOGGER.info(agentSessionId + " ===>> Adding application param: " + key + " = " + value);
			}
			config.addAppParam(key, value);

			if (AppParams.BASE_URL.equals(key)) {
				if (LOGGER.isInfoEnabled()) {
					LOGGER.info("Adding baseUrl: " + value);
				}
				config.setBaseUrl(value);
			}
		}
		
		if (LOGGER.isInfoEnabled()) {
			LOGGER.info(agentSessionId + " ===>> Adding application param: " + AppParams.WFO_URL + " = " + configMap.getConfigForAgent(agentSessionId).getWfoUrl());
			LOGGER.info(agentSessionId + " ===>> Adding application param: " + AppParams.WFO_ENABLED + " = " + configMap.getConfigForAgent(agentSessionId).isWfoEnabled());
			LOGGER.info(agentSessionId + " ===>> Adding application param: " + AppParams.CAMPAIGN_ENABLED + " = " + configMap.getConfigForAgent(agentSessionId).isCampaignEnabled());
		}

			config.addAppParam(AppParams.WFO_URL, configMap.getConfigForAgent(agentSessionId).getWfoUrl());
			config.addAppParam(AppParams.WFO_ENABLED, configMap.getConfigForAgent(agentSessionId).isWfoEnabled());
			config.addAppParam(AppParams.CAMPAIGN_ENABLED, configMap.getConfigForAgent(agentSessionId).isCampaignEnabled());

		if (LOGGER.isDebugEnabled()) {
			final long endTime = System.currentTimeMillis() - startTime;
			LOGGER.debug(agentSessionId + " ===>> Finished processing params : " + endTime);
		}
	}
	
	/**
	 * @param agentSessionId
	 */
	public void populateServerMapping(final String agentSessionId, final String enterpriseId) {
		final DesktopConfiguration desktopConfig = configMap.getConfigForAgent(agentSessionId);
		if (desktopConfig == null) {
			return;
		}

		final String configAgentUrl = propertiesUtil.getAdaProperty(CONFIG_AGENT_URL_PROPERTY_KEY);

		LOGGER.info("{} :===> (BE) agentSessionId extracting and populating Server Mapping information", agentSessionId);
		
		final JSONObject tenantCustomerDataJson = analyzerUtil.getTenantCustomerData(enterpriseId);
		LOGGER.info("tenantCustomerDataJson: {}", tenantCustomerDataJson);
		try {
			JSONArray tenantCustomerDataList = (JSONArray) tenantCustomerDataJson.get("auxiliaryDataList");
			JSONObject tenantCustomerAttributes = (JSONObject) tenantCustomerDataList.getJSONObject(0).get("attributes");
			LOGGER.info("tenantCustomerAttributes: {}", tenantCustomerAttributes);
			desktopConfig.setWfoEnabled(tenantCustomerAttributes.get("wfoEnabled__i").equals(1) ? "true": "false");
			desktopConfig.setCampaignEnabled(tenantCustomerAttributes.get("campaignManagerEnabled__i").equals(1) ? "true": "false");
		}catch (Exception e) {
			desktopConfig.setWfoEnabled("false");
			desktopConfig.setCampaignEnabled("false");
			LOGGER.error("Exception while parsing the tenant customer data {}",
					tenantCustomerDataJson, e);
		}
		
		try {
			// WFO
			if(desktopConfig.isWfoEnabled().equals("true")) {
				final List<ServerMapping> wfoServerMappingList =
						ConfigAgentHelperForXMLBean.getServerMappings(configAgentUrl,
								"/server-mapping[@enterpriseId='"+ enterpriseId + "' and @componentType='WFO']");

				if ((wfoServerMappingList != null) && (wfoServerMappingList.size() > 0)) {
					final ServerMapping sm = wfoServerMappingList.get(0);
					StringBuilder builder = new StringBuilder();
					builder.append(sm.getPortType() == 0 ? AdaConstants.PROTOCOL : AdaConstants.SECURE_PROTOCOL);
					builder.append(sm.getHost());
					builder.append(':');
					builder.append(sm.getPort());
					builder.append('/');

					// Retrieve URI and append to protocol, host, and port number
					HashMap<String, String> serverMappingParams = sm.getServerMappingParams();
					if ((serverMappingParams != null) && (!serverMappingParams.isEmpty())) {
						String uri = serverMappingParams.get(URI);
						if (org.apache.commons.lang3.StringUtils.isNotBlank(uri)) {
							builder.append(uri);
						}
					}

					desktopConfig.setWfoUrl(builder.toString());
					LOGGER.debug("WorkFlow Optimization URL: {}, isWfoEnabled: {}, for enterpriseId: {}, agentSessionId: {}, agent Id: {}, agent name: {}",
							desktopConfig.getWfoUrl(),
							desktopConfig.isWfoEnabled(),
							enterpriseId, 
							agentSessionId,
							desktopConfig.getAgentId(),
							desktopConfig.getAgentName());
				}
			}
			// Campaign Manager
			if(desktopConfig.isCampaignEnabled().equals("true")) {
				final List<ServerMapping> campaignManagerServerMappingList =
						ConfigAgentHelperForXMLBean.getServerMappings(configAgentUrl,
								"/server-mapping[@enterpriseId='"+ enterpriseId + "' and @componentType='campaign-manager']");

				if ((campaignManagerServerMappingList != null) && (campaignManagerServerMappingList.size() > 0)) {
					final ServerMapping sm = campaignManagerServerMappingList.get(0);
					StringBuilder builder = new StringBuilder();
					builder.append(sm.getPortType() == 0 ? AdaConstants.PROTOCOL : AdaConstants.SECURE_PROTOCOL);
					builder.append(sm.getHost());
					builder.append(':');
					builder.append(sm.getPort());
					builder.append('/');
				
					// Retrieve URI and append to protocol, host, and port number
					HashMap<String, String> serverMappingParams = sm.getServerMappingParams();
					if ((serverMappingParams != null) && (!serverMappingParams.isEmpty())) {
						String apiUri = serverMappingParams.get(CAMPAIGN_MANAGER_APIURI);
						if (org.apache.commons.lang3.StringUtils.isNotBlank(apiUri)) {
							builder.append(apiUri);
						}
					}
					
					desktopConfig.setCampaignManagerUrl(builder.toString());
					
					LOGGER.debug("Campaign Manager URL: {}, Campaign enabled: {}, for enterpriseId: {}, agentSessionId: {}, agent Id: {}, agent name: {}",
							desktopConfig.getCampaignManagerUrl(),
							desktopConfig.isCampaignEnabled(),
							enterpriseId, 
							agentSessionId,
							desktopConfig.getAgentId(),
							desktopConfig.getAgentName());
				}
			}
		} catch (Exception e) {
			LOGGER.error("Error while retrieving server mapping information for agent session id: {}, and enterprise id: {}",
					agentSessionId, enterpriseId);
		}
		LOGGER.info("{} :===> (BE) agentSessionId populated WFO URL from Server Mapping: {}", agentSessionId, desktopConfig.getWfoUrl());
		LOGGER.info("{} :===> (BE) agentSessionId populated LCM (Campaign Manager) from Server Mapping: {}", agentSessionId, desktopConfig.getCampaignManagerUrl());
	}


	public String retrieveComponentInformation(final String agentSessionId, final String componentType) {
		LOGGER.info(
				"Retrieving component information for agentSessionId: {}, and componentType: {}", 
				agentSessionId, 
				componentType
				);

		final DesktopConfiguration desktopConfig = configMap.getConfigForAgent(agentSessionId);

		if (desktopConfig == null) {
			return null;
		}

		final String enterpriseId = desktopConfig.getEnterpriseId();
		final String configAgentUrl = propertiesUtil.getAdaProperty(CONFIG_AGENT_URL_PROPERTY_KEY);

		String componentInformation = null;

		try {
			
			StringBuilder xpath = new StringBuilder();
			xpath.append(String.format(COMPONENT_TYPE_QUERY_FROM_SERVER_MAPPING_STRING_FORMAT_TEMPLATE, 
					enterpriseId,
					componentType));
			
			final List<ServerMapping> componentServerMappingList =
					ConfigAgentHelperForXMLBean.getServerMappings(configAgentUrl, xpath.toString());

			if ((componentServerMappingList != null) && (componentServerMappingList.size() > 0)) {
				final ServerMapping sm = componentServerMappingList.get(0);
				componentInformation = constructComponentInformation(sm, componentType);
				
			}
		} catch (Exception e) {
			LOGGER.error(
							"Error while retrieving server mapping information for agent session id: {}, and enterprise id: {}",
							agentSessionId, 
							enterpriseId
						);
		}
		LOGGER.info(
						"agentSessionId: {} ===> Retrieving component information: {}", 
						agentSessionId, 
						componentInformation
					);

		return componentInformation;
	}

	private String constructComponentInformation(final ServerMapping sm, final String componentType) {
		final JSONObject compInfoJson = new JSONObject();

		// "server" JSON element
		StringBuilder builder = new StringBuilder();
		builder.append(sm.getPortType() == 0 ? AdaConstants.PROTOCOL : AdaConstants.SECURE_PROTOCOL);
		builder.append(sm.getHost());
		builder.append(':');
		builder.append(sm.getPort());
		builder.append('/');
		compInfoJson.put(SERVER_KEY, builder.toString());

		// "componentType" JSON element
		compInfoJson.put(COMPONENT_TYPE_KEY, componentType);

		// Additional information
		HashMap<String, String> serverMappingParams = sm.getServerMappingParams();
		if ((serverMappingParams != null) && (!serverMappingParams.isEmpty())) {
			for (Map.Entry<String, String> paramEntry : serverMappingParams.entrySet()) {
				if (org.apache.commons.lang3.StringUtils.isNotBlank(paramEntry.getKey())) {
					compInfoJson.put(paramEntry.getKey(), paramEntry.getValue());
				}
			}
		}

		return compInfoJson.toString();
	}

}
