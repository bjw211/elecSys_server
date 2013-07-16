package com.control.Action;

/**
 * 名称: loginAction
 * 描述: 该类用于处理客户端用户登录请求
 * 类型: JAVA
 * @author 李昌健
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
	　　　 * 方法描述
	　　　 * 
		* 变量的set get群
	　　　 *
	　　　 */
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

	/**从父类继承的方法需要实现**/
	public void setServletRequest(HttpServletRequest arg0) {
		// TODO Auto-generated method stub
		this.request = arg0;
	}

	public void setServletResponse(HttpServletResponse arg0) {
		// TODO Auto-generated method stub
		this.response = arg0;
	}


	  /**
	　　　 * 方法描述
	　　　 * 
	　　　 * @param String wid
	　　　 * @return json
		* 服务器返回给andriod客户端用户的登录信息
	　　　 *
	　　　 */
	public void Login() {	
		try {
			worker = dao.findById(wid);		
			
			this.response.setContentType("text/json;charset=utf-8");
			this.response.setCharacterEncoding("UTF-8");

			Map<String, String> json = new HashMap<String, String>();
			
			/**处理用户登录的请求**/
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
			
			/**发送json数据**/
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
