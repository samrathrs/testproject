package com.transerainc.adaws.model.cache.contact.chat;

/**
 * @author tringuyen
 *
 */
public class ChatMessagePrivateAgentToAgentMessageResponseData {

	private String sessionId;
	private String cduId;
	private String fromId;
	private String fromName;
	private String to;
	private String message;
	private String sendTime;

	/**
	 * 
	 */
	public ChatMessagePrivateAgentToAgentMessageResponseData() {
	}

	/**
	 * @param sessionId
	 * @param cduId
	 * @param messageType
	 * @param fromId
	 * @param fromName
	 * @param to
	 * @param message
	 * @param sendTime
	 */
	public ChatMessagePrivateAgentToAgentMessageResponseData(String sessionId, String cduId, String fromId,
			String fromName, String to, String message, String sendTime) {
		this.sessionId = sessionId;
		this.cduId = cduId;
		this.fromId = fromId;
		this.fromName = fromName;
		this.to = to;
		this.message = message;
		this.sendTime = sendTime;
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
	 * @return the fromId
	 */
	public String getFromId() {
		return fromId;
	}

	/**
	 * @param fromId the fromId to set
	 */
	public void setFromId(String fromId) {
		this.fromId = fromId;
	}

	/**
	 * @return the fromName
	 */
	public String getFromName() {
		return fromName;
	}

	/**
	 * @param fromName the fromName to set
	 */
	public void setFromName(String fromName) {
		this.fromName = fromName;
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
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the sendTime
	 */
	public String getSendTime() {
		return sendTime;
	}

	/**
	 * @param sendTime the sendTime to set
	 */
	public void setSendTime(String sendTime) {
		this.sendTime = sendTime;
	}

	public String debugToString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ChatMessagePrivateAgentToAgentMessageResponseData [sessionId=");
		builder.append(sessionId);
		builder.append(", cduId=");
		builder.append(cduId);
		builder.append(", fromId=");
		builder.append(fromId);
		builder.append(", fromName=");
		builder.append(fromName);
		builder.append(", to=");
		builder.append(to);
		builder.append(", message=");
		builder.append(message);
		builder.append(", sendTime=");
		builder.append(sendTime);
		builder.append("]");
		return builder.toString();
	}

}
