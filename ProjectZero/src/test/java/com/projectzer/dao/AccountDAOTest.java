package com.projectzer.dao;

import static org.junit.Assert.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.projectzero.dao.Account;
import com.projectzero.dao.AccountDAO;
import com.projectzero.dao.User;
import com.projectzero.dao.UserDAO;
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
			accountDAO.addAccount(id, 99.01);
		}
		
		List<Account> list = accountDAO.getAccounts(id);
		assertTrue(list.size() == 10);
	}
	
	@Test
	public void testUpdateAccount() {
		userDAO.addUser("myUser1", "myPassword1");
		User testUser = userDAO.getUser("myUser1");
		accountDAO.addAccount(testUser.getUserId(), 987.32);
		List<Account> list = accountDAO.getAccounts(testUser.getUserId());
		assertTrue(accountDAO.updateAccount(list.get(0).getAccountId(), testUser.getUserId(), 1_000_000.00));
	}
	
	@Test
	public void testDeleteAccount() {
		userDAO.addUser("myUser1", "myPassword1");
		User testUser = userDAO.getUser("myUser1");
		accountDAO.addAccount(testUser.getUserId(), 987.32);
		List<Account> list = accountDAO.getAccounts(testUser.getUserId());
		assertTrue(accountDAO.deleteAccount(list.get(0).getAccountId()));
	}
	
	@Test
	public void testSubtractMonthlyFee() {
		userDAO.addUser("myUser1", "myPassword1");
		User testUser = userDAO.getUser("myUser1");
		accountDAO.addAccount(testUser.getUserId(), 987.32);
		accountDAO.subtractMonthlyFee(500.25);
		assertTrue(accountDAO.getAccounts(testUser.getUserId()).get(0).getBalance() == 487.07);
	}
}
