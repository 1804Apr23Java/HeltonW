package com.projectzer.dao;

import java.util.List;

public interface AccountDAOInterface {
	public List<Account> getAccounts(int userId);
	public boolean addAccount(int userId, double balance);
	public double updateAccount(int accountId, double balance);
	public boolean updateAccount(int accountId, int userId, double balance);
}