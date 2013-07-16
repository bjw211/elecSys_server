package com.control.Action;

/**
 * 名称: qrAction
 * 描述: 该类用于处理客户端验证QR的请求
 * 类型: JAVA
 * @author 李昌健
 */


import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.Dao.Device;
import com.Dao.DeviceDAO;
import com.opensymphony.xwork2.ActionSupport;




public class qrAction extends ActionSupport implements ServletRequestAware, ServletResponseAware{
	
	private HttpServletRequest request;
	private HttpServletResponse response;
	
	private String did;
	private String QRcode;
	private DeviceDAO dao = new DeviceDAO();
	private Map<String, String> json = new HashMap<String, String>();
	private String message;

	  /**
	　　　 * 方法描述
	　　　 * 
		* 变量的set get群
	　　　 *
	　　　 */
	public String getDid() {
		return did;
	}
	public void setDid(String did) {
		this.did = did;
	}
	
	public String getQRcode() {
		return QRcode;
	}
	public void setQRcode(String qRcode) {
		QRcode = qRcode;
	}
	/**从父类继承的方法需要实现**/
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
	　　　 * @param String did QR
	　　　 * @return json
		* 服务器返回给andriod客户端验证信息
	　　　 *
	　　　 */
	public void checkQR(){
		try {
			
			this.response.setContentType("text/json;charset=utf-8");
			this.response.setCharacterEncoding("UTF-8");
			
			/**获取信息**/
			did = request.getParameter("did");
			QRcode = request.getParameter("qr");
			
			Device d= dao.findById(did);
			if(did == null){
				message = "\"no such device\"";
			}else{
				if(d.getQr().equals(QRcode)){
					message = "success";
				}else{
					message = "\"wrong QRcode\"";
				}
			}
			
			response.getWriter().write(message);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
