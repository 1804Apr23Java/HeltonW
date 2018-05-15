package com.williamhelton.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	
}
