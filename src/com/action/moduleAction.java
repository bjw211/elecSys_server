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
import com.Dao.Module;
import com.Dao.ModuleDAO;
import com.db.HibernateSessionFactory;
import com.opensymphony.xwork2.ActionSupport;

public class moduleAction extends ActionSupport implements ServletResponseAware, ServletRequestAware{
	
	private List<Module> moduleList;
	private String mid;
	private String mname;
	private Module mn;
	private ModuleDAO dao = new ModuleDAO();
	private DeviceDAO ddao = new DeviceDAO();
	private List<Device> dList;
	private Session session = HibernateSessionFactory.getSession();
	private Transaction tx = session.beginTransaction();
	
	private HttpServletRequest request;
	private HttpServletResponse response;
	
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public Module getMn() {
		return mn;
	}
	public void setMn(Module mn) {
		this.mn = mn;
	}
	public List<Module> getModuleList() {
		return moduleList;
	}
	public void setModuleList(List<Module> moduleList) {
		this.moduleList = moduleList;
	}
	
	public List<Device> getdList() {
		return dList;
	}
	public void setdList(List<Device> dList) {
		this.dList = dList;
	}
	public String list_module(){
		moduleList = dao.findAll();
		return SUCCESS;
	}
	
	public String list2(){
		moduleList = dao.findAll();
		return SUCCESS;
	}
	
	public String find_module(){
		moduleList = dao.findByMname(mname);
		return SUCCESS;
	}
	
	public String getModuleElement(){
		String[] str =request.getParameterValues("pro");
		for(int i=0;i<str.length;i++)
			System.out.println(str[i]);
		return SUCCESS;
	}
	
	public String delete_module(){
		Module m = new Module();
		m = dao.findById(mid);
		if(m == null){
			moduleList = dao.findAll();
			return ERROR;
		}else{
			dao.delete(m);
			tx.commit();
			moduleList = dao.findAll();
			session.close();
			return SUCCESS;
		}
	}
	
	public String add_module(){	
		dList = ddao.findAll();
		return SUCCESS;
	}
	
	 public String modify_module(){
				
			return SUCCESS;
		 }
	public void setServletResponse(HttpServletResponse arg0) {
		// TODO Auto-generated method stub
		response = arg0;
	}
	public void setServletRequest(HttpServletRequest arg0) {
		// TODO Auto-generated method stub
		request = arg0;
	}
}
