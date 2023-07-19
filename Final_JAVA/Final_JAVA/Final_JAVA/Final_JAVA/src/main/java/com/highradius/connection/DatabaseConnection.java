package com.highradius.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

	//Credentials to the DataBase connection.
	static final String URL = "jdbc:mysql://localhost:3306/mysql";
	static final String USER = "root";
	static final String PASS = "20051619";
	
	public static Connection getConnection() throws SQLException {
		Connection con = null;
		try {
			//establishing the connection
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(URL, USER, PASS);
			
			//if connection fails display a message
			if (con == null) {
				System.out.println("Connection cannot be established");
			}
			else
			{
				System.out.println("Connection established");
			}
			//else return the connection
			return con;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
}

