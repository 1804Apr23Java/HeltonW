package com.williamhelton.reimbursement.dao;

import static org.junit.Assert.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import com.williamhelton.reimbursement.util.ConnectionUtil;

public class EmployeeDAOTest {
	private static final EmployeeDAOImpl employeeDAO = new EmployeeDAOImpl();
	
	@Before
	public void initTest() {
		PreparedStatement p = null;
		try {
			Connection con = ConnectionUtil.getConnectionFromFile("connection.properties");
			String sql = "DELETE FROM REIMB_IMAGES";
			p = con.prepareStatement(sql);
			p.executeUpdate();

			sql = "DELETE FROM REIMBURSEMENT";
			p = con.prepareStatement(sql);
			p.executeUpdate();
			
			sql = "DELETE FROM EMPLOYEE";
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
	public void testCreateEmployee() {
		try {
			assertTrue(employeeDAO.createEmployee("user1", "pass1", "First1", "Last1", "emp@email.com", false));
		} catch(NullPointerException e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void testCreateDuplicateEmployee() {
		employeeDAO.createEmployee("user2", "pass2", "First1", "Last1", "emp@email.com", false);
		assertFalse(employeeDAO.createEmployee("user2", "pass2", "First1", "Last1", "emp@email.com", false));
	}
	
	@Test
	public void testGetEmployee() {
		employeeDAO.createEmployee("user11", "pass11", "First11", "Last11", "emp@email.com", false);
		Employee employeeUnderTest = employeeDAO.getEmployee("user11");
		try{
			assertTrue(employeeUnderTest.getUserName().equals("user11"));	
		} catch(NullPointerException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testGetNonexistantEmployee() {
		assertNull(employeeDAO.getEmployee("fakeName"));
	}
	
	@Test
	public void testUpdateEmployee() {	
		employeeDAO.createEmployee("user3", "pass3", "First33", "Last33", "emp@email.com", false);
		Employee employeeUnderTest = employeeDAO.getEmployee("user3");
		employeeDAO.updateEmployee(employeeUnderTest.getEmployeeId(), "user3", "updatedPass", "First33", "Last33", "emp@email.com", false);
		employeeUnderTest = employeeDAO.getEmployee("user3");
		assertTrue(employeeUnderTest.validatePassword("updatedPass"));
	}
	
	@Test
	public void testUpdateNonexistantEmployee() {
		assertFalse(employeeDAO.updateEmployee(4000, "fake", "fake", "fake", "fake", "fake@fake.com", false));
	}
}
