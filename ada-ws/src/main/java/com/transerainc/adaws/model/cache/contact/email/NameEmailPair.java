package com.transerainc.adaws.model.cache.contact.email;

import org.json.JSONObject;

import com.transerainc.adaws.constants.StateCacheConstants;

/**
 * @author tringuyen
 *
 */
public class NameEmailPair {

	private String name;
	private String email;

	/**
	 * 
	 */
	public NameEmailPair() {
	}

	/**
	 * @param name
	 * @param email
	 */
	public NameEmailPair(String name, String email) {
		this.name = name;
		this.email = email;
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
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	public String debugToString() {
		StringBuilder builder = new StringBuilder();
		builder.append("To ");
		builder.append("[");
		builder.append("name=");
		builder.append(name);
		builder.append(", email=");
		builder.append(email);
		builder.append("]");
		return builder.toString();
	}

	public JSONObject toJsonObject() {
		final JSONObject nameEmailPairJsonObject = new JSONObject();
		nameEmailPairJsonObject.put(StateCacheConstants.NAME_KEY, this.name);
		nameEmailPairJsonObject.put(StateCacheConstants.EMAIL_KEY, this.email);
		return nameEmailPairJsonObject;
	}

}
