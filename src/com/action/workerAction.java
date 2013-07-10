package com.action;

import java.util.*;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.Dao.Device;
import com.Dao.Worker;
import com.Dao.WorkerDAO;
import com.db.HibernateSessionFactory;
import com.opensymphony.xwork2.ActionSupport;

public class workerAction extends ActionSupport {

	private List<Worker> workerList;
	private String wname;
	private String wid;
	private String key;
	private static WorkerDAO dao = new WorkerDAO();
	private Worker nw;
	private Session session = HibernateSessionFactory.getSession();
	private Transaction tx = session.beginTransaction();

	public List<Worker> getWorkerList() {
		return workerList;
	}

	public void setWorkerList(List<Worker> workerList) {
		this.workerList = workerList;
	}

	public Worker getNw() {
		return nw;
	}

	public void setNw(Worker nw) {
		this.nw = nw;
	}

	public String getWid() {
		return wid;
	}

	public void setWid(String wid) {
		this.wid = wid;
	}

	public String getWname() {
		return wname;
	}

	public void setWname(String wname) {
		this.wname = wname;
	}

	// 工人的 增删改查
	public String list_worker() {
		workerList = dao.findAll();
		return SUCCESS;
	}

	public String find_worker() {
		workerList = dao.findByWname(wname);
		return SUCCESS;
	}

	//方法bug在于数据库的列名使用了保留字
	public String add_worker() {	
		dao.save(nw);
		tx.commit();
		workerList = dao.findAll();
		session.close();
		return SUCCESS;
	}

	 public String delete_worker(){
		Worker w = dao.findById(wid);
		if(w ==null){
			workerList = dao.findAll();
			return ERROR;
		}else{
			dao.delete(w);
			tx.commit();
			workerList = dao.findAll();
			return SUCCESS;
		}
	 }
	 public String modify_worker(){
		key = nw.getWid();
		Worker d = dao.findById(key);
		dao.delete(d);
		dao.save(nw);
		tx.commit();
		workerList = dao.findAll();
		session.close();
			
		return SUCCESS;
	 }

}
