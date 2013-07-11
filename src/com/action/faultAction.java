package com.action;



import java.sql.Date;
import java.util.List;

import com.Dao.Device;
import com.Dao.DeviceDAO;
import com.Dao.Fault;
import com.Dao.FaultDAO;
import com.opensymphony.xwork2.ActionSupport;

public class faultAction extends ActionSupport{
	
	private String did;
	private String solved;
	private List<Fault> faultList;
	private List fl;
	private FaultDAO dao = new FaultDAO();
	
	public String getDid() {
		return did;
	}
	public void setDid(String did) {
		this.did = did;
	}
	public String getSolved() {
		return solved;
	}
	public void setSolved(String solved) {
		this.solved = solved;
	}
	public List<Fault> getFaultList() {
		return faultList;
	}
	public void setFaultList(List<Fault> faultList) {
		this.faultList = faultList;
	}
	
	
	public String list_fault(){
		faultList = dao.findAll();	
		return SUCCESS;
	}
	
	public String find_fault(){
		faultList = dao.findBySolved(solved);
		return SUCCESS;
	}
}
