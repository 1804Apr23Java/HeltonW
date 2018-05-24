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
 * Servlet implementation class SearchReimbursementsByEmployeeServlet
 */
@WebServlet("/SearchReimbursementsByEmployeeServlet")
public class SearchReimbursementsByEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		response.setContentType("application/json");
		
		String empId = request.getParameter("empId");
		
		ReimbursementDAO reimbursementDAO = new ReimbursementDAOImpl();
		List<Reimbursement> list = reimbursementDAO.getReimbursementsByEmployee(Integer.parseInt(empId));
		PrintWriter writer = response.getWriter();
		writer.write(objectMapper.writeValueAsString(list));
	}


}
