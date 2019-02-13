package com.transerainc.adaws.model.cache.contact.chat;

/**
 * @author tringuyen
 *
 */
public enum MessageType {

	TYPING_STARTED("12", "typing started"),
	TYPING_STOPPED("13", "typing stopped"),
	SEND_MESSAGE("2", "send message"),
	PUSH_URL("4", "push url");

	private String id;
	private String description;
	/**
	 * @param id
	 * @param description
	 */
	private MessageType(String id, String description) {
		this.id = id;
		this.description = description;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

}
