package com.transerainc.adaws.model.cache.contact.chat;

/**
 * @author tnguyen
 *
 */
public enum MessageDirection {

	INBOUND ("inbound"),
	OUTBOUND ("outbound");

	private String name;

	private MessageDirection(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

}
