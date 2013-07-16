package com.control.Action;

/**
 * 名称: acquireTaskAction
 * 描述: 该类用于处理客户端获取任务的请求
 * 类型: JAVA
 * @author 李昌健
 */

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

import com.Dao.Task;
import com.Dao.TaskDAO;
import com.Dao.Worker;
import com.Dao.WorkerDAO;
import com.opensymphony.xwork2.ActionSupport;

public class acquireTaskAction extends ActionSupport implements
		ServletRequestAware, ServletResponseAware {

	private HttpServletRequest request;
	private HttpServletResponse response;

	private String wid; // 工人ID
	private String state; // 任务状态
	private Date time; // 参照时间
	private String tid; // 任务ID
	private String tname; // 任务名称
	private String count; // 设备数量
	private Date stime; // 布置时间
	private Date etime; // 实际完成时间
	private Date deadline; // 截止时间
	private TaskDAO dao = new TaskDAO();
	private WorkerDAO wdao = new WorkerDAO();
	private List<Task> taskList;
	private DateFormat df = new SimpleDateFormat("yyyy-mm-dd");


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

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getTid() {
		return tid;
	}

	public void setTid(String tid) {
		this.tid = tid;
	}

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	public Date getStime() {
		return stime;
	}

	public void setStime(Date stime) {
		this.stime = stime;
	}

	public Date getEtime() {
		return etime;
	}

	public void setEtime(Date etime) {
		this.etime = etime;
	}

	public Date getDeadline() {
		return deadline;
	}

	public void setDeadline(Date deadline) {
		this.deadline = deadline;
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
	　　　 * @param String tid wid
	　　　 * @return json
		* 服务器返回给andriod客户端某个工人的任务
	　　　 *
	　　　 */
	public void Acquire() {
		try {
			this.response.setContentType("text/json;charset=utf-8");
			this.response.setCharacterEncoding("UTF-8");

			ArrayList<Map<String, String>> list = new ArrayList<Map<String, String>>();
			Map<String, String> result = new HashMap<String, String>();
			Task t;
			taskList = dao.findAll();
			
			/**工人不存在**/
			if (wid == null) {
				result.put("message", "\"no such worker\"");
			} else {
				Worker w = wdao.findById(wid);
				if (w == null) {
					result.put("message", "\"no such worker\"");
				} else {
					if (time == null) {
						/**所有任务**/
						for (int i = 0; i < taskList.size(); i++) {
							Map<String, String> json = new HashMap<String, String>();
							t = taskList.get(i);
							if (t.getWorker().getWid().equals(wid)
									&& t.getState().equals(state)) {
								// 获取devices并解析计数回传
								tid = t.getTid();
								tname = t.getTname();
								stime = t.getStime();
								deadline = t.getDeadline();
								etime = t.getEtime();
								count = t.getDevices().substring(0, 1);
								json.put("tid", tid);
								json.put("tname", tname);
								json.put("stime", df.format(stime));
								json.put("deadline", df.format(deadline));
								json.put("etime", df.format(etime));
								json.put("count", count);
								list.add(json);
							}
						}
					} else {
						/**布置时间比time晚的**/
						if (state.equals("undo")) {
							for (int i = 0; i < taskList.size(); i++) {
								Map<String, String> json = new HashMap<String, String>();
								t = taskList.get(i);
								if (t.getStime().after(time)
										&& t.getWorker().getWid().equals(wid)) {
									tid = t.getTid();
									tname = t.getTname();
									stime = t.getStime();
									deadline = t.getDeadline();
									etime = t.getEtime();
									count = t.getDevices().substring(0, 1);
									json.put("tid", tid);
									json.put("tname", tname);
									json.put("stime", df.format(stime));
									json.put("deadline", df.format(deadline));
									json.put("etime", df.format(etime));
									json.put("count", count);
									list.add(json);
								}
							}
						} else if (state.equals("done")) { 
							/**完成时间比time晚的**/
							for (int i = 0; i < taskList.size(); i++) {
								Map<String, String> json = new HashMap<String, String>();
								t = taskList.get(i);
								if (t.getEtime().after(time)
										&& t.getWorker().getWid().equals(wid)) {
									tid = t.getTid();
									tname = t.getTname();
									stime = t.getStime();
									deadline = t.getDeadline();
									etime = t.getEtime();
									count = t.getDevices().substring(0, 1);
									json.put("tid", tid);
									json.put("tname", tname);
									json.put("stime", df.format(stime));
									json.put("deadline", df.format(deadline));
									json.put("etime", df.format(etime));
									json.put("count", count);
									list.add(json);
								}
							}
						} else { 
							/**deadline 比time晚的**/
							for (int i = 0; i < taskList.size(); i++) {
								Map<String, String> json = new HashMap<String, String>();
								t = taskList.get(i);
								if (t.getDeadline().after(time)
										&& t.getWorker().getWid().equals(wid)) {
									tid = t.getTid();
									tname = t.getTname();
									stime = t.getStime();
									deadline = t.getDeadline();
									etime = t.getEtime();
									count = t.getDevices().substring(0, 1);
									json.put("tid", tid);
									json.put("tname", tname);
									json.put("stime", df.format(stime));
									json.put("deadline", df.format(deadline));
									json.put("etime", df.format(etime));
									json.put("count", count);
									list.add(json);
								}
							}
						}
					}
					result.put("message", "success");
				}

				result.put("tasklist", list.toString());
			}
			
			/**发送json数据**/
			byte[] jsonBytes = result.toString().getBytes("utf-8");
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
