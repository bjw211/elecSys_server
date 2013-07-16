package com.action;

/**
 * ����: AdminLMAction
 * ����: �������ڴ���������˹���Ա�ĵ�¼���޸�����
 * ����: JAVA
 * @author �����
 */ 

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.Dao.Admin;
import com.Dao.AdminDAO;
import com.db.HibernateSessionFactory;
import com.opensymphony.xwork2.ActionSupport;

public class AdminLMAction extends ActionSupport {

	private String aid;
	private String pwd;
	private String npwd;
	private String nnpwd;
	private String aname;
	private Session session = HibernateSessionFactory.getSession();
	private Transaction t = session.beginTransaction();

	  /**
	������ * ��������
	������ * 
		* ������set getȺ
	������ *
	������ */
	
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

	
		/**
	������ * ��������
	������ * 
	������ * @param String aid   String pwd
	������ * @return loginSuccessfully  --> SUCCESS  or  ERROR
		* ��֤����Ա��¼
	������ *
	������ */
	public String checkLogin() {
		AdminDAO dao = new AdminDAO();
		Admin admin = dao.findById(aid);
		
		/**����Ա�˺�Ϊ��**/
		if (admin == null) {
			System.out.println("no such user");
			return ERROR;
		}
		/**������֤��ȷ**/
		if (admin.getPwd().equals(pwd)) {
			aname = admin.getAname();
			System.out.println("login success!");
			return SUCCESS;
		}

		return ERROR;
	}

		/**
	������ * ��������
	������ * 
	������ * @param String pwd npwd nnpwd
	������ * @return modifySuccessfully  --> SUCCESS  or  ERROR
		* �޸Ĺ���Ա����
	������ *
	������ */
	public String modify() {

		AdminDAO dao = new AdminDAO();
		Admin admin = dao.findById(aid);
		
		/**��֤�޸����벢д�����ݿ�**/
		if (admin.getPwd().equals(pwd)) {
			if (npwd.equals(nnpwd)) {
				admin.setPwd(npwd);
				session.save(admin);
				t.commit();
				session.close();
				System.out.println("modify the pwd successfully");
				return SUCCESS;
			}
		}
		return ERROR;
	}
}
