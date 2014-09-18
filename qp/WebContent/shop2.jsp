<%@ include file="logout.jsp" %>
<body bgcolor="yellow">
<form method="post" action="shop.do">
<input type="hidden" name="id" value="shop">
	<h1>Gold shop...</h1>
	<input type="hidden" name="shopid" value="shop3.success">
	
	bangles:<input type="checkbox" name="c4" value="bangles">
	goldchain:<input type="checkbox" name="c5" value="gold chain">
	gold ring:<input type="checkbox" name="c6" value="gold ring">
	
	<input type="submit" value="Next Shop..">	
</form>
</body>