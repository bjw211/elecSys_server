package com.Dao;

/**
 * Module entity. @author MyEclipse Persistence Tools
 */

public class Module implements java.io.Serializable {

	// Fields

	private String mid;
	private String mname;
	private String devices;

	// Constructors

	/** default constructor */
	public Module() {
	}

	/** minimal constructor */
	public Module(String mid) {
		this.mid = mid;
	}

	/** full constructor */
	public Module(String mid, String mname, String devices) {
		this.mid = mid;
		this.mname = mname;
		this.devices = devices;
	}

	// Property accessors

	public String getMid() {
		return this.mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public String getMname() {
		return this.mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public String getDevices() {
		return this.devices;
	}

	public void setDevices(String devices) {
		this.devices = devices;
	}

}