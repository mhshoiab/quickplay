package control;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ShopAction extends Action{
@Override
public String execute(HttpServletRequest request,
		HttpServletResponse response) throws Exception {
	String shopid=request.getParameter("shopid");
	HttpSession session=request.getSession();
	Enumeration<String> e=request.getParameterNames();
	while(e.hasMoreElements())
	{
		String name=e.nextElement().toString();
		String value=request.getParameter(name);
		session.setAttribute(name, value);
	}
	return shopid;
}
}
