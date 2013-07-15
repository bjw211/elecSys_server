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
								增加设备
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
							&nbsp;增加设备
						</td>


					</tr>
					<tr>
						<td colspan="2" valign="top">
							<form action="add_device" method="post">

								<table border="1" width="90%" cellspacing="0"
									bordercolorlight="white" bordercolordark="#4BD52B"
									align="center">
									<tr>
										<td height="44">
											设备号:
										</td>
										<td>
											<input type="text" name="dc.did" size="10" />
											<span>*</span>
										</td>
										<td>
											设备名:
										</td>
										<td>
											<input type="text" name="dc.dname" size="10" />
											<span>*</span>
										</td>
									</tr>

									<tr>
										<td height="40">
											类型:
										</td>
										<td>
											<select name="key">
												<option value="1">
													---请选择---
												</option>
												<option value="变压器">
													变压器
												</option>
												<option value="开关">
													开关
												</option>
												<option value="断路器">
													断路器
												</option>
											</select>
											<span>*</span>
										</td>
										<td>
											安放地址:
										</td>
										<td>
											<input type="text" name="dc.address" size="20" />
											<span>*</span>
										</td>
									</tr>
								</table>

								<p align="center">
									<input type="submit" value="确   定" />
									<input type="reset" value="重   置" />
								</p>

							</form>





						</td>


					</tr>
					<tr>
						<td colspan="2">
							&nbsp;
						</td>


					</tr>
					<tr>
						<td colspan="2" valign="top">
							<!--JavaScript部分-->
							<SCRIPT language=javascript>
	function secBoard(n) {
		for (i = 0; i < secTable.cells.length; i++)
			secTable.cells[i].className = "sec1";
		secTable.cells[n].className = "sec2";
		for (i = 0; i < mainTable.tBodies.length; i++)
			mainTable.tBodies[i].style.display = "none";
		mainTable.tBodies[n].style.display = "block";
	}
</SCRIPT>
							<!--HTML部分-->
							<br>
						</td>


					</tr>
					<tr>
						<td height="40" colspan="2">
							<br>
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

