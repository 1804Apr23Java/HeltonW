package util;

import dao.Employee;
import dao.EmployeeDAOImpl;

public class LoginVerifier {
	static EmployeeDAOImpl employeeDAO = new EmployeeDAOImpl();
	
	public static String userLogin(String username, String password) {
		if(userIsValid(username, password)) {
			if(isManager(username)) {
				return "Manager";
			} else
				return "Employee";
		} else
			return "InvalidLogin";
	}

	private static boolean userIsValid(String username, String password) {
		// TODO Auto-generated method stub
		Employee emp = employeeDAO.getEmployee(username);
		if(emp == null) {
			System.out.println("emp is null");
			return false;
		}
		if(!emp.validatePassword(password)) {
			System.out.println("password bad");
			return false;
		}
		System.out.println("user valid");
		return true;
	}

	private static boolean isManager(String username) {
		Employee emp = employeeDAO.getEmployee(username);
		return(emp.isManager());
	}
	
}
