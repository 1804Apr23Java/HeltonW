package com.projectzer.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.projectzero.util.ConnectionUtil;

public class UserDAO implements UserDAOInterface {

	private String filename = "connection.properties";
	
	@Override
	public User getUser(String userName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addUser(String userName, String passwordHash) {
		PreparedStatement p = null;
		try {
			System.out.println(filename);
			Connection con = ConnectionUtil.getConnectionFromFile(filename);
			String sql = "INSERT INTO BANK_USER (USER_NAME, PASSWORD_HASH) VALUES (?, ?)";
			p = con.prepareStatement(sql);
			p.setString(1, userName);
			p.setString(2, passwordHash);
			
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
	public boolean updateUser(int primaryKey, String userName, String passwordHash) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteUser(int primaryKey) {
		// TODO Auto-generated method stub
		return false;
	}

	
}
