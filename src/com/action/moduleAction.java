package com.action;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.Dao.Module;
import com.Dao.ModuleDAO;
import com.Dao.Worker;
import com.db.HibernateSessionFactory;
import com.opensymphony.xwork2.ActionSupport;
import com.sun.org.apache.bcel.internal.generic.NEW;

public class moduleAction extends ActionSupport{
	
	private List<Module> moduleList;
	private String mid;
	private String mname;
	private Module mn;
	private ModuleDAO dao = new ModuleDAO();
	private Session session = HibernateSessionFactory.getSession();
	private Transaction tx = session.beginTransaction();
	

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
	
	public String list_module(){
		moduleList = dao.findAll();
		return SUCCESS;
	}
	
	public String find_module(){
		moduleList = dao.findByMname(mname);
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
		dao.save(mn);
		tx.commit();
		moduleList = dao.findAll();
		session.close();
		return SUCCESS;
	}
	
	 public String modify_module(){
			String key = mn.getMid();
			Module m = dao.findById(key);
			dao.delete(m);
			dao.save(mn);
			tx.commit();
			moduleList = dao.findAll();
			session.close();
				
			return SUCCESS;
		 }
}
