package de.szut.ptms.authentication;

import java.awt.HeadlessException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import de.szut.dataLayer.sqlite.*;

public class Authentication {
	
	private Statement statement;

	ConnectionSqlite connection = new ConnectionSqlite();
	
	public void AuthUser(String username, String password) {
		connection.ConnectionSqliteIni();
		String query = "SELECT * FROM employees WHERE validname = '" + username + "'" + " AND password = '" + password+ "'";
		ResultSet queryResults = null;
		try {
			queryResults = connection.statement.executeQuery(query);
			if (!queryResults.isBeforeFirst() ) {    
				JOptionPane.showMessageDialog(null,"Falscher Benutzername oder Passwort!");
				
				}
			else {
				JOptionPane.showMessageDialog(null,"Willkommen Herr/Frau " + queryResults.getString("name"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();	
		}

	}
			

	
}
