package com.control.Action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.Dao.Device;
import com.Dao.DeviceDAO;
import com.opensymphony.xwork2.ActionSupport;

public class acquireDeviceAction extends ActionSupport implements
		ServletRequestAware, ServletResponseAware {

	private HttpServletRequest request;
	private HttpServletResponse response;

	private String did;
	private DeviceDAO dao = new DeviceDAO();
	private List<Map<String, String>> clause = new ArrayList<Map<String, String>>();
	private Map<String, String> json = new HashMap<String, String>();

	public String getDid() {
		return did;
	}

	public void setDid(String did) {
		this.did = did;
	}

	public void setServletRequest(HttpServletRequest arg0) {
		// TODO Auto-generated method stub
		request = arg0;
	}

	public void setServletResponse(HttpServletResponse arg0) {
		// TODO Auto-generated method stub
		response = arg0;
	}

	public void getDevice() {
		try {
			this.response.setContentType("text/json;charset=utf-8");
			this.response.setCharacterEncoding("UTF-8");
System.out.println("收到的设备号" +did);
			if (did == null) {
				json.put("message", "\"no such device\"");
			} else {
				Device d = dao.findById(did);

				if (d == null) {
					json.put("message", "\"no such device\"");
				} else {
					json.put("message", "success");
					json.put("dname", "\"" + d.getDname() + "\"");
					json.put("type", d.getType());
					json.put("address", d.getAddress());
					json.put("qr", "\"" + d.getQr() + "\"");
					String Items = d.getCheckItem();
					String s[] = new String[20];
					s = Items.split("@");
					for (int i = 0; i < s.length; i++) {
						Map<String, String> c = new HashMap<String, String>();
						c.put("cid", s[i].substring(0, 3));
						c.put("cname", s[i].substring(3));
						clause.add(c);
					}
					json.put("clauselist", clause.toString());
				}
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
