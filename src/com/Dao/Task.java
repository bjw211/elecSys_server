package com.Dao;

import java.util.Date;

/**
 * Task entity. @author MyEclipse Persistence Tools
 */

public class Task implements java.io.Serializable {

	// Fields

	private String tid;
	private Worker worker;
	private String tname;
	private Date stime;
	private Date deadline;
	private Date etime;
	private String state;
	private String devices;

	// Constructors

	/** default constructor */
	public Task() {
	}

	/** minimal constructor */
	public Task(String tid, Worker worker) {
		this.tid = tid;
		this.worker = worker;
	}

	/** full constructor */
	public Task(String tid, Worker worker, String tname, Date stime,
			Date deadline, Date etime, String state, String devices) {
		this.tid = tid;
		this.worker = worker;
		this.tname = tname;
		this.stime = stime;
		this.deadline = deadline;
		this.etime = etime;
		this.state = state;
		this.devices = devices;
	}

	// Property accessors

	public String getTid() {
		return this.tid;
	}

	public void setTid(String tid) {
		this.tid = tid;
	}

	public Worker getWorker() {
		return this.worker;
	}

	public void setWorker(Worker worker) {
		this.worker = worker;
	}

	public String getTname() {
		return this.tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	public Date getStime() {
		return this.stime;
	}

	public void setStime(Date stime) {
		this.stime = stime;
	}

	public Date getDeadline() {
		return this.deadline;
	}

	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}

	public Date getEtime() {
		return this.etime;
	}

	public void setEtime(Date etime) {
		this.etime = etime;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getDevices() {
		return this.devices;
	}

	public void setDevices(String devices) {
		this.devices = devices;
	}

}