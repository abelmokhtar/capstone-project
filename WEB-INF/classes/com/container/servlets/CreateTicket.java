package com.container.servlets;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.io.PrintWriter;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.naming.Context;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.container.beans.ListTickets;
import com.container.beans.Notifications;
import com.container.beans.TicketData;
import com.container.dao.TicketDao;

@WebServlet("/createticket")
public class CreateTicket extends HttpServlet{

	private String querystatus = null;
	private Notifications notify = new Notifications();
	private String messageString = null;
	private String btnType = null;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String state = null;
		String action = req.getServletPath();
		
		switch(action){
		case "/createticket":
			try {
				state = createTicket(req, resp);
			} catch (SQLException | IOException | ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    break;
		default:
			state = "insert"; // this is needed to reset the state of the form
			break;
		}
		
		//List<ListProjects> projects = dao.getAllProjects();
		req.setAttribute("message", state);
		req.getRequestDispatcher("/html/createticket.jsp").forward(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		 
	    
		TicketDao dao = new TicketDao();		
		List<ListTickets> tickets = dao.getAllTickets();
		req.setAttribute("tickets", tickets);
 		 req.getRequestDispatcher("/html/createticket.jsp").forward(req, resp);
    }
 	
	public String createTicket(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException, ServletException {
		String tickettitle = req.getParameter("tickettitle");
		String ticketproject = req.getParameter("ticketproject");
		String ticketdescription = req.getParameter("ticketdescription");
		String assignteam = req.getParameter("assignteam");
		String assignuser = req.getParameter("assignuser");
		
		TicketData tickets = new TicketData(tickettitle, ticketproject, ticketdescription, assignteam, assignuser);
		
		TicketDao dao = new TicketDao();
		int rows = dao.createTicket(tickets);		
		
		if(rows > 0){
			querystatus = notify.insertNotification(true);
		}else{
			querystatus = notify.insertNotification(false);;
		}
		
		return querystatus;
    }
}
