package com.container.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.container.beans.SendEmail;
import com.container.dao.ApplicationDao;

public class Registration extends HttpServlet {
	
	public void Registration() {}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String response = null;
		String user = req.getParameter("username");
		String firstPass = req.getParameter("firstPass");
		String secondPass = req.getParameter("secondPass");
		
		String hashedPass = org.apache.commons.codec.digest.DigestUtils.sha256Hex(firstPass); 
		
		String email = req.getParameter("email");
		String jspstate = null;
		
		if(firstPass.equals(secondPass)) {
			try {
				
				String token = UUID.randomUUID().toString();
				response = new ApplicationDao().storeCredentials(user, hashedPass, email,token);
				
				String textBody = "Thank you for signing up with us! click on this link to verify your email: "+ req.getRequestURL()+"?token="+token;
				String subject = "Email Verification";
				
				SendEmail verifyEmail = new SendEmail();
				verifyEmail.sendEmail(email,"capstoneproject@gmail.com",textBody,subject );
				
				String message = "Successful! Please check your email for confirmation.";
				
				resp.sendRedirect("html/registration.jsp?message="+message);
				
		} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		if(response.equals("unsuccessful")) {
			jspstate = "<div class='alert alert-warning' role='alert'>Invalid login information</div>";
			req.setAttribute("msg", jspstate);
		}
		
	}
	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		
 		 String token = req.getParameter("token");
 		 
 		 try {
			new ApplicationDao().verifyToken(token);
				System.out.println("successfully verified Email!!!");
				resp.sendRedirect("html/login.jsp");
			
		} catch (SQLException e) {
			String message = "Failed to verify Email! Please try again later.";
			resp.sendRedirect("html/registration.jsp?message="+message);
			e.printStackTrace();
		}
   }
 
	
}
