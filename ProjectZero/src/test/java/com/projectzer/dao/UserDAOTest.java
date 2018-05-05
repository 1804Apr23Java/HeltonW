package com.projectzer.dao;

import static org.junit.Assert.*;

import org.junit.Test;

public class UserDAOTest {

	private static final UserDAO u = new UserDAO();
	
	@Test
	public void testAddUser() {
		assertTrue(u.addUser("myUserName", "This is Password"));
	}
}
