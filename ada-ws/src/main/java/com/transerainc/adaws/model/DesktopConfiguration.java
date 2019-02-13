package com.transerainc.adaws.model;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.transerainc.adaws.constants.AgentProfileConstants;
import com.transerainc.adaws.constants.AgentStateConstants;
import com.transerainc.adaws.constants.AppParams;
import com.transerainc.adaws.constants.ContextConstants;
import com.transerainc.adaws.constants.OmniChannelConstants;
import com.transerainc.adaws.model.cache.contact.call.CallContact;
import com.transerainc.adaws.model.cache.contact.chat.ChatContact;
import com.transerainc.adaws.model.cache.contact.email.EmailContact;
import com.transerainc.adaws.model.cache.contact.followup.FollowUpContact;
import com.transerainc.adaws.model.cache.icrm.IcrmResponse;
import com.transerainc.adaws.model.cache.loggedinagent.AgentLoggedInMessage;
import com.transerainc.adaws.model.cache.profile.MmProfile;
import com.transerainc.adaws.util.DnValidator;
import com.transerainc.adaws.util.ParsingUtils;
import com.transerainc.adaws.util.PropertiesUtil;
import com.transerainc.adaws.util.SpringContextHelper;
import com.transerainc.adaws.util.StringUtils;
import com.transerainc.adaws.util.ValidationConfiguration;

/**
 * Contains most of the info in agent-auth.xsd.
 * 
 * @author rajeev.lochanam
 */
public class DesktopConfiguration implements ContextConstants {

	private static Logger LOGGER = LoggerFactory.getLogger(DesktopConfiguration.class.getName());

	final boolean DEFAULT_SHOW_EMPTY_CAD = true;

	private String version = null;

	// parameters that are exposed through external API
	private Map<String, String> agentProperties;

	private Map<String, String> appParams;

	// deprecated. should be in agent profile
	private Map<String, String> idleMap;
	private final String defaultIdleId = null;
	private final String defaultIdleDesc = null;
	private AuxCode lastIdleAuxCode = null;
	// deprecated. should be in agent profile
	private Map<String, String> wrapUpMap;
	private final String defaultWrapUpId = null;
	private final String defaultWrapUpDesc = null;

	private Map<String, String> accessibleTeamMap;

	private CallDataConfiguration callDataConfig;

	private String prevState;
	private String agentSessionId;

	private AgentProfile agentProfile = null;
	private String stringifiedAgentProfileJSON = null;
	private ChannelCapability channelCapability = null;

	private String status;
	private String subStatus;
	private AdaRequest bufferedAdaRequest;

	private StateChangeData stateChangeData;
	private CallModel callModel;

	private Map<String, String> channelIdMap = null;

	private boolean positionSet;

	private PeerAgent peerAgentDetails;

	private boolean conferenceByThis = false;

	private boolean agentavailable = false;

	private boolean serviceRequested = false;
	private boolean isOutdialCall = false;
	private boolean isOutdialCallCheck = false; // added to check on wrapup state

	private DnValidator defaultDnValidator = null;
	private DnValidator otherDnValidator = null;

	private String routedCallId;

	private AdaResponse lastStateTriggered = null;
	private ConnectionStateModel connectionStateModel = null;

	private boolean hasRequestedDnTeamChange = false;

	private String campaignManagerUrl = null;

	private String omniChannelServerUrl = null;

	private MmProfile mmProfile = null;

	private IcrmResponse icrmResponse = null;

	private Map<Long, AgentLoggedInMessage> agentLoggedInMessages = null;

	private CallContact callContact = new CallContact();

	private Map<String, ChatContact> chatContacts = null;

	private Map<String, EmailContact> emailContacts = null;

	private Map<String, FollowUpContact> followUpContacts = null;

	private boolean omnichannelLoginPending = false;

	private AdaRequest pendingLoginAdaRequest = null;

	private boolean isConnectedConsultReserved = false;

	private Map<String, String> componentInformation = null;

	private boolean isIcrmEnabled = false;

	private String urUrl = null;
	
	public String getChannelId(String channelType) {
		return channelIdMap.get(channelType);
	}

	public DesktopConfiguration() {
		super();
		init();
	}

	public void init() {
		setStatus("LoggedOut");
		setSubStatus("Station");
		agentProperties = new HashMap<String, String>();
		accessibleTeamMap = new TreeMap<String, String>();
		callDataConfig = new CallDataConfiguration();

		appParams = new HashMap<String, String>();

		agentProfile = null;
		setPositionSet(false);
		stateChangeData = new StateChangeData();
		callModel = new CallModel();
		connectionStateModel = new ConnectionStateModel();
		agentLoggedInMessages = new Hashtable<Long, AgentLoggedInMessage>();
		chatContacts = new Hashtable<String, ChatContact>();
		emailContacts = new Hashtable<String, EmailContact>();
		followUpContacts = new Hashtable<String, FollowUpContact>();
		componentInformation = new Hashtable<String, String>();
		channelIdMap = new Hashtable<String, String>();
		isIcrmEnabled = Boolean
				.valueOf(SpringContextHelper.getBean(PropertiesUtil.class).getAdaProperty(AppParams.ICRM_ENABLED));
		LOGGER.info("isIcrmEnabled: {}", isIcrmEnabled);
		urUrl = SpringContextHelper.getBean(PropertiesUtil.class).getAdaProperty(AppParams.UR_URL);
	}

	public String getOutdialVteam() {
		final String pOutdialVteamStr = getAgentProfileProperty(AgentProfileConstants.OUTDIAL_VTEAM);
		final String outdialVteamStr = getAppParam(AppParams.OUTDIAL_VTEAM);
		final String outdialVteam = pOutdialVteamStr == null ? outdialVteamStr : pOutdialVteamStr;

		return outdialVteam;
	}

	/**
	 * @param newConfig
	 */
	public void merge(final DesktopConfiguration newConfig) {
		if (newConfig != null) {

			final String newSessionId = newConfig.getAgentSessionId();
			if (newSessionId != null) {
				setAgentSessionId(newSessionId);
			}

			agentProperties.putAll(newConfig.agentProperties);
			appParams.putAll(newConfig.appParams);

			if (!newConfig.accessibleTeamMap.isEmpty()) {
				accessibleTeamMap = newConfig.accessibleTeamMap;
			}

			callDataConfig.merge(newConfig.callDataConfig);

			agentProfile = newConfig.agentProfile;

		}
	}

	public String getWatsonAnalyticsBaseUrl() {
		return appParams.get(AppParams.WATSON_ANALYTICS_BASE_URL);
	}

	public String getWatsonAnalyticsUserName() {
		return appParams.get(AppParams.WATSON_ANALYTICS_USER_NAME);
	}

	public String getWatsonAnalyticsPassword() {
		return appParams.get(AppParams.WATSON_ANALYTICS_PASSWORD);
	}

	public boolean hasWatsonAnalytics() {
		final String watsonAnalyticsBaseUrl = getWatsonAnalyticsBaseUrl();
		if (org.apache.commons.lang3.StringUtils.isNotBlank(watsonAnalyticsBaseUrl)) {
			return true;
		}
		return false;
	}

	/**
	 * @return
	 */
	public String getVersion() {
		return version;
	}

	public String getPrevState() {
		return prevState;
	}

	public void setPrevState(String prevState) {
		this.prevState = prevState;
	}

	public void addAppParam(final String key, final String value) {
		appParams.put(key, value);
	}

	public String getAgentId() {
		return agentProperties.get(PARAM_AGENT_ID);
	}

	public String getEnterpriseId() {
		return agentProperties.get(PARAM_ENTERPRISE_ID);
	}

	public String getSiteId() {
		return agentProperties.get(PARAM_SITE_ID);
	}

	public String getTeamId() {
		return agentProperties.get(PARAM_TEAM_ID);
	}

	public void setAgentName(final String agentName) {
		agentProperties.put(PARAM_USER_REALNAME, agentName);
	}

	public String getAgentName() {
		String s = agentProperties.get(PARAM_USER_REALNAME);
		s = StringUtils.isEmpty(s) ? getUserName() : s;
		return StringUtils.isEmpty(s) ? "" : s;
	}

	public void setAgentId(final String agentId) {
		agentProperties.put(PARAM_AGENT_ID, agentId);
	}

	public void setDn(final String dn) {
		agentProperties.put(PARAM_DN, dn);
	}

	public String getDn() {
		return agentProperties.get(PARAM_DN);
	}

	public void setDefaultDn(final String defaultDn) {
		agentProperties.put(PARAM_DEFAULT_DN, defaultDn);
	}

	public String getDefaultDn() {
		return agentProperties.get(PARAM_DEFAULT_DN);
	}

	public void setEnterpriseId(final String enterpriseId) {
		agentProperties.put(PARAM_ENTERPRISE_ID, enterpriseId);
	}

	public void setSiteId(final String siteId) {
		agentProperties.put(PARAM_SITE_ID, siteId);
	}

	public void setSiteName(final String siteName) {
		agentProperties.put(PARAM_SITE_NAME, siteName);
	}

	public void setTeamId(final String teamId) {
		if (teamId == null) {
			return;
		}

		agentProperties.put(PARAM_TEAM_ID, teamId);

		final String teamName = accessibleTeamMap.get(teamId);
		if (teamName != null) {
			agentProperties.put(PARAM_TEAM_NAME, teamName);
		}
	}

	public String getAgentSessionId() {
		return agentSessionId;
	}

	public void setAgentSessionId(final String id) {
		agentSessionId = id;
	}

	public Map<String, String> getAccessibleTeamMap() {
		return accessibleTeamMap;
	}

	public void setAccessibleTeamMap(final Map<String, String> accessibleTeamMap) {
		this.accessibleTeamMap = accessibleTeamMap;
	}

	public String getUserName() {
		return agentProperties.get(PARAM_USERNAME);
	}

	public void setUserName(final String userName) {
		agentProperties.put(PARAM_USERNAME, userName);
	}

	public String getEnterpriseName() {
		return agentProperties.get(PARAM_ENTERPRISE_NAME);
	}

	public void setEnterpriseName(final String enterpriseName) {
		agentProperties.put(PARAM_ENTERPRISE_NAME, enterpriseName);
	}

	public String getTeamName() {
		return agentProperties.get(PARAM_TEAM_NAME);
	}

	public void setTeamName(final String teamName) {
		agentProperties.put(PARAM_TEAM_NAME, teamName);
	}

	public CallDataConfiguration getCallDataConfig() {
		return callDataConfig;
	}

	public String getBaseUrl() {
		return agentProperties.get(PARAM_BASE_URL);
	}

	public void setBaseUrl(String baseUrl) {
		baseUrl = baseUrl == null ? "" : baseUrl;
		agentProperties.put(PARAM_BASE_URL, baseUrl);
	}

	public String getTeamIdsCSV() {
		return agentProperties.get(PARAM_TEAM_IDS_CSV);
	}

	public void setTeamIdsCSV(final String teamIdsCSV) {
		agentProperties.put(PARAM_TEAM_IDS_CSV, teamIdsCSV);
	}

	public String getTeamNamesCSV() {
		return agentProperties.get(PARAM_TEAM_NAMES_CSV);
	}

	public void setTeamNamesCSV(final String teamNamesCSV) {
		agentProperties.put(PARAM_TEAM_NAMES_CSV, teamNamesCSV);
	}

	public Map<String, String> getProperties() {
		// return a clone of the properties.
		final Map<String, String> props = new HashMap<String, String>();
		props.putAll(appParams);
		props.putAll(agentProperties);

		return props;
	}

	private String getAppParam(final String key) {
		String result = "";
		final Map<String, String> props = getProperties();
		if (props != null && !props.isEmpty() && props.containsKey(key)) {
			result = props.get(key);
		}

		return result;
	}

	public String getCodeName(final String auxCodeType, final String codeId) {
		String codeName = null;

		if (agentProfile != null) {
			String type = AgentProfileConstants.IDLE_CODE;
			if (AuxCode.TYPE_WRAPUP.equals(auxCodeType)) {
				type = AgentProfileConstants.WRAPUP_CODE;
			}
			final Map<String, String> pMap = agentProfile.getEntityList(type);
			codeName = pMap.get(codeId);
		} else {
			if (AuxCode.TYPE_IDLE.equals(auxCodeType)) {
				return idleMap.get(codeId);
			} else if (AuxCode.TYPE_WRAPUP.equals(auxCodeType)) {
				return wrapUpMap.get(codeId);
			}
		}

		return codeName;
	}

	private String getDefaultCodeId(String type, String defaultIdIfNotPresent) {
		String id = defaultIdIfNotPresent;
		if (agentProfile != null) {
			final Map<String, String> pIdleMap = agentProfile.getEntityList(type);
			if (pIdleMap != null && !pIdleMap.isEmpty()) {
				id = pIdleMap.keySet().iterator().next();
			}
		}
		return id;
	}

	private String getDefaultCodeDesc(String type, String defaultDescIfNotPresent) {
		String desc = defaultDescIfNotPresent;
		if (agentProfile != null) {
			final Map<String, String> pIdleMap = agentProfile.getEntityList(type);
			if (pIdleMap != null && !pIdleMap.isEmpty()) {
				final String key = pIdleMap.keySet().iterator().next();
				desc = pIdleMap.get(key);
			}
		}
		return desc;
	}

	public String getDefaultIdleId() {
		return getDefaultCodeId(AgentProfileConstants.IDLE_CODE, defaultIdleId);
	}

	public String getDefaultIdleDesc() {
		return getDefaultCodeDesc(AgentProfileConstants.IDLE_CODE, defaultIdleDesc);
	}

	public String getDefaultWrapUpId() {
		return getDefaultCodeId(AgentProfileConstants.WRAPUP_CODE, defaultWrapUpId);
	}

	public String getDefaultWrapUpDesc() {
		return getDefaultCodeDesc(AgentProfileConstants.WRAPUP_CODE, defaultWrapUpDesc);
	}

	public AuxCode getDefaultIdleAuxCode() {
		return new AuxCode(AuxCode.TYPE_IDLE, getDefaultIdleId(), getDefaultIdleDesc());
	}

	public AuxCode getDefaultWrapUpAuxCode() {
		return new AuxCode(AuxCode.TYPE_WRAPUP, getDefaultWrapUpId(), getDefaultWrapUpDesc());
	}

	public String getIdleAuxCodeDescription() {
		return getDefaultCodeDesc(AgentProfileConstants.IDLE_CODE, defaultIdleDesc);
	}

	public void setAgentProfile(final AgentProfile profile) {
		agentProfile = profile;
		// if null, is clearing the idle and wrapup variables necessary
	}

	public AgentProfile getAgentProfile() {
		return agentProfile;
	}

	/**
	 * @return the stringifiedAgentProfileJSON
	 */
	public String getStringifiedAgentProfileJSON() {
		return stringifiedAgentProfileJSON;
	}

	/**
	 * @param stringifiedAgentProfileJSON
	 *            the stringifiedAgentProfileJSON to set
	 */
	public void setStringifiedAgentProfileJSON(String stringifiedAgentProfileJSON) {
		this.stringifiedAgentProfileJSON = stringifiedAgentProfileJSON;
	}

	public ChannelCapability getChannelCapability() {
		return this.channelCapability;
	}

	public void setChannelCapability(ChannelCapability channelCapability) {
		this.channelCapability = channelCapability;
	}

	public String getAgentProfileProperty(final String name) {
		String prop = null;
		if (agentProfile != null) {
			prop = agentProfile.getAttribute(name);
		}
		return prop;
	}

	public void postInit() {
		final String denyFirstStr = appParams.get(AppParams.CAD_DENY_FIRST);
		if (denyFirstStr != null) {
			final boolean denyFirst = StringUtils.getBoolean(denyFirstStr);
			callDataConfig.setDenyFirst(denyFirst);
		}

		boolean showEmpty = DEFAULT_SHOW_EMPTY_CAD;
		final String showEmptyStr = appParams.get(AppParams.CAD_SHOW_EMPTY);
		if (showEmptyStr != null) {
			showEmpty = StringUtils.getBoolean(showEmptyStr);
		}
		callDataConfig.setShowEmpty(showEmpty);

		final String suppressedCsv = appParams.get(AppParams.CAD_SUPPRESSED_KEYS);
		if (suppressedCsv != null) {
			final List<String> suppressedKeys = ParsingUtils.getListFromCSV(suppressedCsv);
			for (final String key : suppressedKeys) {
				callDataConfig.addSuppressedKey(key);
			}
		}

		final String allowedCsv = appParams.get(AppParams.CAD_ALLOWED_KEYS);
		if (allowedCsv != null) {
			final List<String> allowedKeys = ParsingUtils.getListFromCSV(allowedCsv);
			for (final String key : allowedKeys) {
				callDataConfig.addAllowedKey(key);
			}
		}

		final String labelNamesCsv = appParams.get(AppParams.CAD_TRANSLATION);
		if (labelNamesCsv != null) {
			callDataConfig.setLabelNamesCsv(labelNamesCsv);
		}
	}

	public void setProtocolVersion(final String version) {
		this.version = version;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(final String status) {
		if (AgentStateConstants.STATE_LOGOUT.equals(status)) {
			setAgentavailable(false);
		}

		this.status = status;
	}

	public String getSubStatus() {
		return subStatus;
	}

	public void setSubStatus(final String subStatus) {
		if (AgentStateConstants.SUBSTATE_AVAILABLE.equals(subStatus)) {
			setAgentavailable(true);
		} else if (AgentStateConstants.SUBSTATE_IDLE.equals(subStatus)) {
			setAgentavailable(false);
		}

		this.subStatus = subStatus;
	}

	/**
	 * @return the bufferedAdaRequest
	 */
	public AdaRequest getBufferedAdaRequest() {
		return bufferedAdaRequest;
	}

	/**
	 * @param bufferedAdaRequest
	 *            the bufferedAdaRequest to set
	 */
	public void setBufferedAdaRequest(AdaRequest bufferedAdaRequest) {
		this.bufferedAdaRequest = bufferedAdaRequest;
	}

	public void resetBufferedAdaRequest() {
		this.bufferedAdaRequest = null;
	}

	public StateChangeData getStateChangeData() {
		return stateChangeData;
	}

	public CallModel getCallModel() {
		return callModel;
	}

	/**
	 * @return
	 */
	public boolean hasReason() {
		return stateChangeData.getReason() != null;
	}

	/**
	 * @return
	 */
	public boolean hasCallId() {
		return stateChangeData.getCallId() != null;
	}

	/**
	 * @return
	 */
	public boolean hasRetry() {
		return stateChangeData.getRetry() != null;
	}

	/**
	 * @param id
	 */
	public void setChannelId(final String channelType, final String id) {
		channelIdMap.put(channelType, id);
	}

	public boolean isPositionSet() {
		return positionSet;
	}

	public void setPositionSet(final boolean positionSet) {
		this.positionSet = positionSet;
	}

	/**
	 * @return the lastIdleAuxCode
	 */
	public AuxCode getLastIdleAuxCode() {
		return lastIdleAuxCode;
	}

	/**
	 * @param lastIdleAuxCode
	 *            the lastIdleAuxCode to set
	 */
	public void setLastIdleAuxCode(final AuxCode lastIdleAuxCode) {
		this.lastIdleAuxCode = lastIdleAuxCode;
	}

	/**
	 * @return the peerAgentDetails
	 */
	public PeerAgent getPeerAgentDetails() {
		return peerAgentDetails;
	}

	/**
	 * @param peerAgentDetails
	 *            the peerAgentDetails to set
	 */
	public void setPeerAgentDetails(final PeerAgent peerAgentDetails) {
		this.peerAgentDetails = peerAgentDetails;
	}

	/**
	 * @return the conferenceByMe
	 */
	public boolean isConferenceByThis() {
		return conferenceByThis;
	}

	/**
	 * @param conferenceByMe
	 *            the conferenceByMe to set
	 */
	public void setConferenceByThis(final boolean conferenceByMe) {
		conferenceByThis = conferenceByMe;
	}

	public void reset() {
		conferenceByThis = false;
		peerAgentDetails = null;
		serviceRequested = false;
		setOutdialCall(false);
		routedCallId = null;
		if (getCallModel() != null) {
			getCallModel().setConferencing(false);
			getCallModel().setHoldEnabled(false);
			getCallModel().setConsulting(false);
			getCallModel().setCtqCancel(false);
		}
	}

	public String getValue(final String name) {
		String s = getAgentProfileProperty(name);
		if (s == null) {
			s = agentProperties.get(name);
			if (s == null) {
				s = appParams.get(name);
			}
		}

		if (s == null) {
			s = "";
		}
		return s;
	}

	/**
	 * @return the agentavailable
	 */
	public boolean isAgentavailable() {
		return agentavailable;
	}

	/**
	 * @param agentavailable
	 *            the agentavailable to set
	 */
	public void setAgentavailable(final boolean agentavailable) {
		this.agentavailable = agentavailable;
	}

	/**
	 * @return the serviceRequested
	 */
	public boolean isServiceRequested() {
		return serviceRequested;
	}

	/**
	 * @param serviceRequested
	 *            the serviceRequested to set
	 */
	public void setServiceRequested(final boolean serviceRequested) {
		this.serviceRequested = serviceRequested;
	}

	public DnValidator getDefaultDnValidator() {
		if (defaultDnValidator == null) {
			defaultDnValidator = new DnValidator();

			final String regex = appParams.get(AppParams.DN_DEFAULT_REGEX);
			if (regex != null) {
				// read from the desktopConfiguration xml first
				defaultDnValidator.setRegex(regex);
				defaultDnValidator.setPrefix(appParams.get(AppParams.DN_DEFAULT_PREFIX));
				defaultDnValidator.setStripCharacters(appParams.get(AppParams.DN_DEFAULT_STRIP_CHARACTERS));
			} else {
				// otherwise get it from the app configuration
				final ValidationConfiguration vc = ValidationConfiguration.getInstance();
				defaultDnValidator.setRegex(vc.getProperty(AppParams.DN_DEFAULT_REGEX));
				defaultDnValidator.setPrefix(vc.getProperty(AppParams.DN_DEFAULT_PREFIX));
				defaultDnValidator.setStripCharacters(vc.getProperty(AppParams.DN_DEFAULT_STRIP_CHARACTERS));
			}
		}
		return defaultDnValidator;
	}

	public DnValidator getOtherDnValidator() {
		if (otherDnValidator == null) {
			otherDnValidator = new DnValidator();

			final String regex = appParams.get(AppParams.DN_OTHER_REGEX);
			if (regex != null) {
				// read from the desktopConfiguration xml first
				otherDnValidator.setRegex(regex);
				otherDnValidator.setPrefix(appParams.get(AppParams.DN_OTHER_PREFIX));
				otherDnValidator.setStripCharacters(appParams.get(AppParams.DN_OTHER_STRIP_CHARACTERS));
			} else {
				// otherwise get it from the app configuration
				final ValidationConfiguration vc = ValidationConfiguration.getInstance();
				otherDnValidator.setRegex(vc.getProperty(AppParams.DN_OTHER_REGEX));
				otherDnValidator.setPrefix(vc.getProperty(AppParams.DN_OTHER_PREFIX));
				otherDnValidator.setStripCharacters(vc.getProperty(AppParams.DN_OTHER_STRIP_CHARACTERS));
			}
		}
		return otherDnValidator;
	}

	/**
	 * @return the isOutdialCall
	 */
	public boolean isOutdialCall() {
		return isOutdialCall;
	}

	/**
	 * @param isOutdialCall
	 *            the isOutdialCall to set
	 */
	public void setOutdialCall(final boolean isOutdialCall) {
		this.isOutdialCall = isOutdialCall;
	}

	/**
	 * @return the routedCallId
	 */
	public String getRoutedCallId() {
		return routedCallId;
	}

	/**
	 * @param routedCallId
	 *            the routedCallId to set
	 */
	public void setRoutedCallId(final String routedCallId) {
		this.routedCallId = routedCallId;
	}

	/**
	 * @return the lastStateTriggered
	 */
	public AdaResponse getLastStateTriggered() {
		return lastStateTriggered;
	}

	/**
	 * @param lastStateTriggered
	 *            the lastStateTriggered to set
	 */
	public void setLastStateTriggered(final AdaResponse lastStateTriggered) {
		this.lastStateTriggered = lastStateTriggered;
	}

	/**
	 * @return the connectionStateModel
	 */
	public ConnectionStateModel getConnectionStateModel() {
		return connectionStateModel;
	}

	/**
	 * @return the hasRequestedDnTeamChange
	 */
	public boolean getHasRequestedDnTeamChange() {
		return hasRequestedDnTeamChange;
	}

	/**
	 * @param hasRequestedDnTeamChange
	 *            the hasRequestedDnTeamChange to set
	 */
	public void setHasRequestedDnTeamChange(boolean requestedDnTeamChange) {
		this.hasRequestedDnTeamChange = requestedDnTeamChange;
	}

	public void resetHasRequestedDnTeamChange() {
		setHasRequestedDnTeamChange(false);
	}

	public String getWfoUrl() {
		return appParams.get(AppParams.WFO_URL);
	}

	public void setWfoUrl(String str) {
		appParams.put(AppParams.WFO_URL, str);
	}

	public void setWfoEnabled(String tof) {
		appParams.put(AppParams.WFO_ENABLED, tof);
	}

	public String isWfoEnabled() {
		return appParams.get(AppParams.WFO_ENABLED);
	}

	/**
	 * @return the campaignManagerUrl
	 */
	public String getCampaignManagerUrl() {
		return campaignManagerUrl;
	}

	/**
	 * @param campaignManagerUrl
	 *            the campaignManagerUrl to set
	 */
	public void setCampaignManagerUrl(String campaignManagerUrl) {
		this.campaignManagerUrl = campaignManagerUrl;
	}

	public void setCampaignEnabled(String tof) {
		appParams.put(AppParams.CAMPAIGN_ENABLED, tof);
	}

	public String isCampaignEnabled() {
		return appParams.get(AppParams.CAMPAIGN_ENABLED);
	}

	public String getOmniChannelServerUrl() {
		return omniChannelServerUrl;
	}

	public void setOmniChannelServerUrl(String omniChannelServerUrl) {
		this.omniChannelServerUrl = omniChannelServerUrl;
	}

	public String getOmniChannelUrl() {
		return omniChannelServerUrl + OmniChannelConstants.MIM_PATH;
	}

	public String getOmniChannelFileServerUrl() {
		return omniChannelServerUrl + OmniChannelConstants.MIM_FILE_UPLOAD_PATH;
	}

	/**
	 * @return the mmProfile
	 */
	public MmProfile getMmProfile() {
		return mmProfile;
	}

	/**
	 * @param mmProfile
	 *            the mmProfile to set
	 */
	public void setMmProfile(MmProfile mmProfile) {
		this.mmProfile = mmProfile;
	}

	/**
	 * @return the icrmResponse
	 */
	public IcrmResponse getIcrmResponse() {
		return icrmResponse;
	}

	/**
	 * @param icrmResponse
	 *            the icrmResponse to set
	 */
	public void setIcrmResponse(IcrmResponse icrmResponse) {
		this.icrmResponse = icrmResponse;
	}

	public void addAgentLoggedMessage(AgentLoggedInMessage agentLoggedInMessage) {
		agentLoggedInMessages.put(agentLoggedInMessage.getMmResponse().getResponseData().getChannelId(),
				agentLoggedInMessage);
	}

	public void removeAgentLoggedMessage(AgentLoggedInMessage agentLoggedInMessage) {
		agentLoggedInMessages.remove(agentLoggedInMessage.getMmResponse().getResponseData().getChannelId());
	}

	public void removeAgentLoggedMessage(Long channelId) {
		agentLoggedInMessages.remove(channelId);
	}

	/**
	 * @return the agentLoggedInMessages
	 */
	public AgentLoggedInMessage[] getAgentLoggedInMessages() {
		return agentLoggedInMessages.values().toArray(new AgentLoggedInMessage[0]);
	}

	public void clearAgentLoggedInMessages() {
		agentLoggedInMessages.clear();
	}

	public void addChatContact(ChatContact chatContact) {
		chatContacts.put(chatContact.getContactDetails().getCduId(), chatContact);
	}

	public void removeChatContact(String cduId) {
		chatContacts.remove(cduId);
	}

	public void removeChatContact(ChatContact chatContact) {
		chatContacts.remove(chatContact.getContactDetails().getCduId());
	}

	public void clearChatContacts() {
		chatContacts.clear();
	}

	public ChatContact[] getChatContacts() {
		return chatContacts.values().toArray(new ChatContact[0]);
	}

	public ChatContact getChatContact(String cduId) {
		return chatContacts.get(cduId);
	}

	public void addEmailContact(EmailContact emailContact) {
		emailContacts.put(emailContact.getContactDetails().getCduId(), emailContact);
	}

	public void removeEmailContact(String cduId) {
		emailContacts.remove(cduId);
	}

	public void removeEmailContact(EmailContact emailContact) {
		emailContacts.remove(emailContact.getContactDetails().getCduId());
	}

	public void clearEmailContacts() {
		emailContacts.clear();
	}

	public EmailContact[] getEmailContacts() {
		return emailContacts.values().toArray(new EmailContact[0]);
	}

	public EmailContact getEmailContact(String cduId) {
		return emailContacts.get(cduId);
	}

	/**
	 * @return the callContact
	 */
	public CallContact getCallContact() {
		return callContact;
	}

	/**
	 * @param callContact
	 *            the callContact to set
	 */
	public void setCallContact(CallContact callContact) {
		this.callContact = callContact;
	}

	public boolean isOmnichannelLoginPending() {
		return omnichannelLoginPending;
	}

	public void setOmnichannelLoginPending(boolean omnichannelLoginPending) {
		this.omnichannelLoginPending = omnichannelLoginPending;
	}

	public AdaRequest getPendingLoginAdaRequest() {
		return pendingLoginAdaRequest;
	}

	public void setPendingLoginAdaRequest(AdaRequest pendingLoginAdaRequest) {
		this.pendingLoginAdaRequest = pendingLoginAdaRequest;
	}

	public void addFollowUpContact(FollowUpContact followUpContact) {
		followUpContacts.put(followUpContact.getFollowUpDetails().getCduId(), followUpContact);
	}

	public void removeFollowUpContact(String cduId) {
		followUpContacts.remove(cduId);
	}

	public void removeFollowUpContact(FollowUpContact followUpContact) {
		followUpContacts.remove(followUpContact.getFollowUpDetails().getCduId());
	}

	public void clearFollowUpContacts() {
		followUpContacts.clear();
	}

	public FollowUpContact[] getFollowUpContacts() {
		return followUpContacts.values().toArray(new FollowUpContact[0]);
	}

	public FollowUpContact getFollowUpContact(String cduId) {
		return followUpContacts.get(cduId);
	}

	public boolean isConnectedConsultReserved() {
		return isConnectedConsultReserved;
	}

	public void setConnectedConsultReserved(boolean isConnectedConsultReserved) {
		this.isConnectedConsultReserved = isConnectedConsultReserved;
	}

	/**
	 * @return the componentInformation
	 */
	public Map<String, String> getComponentInformation() {
		return componentInformation;
	}

	/**
	 * @param componentInformation
	 *            the componentInformation to set
	 */
	public void setComponentInformation(String componentType, String componentInformation) {
		this.componentInformation.put(componentType, componentInformation);
	}

	/**
	 * @return the isOutdialCallCheck
	 */
	public boolean isOutdialCallCheck() {
		return isOutdialCallCheck;
	}

	/**
	 * @param isOutdialCallCheck
	 *            the isOutdialCallCheck to set
	 */
	public void setOutdialCallCheck(final boolean isOutdialCallCheck) {
		this.isOutdialCallCheck = isOutdialCallCheck;
	}

	public boolean isIcrmEnabled() {
		return isIcrmEnabled;
	}

	public String geturUrl() {
		return urUrl;
	}
}
