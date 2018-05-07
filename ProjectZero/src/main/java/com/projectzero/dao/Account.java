package com.projectzero.dao;

public class Account {
	private double balance;
	private int userId;
	private int accountId;

	public Account(int accountId, int userId, double balance) {
		super();
		this.accountId = accountId;
		this.userId = userId;
		this.balance = balance;
	}
	
	public Account(int userId, double balance) {
		super();
		this.userId = userId;
		this.balance = balance;
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
	
	@Override
	public String toString() {
		return "Account : [accountId = " + accountId + "] and [balance = " + balance + "] and [UserId = " + userId +"]";
	}
	
	public String toString(int i) {
		return "Account #" + i + " : [accountId = " + accountId + "] and [balance = " + balance + "] and [UserId = " + userId +"]";
	}
}
