package com.container.beans;

import java.sql.Timestamp;

public class ListTickets {

	private int ticket_id;
	private String tickettitle;
	private String ticketproject;
	private String ticketdescription;
	private String assignteam;
	private String assignuser;
	private Timestamp tickettimestamp;
	private int status; 	
	
	
	public int getTicket_id() {
		return ticket_id;
	}
	public void setTicket_id(int ticket_id) {
		this.ticket_id = ticket_id;
	}
	public String getTickettitle() {
		return tickettitle;
	}
	public void setTickettitle(String tickettitle) {
		this.tickettitle = tickettitle;
	}
	
	public String getTicketproject() {
		return ticketproject;
	}
	public void setTicketproject(String ticketproject) {
		this.ticketproject = ticketproject;
	}
	public String getTicketdescription() {
		return ticketdescription;
	}
	public void setTicketdescription(String ticketdescription) {
		this.ticketdescription = ticketdescription;
	}
	public String getAssignteam() {
		return assignteam;
	}
	public void setAssignteam(String assignteam) {
		this.assignteam = assignteam;
	}
	public String getAssignuser() {
		return assignuser;
	}
	public void setAssignuser(String assignuser) {
		this.assignuser = assignuser;
	}
	
	public Timestamp getTickettimestamp() {
		return tickettimestamp;
	}
	public void setTickettimestamp(Timestamp tickettimestamp) {
		this.tickettimestamp = tickettimestamp;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
}
