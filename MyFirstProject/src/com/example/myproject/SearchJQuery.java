package com.example.myproject;



import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Servlet implementation class SearchJQuery
 * 
 * using the link for asp validation
 * 
 * without which the validation won't happen
 * 
 * Exercise 7 (JQUERY)
 * 
 */
public class SearchJQuery extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		SessionFactory factory,factory1;
		int id1;

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();    
		HttpSession session=request.getSession();
		if(session!=null && !session.isNew())
		{
			session.setMaxInactiveInterval(1*60);
			
			out.print("<html> <head> <link rel=stylesheet type=text/css	href=\"CSS/exercise6.css\"> "
					+ " <script src=\"JS/jquery-1.11.1.js\"></script>"
							+ "<script src=\"//ajax.aspnetcdn.com/ajax/jquery.validate/1.9/jquery.validate.min.js\"></script>"
					+ "<script type=\"text/javascript\">"
							+ "$( document ).ready(function() {"
									+ "$(\"#form_id\").validate({"
									+ "rules: {fName: \"required\","
									+ " 		lName: \"required\","
									+ "           email: {required: true, email: true},"
									+ "            password: { required: true,minlength: 5},"
									+ "             privilege: { required: true,number: true }},"
									+ "messages: {fName: \"Please enter your first name\","
									+ "            lName: \"Please enter your last name\","
									+ "				email: \"Please enter a valid email address\","
									+ "				 password: {required: \"Please provide a password\","
									+ "                          minlength: \"Your password must be at least 5 characters long\""
									+ " },"
									+ "               privilege: {required: \"Please provide a privilege\","
									+ "					number: \"Your privilege must be a number\""
									+ "}"
									+ "},"
									+ " submitHandler: function(form) {"
									+ " form.submit();"
									+ "}"
									+ " });"
									+ "});"
									+ "</script><title></title></head");
			out.print("<body text=black link=blue alink=blue vlink=blue>");
			out.print("<h3>User Registration</h3><font face=\"verdana\"  size=-1><center><p class=\"linkimg\">");
			out.print("<div style=text-align: \"center\">");
			out.print("<div	style=box-sizing: \"border-box\" display: \"inline-block\" width: \"auto\" max-width: 480px background-color: \"#FFFFFF\" border: \"2px solid #0361A8\" border-radius: \"5px\" box-shadow: \"0px 0px 8px #0361A8\" margin: \"50px auto \">");
			out.print("<div	style=background: #B22222 border-radius: 5px 5px 0px 0px padding: 15px>");
			out.print("<span style=font-family:\" arial\" color:\" yellow \"font-size: \"1.00em\" font-weight: \"bold\">Register</span>");
			out.print("</div><div style= padding: \"15px\">");

			out.print("<form id=\"form_id\" action=SearchJQuery method=post novalidation=\"novalidation\">");
			out.print("<input type=hidden name=action value=register>");
			out.print("<input type=hidden name=hide >");
			out.print("<table  class=seccol bgcolor=\"#B22222\">");
			out.print("<tr>			<td>First Name:</td>		<td><input type=text name=fName></td>		</tr>");
			out.print("<tr>			<td>Last Name:</td>			<td><input type=text name=lName></td>		</tr>");
			out.print("<tr>			<td>Password:</td>		<td><input type=text name=password></td>		</tr>");
			out.print("<tr>			<td>Privilege:</td>			<td><input type=text name=privilege></td>		</tr>");
			out.print("<tr>			<td>Email:</td>		<td><input type=text name=email></td>		</tr>");
			
			out.print("<tr>			<td>&nbsp;</td>			<td><input type=submit value=submit class=\"submit\"></td>		</tr>		<tr>");
			out.print("<td colspan=2>&nbsp;</td>		</tr>");
			out.print("<tr>			<td colspan=2>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>");
			out.print("</tr>		<tr>			<td colspan=2></td></tr>	</table>");
			
			out.print("</form>		</div>	</div></div>");

			
			
			//	String name=request.getParameter("uname");                          
				try{
					// Class.forName("oracle.jdbc.driver.OracleDriver");
					Class.forName("oracle.jdbc.OracleDriver").newInstance();

					Connection con=DriverManager.getConnection("jdbc:Oracle:thin:@localhost:1521:xe","test","test");               
					/*   PreparedStatement ps=con.prepareStatement("select * from Person where firstname=?");
		                     ps.setString(1,name);                   
		                     out.print("<table width=25% border=1>");
		                     out.print("<center><h1>Result:</h1></center>");
		    				ResultSet rs=ps.executeQuery();           */
					
					
					if (request.getParameter("fName") != null) {
						 String fname = request.getParameter("fName");

			                String lname = request.getParameter("lName");
			                int privilege = Integer.parseInt(request.getParameter("privilege"));

			                String email = request.getParameter("email");

			                String password = request.getParameter("password");
			                
			               Transaction t = null;
			        		Session session1 = null;
			        		try {
			        			factory = new Configuration().configure().buildSessionFactory();
			        			session1 = factory.openSession();
			        			t = session1.beginTransaction();
			        			DBUser db = new DBUser(fname, lname,password,privilege,email);
			        			session1.persist(db);
			        			t.commit();
			        			System.out.println("\nSuccessfully saved");
			        		}
			        		catch (HibernateException e) {
			        			if (t != null)
			        				t.rollback();
			        			e.printStackTrace();
			        		} finally {
			        			session1.close();
			        		}

					}
					out.print("<table cellpadding=2 width=25% border=2  id=userData cellpadding=2 ");
					out.print("<tr><td><b>UserId</b></td>");
					out.print("<td><b>First Name</b></td>");
					out.print("<td><b>Last Name</b></td>");
					out.print("<td><b>Password</b></td>");
					out.print("<td><b>Privilege</b></td>");
					out.print("<td><b>Email</b></td></tr>");
					
					factory1 = new Configuration().configure().buildSessionFactory();
					Session session2 = factory1.openSession();
					Transaction tx = null;
					try {
						tx = session2.beginTransaction();
						List<DBUser> listOfUsers = (List<DBUser>) session2.createCriteria(
								DBUser.class).list();
						for (Iterator iterator = listOfUsers.iterator(); iterator.hasNext();) {
							DBUser user = (DBUser) iterator.next();
							out.print("<tr><td>"+user.getUserId()+"</td>");
							out.print("<td>"+user.getPassword()+"</td>");
							out.print("<td>"+user.getPrivilege()+"</td>");
							out.print("<td>"+user.getFirstName()+"</td>");
							out.print("<td>"+ user.getLastName()+"</td>");
							out.print("<td>"+user.getEmail()+"</td>");
						//	out.print("<td><input type=\"button\" value = \"Delete\" onClick=\"Javacsript:deleteContent(this)\"></td>");
						}

						tx.commit();

						out.print("</table>");
						out.print("</body></html>");
					} catch (HibernateException e) {
						if (tx != null)
							tx.rollback();
						e.printStackTrace();
					} finally {
						session2.close();
					}


				}catch (Exception e2)
				{
					e2.printStackTrace();
				}

				finally{out.close();
				}
			
		}
		else {
			response.sendRedirect("TimeOut.html");
		}
		
		
	
	}

}
