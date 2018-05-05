package com.projectzer.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.projectzero.util.ConnectionUtil;

public class UserDAO implements UserDAOInterface {

	private String filename = "connection.properties";
	
	@Override
	public User getUser(String userName) {
		PreparedStatement p = null;
		try {
			Connection con = ConnectionUtil.getConnectionFromFile(filename);
			String sql = "SELECT * FROM BANK_USER WHERE USER_NAME = ?";
			p = con.prepareStatement(sql);
			p.setString(1, userName);
			ResultSet rs = p.executeQuery();
			
			if(rs.next()) {
				int userID = rs.getInt("USER_ID");
				String passwordHash = rs.getString("PASSWORD_HASH");
				User user = new User(userID, userName, passwordHash);
				con.close();
				return user;
			}
			
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean addUser(String userName, String passwordHash) {
		PreparedStatement p = null;
		try {
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
		PreparedStatement p = null;
		try {
			Connection con = ConnectionUtil.getConnectionFromFile(filename);
			String sql = "UPDATE BANK_USER SET USER_NAME = ?, PASSWORD_HASH = ? WHERE USER_ID = ?";
			p = con.prepareStatement(sql);
			p.setString(1, userName);
			p.setString(2, passwordHash);
			p.setInt(3, primaryKey);
			
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
	public boolean deleteUser(int primaryKey) {
		PreparedStatement p = null;
		try {
			Connection con = ConnectionUtil.getConnectionFromFile(filename);
			String sql = "DELETE FROM BANK_USER WHERE USER_ID = ?";
			p = con.prepareStatement(sql);
			p.setInt(1, primaryKey);
			
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

	
}
