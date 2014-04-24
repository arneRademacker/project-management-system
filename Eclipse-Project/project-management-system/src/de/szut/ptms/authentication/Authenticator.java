package de.szut.ptms.authentication;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import de.szut.dataLayer.sqlite.*;
import de.szut.ptms.gui.*;

public class Authenticator {

public Boolean logInOk = false;	
	private Statement statement;


	ConnectionSqlite connection = new ConnectionSqlite();
	
	public void authenticateUser(String username, String password) {
		connection.ConnectionSqliteIni();
		String query = "SELECT * FROM employees WHERE validname = '" + username + "'" + " AND password = '" + password+ "'";
		ResultSet queryResults = null;
		try {
			queryResults = connection.statement.executeQuery(query);
			if (!queryResults.isBeforeFirst() ) {    
				JOptionPane.showMessageDialog(null,"Falscher Benutzername oder Passwort!");
				logInOk = false;
				
				}
			else {
				JOptionPane.showMessageDialog(null,"Willkommen Herr/Frau " + queryResults.getString("name"));
				logInOk = true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();	
		}

	}
			

	
}
