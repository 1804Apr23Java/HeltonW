package com.projectzero.dao;

import java.util.List;

import com.projectzero.exceptions.AccountException;

public interface AccountDAOInterface {
	public List<Account> getAccounts(int userId);
	public boolean addAccount(int userId, double balance) throws AccountException;
	public boolean updateAccount(int accountId, int userId, double balance) throws AccountException;
	public boolean deleteAccount(int accountId);
	public void subtractMonthlyFee(double fee);
}