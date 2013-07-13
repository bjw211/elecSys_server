package com.Dao;

/**
 * Result entity. @author MyEclipse Persistence Tools
 */

public class Result implements java.io.Serializable {

	// Fields

	private ResultId id;
	private String value;

	// Constructors

	/** default constructor */
	public Result() {
	}

	/** minimal constructor */
	public Result(ResultId id) {
		this.id = id;
	}

	/** full constructor */
	public Result(ResultId id, String value) {
		this.id = id;
		this.value = value;
	}

	// Property accessors

	public ResultId getId() {
		return this.id;
	}

	public void setId(ResultId id) {
		this.id = id;
	}

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}