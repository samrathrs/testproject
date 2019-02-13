package com.transerainc.adaws.constants;

/**
 * @author tringuyen
 *
 */
public enum StateCacheContactType {

	CALL ("call"),
	CHAT ("chat"),
	EMAIL ("email"),
	FOLLOW_UP ("followup");

	private String name;

	StateCacheContactType(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

}
