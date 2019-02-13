package com.transerainc.adaws.model;

/**
 * @author tringuyen
 *
 */
public class OmniChannelQueue {

	private Long id;
	private Long channelId;
	
	/**
	 * 
	 */
	public OmniChannelQueue() {
	}

	/**
	 * @param id
	 * @param channelId
	 */
	public OmniChannelQueue(Long id, Long channelId) {
		super();
		this.id = id;
		this.channelId = channelId;
	}

	/**
	 * @return the id
	 */
	public final Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public final void setId(Long id) {
		this.id = id;
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

	public String debugToString() {
		StringBuilder builder = new StringBuilder();
		builder.append("OmniChannelQueue [id=");
		builder.append(id);
		builder.append(", channelId=");
		builder.append(channelId);
		builder.append("]");
		return builder.toString();
	}

}
