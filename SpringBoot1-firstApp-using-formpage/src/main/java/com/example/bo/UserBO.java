package com.example.bo;



public class UserBO {
	private String uname;
	private String mailid;
	private long mblno;
	
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getMailid() {
		return mailid;
	}
	public void setMailid(String mailid) {
		this.mailid = mailid;
	}
	public long getMblno() {
		return mblno;
	}
	public void setMblno(long mblno) {
		this.mblno = mblno;
	}
	@Override
	public String toString() {
		return "UserBO [uname=" + uname + ", mailid=" + mailid + ", mblno=" + mblno + "]";
	}
	

}
