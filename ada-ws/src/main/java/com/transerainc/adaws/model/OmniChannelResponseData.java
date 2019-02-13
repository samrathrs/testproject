package com.transerainc.adaws.model;

import javax.validation.constraints.NotNull;

/**
 * @author tnguyen
 *
 */
public class OmniChannelResponseData {

	@NotNull
	public String sessionId;

	@NotNull
	public String agentId;

	public String restOfData;

	/**
	 * @return the sessionId
	 */
	public String getSessionId() {
		return sessionId;
	}

	/**
	 * @param sessionId the sessionId to set
	 */
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	/**
	 * @return the agentId
	 */
	public String getAgentId() {
		return agentId;
	}

	/**s
	 * @param agentId the agentId to set
	 */
	public void setAgentId(String agentId) {
		this.agentId = agentId;
	}

	/**
	 * @return the restOfData
	 */
	public String getRestOfData() {
		return restOfData;
	}

	/**
	 * @param restOfData the restOfData to set
	 */
	public void setRestOfData(String restOfData) {
		this.restOfData = restOfData;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("OmniChannelResponseData ");
		builder.append("[");
		builder.append("sessionId=");
		builder.append(sessionId);
		builder.append(", agentId=");
		builder.append(agentId);
		builder.append(", restOfData=");
		builder.append(restOfData);
		builder.append("]");
		return builder.toString();
	}



}
