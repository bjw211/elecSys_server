package com.control.Action;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLDecoder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.Dao.DeviceDAO;
import com.Dao.Fault;
import com.Dao.FaultDAO;
import com.db.HibernateSessionFactory;
import com.opensymphony.xwork2.ActionSupport;

public class receiveFaultAction extends ActionSupport implements
		ServletRequestAware, ServletResponseAware {

	private HttpServletRequest request;
	private HttpServletResponse response;
	private String did;
	private String content;
	private String fid;
	private Date time;
	private String solved = "·ñ";
	private FaultDAO dao = new FaultDAO();
	private DeviceDAO ddao = new DeviceDAO();
	private DateFormat df = new SimpleDateFormat("yyyy-mm-dd");
	private Session session = HibernateSessionFactory.getSession();
	private Transaction tx = session.beginTransaction();
	private Map<String, String> ms = new HashMap<String, String>();
	private InputStream in;
	private int count;

	public String getDid() {
		return did;
	}

	public void setDid(String did) {
		this.did = did;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getSolved() {
		return solved;
	}

	public void setSolved(String solved) {
		this.solved = solved;
	}

	public void setFid(String fid) {
		this.fid = fid;
	}

	public String getFid() {
		return fid;
	}

	public void setServletRequest(HttpServletRequest arg0) {
		// TODO Auto-generated method stub
		this.request = arg0;
	}

	public void setServletResponse(HttpServletResponse arg0) {
		// TODO Auto-generated method stub
		this.response = arg0;
	}

	public void writeFault() {
		try {

			this.response.setContentType("text/json;charset=utf-8");
			this.response.setCharacterEncoding("UTF-8");

			calFid();
			did = request.getParameter("did");
			content = request.getParameter("content");

			if (did.length() <= 0) {
				ms.put("message", "\"did is null\"");
			} else {
				if (ddao.findById(did) == null) {
					ms.put("message", "\"no such device.\"");
				} else {
					if (content.length() <= 0) {
						ms.put("message", "\"no fault log.\"");
					} else {
						Fault nf = new Fault();
						nf.setFid(Integer.parseInt(fid));
						nf.setDid(did);
						nf.setContent(content);
						nf.setSolved(solved);
						nf.setTime(time);

						dao.save(nf);
						tx.commit();
						session.close();

						ms.put("message", "success");
						ms.put("fid", fid);
						ms.put("time", df.format(time));
						System.out.println("log the fault successfully.");
					}
				}
			}

			byte[] jsonBytes = ms.toString().getBytes("utf-8");
			response.setContentLength(jsonBytes.length);
			response.getOutputStream().write(jsonBytes);
			response.getOutputStream().flush();
			response.getOutputStream().close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void calFid() {
		List<Fault> flist = dao.findAll();
		fid = Integer.toString(flist.size()+1);
		time = new Date();
	}

}
