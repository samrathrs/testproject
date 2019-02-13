package com.transerainc.adaws.constants;

/**
 * @author rajeev.lochanam
 */
public interface ContextConstants {

	final String AND_AT = "and @";
	final String AGENT = "agent";
	final String QUEUE = "queue";
	final String VIRTUAL_TEAM = "virtualTeam";

	final String PARAM_AGENT_ID = "std.agentId";
	final String PARAM_USERNAME = "std.userName";
	final String PARAM_USER_REALNAME = "std.userRealName";

	final String PARAM_DN = "std.dn";
	final String DN = "dn";
	final String PARAM_DEFAULT_DN = "std.defaultDn";

	final String POSITION_ID = "positionId";
	final String PROTOCOL_VERSION = "protocolVersion";
	final String PARAM_ENTERPRISE_ID = "std.enterpriseId";
	final String PARAM_ENTERPRISE_NAME = "std.enterpriseName";
	final String PARAM_SITE_ID = "std.siteId";
	final String SITE_ID = "siteId";
	final String PARAM_SITE_NAME = "std.siteName";

	final String PARAM_TEAM_ID = "std.teamId";
	final String TEAM_ID = "teamId";
	final String PARAM_TEAM_NAME = "std.teamName";

	final String PARAM_STATE = "std.status";
	final String PARAM_SUB_STATE = "std.subStatus";
	final String AGENT_SESSION_ID = "agentsessionid";
	final String PARAM_LAST_IDLE_CODE = "std.lastIdleAuxCode";
	final String PARAM_CALL_ON_HOLD_FLAG = "std.call.onHold";
	final String PARAM_CALL_CONFERENCING_FLAG = "std.call.conferencing";
	final String PARAM_PRIVACY_SHIELD_STATE = "std.privacy.shield.state";
	final String PARAM_PRIVACY_SHIELD_DURATION = "pauseDuration";
	final String PARAM_TEAM_IDS_CSV = "std.teamIdsCSV";
	final String PARAM_TEAM_NAMES_CSV = "std.teamNamesCSV";
	final String AGENT_INTERNAL_ROUTED_CALL_ON_HOLD = "internalRoutedCallOnHold";

	final String PARAM_BASE_URL = "std.baseUrl";
	final String PARAM_AGENT_LIST = "std.agentList";
	final String PARAM_VTEAM_LIST = "std.vteamList";

	final String TRANSFER_TYPE = "transferType";
	final String TENANT_ID = "tenantId";
	final String QUERY_HIPHEN = "query-";
	final String IS_OUTDIAL_CALL = "isOutdialCall";

	// errors
	final int ERROR_UNKNOWN = 0;
	final int ERROR_CONNECTION = 1;
	final int ERROR_AUTHENTICATION = 2;
	final int ERROR_AUTH_CONFIG = 3;
	final int ERROR_AUTH_UNKNOWN = 4;
	final int ERROR_RECOVERY_FAILED = 5;
	final int ERROR_ALL_RECONNECTS_FAILED = 6;
	final int ERROR_PASSWORD_EXPIRED = 7;
	final int ERROR_VERSION_MISMATCH = 8;
	final int ERROR_DUPLICATE_DN = 9;
	final int ERROR_FORCE_PASSWORD_CHANGE = 10;

	final int ERROR_HOLD = 11;
	final int ERROR_UNHOLD = 12;
	final int ERROR_HOLD_ON_CONSULT_REQUEST = 13;
	final int ERROR_CONSULT = 14;
	final int ERROR_TRANSFER = 15;
	final int ERROR_HOLD_ON_CONSULTING = 16;
	final int ERROR_CONFERENCING = 17;
	final int ERROR_VTEAM_TRANSFER = 18;
	final int ERROR_CONSULT_CANCEL = 19;

	final int ERROR_OUTDIAL_GENERIC_ERROR = 20;
	final int ERROR_OUTDIAL_REJECTED = 21;
	final int ERROR_CANCEL_OUTDIAL_REJECTED = 22;

	final int ERROR_PRIVACY_SHIELD_REQUEST = 23;

	final int ERROR_CALL_END = 24;

	final int ERROR_AUTH_MAX_ATTEMPTS_EXCEEDED = 25;

	final int ERROR_INVALID_STATION_DN = 26;
	final int ERROR_INVALID_OUTDIAL_DN = 27;
	final int ERROR_CONNECTION_LOST = 28;
	final int ERROR_CONNECTION_RESTORED = 29;
	final int ERROR_CONNECTION_FAILURE_NOT_ENABLED = 30;
	final int ERROR_AUTHENTICATION_SERVER = 32;
	final int ERROR_CONNECTING_SERVER = 33;
	final int ERROR_TOKEN_CHANGED = 34;
	final int ERROR_SERVER_NOT_FOUND = 35;
	final int WARNING_AGENT_LOCK = 36;
	final int CALL_CENTER_DISABLED = 41;
	final String CALL_CENTER_DISABLED_ERROR_MESSAGE = "Call Center capabilities are disabled for this agent.";
	
	// Omni
	public static final int ERROR_OMNI = 37; // http 5xx ICX Server related errors
	
	// Omni
	public static final int ERROR_OMNI_HB = 38; // ICX heartbeat
	public static final String ICX_HB_LOST = "ICX Hearbeat Connection Lost";
	
	// Omni 
	public static final int ERROR_OMNI_4XX = 39; // http 4xx ICX Server related errors

	public static final int WARNING_TACG_SHUTTING_DOWN_CODE = 40;
	public static final String TACG_SHUTTING_DOWN_REASON = "TPGShuttingDown";
	
	public static final int ERROR_AGENT_SESSION_NOT_FOUND_CODE = 34;

	// privacy shield
	public static final int STATE_OK = 1;
	public static final int STATE_REJECTED = 2;
	public static final int STATE_FAILED = 3;

	// CRMLite data post for LAR
	final String TIMESTAMP = "timestamp";
	final String EVENT_NAME = "eventName";
	final String EVENT_NAME_ADD = "Add";
	final String ENTITY_ID = "entityId";
	final String ATTRIBUTE_MAP = "attrMap";
	final String CONTENT_TYPE = "Content-Type";
	final String AUTHORIZATION = "Authorization";
	final String FROM = "From";
	final String LAR_AGENT_ID = "larAgentId";
	final String LAR = "lar";
	final String SID = "sid";

	final String PROPERTIES_FILE_PATH = "./config/ada-ws.properties";
	
	public static final String CAMPAIGN_MANAGER_APIURI = "APIURI";
	public static final String ADA_CUSTOMIZATION_CONFIGURATION_PARAMETER_KEY = "CONFIG";
	public static final String URI = "URI";

	public static final String BROWSER_CLOSED_REASON = "Browser closed";
	
	public static final int MAX_RECOVERY_LOGOUT_ATTEMPTS = 2;
}
