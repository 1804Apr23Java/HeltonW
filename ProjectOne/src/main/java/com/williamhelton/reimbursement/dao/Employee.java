package com.williamhelton.reimbursement.dao;

public class Employee {
	private int employeeId;
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private String email;
	private boolean isManager;
	
	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", username=" + username + ", password=" + password
				+ ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", isManager="
				+ isManager + "]";
	}

	public Employee(int employeeId, String userName, String password, String firstName, String lastName, String email,
			boolean isManager) {
		super();
		this.employeeId = employeeId;
		this.username = userName;
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
		return username;
	}

	public void setUserName(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean validatePassword(String passwordInput) {
		return(passwordInput.equals(password));
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
