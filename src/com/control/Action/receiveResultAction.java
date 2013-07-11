package com.control.Action;


import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.json.JSONArray;
import org.json.JSONObject;

import com.Dao.Result;
import com.Dao.ResultDAO;
import com.Dao.ResultId;
import com.db.HibernateSessionFactory;
import com.opensymphony.xwork2.ActionSupport;

public class receiveResultAction extends ActionSupport implements
		ServletRequestAware, ServletResponseAware {

	private HttpServletRequest request;
	private HttpServletResponse response;
	
	private String tid;
	private String did;
	private String cid;
	private String value;
	private JSONArray ItemList;
	private ResultDAO dao = new ResultDAO();
	private InputStream in;
	private JSONObject jsonObject=null;
	private ByteArrayOutputStream stream;
	private Session session = HibernateSessionFactory.getSession();
	private Transaction tx = session.beginTransaction();
	
	
	public String getTid() {
		return tid;
	}
	public void setTid(String tid) {
		this.tid = tid;
	}
	public String getDid() {
		return did;
	}
	public void setDid(String did) {
		this.did = did;
	}
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public void setServletRequest(HttpServletRequest arg0) {
		// TODO Auto-generated method stub
		request = arg0;
	}
	public void setServletResponse(HttpServletResponse arg0) {
		// TODO Auto-generated method stub
		response = arg0;
	}
	
	public  void writeResult(){
		try {
			
			this.response.setContentType("text/json;charset=utf-8");
			this.response.setCharacterEncoding("UTF-8");
			
			in = request.getInputStream();
			
			int available=in.available();
			byte[] buffer= new byte[available];
			in.read(buffer);
			stream =new ByteArrayOutputStream();
			stream.write(buffer, 0, available);
			String json=stream.toString("utf-8");
			jsonObject = new JSONObject(json);
			
			tid = jsonObject.getString("tid");
			did = jsonObject.getString("did");
			ItemList = jsonObject.getJSONArray("ItemList");
			
			for(int i=0;i<ItemList.length();i++){
				Result rt = new Result();
				rt.setCid(ItemList.getJSONObject(i).getString("cid"));
				rt.setValue(ItemList.getJSONObject(i).getString("value"));
				ResultId id = new ResultId();
				id.setDid(did);
				id.setTid(tid);
				rt.setId(id);
				dao.save(rt);
			}
			
			tx.commit();
			session.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
