package com.container.beans;

public class TicketData {

	private String ticket_id = null;
	private String tickettitle;
	private String ticketproject;
	private String ticketdescription;
	private String assignteam;
	private String assignuser;
	
	
	public TicketData(String tickettitle, String ticketproject, String ticketdescription, String assignteam, String assignuser) {
		this.tickettitle = tickettitle;
		this.ticketproject = ticketproject;
		this.ticketdescription = ticketdescription;
		this.assignteam = assignteam;
		this.assignuser = assignuser;
	}
	
	public String getTicket_id() {
		return ticket_id;
	}
	public void setTicket_id(String ticket_id) {
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
}
