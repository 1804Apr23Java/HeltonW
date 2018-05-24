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
import util.ReimbursementVerifier;

/**
 * Servlet implementation class DenyReimbursementServlet
 */
@WebServlet("/DenyReimbursementServlet")
public class DenyReimbursementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int reimbursementId = Integer.parseInt(request.getParameter("reimbursementId"));
		
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		EmployeeDAO employeeDAO = new EmployeeDAOImpl();
		Employee emp = employeeDAO.getEmployee(username);
		
		ReimbursementVerifier.updateReimbursement(reimbursementId, "denied", emp.getEmployeeId());
		
		response.sendRedirect("Manager");
	}

}
