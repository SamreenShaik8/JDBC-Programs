package com.jdbccodes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Day1 {
private static Connection connection;

public static void main(String[] args) 
		throws ClassNotFoundException, SQLException {
	Class.forName("com.mysql.cj.jdbc.Driver");
	System.out.println("Driver is connected");
	connection = DriverManager.getConnection
	(Credentials.url, Credentials.user_N, Credentials.pwd);
	if(connection == null)
		System.out.println("Java is not connected  to the Database");
	else
		System.out.println("Java is  connected  to the Database");
	
}
}
