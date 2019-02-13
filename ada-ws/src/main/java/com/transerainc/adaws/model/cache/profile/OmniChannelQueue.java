package com.transerainc.adaws.model.cache.profile;

/**
 * @author tnguyen
 *
 */
public class OmniChannelQueue {

	private long id;
	private String name;

	/**
	 * 
	 */
	public OmniChannelQueue() {
	}

	/**
	 * @param id
	 * @param name
	 */
	public OmniChannelQueue(long id, String name) {
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

	public String debugToString() {
		StringBuilder builder = new StringBuilder();
		builder.append("OmniChannelQueue [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append("]");
		return builder.toString();
	}

}
