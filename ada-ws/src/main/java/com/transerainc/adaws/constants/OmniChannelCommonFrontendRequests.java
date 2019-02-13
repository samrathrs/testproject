/**
 * 
 */
package com.transerainc.adaws.constants;

/**
 * @author tnguyen
 *
 */
public interface OmniChannelCommonFrontendRequests {

	final String AGENT_LOGIN_REQUEST = "{ \"action\": \"OmniChannelAgentLogin\", \"requestData\": { } }";
	final String AGENT_STATE_CHANGE_REQUEST = "{ \"action\": \"AgentStateChange\", \"requestData\": { } }";

	// TODO: Determine how to populate the monitoredQueues
	final String AGENT_LOGOUT_REQUEST = 
			"{" +
					"\"action\": \"Logout\", " +
					"\"requestData\": " +
						"{" +
							"\"sessionId\": \"\", " +
							"\"agentId\": 0, " +
							"\"logoutAction\": \"LogoutButtonClicked\", " +
							"\"logoutReasonCode\": 0, " +
							"\"monitoredQueues\": \"{}\" " +
						"}" +
			"}";
}
