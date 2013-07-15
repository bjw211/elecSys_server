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
	
	//д�����ݿ⣬����ҵ���߼�
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
	
	//�����½������ҵ���߼�
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
				System.out.println("�豸���ظ�");
				return ERROR;
			}
		}
		dc.setType(request.getParameter("key"));
		String str = "�豸��:" + dc.getDid() + ",�豸����:" + dc.getDname() + ",�豸����:" + dc.getType() + ",�豸���ŵ�ַ:" + dc.getAddress();
		new CDQR().encode(dc.getDid()+"@"+str);
		dc.setQr(str);
		dc.setType(request.getParameter("key"));
		if(dc.getType().equals("��ѹ��")){
			dc.setCheckItem("001����@002��λ@003����");
		}else if(dc.getType().equals("����")){
			dc.setCheckItem("007���뿪�ر���Ӧ����ã����ഥͷ�ں�բʱӦͬ�ڵ�λ�����޴�λ��ͬ�ڵ�λ����@008��ͷӦƽ���⻬������������ʴ����@009��ͷ���ɻ򵯻�ƬӦ��ã����ޱ�����");
		}else{
			dc.setCheckItem("004���׹��Ƿ���࣬�����������ơ��ŵ�ۼ�@005������ͷ�Ӵ��Ƿ����ã����޷����ɶ�@006��Ե���˼����˾�Ե���Ƿ������ȱ�ݣ�������ͭƬ�Ƿ����������޶�Ƭ");
		}
		dao.save(dc);
		tx.commit();
		deviceList = dao.findAll();
		session.close();
		return SUCCESS;
	}
	
	public static void main(String[] args) {
		new CDQR().encode("7@�豸��:7,�豸����:007,�豸����:����,�豸���ŵ�ַ:007");
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
	
	//����ģ���
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
