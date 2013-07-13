package com.control.Action;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.Dao.Result;
import com.Dao.ResultDAO;
import com.Dao.Task;
import com.Dao.TaskDAO;
import com.db.HibernateSessionFactory;
import com.opensymphony.xwork2.ActionSupport;

public class taskFinishAction extends ActionSupport implements
		ServletRequestAware, ServletResponseAware {

	private HttpServletRequest request;
	private HttpServletResponse response;

	private String tid;
	private String result;
	private TaskDAO tdao = new TaskDAO();
	private ResultDAO rdao = new ResultDAO();
	private String dec;
	private int count;
	private Map<String, String> json = new HashMap<String, String>();
	private Session session = HibernateSessionFactory.getSession();
	private Transaction tx = session.beginTransaction();
	private DateFormat df = new SimpleDateFormat("yyyy-mm-dd");

	public String getTid() {
		return tid;
	}

	public void setTid(String tid) {
		this.tid = tid;
	}

	public void setServletRequest(HttpServletRequest arg0) {
		// TODO Auto-generated method stub
		request = arg0;
	}

	public void setServletResponse(HttpServletResponse arg0) {
		// TODO Auto-generated method stub
		response = arg0;
	}

	public void checkTask() {
		try {
			this.response.setContentType("text/json;charset=utf-8");
			this.response.setCharacterEncoding("UTF-8");

			request.getParameter("tid");

			Task t = tdao.findById(tid);
			if (t == null) {
				result = "\"no such task\"";
			} else {
				dec = t.getDevices();
				count = Integer.parseInt(dec.substring(0, 1));
				count *= 3;
				int c = 0;
				List<Result> rlist = rdao.findAll();
				for(int i=0;i<rlist.size();i++){				
					if(rlist.get(i).getId().getTid().equals(tid)){
						c++;
					}
				}			
				if (c == count) {
					result = "success";
					
					Date d = new Date();
					t.setState("DONE");
					t.setEtime(d);
System.out.println(d.toString());					
					json.put("etime", df.format(d).toString());
					
					tdao.merge(t);
					tx.commit();
					session.close();
					System.out.println("the task" + tid + "was finished");
					
				} else {
					result = "\"not finished\"";
				}
			}
			
			json.put("message", result);
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
