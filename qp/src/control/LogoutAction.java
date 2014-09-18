package control;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutAction extends Action {
@Override
public String execute(HttpServletRequest request,
		HttpServletResponse response) throws Exception {
	DBActionsDAO dao=DBActionsDAO.getDPActionsDAO();
	try{
		HttpSession session=request.getSession();
		String uname=session.getAttribute("uname").toString();
		dao.changeStatus(uname, 0);
		return "logout.success";
	}catch(Exception e){e.printStackTrace();return null;}
	finally{DBConUtility.getDBCon().closeConnection();}
}
}
