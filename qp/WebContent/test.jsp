<%@ taglib uri="/WEB-INF/mytaglib.tld" prefix="mytags" %>

<h1>
<mytags:checkNumber num="<%=request.getParameter(\"num\")%>"/>

</h1>