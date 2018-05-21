package com.williamhelton.reimbursement.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.williamhelton.reimbursement.dao.Employee;
import com.williamhelton.reimbursement.dao.EmployeeDAOImpl;

/**
 * Servlet implementation class GetEmployeeInfoServlet
 */
@WebServlet("/GetEmployeeInfoServlet")
public class GetEmployeeInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetEmployeeInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EmployeeDAOImpl employeeDAO = new EmployeeDAOImpl();
		Employee employee = employeeDAO.getEmployee(request.getHeader("username"));
		PrintWriter pw = response.getWriter();
		pw.write(employee.toString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		EmployeeDAOImpl employeeDAO = new EmployeeDAOImpl();
		Employee employee = employeeDAO.getEmployee(request.getHeader("username"));
		PrintWriter pw = response.getWriter();
		pw.write(employee.toString());
	}

}
