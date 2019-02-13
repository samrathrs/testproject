package com.transerainc.adaws.model.cache.contact.chat;

/**
 * @author tringuyen
 *
 */
public class ChatContactConferenceCloseResponseData {

	private String sessionId;
	private long agentId;
	private String cduId;
	private String to;
	private String memberName;
	private String memberId;

	/**
	 * 
	 */
	public ChatContactConferenceCloseResponseData() {
	}

	/**
	 * @param sessionId
	 * @param agentId
	 * @param cduId
	 * @param to
	 * @param memberName
	 * @param memberId
	 */
	public ChatContactConferenceCloseResponseData(String sessionId, long agentId, String cduId, String to,
			String memberName, String memberId) {
		this.sessionId = sessionId;
		this.agentId = agentId;
		this.cduId = cduId;
		this.to = to;
		this.memberName = memberName;
		this.memberId = memberId;
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

	/**
	 * @return the memberId
	 */
	public String getMemberId() {
		return memberId;
	}

	/**
	 * @param memberId the memberId to set
	 */
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String debugToString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ChatContactConferenceCloseResponseData [sessionId=");
		builder.append(sessionId);
		builder.append(", agentId=");
		builder.append(agentId);
		builder.append(", cduId=");
		builder.append(cduId);
		builder.append(", to=");
		builder.append(to);
		builder.append(", memberName=");
		builder.append(memberName);
		builder.append(", memberId=");
		builder.append(memberId);
		builder.append("]");
		return builder.toString();
	}

}
