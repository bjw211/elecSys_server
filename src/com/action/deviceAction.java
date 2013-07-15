package com.action;

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
	
	public String find_device(){
		deviceList = dao.findByType(type);
		int j = deviceList.size();
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
	
	//写入数据库，处理业务逻辑
	public String getDeviceElement(){
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
		
		mdao.save(m);
		tx.commit();
		session.close();
		System.out.println("add module successfully.");		
		
		return SUCCESS;
	}
	
	private String tid;
	private Date stime;
	private String state = "UNDO";
	private String wid;
	private String dec;
	private Date deadline;
	private String tname;
	
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
	
	//处理新建任务的业务逻辑
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
			
			tdao.save(nt);
			tx.commit();
			session.close();
System.out.println("add task by device successfully.");			
			
			return SUCCESS;
		}
	}
	
	public String delete_device(){
System.out.println("fuck");		
		did = request.getParameter("pro");
		Device d = dao.findById(did);
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
	
	public String add_device(){
		deviceList = dao.findAll();
		for(int i=0;i<deviceList.size();i++){
			if(deviceList.get(i).getDid().equals(dc.getDid())){
				System.out.println("设备号重复");
				return ERROR;
			}
		}
		dc.setType(request.getParameter("key"));
		String str = "设备号:" + dc.getDid() + ",设备名称:" + dc.getDname() + ",设备类型:" + dc.getType() + ",设备安放地址:" + dc.getAddress();
		new CDQR().encode(dc.getDid()+"@"+str);
		dc.setQr(str);
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
	
	public static void main(String[] args) {
		new CDQR().encode("7@设备号:7,设备名称:007,设备类型:开关,设备安放地址:007");
	}
	
	public String list4(){
System.out.println("fuck"+did+"\n");		
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
	public void setServletRequest(HttpServletRequest arg0) {
		// TODO Auto-generated method stub
		request = arg0;
	}
	public void setServletResponse(HttpServletResponse arg0) {
		// TODO Auto-generated method stub
		response = arg0;
	}
	
	//计算模板号
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
