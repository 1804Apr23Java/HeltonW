package com.williamhelton.reimbursement.dao;

public class Employee {
	private int employeeId;
	private String userName;
	private String password;
	private String firstName;
	private String lastName;
	private String email;
	private boolean isManager;
	
	public Employee(int employeeId, String userName, String password, String firstName, String lastName, String email,
			boolean isManager) {
		super();
		this.employeeId = employeeId;
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.isManager = isManager;
	}

	public int getEmployeeId() {
		return employeeId;
	}
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isManager() {
		return isManager;
	}

	public void setManager(boolean isManager) {
		this.isManager = isManager;
	}	
	
}
