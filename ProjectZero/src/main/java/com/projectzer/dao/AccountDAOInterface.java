package com.projectzer.dao;

import java.util.List;

public interface AccountDAOInterface {
	public List<Account> getAccounts(int user_id);
	public boolean addAccount(int user_id, String accountType, double balance);
	public double updateAccount(int account_id, double balance);
	public boolean updateAccount(int account_id, int user_id, String accountType, double balance);
}