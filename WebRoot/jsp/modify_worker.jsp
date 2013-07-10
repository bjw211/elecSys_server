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
    
    <title>修改工人信息</title>
    
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
    <div>
    
		<div style="height: 50px">
			<h1 align="center">修改工人信息</h1>
		</div>
	
	<form action="add_worker" method="post">
	
	<table align="center" border="1" cellspacing="0" width="20%" cellpadding="0"> 

		<tr >
			<td class="text" bgcolor=#99CC33 valign="top" align="center">账号</td> 
			<td width="10%"  valign="top" align="center">
				<input type="text" name="nw.wid" />
			</td>
		</tr>
		<tr>	
			<td class="text" bgcolor=#99CC33 valign="top" align="center">姓名</td> 
			<td width="10%"  valign="top" align="center">
				<input type="text" name="nw.wname" />
			</td>
		</tr>

		<tr>
			<td class="text" bgcolor=#99CC33 valign="top" align="center">密码</td> 
			<td width="10%"  valign="top" align="center">
				<input type="text" name="nw.pwd" />
			</td>
		</tr>
		<tr>
			<td class="text" bgcolor=#99CC33 valign="top" align="center">年龄</td>
			<td width="10%"  valign="top" align="center">
				<input type="text" name="nw.age" />
			</td>
		</tr>
		
		<tr>
			<td class="text" bgcolor=#99CC33 valign="top" align="center">家庭住址</td>
			<td width="10%"  valign="top" align="center">
				<input type="text" name="nw.addr" />
			</td>
		</tr>
		
		<tr>
			<td class="text" bgcolor=#99CC33 valign="top" align="center">工作时间</td>	
			<td width="10%"  valign="top" align="center">
				<input type="text" name="nw.wtime" />
			</td>
		</tr>
		<tr>
			<td class="text" bgcolor=#99CC33 valign="top" align="center">工作种类</td> 
			<td width="10%"  valign="top" align="center">
				<input type="text" name="nw.typet" />
			</td>
		</tr>
		<tr>
			<td class="text" bgcolor=#99CC33 valign="top" align="center">分配任务</td> 
			<td width="10%"  valign="top" align="center">
				<input type="text" name="nw.task.tid" />
			</td>
		</tr>
	</table>
	
		<p align="center">
			<input type="submit" value="确   定"/>
			<input type="reset" value="重   置"/>
		</p>
	
	</form>
	
	</div>

  </body>

  
</html>
