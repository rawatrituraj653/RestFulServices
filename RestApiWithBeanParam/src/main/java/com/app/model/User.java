package com.app.model;

import javax.ws.rs.FormParam;

public class User {

	
	@FormParam("uname")
	private String uname;
	@FormParam("pwd")
	private String pwd;
	@FormParam("email")
	private String mail;
	
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}

	@Override
	public String toString() {
		return "User [uname=" + uname + ", pwd=" + pwd + ", mail=" + mail + "]";
	}
	
	
}
