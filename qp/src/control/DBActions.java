package control;

public interface DBActions {
	public boolean checkUser(String uname,String upass);
	public boolean checkStatus(String uname);
	public boolean insertUser(QPUsers user);
	public boolean changeStatus(String uname,int status);
}
