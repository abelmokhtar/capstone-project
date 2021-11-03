package com.container.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.naming.java.javaURLContextFactory;
import org.eclipse.jdt.internal.compiler.ast.JavadocArraySingleTypeReference;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.container.beans.ListProjects;
import com.container.beans.ListTickets;
import com.container.beans.TicketData;
import com.mysql.jdbc.PreparedStatement;

public class TicketDao {
		
	public int createTicket(TicketData tickets) {
		int rowsAffected = 0;
		
		try {
			// get the connection for the database
			Connection connection = DBConnection.getConnectionToDatabase();
			
			// write the insert query
			String insertQuery = "INSERT INTO tbltickets (ticket_title,	ticket_desc, project_id, team_id, user_id, tickettimestamp, status ) VALUES (?,?,?,?,?,?,?)";
			
			// set parameters with PreparedStatement
			java.sql.PreparedStatement preparedStatement  = connection.prepareStatement(insertQuery);
			
			preparedStatement.setString(1, tickets.getTickettitle());
			preparedStatement.setString(2, tickets.getTicketproject());
			preparedStatement.setString(3, tickets.getTicketdescription());
			preparedStatement.setString(4, tickets.getAssignteam());
			preparedStatement.setString(5, tickets.getAssignuser());
			preparedStatement.setTimestamp(6, getCurrentTimeStamp());
			preparedStatement.setInt(7, 1);

			// execute the statement
			rowsAffected = preparedStatement.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return rowsAffected;
	}
	
	
	private static java.sql.Timestamp getCurrentTimeStamp() {
		java.util.Date today = new java.util.Date();
		return new java.sql.Timestamp(today.getTime());
    }
	
	public List<ListTickets> getAllTickets() {		
		ListTickets ticket = null;
		List<ListTickets> tickets = new ArrayList<ListTickets>();
		
		
		try {
			// Connect to DB
			Connection connection = DBConnection.getConnectionToDatabase();
			
			String sql = "SELECT * FROM tbltickets WHERE active = 1 ORDER BY projectTimeStamp DESC";
			Statement statement = connection.createStatement();
			ResultSet set = statement.executeQuery(sql);
			
			// iterates all the returned data from db
			while(set.next()) {
				ticket = new ListTickets();
				ticket.setTicket_id(set.getInt("ticket_id"));
				ticket.setTickettitle(set.getString("ticket_title"));
				ticket.setTicketproject(set.getString("project_id"));
				ticket.setTicketdescription(set.getString("ticket_desc"));
				ticket.setAssignteam(set.getString("team_id"));
				ticket.setAssignuser(set.getString("user_id"));
				ticket.setTickettimestamp(set.getTimestamp("tickettimestamp"));
				ticket.setStatus(set.getInt("active"));
				tickets.add(ticket);
			}
			
		} catch (SQLException exception) {
			exception.printStackTrace();
			// TODO: handle exception
		}
		return tickets;
	}
}
