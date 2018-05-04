package com.projectzer.dao;

public class Account {
	private double balance;
	private int userId;
	private int accountId;
	
	public Account(double balance, int userId, int accountId) {
		super();
		this.balance = balance;
		this.userId = userId;
		this.accountId = accountId;
	}

	public double getBalance() {
		return balance;
	}
	
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public int getUserId() {
		return userId;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public int getAccountId() {
		return accountId;
	}
	
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
}
