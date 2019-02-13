package com.transerainc.adaws.constants;

/**
 * @author tnguyen
 *
 */
public interface OmniChannelCommonConstants {
	
	final int MISSED_ICX_HEARTBEAT_THRESHOLD = 5;
	
	final String MM_REQUEST_KEY = "mmRequest";
	final String MM_RESPONSE_KEY = "mmResponse";
	final String RESPONSE_DATA_KEY = "responseData";
	final String REQUEST_DATA_KEY = "requestData";
	final String CONTACT_DETAILS_KEY = "contactDetails";
	final String ADA_PERSISTENT_CALLBACK_URL = "persistentCallbackUrl";
	final String ADA_CALLBACK_URL = "callbackUrl";
	final String PERSISTENT_CALLBACK_URL_PROPERTIES_KEY = "ada.omnichannel.callback.url";
	final String OMNICHANNEL_URL = "omnichannel.url";
	final String CDU_ID_KEY = "cduId";
	final String SUCCESS_FLAG_KEY = "success";
	final String SEND_TIME_KEY = "sendTime";
	final String CUSTOMER_EMAIL_KEY = "to";
	final String CUSTOMER_EMAIL_INFORMATION_NAME_KEY = "name";
	final String CUSTOMER_EMAIL_INFORMATION_EMAIL_KEY = "email";

	final String MM_OPENING_BRACES = "{";
	final String MM_CLOSING_BRACES = "}";
	final String MM_QUOTE ="\"";
	final String MM_SEMICOLON =":";

	final String MM_RESPONSE_WRAPPER_PREFIX = MM_OPENING_BRACES + 
			MM_QUOTE +
			MM_RESPONSE_KEY + 
			MM_QUOTE +
			MM_SEMICOLON;
	final String MM_RESPONSE_WRAPPER_POSTFIX = MM_CLOSING_BRACES;
	final String MESSAGE_TYPE_KEY = "action";
	
	final String EMAIL_CHANNEL_KEY = "emailChannels";
	final String CHAT_CHANNEL_KEY = "chatChannels";
	final String TELE_CHANNEL_KEY = "teleChannels";
	final String BLENDING_MODE_KEY = "blendingMode";

	final String LOGIN_FAILED_RESPONSE = 
			"{" + 
					"\"mmResponse\": {" + 
						"\"action\": \"OmniChannelAgentLogin\"," + 
						"\"responseData\": {" + 
						"}," + 
						"\"success\": false," + 
						"\"message\": \"Login Failed.\"" + 
						"}" + 
			"}";

	final String LOGOUT_FAILED_RESPONSE = 
			"{" + 
					"\"mmResponse\": {" + 
						"\"action\": \"Logout\"," + 
						"\"responseData\": {" + 
						"}," + 
						"\"success\": false," + 
						"\"message\": \"Logout Failed.\"" + 
						"}" + 
			"}";
	final String LOGIN_FAILED_RESPONSE1 = 
			"{" + 
						"\"action\": \"OmniChannelAgentLogin\"," + 
						"\"responseData\": {" + 
						"}," + 
						"\"success\": false," + 
						"\"message\": \"Ada Send Login Failed.\"" + 
			"}";

	final String LOGOUT_FAILED_RESPONSE1  = 
			"{" + 
						"\"action\": \"Logout\"," + 
						"\"responseData\": {" + 
						"}," + 
						"\"success\": false," + 
						"\"message\": \"Ada Send Logout Failed.\"" + 
			"}";
	
	final String ICX_POST_FAILED_RESPONSE  = 
			"{" +  
						"\"responseData\": {" + 
						"}," + 
						"\"success\": false," + 
						"\"message\": \"Ada Send to ICX failed.\"" + 
			"}";
	
	final String REQUEST_ICX_HEARTBEAT  = 
			"{" +  
					"\"action\": \"HeartBeat\"," + 
					"\"callbackUrl\": \"%s\"," +
						"\"requestData\": {" + 
							"\"sessionId\": \"%s\"," +
							"\"timestamp\": \"%s\" " +	
						"}" +  
			"}";
	
	final String ICX_HEARTBEAT_FAILED_RESPONSE  = 
			"{" +  
					"\"action\": \"HeartBeatOmniChannel\"," + 
					"\"responseData\": {" + 
						"\"sessionId\": \"%s\"" +
						"}," + 
					"\"success\": false," + 
					"\"message\": \"ICX Heartbeat Failure.\"" + 
			"}";
}
