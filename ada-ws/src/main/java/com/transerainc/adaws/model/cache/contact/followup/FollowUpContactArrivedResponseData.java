package com.transerainc.adaws.model.cache.contact.followup;

/**
 * @author tringuyen
 *
 */
public class FollowUpContactArrivedResponseData {

	private String sessionId;
	private long agentId;
	private String contactType;
	private String channelId;
	private FollowUpContactArrivedFollowUpDetails followUpDetails;

	/**
	 * 
	 */
	public FollowUpContactArrivedResponseData() {
	}

	/**
	 * @param sessionId
	 * @param agentId
	 * @param contactType
	 * @param channelId
	 * @param followUpDetails
	 */
	public FollowUpContactArrivedResponseData(String sessionId, long agentId, String contactType, String channelId,
			FollowUpContactArrivedFollowUpDetails followUpDetails) {
		this.sessionId = sessionId;
		this.agentId = agentId;
		this.contactType = contactType;
		this.channelId = channelId;
		this.followUpDetails = followUpDetails;
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
	 * @return the channelId
	 */
	public String getChannelId() {
		return channelId;
	}

	/**
	 * @param channelId the channelId to set
	 */
	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}

	/**
	 * @return the followUpDetails
	 */
	public FollowUpContactArrivedFollowUpDetails getFollowUpDetails() {
		return followUpDetails;
	}

	/**
	 * @param followUpDetails the followUpDetails to set
	 */
	public void setFollowUpDetails(FollowUpContactArrivedFollowUpDetails followUpDetails) {
		this.followUpDetails = followUpDetails;
	}

	public String debugToString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FollowUpContactArrivedResponseData [sessionId=");
		builder.append(sessionId);
		builder.append(", agentId=");
		builder.append(agentId);
		builder.append(", contactType=");
		builder.append(contactType);
		builder.append(", channelId=");
		builder.append(channelId);
		builder.append(", followUpDetails=");
		if (followUpDetails != null) {
			builder.append(followUpDetails.debugToString());
		} else {
			builder.append("null");
		}
		builder.append("]");
		return builder.toString();
	}

}
