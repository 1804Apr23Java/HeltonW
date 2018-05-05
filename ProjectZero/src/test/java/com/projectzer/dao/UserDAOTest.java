package com.projectzer.dao;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class UserDAOTest {

	private static final UserDAO userDAO = new UserDAO();
	
	//this test only works once ever
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
		User userUnderTest = userDAO.getUser("myUserName");
		assertTrue(userDAO.deleteUser(userUnderTest.getUserId()));
	}
	
	@Test
	public void testDeleteFakeUser() {
		assertFalse(userDAO.deleteUser(88888));
	}
}
