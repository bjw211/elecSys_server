package com.action;

/**
 * 名称: moduleAction
 * 描述: 该类用于处理服务器端模板的处理
 * 类型: JAVA
 * @author 李昌健
 */

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.Dao.Device;
import com.Dao.DeviceDAO;
import com.Dao.LogDAO;
import com.Dao.Module;
import com.Dao.ModuleDAO;
import com.Dao.Task;
import com.Dao.TaskDAO;
import com.Dao.Worker;
import com.Dao.WorkerDAO;
import com.db.HibernateSessionFactory;
import com.opensymphony.xwork2.ActionSupport;

public class moduleAction extends ActionSupport implements ServletResponseAware, ServletRequestAware{
	
	private List<Module> moduleList;
	private String mid;
	private String mname;
	private Module mn;
	private ModuleDAO dao = new ModuleDAO();
	private DeviceDAO ddao = new DeviceDAO();
	private LogDAO ldao = new LogDAO();
	private List<Device> dList;
	private Session session = HibernateSessionFactory.getSession();
	private Transaction tx = session.beginTransaction();
	
	private HttpServletRequest request;
	private HttpServletResponse response;
	
	private String nmid;
	private String tid;
	private Date stime;
	private String state = "UNDO";
	private String wid;
	private String dec;
	private Date deadline;
	private String tname;
	private WorkerDAO wdao = new WorkerDAO();
	private TaskDAO tdao = new TaskDAO();

	  /**
	　　　 * 方法描述
	　　　 * 
		* 变量的set get群
	　　　 *
	　　　 */
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
	public Date getStime() {
		return stime;
	}
	public String getDec() {
		return dec;
	}
	public void setDec(String dec) {
		this.dec = dec;
	}
	public void setStime(Date stime) {
		this.stime = stime;
	}
	public String getWid() {
		return wid;
	}
	public void setWid(String wid) {
		this.wid = wid;
	}
	public Date getDeadline() {
		return deadline;
	}
	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}

	  /**
	　　　 * 方法描述
	　　　 * 
	　　　 * @param 
	　　　 * @return moduletList
		* 获取所有的设备
	　　　 *
	　　　 */
	public String list_module(){
		moduleList = dao.findAll();
		return SUCCESS;
	}
	public String list2(){
		moduleList = dao.findAll();
		return SUCCESS;
	}
	

	  /**
	　　　 * 方法描述
	　　　 * 
	　　　 * @param String mname
	　　　 * @return moduleList
		* 关键字查找，不符合要求的设备从列表中删除
	　　　 *
	　　　 */
	public String find_module(){	
		moduleList = dao.findAll();
		int j = moduleList.size();
		
		/**迭代列表，不符合条件的删除**/
		for(int i=0;i<j;){
			Module m = moduleList.get(i);
			if(m.getMname().contains(mname) == false){				
				moduleList.remove(m);
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
	　　　 * @param String wid tid state tname stime deadline
	　　　 * @return moduleList
		* 写入数据库，处理通过模板增加任务的业务逻辑
	　　　 *
	　　　 */
	public String writeTask1(){	
		
		Worker w = wdao.findById(wid);		
		
		/**worker为null**/
		if(w == null){
			System.out.println("no such worker.&&&&");			
			return ERROR;
		}else{
			
			/**计算TID**/
			calTid();
			Task nt = new Task();
			nt.setTid(tid);
			nt.setState(state);
			nt.setTname(tname);
			nt.setWorker(w);
			nt.setDeadline(deadline);
			nt.setStime(stime);
			
			nmid = ldao.findById("001").getValue();
			dec = dao.findById(nmid).getDevices();
			nt.setDevices(dao.findById(nmid).getDevices());
			
			/**写入数据库**/
			tdao.save(nt);
			tx.commit();
			session.close();
			System.out.println("add task by device successfully.");			
			
			return SUCCESS;
		}
	}
	

	  /**
	　　　 * 方法描述
	　　　 * 
	　　　 * @param String mid
	　　　 * @return moduleList
		* 写入数据库，处理删除模板的业务逻辑
	　　　 *
	　　　 */
	public String delete_module(){
		mid = request.getParameter("pro");		
		Module me = dao.findById(mid);
		if(me != null){
			dao.delete(me);
			tx.commit();
			moduleList = dao.findAll();
			session.close();
			return SUCCESS;
		}else{
			moduleList = dao.findAll();
			return ERROR;
		}
	}
	
	
	/**继承自父类的方法需要实现**/
	public void setServletResponse(HttpServletResponse arg0) {
		// TODO Auto-generated method stub
		response = arg0;
	}
	public void setServletRequest(HttpServletRequest arg0) {
		// TODO Auto-generated method stub
		request = arg0;
	}

	  /**
	　　　 * 方法描述
	　　　 * 
	　　　 * @param String did 
	　　　 * @return deviceList
		* 计算任务号
	　　　 *
	　　　 */
	public void calTid(){
		List<Task> t;
		t = tdao.findAll();
		tid = Integer.toString(t.size()+1);
	}
	
}
