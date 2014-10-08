<%@ include file="logout.jsp" %>
<body bgcolor="yellow">
<form method="post" action="shop.do">
<input type="hidden" name="id" value="shop">
	<h1>Vegetable shop...</h1>
	<input type="hidden" name="shopid" value="shop2.success">
	
	Brinjal:<input type="checkbox" name="c1" value="brinjal">
	Potato:<input type="checkbox" name="c2" value="potato">
	Tomato:<input type="checkbox" name="c3" value="tomato">
	
	<input type="submit" value="Next Shop..">	
</form>
</body>