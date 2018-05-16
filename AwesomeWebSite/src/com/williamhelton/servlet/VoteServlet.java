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

import com.williamhelton.connectionutil.ConnectionUtil;

public class VoteServlet extends HttpServlet {
	
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 3761901033949937002L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		RequestDispatcher rd = req.getRequestDispatcher("besthorror.html");
		rd.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		//obtain request parameters
		String result = req.getParameter("vote");
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
		
		RequestDispatcher rd = req.getRequestDispatcher("besthorror.html");
		rd.forward(req, resp);
		
		//save the answer as a request attribute (answer servlet)
		//display on new page
		//ResultsServlet
		//fetch existing results
		
		//save results on backend
		//toss user on results page
		
	}
	
	public int getMovie(String movie) throws ClassNotFoundException {
		String filename = "connection.properties";
		PreparedStatement p = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "master");
			String sql = "SELECT ANYTHING FROM MOVIES WHERE MOVIE_TITLE = ?";
			p = con.prepareStatement(sql);
			p.setString(1, movie);
			ResultSet rs = p.executeQuery();
			System.out.println("query executed");
			int result=-1;
			while(rs.next()) {
				result = rs.getInt("ANYTHING");
				System.out.println(result + " is result");
			}
			
			
			return -1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
}
