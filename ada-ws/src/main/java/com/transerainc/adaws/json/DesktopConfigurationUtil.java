package com.transerainc.adaws.json;

import java.util.Map;
import java.util.SortedMap;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.transerainc.adaws.constants.AdaConstants;
import com.transerainc.adaws.constants.AgentProfileConstants;
import com.transerainc.adaws.constants.AppParams;
import com.transerainc.adaws.constants.ContextConstants;
import com.transerainc.adaws.model.DesktopConfiguration;
import com.transerainc.adaws.model.CallAssociatedData.Data;
import com.transerainc.adaws.util.PropertiesUtil;
import com.transerainc.adaws.util.SpringContextHelper;
import com.transerainc.adaws.util.StringUtils;
import com.transerainc.adaws.util.XMLtoJsonConverter;

public class DesktopConfigurationUtil implements ContextConstants, AgentProfileConstants {

    private static Logger LOGGER = LoggerFactory.getLogger(DesktopConfigurationUtil.class);

    public static JSONObject toJson(final DesktopConfiguration desktopConfig) {
        final JSONObject obj = new JSONObject();
        try {
			obj.put(PROTOCOL_VERSION, desktopConfig.getVersion());
	        obj.put(PARAM_AGENT_ID, desktopConfig.getAgentId());
	        obj.put(PARAM_USER_REALNAME, desktopConfig.getAgentName());
	        obj.put(PARAM_SITE_ID, desktopConfig.getSiteId());
	        obj.put(PARAM_SITE_NAME, desktopConfig.getAgentProfileProperty(PARAM_SITE_NAME));
	        obj.put(PARAM_DEFAULT_DN, desktopConfig.getDefaultDn());
	        obj.put(PARAM_TEAM_IDS_CSV, desktopConfig.getTeamIdsCSV());
	        obj.put(PARAM_TEAM_NAMES_CSV, desktopConfig.getTeamNamesCSV());
	        obj.put(PARAM_SUB_STATE, desktopConfig.getSubStatus());
	        obj.put(PARAM_USER_REALNAME, desktopConfig.getAgentName());
	        obj.put(PARAM_ENTERPRISE_ID, desktopConfig.getEnterpriseId());
	        obj.put(PARAM_STATE, desktopConfig.getStatus());
	        obj.put(AGENT_SESSION_ID, desktopConfig.getAgentSessionId());
	        obj.put(IS_OUTDIAL_CALL, desktopConfig.isOutdialCallCheck());
	        
	        if (desktopConfig.getLastIdleAuxCode() != null) {
		        obj.put(PARAM_LAST_IDLE_CODE, desktopConfig.getLastIdleAuxCode().getId());
	        }
	        final Map<String, String> initParamsMap = SpringContextHelper.getBean(PropertiesUtil.class)
	                .getInitParams();
	        if (initParamsMap != null) {
		        obj.put(AppParams.FREE_FORM_SUPERVISOR_ALERT_ENABLED, 
		        		initParamsMap.getOrDefault(AppParams.FREE_FORM_SUPERVISOR_ALERT_ENABLED, "false"));
		        obj.put(AppParams.APP_VERSION, initParamsMap.getOrDefault(AppParams.APP_VERSION, ""));
	        }

	        if (desktopConfig.getCallModel() != null) {
	            obj.put(ContextConstants.PARAM_CALL_ON_HOLD_FLAG, "" + desktopConfig.getCallModel().isHoldEnabled());
	            obj.put(ContextConstants.PARAM_CALL_CONFERENCING_FLAG, "" + desktopConfig.getCallModel().isConferencing());
	            obj.put(ContextConstants.PARAM_PRIVACY_SHIELD_STATE, "" + desktopConfig.getCallModel().getPrivacyShieldState());
	            obj.put(ContextConstants.PARAM_PRIVACY_SHIELD_DURATION, "" + desktopConfig.getCallModel().getPrivacyShieldDuration());
	        }

	        final JSONArray attributesObjectArray = processAttributes(desktopConfig.getProperties());
	        obj.put(AgentProfileConstants.ATTRIBUTE, attributesObjectArray);
		} catch (JSONException jsonException) {
			LOGGER.error("Error occurred converting DesktopConfiguration: {}, to JSON with JSONException: {}",
					desktopConfig,
					jsonException.toString()); 
		}

        return obj;
	}

    @SuppressWarnings("unchecked")
	private static JSONArray processAttributes(final Map<String, String> attributes) {
		JSONArray attributeArray = new JSONArray();
        for(Map.Entry<String, String> attribute : attributes.entrySet()) {
	        	final String key = attribute.getKey();
	        	final String value = StringUtils.isEmpty(attribute.getValue()) ? "" : attribute.getValue();
	
	        	JSONObject attributeObj = new JSONObject();
            try {
				attributeObj.put(AgentProfileConstants.NODE_NAME, key);
	            attributeObj.put(AgentProfileConstants.NODE_VALUE, value);
			} catch (JSONException jsonException) {
				LOGGER.error("Error occurred processing (key, value): ({}, {}), to JSONArray with JSONException: {}",
						key, 
						value,
						jsonException.toString()); 
			}
            attributeArray.add(attributeObj);
        }
		
        return attributeArray;
	}
	
    /**
	 * @return the stringifiedCallData
	 */
	public static String getStringifiedCallData(DesktopConfiguration desktopConfig) {
        String callData = null;

        if (desktopConfig.getStateChangeData() != null && desktopConfig.getStateChangeData().getCallAssociatedData() != null) {
            final SortedMap<String, Data> dataMap = desktopConfig.getStateChangeData().getCallAssociatedData().getDataMap();
            if (dataMap != null && !dataMap.isEmpty()) {
                callData = toJson(dataMap);
            }
        }

        return callData;
	}


    /**
     * @param request
     * @return
     */
    private static String toJson(final SortedMap<String, Data> request) {
        // convert to json
        final Gson gson = new GsonBuilder().create();
        final String json = gson.toJson(request);

        return json;
    }
    
    public static JSONObject dnTeamNameToJson(final DesktopConfiguration desktopConfig) {
        final JSONObject obj = new JSONObject();
        try {
			obj.put(AgentProfileConstants.NODE_TEAM_NAME, desktopConfig.getTeamName());
	        obj.put(AdaConstants.FILTERED_AGENT_DN, desktopConfig.getDn());
		} catch (JSONException jsonException) {
			LOGGER.error("Error occurred converting DN and Team Name: {}, {}, from DesktopConfiguration: {}, to JSON with JSONException: {}",
					desktopConfig.getDn(),
					desktopConfig.getTeamName(),
					desktopConfig,
					jsonException.toString()); 
		}
        return obj;
    }
    
    /**
     * @param authError
     * @param detail
     */
    public static JSONObject errorOccurred(final int authError, final String detail) {
        final JSONObject jsonResponse = new JSONObject();
        try {
            jsonResponse.put(AdaConstants.CODE, String.valueOf(authError));
            jsonResponse.put(AdaConstants.DETAIL, detail);
        } catch (final JSONException jsonException) {
            LOGGER.error("Error occured while forming json string on authError and detail: {} and {}, with JSONException: {}", 
            		String.valueOf(authError),
            		detail,
            		jsonException);
        }
        return jsonResponse;
    }
    

    public static boolean hasReason(final String xml, final String reason) {
    	if (org.apache.commons.lang3.StringUtils.isBlank(xml)) {
    		return false;
    	}
    	return XMLtoJsonConverter.convertXMLtoJSON(xml).toString().contains(reason);
    }
}
