package com.transerainc.adaws.model.cache.loggedinagent;

/**
 * @author tnguyen
 *
 */

public class ResponseData {

	private String sessionId;
	private long agentId;
	private long channelId;

	/**
	 * 
	 */
	public ResponseData() {
	}

	/**
	 * @param sessionId
	 * @param agentId
	 * @param channelId
	 */
	public ResponseData(String sessionId, long agentId, long channelId) {
		this.sessionId = sessionId;
		this.agentId = agentId;
		this.channelId = channelId;
	}

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
	public long getAgentId() {
		return agentId;
	}

	/**
	 * @param agentId the agentId to set
	 */
	public void setAgentId(long agentId) {
		this.agentId = agentId;
	}

	/**
	 * @return the channelId
	 */
	public long getChannelId() {
		return channelId;
	}

	/**
	 * @param channelId the channelId to set
	 */
	public void setChannelId(long channelId) {
		this.channelId = channelId;
	}

	public String debugToString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ResponseData [sessionId=");
		builder.append(sessionId);
		builder.append(", agentId=");
		builder.append(agentId);
		builder.append(", channelId=");
		builder.append(channelId);
		builder.append("]");
		return builder.toString();
	}

}
