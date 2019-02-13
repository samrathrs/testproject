package com.transerainc.adaws.constants;

/**
 * @author rajeev.lochanam
 */
public interface AdaConstants {

	String AUTHENTICATE = "authenticate";
	String RECONNECT_AUTH = "reconnect";
	String TPM_URL = "tpm.url";
	String HOST_NAME = "app.host.name";
	String PORT_NUMBER = "app.port";
	String NON_DMZ_PORT = "app.nondmz.port";
	String PROCESSS_ID = "process.id";
	String PROCESS_ID_FILE = "process.id.file";
	String APPLICATION_NAME = "application.name";
	String TPM_PATH = "/nondmz/tpm";
	String PING_PATH = TPM_PATH + "/pingIntf";
	String SHUTDOWN_PATH = TPM_PATH + "/shutdownIntf";

	// Security
	String SSL_ENABLED = "sslEnabled";
	String CAS_SECURE_PORT_NUMBER = "auth.cas.callback.port";

	// String PING_SERVLET = "/ada-ws/PingServlet";
	// String SHUTDOWN_SERVLET = "/ada-ws/ShutdownServlet";
	String PROTOCOL = "http://";
	String SECURE_PROTOCOL = "https://";
	String PORT_SEPARATOR = ":";
	String ADA_CALLBACK_URL = "/ada-ws/handleTacgResponse";
	String AGENT_SESSION_ID = "agentsessionid";
	String CALL_BACK_URL = "callBackUrl";
	String XML_STRING = "xmlString";

	String CONFIG_DIR = "config.dir";
	String DESKTOP_PROPERTIES_FILE_NAME = "ada-ws.properties";
	String QUERY_SPEED_DIAL_LIST = "querySpeedDialList";
	String REQUEST_DATA_KEY = "requestData";
	String REQUEST_WRAPUP_CALL = "requestWrapUpCall";
	String REQUEST_CALL_END = "requestCallEnd";
	String REQUEST_STATE_CHANGE = "requestStateChange";
	String REQUEST_LOGOUT = "requestLogout";
	String REQUEST_STATION_LOGIN = "requestStationLogin";
	String REQUEST_CONSULT_TRANSFER = "consultTransfer";
	String REQUEST_CALL_TRANSFER = "callTransfer";
	String REQUEST_CONSULT = "requestConsult";
	String REQUEST_CONFERENCE = "requestConference";
	String REQUEST_CONSULT_END = "requestConsultEnd";
	String REQUEST_HOLD = "requestHold";
	String REQUEST_CTQ = "ctq";
	String REQUEST_OUT_DIAL = "outdial";
	String REQUEST_CONSULT_TO_QUEUE_ACCEPTED = "requestConsultToQueueAccepted";
	String REQUEST_CONSULT_TO_QUEUE_CANCEL = "requestConsultToQueueCancel";
	String SEND_SUPERVISOR_ALERT = "sendSupervisorAlert";
	String REQUEST_PAUSE_RECORDING = "requestPauseRecording";
	String REQUEST_RESUME_RECORDING = "requestResumeRecording";
	String REQUEST_STATE_CHANGE_TO_AVAILABLE = "requestStateChangeToAvailable";
	String REQUEST_FOR_HEART_BEAT = "heartBeatCheck";
	String REQUEST_RELOADED_STATE = "reloadedState";	// Legacy Desktop approach to connection recovery
	String REQUEST_CHECK_STATE = "syncUiState";			// Legacy Desktop approach to browser reload
	String REQUEST_RESTORE_UI_STATE = "restoreUiState";	// New approach to connection recovery for new (2017) UI
	String REQUEST_RELOAD_UI_STATE = "reloadUiState";	// New approach to browser reload for new (2017) UI
	String REQUEST_CHANGE_DN_AND_TEAM = "changeDnTeamName";
	String REQUEST_COMPONENT_INFORMATION = "requestComponentInformation";

	//icrm
	String DOICRMLOGIN = "doIcrmLogin";
	String DOICRMLOGOUT = "doIcrmLogout";
	String GETAGENTTPP = "getAgentTpp";

	String QUERY_AGENT_LIST = "queryAgentList";
	String QUERY_VTEAM_LIST = "queryVteamList";

	String CODE = "code";
	String UTF_8 = "UTF-8";
	String DETAIL = "detail";
	String ADA_TOKEN = "adaToken";
	String FAILED = "failed";
	String REASON = "reason";
	String PASSWORD_EXPIRED = "passwordExpired";
	String VERSION_MISMATCH = "versionMismatch";
	String PASSWORD_CHANGE = "ForcedPasswordChange";
	String ACCOUNT_LOCKED = "Agent account is locked";
	String NOT_VALID_CREDENTIALS = "Not valid credentials";
	String ANOTHER_INSTANCE_LOGOUT = "loggingOutAnotherInstance";
	String CONFIG_ERROR = "badOrMissingDesktopConfigurationForThisEnterprise";
	String LOGIN_BLOCKED = "Due to multiple failed attempts to login your account has been blocked, contact your supervisor";

	String AUTH_FAILED = "Authentication failed.";
	String VERSION_MISMATCH_DESC = "Version mismatch.";
	String ACCOUNT_BLOCKED_DESC = "Your account has been locked. Please contact your supervisor.";
	String NOT_ACCESSIBLE_DESC = "This enterprise configuration is not accessible";
	String RESPONSE_STRING = "responseString";
	String SERVER_NOT_STARTED = "Failed to connect to server.";
	String SERVER_NOT_FOUND = "ErrorServerNotFound";
	String ACC_LOCK_WARNING = "The login attempt was unsuccessful. Your account will be locked if another unsuccessful attempt is made to access this account. Please reset your password to avoid your account from getting locked.";
	String FILTERED_AGENT_DN = "filteredAgentDn";

	String ENTERRPISE_ENTITY = "customer";
	String ATTRIBUTES = "lastAgentRouting";
	String OUTDIAL_ANI_KEY = "number";
	String OUTDIAL_ANI_VALUE = "entryName";
	String OUTDIAL_ANI_LIST_ENTRY = "outdialAniListEntry";
	String ALL = "*";
	String ENTERPRISE_LAR_ENABLED = "enterpriseLarEnabled";
	String MOCK_OUTDIAL_ANI_LIST = "mockOutdialAniList";

	String CONTENT_TYPE_JSON = "application/json";
	String UTF8 = "UTF-8";

	String CUSTOM_PATH = "customPath";

	String JSESSIONID = "JSESSIONID";

	String GET_TRANSCRIPT = "getTranscript";
	String PUBLISH_CONSULTING = "publishConsulting";
	
	String CONFIG_AGENT_URL_PROPERTY_KEY = "config.agent.url";
	
	String WEBSOCKET_SESSION_ATTRIBUTES_KEY = "simpSessionAttributes";
	String SPRING_SESSION_ID_KEY = "SPRING.SESSION.ID";

}
