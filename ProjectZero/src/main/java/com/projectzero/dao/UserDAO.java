package com.projectzero.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.projectzero.exceptions.UserNameException;
import com.projectzero.exceptions.UserNotFoundException;
import com.projectzero.util.ConnectionUtil;

public class UserDAO implements UserDAOInterface {

	private String filename = "connection.properties";
	
	@Override
	public User getUser(String userName) throws UserNotFoundException {
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
			} else {
				con.close();
				throw new UserNotFoundException("Username is not a valid username, please try again.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean addUser(String userName, String passwordHash) throws UserNameException {
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
			if(userName.length() > 50) throw new UserNameException("Username length must be less than 51 characters.");
			throw new UserNameException("Username already exists, please try a different username.");
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

	@Override
	public List<User> getAllUsers() {
		PreparedStatement p = null;
		try {
			Connection con = ConnectionUtil.getConnectionFromFile(filename);
			String sql = "SELECT * FROM BANK_USER";
			p = con.prepareStatement(sql);
			ResultSet rs = p.executeQuery();
			List<User> results = new ArrayList<>();
			
			while (rs.next()) {
				int userID = rs.getInt("USER_ID");
				String userName = rs.getString("USER_NAME");
				String passwordHash = rs.getString("PASSWORD_HASH");
				User user = new User(userID, userName, passwordHash);
				results.add(user);				
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

	
}
