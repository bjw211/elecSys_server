<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
	<head>
		<meta http-equiv="refresh" content="2;url=<%=basePath%>/jsp/index.jsp">
		<title></title>
	</head>
	<body>
		<p align="center">
			执行成功,自动跳转至首页！
		</p>
	</body>
</html>