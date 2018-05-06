package com.projectzero.dao;

import static org.junit.Assert.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.projectzero.dao.Account;
import com.projectzero.dao.AccountDAO;
import com.projectzero.dao.User;
import com.projectzero.dao.UserDAO;
import com.projectzero.exceptions.AccountException;
import com.projectzero.exceptions.UserNameException;
import com.projectzero.exceptions.UserNotFoundException;
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
		try {
			userDAO.addUser("myUser1", "myPassword1");
			User testUser = userDAO.getUser("myUser1");
			assertTrue(accountDAO.addAccount(testUser.getUserId(), 987.32));
		} catch (UserNameException e) {
			e.printStackTrace();
		} catch (UserNotFoundException e) {
			e.printStackTrace();
		} catch (AccountException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	@Test
	public void testAddFakeAccount() {
		try {
			assertFalse(accountDAO.addAccount(999, 32.32));
		} catch (AccountException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testGetAccounts() {
		try {
			userDAO.addUser("u", "p");
			int id = userDAO.getUser("u").getUserId();

			for(int i = 0; i < 10; i++) {
				accountDAO.addAccount(id, 99.01);
			}
			
			List<Account> list = accountDAO.getAccounts(id);
			assertTrue(list.size() == 10);
		} catch (UserNameException e) {
			e.printStackTrace();
		} catch (UserNotFoundException e) {
			e.printStackTrace();
		} catch (AccountException e) {
			e.printStackTrace();
		}		
	}
	
	@Test
	public void testUpdateAccount() {
		try {
			userDAO.addUser("myUser1", "myPassword1");
			User testUser = userDAO.getUser("myUser1");
			accountDAO.addAccount(testUser.getUserId(), 987.32);
			List<Account> list = accountDAO.getAccounts(testUser.getUserId());
			assertTrue(accountDAO.updateAccount(list.get(0).getAccountId(), testUser.getUserId(), 1_000_000.00));
		} catch (UserNameException e) {
			e.printStackTrace();
		} catch (UserNotFoundException e) {
			e.printStackTrace();
		} catch (AccountException e) {
			e.printStackTrace();
		}		
	}
	
	@Test
	public void testDeleteAccount() {
		try {
			userDAO.addUser("myUser1", "myPassword1");
			User testUser = userDAO.getUser("myUser1");
			accountDAO.addAccount(testUser.getUserId(), 987.32);
			List<Account> list = accountDAO.getAccounts(testUser.getUserId());
			assertTrue(accountDAO.deleteAccount(list.get(0).getAccountId()));
		} catch (UserNameException e) {
			e.printStackTrace();
		} catch (UserNotFoundException e) {
			e.printStackTrace();
		} catch (AccountException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testSubtractMonthlyFee() {
		try {
			userDAO.addUser("myUser1", "myPassword1");
			User testUser = userDAO.getUser("myUser1");
			accountDAO.addAccount(testUser.getUserId(), 987.32);
			accountDAO.subtractMonthlyFee(500.25);
			assertTrue(accountDAO.getAccounts(testUser.getUserId()).get(0).getBalance() == 487.07);
		} catch (UserNameException e) {
			e.printStackTrace();
		} catch (UserNotFoundException e) {
			e.printStackTrace();
		} catch (AccountException e) {
			e.printStackTrace();
		}
		
	}
}
