package control;

import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LanguageAction extends Action{
@Override
public String execute(HttpServletRequest request,
		HttpServletResponse response) throws Exception {
	String lang=request.getParameter("language");
	HttpSession session=request.getSession();
	
	Locale locale=new Locale(lang);
	ResourceBundle rb=ResourceBundle.getBundle("dictionary",locale);
	
	session.setAttribute("rb", rb);
	return "lang.success";
}
}
