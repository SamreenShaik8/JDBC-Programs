package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class FetchDataname {

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
		
//		Fetching data based on parameters
		String sql="select * from studentmarks where name=?";
		
//		if the query is incomplete then we go for preparedstatement
		PreparedStatement pstm=con.prepareStatement(sql);
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Please enter the name whose result has to be displayed");
		name=sc.next();
		pstm.setString(1, name);
		ResultSet res=pstm.executeQuery();
		
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
