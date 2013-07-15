package com.action;



import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.Dao.Device;
import com.Dao.DeviceDAO;
import com.Dao.Fault;
import com.Dao.FaultDAO;
import com.opensymphony.xwork2.ActionSupport;

public class faultAction extends ActionSupport implements ServletRequestAware,ServletResponseAware{
	
	private String did;
	private String solved;
	private List<Fault> faultList;
	private FaultDAO dao = new FaultDAO();
	private DeviceDAO ddao = new DeviceDAO();
	
	
	private HttpServletRequest request;
	private HttpServletResponse response;
	
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
//		for(int i=0;i<faultList.size();i++){
//			faultList.get(i).setDid(faultList.get(i).getDid()+"--"+ddao.findById(faultList.get(i).getDid()).getDname());
//		}
		return SUCCESS;
	}
	
	public String find_fault(){
		
		solved = request.getParameter("type");
		faultList = dao.findBySolved(solved);
		int j = faultList.size();
		for(int i=0;i<j;){
			Fault ttt = faultList.get(i);
			String ss[] = new String [3];
			ss = ttt.getDid().split("--");
			if(ss[0].equals(did) == false){
				faultList.remove(faultList.get(i));
				j--;
			}else{
				i++;
			}
		}
		return SUCCESS;
	}
	public void setServletRequest(HttpServletRequest arg0) {
		// TODO Auto-generated method stub
		request = arg0;
	}
	public void setServletResponse(HttpServletResponse arg0) {
		// TODO Auto-generated method stub
		response = arg0;
	}
}
