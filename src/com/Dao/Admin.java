package com.Dao;

/**
 * Admin entity. @author MyEclipse Persistence Tools
 */

public class Admin implements java.io.Serializable {

	// Fields

	private String aid;
	private String aname;
	private String pwd;

	// Constructors

	/** default constructor */
	public Admin() {
	}

	/** minimal constructor */
	public Admin(String aid) {
		this.aid = aid;
	}

	/** full constructor */
	public Admin(String aid, String aname, String pwd) {
		this.aid = aid;
		this.aname = aname;
		this.pwd = pwd;
	}

	// Property accessors

	public String getAid() {
		return this.aid;
	}

	public void setAid(String aid) {
		this.aid = aid;
	}

	public String getAname() {
		return this.aname;
	}

	public void setAname(String aname) {
		this.aname = aname;
	}

	public String getPwd() {
		return this.pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

}