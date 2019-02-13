package com.transerainc.adaws.model.cache.contact.email;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.transerainc.adaws.constants.StateCacheConstants;
import com.transerainc.adaws.model.EmailCouplet;
import com.transerainc.adaws.model.RequestData;

/**
 * @author tringuyen
 *
 */
public class EmailContactDetails {

	private static final Logger LOGGER = LoggerFactory.getLogger(EmailContactDetails.class);

	private String subject;
	private String body;
	private long entryPointId;
	private String trackingId;
	private String cduId;
	private long createTime;
	private long ronaTime;
	private NameEmailPair from;
	private List<NameEmailPair> to;
	private List<NameEmailPair> cc;
	private List<NameEmailPair> bcc;
	private boolean hasAttachments;
	private boolean isFromSupervisor;
	private long outboundId;

	/**
	 * 
	 */
	public EmailContactDetails() {
	}

	/**
	 * @param subject
	 * @param body
	 * @param entryPointId
	 * @param trackingId
	 * @param cduId
	 * @param createTime
	 * @param ronaTime
	 * @param from
	 * @param to
	 * @param cc
	 * @param bcc
	 * @param hasAttachments
	 * @param isFromSupervisor
	 */
	public EmailContactDetails(String subject, String body, long entryPointId, String trackingId, String cduId,
			long createTime, long ronaTime, NameEmailPair from, List<NameEmailPair> to, List<NameEmailPair> cc,
			List<NameEmailPair> bcc, boolean hasAttachments, boolean isFromSupervisor, long outboundId) {
		this.subject = subject;
		this.body = body;
		this.entryPointId = entryPointId;
		this.trackingId = trackingId;
		this.cduId = cduId;
		this.createTime = createTime;
		this.ronaTime = ronaTime;
		this.from = from;
		this.to = to;
		this.cc = cc;
		this.bcc = bcc;
		this.hasAttachments = hasAttachments;
		this.isFromSupervisor = isFromSupervisor;
		this.outboundId = outboundId;
	}

	/**
	 * @return the subject
	 */
	public String getSubject() {
		return subject;
	}

	public long getOutboundId() {
		return outboundId;
	}

	public void setOutboundId(long outboundId) {
		this.outboundId = outboundId;
	}

	/**
	 * @param subject the subject to set
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}

	/**
	 * @return the body
	 */
	public String getBody() {
		return body;
	}

	/**
	 * @param body the body to set
	 */
	public void setBody(String body) {
		this.body = body;
	}

	/**
	 * @param entryPointId the entryPointId to set
	 */
	public void setEntryPointId(long entryPointId) {
		this.entryPointId = entryPointId;
	}

	/**
	 * @param trackingId the trackingId to set
	 */
	public void setTrackingId(String trackingId) {
		this.trackingId = trackingId;
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
	 * @return the createTime
	 */
	public long getCreateTime() {
		return createTime;
	}

	/**
	 * @param createTime the createTime to set
	 */
	public void setCreateTime(long createTime) {
		this.createTime = createTime;
	}

	/**
	 * @return the ronaTime
	 */
	public long getRonaTime() {
		return ronaTime;
	}

	/**
	 * @param ronaTime the ronaTime to set
	 */
	public void setRonaTime(long ronaTime) {
		this.ronaTime = ronaTime;
	}

	/**
	 * @return the from
	 */
	public NameEmailPair getFrom() {
		return from;
	}

	/**
	 * @param from the from to set
	 */
	public void setFrom(NameEmailPair from) {
		this.from = from;
	}

	/**
	 * @return the to
	 */
	public List<NameEmailPair> getTo() {
		return to;
	}

	/**
	 * @param to the to to set
	 */
	public void setTo(List<NameEmailPair> to) {
		this.to = to;
	}

	public void addTo(NameEmailPair toAddressee) {
		if (to == null) {
			to = new ArrayList<NameEmailPair>();
		}
		to.add(toAddressee);
	}

	/**
	 * @return the cc
	 */
	public List<NameEmailPair> getCc() {
		return cc;
	}

	/**
	 * @param cc the cc to set
	 */
	public void setCc(List<NameEmailPair> cc) {
		this.cc = cc;
	}

	/**
	 * @return the bcc
	 */
	public List<NameEmailPair> getBcc() {
		return bcc;
	}

	/**
	 * @param bcc the bcc to set
	 */
	public void setBcc(List<NameEmailPair> bcc) {
		this.bcc = bcc;
	}

	/**
	 * @return the hasAttachments
	 */
	public boolean isHasAttachments() {
		return hasAttachments;
	}

	/**
	 * @param hasAttachments the hasAttachments to set
	 */
	public void setHasAttachments(boolean hasAttachments) {
		this.hasAttachments = hasAttachments;
	}

	/**
	 * @return the isFromSupervisor
	 */
	public boolean isFromSupervisor() {
		return isFromSupervisor;
	}

	/**
	 * @param isFromSupervisor the isFromSupervisor to set
	 */
	public void setFromSupervisor(boolean isFromSupervisor) {
		this.isFromSupervisor = isFromSupervisor;
	}

	public String debugToString() {
		StringBuilder builder = new StringBuilder();
		builder.append("EmailContactDetails [subject=");
		builder.append(subject);
		builder.append(", body=");
		builder.append(body);
		builder.append(", entryPointId=");
		builder.append(entryPointId);
		builder.append(", trackingId=");
		builder.append(trackingId);
		builder.append(", outboundId=");
		builder.append(outboundId);
		builder.append(", cduId=");
		builder.append(cduId);
		builder.append(", createTime=");
		builder.append(createTime);
		builder.append(", ronaTime=");
		builder.append(ronaTime);
		builder.append(", from=");
		if (from != null) {
			builder.append(from.debugToString());
		} else {
			builder.append("null");
		}
		builder.append(", to=");
		if ((to != null) && (to.size() > 0)) {
			for (NameEmailPair toDataEntry : to) {
				builder.append(toDataEntry.debugToString());
			}
		} else {
			builder.append("null");
		}
		builder.append(", cc=");
		if ((cc != null) && (cc.size() > 0)) {
			for (NameEmailPair ccDataEntry : cc) {
				builder.append(ccDataEntry.debugToString());
			}
		} else {
			builder.append("null");
		}
		builder.append(", bcc=");
		if ((bcc != null) && (bcc.size() > 0)) {
			for (NameEmailPair bccDataEntry : bcc) {
				builder.append(bccDataEntry.debugToString());
			}
		} else {
			builder.append("null");
		}
		builder.append(", hasAttachments=");
		builder.append(hasAttachments);
		builder.append(", isFromSupervisor=");
		builder.append(isFromSupervisor);
		builder.append("]");
		return builder.toString();
	}

	public void copyAttributes(RequestData requestData) {
		if (requestData == null) {
			return;
		}
		this.setToAttribute(requestData.getTo());
		this.setCcAttribute(requestData.getCc());
		this.setBccAttribute(requestData.getBcc());
		this.setSubject(requestData.getSubject());
		this.setBody(requestData.getEmailBody());
	}

	private void setBccAttribute(List<EmailCouplet> emailCoupletList) {
		if (
				(emailCoupletList == null)		|| 
				(emailCoupletList.isEmpty())	|| 
				(emailCoupletList.size() == 0)
			) {
			setTo(null);
			return;
		}
		this.to = new ArrayList<NameEmailPair>();
		for (EmailCouplet emailCouplet : emailCoupletList) {
			this.to.add(new NameEmailPair(emailCouplet.getName(), emailCouplet.getEmail()));
		}
	}

	private void setCcAttribute(List<EmailCouplet> emailCoupletList) {
		if (
				(emailCoupletList == null)		|| 
				(emailCoupletList.isEmpty())	|| 
				(emailCoupletList.size() == 0)
			) {
			setCc(null);
			return;
		}
		this.cc = new ArrayList<NameEmailPair>();
		for (EmailCouplet emailCouplet : emailCoupletList) {
			this.cc.add(new NameEmailPair(emailCouplet.getName(), emailCouplet.getEmail()));
		}
	}

	private void setToAttribute(List<EmailCouplet> emailCoupletList) {
		if (
				(emailCoupletList == null)		|| 
				(emailCoupletList.isEmpty())	|| 
				(emailCoupletList.size() == 0)
			) {
			setBcc(null);
			return;
		}
		this.bcc = new ArrayList<NameEmailPair>();
		for (EmailCouplet emailCouplet : emailCoupletList) {
			this.bcc.add(new NameEmailPair(emailCouplet.getName(), emailCouplet.getEmail()));
		}
	}

	public String toJsonString() {
		return this.toJsonObject().toString();
	}

	protected static JSONArray toJsonObject(List<NameEmailPair> nameEmailPairList) {
		final JSONArray nameEmailPairJsonArray = new JSONArray();
		if (
				(nameEmailPairList != null)			&& 
				(!nameEmailPairList.isEmpty())		&& 
				(nameEmailPairList.size() > 0)
			) {
			for (NameEmailPair nameEmailPair : nameEmailPairList) {
				nameEmailPairJsonArray.put(nameEmailPair.toJsonObject());
			}
		}
		return nameEmailPairJsonArray;
	}

	public JSONObject toJsonObject() {
		final JSONObject emailContactDetailJsonObject = new JSONObject();
		emailContactDetailJsonObject.put(StateCacheConstants.SUBJECT_KEY, this.subject);
		emailContactDetailJsonObject.put(StateCacheConstants.BODY_KEY, this.body);
		emailContactDetailJsonObject.put(StateCacheConstants.ENTRY_POINT_ID_KEY, this.entryPointId);
		emailContactDetailJsonObject.put(StateCacheConstants.TRACKING_ID_KEY, this.trackingId);
		emailContactDetailJsonObject.put(StateCacheConstants.CDU_ID_KEY, this.cduId);
		emailContactDetailJsonObject.put(StateCacheConstants.CREATE_TIME_KEY, this.createTime);
		emailContactDetailJsonObject.put(StateCacheConstants.RONA_TIME_KEY, this.ronaTime);
		emailContactDetailJsonObject.put(StateCacheConstants.OUTBOUND_ID, this.outboundId);
		JSONObject fromJsonObject = null;
		if (from != null) {
			fromJsonObject = from.toJsonObject();
		}
		emailContactDetailJsonObject.put(StateCacheConstants.FROM_KEY, fromJsonObject);
		emailContactDetailJsonObject.put(StateCacheConstants.TO_KEY, EmailContactDetails.toJsonObject(this.to));
		emailContactDetailJsonObject.put(StateCacheConstants.CC_KEY, EmailContactDetails.toJsonObject(this.cc));
		emailContactDetailJsonObject.put(StateCacheConstants.BCC_KEY, EmailContactDetails.toJsonObject(this.bcc));
		emailContactDetailJsonObject.put(StateCacheConstants.HAS_ATTACHMENTS_KEY, this.hasAttachments);
		emailContactDetailJsonObject.put(StateCacheConstants.IS_FROM_SUPERVISOR_KEY, this.isFromSupervisor);
		return emailContactDetailJsonObject;
	}

}
