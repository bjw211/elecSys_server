<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<link href="images/skin.css" rel="stylesheet" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" /><style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
	background-color: #EEF2FB;
}
-->
</style>
<body>
<table width="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="17" valign="top" background="images/mail_leftbg.gif"><img src="images/left-top-right.gif" width="17" height="29" /></td>
    <td valign="top" background="images/content-bg.gif"><table width="100%" height="31" border="0" cellpadding="0" cellspacing="0" class="left_topbg" id="table2">
      <tr>
        <td height="31"><div class="titlebt">查询设备</div></td>
      </tr>
    </table></td>
    <td width="16" valign="top" background="images/mail_rightbg.gif"><img src="images/nav-right-bg.gif" width="16" height="29" /></td>
  </tr>
  <tr>
    <td valign="middle" background="images/mail_leftbg.gif">&nbsp;</td>
    <td valign="top" bgcolor="#F7F8F9"><table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
      <tr>
        <td colspan="2" valign="top">&nbsp;</td>
      </tr>
      <tr>
        <td colspan="2" valign="top">输入设备类型和安放地点，可以查询出所有的相关的设备。</td>
      </tr>
       <tr>
        <td colspan="2" valign="top">&nbsp;</td>
      </tr>
      <tr>
        <td colspan="2" valign="top">
    <div >
	<div align="center">
  	<s:form action="find_device">
		设备类型 <input name="type" type="text" size="7"/>
		安放地点 <input name="address" type="text" size="7"/>
				<input type="submit" value="查   询" />
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
	</div>
        </td>
      </tr>
      <tr>
        <td colspan="2">&nbsp;</td>
      </tr>
      <tr>
        <td height="40" colspan="2"><br></td>
      </tr>
      <tr>
        <td width="2%">&nbsp;</td>
        <td width="51%" class="left_txt"><img src="images/icon-mail2.gif" width="16" height="11"> 疑问咨询邮箱：liyanrong912@163.com,chjili2011@163.com<br>
              <img src="images/icon-phone.gif" width="17" height="14">开发人员单位：山东大学</td>
      </tr>
    </table></td>
    <td background="images/mail_rightbg.gif">&nbsp;</td>
  </tr>
  <tr>
    <td valign="bottom" background="images/mail_leftbg.gif"><img src="images/buttom_left2.gif" width="17" height="17" /></td>
    <td background="images/buttom_bgs.gif"><img src="images/buttom_bgs.gif" width="17" height="17"></td>
    <td valign="bottom" background="images/mail_rightbg.gif"><img src="images/buttom_right2.gif" width="16" height="17" /></td>
  </tr>
</table>
</body>
