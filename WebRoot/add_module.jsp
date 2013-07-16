<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
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
<script type="text/javascript" src="My97DatePicker/WdatePicker.js"></script>
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
			<td valign="middle" background="images/mail_leftbg.gif">&nbsp;
				
			</td>
			<td valign="top" bgcolor="#F7F8F9" align="center">
				<table width="98%" border="0" align="center" cellpadding="0"
					cellspacing="0">
					<tr>
						<td align="center">
                        	
                            
					<s:form action="getDeviceElement" align="center">
								<tr align="center">
									<td class="text" colspan="2" align="center">
										<table align="center" border="1" cellspacing="0" width="464"
											cellpadding="0" height="255" align="center">
											<tr align="left">
												<td width="17%" height="21">
													模板名称
												</td>
												<td width="33%">
													<input type="text" name="mname" />
												</td>
											</tr>
											<tr align="left">
												<td colspan="4" align="left">
													<div align="left">
														<p align="left">
															<input type="checkbox" id="all" onclick="chk()"
																align="left" />
															全选
														</p>
														<s:iterator value="deviceList" var="d">
															<p>
																<input type="checkbox" name="pro" align="left"
																	value="<s:property value="#d.did"/>" />
																<s:property value="#d.did" />
																----
																<s:property value="#d.dname" />
																<br>
															</p>
														</s:iterator>



													</div>
												</td>
											</tr>
											<tr>
												<td colspan="2" align="right">
													<input type="submit" value="提交" />
												</td>
												<td colspan="2" align="left">
													<input type="reset" value="重置" />
												</td>
											</tr>

										</table>
									</td>
								</tr>
							</s:form>
                        
                        
                        
                        
							
						</td>
					</tr>
					<tr>
						<td width="100%" class="left_txt">
							<img src="images/icon-mail2.gif" width="16" height="11">
							疑问咨询邮箱：liyanrong912@163.com,chjili2011@163.com
							<br>
							<img src="images/icon-phone.gif" width="17" height="14">
							开发人员单位：山东大学
						</td>


					</tr>
				</table>
			</td>
			<td background="images/mail_rightbg.gif">&nbsp;
				
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
