<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>修改管理员密码</title>
    
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
 	
	<h1 align="center">更改密码</h1>

	<form action="modify">

	<table align="center" border="1" width="40%" cellpadding="5" cellspacing="0" bordercolor="#99CC33" >
		<tr>
			<td>请输入账号:</td>
			<td><input name="aid" type="text"/></td>
		</tr>
		<tr>
			<td>请输入旧密码:</td>
			<td><input name="pwd" type="password"/></td>
		</tr>
		<tr>
			<td>请输入新密码:</td>
			<td><input name="npwd"  type="password"/></td>
		</tr>
		<tr>
			<td>请确认新密码:</td>
			<td><input name="nnpwd"  type="password"/></td>
		</tr>
	</table>

		<p align="center">
			<input value="提   交"  type="submit" />
			<input value="重   置" type="reset" />
		</p>
	</form>
	</div>
	
	<div align="right">
		用户：<s:property value="aname"/>
		<a href="<%=basePath%>index.jsp" >退出系统</a>
	</div>
	
</body>
 
</html>
