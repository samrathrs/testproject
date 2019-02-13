package com.transerainc.adaws.json;

import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.transerainc.adaws.constants.ProxyConstants;

public class ProxyJson {

	private static Logger LOGGER = LoggerFactory.getLogger(ProxyJson.class.getName());

    public static String getAgentSessionId(String dataPayloadString) throws JSONException {
	    	try {
	    		JSONObject dataPayloadJson = new JSONObject(dataPayloadString);
	    		return dataPayloadJson.getString(ProxyConstants.AGENT_SESSION_ID_OBJECT_KEY);
	    	} catch (JSONException jsonException) {
	    		LOGGER.error("Unable to extract FE agentSessionId/WebToken from payload: {}", dataPayloadString);
	    		throw jsonException;
	    	}
    }

    public static String getTranscriptId(String dataPayloadString) throws JSONException {
	    	try {
	    		JSONObject dataPayloadJson = new JSONObject(dataPayloadString);
	    		return dataPayloadJson.getString(ProxyConstants.TRANSCRIPT_ID);
	    	} catch (JSONException jsonException) {
	    		LOGGER.error("Unable to extract FE transcriptId from payload: {}", dataPayloadString);
	    		throw jsonException;
	    	}
    }
    
    public static String getAction(String dataPayloadString) throws JSONException {
	    	try {
	    		JSONObject dataPayloadJson = new JSONObject(dataPayloadString);
	    		return dataPayloadJson.getString(ProxyConstants.ACTION_OBJECT_KEY);
	    	} catch (JSONException jsonException) {
	    		LOGGER.error("Unable to extract action from payload: {}", dataPayloadString);
	    		throw jsonException;
	    	}
    }

    public static String getRequestDataFromJson(String dataPayloadString) throws JSONException {
	    	try {
	    		JSONObject dataPayloadJson = new JSONObject(dataPayloadString);
	    		JSONObject requestDataJson = dataPayloadJson.getJSONObject(ProxyConstants.REQUEST_DATA_OBJECT_KEY);
	    		String requestDataValueAsString = requestDataJson.toString();
	    		LOGGER.debug("requestDataValueAsString: {}", requestDataValueAsString);
	    		return requestDataValueAsString;
	    	} catch (JSONException jsonException) {
	    		LOGGER.error("Unable to extract request data from payload: {}, with JSONException: {}", 
	    				dataPayloadString,
	    				jsonException.toString());
	    		throw jsonException;
	    	}
    }

    public static String getRequestDataFromStringifiedJson(String dataPayloadString) throws JSONException {
	    	try {
	    		JSONObject dataPayloadJson = new JSONObject(dataPayloadString);
	    		return dataPayloadJson.getString(ProxyConstants.REQUEST_DATA_OBJECT_KEY);
	    	} catch (JSONException jsonException) {
	    		LOGGER.error("Unable to extract request data from payload: {}, with JSONException: {}", 
	    				dataPayloadString,
	    				jsonException.toString());
	    		throw jsonException;
	    	}
    }
}
