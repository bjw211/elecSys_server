package com.action;

/**
 * ����: workerAction
 * ����: �������ڴ���������˹��˵Ĵ���
 * ����: JAVA
 * @author �����
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
import com.Dao.Worker;
import com.Dao.WorkerDAO;
import com.db.HibernateSessionFactory;
import com.opensymphony.xwork2.ActionSupport;

public class workerAction extends ActionSupport implements ServletRequestAware, ServletResponseAware{

	private List<Worker> workerList;
	private String wname;
	private String wid;
	private String type;
	private String age;
	private static WorkerDAO dao = new WorkerDAO();
	private TaskDAO tdao = new TaskDAO();
	private List<Task> tlist;
	private Worker nw;
	private Session session = HibernateSessionFactory.getSession();
	private Transaction tx = session.beginTransaction();

	private HttpServletRequest request;
	private HttpServletResponse response;
	
	  /**
	������ * ��������
	������ * 
		* ������set getȺ
	������ *
	������ */
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

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getWname() {
		return wname;
	}

	public void setWname(String wname) {
		this.wname = wname;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	/**���˵���ɾ�Ĳ�**/

	  /**
	������ * ��������
	������ * 
	������ * @param 
	������ * @return workertList
		* ��ȡ���еĹ���
	������ *
	������ */
	public String list_worker() {
		workerList = dao.findAll();
		return SUCCESS;
	}


	  /**
	������ * ��������
	������ * 
	������ * @param String type wname
	������ * @return workerList
		* �ؼ��ֲ��ң�������Ҫ��Ĺ��˴��б���ɾ��
	������ *
	������ */
	public String find_worker() {
		
		workerList = dao.findByType(type);
		
		int j = workerList.size();
		for(int i=0;i<j;){
			Worker ww = workerList.get(i);
			if(ww.getWname().contains(wname) ==  false || Integer.parseInt(ww.getAge()) >= Integer.parseInt(age)){
				workerList.remove(ww);
				j --;
			}else{
				i++;
			}
		}
		return SUCCESS;
	}


	  /**
	������ * ��������
	������ * 
	������ * @param Worker nw
	������ * @return workerList
		* д�����ݿ⣬�������ӹ��˵�ҵ���߼�
	������ *
	������ */
	public String add_worker() {	//����bug�������ݿ������ʹ���˱�����
		dao.save(nw);
		tx.commit();
		workerList = dao.findAll();
		session.close();
		return SUCCESS;
	}


	  /**
	������ * ��������
	������ * 
	������ * @param Worker nw
	������ * @return workerList
		* д�����ݿ⣬����ɾ�����˵�ҵ���߼�
	������ *
	������ */
	public String delete_worker(){
		
		/**�ӱ���ȡ����ID**/
		wid = request.getParameter("pro");
		Worker w = dao.findById(wid);
		
		if(w == null){
			workerList = dao.findAll();
			return ERROR;
		}else{
			tlist = tdao.findAll();
			
			for(int i=0;i<tlist.size();i++){
				Task t = tlist.get(i);
				if(t.getWorker().getWid().equals(w.getWid())){
					if(!t.getState().equals("DONE")){
						return ERROR;
					}else{
						tdao.delete(t);
					}
				}
			}
			dao.delete(w);
			tx.commit();
			workerList = dao.findAll();
			session.close();
			return SUCCESS;
		}
	 }

	/**�̳��Ը���ķ�����Ҫʵ��**/
	public void setServletRequest(HttpServletRequest arg0) {
		// TODO Auto-generated method stub
		request = arg0; 
	}
	public void setServletResponse(HttpServletResponse arg0) {
		// TODO Auto-generated method stub
		response = arg0;
	}
}
