package com.williamhelton.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class VoteServlet extends HttpServlet {
	
	

	/**
	 * CREATE TABLE PROJ1EMPLOYEE (
    EMP_ID VARCHAR2(100) PRIMARY KEY,
    EMP_USERBAME VARCHAR2(100),
    EMP_PASSWORD VARCHAR2(100),
    EMP_EMAIL VARCHAR2(100)
    
	 * INSERT INTO PROJ1EMPLOYEE VALUES (1,'JOSE','PASS', 'JLM@GMAIL.COM');
	 */
	private static final long serialVersionUID = 3761901033949937002L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		RequestDispatcher rd = req.getRequestDispatcher("loginHome.html");
		rd.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		//obtain request parameters
		String result = req.getParameter("vote");
		//string result = req.getParameter("vote");
		System.out.println(result);
		try {
			System.out.println(getMovie(result));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		//calculate answer
		
		
		//include answer
		//or forward request to an AnswerServlet
		PrintWriter pw = resp.getWriter();
		pw.write("<p style = \"margin:30px\"> The answer is: " + result + "</p>");
		
		RequestDispatcher rd = req.getRequestDispatcher("loginHome.html");
		rd.forward(req, resp);
		
		//save the answer as a request attribute (answer servlet)
		//display on new page
		//ResultsServlet
		//fetch existing results
		
		//save results on backend
		//toss user on results page
		
	}
	
	public String getMovie(String username) throws ClassNotFoundException {
		String filename = "connection.properties";
		PreparedStatement p = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@apr23java.cg5hazkndtda.us-east-2.rds.amazonaws.com:1521:ORCL", "jlmunoz4", "Utep**9900");
			String sql = "SELECT EMP_PASSWORD FROM PROJ1EMPLOYEE WHERE EMP_USERBAME = ?";
			p = con.prepareStatement(sql);
			p.setString(1, username);
			ResultSet rs = p.executeQuery();
			System.out.println("query executed:");
			String result= "null oops";
			while(rs.next()) {
				result = rs.getString("EMP_PASSWORD");
			}
			
			
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
