package com.cctwo.dao;

public interface DepartmentDAOInterface {
	public boolean addDepartment(String deptName);
	public boolean updateDepartment(int deptID, String deptName);
	public boolean deleteDepartment(int departmentID);
}
