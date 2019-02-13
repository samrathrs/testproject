/**
 * 
 */
package com.transerainc.adaws.model;

/**
 * @author jnarain
 *
 */
public class EmailCouplet {
	
	private String name;
    private String email;
	/**
	 * 
	 */
	public EmailCouplet() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EmailCouplet(String name, String email) {
		super();
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
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String debugToString() {
		StringBuilder builder = new StringBuilder();
		builder.append("EmailCouplet [name=");
		builder.append(name);
		builder.append(", email=");
		builder.append(email);
		builder.append("]");
		return builder.toString();
	}
}
