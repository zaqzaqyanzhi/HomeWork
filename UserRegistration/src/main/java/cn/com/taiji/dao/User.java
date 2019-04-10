package cn.com.taiji.dao;

public class User {

	private String user;
	private String upassword;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String user, String upassword) {
		super();
		this.user = user;
		this.upassword = upassword;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getUpassword() {
		return upassword;
	}
	public void setUpassword(String upassword) {
		this.upassword = upassword;
	}
	@Override
	public String toString() {
		return "User [user=" + user + ", upassword=" + upassword + "]";
	}
	
}
