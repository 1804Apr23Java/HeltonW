package com.projectzero.dao;

import java.util.List;

public interface AccountDAOInterface {
	public List<Account> getAccounts(int userId);
	public boolean addAccount(int userId, double balance);
	public boolean updateAccount(int accountId, int userId, double balance);
	public boolean deleteAccount(int accountId);
	public void subtractMonthlyFee(double fee);
}