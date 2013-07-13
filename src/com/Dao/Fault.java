package com.Dao;

import java.util.Date;

/**
 * Fault entity. @author MyEclipse Persistence Tools
 */

public class Fault implements java.io.Serializable {

	// Fields

	private Integer fid;
	private String did;
	private String content;
	private Date time;
	private String solved;

	// Constructors

	/** default constructor */
	public Fault() {
	}

	/** full constructor */
	public Fault(String did, String content, Date time, String solved) {
		this.did = did;
		this.content = content;
		this.time = time;
		this.solved = solved;
	}

	// Property accessors

	public Integer getFid() {
		return this.fid;
	}

	public void setFid(Integer fid) {
		this.fid = fid;
	}

	public String getDid() {
		return this.did;
	}

	public void setDid(String did) {
		this.did = did;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getTime() {
		return this.time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getSolved() {
		return this.solved;
	}

	public void setSolved(String solved) {
		this.solved = solved;
	}

}