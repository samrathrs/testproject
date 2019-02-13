package com.transerainc.adaws.constants;

/**
 * @author rajeev.lochanam
 */
public interface AppParams {

    // State Recovery
    final String RECOVERY_MAX_TIME = "lostConnectionRecoveryTimeout";

    // Connection Retry
    final String FAILOVER_ENABLED = "failoverEnabled";

    // Hearbeat
    final String HEART_BEAT_INTERVAL = "heartBeatInterval";
    final String MISSED_HEART_BEATS_ALLOWED = "missedHeartBeatsAllowed";
    final String HEART_BEAT_RETRY_FREEQUENCY = "retryFreequency";
    final String DEFAULT_MISSED_HB_ALLOWED = "2";
    final String LOST_CONNECTION_REC_TIMEOUT= "120";
    // CAD
    final String BASE_URL = "callVariablesBaseUrl";
    final String CAD_SUPPRESSED_KEYS = "callVariablesSuppressed";
    final String CAD_ALLOWED_KEYS = "callVariablesAllowed";
    final String CAD_DENY_FIRST = "callVariablesSuppressedFirst";
    final String CAD_TRANSLATION = "callVariablesTranslation";
    final String CAD_SHOW_EMPTY = "callVariablesShowEmpty";

    // Password
    //final String PASSWORD_CHANGE_URL = "passwordChangeUrl";
    //final String PASSWORD_RESET_URL = "passwordResetUrl";
    //final String PASSWORD_EXPIRY_WARNING_LIMIT = "passwordExpirationWarningInDays";
    final String APP_VERSION = "app.version";

    // DN Validation
    final String DN_DEFAULT_PREFIX = "dn.default.prefix";
    final String DN_DEFAULT_REGEX = "dn.default.regex";
    final String DN_DEFAULT_STRIP_CHARACTERS = "dn.default.strip.chars";

    final String DN_OTHER_PREFIX = "dn.other.prefix";
    final String DN_OTHER_REGEX = "dn.other.regex";
    final String DN_OTHER_STRIP_CHARACTERS = "dn.other.strip.chars";

    final String OUTDIAL_VTEAM = "outdialVteam";

    // aps
    final String APS_URL = "apsUrl"; // desktop.properties
    final String APS_URL_FOR_ADA = "apsUrlForAda"; //From ADA properties

    final String PARAM_HELP_URL = "helpUrl";
    final String SUPERVISOR_ALERT_URL = "supervisorAlertUrl";
    final String AIMURL = "aimUrl";
    //final String COOKIEPREFIX = "cookiePrefix";
    final String FREE_FORM_SUPERVISOR_ALERT_ENABLED = "freeFormSupervisorAlertEnabled";
    final String UPDATE_TITLE_WITH_STATUS = "updateTitleWithStatus";
    //final String COOKIE_PERSISTENCE = "cookiePersistence";
    final String SEATMAP_URL = "seatmapUrl";
    final String UR_URL = "urUrl";
    final String SFDC_NAMESPACE= "sfdc.namespace";

    // CRMLite data post for LAR
    final String CRM_LITE_URL = "crmLiteUrl";
    final String EMAIL_ID = "emailId";
    final String KEY = "key";

    // Watson Analytics
    final String WATSON_ANALYTICS_BASE_URL = "watsonAnalyticsBaseUrl";
    final String WATSON_ANALYTICS_USER_NAME = "watsonAnalyticsUserName";
    final String WATSON_ANALYTICS_PASSWORD = "watsonAnalyticsPassword";
    
    // WFO
    final String WFO_URL = "wfoUrl"; // desktop.properties
    final String WFO_ENABLED = "wfoEnabled";
    
    // Campaign
    final String CAMPAIGN_ENABLED = "campaignEnabled"; // desktop.properties

	final String ICRM_ENABLED = "icrmEnabled";

}
