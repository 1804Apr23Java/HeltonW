package com.projectzer.dao;

import java.util.List;

public class AccountDAO implements AccountDAOInterface {

	@Override
	public List<Account> getAccounts(int user_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addAccount(int user_id, String accountType, double balance) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public double updateAccount(int account_id, double balance) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean updateAccount(int account_id, int user_id, String accountType, double balance) {
		// TODO Auto-generated method stub
		return false;
	}

}
