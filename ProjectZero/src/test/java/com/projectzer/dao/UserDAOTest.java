package com.projectzer.dao;

import static org.junit.Assert.*;

import org.junit.Test;

public class UserDAOTest {

	private static final UserDAO userDAO = new UserDAO();
	
	@Test
	public void testAddUser() {
		assertTrue(userDAO.addUser("myUserName", "This is Password"));
	}
	
	@Test
	public void testGetUser() {
		User userUnderTest = userDAO.getUser("myUserName");
		assertTrue(userUnderTest.getUserName().equals("myUserName"));
	}
}
