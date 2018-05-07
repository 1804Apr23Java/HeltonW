package com.cctwo.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.cctwo.util.ConnectionUtil;

public class EmployeeDAO implements EmployeeDAOInterface {
	
	private String filename = "connection.properties";

	@Override
	public boolean addEmployee(String firstName, String lastName, int deptID, double salary, String email) {
		PreparedStatement p = null;
		try {
			Connection con = ConnectionUtil.getConnectionFromFile(filename);
			String sql = "INSERT INTO EMPLOYEE (EMP_FIRSTNAME, EMP_LASTNAME, DEPARTMENT_ID, SALARY, EMP_EMAIL) VALUES (?, ?, ?, ?, ?)";
			p = con.prepareStatement(sql);
			p.setString(1, firstName);
			p.setString(2, lastName);
			p.setInt(3,  deptID);
			p.setDouble(4, salary);
			p.setString(5, email);
			
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
	public boolean updateEmployee(int employeeID, String firstName, String lastName, int deptID, double salary,
			String email) {
		PreparedStatement p = null;
		try {
			Connection con = ConnectionUtil.getConnectionFromFile(filename);
			String sql = "UPDATE EMPLOYEE SET EMP_FIRSTNAME = ?, EMP_LASTNAME = ?, DEPARTMENT_ID = ?, SALARY = ?, EMP_EMAIL = ? WHERE EMPLOYEE_ID = ?";
			p = con.prepareStatement(sql);
			p.setString(1, firstName);
			p.setString(2, lastName);
			p.setInt(3,  deptID);
			p.setDouble(4, salary);
			p.setString(5, email);
			p.setInt(6,  employeeID);
			
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
	public boolean deleteAccount(int employeeID) {
		PreparedStatement p = null;
		try {
			Connection con = ConnectionUtil.getConnectionFromFile(filename);
			String sql = "DELETE FROM EMPLOYEE WHERE EMPLOYEE_ID = ?";
			p = con.prepareStatement(sql);
			p.setInt(1,  employeeID);
			
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

}
