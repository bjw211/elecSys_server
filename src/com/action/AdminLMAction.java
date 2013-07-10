package com.action;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.Dao.Admin;
import com.Dao.AdminDAO;
import com.db.HibernateSessionFactory;
import com.opensymphony.xwork2.ActionSupport;

public class AdminLMAction extends ActionSupport{
	
	private String aid;
	private String pwd;
	private String npwd;
	private String nnpwd;
	private String aname;
	
	public String getAname() {
		return aname;
	}

	public void setAname(String aname) {
		this.aname = aname;
	}

	public String getNnpwd() {
		return nnpwd;
	}

	public void setNnpwd(String nnpwd) {
		this.nnpwd = nnpwd;
	}

	public String getNpwd() {
		return npwd;
	}

	public void setNpwd(String npwd) {
		this.npwd = npwd;
	}

	public String getAid() {
		return aid;
	}

	public void setAid(String aid) {
		this.aid = aid;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	Session session =HibernateSessionFactory.getSession();
	Transaction t= session.beginTransaction();
	
	public String checkLogin(){

		AdminDAO dao = new AdminDAO();
		Admin admin = dao.findById(aid);
		
		aname = admin.getAname();
		
		if(admin.getAid()== null){
			System.out.println("no such user");
			return ERROR;
		}
		
		if(admin.getPwd().equals(pwd)){
			System.out.println("ok");
			return SUCCESS;
		}
		return ERROR;
	}
	
	public String modify(){
		AdminDAO dao = new AdminDAO();
		Admin admin = dao.findById(aid);

		if(admin.getPwd().equals(pwd)){
			if(npwd.equals(nnpwd)){
				admin.setPwd(npwd);
				session.save(admin);
				t.commit();
				session.close();
				return SUCCESS;
			}
		}
		session.close();
		return ERROR;
	}
}
