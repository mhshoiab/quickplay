package control;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConUtility {
	private Connection con;
	private static DBConUtility dbconutility;
	private static ThreadLocal<Connection> tlocal=new ThreadLocal<Connection>();
	private DBConUtility()
	{
		try{
			System.out.println("object made.....");
		Class.forName("oracle.jdbc.OracleDriver");
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","hr","hr");
		}catch(Exception e){e.printStackTrace();}
	}

	synchronized public static DBConUtility getDBCon()
	{
		if(dbconutility==null)
		{
			dbconutility=new DBConUtility();
			return dbconutility;
		}
		else
		{
			return dbconutility;
		}
	}
	int count=1;
	final public Connection getCon() {
		try{
			con=tlocal.get();
			if(con==null)
			{
				
				if(count<=15){
					++count;
				con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","hr","hr");
				tlocal.set(con);
				return con;}
				else
				{
					System.out.println("No more connections....:"+count+" already made...max 15");
					return null;
				}
			}
			else{
				return con;
			}
		}catch(Exception e){e.printStackTrace();return null;}
	}
	final public void closeConnection()
	{
		con=tlocal.get();
		if(con!=null)
		{
			--count;
			try{con.close();}catch(Exception e){e.printStackTrace();}
			System.out.println("connections closed....");
			tlocal.remove();
			
		}
		else
		{
			System.out.println("first create/get a connection...");
		}
	}
}
