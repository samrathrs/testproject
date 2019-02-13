/**
 * 
 */
package com.transerainc.adaws.constants;

/**
 * @author jnarain
 *
 */
public interface OmniChannelCommonMessageTypeConstants {

	// synchronous responses from ICX: 
	final String AGENT_LOGIN = "OmniChannelAgentLogin";
	final String AGENT_STATE_CHANGE = "AgentStateChange"; // mm.stateChanged to FE
	
	final String FETCH_TRANFERABLE_AGENTS = "FetchTransferableAgents";
	final String FETCH_TRANFERABLE_QUEUES = "FetchTransferableQueues";
	final String WRAPUP_CONTACT = "WrapUpRequest"; // mm.contactWrappedUp to FE 
	final String CONTACT_COMPLETED = "ContactCompletedRequest"; // mm.contactClosed to FE
	
	// asynchronous Callback from ICX:
	final String AGENT_LOGGED_IN_CB = "AgentLoginCallback";	// mm.agentLoggedIn
	final String AGENT_LOGGED_OUT_CB = "AgentLogoutCallback";	// mm.agentLoggedOut
	final String AGENT_STATE_CHANGE_CB = "AgentStateChangeCallback"; // mm.stateChangeAccepted to FE
	final String RONA_CONTACT_REDIRECT = "ContactRedirectCallback"; // mm.ronaNotified to FE
	final String CONTACT_COMPLETED_CB = "ContactCompletedCallback"; // mm.contactCompleted to FE
	final String CONTACT_TRANSFERRED_CB = "ContactTransferredCallback"; // mm.contactTransferred to FE
	
}
