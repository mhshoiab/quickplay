<%@ taglib uri="/WEB-INF/mytaglib.tld" prefix="mytags" %>

<body bgcolor="red">
<center>
<form action="login.do" method="post">
<input type="hidden" name="id" value="login">
<table border="1">
	<tr>
		<td><mytags:bundle key="username"/></td>
		<td><input type="text" name="uname"></td>
	</tr>
	<tr>
		<td><mytags:bundle key="password"/></td>
		<td><input type="password" name="upass"></td>
	</tr>
	
	<tr><td colspan="2"><input type="submit" value="login.."></td></tr>
</table>
</form>
</center>
</body>