package com.transerainc.adaws.model.cache.contact.email;

import java.util.List;

/**
 * @author tringuyen
 *
 */
public class EmailContactArrivedMessageAgentMessage {

	private String cduId;
	private String subject;
	private String emailBody;
	private List<FilenameFilepathPair> attachments;

	/**
	 * 
	 */
	public EmailContactArrivedMessageAgentMessage() {
	}

	/**
	 * @param cduId
	 * @param subject
	 * @param emailBody
	 * @param attachments
	 */
	public EmailContactArrivedMessageAgentMessage(String cduId, String subject, String emailBody,
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
		builder.append("EmailContactArrivedMessageAgentMessage [cduId=");
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

	public EmailContactAgentMessage constructEmailContactAgentMessage() {
		return new EmailContactAgentMessage(
				cduId, 
				subject, 
				emailBody, 
				attachments
				);
	}

}
