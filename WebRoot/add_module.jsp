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
    
    <title>设备管理</title>
    
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
			<h1 align="center">请添加设备：</h1>
		</div>

	<table align="center" border="1" cellspacing="0" width="80%" cellpadding="0"> 

		<tr bgcolor=#99CC33 class="text" >
			<td valign="top" align="center">设备号</td> 
			<td valign="top" align="center">设备名称</td> 
			<td valign="top" align="center">设备类型</td> 
			<td valign="top" align="center">设备安放地址</td>
			<td valign="top" align="center">二维码</td>
			<td valign="top" align="center">检查项目</td>
		</tr>
		<s:if test="dList.size()>0">
		<s:iterator value="dList" var="dl">
		<tr>
			<td width="8%"  valign="top" align="center" class="text">
				<s:property value="#dl.did" />
			</td>
			 
			<td width="10%"  valign="top" align="center" class="text"> 
				<s:property value="#dl.dname" />
			</td>

			<td width="10%"  valign="top" align="center" class="text"> 
				<s:property value="#dl.type" />
			</td>

			<td width="10%"  valign="top" align="center" class="text"> 
				<s:property value="#dl.address" />
			</td>
			
			<td width="10%"  valign="top" align="center" class="text"> 
				<s:property value="#dl.qr" />
			</td>
			
			<td width="9%"  valign="top" align="center" class="text">
				<s:property value="#dl.checkItem" />
			</td>
		</tr>
		</s:iterator>
		</s:if>
		<s:else><tr><td colspan="6" align="center">没有设备.</td></tr></s:else>
	</table>

	</div>

  </body>

  
</html>
