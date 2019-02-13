/**
 * 
 */
package com.transerainc.adaws.model.cache.profile;

/**
 * @author tnguyen
 *
 */
public class AgentLoginResponseBody {

	private MmResponse mmResponse;

	/**
	 * 
	 */
	public AgentLoginResponseBody() {
	}

	/**
	 * @param success
	 * @param message
	 * @param action
	 * @param responseData
	 */
	public AgentLoginResponseBody(MmResponse mmResponse) {
		this.mmResponse = mmResponse;	}


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
		builder.append("AgentLoginResponseBody [mmResponse=");
		if (mmResponse != null) {
			builder.append(mmResponse.debugToString());
		} else {
			builder.append("null");
		}
		builder.append("]");
		return builder.toString();
	}

}
