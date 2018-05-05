package com.projectzer.dao;

import java.util.List;

public class User {
	private int userId;
	private String userName;
	private String passwordHash;
	private List<Account> userAccounts;
	
	public User(int userId, String userName, List<Account> userAccounts, String passwordHash) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userAccounts = userAccounts;
		this.passwordHash = passwordHash;
	}

	public User(String userName, List<Account> userAccounts, String passwordHash) {
		super();
		this.userName = userName;
		this.userAccounts = userAccounts;
		this.passwordHash = passwordHash;
	}

	public int getUserId() {
		return userId;
	}
	
	public String getUserName() {
		return userName;
	}

	public List<Account> getUserAccounts() {
		return userAccounts;
	}
	
	public boolean validatePassword(String password) {
		return (password.equals(this.passwordHash));
		
	}
}
