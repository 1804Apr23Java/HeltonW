package util;

import dao.EmployeeDAO;
import dao.EmployeeDAOImpl;

public class UpdateEmployeeInfoVerifier {
	static EmployeeDAO employeeDAO = new EmployeeDAOImpl();
	
	public static String updateEmployee(int userId, String firstname, String lastname, String email) {
		if(employeeDAO.updateEmployee(userId, firstname, lastname, email)) {
			return "SuccessfulTransaction";
		} else {
			return "BadTransaction";
		}
	}
	
	
}
