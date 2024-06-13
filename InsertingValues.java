package com.jdbccodes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertingValues {
	private static Connection connection;
	private static Statement statement;

	public static void main(String[] args) 
			throws ClassNotFoundException, SQLException {
		// step-1
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Driver is connected");
		
		// step-2
		connection = DriverManager.getConnection
		(Credentials.url, Credentials.user_N, Credentials.pwd);
		if(connection == null)
			System.out.println("Java is not connected  to the Database");
		else
			System.out.println("Java is  connected  to the Database");
		
		// step-3
		/*Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the database name");
		String db_name = scanner.next();*/
		String query="Insert into PMK values(01,'Pandu Mohan Kumar','Thammineni','10-84 Raja street Ndk Ndl Ap',518401)";
		statement = connection.createStatement();
		
		// step-4
		int x = statement.executeUpdate(query);
		if(x>0)
			System.out.println("Values inserted into table");
		else
			System.out.println("Values not inserted into table");
}
}