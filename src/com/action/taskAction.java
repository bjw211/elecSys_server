package com.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.Dao.Module;
import com.Dao.Task;
import com.Dao.TaskDAO;
import com.Dao.Worker;
import com.db.HibernateSessionFactory;
import com.opensymphony.xwork2.ActionSupport;

public class taskAction extends ActionSupport implements ServletRequestAware, ServletResponseAware{
	
	private List<Task> taskList;
	private String state;
	private String tid;
	private TaskDAO dao = new TaskDAO();
	private Session session = HibernateSessionFactory.getSession();
	private Transaction tx = session.beginTransaction();
	private String tname;
	private String tmp;
	
	private HttpServletRequest request;
	private HttpServletResponse response;
	
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
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
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
		state = request.getParameter("type");
		System.out.println(state);
		taskList = dao.findAll();
		int j = taskList.size();
		for(int i=0;i<j;){
			Task tt = taskList.get(i);
			if(tt.getTname().contains(tname) == false || tt.getState().equals(state) == false){			
				taskList.remove(tt);
				j--;
			}else{
				i++;
			}
		}
		return SUCCESS;
	}
	
	public String find_task1(){
		
		state = request.getParameter("type");
		System.out.println(state);
		taskList = dao.findAll();
		int j = taskList.size();
		for(int i=0;i<j;){
			Task tt = taskList.get(i);
			if(tt.getTname().contains(tname) == false || tt.getState().equals(state) == false){			
				taskList.remove(tt);
				j--;
			}else{
				i++;
			}
		}
		return SUCCESS;
	}
	
	 public String delete_task(){
		 
		 tid = request.getParameter("pro");	 
		Task t = dao.findById(tid);
		if(t ==null){
			taskList = dao.findAll();
			return ERROR;
		}else{
			dao.delete(t);
			tx.commit();
			taskList = dao.findAll();
			session.close();
			return SUCCESS;
		}
	 }
	 
	 public String modify_task(){
		 
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
