package com.transerainc.adaws.constants;

/**
 * @author tringuyen
 *
 */
public enum CacheContactState {

	NEW ("New"),
	ACCEPTED ("Accepted"),
	ASSIGNED ("Assigned"),
	CLOSED ("Closed"),
	WRAP_UP("WrapUp"),
	COMPLETED ("Completed");

	private String name;

	CacheContactState(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

}
