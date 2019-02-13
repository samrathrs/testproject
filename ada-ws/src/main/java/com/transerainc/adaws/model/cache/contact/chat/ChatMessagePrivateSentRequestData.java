package com.transerainc.adaws.model.cache.contact.chat;

/**
 * @author tnguyen
 *
 */
public class ChatMessagePrivateSentRequestData {

	private static final String CDU_ID_TO_MEMBER_ID_SEPARATOR = "/";
	private static final String MEMBER_ID_MEMBER_NAME_SEPARATOR = "::";
	private static final String CDU_ID_TO_MEMBER_ID__MEMBER_NAME_FORMAT = "%s/%d::%s";

	private String sessionId;
	private long tenantId;
	private long agentId;
	private String persistentCallbackUrl;
	private String toMember;
	private String fromMember;
	private String source;
	private String msgType;
	private String message;

	/**
	 * 
	 */
	public ChatMessagePrivateSentRequestData() {
	}

	/**
	 * @param sessionId
	 * @param tenantId
	 * @param agentId
	 * @param persistentCallbackUrl
	 * @param toMember
	 * @param fromMember
	 * @param source
	 * @param msgType
	 * @param message
	 */
	public ChatMessagePrivateSentRequestData(String sessionId, long tenantId, long agentId,
			String persistentCallbackUrl, String toMember, String fromMember, String source, String msgType,
			String message) {
		this.sessionId = sessionId;
		this.tenantId = tenantId;
		this.agentId = agentId;
		this.persistentCallbackUrl = persistentCallbackUrl;
		this.toMember = toMember;
		this.fromMember = fromMember;
		this.source = source;
		this.msgType = msgType;
		this.message = message;
	}

	/**
	 * @return the sessionId
	 */
	public String getSessionId() {
		return sessionId;
	}

	/**
	 * @param sessionId the sessionId to set
	 */
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	/**
	 * @return the tenantId
	 */
	public long getTenantId() {
		return tenantId;
	}

	/**
	 * @param tenantId the tenantId to set
	 */
	public void setTenantId(long tenantId) {
		this.tenantId = tenantId;
	}

	/**
	 * @return the agentId
	 */
	public long getAgentId() {
		return agentId;
	}

	/**
	 * @param agentId the agentId to set
	 */
	public void setAgentId(long agentId) {
		this.agentId = agentId;
	}

	/**
	 * @return the persistentCallbackUrl
	 */
	public String getPersistentCallbackUrl() {
		return persistentCallbackUrl;
	}

	/**
	 * @param persistentCallbackUrl the persistentCallbackUrl to set
	 */
	public void setPersistentCallbackUrl(String persistentCallbackUrl) {
		this.persistentCallbackUrl = persistentCallbackUrl;
	}

	/**
	 * @return the toMember
	 */
	public String getToMember() {
		return toMember;
	}

	/**
	 * @param toMember the toMember to set
	 */
	public void setToMember(String toMember) {
		this.toMember = toMember;
	}

	/**
	 * @return the fromMember
	 */
	public String getFromMember() {
		return fromMember;
	}

	/**
	 * @param fromMember the fromMember to set
	 */
	public void setFromMember(String fromMember) {
		this.fromMember = fromMember;
	}

	/**
	 * @return the source
	 */
	public String getSource() {
		return source;
	}

	/**
	 * @param source the source to set
	 */
	public void setSource(String source) {
		this.source = source;
	}

	/**
	 * @return the msgType
	 */
	public String getMsgType() {
		return msgType;
	}

	/**
	 * @param msgType the msgType to set
	 */
	public void setMsgType(String msgType) {
		this.msgType = msgType;
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

	public String debugToString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ChatMessagePrivateSentRequestData [sessionId=");
		builder.append(sessionId);
		builder.append(", tenantId=");
		builder.append(tenantId);
		builder.append(", agentId=");
		builder.append(agentId);
		builder.append(", persistentCallbackUrl=");
		builder.append(persistentCallbackUrl);
		builder.append(", toMember=");
		builder.append(toMember);
		builder.append(", fromMember=");
		builder.append(fromMember);
		builder.append(", source=");
		builder.append(source);
		builder.append(", msgType=");
		builder.append(msgType);
		builder.append(", message=");
		builder.append(message);
		builder.append("]");
		return builder.toString();
	}

	public String getCduId() {
		if (org.apache.commons.lang3.StringUtils.isNotBlank(toMember)) {
			final String[] parts = toMember.split(CDU_ID_TO_MEMBER_ID_SEPARATOR);
			if ((parts != null) && (parts.length > 0)) {
				final String cduId = parts[0];
				return cduId;
			}
		}
		return null;
	}

	public String getToMemberId() {
		if (org.apache.commons.lang3.StringUtils.isNotBlank(toMember)) {
			final String[] parts = toMember.split(CDU_ID_TO_MEMBER_ID_SEPARATOR);
			if ((parts != null) && (parts.length > 1)) {
				final String toMemberIdWithMemberName = parts[1];
				if (org.apache.commons.lang3.StringUtils.isNotBlank(toMemberIdWithMemberName)) {
					final String[] subParts = toMemberIdWithMemberName.split(MEMBER_ID_MEMBER_NAME_SEPARATOR);
					if ((subParts != null) && (subParts.length > 0)) {
						final String toMemberId = subParts[0];
						return toMemberId;
					}
				}
			}
		}
		return null;
	}

	// fffb20f001140306ac1f019b270c0000/16::OsakaAgent11@fedex.com

	public String getToMemberName() {
		if (org.apache.commons.lang3.StringUtils.isNotBlank(toMember)) {
			final String[] parts = toMember.split(CDU_ID_TO_MEMBER_ID_SEPARATOR);
			if ((parts != null) && (parts.length > 1)) {
				final String toMemberIdWithMemberName = parts[1];
				if (org.apache.commons.lang3.StringUtils.isNotBlank(toMemberIdWithMemberName)) {
					final String[] subParts = toMemberIdWithMemberName.split(MEMBER_ID_MEMBER_NAME_SEPARATOR);
					if ((subParts != null) && (subParts.length > 1)) {
						final String toMemberName = subParts[1];
						return toMemberName;
					}
				}
			}
		}
		return null;
	}

}
