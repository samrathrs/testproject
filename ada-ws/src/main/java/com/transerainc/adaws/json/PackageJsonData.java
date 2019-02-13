/**
 * 
 */
package com.transerainc.adaws.json;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.transerainc.adaws.config.DesktopConfigManager;
import com.transerainc.adaws.constants.AdaConstants;
import com.transerainc.adaws.constants.AgentProfileConstants;
import com.transerainc.adaws.constants.AppParams;
import com.transerainc.adaws.constants.ChannelStateConstant;
import com.transerainc.adaws.constants.ContextConstants;
import com.transerainc.adaws.util.ParsingUtils;
import com.transerainc.adaws.util.PropertiesUtil;
import com.transerainc.adaws.util.SpringContextHelper;
import com.transerainc.adaws.util.StringUtils;
import com.transerainc.adaws.util.XMLtoJsonConverter;
import com.transerainc.aha.gen.agent.AgentCommandDocument.AgentCommand;
import com.transerainc.aha.gen.agent.AgentDocument.Agent;
import com.transerainc.aha.gen.agent.AttributeDocument.Attribute;
import com.transerainc.aha.gen.agent.DesktopConfigurationDocument.DesktopConfiguration;

/**
 * @author varsha.shivaram
 */
@Component
public class PackageJsonData implements ContextConstants, AgentProfileConstants { 

    private static Logger LOGGER = LoggerFactory.getLogger(PackageJsonData.class.getName());

    @Autowired
    private DesktopConfigManager configMap;

    /**
     * @param desktopConf
     * @param agentSessionId
     * @return
     * @throws JSONException
     */
    public JSONObject getDesktopConfigurationJson(final DesktopConfiguration desktopConf, final String agentSessionId)
            throws JSONException {
        long startTime = 0;
        if (LOGGER.isDebugEnabled()) {
            startTime = System.currentTimeMillis();
            LOGGER.debug("{} ===>> Starting to get the converted desktop configuration JSON : {}", agentSessionId,
                    startTime);
        }

        final String teamIds = desktopConf.getTeamIds();
        final String teamNames = desktopConf.getTeamNames();
        ParsingUtils.createMap(teamIds, teamNames);
        final JSONObject obj = new JSONObject();
        JSONArray attributeArray = new JSONArray();
        obj.put(PROTOCOL_VERSION, desktopConf.getProtocolVersion());
        obj.put(PARAM_AGENT_ID, desktopConf.getAgentId());
        obj.put(PARAM_USER_REALNAME, desktopConf.getAgentName());
        obj.put(PARAM_SITE_ID, desktopConf.getSiteId());
        obj.put(PARAM_SITE_NAME, desktopConf.getSiteName());
        obj.put(PARAM_DEFAULT_DN, desktopConf.getDefaultDn());
        obj.put(PARAM_TEAM_IDS_CSV, teamIds);
        obj.put(PARAM_TEAM_NAMES_CSV, teamNames);

        attributeArray = XMLtoJsonConverter.convertMapToJsonArray(SpringContextHelper.getBean(PropertiesUtil.class)
                .getInitParams(), attributeArray);

        if (desktopConf.getAuxiliaryList() != null) {
            obj.put(PARAM_ENTERPRISE_ID, desktopConf.getAuxiliaryList().getEnterpriseId());
        }

        if (desktopConf.getAgentProfileXmlData() != null && !desktopConf.getAgentProfileXmlData().isEmpty()) {
            // @ TODO
            LOGGER.warn("{} Exception occured while proccessing desktop configuration xml", agentSessionId);
        }

        if (desktopConf.getAttributeArray() != null && desktopConf.getAttributeArray().length > 0) {
            processAttributes(attributeArray, desktopConf.getAttributeArray());
        }

        addWfoAttributes(attributeArray, desktopConf.getAttributeArray(), agentSessionId);
        addCampaignAttributes(attributeArray, desktopConf.getAttributeArray(), agentSessionId);
        addURAttributes(attributeArray, desktopConf.getAttributeArray(), agentSessionId);
        
        obj.put(AgentProfileConstants.ATTRIBUTE, attributeArray);

        if (LOGGER.isDebugEnabled()) {
            final long endTime = System.currentTimeMillis() - startTime;
            LOGGER.debug("{} ===>> Finished getting the converted desktop configuration JSON : {}", agentSessionId,
                    endTime);
        }

        return obj;
    }

    /**
     * @param agent
     * @param agentSessionId
     * @return
     */
    public JSONObject getAgentStateUpdateJson(final Agent agent, final String agentSessionId) {
        final JSONObject obj = new JSONObject();
        try {
            obj.put(PARAM_AGENT_ID, agent.getAgentId());
            obj.put(PARAM_ENTERPRISE_ID, agent.getEnterpriseId());
            obj.put(PARAM_SITE_ID, agent.getSiteId());
            obj.put(PARAM_TEAM_ID, agent.getTeamId());
            obj.put(POSITION_ID, agent.getPositionId());
            obj.put(PARAM_DEFAULT_DN, agent.getDn());
            obj.put(PARAM_STATE, agent.getStatus() != null ? agent.getStatus().toString() : "");
          //  if(agent.getCode() != 0){
            	  obj.put("system.aux.code",   agent.getCode());
           // }
          
          
            final com.transerainc.adaws.model.DesktopConfiguration conf = configMap.getConfigForAgent(agentSessionId);
            final String subState = agent.getSubStatus() != null ? agent.getSubStatus().toString() : "";
            switch (subState) {
            case ChannelStateConstant.CONNECTED_CONSULT_RESERVED:
                if (conf.isConferenceByThis()) {
                    obj.put(PARAM_SUB_STATE, ChannelStateConstant.CONSULT_RESERVED);
                } else {
                    obj.put(PARAM_SUB_STATE, ChannelStateConstant.CONNECTED_CONSULT_RESERVED);
                }
                break;
            case ChannelStateConstant.CONNECTED_CONSULTING:
                if (!conf.isConferenceByThis()) {
                    obj.put(PARAM_SUB_STATE, ChannelStateConstant.CONNECTED_CONSULTING);
                } else {
                    // obj.put(ContextConstants.PARAM_SUB_STATE, CallStateConstants.CONFERENCING);
                    obj.put(ContextConstants.PARAM_SUB_STATE, ChannelStateConstant.CONSULTING);
                }
                break;
            case ChannelStateConstant.AVAILABLE_CONSULTING:
                obj.put(PARAM_SUB_STATE, subState);
                break;
            case ChannelStateConstant.RESERVED:
                obj.put(PARAM_SUB_STATE, subState);
                // If the call is outbound and the substate is ringing then, set OutdialReserved
                if (!conf.isAgentavailable() && ChannelStateConstant.RESERVED.equals(subState)) {
                    obj.put(PARAM_SUB_STATE, ChannelStateConstant.OUTDIAL_RESERVED);
                }
                break;
            case ChannelStateConstant.NOT_RESPONDING:
                obj.put(AdaConstants.REASON, agent.getReason());
                obj.put(PARAM_SUB_STATE, subState);
                break;
            default:
                obj.put(PARAM_SUB_STATE, subState);
            }

            obj.put(AGENT_SESSION_ID, agent.getAgentsessionid());
            SpringContextHelper.getBean(PropertiesUtil.class).getInitParamsAsJson(obj);
        } catch (final JSONException e) {
            LOGGER.error(agentSessionId + " ===>> Exception occured while processing the xml: " + e.getMessage());
        }

        return obj;
    }

    /**
     * @param agent
     * @param agentSessionId
     * @return
     */
    public JSONObject getAgentStateUpdateJson(final AgentCommand agent, final String agentSessionId) {
        final JSONObject obj = new JSONObject();
        try {
            obj.put(PARAM_AGENT_ID, agent.getAgentId());
            obj.put(PARAM_ENTERPRISE_ID, agent.getEnterpriseId());
            obj.put(PARAM_SITE_ID, agent.getSiteId());
            obj.put(PARAM_TEAM_ID, agent.getTeamId());
            // obj.put(POSITION_ID, agent.getPositionId());
            // obj.put(PARAM_DEFAULT_DN, agent.getDn());
            // obj.put(PARAM_STATE, agent.getStatus().toString());

            // final com.transerainc.adaws.model.DesktopConfiguration conf =
            // configMap.getConfigForAgent(agentSessionId);
            final String subState = agent.getSubStatus() != null ? agent.getSubStatus().toString() : "";
            switch (subState) {
            case ChannelStateConstant.CONSULTING:
                obj.put(PARAM_SUB_STATE, ChannelStateConstant.CONSULTING);
                break;
            default:
                obj.put(PARAM_SUB_STATE, subState);
            }

            obj.put(AGENT_SESSION_ID, agent.getAgentsessionid());
            SpringContextHelper.getBean(PropertiesUtil.class).getInitParamsAsJson(obj);
        } catch (final JSONException e) {
            LOGGER.error(agentSessionId + " ===>> Exception occured while processing the xml: " + e.getMessage());
        }

        return obj;
    }

    /**
     * @param attributeArray
     * @param desktopConfAttributeArray
     * @throws JSONException
     */
    @SuppressWarnings("unchecked")
    private void processAttributes(final JSONArray attributeArray, final Attribute[] desktopConfAttributeArray)
            throws JSONException {
        for (final Attribute attribute : desktopConfAttributeArray) {
            final String key = attribute.getName();
            final String value = StringUtils.isEmpty(attribute.getValue()) ? "" : attribute.getValue();

            JSONObject attributeObj = new JSONObject();
            attributeObj.put(AgentProfileConstants.NODE_NAME, key);
            attributeObj.put(AgentProfileConstants.NODE_VALUE, value);
            attributeArray.add(attributeObj);

            if (AppParams.BASE_URL.equals(key)) {
                attributeObj = new JSONObject();
                attributeObj.put(AgentProfileConstants.NODE_NAME, PARAM_BASE_URL);
                attributeObj.put(AgentProfileConstants.NODE_VALUE, value);
                attributeArray.add(attributeObj);
            }
        }
    }
    
    /**
     * @param attributeArray
     * @param desktopConfAttributeArray
     * @param agentSessionId
     * @throws JSONException
     */
    @SuppressWarnings("unchecked")
    private void addWfoAttributes(
	    		final JSONArray attributeArray, 
	    		final Attribute[] desktopConfAttributeArray, 
	    		final String agentSessionId) throws JSONException {
    	
    		// Insert WFO appParams in attribute list of desktopConfig to FE UI
		JSONObject attributeObj = new JSONObject();
		attributeObj.put(AgentProfileConstants.NODE_NAME, AppParams.WFO_URL);
		attributeObj.put(AgentProfileConstants.NODE_VALUE, configMap.getConfigForAgent(agentSessionId).getWfoUrl());
		attributeArray.add(attributeObj);
	    
	    attributeObj = new JSONObject();
	    attributeObj.put(AgentProfileConstants.NODE_NAME, AppParams.WFO_ENABLED);
	    attributeObj.put(AgentProfileConstants.NODE_VALUE, configMap.getConfigForAgent(agentSessionId).isWfoEnabled());
	    attributeArray.add(attributeObj);
    }
    
    /**
     * @param attributeArray
     * @param desktopConfAttributeArray
     * @param agentSessionId
     * @throws JSONException
     */
    @SuppressWarnings("unchecked")
    private void addCampaignAttributes(
	    		final JSONArray attributeArray, 
	    		final Attribute[] desktopConfAttributeArray, 
	    		final String agentSessionId) throws JSONException {
    	
    		// Insert WFO appParams in attribute list of desktopConfig to FE UI
		JSONObject attributeObj = new JSONObject();
	    attributeObj.put(AgentProfileConstants.NODE_NAME, AppParams.CAMPAIGN_ENABLED);
	    attributeObj.put(AgentProfileConstants.NODE_VALUE, configMap.getConfigForAgent(agentSessionId).isCampaignEnabled());
	    attributeArray.add(attributeObj);
    }
    
	/**
	 * @param attributeArray
	 * @param desktopAttributeArray
	 * @param agentSessionId
	 * @throws JSONException
	 */
	@SuppressWarnings("unchecked")
	private void addURAttributes(final JSONArray attributeArray, final Attribute[] desktopAttributeArray,
			final String agentSessionId) throws JSONException {
		JSONObject attributeObj = new JSONObject();
		attributeObj.put(AgentProfileConstants.NODE_NAME, AppParams.UR_URL);
		attributeObj.put(AgentProfileConstants.NODE_VALUE, configMap.getConfigForAgent(agentSessionId).geturUrl());
		attributeArray.add(attributeObj);
	}

}
