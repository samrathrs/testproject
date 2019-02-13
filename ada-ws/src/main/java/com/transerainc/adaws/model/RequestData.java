package com.transerainc.adaws.model;

import java.util.List;

/**
 * @author tringuyen
 *
 */
public class RequestData {

	private String cduId;
	private String sessionId;
	private Long tenantId;
	private Long agentId;
	private String persistentCallbackUrl;
	private Long channelId;
	private Long entryPointId;
	private String templateName;
	private String templateSubject;
	private String templateContent;
	private Long resourceId;
	private Long processGuideId;
	private Long state;
	private Long auxkey;
	private Long auxCodeId;
	private Long outboundId;
	private Long reason;
	private Long onmniChannelQueueId;
	private Long answerTime;
	private Long wrapupStatus;
	private String logoutAction;
	private Long logoutReasonCode;
	private Long omniChannelQueueChannelId;
	private Long omniChannelQueueId;
	private String fileName;
	private String filePath;
	private String subject;
	private Boolean attachThread;
	private Boolean isDraft;
	private String emailBody;
	private List<EmailCouplet> to;
	private List<EmailCouplet> cc;
	private List<EmailCouplet> bcc;
	private EmailCouplet from;
	private String toMember;
	private String fromMember;
	private String source;
	private String msgType;
	private String message;
	private String agentComments;
	private DestinationDetails destinationDetails;
	private String comments;
    private CurrentQueue currentQueue;
    private Boolean isReminderSet;
    private List<EmailCouplet> customerEmail;
	private TransferDetails transferDetails;
	private WrapupDetail wrapupDetail;
	private FollowUp followUp;
	private OmniChannelQueue omniChannelQueue;
	private List<Attachments> attachments;
	private String trackingId;
	private Long contactPkey;
	private String status;
	private Long datetime ;
	private String outboundEmailAddress;
	
	/**
	 * 
	 */
	public RequestData() {
	}

	/**
	 * @param cduId
	 * @param sessionId
	 * @param tenantId
	 * @param agentId
	 * @param persistentCallbackUrl
	 * @param channelId
	 * @param entryPointId
	 * @param templateName
	 * @param templateSubject
	 * @param templateContent
	 * @param resourceId
	 * @param processGuideId
	 * @param state
	 * @param auxkey
	 * @param auxCodeId
	 * @param outboundId
	 * @param reason
	 * @param onmniChannelQueueId
	 * @param answerTime
	 * @param wrapupStatus
	 * @param logoutAction
	 * @param logoutReasonCode
	 * @param omniChannelQueueChannelId
	 * @param omniChannelQueueId
	 * @param fileName
	 * @param filePath
	 * @param subject
	 * @param attachThread
	 * @param emailBody
	 * @param to
	 * @param cc
	 * @param bcc
	 * @param from
	 * @param toMember
	 * @param fromMember
	 * @param source
	 * @param msgType
	 * @param message
	 * @param agentComments
	 * @param destinationDetails
	 * @param comments
	 * @param currentQueue
	 * @param isReminderSet
	 * @param transferDetails
	 * @param wrapupDetail
	 * @param followUp
	 * @param omniChannelQueue
	 */
	public RequestData(String cduId, String sessionId, Long tenantId, Long agentId, String persistentCallbackUrl,
			Long channelId, Long entryPointId, String templateName, String templateSubject, String templateContent,
			Long resourceId, Long processGuideId, Long state, Long auxkey, Long auxCodeId, Long outboundId, Long reason,
			Long onmniChannelQueueId, Long answerTime, Long wrapupStatus, String logoutAction, Long logoutReasonCode,
			Long omniChannelQueueChannelId, Long omniChannelQueueId, String fileName, String filePath, String subject,
			Boolean attachThread, String emailBody, List<EmailCouplet> to, List<EmailCouplet> cc,
			List<EmailCouplet> bcc, EmailCouplet from, String toMember, String fromMember, String source,
			String msgType, String message, String agentComments, DestinationDetails destinationDetails,
			String comments, CurrentQueue currentQueue, Boolean isReminderSet, TransferDetails transferDetails,
			WrapupDetail wrapupDetail, FollowUp followUp, OmniChannelQueue omniChannelQueue, List<Attachments> attachments,
			String trackingId, String status, Long contactPkey, Long datetime, String outboundEmailAddress,  List<EmailCouplet> customerEmail) {
		super();
		this.cduId = cduId;
		this.sessionId = sessionId;
		this.tenantId = tenantId;
		this.agentId = agentId;
		this.persistentCallbackUrl = persistentCallbackUrl;
		this.channelId = channelId;
		this.entryPointId = entryPointId;
		this.templateName = templateName;
		this.templateSubject = templateSubject;
		this.templateContent = templateContent;
		this.resourceId = resourceId;
		this.processGuideId = processGuideId;
		this.state = state;
		this.auxkey = auxkey;
		this.auxCodeId = auxCodeId;
		this.outboundId = outboundId;
		this.reason = reason;
		this.onmniChannelQueueId = onmniChannelQueueId;
		this.answerTime = answerTime;
		this.wrapupStatus = wrapupStatus;
		this.logoutAction = logoutAction;
		this.logoutReasonCode = logoutReasonCode;
		this.omniChannelQueueChannelId = omniChannelQueueChannelId;
		this.omniChannelQueueId = omniChannelQueueId;
		this.fileName = fileName;
		this.filePath = filePath;
		this.subject = subject;
		this.attachThread = attachThread;
		this.emailBody = emailBody;
		this.to = to;
		this.cc = cc;
		this.bcc = bcc;
		this.from = from;
		this.toMember = toMember;
		this.fromMember = fromMember;
		this.source = source;
		this.msgType = msgType;
		this.message = message;
		this.agentComments = agentComments;
		this.destinationDetails = destinationDetails;
		this.comments = comments;
		this.currentQueue = currentQueue;
		this.isReminderSet = isReminderSet;
		this.transferDetails = transferDetails;
		this.wrapupDetail = wrapupDetail;
		this.followUp = followUp;
		this.omniChannelQueue = omniChannelQueue;
		this.attachments =attachments;
		this.trackingId = trackingId;
		this.status = status;
		this.contactPkey =contactPkey;
		this.datetime = datetime;
		this.outboundEmailAddress =outboundEmailAddress;
		this.customerEmail = customerEmail;
	}

	/**
	 * @return the cduId
	 */
	public final String getCduId() {
		return cduId;
	}


	/**
	 * @param cduId the cduId to set
	 */
	public final void setCduId(String cduId) {
		this.cduId = cduId;
	}


	/**
	 * @return the sessionId
	 */
	public final String getSessionId() {
		return sessionId;
	}


	/**
	 * @param sessionId the sessionId to set
	 */
	public final void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}


	/**
	 * @return the tenantId
	 */
	public final Long getTenantId() {
		return tenantId;
	}


	/**
	 * @param tenantId the tenantId to set
	 */
	public final void setTenantId(Long tenantId) {
		this.tenantId = tenantId;
	}


	/**
	 * @return the agentId
	 */
	public final Long getAgentId() {
		return agentId;
	}


	/**
	 * @param agentId the agentId to set
	 */
	public final void setAgentId(Long agentId) {
		this.agentId = agentId;
	}


	/**
	 * @return the persistentCallbackUrl
	 */
	public final String getPersistentCallbackUrl() {
		return persistentCallbackUrl;
	}


	/**
	 * @param persistentCallbackUrl the persistentCallbackUrl to set
	 */
	public final void setPersistentCallbackUrl(String persistentCallbackUrl) {
		this.persistentCallbackUrl = persistentCallbackUrl;
	}


	/**
	 * @return the channelId
	 */
	public final Long getChannelId() {
		return channelId;
	}


	/**
	 * @param channelId the channelId to set
	 */
	public final void setChannelId(Long channelId) {
		this.channelId = channelId;
	}


	/**
	 * @return the entryPointId
	 */
	public final Long getEntryPointId() {
		return entryPointId;
	}


	/**
	 * @param entryPointId the entryPointId to set
	 */
	public final void setEntryPointId(Long entryPointId) {
		this.entryPointId = entryPointId;
	}


	/**
	 * @return the templateName
	 */
	public final String getTemplateName() {
		return templateName;
	}


	/**
	 * @param templateName the templateName to set
	 */
	public final void setTemplateName(String templateName) {
		this.templateName = templateName;
	}


	/**
	 * @return the templateSubject
	 */
	public final String getTemplateSubject() {
		return templateSubject;
	}


	/**
	 * @param templateSubject the templateSubject to set
	 */
	public final void setTemplateSubject(String templateSubject) {
		this.templateSubject = templateSubject;
	}


	/**
	 * @return the templateContent
	 */
	public final String getTemplateContent() {
		return templateContent;
	}


	/**
	 * @param templateContent the templateContent to set
	 */
	public final void setTemplateContent(String templateContent) {
		this.templateContent = templateContent;
	}


	/**
	 * @return the resourceId
	 */
	public final Long getResourceId() {
		return resourceId;
	}


	/**
	 * @param resourceId the resourceId to set
	 */
	public final void setResourceId(Long resourceId) {
		this.resourceId = resourceId;
	}


	/**
	 * @return the processGuideId
	 */
	public final Long getProcessGuideId() {
		return processGuideId;
	}


	/**
	 * @param processGuideId the processGuideId to set
	 */
	public final void setProcessGuideId(Long processGuideId) {
		this.processGuideId = processGuideId;
	}


	/**
	 * @return the state
	 */
	public final Long getState() {
		return state;
	}


	/**
	 * @param state the state to set
	 */
	public final void setState(Long state) {
		this.state = state;
	}


	/**
	 * @return the auxkey
	 */
	public final Long getAuxkey() {
		return auxkey;
	}


	/**
	 * @param auxkey the auxkey to set
	 */
	public final void setAuxkey(Long auxkey) {
		this.auxkey = auxkey;
	}


	/**
	 * @return the auxCodeId
	 */
	public final Long getAuxCodeId() {
		return auxCodeId;
	}


	/**
	 * @param auxCodeId the auxCodeId to set
	 */
	public final void setAuxCodeId(Long auxCodeId) {
		this.auxCodeId = auxCodeId;
	}


	/**
	 * @return the outboundId
	 */
	public final Long getOutboundId() {
		return outboundId;
	}


	/**
	 * @param outboundId the outboundId to set
	 */
	public final void setOutboundId(Long outboundId) {
		this.outboundId = outboundId;
	}


	/**
	 * @return the reason
	 */
	public final Long getReason() {
		return reason;
	}


	/**
	 * @param reason the reason to set
	 */
	public final void setReason(Long reason) {
		this.reason = reason;
	}


	/**
	 * @return the onmniChannelQueueId
	 */
	public final Long getOnmniChannelQueueId() {
		return onmniChannelQueueId;
	}


	/**
	 * @param onmniChannelQueueId the onmniChannelQueueId to set
	 */
	public final void setOnmniChannelQueueId(Long onmniChannelQueueId) {
		this.onmniChannelQueueId = onmniChannelQueueId;
	}


	/**
	 * @return the answerTime
	 */
	public final Long getAnswerTime() {
		return answerTime;
	}


	/**
	 * @param answerTime the answerTime to set
	 */
	public final void setAnswerTime(Long answerTime) {
		this.answerTime = answerTime;
	}


	/**
	 * @return the wrapupStatus
	 */
	public final Long getWrapupStatus() {
		return wrapupStatus;
	}


	/**
	 * @param wrapupStatus the wrapupStatus to set
	 */
	public final void setWrapupStatus(Long wrapupStatus) {
		this.wrapupStatus = wrapupStatus;
	}


	/**
	 * @return the logoutAction
	 */
	public final String getLogoutAction() {
		return logoutAction;
	}


	/**
	 * @param logoutAction the logoutAction to set
	 */
	public final void setLogoutAction(String logoutAction) {
		this.logoutAction = logoutAction;
	}


	/**
	 * @return the logoutReasonCode
	 */
	public final Long getLogoutReasonCode() {
		return logoutReasonCode;
	}


	/**
	 * @param logoutReasonCode the logoutReasonCode to set
	 */
	public final void setLogoutReasonCode(Long logoutReasonCode) {
		this.logoutReasonCode = logoutReasonCode;
	}


	/**
	 * @return the omniChannelQueueChannelId
	 */
	public final Long getOmniChannelQueueChannelId() {
		return omniChannelQueueChannelId;
	}


	/**
	 * @param omniChannelQueueChannelId the omniChannelQueueChannelId to set
	 */
	public final void setOmniChannelQueueChannelId(Long omniChannelQueueChannelId) {
		this.omniChannelQueueChannelId = omniChannelQueueChannelId;
	}


	/**
	 * @return the omniChannelQueueId
	 */
	public final Long getOmniChannelQueueId() {
		return omniChannelQueueId;
	}


	/**
	 * @param omniChannelQueueId the omniChannelQueueId to set
	 */
	public final void setOmniChannelQueueId(Long omniChannelQueueId) {
		this.omniChannelQueueId = omniChannelQueueId;
	}


	/**
	 * @return the fileName
	 */
	public final String getFileName() {
		return fileName;
	}


	/**
	 * @param fileName the fileName to set
	 */
	public final void setFileName(String fileName) {
		this.fileName = fileName;
	}


	/**
	 * @return the filePath
	 */
	public final String getFilePath() {
		return filePath;
	}


	/**
	 * @param filePath the filePath to set
	 */
	public final void setFilePath(String filePath) {
		this.filePath = filePath;
	}


	/**
	 * @return the subject
	 */
	public final String getSubject() {
		return subject;
	}


	/**
	 * @param subject the subject to set
	 */
	public final void setSubject(String subject) {
		this.subject = subject;
	}


	/**
	 * @return the attachThread
	 */
	public final Boolean getAttachThread() {
		return attachThread;
	}


	/**
	 * @param attachThread the attachThread to set
	 */
	public final void setAttachThread(Boolean attachThread) {
		this.attachThread = attachThread;
	}


	/**
	 * @return the emailBody
	 */
	public final String getEmailBody() {
		return emailBody;
	}


	/**
	 * @param emailBody the emailBody to set
	 */
	public final void setEmailBody(String emailBody) {
		this.emailBody = emailBody;
	}


	/**
	 * @return the to
	 */
	public List<EmailCouplet> getTo() {
		return to;
	}


	/**
	 * @param to the to to set
	 */
	public void setTo(List<EmailCouplet> to) {
		this.to = to;
	}


	/**
	 * @return the cc
	 */
	public List<EmailCouplet> getCc() {
		return cc;
	}





	/**
	 * @param cc the cc to set
	 */
	public void setCc(List<EmailCouplet> cc) {
		this.cc = cc;
	}





	/**
	 * @return the bcc
	 */
	public List<EmailCouplet> getBcc() {
		return bcc;
	}





	/**
	 * @param bcc the bcc to set
	 */
	public void setBcc(List<EmailCouplet> bcc) {
		this.bcc = bcc;
	}





	/**
	 * @return the from
	 */
	public EmailCouplet getFrom() {
		return from;
	}





	/**
	 * @param from the from to set
	 */
	public void setFrom(EmailCouplet from) {
		this.from = from;
	}





	/**
	 * @return the source
	 */
	public final String getSource() {
		return source;
	}


	/**
	 * @param source the source to set
	 */
	public final void setSource(String source) {
		this.source = source;
	}


	/**
	 * @return the msgType
	 */
	public final String getMsgType() {
		return msgType;
	}


	/**
	 * @param msgType the msgType to set
	 */
	public final void setMsgType(String msgType) {
		this.msgType = msgType;
	}


	/**
	 * @return the message
	 */
	public final String getMessage() {
		return message;
	}


	/**
	 * @param message the message to set
	 */
	public final void setMessage(String message) {
		this.message = message;
	}


	/**
	 * @return the agentComments
	 */
	public final String getAgentComments() {
		return agentComments;
	}


	/**
	 * @param agentComments the agentComments to set
	 */
	public final void setAgentComments(String agentComments) {
		this.agentComments = agentComments;
	}


	/**
	 * @return the destinationDetails
	 */
	public final DestinationDetails getDestinationDetails() {
		return destinationDetails;
	}


	/**
	 * @param destinationDetails the destinationDetails to set
	 */
	public final void setDestinationDetails(DestinationDetails destinationDetails) {
		this.destinationDetails = destinationDetails;
	}


	/**
	 * @return the comments
	 */
	public final String getComments() {
		return comments;
	}


	/**
	 * @param comments the comments to set
	 */
	public final void setComments(String comments) {
		this.comments = comments;
	}


	/**
	 * @return the currentQueue
	 */
	public CurrentQueue getCurrentQueue() {
		return currentQueue;
	}

	/**
	 * @param currentQueue the currentQueue to set
	 */
	public void setCurrentQueue(CurrentQueue currentQueue) {
		this.currentQueue = currentQueue;
	}

	/**
	 * @return the isReminderSet
	 */
	public Boolean getIsReminderSet() {
		return isReminderSet;
	}

	/**
	 * @param isReminderSet the isReminderSet to set
	 */
	public void setIsReminderSet(Boolean isReminderSet) {
		this.isReminderSet = isReminderSet;
	}

	/**
	 * @return the transferDetails
	 */
	public final TransferDetails getTransferDetails() {
		return transferDetails;
	}


	/**
	 * @param transferDetails the transferDetails to set
	 */
	public final void setTransferDetails(TransferDetails transferDetails) {
		this.transferDetails = transferDetails;
	}


	/**
	 * @return the wrapupDetail
	 */
	public final WrapupDetail getWrapupDetail() {
		return wrapupDetail;
	}


	/**
	 * @param wrapupDetail the wrapupDetail to set
	 */
	public final void setWrapupDetail(WrapupDetail wrapupDetail) {
		this.wrapupDetail = wrapupDetail;
	}


	/**
	 * @return the followUp
	 */
	public final FollowUp getFollowUp() {
		return followUp;
	}


	/**
	 * @param followUp the followUp to set
	 */
	public final void setFollowUp(FollowUp followUp) {
		this.followUp = followUp;
	}


	/**
	 * @return the omniChannelQueue
	 */
	public final OmniChannelQueue getOmniChannelQueue() {
		return omniChannelQueue;
	}


	/**
	 * @param omniChannelQueue the omniChannelQueue to set
	 */
	public final void setOmniChannelQueue(OmniChannelQueue omniChannelQueue) {
		this.omniChannelQueue = omniChannelQueue;
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


	public String debugToString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RequestData [cduId=");
		builder.append(cduId);
		builder.append(", sessionId=");
		builder.append(sessionId);
		builder.append(", tenantId=");
		builder.append(tenantId);
		builder.append(", agentId=");
		builder.append(agentId);
		builder.append(", persistentCallbackUrl=");
		builder.append(persistentCallbackUrl);
		builder.append(", channelId=");
		builder.append(channelId);
		builder.append(", entryPointId=");
		builder.append(entryPointId);
		builder.append(", templateName=");
		builder.append(templateName);
		builder.append(", templateSubject=");
		builder.append(templateSubject);
		builder.append(", templateContent=");
		builder.append(templateContent);
		builder.append(", resourceId=");
		builder.append(resourceId);
		builder.append(", processGuideId=");
		builder.append(processGuideId);
		builder.append(", state=");
		builder.append(state);
		builder.append(", auxkey=");
		builder.append(auxkey);
		builder.append(", auxCodeId=");
		builder.append(auxCodeId);
		builder.append(", outboundId=");
		builder.append(outboundId);
		builder.append(", reason=");
		builder.append(reason);
		builder.append(", onmniChannelQueueId=");
		builder.append(onmniChannelQueueId);
		builder.append(", answerTime=");
		builder.append(answerTime);
		builder.append(", wrapupStatus=");
		builder.append(wrapupStatus);
		builder.append(", logoutAction=");
		builder.append(logoutAction);
		builder.append(", logoutReasonCode=");
		builder.append(logoutReasonCode);
		builder.append(", omniChannelQueueChannelId=");
		builder.append(omniChannelQueueChannelId);
		builder.append(", omniChannelQueueId=");
		builder.append(omniChannelQueueId);
		builder.append(", fileName=");
		builder.append(fileName);
		builder.append(", filePath=");
		builder.append(filePath);
		builder.append(", subject=");
		builder.append(subject);
		builder.append(", attachThread=");
		builder.append(attachThread);
		builder.append(", emailBody=");
		builder.append(emailBody);
		builder.append(", to=");
		if ((to != null) && (!to.isEmpty()) && (to.size() > 0)) {
			for (EmailCouplet ec : to) {
				builder.append(ec.debugToString());
			}
		}
		else {
			builder.append("null");
		}
		if ((customerEmail != null) && (!customerEmail.isEmpty()) && (customerEmail.size() > 0)) {
			for (EmailCouplet ce : customerEmail) {
				builder.append(ce.debugToString());
			}
		}
		else {
			builder.append("null");
		}
		builder.append(", cc=");
		if ((cc != null) && (!cc.isEmpty()) && (cc.size() > 0)) {
			for (EmailCouplet ec : cc) {
				builder.append(ec.debugToString());
			}
		}
		else {
			builder.append("null");
		}
		builder.append(", bcc=");
		if ((bcc != null) && (!bcc.isEmpty()) && (bcc.size() > 0)) {
			for (EmailCouplet ec : bcc) {
				builder.append(ec.debugToString());
			}
		}
		else {
			builder.append("null");
		}
		builder.append(", from=");
		if (from != null) {
				builder.append(from.debugToString());
		}
		else {
			builder.append("null");
		}
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
		builder.append(", agentComments=");
		builder.append(agentComments);
		builder.append(", destinationDetails=");
		if (destinationDetails != null) {
			builder.append(destinationDetails.debugToString());
		}
		else {
			builder.append("null");
		}
		builder.append(", comments=");
		builder.append(comments);
		builder.append(", currentQueue=");
		if (currentQueue != null) {
			builder.append(currentQueue.debugToString());
		} else {
			builder.append("null");
		}
		builder.append(", isReminderSet=");
		builder.append(isReminderSet);
		builder.append(", transferDetails=");
		if (transferDetails != null) {
			builder.append(transferDetails.debugToString());
		} else {
			builder.append("null");
		}
		builder.append(", wrapupDetail=");
		if (wrapupDetail != null) {
			builder.append(wrapupDetail.debugToString());
		} else {
			builder.append("null");
		}
		builder.append(", followUp=");
		if (followUp != null) {
			builder.append(followUp.debugToString());
		} else {
			builder.append("null");
		}
		builder.append(", omniChannelQueue=");
		if (omniChannelQueue != null) {
			builder.append(omniChannelQueue.debugToString());
		} else {
			builder.append("null");
		}
		builder.append(", attachments=");
		if ((attachments != null) && (!attachments.isEmpty()) && (attachments.size() > 0)) {
			for (Attachments attachment : attachments) {
				builder.append(attachment.debugToString());
			}
		}
		else {
			builder.append("null");
		}
		builder.append("]");
		return builder.toString();
	}

	/**
	 * @return the trackingId
	 */
	public String getTrackingId() {
		return trackingId;
	}

	/**
	 * @param trackingId the trackingId to set
	 */
	public void setTrackingId(String trackingId) {
		this.trackingId = trackingId;
	}

	/**
	 * @return the attachments
	 */
	public List<Attachments> getAttachments() {
		return attachments;
	}

	/**
	 * @param attachments the attachments to set
	 */
	public void setAttachments(List<Attachments> attachments) {
		this.attachments = attachments;
	}

	/**
	 * @return the isDraft
	 */
	public Boolean getIsDraft() {
		return isDraft;
	}

	/**
	 * @param isDraft the isDraft to set
	 */
	public void setIsDraft(Boolean isDraft) {
		this.isDraft = isDraft;
	}

	/**
	 * @return the contactPkey
	 */
	public Long getContactPkey() {
		return contactPkey;
	}

	/**
	 * @param contactPkey the contactPkey to set
	 */
	public void setContactPkey(Long contactPkey) {
		this.contactPkey = contactPkey;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the datetime
	 */
	public Long getDatetime() {
		return datetime;
	}

	/**
	 * @param datetime the datetime to set
	 */
	public void setDatetime(Long datetime) {
		this.datetime = datetime;
	}

	/**
	 * @return the outboundEmailAddress
	 */
	public String getOutboundEmailAddress() {
		return outboundEmailAddress;
	}

	/**
	 * @param outboundEmailAddress the outboundEmailAddress to set
	 */
	public void setOutboundEmailAddress(String outboundEmailAddress) {
		this.outboundEmailAddress = outboundEmailAddress;
	}

	/**
	 * @return the customerEmail
	 */
	public List<EmailCouplet> getCustomerEmail() {
		return customerEmail;
	}

	/**
	 * @param customerEmail the customerEmail to set
	 */
	public void setCustomerEmail(List<EmailCouplet> customerEmail) {
		this.customerEmail = customerEmail;
	}

}
