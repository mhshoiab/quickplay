package control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBActionsDAO implements DBActions{
	private static DBActionsDAO dao;
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	private DBActionsDAO() {
		 
	}
	synchronized public static DBActionsDAO getDPActionsDAO() 
	{
		if(dao==null){
			dao=new DBActionsDAO();
			return dao;
		}
		else
		{
			return dao;
		}
	}
	
	@Override
	synchronized public boolean checkUser(String uname, String upass) {
		try{
		con=DBConUtility.getDBCon().getCon();
		ps=con.prepareStatement("select * from quickplayusers where qpusername=? AND qppassword=?");
		ps.setString(1, uname);ps.setString(2, upass);
		rs=ps.executeQuery();
		if(rs.next()){
			return true;
		}
		else{return false;}
		}catch(Exception e){e.printStackTrace();return false;}
		finally{
			try{rs.close();ps.close();}catch(Exception e){e.printStackTrace();}
			DBConUtility.getDBCon().closeConnection();
		}
	}

	@Override
	synchronized public boolean checkStatus(String uname) {
		try{
			con=DBConUtility.getDBCon().getCon();
			ps=con.prepareStatement("select qpstatus from quickplayusers where qpusername=?");
			ps.setString(1, uname);
			rs=ps.executeQuery();
			if(rs.next())
			{
				int n=rs.getInt(1);
				if(n==0){return true;}else{return false;}
			}
			else{return false;}
			}catch(Exception e){e.printStackTrace();return false;}
			finally{
				try{rs.close();ps.close();}catch(Exception e){e.printStackTrace();}
				DBConUtility.getDBCon().closeConnection();
			}
	}

	@Override
	synchronized public boolean insertUser(QPUsers user) {
		try{
			con=DBConUtility.getDBCon().getCon();
			ps=con.prepareStatement("select * from quickplayusers where qpusername=?  AND qppassword=?");
			}catch(Exception e){e.printStackTrace();}
			finally{
				try{rs.close();ps.close();}catch(Exception e){e.printStackTrace();}
				DBConUtility.getDBCon().closeConnection();
			}
		return false;
	}

	@Override
	synchronized public boolean changeStatus(String uname, int status) {
		try{
			con=DBConUtility.getDBCon().getCon();
			ps=con.prepareStatement("update quickplayusers set qpstatus=? where qpusername=?");
			ps.setInt(1, status);
			ps.setString(2, uname);
			int n=ps.executeUpdate();
			if(n==1){return true;}else {return false;}
			}catch(Exception e){e.printStackTrace();return false;}
			finally{
				try{ps.close();}catch(Exception e){e.printStackTrace();}
				DBConUtility.getDBCon().closeConnection();
			}
	}
public static void main(String[] args) {
	DBActions dao=DBActionsDAO.getDPActionsDAO();
	dao.changeStatus("karthik", 0);
	System.out.println(dao.checkStatus("karthik"));
	
}
}
