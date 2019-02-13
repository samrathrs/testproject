package com.transerainc.adaws.model.cache.contact.followup;

import java.util.List;

/**
 * @author tringuyen
 *
 */
public class FollowUpContactFetchedResponseData {

	private String sessionId;
	private long agentId;
	private String contactType;
	private String channelId;
	private List<FollowUpContactFetchedFollowUpDetails> followUpDetails;

	/**
	 * 
	 */
	public FollowUpContactFetchedResponseData() {
	}

	/**
	 * @param sessionId
	 * @param agentId
	 * @param contactType
	 * @param channelId
	 * @param followUpDetails
	 */
	public FollowUpContactFetchedResponseData(String sessionId, long agentId, String contactType, String channelId,
			List<FollowUpContactFetchedFollowUpDetails> followUpDetails) {
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
	public List<FollowUpContactFetchedFollowUpDetails> getFollowUpDetails() {
		return followUpDetails;
	}

	/**
	 * @param followUpDetails the followUpDetails to set
	 */
	public void setFollowUpDetails(List<FollowUpContactFetchedFollowUpDetails> followUpDetails) {
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
		if ((followUpDetails != null) && (followUpDetails.size() > 0)) {
			builder.append("[");
			for (FollowUpContactFetchedFollowUpDetails followUpDetail : followUpDetails) {
				builder.append(followUpDetail.debugToString());
			}
			builder.append("]");
		} else {
			builder.append("null");
		}
		builder.append("]");
		return builder.toString();
	}

}
