package com.jimly.kayak.cases.demo1008;

import java.io.Serializable;

public class UserInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	private String username;

	private transient String passwd;

	public UserInfo(String username, String passwd) {
		super();
		this.username = username;
		this.passwd = passwd;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String toString() {
		return "username=" + username + " passwd=" + passwd;
	}

}
