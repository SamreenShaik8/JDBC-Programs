package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertingData {

	public static void main(String[] args) throws SQLException {
		String url="jdbc:mysql://localhost:3306/student";
		String un="root";
		String pw="root";
		
		int id,marks1,marks2,marks3;
		String name;
		
//		registering the driver
		DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		System.out.println("Driver is registered");
		
//		establishing the connection 
		System.out.println("Establishing the connection");
        Connection con=DriverManager.getConnection(url,un,pw);
        System.out.println("Successfully Connected");
        
//        Inserting values into the database
        String sql="insert into studentmarks values(?,?,?,?,?)";
//        the query is incoplete so we use prepared statement
        PreparedStatement pstm=con.prepareStatement(sql);
        
//        taking the user input
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter id:");
        id=sc.nextInt();
        
        System.out.println("Enter name:");
        name=sc.next();
        
        System.out.println("Enter marks1");
        marks1=sc.nextInt();
        
        System.out.println("Enter marks2");
        marks2=sc.nextInt();
        
        System.out.println("Enter marks3");
        marks3=sc.nextInt();
        
        pstm.setInt(1, id);
        pstm.setString(2, name);
        pstm.setInt(3, marks1);
        pstm.setInt(4, marks2);
        pstm.setInt(5, marks3);
        
        int x=pstm.executeUpdate();
        if(x>0) {
        	System.out.println("Updated");
        }
        else {
        	System.out.println("not updated");
        }
	}

}
