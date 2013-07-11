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
        <td height="31"><div class="titlebt">修改设备</div></td>
      </tr>
    </table></td>
    <td width="16" valign="top" background="images/mail_rightbg.gif"><img src="images/nav-right-bg.gif" width="16" height="29" /></td>
  </tr>
  <tr>
    <td valign="middle" background="images/mail_leftbg.gif">&nbsp;</td>
    <td valign="top" bgcolor="#F7F8F9"><table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
      <tr>
        <td colspan="2" valign="top" align="center">&nbsp;修改设备信息</td>
        
        
      </tr>
      <tr>
        <td colspan="2" valign="top">
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
	
        
        
        
        
        </td>
        
        
      </tr>
      <tr>
        <td colspan="2">&nbsp;</td>
        
        
      </tr>
      <tr>
        <td colspan="2" valign="top"><!--JavaScript部分-->
            <SCRIPT language=javascript>
function secBoard(n)
{
for(i=0;i<secTable.cells.length;i++)
secTable.cells[i].className="sec1";
secTable.cells[n].className="sec2";
for(i=0;i<mainTable.tBodies.length;i++)
mainTable.tBodies[i].style.display="none";
mainTable.tBodies[n].style.display="block";
}
          </SCRIPT>
            <!--HTML部分--><br></td>
        
        
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
