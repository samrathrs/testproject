package com.transerainc.adaws.retriever;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.transerainc.adaws.model.UserEnterpriseInfo;
import com.transerainc.adaws.service.AnalyzerService;

/**
 * @author tnguyen
 * 
 * This class is based on XeraAuthenticationHandler in transera-cas project.
 *
 */
@Component
public class UserInformationRetriever {

	protected static final Logger lgr = LoggerFactory
			.getLogger(UserInformationRetriever.class);

	private String username;

    @Autowired
    private AnalyzerService analyzerService;

	/**
	 * @param username
	 */
	public UserInformationRetriever() {
	}

	/**
	 * @param username
	 */
	public UserInformationRetriever(String username) {
		this.username = username;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	public String extractEnterpriseNameFromResponse(String response) {
		String enterpriseName = null;
		try {
			JSONObject responseAsJson = new JSONObject(response);
			enterpriseName = responseAsJson.
					getJSONObject("details").
					getJSONArray("tenants").
					getJSONObject(0).getString("name");
		} catch (JSONException jsonException) {
			lgr.error("Error extracting Enterprise Name from response: {}, but encountered exception: {}",
					response,
					jsonException);
		}
		return enterpriseName;
	}

	public String extractEnterpriseIdFromResponse(String response) {
		String enterpriseId = null;
		try {
			JSONObject responseAsJson = new JSONObject(response);
			enterpriseId = responseAsJson.
					getJSONObject("details").
					getJSONArray("tenants").
					getJSONObject(0).getString("id");
		} catch (JSONException jsonException) {
			lgr.error("Error extracting Enterprise Id from response: {}, but encountered exception: {}",
					response,
					jsonException);
		}
		return enterpriseId;
	}

	public String getEnterprise(String username) {
		this.setUsername(username);
		String enterpriseName = null;
		String tenantResponse = analyzerService.getTenantNameByLoginName(username);
		if(tenantResponse != null) {
			enterpriseName = extractEnterpriseNameFromResponse(tenantResponse);
		}
		return enterpriseName;
	}

	public UserEnterpriseInfo buildUserEnterpriseInfo(String userName) {
		this.setUsername(userName);
		String enterpriseName = null;
		String enterpriseId = null;
		String tenantResponse = analyzerService.getTenantNameByLoginName(userName);
		if(org.apache.commons.lang3.StringUtils.isNotBlank(tenantResponse)) {
			enterpriseName = extractEnterpriseNameFromResponse(tenantResponse);
			enterpriseId = extractEnterpriseIdFromResponse(tenantResponse);
		}
		
		boolean callCenterEnabled = false;
		String userDetailsInfoResponse = analyzerService.getUserDetailsInfoByLoginName(userName, enterpriseId);
		if(org.apache.commons.lang3.StringUtils.isNotBlank(userDetailsInfoResponse)) {
			callCenterEnabled = extractCallCenterEnabledFlagFromResponse(userDetailsInfoResponse);
		}
		
		return new UserEnterpriseInfo(userName, enterpriseName, enterpriseId, callCenterEnabled);
	}

	public boolean extractCallCenterEnabledFlagFromResponse(String response) {
		try {
			JSONObject responseAsJson = new JSONObject(response);
			int callCenterEnabledFlagAsInt = responseAsJson.
					getJSONArray("auxiliaryDataList").
					getJSONObject(0).
					getJSONObject("attributes").
					getInt("callCenterEnabled__i");
			return (callCenterEnabledFlagAsInt == 0) ? false : true;
		} catch (JSONException jsonException) {
			lgr.error("Error extracting Enterprise Id from response: {}, but encountered exception: {}",
					response,
					jsonException);
		}
		return false;
	}

}
