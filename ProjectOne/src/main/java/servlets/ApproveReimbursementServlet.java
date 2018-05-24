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
import dao.Reimbursement;
import dao.ReimbursementDAO;
import dao.ReimbursementDAOImpl;
import util.ReimbursementVerifier;

/**
 * Servlet implementation class ApproveReimbursement
 */
@WebServlet("/ApproveReimbursementServlet")
public class ApproveReimbursementServlet extends HttpServlet {
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
		System.out.println(emp.getEmployeeId());
		
		ReimbursementVerifier.updateReimbursement(reimbursementId, "approved", emp.getEmployeeId());
		
		response.sendRedirect("Manager");
	}

}
