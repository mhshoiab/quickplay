package control;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class MySessionListener
 *
 */
public class MySessionListener implements HttpSessionListener {

    public void sessionCreated(HttpSessionEvent arg0) {
       System.out.println("session created...");
    }
    public void sessionDestroyed(HttpSessionEvent arg0) {
    	System.out.println("session destroyed...");
    	 HttpSession session=arg0.getSession();
         Object name=session.getAttribute("uname");
         if(name!=null)
         {
        	 String uname=name.toString();
        	 DBActionsDAO.getDPActionsDAO().changeStatus(uname, 0);
         }
    }
	
}
