<%@ page contentType="text/html; charset=utf-8" language="java"
	import="java.sql.*" errorPage=""%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>无标题文档</title>

<script type="text/javascript">
	function save() {
		document.form1.action = "action1";
		document.form1.submit();
	}

	function send() {
		document.form1.action = "action2";
		document.form1.submit();
	}
</script>
	</head>
	<body>
		<form name="form1" method="post">
				<input type="text" name="username" value="scott">
				<input type="button" value="发送" onclick=send();;>
				<input type="button" value="保存" onclick=save();;>
		</form>
	</body>
</html>