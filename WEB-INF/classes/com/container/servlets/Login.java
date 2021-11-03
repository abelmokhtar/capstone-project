package com.container.servlets;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.io.PrintWriter;
import java.text.MessageFormat;
import java.util.List;

import javax.naming.Context;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.container.dao.ApplicationDao;


public class Login extends HttpServlet{
	
	private String messageString = null;
	private String btnType = null;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String action = req.getServletPath();
		String jspstate = null;
		
		switch(action){
			case "/authenticate":
				String username = req.getParameter("username");
				String password = req.getParameter("password");		
				if(username.equals("admin") && password.contentEquals("capstone")) {
					//jspstate = "<div class='alert alert-warning' role='alert'>Success</div>";
					resp.sendRedirect(req.getContextPath() + "/dashboard");
				}else {
					jspstate = "<div class='alert alert-warning' role='alert'>Login Failed</div>";
					req.setAttribute("msg", jspstate);
					req.getRequestDispatcher("/html/login.jsp").forward(req, resp);
				}	
			    break;
			default:
				jspstate = ""; 
				break;
		}
	}
	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		
 		 req.getRequestDispatcher("/html/login.jsp").forward(req, resp);
   }
 
}
