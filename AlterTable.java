package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class AlterTable {

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
        
        String sql="Alter table studentmarks Add Sem Int After marks3";
        Statement stm=con.createStatement();
        stm.executeUpdate(sql);
        System.out.println("Updated");

        
    }
}
