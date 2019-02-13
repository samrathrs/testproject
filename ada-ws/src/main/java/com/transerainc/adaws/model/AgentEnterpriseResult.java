package com.transerainc.adaws.model;

/**
 * @author tnguyen
 *
 */
public class AgentEnterpriseResult {

    private int status;
    private String message;
    private String agentSessionId;
    private String agentName;
    private String enterpriseName;
	/**
	 * @return the status
	 */
	public int getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(int status) {
		this.status = status;
	}
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
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
	/**
	 * @return the agentName
	 */
	public String getAgentName() {
		return agentName;
	}
	/**
	 * @param agentName the agentName to set
	 */
	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}
	/**
	 * @return the enterpriseName
	 */
	public String getEnterpriseName() {
		return enterpriseName;
	}
	/**
	 * @param enterpriseName the enterpriseName to set
	 */
	public void setEnterpriseName(String enterpriseName) {
		this.enterpriseName = enterpriseName;
	}

	public String debugToString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AgentEnterpriseResult [status=");
		builder.append(status);
		builder.append(", message=");
		builder.append(message);
		builder.append(", agentSessionId=");
		builder.append(agentSessionId);
		builder.append(", agentName=");
		builder.append(agentName);
		builder.append(", enterpriseName=");
		builder.append(enterpriseName);
		builder.append("]");
		return builder.toString();
	}

}
