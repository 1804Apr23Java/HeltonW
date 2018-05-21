package dao;

import java.util.List;

public interface EmployeeDAO {
	public Employee getEmployee(String username);
	public List<Employee> getAllEmployees();
	public boolean createEmployee(String username, String password, String firstName, String lastName, String email,
			boolean isManager);
	public boolean updateEmployee(int userId, String username, String password, String firstName, String lastName, String email,
			boolean isManager);
}
