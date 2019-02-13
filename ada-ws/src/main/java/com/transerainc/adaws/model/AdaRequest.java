package com.transerainc.adaws.model;

public class AdaRequest {

	private String redirectApi;
	private String isStationLogin;
	private String userName;
	private String password;
	private String tenant;
	private String dn;
	private String teamId;
	private String usesOtherDn;
	private String state;
	private String auxCodeIdArray;
	private String wrapUpAuxCodeId;
	private String idleAuxCodeId;
	private String updatedCadJson;
	private String agentSessionId;
	private String callType;
	private String holdFlag;
	private String targetType;
	private String targetId;
	private String logoutReason;
	private String outDialAni;
	private String profileAniId;
	private String lcmContact;

	private String reloadApi;
	private String uiAgentState;
	private String supervisorMessage;
	private String reloadRequestString;
	private boolean passwordEncrypted = false;
	private boolean reAuthenticate = false;
	private String reloadWaitTime = null;
	private String isAutoStationLogin = "false";
	private boolean doLar = false;
	private String pingC =null;
	// private String dnTargetedConsult;

	//icrm
	private String chatUrl;
	private String icrmSessionId;
	private String idleCodeIds;
	private String idleCodeNames;
	private String wrapUpCodeIds;
	private String wrapCodeNames;
	private String isSysCodes;
	
	// OmniChannel data portion
	private MmRequest mmRequest;
	
	// Analyzer
	private String ani;
	private String transcriptId;
	private long startTime;
	private long endTime;
	private String consultTime;
	private String contactId;
	private String contactType;
	private String consultingType;
	private String ucContact;

	private String componentType;

	/**
	 * @return the callType
	 */
	public String getCallType() {
		return callType;
	}

	/**
	 * @param callType
	 *            the callType to set
	 */
	public void setCallType(final String callType) {
		this.callType = callType;
	}

	/**
	 * @return the holdFlag
	 */
	public String getHoldFlag() {
		return holdFlag;
	}

	/**
	 * @param holdFlag
	 *            the holdFlag to set
	 */
	public void setHoldFlag(final String holdFlag) {
		this.holdFlag = holdFlag;
	}

	/**
	 * @return the redirectApi
	 */
	public String getRedirectApi() {
		return redirectApi;
	}

	/**
	 * @param redirectApi
	 *            the redirectApi to set
	 */
	public void setRedirectApi(final String redirectApi) {
		this.redirectApi = redirectApi;
	}

	/**
	 * @return the isStationLogin
	 */
	public String getIsStationLogin() {
		return isStationLogin;
	}

	/**
	 * @param isStationLogin
	 *            the isStationLogin to set
	 */
	public void setIsStationLogin(final String isStationLogin) {
		this.isStationLogin = isStationLogin;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName
	 *            the userName to set
	 */
	public void setUserName(final String userName) {
		this.userName = userName;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(final String password) {
		this.password = password;
	}

	/**
	 * @return the tenant
	 */
	public String getTenant() {
		return tenant;
	}

	/**
	 * @param tenant
	 *            the tenant to set
	 */
	public void setTenant(final String tenant) {
		this.tenant = tenant;
	}

	/**
	 * @return the dn
	 */
	public String getDn() {
		return dn;
	}

	/**
	 * @param dn
	 *            the dn to set
	 */
	public void setDn(final String dn) {
		this.dn = dn;
	}

	/**
	 * @return the teamId
	 */
	public String getTeamId() {
		return teamId;
	}

	/**
	 * @param teamId
	 *            the teamId to set
	 */
	public void setTeamId(final String teamId) {
		this.teamId = teamId;
	}

	/**
	 * @return the usesOtherDn
	 */
	public String getUsesOtherDn() {
		return usesOtherDn;
	}

	/**
	 * @param usesOtherDn
	 *            the usesOtherDn to set
	 */
	public void setUsesOtherDn(final String usesOtherDn) {
		this.usesOtherDn = usesOtherDn;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state
	 *            the state to set
	 */
	public void setState(final String state) {
		this.state = state;
	}

	/**
	 * @return the auxCodeIdArray
	 */
	public String getAuxCodeIdArray() {
		return auxCodeIdArray;
	}

	/**
	 * @param auxCodeIdArray
	 *            the auxCodeIdArray to set
	 */
	public void setAuxCodeIdArray(final String auxCodeIdArray) {
		this.auxCodeIdArray = auxCodeIdArray;
	}

	/**
	 * @return the wrapUpAuxCodeId
	 */
	public String getWrapUpAuxCodeId() {
		return wrapUpAuxCodeId;
	}

	/**
	 * @param wrapUpAuxCodeId
	 *            the wrapUpAuxCodeId to set
	 */
	public void setWrapUpAuxCodeId(final String wrapUpAuxCodeId) {
		this.wrapUpAuxCodeId = wrapUpAuxCodeId;
	}

	/**
	 * @return the idleAuxCodeId
	 */
	public String getIdleAuxCodeId() {
		return idleAuxCodeId;
	}

	/**
	 * @param idleAuxCodeId
	 *            the idleAuxCodeId to set
	 */
	public void setIdleAuxCodeId(final String idleAuxCodeId) {
		this.idleAuxCodeId = idleAuxCodeId;
	}

	/**
	 * @return the updatedCadJson
	 */
	public String getUpdatedCadJson() {
		return updatedCadJson;
	}

	/**
	 * @param updatedCadJson
	 *            the updatedCadJson to set
	 */
	public void setUpdatedCadJson(final String updatedCadJson) {
		this.updatedCadJson = updatedCadJson;
	}

	/**
	 * @return the agentSessionId
	 */
	public String getagentSessionId() {
		return agentSessionId;
	}

	/**
	 * @param agentSessionId
	 *            the agentSessionId to set
	 */
	public void setagentSessionId(final String agentSessionId) {
		this.agentSessionId = agentSessionId;
	}

	/**
	 * @return the logoutReason
	 */
	public String getLogoutReason() {
		return logoutReason;
	}

	/**
	 * @param logoutReason
	 *            the logoutReason to set
	 */
	public void setLogoutReason(final String logoutReason) {
		this.logoutReason = logoutReason;
	}

	// /**
	// * @return the dnTargetedConsult
	// */
	// public String getDnTargetedConsult() {
	// return dnTargetedConsult;
	// }
	//
	// /**
	// * @param dnTargetedConsult the dnTargetedConsult to set
	// */
	// public void setDnTargetedConsult(String dnTargetedConsult) {
	// this.dnTargetedConsult = dnTargetedConsult;
	// }

	/**
	 * @return the targetId
	 */
	public String getTargetId() {
		return targetId;
	}

	/**
	 * @param targetId
	 *            the targetId to set
	 */
	public void setTargetId(final String targetId) {
		this.targetId = targetId;
	}

	/**
	 * @return the targetType
	 */
	public String getTargetType() {
		return targetType;
	}

	/**
	 * @param targetType
	 *            the targetType to set
	 */
	public void setTargetType(final String targetType) {
		this.targetType = targetType;
	}

	/**
	 * @return the jsonReloadString
	 */
	public String getReloadRequestString() {
		return reloadRequestString;
	}

	/**
	 * @param jsonReloadString
	 *            the jsonReloadString to set
	 */
	public void setReloadRequestString(final String reloadRequestString) {
		this.reloadRequestString = reloadRequestString;
	}

	/**
	 * @return the reloadApi
	 */
	public String getReloadApi() {
		return reloadApi;
	}

	/**
	 * @param reloadApi
	 *            the reloadApi to set
	 */
	public void setReloadApi(final String reloadApi) {
		this.reloadApi = reloadApi;
	}

	/**
	 * @return the supervisorMessage
	 */
	public String getSupervisorMessage() {
		return supervisorMessage;
	}

	/**
	 * @param supervisorMessage
	 *            the supervisorMessage to set
	 */
	public void setSupervisorMessage(final String supervisorMessage) {
		this.supervisorMessage = supervisorMessage;
	}

	/**
	 * @return the passwordEncrypted
	 */
	public boolean isPasswordEncrypted() {
		return passwordEncrypted;
	}

	/**
	 * @param passwordEncrypted
	 *            the passwordEncrypted to set
	 */
	public void setPasswordEncrypted(final boolean passwordEncrypted) {
		this.passwordEncrypted = passwordEncrypted;
	}

	/**
	 * @return the reAuthenticate
	 */
	public boolean isReAuthenticate() {
		return reAuthenticate;
	}

	/**
	 * @param reAuthenticate
	 *            the reAuthenticate to set
	 */
	public void setReAuthenticate(final boolean reAuthenticate) {
		this.reAuthenticate = reAuthenticate;
	}

	/**
	 * @return the reloadWaitTime
	 */
	public String getReloadWaitTime() {
		return reloadWaitTime;
	}

	/**
	 * @param reloadWaitTime
	 *            the reloadWaitTime to set
	 */
	public void setReloadWaitTime(final String reloadWaitTime) {
		this.reloadWaitTime = reloadWaitTime;
	}

	/**
	 * @return the uiAgentState
	 */
	public String getUiAgentState() {
		return uiAgentState;
	}

	/**
	 * @param uiAgentState
	 *            the uiAgentState to set
	 */
	public void setUiAgentState(final String uiAgentState) {
		this.uiAgentState = uiAgentState;
	}

	/**
	 * @return the profileAniId
	 */
	public String getProfileAniId() {
		return profileAniId;
	}

	/**
	 * @param profileAniId
	 *            the profileAniId to set
	 */
	public void setProfileAniId(final String profileAniId) {
		this.profileAniId = profileAniId;
	}

	/**
	 * @return the outDialAni
	 */
	public String getOutDialAni() {
		return outDialAni;
	}

	/**
	 * @param outDialAni
	 *            the outDialAni to set
	 */
	public void setOutDialAni(final String outDialAni) {
		this.outDialAni = outDialAni;
	}

	public String getLcmContact() {
		return lcmContact;
	}

	public void setLcmContact(String lcmContact) {
		this.lcmContact = lcmContact;
	}

	/**
	 * @return the doLar
	 */
	public boolean isDoLar() {
		return doLar;
	}

	/**
	 * @param doLar
	 *            the doLar to set
	 */
	public void setDoLar(final boolean doLar) {
		this.doLar = doLar;
	}

	public String getPingC() {
		return pingC;
	}

	public void setPingC(String pingC) {
		this.pingC = pingC;
	}
	
	//icrm changes

	/**
	 * @return the chatUrl
	 */
	public String getChatUrl() {
		return chatUrl;
	}

	/**
	 * @param chatUrl the chatUrl to set
	 */
	public void setChatUrl(String chatUrl) {
		this.chatUrl = chatUrl;
	}

	/**
	 * @return the icrmSessionId
	 */
	public String getIcrmSessionId() {
		return icrmSessionId;
	}

	/**
	 * @param icrmSessionId the icrmSessionId to set
	 */
	public void setIcrmSessionId(String icrmSessionId) {
		this.icrmSessionId = icrmSessionId;
	}

	/**
	 * @return the idleCodeIds
	 */
	public String getIdleCodeIds() {
		return idleCodeIds;
	}

	/**
	 * @param idleCodeIds the idleCodeIds to set
	 */
	public void setIdleCodeIds(String idleCodeIds) {
		this.idleCodeIds = idleCodeIds;
	}

	/**
	 * @return the idleCodeNames
	 */
	public String getIdleCodeNames() {
		return idleCodeNames;
	}

	/**
	 * @param idleCodeNames the idleCodeNames to set
	 */
	public void setIdleCodeNames(String idleCodeNames) {
		this.idleCodeNames = idleCodeNames;
	}

	/**
	 * @return the wrapUpCodeIds
	 */
	public String getWrapUpCodeIds() {
		return wrapUpCodeIds;
	}

	/**
	 * @param wrapUpCodeIds the wrapUpCodeIds to set
	 */
	public void setWrapUpCodeIds(String wrapUpCodeIds) {
		this.wrapUpCodeIds = wrapUpCodeIds;
	}

	/**
	 * @return the wrapCodeNames
	 */
	public String getWrapCodeNames() {
		return wrapCodeNames;
	}

	/**
	 * @param wrapCodeNames the wrapCodeNames to set
	 */
	public void setWrapCodeNames(String wrapCodeNames) {
		this.wrapCodeNames = wrapCodeNames;
	}

	public String getIsSysCodes() {
		return isSysCodes;
	}

	public void setIsSysCodes(String isSysCodes) {
		this.isSysCodes = isSysCodes;
	}

	/**
	 * @return the mmRequest
	 */
	public MmRequest getMmRequest() {
		return mmRequest;
	}

	/**
	 * @param mmRequest the mmRequest to set
	 */
	public void setMmRequest(MmRequest mmRequest) {
		this.mmRequest = mmRequest;
	}
	
	/**
	 * @return the ani
	 */
	public String getAni() {
		return ani;
	}

	/**
	 * @param ani to set
	 */
	public void setAni(final String ani) {
		this.ani = ani;
	}
	
	/**
	 * @return the transcriptId
	 */
	public String getTranscriptId() {
		return transcriptId;
	}

	/**
	 * @param transcriptId to set
	 */
	public void setTranscriptId(final String transcriptId) {
		this.transcriptId = transcriptId;
	}
	
	/**
	 * @return the startTime
	 */
	public long getStartTime() {
		return startTime;
	}
	
	/**
	 * @param startTime to set
	 */
	public void setStartTime(final long startTime) {
		this.startTime = startTime;
	}
	
	/**
	 * @return the endTime
	 */
	public long getEndTime() {
		return endTime;
	}

	/**
	 * @param endTime to set
	 */
	public void setEndTime(final long endTime) {
		this.endTime = endTime;
	}

	/**
	 * @return the isAutoStationLogin
	 */
	public String getIsAutoStationLogin() {
		return isAutoStationLogin;
	}

	/**
	 * @param isAutoStationLogin the isAutoStationLogin to set
	 */
	public void setIsAutoStationLogin(String isAutoStationLogin) {
		this.isAutoStationLogin = isAutoStationLogin;
	}

	/**
	 * @return the consultTime
	 */
	public String getConsultTime() {
		return consultTime;
	}

	/**
	 * @param consultTime the consultTime to set
	 */
	public void setConsultTime(String consultTime) {
		this.consultTime = consultTime;
	}

	/**
	 * @return the contactId
	 */
	public String getContactId() {
		return contactId;
	}

	/**
	 * @param contactId the contactId to set
	 */
	public void setContactId(String contactId) {
		this.contactId = contactId;
	}

	/**
	 * @return the contactType
	 */
	public String getContactType() {
		return contactType;
	}

	/**
	 * @param contactType the contactType to set
	 */
	public void setContactType(String contactType) {
		this.contactType = contactType;
	}

	/**
	 * @return the consultingType
	 */
	public String getConsultingType() {
		return consultingType;
	}

	/**
	 * @param consultingType the consultingType to set
	 */
	public void setConsultingType(String consultingType) {
		this.consultingType = consultingType;
	}

	/**
	 * @return the ucContact
	 */
	public String getUcContact() {
		return ucContact;
	}

	/**
	 * @param ucContact the ucContact to set
	 */
	public void setUcContact(String ucContact) {
		this.ucContact = ucContact;
	}

	/**
	 * @return the componentType
	 */
	public String getComponentType() {
		return componentType;
	}

	/**
	 * @param componentType the componentType to set
	 */
	public void setComponentType(String componentType) {
		this.componentType = componentType;
	}

}
