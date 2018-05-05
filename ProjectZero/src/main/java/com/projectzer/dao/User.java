package com.projectzer.dao;

public class User {
	private int userId;
	private String userName;
	private String passwordHash;
	
	public User(int userId, String userName, String passwordHash) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.passwordHash = passwordHash;
	}

	public User(String userName, String passwordHash) {
		super();
		this.userName = userName;
		this.passwordHash = passwordHash;
	}

	public int getUserId() {
		return userId;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public boolean validatePassword(String password) {
		return (password.equals(this.passwordHash));
		
	}
}
