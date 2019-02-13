package com.transerainc.adaws.model.cache.contact.email;

import java.util.Collection;
import java.util.List;

import org.json.JSONObject;

import com.transerainc.adaws.constants.StateCacheConstants;
import com.transerainc.adaws.model.RequestData;

/**
 * @author tringuyen
 *
 */
public class EmailContactAdditionalData {

	private String agentComment;
	private String supervisorComment;
	private EmailContactAgentMessage agentMessage;
	private List<Long> suggestedTemplates;
	private List<Long> suggestedGuides;
	private String cherryPickComment;

	/**
	 * 
	 */
	public EmailContactAdditionalData() {
	}

	/**
	 * @param agentComment
	 * @param supervisorComment
	 * @param agentMessage
	 * @param suggestedTemplates
	 * @param suggestedGuides
	 */
	public EmailContactAdditionalData(String agentComment, String supervisorComment,
			EmailContactAgentMessage agentMessage, List<Long> suggestedTemplates, List<Long> suggestedGuides, String cherryPickComment ) {
		this.agentComment = agentComment;
		this.supervisorComment = supervisorComment;
		this.agentMessage = agentMessage;
		this.suggestedTemplates = suggestedTemplates;
		this.suggestedGuides = suggestedGuides;
		this.cherryPickComment = cherryPickComment;
	}

	/**
	 * @return the agentComment
	 */
	public String getAgentComment() {
		return agentComment;
	}

	/**
	 * @param agentComment the agentComment to set
	 */
	public void setAgentComment(String agentComment) {
		this.agentComment = agentComment;
	}

	/**
	 * @return the supervisorComment
	 */
	public String getSupervisorComment() {
		return supervisorComment;
	}

	/**
	 * @param supervisorComment the supervisorComment to set
	 */
	public void setSupervisorComment(String supervisorComment) {
		this.supervisorComment = supervisorComment;
	}

	/**
	 * @return the agentMessage
	 */
	public EmailContactAgentMessage getAgentMessage() {
		return agentMessage;
	}

	/**
	 * @param agentMessage the agentMessage to set
	 */
	public void setAgentMessage(EmailContactAgentMessage agentMessage) {
		this.agentMessage = agentMessage;
	}

	/**
	 * @return the suggestedTemplates
	 */
	public List<Long> getSuggestedTemplates() {
		return suggestedTemplates;
	}

	/**
	 * @param suggestedTemplates the suggestedTemplates to set
	 */
	public void setSuggestedTemplates(List<Long> suggestedTemplates) {
		this.suggestedTemplates = suggestedTemplates;
	}

	/**
	 * @return the suggestedGuides
	 */
	public List<Long> getSuggestedGuides() {
		return suggestedGuides;
	}

	/**
	 * @param suggestedGuides the suggestedGuides to set
	 */
	public void setSuggestedGuides(List<Long> suggestedGuides) {
		this.suggestedGuides = suggestedGuides;
	}

	public String debugToString() {
		StringBuilder builder = new StringBuilder();
		builder.append("EmailContactAdditionalData ");
		builder.append("[");
		builder.append("agentComment=");
		builder.append(agentComment);
		builder.append(", supervisorComment=");
		builder.append(supervisorComment);
		builder.append(", cherryPickComment=");
		builder.append(cherryPickComment);
		builder.append(", agentMessage=");
		if (agentMessage != null) {
			builder.append(agentMessage.debugToString());
		} else {
			builder.append("null");
		}
		builder.append(", suggestedTemplates=");
		if ((suggestedTemplates != null) && (suggestedTemplates.size() > 0)) {
			for (Long suggestedTemplate : suggestedTemplates) {
				builder.append(suggestedTemplate);
				builder.append(", ");
			}
		} else {
			builder.append("null");
		}
		builder.append(", suggestedGuides=");
		if ((suggestedGuides != null) && (suggestedGuides.size() > 0)) {
			for (Long suggestedGuide : suggestedGuides) {
				builder.append(suggestedGuide);
				builder.append(", ");
			}
		} else {
			builder.append("null");
		}
		builder.append("]");
		return builder.toString();
	}

	public void copyAttributes(RequestData requestData) {
		if (requestData == null) {
			return;
		}

		// agentMessage
		if (this.agentMessage == null) {
			this.agentMessage = new EmailContactAgentMessage();
		}
		this.agentMessage.copyAttributes(requestData);

	}

	public JSONObject toJsonObject() {
		final JSONObject emailContactAdditionalDataJsonObject = new JSONObject();
		emailContactAdditionalDataJsonObject.put(StateCacheConstants.AGENT_COMMENT_KEY, agentComment);
		emailContactAdditionalDataJsonObject.put(StateCacheConstants.SUPERVISOR_COMMENT_KEY, supervisorComment);
		JSONObject agentMessageJsonObject = null;
		if (agentMessage != null) {
			agentMessageJsonObject = agentMessage.toJsonObject();
		}
		emailContactAdditionalDataJsonObject.put(StateCacheConstants.AGENT_MESSAGE_KEY, agentMessageJsonObject);
		emailContactAdditionalDataJsonObject.put(StateCacheConstants.SUGGESTED_TEMPLATES_KEY, suggestedTemplates);
		emailContactAdditionalDataJsonObject.put(StateCacheConstants.SUGGESTED_GUIDES_KEY, suggestedTemplates);
		emailContactAdditionalDataJsonObject.put(StateCacheConstants.CHERRY_PICK_COMMENT, cherryPickComment);
		return emailContactAdditionalDataJsonObject;
	}

	/**
	 * @return the cherryPickComment
	 */
	public String getCherryPickComment() {
		return cherryPickComment;
	}

	/**
	 * @param cherryPickComment the cherryPickComment to set
	 */
	public void setCherryPickComment(String cherryPickComment) {
		this.cherryPickComment = cherryPickComment;
	}

}
