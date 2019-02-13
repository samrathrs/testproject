package com.transerainc.adaws.json;

import java.util.Hashtable;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.transerainc.adaws.constants.AdaConstants;
import com.transerainc.adaws.constants.AgentProfileConstants;
import com.transerainc.adaws.constants.ContextConstants;
import com.transerainc.adaws.constants.OmniChannelCommonConstants;
import com.transerainc.adaws.constants.OmniChannelEmailCommandConstants;
import com.transerainc.adaws.constants.StateCacheConstants;

/**
 * @author tringuyen
 *
 */
public class OmniChannelJsonUtil {

	private static Logger LOGGER = LoggerFactory.getLogger(OmniChannelJsonUtil.class.getName());

	public static String injectBackendSessionId(String mmResponse, String backendId) {
		try {
			JSONObject mmResponseJson = new JSONObject(mmResponse);
			// Extract mmResponse JSON Object value
			JSONObject mmResponseJsonObjectValue = mmResponseJson
					.getJSONObject(OmniChannelCommonConstants.MM_RESPONSE_KEY);

			// Inject backendId into mmResponse
			mmResponseJsonObjectValue.put(AgentProfileConstants.SESSION_ID_KEY, backendId);

			return mmResponseJson.toString();
		} catch (Exception exception) {
			LOGGER.debug("Error occurred injecting backendSessionId into mmResponse: {}, {}, with exception: {}",
					backendId, mmResponse, exception.getMessage());
		}

		return null;
	}

	public static String injectBackendSessionIdAgentIdIntoResponse(String payload, String backendId, long agentId) {
		try {
			JSONObject payloadJson = new JSONObject(payload);
			JSONObject responseDataJsonObjectValue = payloadJson
					.getJSONObject(OmniChannelCommonConstants.RESPONSE_DATA_KEY);
			responseDataJsonObjectValue.put(AgentProfileConstants.SESSION_ID_KEY, backendId);
			responseDataJsonObjectValue.put(AgentProfileConstants.AGENT_ID_KEY, agentId);
			LOGGER.debug("injected payload: {}", payloadJson.toString());
			return payloadJson.toString();
		} catch (Exception exception) {
			LOGGER.debug("Error occurred injecting (sessionId, agentId): ({}, {}), into : {}, with exception: {}",
					backendId, agentId, payload, exception.getMessage());
		}
		return null;
	}

	public static String injectBackendSessionIdAgentIdMessageIntoResponse(String payload, String backendId,
			long agentId, String msg) {
		try {
			JSONObject payloadJson = new JSONObject(payload);
			payloadJson.put(AgentProfileConstants.MESSAGE, msg);
			JSONObject responseDataJsonObjectValue = payloadJson
					.getJSONObject(OmniChannelCommonConstants.RESPONSE_DATA_KEY);
			responseDataJsonObjectValue.put(AgentProfileConstants.SESSION_ID_KEY, backendId);
			responseDataJsonObjectValue.put(AgentProfileConstants.AGENT_ID_KEY, agentId);
			LOGGER.debug("injected payload: {}", payloadJson.toString());
			return payloadJson.toString();
		} catch (Exception exception) {
			LOGGER.debug("Error occurred injecting (sessionId, agentId): ({}, {}), into : {}, with exception:: {}",
					backendId, agentId, payload, exception.getMessage());
		}
		return null;
	}

	public static String failureResponse(String payload, String backendId, long agentId, String action) {
		try {
			JSONObject payloadJson = new JSONObject(payload);
			payloadJson.put("action", action);
			JSONObject responseDataJsonObjectValue = payloadJson
					.getJSONObject(OmniChannelCommonConstants.RESPONSE_DATA_KEY);
			responseDataJsonObjectValue.put(AgentProfileConstants.SESSION_ID_KEY, backendId);
			responseDataJsonObjectValue.put(AgentProfileConstants.AGENT_ID_KEY, agentId);
			LOGGER.debug("injected payload: {}", payloadJson.toString());
			return payloadJson.toString();
		} catch (Exception exception) {
			LOGGER.debug(
					"Error occurred injecting (sessionId, agentId, action): ({}, {}, {}), into : {}, with exception: {}",
					backendId, agentId, action, payload, exception.getMessage());
		}
		return null;
	}

	public static String wrapAsRequestData(String rawRequestData) {
		JSONObject rawRequestDataJson = new JSONObject(rawRequestData);
		JSONObject requestData = new JSONObject();
		requestData.append(AdaConstants.REQUEST_DATA_KEY, rawRequestDataJson);
		return requestData.toString();
	}

	public static String injectRequestData(String mmRequest, String mmResponse) {
		try {
			JSONObject mmRequestJson = new JSONObject(mmRequest);
			JSONObject mmResponseJson = new JSONObject(mmResponse);
			JSONObject mmResponseJsonWithInjectedRequestData = injectRequestData(mmRequestJson, mmResponseJson);
			return mmResponseJsonWithInjectedRequestData.toString();
		} catch (Exception exception) {
			LOGGER.debug("Error occurred injecting mmRequest into mmResponse: {}, {}, with exception: {}", mmRequest,
					mmResponse, exception.getMessage());
		}
		return null;
	}

	public static JSONObject injectRequestData(JSONObject mmRequestJson, JSONObject mmResponseJson) {
		// Extract mmRequest JSON Object value
		JSONObject mmRequestJsonObjectValue = mmRequestJson.getJSONObject(OmniChannelCommonConstants.MM_REQUEST_KEY);
		// Extract requestData JSON Object value
		JSONObject requestDataJsonObjectValue = mmRequestJsonObjectValue.getJSONObject(AdaConstants.REQUEST_DATA_KEY);
		// Extract mmResponse JSON Object value
		JSONObject mmResponseJsonObjectValue = mmResponseJson.getJSONObject(OmniChannelCommonConstants.MM_RESPONSE_KEY);

		// Inject mmRequest into mmResponse
		mmResponseJsonObjectValue.append(AdaConstants.REQUEST_DATA_KEY, requestDataJsonObjectValue);

		return mmResponseJson;
	}

	public static String injectSessionAgentTenantIdsAndCallbackUrlIntoRequest(
			String sessionId,
			long tenantId,
			long agentId,
			String loginName,
			String callbackUrl,
			String requestData,  long emailChannels,long chatChannels, long blendingMode) {
		try {
			JSONObject requestJson = new JSONObject(requestData);
			JSONObject requestDataJsonObjectValue = requestJson.getJSONObject(AdaConstants.REQUEST_DATA_KEY);
			requestDataJsonObjectValue.put(AgentProfileConstants.SESSION_ID_KEY, sessionId);
			requestDataJsonObjectValue.put(ContextConstants.TENANT_ID, tenantId);
			requestDataJsonObjectValue.put(AgentProfileConstants.AGENT_ID_KEY, agentId);
			requestDataJsonObjectValue.put(AgentProfileConstants.LOGIN_NAME, loginName);
			requestDataJsonObjectValue.put("emailChannels", emailChannels);
			requestDataJsonObjectValue.put("chatChannels", chatChannels);
			requestDataJsonObjectValue.put("blendingMode", blendingMode);
			requestDataJsonObjectValue.put(OmniChannelCommonConstants.ADA_PERSISTENT_CALLBACK_URL, callbackUrl);
			return requestJson.toString();
		} catch (Exception exception) {
			LOGGER.debug(
					"Error occurred injecting (sessionId, tenantId, agentId, loginName, callbackUrl): ({}, {}, {}, {}, {}), into requestData: {}, with exception: {}",
					sessionId, Long.valueOf(tenantId), Long.valueOf(agentId), loginName, callbackUrl,
					exception.getMessage());
		}
		return null;
	}

	public static String injectSessionAgentIdsIntoRequest(String sessionId, long agentId, String requestData) {
		try {
			JSONObject requestJson = new JSONObject(requestData);
			JSONObject requestDataJsonObjectValue = requestJson.getJSONObject(AdaConstants.REQUEST_DATA_KEY);
			requestDataJsonObjectValue.put(AgentProfileConstants.SESSION_ID_KEY, sessionId);
			requestDataJsonObjectValue.put(AgentProfileConstants.AGENT_ID_KEY, agentId);
			return requestJson.toString();
		} catch (Exception exception) {

			LOGGER.debug(
					"Error occurred injecting (sessionId, agentId): ({}, {}), into requestData: {}, with exception: {}",
					sessionId, Long.valueOf(agentId), requestData, exception.getMessage());
		}
		return null;
	}

	public static String injectSessionIdIntoRequest(String sessionId, String payload) {
		try {
			JSONObject payloadJson = new JSONObject(payload);
			JSONObject requestData = payloadJson.getJSONObject(AdaConstants.REQUEST_DATA_KEY);
			requestData.put(AgentProfileConstants.SESSION_ID_KEY, sessionId);
			return payloadJson.toString();
		} catch (Exception exception) {
			LOGGER.debug("Error occurred injecting sessionId: {} into requestData: {}, with exception: {}", sessionId,
					payload, exception.getMessage());
		}
		return null;
	}

	public static String injectStringIntoPayload(String key, String value, String payloadData) throws Exception {
		JSONObject responseJson = new JSONObject(payloadData);
		JSONObject responseDataJsonObjectValue = responseJson
				.getJSONObject(OmniChannelCommonConstants.RESPONSE_DATA_KEY);
		responseDataJsonObjectValue.put(key, value);
		return responseJson.toString();
	}

	public static String extractMessageType(String payloadData) {
		try {
			JSONObject payloadJson = new JSONObject(payloadData);
			return payloadJson.getString(OmniChannelCommonConstants.MESSAGE_TYPE_KEY);
		} catch (Exception exception) {
			LOGGER.debug("Error occurred extracting {} from payloadData: {}, with exception: {}",
					OmniChannelCommonConstants.MESSAGE_TYPE_KEY, payloadData, exception.getMessage());
		}
		return null;
	}

	public static String extractSessionId(String payloadData) {
		try {
			JSONObject payloadJson = new JSONObject(payloadData);
			JSONObject responseDataJson = payloadJson.getJSONObject(OmniChannelCommonConstants.RESPONSE_DATA_KEY);
			return responseDataJson.getString(AgentProfileConstants.SESSION_ID_KEY);
		} catch (Exception exception) {
			LOGGER.debug("Error occurred extracting {} from profileData: {}, with exception: {}",
					AgentProfileConstants.SESSION_ID_KEY, payloadData, exception.getMessage());
		}
		return null;
	}

	public static long extractOutBoundID(String payloadData) {
		try {
			JSONObject payloadJson = new JSONObject(payloadData);
			JSONObject responseDataJson = payloadJson.getJSONObject(OmniChannelCommonConstants.RESPONSE_DATA_KEY);
			return responseDataJson.getLong(StateCacheConstants.OUTBOUND_ID);
		} catch (Exception exception) {
			LOGGER.debug("Error occurred extracting {} from outbound ID: {}, with exception: {}",
					StateCacheConstants.OUTBOUND_ID, payloadData, exception.getMessage());
		}
		return 0;
	}

	public static String extractSessionIdFromMmResponse(String payloadData) {
		try {
			JSONObject payloadJson = new JSONObject(payloadData);
			JSONObject mmResponse = payloadJson.getJSONObject(OmniChannelCommonConstants.MM_RESPONSE_KEY);
			JSONObject responseDataJson = mmResponse.getJSONObject(OmniChannelCommonConstants.RESPONSE_DATA_KEY);
			return responseDataJson.getString(AgentProfileConstants.SESSION_ID_KEY);
		} catch (Exception exception) {
			LOGGER.debug("Error occurred extracting session id: {}, from profileData: {}, with exception: {}",
					AgentProfileConstants.SESSION_ID_KEY, payloadData, exception.getMessage());
		}
		return null;
	}

	public static String extractAuxCodeId(String payloadData) {
		try {
			JSONObject payloadJson = new JSONObject(payloadData);
			JSONObject responseDataJson = payloadJson.getJSONObject(OmniChannelCommonConstants.RESPONSE_DATA_KEY);
			return String.valueOf(responseDataJson.getInt(AgentProfileConstants.AUX_CODE_ID));
		} catch (Exception exception) {
			LOGGER.debug("Error occurred extracting {} from profileData: {}, with exception: {}",
					AgentProfileConstants.AUX_CODE_ID, payloadData, exception.getMessage());
		}
		return null;
	}

	public static String extractAuxCodeName(final String payloadData) {
		try {
			JSONObject payloadJson = new JSONObject(payloadData);
			JSONObject responseDataJson = payloadJson.getJSONObject(OmniChannelCommonConstants.RESPONSE_DATA_KEY);
			return responseDataJson.getString(AgentProfileConstants.AUX_CODE_NAME);
		} catch (Exception exception) {
			LOGGER.debug("Error occurred extracting {} from profileData: {}, with exception: {}",
					AgentProfileConstants.AUX_CODE_NAME, payloadData, exception.getMessage());
		}
		return null;
	}

	public static int extractChannelId(final String payload, final String key) throws JSONException {
		int channelId = 0;
			try {
				JSONObject payloadJson = new JSONObject(payload);
				channelId = payloadJson.getInt(key);
			}catch(Exception e) {
				return channelId;
			}
		return channelId;
	}

	public static Long extractChannelId(final String payloadData) {
		JSONObject payloadJson = new JSONObject(payloadData);
		JSONObject responseDataJson = payloadJson.getJSONObject(OmniChannelCommonConstants.RESPONSE_DATA_KEY);
		try {
			return Long.valueOf(responseDataJson.getLong(AgentProfileConstants.CHANNEL_ID));
		} catch (Exception exception) {
			LOGGER.debug("Cannot extract {} from payloadData: {}, with exception: {}", AgentProfileConstants.CHANNEL_ID,
					payloadData, exception.getMessage());
		}
		return null;
	}

	public static Long extractChannelIdFromMmResponse(final String payloadData) {
		JSONObject payloadJson = new JSONObject(payloadData);
		JSONObject mmResponseDataJson = payloadJson.getJSONObject(OmniChannelCommonConstants.MM_RESPONSE_KEY);
		JSONObject responseDataJson = mmResponseDataJson.getJSONObject(OmniChannelCommonConstants.RESPONSE_DATA_KEY);
		try {
			return Long.valueOf(responseDataJson.getLong(AgentProfileConstants.CHANNEL_ID));
		} catch (Exception exception) {
			LOGGER.debug("Cannot extract {} from payloadData: {}, with exception: {}", AgentProfileConstants.CHANNEL_ID,
					payloadData, exception.getMessage());
		}
		return null;
	}

	public static String extractCduId(final String payloadData) {
		try {
			JSONObject payloadJson = new JSONObject(payloadData);
			JSONObject mmResponseDataJson = payloadJson.getJSONObject(OmniChannelCommonConstants.MM_RESPONSE_KEY);
			JSONObject responseDataJson = mmResponseDataJson
					.getJSONObject(OmniChannelCommonConstants.RESPONSE_DATA_KEY);
			return responseDataJson.getString(OmniChannelCommonConstants.CDU_ID_KEY);
		} catch (Exception exception) {
			LOGGER.debug("Cannot extract {} from payloadData: {}, with exception: {}",
					OmniChannelCommonConstants.CDU_ID_KEY, payloadData, exception.getMessage());
		}
		return null;
	}

	public static String extractCduIdFromEmail(final String payloadData) {
		try {
			JSONObject payloadJson = new JSONObject(payloadData);
			JSONObject mmResponseDataJson = payloadJson.getJSONObject(OmniChannelCommonConstants.MM_RESPONSE_KEY);
			JSONObject responseDataJson = mmResponseDataJson
					.getJSONObject(OmniChannelCommonConstants.RESPONSE_DATA_KEY);
			JSONObject emailContactDetailJson = responseDataJson
					.getJSONObject(OmniChannelEmailCommandConstants.EMAIL_CONTACT_DETAILS_KEY);
			return emailContactDetailJson.getString(OmniChannelCommonConstants.CDU_ID_KEY);
		} catch (Exception exception) {
			LOGGER.debug("Cannot extract {} from payloadData: {}, with exception: {}",
					OmniChannelCommonConstants.CDU_ID_KEY, payloadData, exception.getMessage());
		}
		return null;
	}

	public static String extractCduIdFromChat(final String payloadData) {
		try {
			JSONObject payloadJson = new JSONObject(payloadData);
			JSONObject mmResponseDataJson = payloadJson.getJSONObject(OmniChannelCommonConstants.MM_RESPONSE_KEY);
			JSONObject responseDataJson = mmResponseDataJson
					.getJSONObject(OmniChannelCommonConstants.RESPONSE_DATA_KEY);
			JSONObject contactDetailsJson = responseDataJson
					.getJSONObject(OmniChannelCommonConstants.CONTACT_DETAILS_KEY);
			return contactDetailsJson.getString(OmniChannelCommonConstants.CDU_ID_KEY);
		} catch (Exception exception) {
			LOGGER.debug("Cannot extract {} from payloadData: {}, with exception: {}",
					OmniChannelCommonConstants.CDU_ID_KEY, payloadData, exception.getMessage());
		}
		return null;
	}

	public static boolean extractSuccessFlagFromResponse(final String payloadData) {
		try {
			JSONObject payloadJson = new JSONObject(payloadData);
			return payloadJson.getBoolean(OmniChannelCommonConstants.SUCCESS_FLAG_KEY);
		} catch (Exception exception) {
			LOGGER.debug("Cannot extract {} from payloadData: {}, with exception: {}",
					OmniChannelCommonConstants.SUCCESS_FLAG_KEY, payloadData, exception.getMessage());
		}
		return false;
	}

	public static boolean extractSuccessFlagFromMmResponse(final String payloadData) {
		try {
			JSONObject payloadJson = new JSONObject(payloadData);
			JSONObject mmResponseDataJson = payloadJson.getJSONObject(OmniChannelCommonConstants.MM_RESPONSE_KEY);
			return mmResponseDataJson.getBoolean(OmniChannelCommonConstants.SUCCESS_FLAG_KEY);
		} catch (Exception exception) {
			LOGGER.debug("Cannot extract {} from payloadData: {}, with exception: {}",
					OmniChannelCommonConstants.SUCCESS_FLAG_KEY, payloadData, exception.getMessage());
		}
		return false;
	}

	public static String agnosticExtractCduId(final String payloadData) {
		String cduId = extractCduId(payloadData);
		if (org.apache.commons.lang3.StringUtils.isBlank(cduId)) {
			cduId = extractCduIdFromIcxResponse(payloadData);
		}
		return cduId;
	}

	public static String extractCduIdFromIcxResponse(final String payloadData) {
		try {
			JSONObject payloadJson = new JSONObject(payloadData);
			JSONObject responseDataJson = payloadJson.getJSONObject(OmniChannelCommonConstants.RESPONSE_DATA_KEY);
			return responseDataJson.getString(OmniChannelCommonConstants.CDU_ID_KEY);
		} catch (Exception exception) {
			LOGGER.debug("Cannot extract {} from payloadData: {}, with exception: {}",
					OmniChannelCommonConstants.CDU_ID_KEY, payloadData, exception.getMessage());
		}
		return null;
	}

	public static String extractCduIdFromFeRequestToIcx(final String payloadData) {
		try {
			JSONObject payloadJson = new JSONObject(payloadData);
			JSONObject requestDataJson = payloadJson.getJSONObject(OmniChannelCommonConstants.REQUEST_DATA_KEY);
			return requestDataJson.getString(OmniChannelCommonConstants.CDU_ID_KEY);
		} catch (Exception exception) {
			LOGGER.debug("Cannot extract {} from payloadData: {}, with exception: {}",
					OmniChannelCommonConstants.CDU_ID_KEY, payloadData, exception.getMessage());
		}
		return null;
	}

	public static Long extractSendTimeFromResponse(final String payloadData) {
		try {
			JSONObject payloadJson = new JSONObject(payloadData);
			JSONObject responseDataJson = payloadJson.getJSONObject(OmniChannelCommonConstants.RESPONSE_DATA_KEY);
			return responseDataJson.getLong(OmniChannelCommonConstants.SEND_TIME_KEY);
		} catch (Exception exception) {
			LOGGER.debug("Cannot extract {} from response payloadData: {}, with exception: {}",
					OmniChannelCommonConstants.SEND_TIME_KEY, payloadData, exception.getMessage());
		}
		return null;
	}

	public static Long extractSendTimeFromMmResponse(final String payloadData) {
		try {
			JSONObject payloadJson = new JSONObject(payloadData);
			JSONObject mmResponseDataJson = payloadJson.getJSONObject(OmniChannelCommonConstants.MM_RESPONSE_KEY);
			JSONObject responseDataJson = mmResponseDataJson
					.getJSONObject(OmniChannelCommonConstants.RESPONSE_DATA_KEY);
			return responseDataJson.getLong(OmniChannelCommonConstants.SEND_TIME_KEY);
		} catch (Exception exception) {
			LOGGER.debug("Cannot extract {} from mmResponse payloadData: {}, with exception: {}",
					OmniChannelCommonConstants.SEND_TIME_KEY, payloadData, exception.getMessage());
		}
		return null;
	}

	public static Map<String, String> extractNameEmailFromCustomerEmailInformation(String payloadData) {
		try {
			JSONObject payloadJson = new JSONObject(payloadData);
			JSONObject requestDataJson = payloadJson.getJSONObject(OmniChannelCommonConstants.REQUEST_DATA_KEY);
			JSONArray customerEmailInformationAsJsonArray = requestDataJson
					.getJSONArray(OmniChannelCommonConstants.CUSTOMER_EMAIL_KEY);
			Map<String, String> nameEmailMap = new Hashtable<String, String>();
			if ((customerEmailInformationAsJsonArray == null) || (customerEmailInformationAsJsonArray.length() == 0)) {
				return null;
			}
			for (int idx = 0; idx < customerEmailInformationAsJsonArray.length(); idx++) {
				JSONObject nameEmailPair = customerEmailInformationAsJsonArray.getJSONObject(idx);
				String name = nameEmailPair.getString(OmniChannelCommonConstants.CUSTOMER_EMAIL_INFORMATION_NAME_KEY);
				String email = nameEmailPair.getString(OmniChannelCommonConstants.CUSTOMER_EMAIL_INFORMATION_EMAIL_KEY);
				nameEmailMap.put(name, email);
			}
			return nameEmailMap;
		} catch (Exception exception) {
			LOGGER.debug("Cannot extract customerEmailInformation from payloadData: {}, with exception: {}",
					payloadData, exception.getMessage());
		}
		return null;
	}
}
