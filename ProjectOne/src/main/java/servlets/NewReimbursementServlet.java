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
import util.LoginVerifier;
import util.ReimbursementVerifier;

/**
 * Servlet implementation class NewReimbursementServlet
 */
@WebServlet("/NewReimbursementServlet")
public class NewReimbursementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewReimbursementServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String description = request.getParameter("description");
		String amount = request.getParameter("amount");
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		EmployeeDAO employeeDAO = new EmployeeDAOImpl();
		Employee emp = employeeDAO.getEmployee(username);
		int userId = emp.getEmployeeId();
		
		String destination = ReimbursementVerifier.newReimbursement(userId, description, Double.parseDouble(amount));
		
		//temporary code to leave user where they are
		if(emp.isManager()) {
			destination = "Manager";
		} else {
			destination = "Employee";
		}
		
		//send user to success or fail redirect
		//currently do not show anything since employee/manager pages are different
		response.sendRedirect(destination);
	}

}
