package com.control.Action;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.Dao.Device;
import com.Dao.DeviceDAO;
import com.Dao.Task;
import com.Dao.TaskDAO;
import com.opensymphony.xwork2.ActionSupport;

public class detailedTaskAction extends ActionSupport implements
		ServletRequestAware, ServletResponseAware {

	private HttpServletRequest request;
	private HttpServletResponse response;

	private String tid; // 任务ID

	private String count; // 设备数量
	private String devices;
	private TaskDAO dao = new TaskDAO();
	private DeviceDAO ddao = new DeviceDAO();
	private List<Map<String, String>> devicelite = new ArrayList<Map<String, String>>();
	private Map<String, String> json = new HashMap<String, String>();
	private DateFormat df = new SimpleDateFormat("yyyy-mm-dd");

	public String getTid() {
		return tid;
	}

	public void setTid(String tid) {
		this.tid = tid;
	}

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	public String getDevices() {
		return devices;
	}

	public void setDevices(String devices) {
		this.devices = devices;
	}

	public void setServletResponse(HttpServletResponse arg0) {
		// TODO Auto-generated method stub
		response = arg0;
	}

	public void setServletRequest(HttpServletRequest arg0) {
		// TODO Auto-generated method stub
		request = arg0;
	}

	public void getTask() {

		try {
			this.response.setContentType("text/json;charset=utf-8");
			this.response.setCharacterEncoding("UTF-8");

			Task t = dao.findById(tid);
			if (t != null) {
				json.put("message", "success");
				json.put("tname", t.getTname());
				json.put("stime", df.format(t.getStime()));
				json.put("deadline", df.format(t.getDeadline()));
				json.put("etime", df.format(t.getEtime()));
				json.put("state", t.getState());
				devices = t.getDevices();
				count = devices.substring(0, 1);
				json.put("count", count);
				String s[] = new String[30];
				s = devices.split("@");
				for (int i = 1; i < s.length; i++) {
					Map<String, String> d = new HashMap<String, String>();
					String did = s[i].substring(0, 3);
					d.put("did", did);
					d.put("dname", ddao.findById(did).getDname());
					d.put("address", ddao.findById(did).getAddress());
					devicelite.add(d);
				}
				json.put("devicelites", devicelite.toString());
			} else {
				json.put("message", "\"no such task\"");
			}
			byte[] jsonBytes = json.toString().getBytes("utf-8");
			response.setContentLength(jsonBytes.length);
			response.getOutputStream().write(jsonBytes);
			response.getOutputStream().flush();
			response.getOutputStream().close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
