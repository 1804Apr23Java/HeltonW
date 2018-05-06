package com.projectzero.dao;

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
	
	public String getPassword() {
		return userName;
	}
	
	public boolean validatePassword(String password) {
		return (password.equals(this.passwordHash));
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", passwordHash=" + passwordHash + "]";
	}
}
