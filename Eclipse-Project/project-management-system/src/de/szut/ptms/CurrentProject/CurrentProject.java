package de.szut.ptms.CurrentProject;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import de.szut.dataLayer.sqlite.*;

import javax.swing.JOptionPane;

public class CurrentProject {
	public String projectname, description, status, keyword, begindate, enddate, createdate;
	public int ID, leaderID;
	
	
	
	private Statement statement;
	ConnectionSqlite connection = new ConnectionSqlite();
	
	public void selectCurrentProject(int index) {
	
	connection.ConnectionSqliteIni();
	String query = "SELECT * FROM project WHERE ID = '" + index + "'";
	ResultSet queryResults = null;
	try {
		queryResults = connection.statement.executeQuery(query);
    
			while (queryResults.next()) 
			{
				ID = queryResults.getInt(1);
				projectname = queryResults.getString(2);
				description = queryResults.getString(3);
				begindate = queryResults.getString(4);
				enddate = queryResults.getString(5);
				status = queryResults.getString(6);
				createdate = queryResults.getString(7);
				leaderID = queryResults.getInt(8);
				keyword = queryResults.getString(9);
				System.out.println(createdate);
				
			}	
			
		
	} catch (SQLException e) {
		e.printStackTrace();	
	} 
}

	

}
