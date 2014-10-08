package control;

import java.io.Serializable;

public class QPUsers implements Serializable{
	private int qpid;
	private String qpusername,qppassword,qpscity,qpstate;
	private int qpstatus;
	public final int getQpid() {
		return qpid;
	}
	public final void setQpid(int qpid) {
		this.qpid = qpid;
	}
	public final String getQpusername() {
		return qpusername;
	}
	public final void setQpusername(String qpusername) {
		this.qpusername = qpusername;
	}
	public final String getQppassword() {
		return qppassword;
	}
	public final void setQppassword(String qppassword) {
		this.qppassword = qppassword;
	}
	public final String getQpscity() {
		return qpscity;
	}
	public final void setQpscity(String qpscity) {
		this.qpscity = qpscity;
	}
	public final String getQpstate() {
		return qpstate;
	}
	public final void setQpstate(String qpstate) {
		this.qpstate = qpstate;
	}
	public final int getQpstatus() {
		return qpstatus;
	}
	public final void setQpstatus(int qpstatus) {
		this.qpstatus = qpstatus;
	}
	
}
