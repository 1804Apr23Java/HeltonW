package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;

import dao.Employee;
import dao.EmployeeDAO;
import dao.EmployeeDAOImpl;
import dao.Reimbursement;
import dao.ReimbursementDAO;
import dao.ReimbursementDAOImpl;

/**
 * Servlet implementation class ThisEmployeesResolvedReimbursementsServlet
 */
@WebServlet("/ThisEmployeesResolvedReimbursementsServlet")
public class ThisEmployeesResolvedReimbursementsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		ObjectMapper objectMapper = new ObjectMapper();
		if(session != null) {
			response.setContentType("application/json");
			
			String username = (String) session.getAttribute("username");
			EmployeeDAO employeeDAO = new EmployeeDAOImpl();
			Employee emp = employeeDAO.getEmployee(username);
			int userId = emp.getEmployeeId();
			
			ReimbursementDAO reimbursementDAO = new ReimbursementDAOImpl();
			List<Reimbursement> list = reimbursementDAO.getReimbursementsByEmployeeAndApproval(userId, "approved");
			list.addAll(reimbursementDAO.getReimbursementsByEmployeeAndApproval(userId, "denied"));
			PrintWriter writer = response.getWriter();
			writer.write(objectMapper.writeValueAsString(list));
		}
	}
}
