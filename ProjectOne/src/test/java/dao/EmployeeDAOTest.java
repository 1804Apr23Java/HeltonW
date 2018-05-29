package dao;

import static org.junit.Assert.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import util.ConnectionUtil;

public class EmployeeDAOTest {
	private static final EmployeeDAOImpl employeeDAO = new EmployeeDAOImpl();
//	
//	@Before
//	public void initTest() {
//		PreparedStatement p = null;
//		try {
//			Connection con = ConnectionUtil.getConnectionFromFile("connection.properties");
//			String sql = "DELETE FROM REIMB_IMAGES";
//			p = con.prepareStatement(sql);
//			p.executeUpdate();
//
//			sql = "DELETE FROM REIMBURSEMENT";
//			p = con.prepareStatement(sql);
//			p.executeUpdate();
//			
//			sql = "DELETE FROM EMPLOYEE";
//			p = con.prepareStatement(sql);
//			p.executeUpdate();
//
//			con.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
//	
//	@Test
//	public void testCreateEmployee() {
//		assertTrue(employeeDAO.createEmployee("user1", "pass1", "First1", "Last1", "emp@email.com", false));
//	}
//	
//	@Test
//	public void testCreateDuplicateEmployee() {
//		employeeDAO.createEmployee("user2", "pass2", "First1", "Last1", "emp@email.com", false);
//		assertFalse(employeeDAO.createEmployee("user2", "pass2", "First1", "Last1", "emp@email.com", false));
//	}
//	
//	@Test
//	public void testGetEmployee() {
//		employeeDAO.createEmployee("user11", "pass11", "First11", "Last11", "emp@email.com", false);
//		Employee employeeUnderTest = employeeDAO.getEmployee("user11");
//		assertTrue(employeeUnderTest.getUserName().equals("user11"));	
//	}
//	
//	@Test
//	public void testGetNonexistantEmployee() {
//		assertNull(employeeDAO.getEmployee("fakeName"));
//	}
//	
//	@Test
//	public void testUpdateEmployee() {	
//		employeeDAO.createEmployee("user3", "pass3", "First33", "Last33", "emp@email.com", false);
//		Employee employeeUnderTest = employeeDAO.getEmployee("user3");
//		employeeDAO.updateEmployee(employeeUnderTest.getEmployeeId(), "First44", "Last44", "emp@email.com");
//		employeeUnderTest = employeeDAO.getEmployee("user3");
//		assertTrue(employeeUnderTest.getLastName().equals("Last44"));
//	}
//	
//	@Test
//	public void testUpdateNonexistantEmployee() {
//		assertFalse(employeeDAO.updateEmployee(4000, "fake", "fake", "fake@fake.com"));
//	}
//	
//	@Test
//	public void testGetAllEmployees() {
//		employeeDAO.createEmployee("user1", "pass3", "First33", "Last33", "emp@email.com", false);
//		employeeDAO.createEmployee("user2", "pass3", "First33", "Last33", "emp@email.com", false);
//		employeeDAO.createEmployee("user3", "pass3", "First33", "Last33", "emp@email.com", false);
//		List<Employee> list = employeeDAO.getAllEmployees();
//		assertTrue(list.size() == 3);
//	}
}
