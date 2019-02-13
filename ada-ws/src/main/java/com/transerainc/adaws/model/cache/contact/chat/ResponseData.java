package com.transerainc.adaws.model.cache.contact.chat;

/**
 * @author tringuyen
 *
 */
public class ResponseData {

	private String sessionId;
	private long agentId;
	private String contactType;
	private long channelId;
	private long omniChannelQueueId;
	private ContactDetails contactDetails;
	private AdditionalData additionalData;

	/**
	 * 
	 */
	public ResponseData() {
	}

	/**
	 * @param sessionId
	 * @param agentId
	 * @param contactType
	 * @param channelId
	 * @param omniChannelQueueId
	 * @param contactDetails
	 * @param additionalData
	 */
	public ResponseData(String sessionId, long agentId, String contactType, long channelId, long omniChannelQueueId,
			ContactDetails contactDetails, AdditionalData additionalData) {
		this.sessionId = sessionId;
		this.agentId = agentId;
		this.contactType = contactType;
		this.channelId = channelId;
		this.omniChannelQueueId = omniChannelQueueId;
		this.contactDetails = contactDetails;
		this.additionalData = additionalData;
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
	public long getChannelId() {
		return channelId;
	}

	/**
	 * @param channelId the channelId to set
	 */
	public void setChannelId(long channelId) {
		this.channelId = channelId;
	}

	/**
	 * @return the omniChannelQueueId
	 */
	public long getOmniChannelQueueId() {
		return omniChannelQueueId;
	}

	/**
	 * @param omniChannelQueueId the omniChannelQueueId to set
	 */
	public void setOmniChannelQueueId(long omniChannelQueueId) {
		this.omniChannelQueueId = omniChannelQueueId;
	}

	/**
	 * @return the contactDetails
	 */
	public ContactDetails getContactDetails() {
		return contactDetails;
	}

	/**
	 * @param contactDetails the contactDetails to set
	 */
	public void setContactDetails(ContactDetails contactDetails) {
		this.contactDetails = contactDetails;
	}

	/**
	 * @return the additionalData
	 */
	public AdditionalData getAdditionalData() {
		return additionalData;
	}

	/**
	 * @param additionalData the additionalData to set
	 */
	public void setAdditionalData(AdditionalData additionalData) {
		this.additionalData = additionalData;
	}

	public String debugToString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ResponseData [sessionId=");
		builder.append(sessionId);
		builder.append(", agentId=");
		builder.append(agentId);
		builder.append(", contactType=");
		builder.append(contactType);
		builder.append(", channelId=");
		builder.append(channelId);
		builder.append(", omniChannelQueueId=");
		builder.append(omniChannelQueueId);
		builder.append(", contactDetails=");
		if (contactDetails != null) {
			builder.append(contactDetails.debugToString());
		} else {
			builder.append("null");
		}
		builder.append(", additionalData=");
		if (contactDetails != null) {
			builder.append(additionalData.debugToString());
		} else {
			builder.append("null");
		}
		builder.append("]");
		return builder.toString();
	}

}
