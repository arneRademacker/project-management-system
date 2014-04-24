package de.szut.dataLayer.sqlite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class ConnectionSqlite {
	
	private static final String CLASSNAME = "org.sqlite.JDBC";
	private static final String CONNECTION_STRING = "jdbc:sqlite:assets/ptms_database.sqlite";

	public Connection con;
	public Statement statement;

	public void ConnectionSqliteIni() {
		try {
			Class.forName(CLASSNAME);
			con = DriverManager.getConnection(CONNECTION_STRING);
			statement = con.createStatement();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	
}

