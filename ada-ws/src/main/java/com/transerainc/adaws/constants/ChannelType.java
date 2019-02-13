package com.transerainc.adaws.constants;

public enum ChannelType {

	Telephony ("telephony"),
	Chat ("chat"),
	Email ("email");

	private String name;

	ChannelType(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

}
