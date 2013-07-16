package com.action;

/**
 * 名称: AdminLMAction
 * 描述: 该类用于处理服务器端管理员的登录、修改密码
 * 类型: JAVA
 * @author 李昌健
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
	　　　 * 方法描述
	　　　 * 
		* 变量的set get群
	　　　 *
	　　　 */
	
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
	　　　 * 方法描述
	　　　 * 
	　　　 * @param String aid   String pwd
	　　　 * @return loginSuccessfully  --> SUCCESS  or  ERROR
		* 验证管理员登录
	　　　 *
	　　　 */
	public String checkLogin() {
		AdminDAO dao = new AdminDAO();
		Admin admin = dao.findById(aid);
		
		/**管理员账号为空**/
		if (admin == null) {
			System.out.println("no such user");
			return ERROR;
		}
		/**密码验证正确**/
		if (admin.getPwd().equals(pwd)) {
			aname = admin.getAname();
			System.out.println("login success!");
			return SUCCESS;
		}

		return ERROR;
	}

		/**
	　　　 * 方法描述
	　　　 * 
	　　　 * @param String pwd npwd nnpwd
	　　　 * @return modifySuccessfully  --> SUCCESS  or  ERROR
		* 修改管理员密码
	　　　 *
	　　　 */
	public String modify() {

		AdminDAO dao = new AdminDAO();
		Admin admin = dao.findById(aid);
		
		/**验证修改密码并写入数据库**/
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
