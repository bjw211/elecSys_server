package com.Dao;

import java.util.HashSet;
import java.util.Set;

/**
 * Worker entity. @author MyEclipse Persistence Tools
 */

public class Worker implements java.io.Serializable {

	// Fields

	private String wid;
	private String wname;
	private String pwd;
	private String age;
	private String address;
	private String type;
	private String wtime;
	private Set tasks = new HashSet(0);

	// Constructors

	/** default constructor */
	public Worker() {
	}

	/** minimal constructor */
	public Worker(String wid) {
		this.wid = wid;
	}

	/** full constructor */
	public Worker(String wid, String wname, String pwd, String age,
			String address, String type, String wtime, Set tasks) {
		this.wid = wid;
		this.wname = wname;
		this.pwd = pwd;
		this.age = age;
		this.address = address;
		this.type = type;
		this.wtime = wtime;
		this.tasks = tasks;
	}

	// Property accessors

	public String getWid() {
		return this.wid;
	}

	public void setWid(String wid) {
		this.wid = wid;
	}

	public String getWname() {
		return this.wname;
	}

	public void setWname(String wname) {
		this.wname = wname;
	}

	public String getPwd() {
		return this.pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getAge() {
		return this.age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getWtime() {
		return this.wtime;
	}

	public void setWtime(String wtime) {
		this.wtime = wtime;
	}

	public Set getTasks() {
		return this.tasks;
	}

	public void setTasks(Set tasks) {
		this.tasks = tasks;
	}

}