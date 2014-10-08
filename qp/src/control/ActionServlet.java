package control;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ActionServlet extends HttpServlet {
	String path;Properties prop;
    @Override
    public void init(ServletConfig config) throws ServletException {
    	try{
    	String con=config.getInitParameter("config");
    	ServletContext app=config.getServletContext();
    	path=app.getRealPath(con);
    	prop=new Properties();
		prop.load(new FileInputStream(path));
		
    	}catch(Exception e){e.printStackTrace();}
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
		String id=request.getParameter("id");
		String classname=prop.getProperty(id);
		Action action=(Action)Class.forName(classname).newInstance();
		String result=action.execute(request, response);
		String nextpage=prop.getProperty(result);
		RequestDispatcher rd=request.getRequestDispatcher(nextpage);
		rd.forward(request,response);
		}catch(Exception e){e.printStackTrace();}
	}

}
