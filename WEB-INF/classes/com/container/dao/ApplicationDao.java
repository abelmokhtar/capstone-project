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
import com.container.beans.Projects;
import com.mysql.jdbc.PreparedStatement;

public class ApplicationDao {
	
	/**
	 * Return all projects
	 * @param searchString
	 * @return
	*/
	public List<ListProjects> getAllProjects() {		
		ListProjects project = null;
		List<ListProjects> projects = new ArrayList<ListProjects>();
		
		
		try {
			// Connect to DB
			Connection connection = DBConnection.getConnectionToDatabase();
			
			String sql = "SELECT * FROM tblprojects WHERE active = 1 ORDER BY projectTimeStamp DESC";
			Statement statement = connection.createStatement();
			ResultSet set = statement.executeQuery(sql);
			
			// iterates all the returned data from db
			while(set.next()) {
				project = new ListProjects();
				project.setProjectID(set.getInt("project_id"));
				project.setProjectName(set.getString("project_name"));
				projects.add(project);
			}
			
		} catch (SQLException exception) {
			exception.printStackTrace();
			// TODO: handle exception
		}
		return projects;
	}
	
	public int insertProjects(Projects project) {
		int rowsAffected = 0;
		
		try {
			// get the connection for the database
			Connection connection = DBConnection.getConnectionToDatabase();
			
			// write the insert query
			String insertQuery = "INSERT INTO tblprojects (project_name, projectTimeStamp, active) VALUES (?, ?, ?)";
			
			// set parameters with PreparedStatement
			java.sql.PreparedStatement preparedStatement  = connection.prepareStatement(insertQuery);
		
			preparedStatement.setString(1, project.getProjectName());
			preparedStatement.setTimestamp(2, getCurrentTimeStamp());
			preparedStatement.setInt(3, 1);

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
	
	
	public Projects loadEntry(int id) {	
		Projects projects = null;
		try {
			// Connect to DB
			Connection connection = DBConnection.getConnectionToDatabase();
			
			java.sql.PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM tblprojects WHERE project_id = ?");
			preparedStatement.setInt(1, id);
			ResultSet set = preparedStatement.executeQuery();
			
			// iterates all the returned data from database
			while(set.next()) {
				int project_id = set.getInt("project_id");
				String project_name = set.getString("project_name");		 	
				Timestamp projectTimeStamp = set.getTimestamp("projectTimeStamp");
				int active = set.getInt("active");
				projects = new Projects(project_id, project_name, projectTimeStamp, active);
			}
			
		} catch (SQLException exception) {
			exception.printStackTrace();
			// TODO: handle exception
		}
		
		return projects;
	}
	
	
	public Boolean update(String id, String projectname) throws SQLException {
		Projects logs = null;
		boolean rowUpdate = false;
		int rowid = 0;
		try{
			rowid = Integer.parseInt(id);
			Connection connection = DBConnection.getConnectionToDatabase();
			String updateQuery = "UPDATE tblprojects SET project_name = ? WHERE project_id = ?";
			java.sql.PreparedStatement statement  = connection.prepareStatement(updateQuery);
			statement.setString(1, projectname);
			statement.setInt(2, rowid);
			rowUpdate = statement.executeUpdate() > 0;
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		return rowUpdate;
	} 	 	 	 
	
	
	public boolean archiveProject(String id) throws SQLException {
		boolean rowArchive = false;
		int rowid = 0;
		try{
			rowid = Integer.parseInt(id);
			Connection connection = DBConnection.getConnectionToDatabase();
			String updateQuery = "UPDATE tblprojects SET active = ? WHERE project_id = ?";
			java.sql.PreparedStatement statement  = connection.prepareStatement(updateQuery);
			statement.setInt(1, 0);
			statement.setInt(2, rowid);
			rowArchive = statement.executeUpdate() > 0;
		
		}catch (Exception e) {
			// TODO: handle exception
		}
		return rowArchive;
	}
}
