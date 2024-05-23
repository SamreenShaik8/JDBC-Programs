package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FechingDataByColumns {

	public static void main(String[] args) throws SQLException {
		String url="Jdbc:mysql://localhost:3306/student";
		String un="root";
		String pw="root";
		
		int id,marks1,marks2,marks3;
		String name;
        // registering the Driver
		DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		System.out.println("Driver is registered");
		
        // establishing the connection to Database
		System.out.println("establishing the connection");
		Connection con=DriverManager.getConnection(url, un, pw);
		System.out.println("successfully connected");
//		writing sql queries in java
		String sql="select * from studentmarks";
		Statement stm=con.createStatement();
		ResultSet res=stm.executeQuery(sql);
		
		while(res.next()==true) {
			id=res.getInt("id");
			name=res.getString("name");
			marks1=res.getInt("marks1");
			marks2=res.getInt("marks2");
			marks3=res.getInt("marks3");
			System.out.println(id+" "+name+" "+" "+marks1+" "+marks2+" "+marks3);
		}

	}

}
