package com.action;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.Dao.Task;
import com.Dao.TaskDAO;
import com.Dao.Worker;
import com.db.HibernateSessionFactory;
import com.opensymphony.xwork2.ActionSupport;

public class taskAction extends ActionSupport{
	
	private List<Task> taskList;
	private String state;
	private String tid;
	private TaskDAO dao = new TaskDAO();
	private Session session = HibernateSessionFactory.getSession();
	private Transaction tx = session.beginTransaction();
	
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getTid() {
		return tid;
	}
	public void setTid(String tid) {
		this.tid = tid;
	}
	public List<Task> getTaskList() {
		return taskList;
	}
	public void setTaskList(List<Task> taskList) {
		this.taskList = taskList;
	}
	
	public String list_task(){
		taskList = dao.findAll();
		return SUCCESS;
	}
	
	public String find_task(){
		taskList = dao.findByState(state);
		return SUCCESS;
	}
	
	 public String delete_task(){
		Task t = dao.findById(tid);
		if(t ==null){
			taskList = dao.findAll();
			return ERROR;
		}else{
			dao.delete(t);
			tx.commit();
			taskList = dao.findAll();
			return SUCCESS;
		}
	 }
}
