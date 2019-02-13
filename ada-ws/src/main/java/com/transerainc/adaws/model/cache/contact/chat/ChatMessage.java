package com.transerainc.adaws.model.cache.contact.chat;

/**
 * @author tnguyen
 *
 */
public class ChatMessage {

	private String msgDirection;
	private String msgType;
	private String fromId;
	private String fromName;
	private String messageBody;
	private String messageReason;
	private String sendTime;

	/**
	 * 
	 */
	public ChatMessage() {
	}

	/**
	 * @param msgType
	 * @param fromId
	 * @param fromName
	 * @param messageBody
	 * @param messageReason
	 * @param sendTime
	 */
	public ChatMessage(
			String msgDirection, 
			String msgType, 
			String fromId, 
			String fromName, 
			String messageBody, 
			String messageReason,
			String sendTime
	) {
		this.msgDirection = msgDirection;
		this.msgType = msgType;
		this.fromId = fromId;
		this.fromName = fromName;
		this.messageBody = messageBody;
		this.messageReason = messageReason;
		this.sendTime = sendTime;
	}

	/**
	 * @param msgType
	 * @param fromId
	 * @param fromName
	 * @param messageBody
	 * @param sendTime
	 */
	ChatMessage(String msgType, String fromId, String fromName, String messageBody, String sendTime) {
		this.msgType = msgType;
		this.fromId = fromId;
		this.fromName = fromName;
		this.messageBody = messageBody;
		this.sendTime = sendTime;
	}

	/**
	 * @param fromId
	 * @param fromName
	 * @param messageBody
	 * @param sendTime
	 */
	public ChatMessage(String fromId, String fromName, String messageBody, String sendTime) {
		this.fromId = fromId;
		this.fromName = fromName;
		this.messageBody = messageBody;
		this.sendTime = sendTime;
	}

	/**
	 * @return the msgDirection
	 */
	public String getMsgDirection() {
		return msgDirection;
	}

	/**
	 * @param msgDirection the msgDirection to set
	 */
	public void setMsgDirection(String msgDirection) {
		this.msgDirection = msgDirection;
	}

	/**
	 * @return the msgType
	 */
	public String getMsgType() {
		return msgType;
	}

	/**
	 * @param msgType the msgType to set
	 */
	public void setMsgType(String msgType) {
		this.msgType = msgType;
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
	 * @return the messageBody
	 */
	public String getMessageBody() {
		return messageBody;
	}

	/**
	 * @param messageBody the messageBody to set
	 */
	public void setMessageBody(String messageBody) {
		this.messageBody = messageBody;
	}

	/**
	 * @return the messageReason
	 */
	public String getMessageReason() {
		return messageReason;
	}

	/**
	 * @param messageReason the messageReason to set
	 */
	public void setMessageReason(String messageReason) {
		this.messageReason = messageReason;
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
		builder.append("ChatMessage [msgType=");
		builder.append(msgType);
		builder.append(", fromId=");
		builder.append(fromId);
		builder.append(", fromName=");
		builder.append(fromName);
		builder.append(", messageBody=");
		builder.append(messageBody);
		builder.append(", messageReason=");
		builder.append(messageReason);
		builder.append(", sendTime=");
		builder.append(sendTime);
		builder.append("]");
		return builder.toString();
	}

}
