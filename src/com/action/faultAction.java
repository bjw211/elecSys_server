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
	private String dname;
	private List<Fault> faultList;
	private List fl;
	private FaultDAO dao = new FaultDAO();
	
	public String getDid() {
		return did;
	}
	public void setDid(String did) {
		this.did = did;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public List<Fault> getFaultList() {
		return faultList;
	}
	public void setFaultList(List<Fault> faultList) {
		this.faultList = faultList;
	}
	
	
	public String list_fault(){
		faultList = dao.findAll();
		DeviceDAO da = new DeviceDAO(); 
		for(int i = 0;i<faultList.size(); i++){
			String name = da.findById(faultList.get(i).getDid()).getDname();
			faultList.get(i).setDid(faultList.get(i).getDid()+"--"+name);
		}
		
		return SUCCESS;
	}
	
	public String find_fault(){
		faultList = dao.findByDid(did);
		return SUCCESS;
	}
}
