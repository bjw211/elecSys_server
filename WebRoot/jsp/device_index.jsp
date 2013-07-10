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
			<h1 align="center">设备列表</h1>
		</div>
		
		<div align="center">
			<s:form action="find_device">
				查询条件：
				设备类型 <input name="type" type="text" size="7"/>
				<input type="submit" value="查   询" />
			</s:form>
		</div>
		
		<div align="center">
			<s:form action="delete_device">
				查询条件：
				设备号    <input name="did" type="text" size="7"/>
				<input type="submit" value="删   除" />
			</s:form>
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
		<s:if test="deviceList.size()>0">
		<s:iterator value="deviceList" var="d">
		<tr>
			<td width="8%"  valign="top" align="center" class="text">
				<s:property value="#d.did" />
			</td>
			 
			<td width="10%"  valign="top" align="center" class="text"> 
				<s:property value="#d.dname" />
			</td>

			<td width="10%"  valign="top" align="center" class="text"> 
				<s:property value="#d.type" />
			</td>

			<td width="10%"  valign="top" align="center" class="text"> 
				<s:property value="#d.address" />
			</td>
			
			<td width="10%"  valign="top" align="center" class="text"> 
				<s:property value="#d.qr" />
			</td>
			
			<td width="9%"  valign="top" align="center" class="text">
				<s:property value="#d.checkItem" />
			</td>
		</tr>
		</s:iterator>
		</s:if>
		<s:else><tr><td colspan="6" align="center">没有找到您查询的设备.</td></tr></s:else>
	</table>
	
	
	<p align="center" style="color:red">
	当前第1页
	<a href="<%=basePath%>jsp/device_index.jsp">[首页]</a>
	<a href="<%=basePath%>jsp/device_index.jsp">[上一页]</a>
	<a href="<%=basePath%>jsp/device_index.jsp">[下一页]</a>
	<a href="<%=basePath%>jsp/device_index.jsp">[尾页]</a>
	</p>

	<p align="center">
		<a href="<%=basePath%>jsp/add_device.jsp" ><input type="button" value="增加设备"/></a>
		<a href="<%=basePath%>jsp/modify_device.jsp" ><input type="button" value="修改设备信息"/></a>
	</p>
	
	</div>

  </body>

  
</html>
