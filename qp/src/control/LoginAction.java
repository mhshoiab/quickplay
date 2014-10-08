package control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginAction extends Action{
	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String uname=request.getParameter("uname");
		String upass=request.getParameter("upass");
		DBActionsDAO dao=DBActionsDAO.getDPActionsDAO();
		HttpSession session=request.getSession();
		
		if(dao.checkUser(uname, upass))
		{
			if(dao.checkStatus(uname))
			{
				session.setAttribute("uname", uname);
				dao.changeStatus(uname, 1);
				return "login.success";
			}
			else
			{
				return "login.failure";
			}
		}
		else
		{
			return "login.register";
		}
	}
}
