<%@ include file="logout.jsp" %>
<body bgcolor="yellow">
<form method="post" action="shop.do">
<input type="hidden" name="id" value="shop">
	<h1>Fruit shop...</h1>
	<input type="hidden" name="shopid" value="shop4.success">
	
	Mango:<input type="checkbox" name="c7" value="mango">
	pineapple:<input type="checkbox" name="c8" value="pineapple">
	apple:<input type="checkbox" name="c9" value="apple">
	
	<input type="submit" value="Next Shop..">	
</form>
</body>