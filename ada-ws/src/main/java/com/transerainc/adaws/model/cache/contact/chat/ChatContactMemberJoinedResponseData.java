package com.transerainc.adaws.model.cache.contact.chat;

/**
 * @author tringuyen
 *
 */
public class ChatContactMemberJoinedResponseData {

	private String sessionId;
	private long agentId;
	private String cduId;
	private long customerId;
	private String to;
	private String memberName;

	/**
	 * 
	 */
	public ChatContactMemberJoinedResponseData() {
	}

	/**
	 * @param sessionId
	 * @param agentId
	 * @param cduId
	 * @param customerId
	 * @param to
	 * @param memberName
	 */
	public ChatContactMemberJoinedResponseData(String sessionId, long agentId, String cduId, long customerId, String to,
			String memberName) {
		this.sessionId = sessionId;
		this.agentId = agentId;
		this.cduId = cduId;
		this.customerId = customerId;
		this.to = to;
		this.memberName = memberName;
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
	 * @return the cduId
	 */
	public String getCduId() {
		return cduId;
	}

	/**
	 * @param cduId the cduId to set
	 */
	public void setCduId(String cduId) {
		this.cduId = cduId;
	}

	/**
	 * @return the customerId
	 */
	public long getCustomerId() {
		return customerId;
	}

	/**
	 * @param customerId the customerId to set
	 */
	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	/**
	 * @return the to
	 */
	public String getTo() {
		return to;
	}

	/**
	 * @param to the to to set
	 */
	public void setTo(String to) {
		this.to = to;
	}

	/**
	 * @return the memberName
	 */
	public String getMemberName() {
		return memberName;
	}

	/**
	 * @param memberName the memberName to set
	 */
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String debugToString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ChatContactMemberJoinedResponseData [sessionId=");
		builder.append(sessionId);
		builder.append(", agentId=");
		builder.append(agentId);
		builder.append(", cduId=");
		builder.append(cduId);
		builder.append(", customerId=");
		builder.append(customerId);
		builder.append(", to=");
		builder.append(to);
		builder.append(", memberName=");
		builder.append(memberName);
		builder.append("]");
		return builder.toString();
	}

}
