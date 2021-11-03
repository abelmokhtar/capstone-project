package com.container.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.container.beans.ListProjects;
import com.container.beans.Notifications;
import com.container.beans.Projects;
import com.container.dao.ApplicationDao;


@WebServlet("/deleteproject")	
public class DeleteProject extends HttpServlet {
	private Notifications notify = new Notifications();
	private String btn = "";
	private String btnType = "Create";
	private String pagerequest = null;
	private String message = null;
	
	Projects project = null;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		
		
		String id = req.getParameter("projectid");
		String action = req.getServletPath();
		String state = null;
		
		switch(action){
			case "/deleteproject":
				try {
					state = deleteProjectEntry(req, resp);
				} catch (SQLException | IOException e1) {
					e1.printStackTrace();
				}
			    break;
			default:
				state = ""; // this is needed to reset the state of the form
				break;
		}
		
		ApplicationDao dao = new ApplicationDao();		
		List<ListProjects> projects = dao.getAllProjects();
		req.setAttribute("projects", projects);
		req.setAttribute("btn", btnType);
		req.setAttribute("request", "dashboard");
		req.getRequestDispatcher("/html/dashboard.jsp").forward(req, resp);
   }
   
   private String deleteProjectEntry(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException {
		ApplicationDao dao = new ApplicationDao();
		boolean methodState = dao.archiveProject(req.getParameter("id"));

		if(methodState) {
			message = "<div class='alert alert-success' role='alert'>Moved to archives</div>";
		}else {
			message = "<div class='alert alert-primary' role='alert'>Unable to execute request</div>";
		}
		return message;
   }
}
