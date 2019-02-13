package com.transerainc.adaws.json;

import javax.validation.constraints.NotNull;

public class FrontendAgentSessionId {
    @NotNull
    public String agentSessionId;

	/**
	 * @return the agentSessionId
	 */
	public String getAgentSessionId() {
		return agentSessionId;
	}

	/**
	 * @param agentSessionId the agentSessionId to set
	 */
	public void setAgentSessionId(String agentSessionId) {
		this.agentSessionId = agentSessionId;
	}
}
