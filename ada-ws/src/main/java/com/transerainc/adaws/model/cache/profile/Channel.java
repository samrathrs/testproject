package com.transerainc.adaws.model.cache.profile;

/**
 * @author tnguyen
 *
 */
public class Channel {

	private long id;
	private String name;
	private OmniChannelQueue[] omniChannelQueues;

	/**
	 * 
	 */
	public Channel() {
	}

	/**
	 * @param id
	 * @param name
	 */
	public Channel(long id, String name) {
		this.id = id;
		this.name = name;
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the omniChannelQueues
	 */
	public OmniChannelQueue[] getOmniChannelQueues() {
		return omniChannelQueues;
	}

	/**
	 * @param omniChannelQueues the omniChannelQueues to set
	 */
	public void setOmniChannelQueues(OmniChannelQueue[] omniChannelQueues) {
		this.omniChannelQueues = omniChannelQueues;
	}

	public String debugToString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Channel [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", omniChannelQueues=");
		if ((omniChannelQueues != null) && (omniChannelQueues.length > 0)) {
			for(OmniChannelQueue omniChannelQueue : omniChannelQueues) {
				builder.append(omniChannelQueue.debugToString());
			}
		} else {
			builder.append("null");
		}
		builder.append("]");
		return builder.toString();
	}

}
