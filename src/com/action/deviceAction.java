package com.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.Dao.Device;
import com.Dao.DeviceDAO;
import com.Dao.Worker;
import com.db.HibernateSessionFactory;
import com.opensymphony.xwork2.ActionSupport;

public class deviceAction extends ActionSupport implements ServletRequestAware, ServletResponseAware{
	private List<Device> deviceList;
	private DeviceDAO dao = new DeviceDAO();
	private String dname;
	private String did;
	private String type;
	private Device dc;
	private Session session = HibernateSessionFactory.getSession();
	private Transaction tx = session.beginTransaction();
	
	
	private HttpServletRequest request;
	private HttpServletResponse response;
	
	
	
	public List<Device> getDeviceList() {
		return deviceList;
	}
	public void setDeviceList(List<Device> deviceList) {
		this.deviceList = deviceList;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getDid() {
		return did;
	}
	public void setDid(String did) {
		this.did = did;
	}
	public Device getDc() {
		return dc;
	}
	public void setDc(Device dc) {
		this.dc = dc;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String list_device(){
		deviceList = dao.findAll();
		return SUCCESS;
	}
	
	
	public String list(){
		deviceList = dao.findAll();
		return SUCCESS;
	}
	
	public String find_device(){
		deviceList = dao.findByType(type);
		return SUCCESS;
	}
	
	public String getDeviceElement(){
		String[] str = new String[20];
		if(request == null){
			System.out.println("fuck");
			return SUCCESS;
		}
		str = request.getParameterValues("pro");
		for(int i=0;i<str.length;i++)
			System.out.println(str[i]);
		return SUCCESS;
	}
	
	public String delete_device(){
		Device d = dao.findById(did);
		if(d == null){
			deviceList = dao.findAll();
			return ERROR;
		}else{
			dao.delete(d);
			tx.commit();
			deviceList = dao.findAll();
			session.close();
			return SUCCESS;
		}
	}
	
	public String add_device(){
		dao.save(dc);
		tx.commit();
		deviceList = dao.findAll();
		session.close();
		return SUCCESS;
	}
	
	public String modify_device(){
		String key = dc.getDid();
		Device d = dao.findById(key);
		dao.delete(d);
		dao.save(dc);
		tx.commit();
		deviceList = dao.findAll();
		session.close();
			
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
