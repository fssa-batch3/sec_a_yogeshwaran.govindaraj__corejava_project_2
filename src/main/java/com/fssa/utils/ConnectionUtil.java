package com.fssa.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {

	// Private constructor to prevent instantiation
	private ConnectionUtil() {
		// Do nothing (empty constructor)
	}

	// Call the database connection
	public static Connection getConnection() {

		// Database URL and credentials
//		final String dbUrl;
//		final String dbUser;
//		final String dbPassword;
//
//		dbUrl = System.getenv("DB_URL");
//		dbUser = System.getenv("DB_USER");
//		dbPassword = System.getenv("DB_PASSWORD");

		try {
			// Load the MySQL JDBC driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			// Establish a connection to the database
		  return DriverManager.getConnection("jdbc:mysql://localhost:3306/blood", "root", "123456");
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Unable to connect to the database", e);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Database driver class not found", e);
		}
				
	}

}