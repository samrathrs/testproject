/**
 * 
 */
package com.transerainc.ara.pojo;

/**
 * @author pgujjeti
 *
 */
public class AgentStateRequest {
	private Long agentId;

	private String agentSessionId;

	private Long enterpriseId;

	private String command;
	
	private String state;

	private int auxCodeId;

	private Contact contact;

	private Long timestamp;

	public static class Contact {
		private String type;

		private String contactId;

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public String getContactId() {
			return contactId;
		}

		public void setContactId(String contactId) {
			this.contactId = contactId;
		}
	}

	public Long getAgentId() {
		return agentId;
	}

	public void setAgentId(Long agentId) {
		this.agentId = agentId;
	}

	public String getAgentSessionId() {
		return agentSessionId;
	}

	public void setAgentSessionId(String agentSessionId) {
		this.agentSessionId = agentSessionId;
	}

	public Long getEnterpriseId() {
		return enterpriseId;
	}

	public void setEnterpriseId(Long enterpriseId) {
		this.enterpriseId = enterpriseId;
	}

	public String getCommand() {
		return command;
	}

	public void setCommand(String command) {
		this.command = command;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	public Long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}

	public int getAuxCodeId() {
		return auxCodeId;
	}

	public void setAuxCodeId(int auxCodeId) {
		this.auxCodeId = auxCodeId;
	}

}
