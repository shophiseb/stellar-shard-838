package com.example.myproject;



import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class LoginServlet extends HttpServlet {

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		//out.print("Wrong username or password");
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		if(password.equals("password")&& name.equals("name")){
			out.print("Welcome, "+name);
			HttpSession session=request.getSession();
			session.setAttribute("name",name);

			/**for jquery
			 * 
			 */
			RequestDispatcher rd = request.getRequestDispatcher("SearchJQuery");


			/**for database
			 * 
			 */
			//RequestDispatcher rd = request.getRequestDispatcher("Search");    

			rd.forward(request,response);
			out.close();
		}

	}
}