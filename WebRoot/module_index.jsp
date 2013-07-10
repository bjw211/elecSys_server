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
    
    <title>模板管理</title>
    
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
			<h1 align="center">模板列表</h1>
		</div>
		
		<div align="center">
			<s:form action="find_module">
				查询条件：
				模板名称   <input name="mname" type="text" size="7"/>
				<input type="submit" value="查   询" />
			</s:form>
		</div>
		
		<div align="center">
			<s:form action="delete_module">
				查询条件：
				模板号 <input name="mid" type="text" size="7"/>
				<input type="submit" value="删   除" />
			</s:form>
		</div>

	<table align="center" border="1" cellspacing="0" width="80%" cellpadding="0"> 

		<tr bgcolor=#99CC33 class="text" >
			<td valign="top" align="center">模板号</td> 
			<td valign="top" align="center">模板名称</td> 
			<td valign="top" align="center">检查设备表(Id+Name)</td> 
		</tr>
		<s:if test="moduleList.size()>0">
		<s:iterator value="moduleList" var="ml">
		<tr>
			<td width="8%"  valign="top" align="center" class="text">
				<s:property value="#ml.mid" />
			</td>
			 
			<td width="10%"  valign="top" align="center" class="text"> 
				<s:property value="#ml.mname" />
			</td>

			<td width="30%"  valign="top" align="center" class="text"> 
				<s:property value="#ml.devices" />
			</td>
		</tr>
		</s:iterator>
		</s:if>
		<s:else><tr><td colspan="3" align="center">没有找到您查询的模板.</td></tr></s:else>
	</table>
	
	
	<p align="center" style="color:red">
	当前第1页
	<a href="<%=basePath%>jsp/module_index.jsp">[首页]</a>
	<a href="<%=basePath%>jsp/module_index.jsp">[上一页]</a>
	<a href="<%=basePath%>jsp/module_index.jsp">[下一页]</a>
	<a href="<%=basePath%>jsp/module_index.jsp">[尾页]</a>
	</p>
	
	</div>

  </body>

  
</html>
