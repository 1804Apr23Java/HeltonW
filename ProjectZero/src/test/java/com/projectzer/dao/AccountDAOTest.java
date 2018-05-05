package com.projectzer.dao;

import static org.junit.Assert.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.projectzero.util.ConnectionUtil;

public class AccountDAOTest {

	public static final AccountDAO accountDAO = new AccountDAO();
	public static final UserDAO userDAO = new UserDAO();
	
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
	public void testAddAccount() {
		userDAO.addUser("myUser1", "myPassword1");
		User testUser = userDAO.getUser("myUser1");
		assertTrue(accountDAO.addAccount(testUser.getUserId(), 987.32));
	}
	
	@Test
	public void testAddFakeAccount() {
		assertFalse(accountDAO.addAccount(999, 32.32));
	}
	
	@Test
	public void testGetAccounts() {
		userDAO.addUser("u", "p");
		int id = userDAO.getUser("u").getUserId();

		for(int i = 0; i < 10; i++) {
			accountDAO.addAccount(id, 99.00);
		}
		
		List<Account> list = accountDAO.getAccounts(id);
		System.out.println(list.toString());
		assertTrue(list.size() == 10);
	}
}
