package com.action;

/**
 * 名称: deviceAction
 * 描述: 该类用于处理服务器端设备的增删改查
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

import util.CDQR;

import com.Dao.Device;
import com.Dao.DeviceDAO;
import com.Dao.Module;
import com.Dao.ModuleDAO;
import com.Dao.Task;
import com.Dao.TaskDAO;
import com.Dao.Worker;
import com.Dao.WorkerDAO;
import com.db.HibernateSessionFactory;
import com.opensymphony.xwork2.ActionSupport;


public class deviceAction extends ActionSupport implements ServletRequestAware, ServletResponseAware{
	
	private List<Device> deviceList;
	private DeviceDAO dao = new DeviceDAO();
	private ModuleDAO mdao = new ModuleDAO();
	private WorkerDAO wdao = new WorkerDAO();
	private TaskDAO tdao = new TaskDAO();
	private String dname;
	private String did;
	private String type;
	private Device dc;
	private String mname;
	private String de;
	private String mid;
	private String address;
	private Session session = HibernateSessionFactory.getSession();
	private Transaction tx = session.beginTransaction();
	
	private HttpServletRequest request;
	private HttpServletResponse response;
	
	private String tid;
	private Date stime;
	private String state = "UNDO";
	private String wid;
	private String dec;
	private Date deadline;
	private String tname;
	
	  /**
	　　　 * 方法描述
	　　　 * 
		* 变量的set get群
	　　　 *
	　　　 */
	public Date getStime() {
		return stime;
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
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public Date getDeadline() {
		return deadline;
	}
	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}
	
	public List<Device> getDeviceList() {
		return deviceList;
	}
	public void setDeviceList(List<Device> deviceList) {
		this.deviceList = deviceList;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getDid() {
		return did;
	}
	public void setDid(String did) {
		this.did = did;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Device getDc() {
		return dc;
	}
	public void setDc(Device dc) {
		this.dc = dc;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	  /**
	　　　 * 方法描述
	　　　 * 
	　　　 * @param 
	　　　 * @return deviceList
		* 获取所有的设备
	　　　 *
	　　　 */
	
	public String list_device(){
		deviceList = dao.findAll();
		return SUCCESS;
	}
	
	public String list(){
		deviceList = dao.findAll();
		return SUCCESS;
	}
	
	public String list3(){
		deviceList = dao.findAll();
		return SUCCESS;
	}
	
	  /**
	　　　 * 方法描述
	　　　 * 
	　　　 * @param String type address
	　　　 * @return deviceList
		* 关键字查找，不符合要求的设备从列表中删除
	　　　 *
	　　　 */
	
	public String find_device(){
		deviceList = dao.findByType(type);
		int j = deviceList.size();
		
		/**迭代所有的设备**/
		for(int i=0;i<j;){
			Device dd= deviceList.get(i);
			if(dd.getAddress().equals(address) == false){
				deviceList.remove(dd);
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
	　　　 * @param String mid mname devices
	　　　 * @return deviceList
		* 写入数据库，处理增加模板的业务逻辑
	　　　 *
	　　　 */
	public String getDeviceElement(){
		
		/*计算mid*/
		calMid();
		
		Module m = new Module();
		m.setMid(mid);
		m.setMname(mname);
		
		String[] str = request.getParameterValues("pro");
		int count = str.length;
		de = Integer.toString(count);
		for(int i=0;i<str.length;i++){
			de += "@" + str[i];
			de += "@" + dao.findById(str[i]).getDname();
		}
		m.setDevices(de);
		
		/**写入数据库**/
		mdao.save(m);
		tx.commit();
		session.close();
		System.out.println("add module successfully.");		
		
		
		return SUCCESS;
	}
	

	  /**
	　　　 * 方法描述
	　　　 * 
	　　　 * @param String wid tid state tname stime
	　　　 * @return deviceList
		* 写入数据库，处理通过设备新建任务的业务逻辑
	　　　 *
	　　　 */
	public String writeTask(){
		
		Worker w = wdao.findById(wid);
		if(w == null){
			System.out.println("no such worker.");			
			return ERROR;
		}else{	
			calTid();
			Task nt = new Task();
			nt.setTid(tid);
			nt.setState(state);
			nt.setTname(tname);
			nt.setWorker(w);
			nt.setDeadline(deadline);
			nt.setStime(stime);
			
			String[] str = request.getParameterValues("pro");
			int count = str.length;
			dec = Integer.toString(count);
			for(int i=0;i<str.length;i++){
				dec += "@" + str[i];
				dec += dao.findById(str[i]).getDname();
			}
			
			nt.setDevices(dec);
			
			/**写入数据库保存数据**/
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
	　　　 * @param String did 
	　　　 * @return deviceList
		* 写入数据库，处理删除设备的业务逻辑
	　　　 *
	　　　 */
	public String delete_device(){
		
		did = request.getParameter("pro");
		Device d = dao.findById(did);
		
		/**不存在该设备**/
		if(d == null){
			deviceList = dao.findAll();
			return ERROR;
		}else{
			dao.delete(d);
			tx.commit();
			deviceList = dao.findAll();
			session.close();
			return SUCCESS;
		}
	}
	

	  /**
	　　　 * 方法描述
	　　　 * 
	　　　 * @param String did 
	　　　 * @return deviceList
		* 写入数据库，处理增加设备的业务逻辑
	　　　 *
	　　　 */
	public String add_device(){
		
		/**迭代设备列表，获取所有的设备并筛选**/
		deviceList = dao.findAll();
		for(int i=0;i<deviceList.size();i++){
			if(deviceList.get(i).getDid().equals(dc.getDid())){
				System.out.println("设备号重复");
				return ERROR;
			}
		}
		dc.setType(request.getParameter("key"));
		
		/**生成二维码，保存二维码的图片**/
		String str = "设备号:" + dc.getDid() + ",设备名称:" + dc.getDname() + ",设备类型:" + dc.getType() + ",设备安放地址:" + dc.getAddress();
		new CDQR().encode(dc.getDid()+"@"+str);
		dc.setQr(str);
		
		/**根据设备类型设置检查条目**/
		dc.setType(request.getParameter("key"));
		if(dc.getType().equals("变压器")){
			dc.setCheckItem("001油温@002油位@003声响");
		}else if(dc.getType().equals("开关")){
			dc.setCheckItem("007隔离开关本体应该完好，三相触头在合闸时应同期到位，有无错位或不同期到位现象@008触头应平整光滑，有无脏污锈蚀变形@009触头弹簧或弹簧片应完好，有无变形损坏");
		}else{
			dc.setCheckItem("004瓷套管是否清洁，有无破损裂纹、放电痕迹@005各连接头接触是否良好，有无发热松动@006绝缘拉杆及拉杆绝缘子是否完好无缺陷，连接软铜片是否完整，有无断片");
		}
		dao.save(dc);
		tx.commit();
		deviceList = dao.findAll();
		session.close();
		return SUCCESS;
	}
	
	

	  /**
	　　　 * 方法描述
	　　　 * 
	　　　 * @param String did 
	　　　 * @return deviceList
		* 写入数据库，处理修改设备的业务逻辑
	　　　 *
	　　　 */
	public String list4(){	
		did = request.getParameter("name");
		dc = dao.findById(did);
		return SUCCESS;
	}
	public String modify_device(){
		did = request.getParameter("name");
		Device d = dao.findById(did);
		dao.delete(d);
		dao.save(dc);
		tx.commit();
		deviceList = dao.findAll();
		session.close();
			
		return SUCCESS;
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
	
	

	  /**
	　　　 * 方法描述
	　　　 * 
	　　　 * @param String did 
	　　　 * @return deviceList
		* 计算模板号、任务号
	　　　 *
	　　　 */
	public void calMid(){
		List<Module> l;
		l = mdao.findAll();
		mid = Integer.toString(Integer.parseInt(l.get(l.size()-1).getMid())+1);
	}
	public void calTid(){
		List<Task> t;
		t = tdao.findAll();
		tid = Integer.toString(t.size()+1);
	}
}
