package com.cctwo.dao;

public interface EmployeeDAOInterface {
	public boolean addEmployee(String firstName, String lastName, int deptID, double salary, String email);
	public boolean updateEmployee(int employeeID, String firstName, String lastName, int deptID, double salary, String email);
	public boolean deleteAccount(int employeeID);
}
