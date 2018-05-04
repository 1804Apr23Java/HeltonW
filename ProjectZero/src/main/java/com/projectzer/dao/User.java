package com.projectzer.dao;

import java.util.List;

public class User {
	private int userId;
	private String passwordHash;
	private boolean isAdmin;
	private List<Account> userAccounts;
	
	public User(int userId, boolean isAdmin, List<Account> userAccounts, String passwordHash) {
		super();
		this.userId = userId;
		this.isAdmin = isAdmin;
		this.userAccounts = userAccounts;
		this.passwordHash = passwordHash;
	}

	public User(boolean isAdmin, List<Account> userAccounts, String passwordHash) {
		super();
		this.isAdmin = isAdmin;
		this.userAccounts = userAccounts;
		this.passwordHash = passwordHash;
	}

	public int getUserId() {
		return userId;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public List<Account> getUserAccounts() {
		return userAccounts;
	}
}
