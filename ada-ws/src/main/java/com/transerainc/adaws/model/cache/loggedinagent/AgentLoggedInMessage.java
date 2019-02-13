package com.transerainc.adaws.model.cache.loggedinagent;

/**
 * @author tnguyen
 *
 */

public class AgentLoggedInMessage {

	private MmResponse mmResponse;

	/**
	 * 
	 */
	public AgentLoggedInMessage() {
	}

	/**
	 * @param mmResponse
	 */
	public AgentLoggedInMessage(MmResponse mmResponse) {
		this.mmResponse = mmResponse;
	}

	/**
	 * @return the mmResponse
	 */
	public MmResponse getMmResponse() {
		return mmResponse;
	}

	/**
	 * @param mmResponse the mmResponse to set
	 */
	public void setMmResponse(MmResponse mmResponse) {
		this.mmResponse = mmResponse;
	}

	public String debugToString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AgentLoggedInMessage [mmResponse=");
		if (mmResponse  != null) {
			builder.append(mmResponse.debugToString());
		} else {
			builder.append("null");
		}
		builder.append("]");
		return builder.toString();
	}

}
