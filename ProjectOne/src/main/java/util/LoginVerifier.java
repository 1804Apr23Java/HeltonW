package util;

import dao.Employee;
import dao.EmployeeDAO;
import dao.EmployeeDAOImpl;

public class LoginVerifier {
	static EmployeeDAO employeeDAO = new EmployeeDAOImpl();
	
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
		System.out.println(username);
		System.out.println(emp);
		return (emp != null && emp.validatePassword(password));
	}

	private static boolean isManager(String username) {
		Employee emp = employeeDAO.getEmployee(username);
		return(emp.isManager());
	}
	
}
