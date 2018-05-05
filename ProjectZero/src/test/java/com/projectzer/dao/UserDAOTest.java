package com.projectzer.dao;

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
		assertTrue(userDAO.addUser("myUserName", "This is Password"));
	}
	
	@Test
	public void testAddDuplicateUser() {
		userDAO.addUser("myUserName1", "This is Password");
		assertFalse(userDAO.addUser("myUserName1", "This is Password"));
	}
	
	@Test
	public void testGetUser() {
		userDAO.addUser("myUserName", "This is Password");
		User userUnderTest = userDAO.getUser("myUserName");
		assertTrue(userUnderTest.getUserName().equals("myUserName"));
	}
	
	@Test
	public void testGetFakeUser() {
		assertNull(userDAO.getUser("myFakeUser"));
	}
	
	@Test
	public void testUpdateUser() {
		userDAO.addUser("myUserName2", "This is Password33");
		User userUnderTest = userDAO.getUser("myUserName2");
		userDAO.updateUser(userUnderTest.getUserId(), "updatedUser", "updatedPass");
		userUnderTest = userDAO.getUser("updatedUser");
		assertTrue(userUnderTest.validatePassword("updatedPass"));
	}
	
	@Test
	public void testUpdateFakeUser() {
		assertFalse(userDAO.updateUser(400, "fakeUserName", "fakePass"));
	}
	
	@Test
	public void testDeleteUser() {
		userDAO.addUser("myUserName", "This is Password");
		User userUnderTest = userDAO.getUser("myUserName");
		assertTrue(userDAO.deleteUser(userUnderTest.getUserId()));
	}
	
	@Test
	public void testDeleteFakeUser() {
		assertFalse(userDAO.deleteUser(88888));
	}
	
	@Test
	public void testGetAllUsers() {
		userDAO.addUser("myUserName1", "This is Password1");
		userDAO.addUser("myUserName2", "This is Password2");
		userDAO.addUser("myUserName3", "This is Password3");
		List<User> list = userDAO.getAllUsers();
		assertTrue(list.size() == 3);
	}
}
