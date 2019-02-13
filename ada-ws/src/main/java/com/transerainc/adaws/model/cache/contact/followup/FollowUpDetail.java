package com.transerainc.adaws.model.cache.contact.followup;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.transerainc.adaws.constants.StateCacheConstants;

/**
 * @author tringuyen
 *
 */
public class FollowUpDetail {

	private static final Logger LOGGER = LoggerFactory.getLogger(FollowUpDetail.class);

	private long omniChannelQueueId;
	private String trackingId;
	private String cduId;
	private String status;
	private long dateTime;
	private String comments;
	private long createDateTime;
	private long contactPkey;
	private String fromEmailAddress;
	private String channelId;

	/**
	 * 
	 */
	public FollowUpDetail() {
	}

	/**
	 * @param omniChannelQueueId
	 * @param trackingId
	 * @param cduId
	 * @param status
	 * @param dateTime
	 * @param comments
	 * @param createDateTime
	 * @param contactPkey
	 * @param fromEmailAddress
	 * @param channelId
	 */
	public FollowUpDetail(long omniChannelQueueId, String trackingId, String cduId, String status, long dateTime,
			String comments, long createDateTime, long contactPkey, String fromEmailAddress, String channelId) {
		this.omniChannelQueueId = omniChannelQueueId;
		this.trackingId = trackingId;
		this.cduId = cduId;
		this.status = status;
		this.dateTime = dateTime;
		this.comments = comments;
		this.createDateTime = createDateTime;
		this.contactPkey = contactPkey;
		this.fromEmailAddress = fromEmailAddress;
		this.channelId = channelId;
	}

	/**
	 * @return the omniChannelQueueId
	 */
	public long getOmniChannelQueueId() {
		return omniChannelQueueId;
	}

	/**
	 * @param omniChannelQueueId the omniChannelQueueId to set
	 */
	public void setOmniChannelQueueId(long omniChannelQueueId) {
		this.omniChannelQueueId = omniChannelQueueId;
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
	 * @return the dateTime
	 */
	public long getDateTime() {
		return dateTime;
	}

	/**
	 * @param dateTime the dateTime to set
	 */
	public void setDateTime(long dateTime) {
		this.dateTime = dateTime;
	}

	/**
	 * @return the comments
	 */
	public String getComments() {
		return comments;
	}

	/**
	 * @param comments the comments to set
	 */
	public void setComments(String comments) {
		this.comments = comments;
	}

	/**
	 * @return the createDateTime
	 */
	public long getCreateDateTime() {
		return createDateTime;
	}

	/**
	 * @param createDateTime the createDateTime to set
	 */
	public void setCreateDateTime(long createDateTime) {
		this.createDateTime = createDateTime;
	}

	/**
	 * @return the contactPkey
	 */
	public long getContactPkey() {
		return contactPkey;
	}

	/**
	 * @param contactPkey the contactPkey to set
	 */
	public void setContactPkey(long contactPkey) {
		this.contactPkey = contactPkey;
	}

	/**
	 * @return the fromEmailAddress
	 */
	public String getFromEmailAddress() {
		return fromEmailAddress;
	}

	/**
	 * @param fromEmailAddress the fromEmailAddress to set
	 */
	public void setFromEmailAddress(String fromEmailAddress) {
		this.fromEmailAddress = fromEmailAddress;
	}

	/**
	 * @return the channelId
	 */
	public String getChannelId() {
		return channelId;
	}

	/**
	 * @param channelId the channelId to set
	 */
	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}

	public String debugToString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FollowUpDetail ");
		builder.append("[");
		builder.append("omniChannelQueueId=");
		builder.append(omniChannelQueueId);
		builder.append(", trackingId=");
		builder.append(trackingId);
		builder.append(", cduId=");
		builder.append(cduId);
		builder.append(", status=");
		builder.append(status);
		builder.append(", dateTime=");
		builder.append(dateTime);
		builder.append(", comments=");
		builder.append(comments);
		builder.append(", createDateTime=");
		builder.append(createDateTime);
		builder.append(", contactPkey=");
		builder.append(contactPkey);
		builder.append(", fromEmailAddress=");
		builder.append(fromEmailAddress);
		builder.append(", channelId=");
		builder.append(channelId);
		builder.append("]");
		return builder.toString();
	}

	public JSONObject toJsonObject() {
		final JSONObject followDetailJsonObject = new JSONObject();
		followDetailJsonObject.put(StateCacheConstants.OMNI_CHANNEL_QUEUE_ID_KEY, omniChannelQueueId);
		followDetailJsonObject.put(StateCacheConstants.TRACKING_ID_KEY, trackingId);
		followDetailJsonObject.put(StateCacheConstants.CDU_ID_KEY, cduId);
		followDetailJsonObject.put(StateCacheConstants.STATUS_KEY, status);
		followDetailJsonObject.put(StateCacheConstants.DATE_TIME_KEY, dateTime);
		followDetailJsonObject.put(StateCacheConstants.COMMENTS_KEY, comments);
		followDetailJsonObject.put(StateCacheConstants.CREATE_DATE_TIME_KEY, createDateTime);
		followDetailJsonObject.put(StateCacheConstants.CONTACT_PKEY_KEY, contactPkey);
		followDetailJsonObject.put(StateCacheConstants.FROM_EMAIL_ADDRESS_KEY, fromEmailAddress);
		followDetailJsonObject.put(StateCacheConstants.CHANNEL_ID_KEY, channelId);
		return followDetailJsonObject;
	}

}
