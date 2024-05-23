package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class MetaDatainfo {

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
        
//        Fetching data from Meta Data
        String sql="select * from studentmarks";
        Statement stm=con.createStatement();
        ResultSet res=stm.executeQuery(sql);
        
//        returning information about table
        ResultSetMetaData rsmd=res.getMetaData();
        
        for(int i=1; i<=rsmd.getColumnCount();i++) {
        	System.out.println(rsmd.getColumnName(i)+" "+rsmd.getColumnTypeName(i));

        }
        while(res.next()==true) {
			id=res.getInt(1);
			name=res.getString(2);
			marks1=res.getInt(3);
			marks2=res.getInt(4);
			marks3=res.getInt(5);
			System.out.println(id+" "+name+" "+" "+marks1+" "+marks2+" "+marks3);
		}
	}

}
