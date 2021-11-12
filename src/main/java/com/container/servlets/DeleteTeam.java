package com.container.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.container.beans.ListTeam;
import com.container.beans.Notifications;
import com.container.beans.Projects;
import com.container.dao.TeamDao;


@WebServlet("/deleteteam")	
public class DeleteTeam extends HttpServlet {
	private Notifications notify = new Notifications();
	private String btn = "";
	private String btnType = "Create";
	private String pagerequest = null;
	private String message = null;
	
	Projects project = null;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		
		
		String action = req.getServletPath();
		String state = null;
		
		switch(action){
			case "/deleteteam":
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
		
		TeamDao dao = new TeamDao();		
		List<ListTeam> teams = dao.getAllTeam();
		req.setAttribute("teams", teams);
		req.getRequestDispatcher("/html/teamcreate.jsp").forward(req, resp);
   }
   
   private String deleteProjectEntry(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException {
	    TeamDao dao = new TeamDao();
		boolean methodState = dao.archiveTeam(req.getParameter("team"));

		if(methodState) {
			message = "<div class='alert alert-success' role='alert'>Moved to archives</div>";
		}else {
			message = "<div class='alert alert-primary' role='alert'>Unable to execute request</div>";
		}
		return message;
   }
}
