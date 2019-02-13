/**
 * 
 */
package com.transerainc.adaws.model;

/**
 * @author jnarain
 *
 */
public class FrontendDiagnosticsLogging {
	private String agentSessionId;
	private String level;
	private String message;
	
	public FrontendDiagnosticsLogging () {
		super();
	}
	
	public FrontendDiagnosticsLogging (String agentSessionId, String level, String message) {
		super();
		this.agentSessionId = agentSessionId;
		this.level = level;
		this.message = message;
	}
	
	public String getAgentSessionId() {
		return agentSessionId;
	}
	
	public void setAgentSessionId(String agentSessionId) {
		this.agentSessionId = agentSessionId;
	}
	
	public String getLevel() {
		return level;
	}
	
	public void setLevel(String level) {
		this.level = level;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}

	public String debugToString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FrontendDiagnosticsLogging [agentSessionId=");
		builder.append(agentSessionId);
		builder.append(", level=");
		builder.append(level);
		builder.append(", message=");
		builder.append(message);
		builder.append("]");
		return builder.toString();
	}
}
