package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Employee;
import dao.EmployeeDAO;
import dao.EmployeeDAOImpl;
import util.UpdateEmployeeInfoVerifier;

/**
 * Servlet implementation class UpdateEmployeeInfoServlet
 */
@WebServlet("/UpdateEmployeeInfoServlet")
public class UpdateEmployeeInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateEmployeeInfoServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String email = request.getParameter("email");
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		EmployeeDAO employeeDAO = new EmployeeDAOImpl();
		Employee emp = employeeDAO.getEmployee(username);
		int userId = emp.getEmployeeId();

		String destination = UpdateEmployeeInfoVerifier.updateEmployee(userId, firstname, lastname, email);

		// temporary code to leave user where they are
		if (emp.isManager()) {
			destination = "Manager";
		} else {
			destination = "Employee";
		}

		// send user to success or fail redirect
		// currently do not show anything since employee/manager pages are different
		response.sendRedirect(destination);
	}

}
