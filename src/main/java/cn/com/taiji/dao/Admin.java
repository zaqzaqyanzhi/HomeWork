package cn.com.taiji.dao;

public class Admin {

	private String admin;
	private String apassword;
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Admin(String admin, String apassword) {
		super();
		this.admin = admin;
		this.apassword = apassword;
	}
	public String getAdmin() {
		return admin;
	}
	public void setAdmin(String admin) {
		this.admin = admin;
	}
	public String getApassword() {
		return apassword;
	}
	public void setApassword(String apassword) {
		this.apassword = apassword;
	}
	
}
