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
    
    <title>缺陷管理</title>
    
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
			<h1 align="center">缺陷列表</h1>
		</div>
		
		<div align="center">
			<s:form action="find_fault">
				查询设备缺陷：
				设备号   <input name="did" type="text" size="7"/>
				<input type="submit" value="查   询" />
			</s:form>
		</div>

	<table align="center" border="1" cellspacing="0" width="80%" cellpadding="0"> 

		<tr bgcolor=#99CC33 class="text" >
			<td valign="top" align="center">缺陷号</td> 
			<td valign="top" align="center">设备号及名称</td> 
			<td valign="top" align="center">缺陷描述</td> 
			<td valign="top" align="center">发现时间</td>
			<td valign="top" align="center">是否处理</td>
		</tr>
		<s:if test="faultList.size()>0">
		<s:iterator value="faultList" var="f">
		<tr>
			<td width="10%" valign="top" align="center" class="text">
				<s:property value="#f.fid" />
			</td>
			 
			<td width="10%"  valign="top" align="center" class="text"> 
				<s:property value="#f.did" />
			</td>

			<td width="10%"  valign="top" align="center" class="text"> 
				<s:property value="#f.content" />
			</td>

			<td width="10%"  valign="top" align="center" class="text"> 
				<s:property value="#f.time" />
			</td>
			
			<td width="10%"  valign="top" align="center" class="text"> 
				<s:property value="#f.solved" />
			</td>
		</tr>
		</s:iterator>
		</s:if>
		<s:else><tr><td colspan="4" align="center">没有找到相应设备的缺陷。</td></tr></s:else>
	</table>
	
	
	<p align="center" style="color:red">
	当前第1页
	<a href="<%=basePath%>jsp/fault_index.jsp">[首页]</a>
	<a href="<%=basePath%>jsp/fault_index.jsp">[上一页]</a>
	<a href="<%=basePath%>jsp/fault_index.jsp">[下一页]</a>
	<a href="<%=basePath%>jsp/fault_index.jsp">[尾页]</a>
	</p>
	
	</div>

  </body>

</html>
