package dao;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import util.ConnectionUtil;

public class ReimbursementDAOTest {
	private static final EmployeeDAOImpl employeeDAO = new EmployeeDAOImpl();
	private static final ReimbursementDAOImpl reimbursementDAO = new ReimbursementDAOImpl();
	
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
			
			sql = "INSERT INTO EMPLOYEE (USERNAME, PASSWORD, FIRSTNAME, LASTNAME, EMAIL, ISMANAGER) VALUES ('user1', 'pass1', 'First1', 'Last1', 'emp@email.com', 0)";
			p = con.prepareStatement(sql);
			p.executeUpdate();
			
			sql = "INSERT INTO EMPLOYEE (USERNAME, PASSWORD, FIRSTNAME, LASTNAME, EMAIL, ISMANAGER) VALUES ('user2', 'pass2', 'First2', 'Last2', 'emp@email.com', 0)";
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
	public void testCreateNewReimbursement() {
		Employee emp = employeeDAO.getEmployee("user1");
		assertTrue(reimbursementDAO.createNewReimbursement(emp.getEmployeeId(), "pending", "description 0123", 12.34));
	}
	
	@Test
	public void testGetAllReimbursements() {
		Employee emp1 = employeeDAO.getEmployee("user1");
		Employee emp2 = employeeDAO.getEmployee("user2");
		reimbursementDAO.createNewReimbursement(emp1.getEmployeeId(), "pending", "description 0123", 12.34);
		reimbursementDAO.createNewReimbursement(emp2.getEmployeeId(), "pending", "description 9876", 98.76);
		List<Reimbursement> list = reimbursementDAO.getAllReimbursements();
		assertTrue(list.size() == 2);
	}
	
	@Test
	public void testGetReimbursementsByEmployee() {
		Employee emp1 = employeeDAO.getEmployee("user1");
		reimbursementDAO.createNewReimbursement(emp1.getEmployeeId(), "pending", "description 0123", 12.34);
		reimbursementDAO.createNewReimbursement(emp1.getEmployeeId(), "pending", "description 4567", 45.67);
		assertTrue(reimbursementDAO.getReimbursementsByEmployee(emp1.getEmployeeId()).size() == 2);		
	}
	
	@Test
	public void testGetReimbursementsByApproval() {
		Employee emp1 = employeeDAO.getEmployee("user1");
		reimbursementDAO.createNewReimbursement(emp1.getEmployeeId(), "pending", "description 0123", 12.34);
		reimbursementDAO.createNewReimbursement(emp1.getEmployeeId(), "approved", "description 4567", 45.67);
		assertTrue(reimbursementDAO.getReimbursementsByApproval("pending").size() == 1);	
	}
}
