<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<link href="images/skin.css" rel="stylesheet" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<style type="text/css">
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
	<table width="100%" border="0" cellpadding="0" cellspacing="0">
		<tr>
			<td width="17" valign="top" background="images/mail_leftbg.gif">
				<img src="images/left-top-right.gif" width="17" height="29" />
			</td>
			<td valign="top" background="images/content-bg.gif">
				<table width="100%" height="31" border="0" cellpadding="0"
					cellspacing="0" class="left_topbg" id="table2">
					<tr>
						<td height="31">
							<div class="titlebt">
								新建模板
							</div>
						</td>
					</tr>
				</table>
			</td>
			<td width="16" valign="top" background="images/mail_rightbg.gif">
				<img src="images/nav-right-bg.gif" width="16" height="29" />
			</td>
		</tr>
		<tr>
			<td valign="middle" background="images/mail_leftbg.gif">
				&nbsp;
			</td>
			<td valign="top" bgcolor="#F7F8F9">
				<table width="98%" border="0" align="center" cellpadding="0"
					cellspacing="0">
					<tr>
						<td colspan="2" valign="top" align="center">
							请选择设备：
						</td>
					</tr>
					<tr align="center">
						<td class="text" colspan="2" align="center">
							输入模板名称：
							<input type="text" name="mname" />
						</td>
					</tr>
					<tr>
						<td colspan="2" valign="top">
							<div align="center">
								<s:form action="getDeviceElement">
									<table align="center" border="0" cellspacing="2" width="20%"
										cellpadding="2">
										<p align="center">
											<input type="checkbox" id="all" onclick="chk()" />
											全选
										</p>
										<s:if test="deviceList.size()>0">
											<s:iterator value="DeviceList" var="d">
												<p>
													<input type="checkbox" name="pro"
														value="<s:property value="#d.did"/>" />
													<s:property value="#d.dname" />
													<br>
												</p>
											</s:iterator>
										</s:if>
										<s:else>
											<tr>
												<td colspan="6" align="center">
													没有找到设备.
												</td>
											</tr>
										</s:else>
									</table>
									<input type="submit" value="提交" />
									<input type="reset" value="重置" />
								</s:form>
							</div>
						</td>
					</tr>
					<tr>
					</tr>
					<tr>
						<td colspan="2" valign="top">
							<!--JavaScript部分-->
					</tr>
					<tr>
						<td height="40" colspan="2">
							&nbsp;
						</td>
					</tr>
					<tr>
						<td width="2%">
							&nbsp;
						</td>
						<td width="51%" class="left_txt">
							<img src="images/icon-mail2.gif" width="16" height="11">
							疑问咨询邮箱：liyanrong912@163.com,chjili2011@163.com
							<br>
							<img src="images/icon-phone.gif" width="17" height="14">
							开发人员单位：山东大学
						</td>
					</tr>
				</table>
			</td>
			<td background="images/mail_rightbg.gif">
				&nbsp;
			</td>
		</tr>
		<tr>
			<td valign="bottom" background="images/mail_leftbg.gif">
				<img src="images/buttom_left2.gif" width="17" height="17" />
			</td>
			<td background="images/buttom_bgs.gif">
				<img src="images/buttom_bgs.gif" width="17" height="17">
			</td>
			<td valign="bottom" background="images/mail_rightbg.gif">
				<img src="images/buttom_right2.gif" width="16" height="17" />
			</td>
		</tr>
	</table>
</body>

