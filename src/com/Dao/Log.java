package com.Dao;

/**
 * Log entity. @author MyEclipse Persistence Tools
 */

public class Log implements java.io.Serializable {

	// Fields

	private String kid;
	private String value;

	// Constructors

	/** default constructor */
	public Log() {
	}

	/** minimal constructor */
	public Log(String kid) {
		this.kid = kid;
	}

	/** full constructor */
	public Log(String kid, String value) {
		this.kid = kid;
		this.value = value;
	}

	// Property accessors

	public String getKid() {
		return this.kid;
	}

	public void setKid(String kid) {
		this.kid = kid;
	}

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}