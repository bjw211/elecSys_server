package com.control.Action;

/**
 * ����: loginAction
 * ����: �������ڴ���ͻ����û���¼����
 * ����: JAVA
 * @author �����
 */

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.Dao.Worker;
import com.Dao.WorkerDAO;
import com.opensymphony.xwork2.ActionSupport;

public class loginAction extends ActionSupport implements ServletRequestAware,
		ServletResponseAware {

	private HttpServletRequest request;
	private HttpServletResponse response;

	private String wid;
	private String pwd;
	private String wname;
	private WorkerDAO dao = new WorkerDAO();
	private Worker worker;
	

	  /**
	������ * ��������
	������ * 
		* ������set getȺ
	������ *
	������ */
	public String getWid() {
		return wid;
	}

	public void setWid(String wid) {
		this.wid = wid;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getWname() {
		return wname;
	}

	public void setWname(String wname) {
		this.wname = wname;
	}

	/**�Ӹ���̳еķ�����Ҫʵ��**/
	public void setServletRequest(HttpServletRequest arg0) {
		// TODO Auto-generated method stub
		this.request = arg0;
	}

	public void setServletResponse(HttpServletResponse arg0) {
		// TODO Auto-generated method stub
		this.response = arg0;
	}


	  /**
	������ * ��������
	������ * 
	������ * @param String wid
	������ * @return json
		* ���������ظ�andriod�ͻ����û��ĵ�¼��Ϣ
	������ *
	������ */
	public void Login() {	
		try {
			worker = dao.findById(wid);		
			
			this.response.setContentType("text/json;charset=utf-8");
			this.response.setCharacterEncoding("UTF-8");

			Map<String, String> json = new HashMap<String, String>();
			
			/**�����û���¼������**/
			if (worker == null) {
				json.put("message", "\"no such worker\"");
			} else {
				if (worker.getWid() != null) {
					if (worker.getPwd().equals(pwd)) {
						json.put("message", "success");
						json.put("wname", worker.getWname());
					} else {
						json.put("message", "\"wrong password\"");
					}
				} else {
					json.put("message", "\"no such worker\"");
				}
			}
			
			/**����json����**/
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
