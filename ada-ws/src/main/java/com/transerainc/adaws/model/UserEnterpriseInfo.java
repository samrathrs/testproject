package com.transerainc.adaws.model;

/**
 * @author tnguyen
 *
 */
public class UserEnterpriseInfo {

	private String userName;
	private String enterpriseName;
	private String enterpriseId;
	private boolean callCenterEnabled;
	
	public UserEnterpriseInfo(String userName, String enterpriseName, String enterpriseId, boolean callCenterEnabled) {
		setUsername(userName);
		setEnterpriseName(enterpriseName);
		setEnterpriseId(enterpriseId);
		setCallCenterEnabled(callCenterEnabled);
	}
	
	/**
	 * @return the userName
	 */
	public String getUsername() {
		return userName;
	}
	/**
	 * @param userName the userName to set
	 */
	public void setUsername(String userName) {
		this.userName = userName;
	}
	/**
	 * @return the enterpriseName
	 */
	public String getEnterpriseName() {
		return enterpriseName;
	}
	/**
	 * @param enterpriseName the enterpriseName to set
	 */
	public void setEnterpriseName(String enterpriseName) {
		this.enterpriseName = enterpriseName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEnterpriseId() {
		return enterpriseId;
	}

	public void setEnterpriseId(String enterpriseId) {
		this.enterpriseId = enterpriseId;
	}

	public boolean isCallCenterEnabled() {
		return callCenterEnabled;
	}

	public void setCallCenterEnabled(boolean callCenterEnabled) {
		this.callCenterEnabled = callCenterEnabled;
	}
	
}
