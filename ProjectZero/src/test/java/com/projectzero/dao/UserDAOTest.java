package com.projectzero.dao;

import static org.junit.Assert.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.projectzero.dao.User;
import com.projectzero.dao.UserDAO;
import com.projectzero.exceptions.UserNameException;
import com.projectzero.exceptions.UserNotFoundException;
import com.projectzero.util.ConnectionUtil;

public class UserDAOTest {

	private static final UserDAO userDAO = new UserDAO();
	
	@Before
	public void initTest() {
		PreparedStatement p = null;
		try {
			Connection con = ConnectionUtil.getConnectionFromFile("connection.properties");
			String sql = "DELETE FROM BANK_ACCOUNT";
			p = con.prepareStatement(sql);
			p.executeUpdate();
			
			sql = "DELETE FROM BANK_USER";
			p = con.prepareStatement(sql);
			p.executeUpdate();
			
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testAddUser() {
		try {
			assertTrue(userDAO.addUser("myUserName", "This is Password"));
		} catch (UserNameException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testAddDuplicateUser() {
		try {
			userDAO.addUser("myUserName1", "This is Password");
			assertFalse(userDAO.addUser("myUserName1", "This is Password"));
		} catch (UserNameException e) {
			e.printStackTrace();
		}		
	}
	
	@Test
	public void testGetUser() {
		try {
			userDAO.addUser("myUserName", "This is Password");
			User userUnderTest = userDAO.getUser("myUserName");
			assertTrue(userUnderTest.getUserName().equals("myUserName"));
		} catch (UserNameException e) {
			e.printStackTrace();
		} catch (UserNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void testGetFakeUser() {
		try {
			assertNull(userDAO.getUser("myFakeUser"));
		} catch (UserNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testUpdateUser() {
		try {
			userDAO.addUser("myUserName2", "This is Password33");
			User userUnderTest = userDAO.getUser("myUserName2");
			userDAO.updateUser(userUnderTest.getUserId(), "updatedUser", "updatedPass");
			userUnderTest = userDAO.getUser("updatedUser");
			assertTrue(userUnderTest.validatePassword("updatedPass"));
		} catch (UserNameException e) {
			e.printStackTrace();
		} catch (UserNotFoundException e) {
			e.printStackTrace();
		}		
	}
	
	@Test
	public void testUpdateFakeUser() {
		try {
			assertFalse(userDAO.updateUser(400, "fakeUserName", "fakePass"));
		} catch (UserNameException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testDeleteUser() {
		try {
			userDAO.addUser("myUserName", "This is Password");
			User userUnderTest = userDAO.getUser("myUserName");
			assertTrue(userDAO.deleteUser(userUnderTest.getUserId()));
		} catch (UserNameException e) {
			e.printStackTrace();
		} catch (UserNotFoundException e) {
			e.printStackTrace();
		}		
	}
	
	@Test
	public void testDeleteFakeUser() {
		assertFalse(userDAO.deleteUser(88888));
	}
	
	@Test
	public void testGetAllUsers() {
		try {
			userDAO.addUser("myUserName1", "This is Password1");
			userDAO.addUser("myUserName2", "This is Password2");
			userDAO.addUser("myUserName3", "This is Password3");
			List<User> list = userDAO.getAllUsers();
			assertTrue(list.size() == 3);
		} catch (UserNameException e) {
			e.printStackTrace();
		}		
	}
}
