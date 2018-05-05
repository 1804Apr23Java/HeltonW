package com.projectzer.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.projectzero.util.ConnectionUtil;

public class AccountDAO implements AccountDAOInterface {
	
	private String filename = "connection.properties";

	@Override
	public List<Account> getAccounts(int userId) {
		PreparedStatement p = null;
		
		try {
			Connection con = ConnectionUtil.getConnectionFromFile(filename);
			String sql = "SELECT * FROM BANK_ACCOUNT WHERE USER_ID = ?";
			p = con.prepareStatement(sql);
			p.setInt(1, userId);
			ResultSet rs = p.executeQuery();
			List<Account> results = new ArrayList<>();
			
			while (rs.next()) {
				int accountID = rs.getInt("ACCOUNT_ID");
				double balance = rs.getDouble("ACCOUNT_BALANCE");
				Account account = new Account(accountID, userId, balance);
				results.add(account);
			}
			con.close();
			return results;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean addAccount(int user_id, double balance) {
		PreparedStatement p = null;
		try {
			Connection con = ConnectionUtil.getConnectionFromFile(filename);
			String sql = "INSERT INTO BANK_ACCOUNT (USER_ID, ACCOUNT_BALANCE) VALUES (?, ?)";
			p = con.prepareStatement(sql);
			p.setInt(1, user_id);
			p.setDouble(2, balance);
			
			int rowCount = p.executeUpdate();
			con.close();
			return (rowCount == 1) ? true : false;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public double updateAccount(int account_id, double balance) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean updateAccount(int account_id, int user_id, double balance) {
		// TODO Auto-generated method stub
		return false;
	}

}
