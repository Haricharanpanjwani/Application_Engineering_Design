package com.my.finalproject.webModel;

public class WebUserAccount {
	private int userid;
	private String username;
	private String password;
	private int preuserid;
	private int status;
	
	
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getPreuserid() {
		return preuserid;
	}
	public void setPreuserid(int preuserid) {
		this.preuserid = preuserid;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
}
