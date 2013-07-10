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
    
    <title>增加设备</title>
    
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
			<h1 align="center">登记设备信息</h1>
		</div>
	
	<form action="modify_device" method="post">
	
	<table align="center" border="1" cellspacing="0" width="20%" cellpadding="0"> 

		<tr >
			<td class="text" bgcolor=#99CC33 valign="top" align="center">设备号</td> 
			<td width="10%"  valign="top" align="center">
				<input type="text" name="dc.did" />
			</td>
		</tr>
		<tr>	
			<td class="text" bgcolor=#99CC33 valign="top" align="center">设备名称</td> 
			<td width="10%"  valign="top" align="center">
				<input type="text" name="dc.dname" />
			</td>
		</tr>

		<tr>
			<td class="text" bgcolor=#99CC33 valign="top" align="center">设备类型</td> 
			<td width="10%"  valign="top" align="center">
				<input type="text" name="dc.type" />
			</td>
		</tr>
		<tr>
			<td class="text" bgcolor=#99CC33 valign="top" align="center">设备安放地址</td>
			<td width="10%"  valign="top" align="center">
				<input type="text" name="dc.address" />
			</td>
		</tr>
		
		<tr>
			<td class="text" bgcolor=#99CC33 valign="top" align="center">二维码</td>
			<td width="10%"  valign="top" align="center">
				<input type="text" name="dc.qr" />
			</td>
		</tr>
		
		<tr>
			<td class="text" bgcolor=#99CC33 valign="top" align="center">检查项目</td>	
			<td width="10%"  valign="top" align="center">
				<input type="text" name="dc.checkItem" />
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
