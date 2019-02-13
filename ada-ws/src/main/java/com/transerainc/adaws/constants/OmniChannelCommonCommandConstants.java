package com.transerainc.adaws.constants;

/**
 * @author tringuyen
 *
 *  Defines common command constants for OmniChannel capability.
 *  In particular, this interface defines the JS Methods (jsMethod) that the Agent Desktop Application (Ada)
 *  Backend uses as a transmission communication endpoint of the Ada Frontend UI.
 */

public interface OmniChannelCommonCommandConstants {
    // Common prefix to all OmniChannel constants
    final String PREFIX = "mm.";

    // Common constants
    
    final String STATE_CHANGED = "mm.stateChanged";
    final String STATE_CHANGE_ACCEPTED = "mm.stateChangeAccepted";
    
    final String LOGIN_SUCCESS = "mm.loginSuccess";
    final String AGENT_LOGGED_IN = "mm.agentLoggedIn";
    
    final String HEARTBEAT_FAILED = "mm.heartbeatFailed";
    
    final String CONTACT_WRAP_UP = "mm.wrapUpContact";
    final String CONTACT_WRAPPED_UP = "mm.contactWrappedUp";
    
    final String CONTACT_COMPLETED = "mm.contactCompleted";
    final String CONTACT_CLOSED = "mm.contactClosed";
    
    final String RONA_NOTIFICATION = "mm.ronaNotified";
    
    final String CONTACT_TRANSFER_TO_QUEUE = "mm.contactTransferToQueue";
    final String CONTACT_TO_QUEUE_TRANSFERRED = "mm.contactToQueueTransferred"; // synchronous response
    
    final String CONTACT_TRANSFER_TO_AGENT = "mm.contactTransferToAgent";
    final String CONTACT_TO_AGENT_TRANSFERRED = "mm.contactToAgentTransferred"; // synchronous response
    
    final String CONTACT_TRANSFERRED = "mm.contactTransferred"; // callback response from ICX for both transfer to Q and Agent

    final String INITIATE_TRANSFER_REQUEST = "mm.initiateTransferRequest"; // redirectApi from FE
    final String TRANSFER_REQUEST_INITIATED = "mm.transferRequestInitiated"; // Synchronous response: jsMethod
    
    final String CONTACT_TRANSFER_REQUEST = "mm.contactTransferRequest"; // redirectApi from FE
    final String CONTACT_TRANSFER_REQUESTED = "mm.contactTransferRequested"; // Synchronous response: jsMethod

    final String FETCH_TRANSFERABLE_AGENTS = "mm.fetchTransferableAgents";
    final String TRANSFERABLE_AGENTS_FETCHED = "mm.transferableAgentsFetched";
    
    final String FETCH_TRANSFERABLE_QUEUES = "mm.fetchTransferableQueues";
    final String TRANSFERABLE_QUEUES_FETCHED = "mm.transferableQueuesFetched";
    
    final String GET_RESOURCES_LIST = "mm.getResourcesList";
    final String RESOURCES_LIST_FETCHED = "mm.resourcesListFetched";
    
    final String GET_CHANNELS = "mm.getChannels";
    final String CHANNELS_FETCHED = "mm.channelsFetched";
    
    final String GET_ENTRY_POINTS = "mm.getEntryPoints";
    final String ENTRY_POINTS_FETCHED = "mm.entryPointsFetched";
    
    final String GET_MACRO = "mm.getAgentResourceMacroData";
    final String MACRO_FETCHED = "mm.agentResourceMacroDataFetched";
    
    final String SAVE_AGENT_RESOURCE = "mm.saveAgentResource";
    final String AGENT_RESOURCE_SAVED = "mm.agentResourceSaved";
    
    final String UPDATE_AGENT_RESOURCE = "mm.updateAgentResource";
    final String AGENT_RESOURCE_UPDATED = "mm.agentResourceUpdated";
    
    final String DELETE_AGENT_RESOURCE = "mm.deleteAgentResource";
    final String AGENT_RESOURCE_DELETED = "mm.agentResourceDeleted";
    
    final String GET_PROCESS_GUIDES = "mm.getProcessGuides";
    final String PROCESS_GUIDES_FETCHED = "mm.processGuidesFetched";
    
    final String PROCESS_GUIDES_BODY = "mm.processGuidesBody";
    final String BODY_PROCESS_GUIDES = "mm.bodyProcessGuides";
    
    final String RTCC_HEALTH_CHECK = "mm.rtccHealthCheck";
    final String HEALTH_CHECK_RTCC = "mm.healthCheckRtcc";
    
    final String LOGOUT_REQUEST = "mm.logout";
    final String LOGOUT_RESPONSE = "mm.logoutResponse";
    final String AGENT_LOGGED_OUT = "mm.agentLoggedOut";
    
    final String FOLLOW_UP_CONTACT_RETIRE = "mm.followUpContactRetire";
    final String CONTACT_RETIRE_FOLLOWED_UP = "mm.contactRetireFollowedUp";

    final String FOLLOW_UP_CONTACT_REMIND_LATER = "mm.followUpContactRemindLater";
    final String CONTACT_REMIND_LATER_FOLLOWED_UP = "mm.contactRemindLaterFollowedUp";
    
    final String CONTEXT_DATA = "mm.contextData";
    final String CONTEXT_DATA_FETCHED = "mm.contextDataFetched";
    
    final String REFRESH_AGENT = "mm.refreshAgent";
    final String AGENT_REFRESHED = "mm.agentRefreshed";
    
    final String FETCH_FOLLOW_UP_CONTACTS_ON_LOGIN = "mm.fetchFollowUpContactsOnLogin";
    final String FOLLOW_UP_CONTACTS_ON_LOGIN_FETCHED = "mm.followUpContactsOnLoginFetched";
}
