package com.williamhelton.reimbursement.dao;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

import org.junit.Before;
import org.junit.Test;

import com.williamhelton.reimbursement.util.ConnectionUtil;

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
}
