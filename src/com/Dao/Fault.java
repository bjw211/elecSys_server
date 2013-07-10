package com.Dao;

import java.util.Date;

/**
 * Fault entity. @author MyEclipse Persistence Tools
 */

public class Fault implements java.io.Serializable {

	// Fields

	private String fid;
	private String did;
	private String content;
	private Date time;
	private String solved;

	// Constructors

	/** default constructor */
	public Fault() {
	}

	/** minimal constructor */
	public Fault(String fid) {
		this.fid = fid;
	}

	/** full constructor */
	public Fault(String fid, String did, String content, Date time,
			String solved) {
		this.fid = fid;
		this.did = did;
		this.content = content;
		this.time = time;
		this.solved = solved;
	}

	// Property accessors

	public String getFid() {
		return this.fid;
	}

	public void setFid(String fid) {
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