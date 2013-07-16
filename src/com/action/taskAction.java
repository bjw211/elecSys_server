package com.action;

/**
 * 名称: taskAction
 * 描述: 该类用于处理服务器端任务的处理
 * 类型: JAVA
 * @author 李昌健
 */

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.Dao.Task;
import com.Dao.TaskDAO;
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
	
	private HttpServletRequest request;
	private HttpServletResponse response;
	
	  /**
	　　　 * 方法描述
	　　　 * 
		* 变量的set get群
	　　　 *
	　　　 */
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
	

	  /**
	　　　 * 方法描述
	　　　 * 
	　　　 * @param 
	　　　 * @return taskList
		* 获取所有的任务
	　　　 *
	　　　 */
	public String list_task(){
		taskList = dao.findAll();
		return SUCCESS;
	}
	

	  /**
	　　　 * 方法描述
	　　　 * 
	　　　 * @param String type state tname
	　　　 * @return taskList
		* 关键字查找，不符合要求的任务从列表中删除
	　　　 *
	　　　 */
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
	
	
	 /**
	　　　 * 方法描述
	　　　 * 
	　　　 * @param String type state tname
	　　　 * @return taskList
		* 关键字查找，不符合要求的任务从列表中删除,并且修改选中的项目
	　　　 *
	　　　 */
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
	public String modify_task(){
		 
		 return SUCCESS;
	 }
	

	  /**
	　　　 * 方法描述
	　　　 * 
	　　　 * @param String tid
	　　　 * @return taskList
		* 写入数据库，处理 删除任务的业务逻辑
	　　　 *
	　　　 */
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
	 
	/**继承自父类的方法需要实现**/ 
	public void setServletRequest(HttpServletRequest arg0) {
		// TODO Auto-generated method stub
		request = arg0;
	}
	public void setServletResponse(HttpServletResponse arg0) {
		// TODO Auto-generated method stub
		response = arg0;
	}
}
