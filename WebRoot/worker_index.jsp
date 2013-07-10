<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN ，">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>工人管理</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  
  <body>
    <div >
    
		<div style="height: 50px">
			<h1 align="center">工人列表</h1>
		</div>
		
		<div align="center">
			<s:form action="find_worker">
				查询条件：
				姓名   <input name="wname" type="text" size="7"/>
				<input type="submit" value="查   询" />
			</s:form>
		</div>
		
		<div align="center">
			<s:form action="delete_worker">
				查询条件：
				账号    <input name="wid" type="text" size="7"/>
				<input type="submit" value="删   除" />
			</s:form>
		</div>

	<table align="center" border="1" cellspacing="0" width="80%" cellpadding="0"> 

		<tr bgcolor=#99CC33 class="text" >
			<td valign="top" align="center">账号</td> 
			<td valign="top" align="center">姓名</td> 
			<td valign="top" align="center">密码</td> 
			<td valign="top" align="center">年龄</td>
			<td valign="top" align="center">家庭住址</td>
			<td valign="top" align="center">工作时间</td>
			<td valign="top" align="center">工作种类</td>
		</tr>
		<s:if test="workerList.size()>0">
		<s:iterator value="workerList" var="w">
		<tr>
			<td width="8%"  valign="top" align="center" class="text">
				<s:property value="#w.wid" />
			</td>
			 
			<td width="10%"  valign="top" align="center" class="text"> 
				<s:property value="#w.wname" />
			</td>

			<td width="10%"  valign="top" align="center" class="text"> 
				<s:property value="#w.pwd" />
			</td>

			<td width="10%"  valign="top" align="center" class="text"> 
				<s:property value="#w.age" />
			</td>
			
			<td width="10%"  valign="top" align="center" class="text"> 
				<s:property value="#w.address" />
			</td>
			
			<td width="9%"  valign="top" align="center" class="text">
				<s:property value="#w.wtime" />
			</td> 

			<td width="10%"  valign="top" align="center" class="text"> 
				<s:property value="#w.type" />
			</td>
		</tr>
		</s:iterator>
		</s:if>
		<s:else><tr><td colspan="8" align="center">没有找到您查询的工人.</td></tr></s:else>
	</table>
	
	
	<p align="center" style="color:red">
	当前第1页
	<a href="<%=basePath%>jsp/worker_index.jsp">[首页]</a>
	<a href="<%=basePath%>jsp/worker_index.jsp">[上一页]</a>
	<a href="<%=basePath%>jsp/worker_index.jsp">[下一页]</a>
	<a href="<%=basePath%>jsp/worker_index.jsp">[尾页]</a>
	</p>

	<p align="center">
		<a href="<%=basePath%>jsp/add_worker.jsp" ><input type="button" value="增加工人"/></a>
		<a href="<%=basePath%>jsp/modify_worker.jsp" ><input type="button" value="修改信息"/></a>
	</p>
	
	</div>

  </body>

  
</html>
