/**
 * 
 */
package com.transerainc.adaws.model;

/**
 * @author jnarain
 *
 */
public class Category {
	
	private Long id;
	private String code;

	/**
	 * 
	 */
	public Category() {
	}

	/**
	 * @param id
	 * @param code
	 */
	public Category(Long id, String code) {
		super();
		this.id = id;
		this.code = code;
	}
	
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	
	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}
	
	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	public String debugToString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Category [id=");
		builder.append(id);
		builder.append(", code=");
		builder.append(code);
		builder.append("]");
		return builder.toString();
	}
	
	

}
