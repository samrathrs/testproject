/**
 * 
 */
package com.transerainc.ara.domain;

public class Server {
	public Long id;

	private String name;

	/**
	 * @param id
	 */
	public Server(Long id) {
		super();
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}