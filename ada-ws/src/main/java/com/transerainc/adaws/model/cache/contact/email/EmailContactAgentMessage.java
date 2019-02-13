package com.transerainc.adaws.model.cache.contact.email;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.transerainc.adaws.constants.StateCacheConstants;
import com.transerainc.adaws.model.Attachments;
import com.transerainc.adaws.model.RequestData;

/**
 * @author tringuyen
 *
 */
public class EmailContactAgentMessage {

	private String cduId;
	private String subject;
	private String emailBody;
	private List<FilenameFilepathPair> attachments;

	/**
	 * 
	 */
	public EmailContactAgentMessage() {
	}

	/**
	 * @param cduId
	 * @param subject
	 * @param emailBody
	 * @param attachments
	 */
	public EmailContactAgentMessage(String cduId, String subject, String emailBody,
			List<FilenameFilepathPair> attachments) {
		this.cduId = cduId;
		this.subject = subject;
		this.emailBody = emailBody;
		this.attachments = attachments;
	}

	/**
	 * @return the cduId
	 */
	public String getCduId() {
		return cduId;
	}

	/**
	 * @param cduId the cduId to set
	 */
	public void setCduId(String cduId) {
		this.cduId = cduId;
	}

	/**
	 * @return the subject
	 */
	public String getSubject() {
		return subject;
	}

	/**
	 * @param subject the subject to set
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}

	/**
	 * @return the emailBody
	 */
	public String getEmailBody() {
		return emailBody;
	}

	/**
	 * @param emailBody the emailBody to set
	 */
	public void setEmailBody(String emailBody) {
		this.emailBody = emailBody;
	}

	/**
	 * @return the attachments
	 */
	public List<FilenameFilepathPair> getAttachments() {
		return attachments;
	}

	/**
	 * @param attachments the attachments to set
	 */
	public void setAttachments(List<FilenameFilepathPair> attachments) {
		this.attachments = attachments;
	}

	public String debugToString() {
		StringBuilder builder = new StringBuilder();
		builder.append("EmailContactAgentMessage ");
		builder.append("[");
		builder.append("cduId=");
		builder.append(cduId);
		builder.append(", subject=");
		builder.append(subject);
		builder.append(", emailBody=");
		builder.append(emailBody);
		builder.append(", attachments=");
		if ((attachments != null) && (attachments.size() > 0)) {
			for (FilenameFilepathPair attachment : attachments) {
				builder.append(attachment.debugToString());
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

		this.setCduId(requestData.getCduId());
		this.setSubject(requestData.getSubject());
		this.setEmailBody(requestData.getEmailBody());
		List<Attachments> requestDataAttachments = requestData.getAttachments();
		if (
				(requestDataAttachments == null)	|| 
				(requestDataAttachments.isEmpty())	|| 
				(requestDataAttachments.size() == 0)
		) {
			this.setAttachments(null);
		}
		if (attachments == null) {
			attachments = new ArrayList<FilenameFilepathPair>();
		}
		for (Attachments requestDataAttachment : requestDataAttachments) {
			attachments.add(
					new FilenameFilepathPair(requestDataAttachment.getFileName(), 
							requestDataAttachment.getFilePath()));
		}
	}

	protected static JSONArray toJsonObject(List<FilenameFilepathPair> filenameFilepathPairList) {
		final JSONArray filenameFilepathPairJsonArray = new JSONArray();
		if (
				(filenameFilepathPairList != null)			&& 
				(!filenameFilepathPairList.isEmpty())		&& 
				(filenameFilepathPairList.size() > 0)
			) {
			for (FilenameFilepathPair filenameFilepathPair : filenameFilepathPairList) {
				filenameFilepathPairJsonArray.put(filenameFilepathPair.toJsonObject());
			}
		}
		return filenameFilepathPairJsonArray;
	}

	public JSONObject toJsonObject() {
		final JSONObject emailContactAgentMessageJsonObject = new JSONObject();
		emailContactAgentMessageJsonObject.put(StateCacheConstants.CDU_ID_KEY, cduId);
		emailContactAgentMessageJsonObject.put(StateCacheConstants.SUBJECT_KEY, subject);
		emailContactAgentMessageJsonObject.put(StateCacheConstants.EMAIL_BODY_KEY, emailBody);
		emailContactAgentMessageJsonObject.put(StateCacheConstants.ATTACHMENTS_KEY, EmailContactAgentMessage.toJsonObject(attachments));
		return emailContactAgentMessageJsonObject;
	}

}
