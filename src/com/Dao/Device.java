package com.Dao;

/**
 * Device entity. @author MyEclipse Persistence Tools
 */

public class Device implements java.io.Serializable {

	// Fields

	private String did;
	private String dname;
	private String type;
	private String address;
	private String qr;
	private String checkItem;

	// Constructors

	/** default constructor */
	public Device() {
	}

	/** minimal constructor */
	public Device(String did) {
		this.did = did;
	}

	/** full constructor */
	public Device(String did, String dname, String type, String address,
			String qr, String checkItem) {
		this.did = did;
		this.dname = dname;
		this.type = type;
		this.address = address;
		this.qr = qr;
		this.checkItem = checkItem;
	}

	// Property accessors

	public String getDid() {
		return this.did;
	}

	public void setDid(String did) {
		this.did = did;
	}

	public String getDname() {
		return this.dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getQr() {
		return this.qr;
	}

	public void setQr(String qr) {
		this.qr = qr;
	}

	public String getCheckItem() {
		return this.checkItem;
	}

	public void setCheckItem(String checkItem) {
		this.checkItem = checkItem;
	}

}