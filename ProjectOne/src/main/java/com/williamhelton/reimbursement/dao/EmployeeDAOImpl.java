package com.williamhelton.reimbursement.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.williamhelton.reimbursement.util.ConnectionUtil;

public class EmployeeDAOImpl implements EmployeeDAO {
	
	private String filename = "connection.properties";

	@Override
	public Employee getEmployee(String usernameSearch) {
		PreparedStatement p = null;
		try {
			Connection con = ConnectionUtil.getConnectionFromFile(filename);
			String sql = "SELECT * FROM EMPLOYEE WHERE USERNAME = ?";
			p = con.prepareStatement(sql);
			p.setString(1, usernameSearch);
			ResultSet rs = p.executeQuery();

			if(rs.next()) {
				int userID = rs.getInt("EMPLOYEE_ID");
				String username = rs.getString("USERNAME");
				String password = rs.getString("PASSWORD");
				String firstName = rs.getString("FIRSTNAME");
				String lastName = rs.getString("LASTNAME");
				String email = rs.getString("EMAIL");
				boolean isManager = rs.getInt("ISMANAGER") == 1 ? true : false;
				
				Employee employee = new Employee(userID, username, password, firstName, lastName, email, isManager);
				
				con.close();
				return employee;
			} else {
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean createEmployee(String username, String password, String firstName, String lastName, String email,
			boolean isManager) {
		PreparedStatement p = null;
		try {
			Connection con = ConnectionUtil.getConnectionFromFile(filename);
			String sql = "INSERT INTO EMPLOYEE (USERNAME, PASSWORD, FIRSTNAME, LASTNAME, EMAIL, ISMANAGER) VALUES (?, ?, ?, ?, ?, ?)";
			p = con.prepareStatement(sql);
			p.setString(1, username);
			p.setString(2, password);
			p.setString(3, firstName);
			p.setString(4, lastName);
			p.setString(5, email);
			p.setInt(6, isManager == true ? 1 : 0);
			
			int rowCount = p.executeUpdate();
			con.close();
			return (rowCount == 1) ? true : false;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;		
	}

	@Override
	public boolean updateEmployee(int userId, String username, String password, String firstName, String lastName, String email,
			boolean isManager) {
		// TODO Auto-generated method stub
		return false;
	}

}
