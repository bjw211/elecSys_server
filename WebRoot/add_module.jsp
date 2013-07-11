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
    
    <title></title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <script type="text/javascript">
   function chk(){
     var aa=document.getElementsByName("pro")
     for(i=0;i<aa.length;i++){
        if(document.getElementById("all").checked==true)
		{
			aa[i].checked=true;           
			}
		else
		{
        	aa[i].checked=false;
			}
     }
   }
  </script>
  
  <body>
	
	<div align="center">
	
  	<s:form action="getDeviceElement">
		 
		 <input type="submit" value="提交" />
		 
		 <table align="center" border="1" cellspacing="0" width="10%" cellpadding="0"> 
		 <s:if test="deviceList.size()>0">
		 <p><input type="checkbox" id="all" onclick="chk()" />全选</p>
		 <s:iterator value="deviceList" var="d">
			<p><input type="checkbox" name="pro" value="<s:property value="#d.did"/>"/>
				<s:property value="#d.dname" />
				<br>
			</p>
		 </s:iterator>
		 </s:if>
		 <s:else>
		 <tr>
		 <td colspan="1" align="center">nothing</td>
		 </tr></s:else>
	</table>
		 
		</s:form>
</div>
		
  </body>
</html>
