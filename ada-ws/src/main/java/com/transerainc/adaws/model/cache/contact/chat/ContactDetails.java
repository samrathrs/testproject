package com.transerainc.adaws.model.cache.contact.chat;

/**
 * @author tringuyen
 *
 */
public class ContactDetails {

	private String chatReason;
	private String messageBody;
	private String cduId;
	private long entryPointId;
	private long receivedDate;
	private long ronaTime;
	private From from;

	/**
	 * 
	 */
	public ContactDetails() {
	}

	/**
	 * @param chatReason
	 * @param messageBody
	 * @param cduId
	 * @param entryPointId
	 * @param receivedDate
	 * @param ronaTime
	 * @param from
	 */
	public ContactDetails(String chatReason, String messageBody, String cduId, long entryPointId, long receivedDate,
			long ronaTime, From from) {
		this.chatReason = chatReason;
		this.messageBody = messageBody;
		this.cduId = cduId;
		this.entryPointId = entryPointId;
		this.receivedDate = receivedDate;
		this.ronaTime = ronaTime;
		this.from = from;
	}



	/**
	 * @return the chatReason
	 */
	public String getChatReason() {
		return chatReason;
	}

	/**
	 * @param chatReason the chatReason to set
	 */
	public void setChatReason(String chatReason) {
		this.chatReason = chatReason;
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
	 * @return the entryPointId
	 */
	public long getEntryPointId() {
		return entryPointId;
	}

	/**
	 * @param entryPointId the entryPointId to set
	 */
	public void setEntryPointId(long entryPointId) {
		this.entryPointId = entryPointId;
	}

	/**
	 * @return the receivedDate
	 */
	public long getReceivedDate() {
		return receivedDate;
	}

	/**
	 * @param receivedDate the receivedDate to set
	 */
	public void setReceivedDate(long receivedDate) {
		this.receivedDate = receivedDate;
	}

	/**
	 * @return the ronaTime
	 */
	public long getRonaTime() {
		return ronaTime;
	}

	/**
	 * @param ronaTime the ronaTime to set
	 */
	public void setRonaTime(long ronaTime) {
		this.ronaTime = ronaTime;
	}

	/**
	 * @return the from
	 */
	public From getFrom() {
		return from;
	}

	/**
	 * @param from the from to set
	 */
	public void setFrom(From from) {
		this.from = from;
	}

	public String debugToString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ContactDetails [chatReason=");
		builder.append(chatReason);
		builder.append(", messageBody=");
		builder.append(messageBody);
		builder.append(", cduId=");
		builder.append(cduId);
		builder.append(", entryPointId=");
		builder.append(entryPointId);
		builder.append(", receivedDate=");
		builder.append(receivedDate);
		builder.append(", ronaTime=");
		builder.append(ronaTime);
		builder.append(", from=");
		if (from != null) {
			builder.append(from.debugToString());
		} else {
			builder.append("null");
		}
		builder.append("]");
		return builder.toString();
	}

}
