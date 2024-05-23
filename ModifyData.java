package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class ModifyData {

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
        
//        modifying data
        String sql="update studentmarks set marks1=? where id=?";
        
//        the query is incomplete so we use preparedstatement
        PreparedStatement pstm=con.prepareStatement(sql);
        
//        taking user input
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter id");
        id=sc.nextInt();
        System.out.println("Enter marks1");
        marks1=sc.nextInt();
        
        pstm.setInt(1, marks1);
        pstm.setInt(2, id);   
        
        
        int x=pstm.executeUpdate();
        if(x>0) {
        	System.out.println("Updated");
        }
        else {
        	System.out.println("not updated");
        }

	}

}
