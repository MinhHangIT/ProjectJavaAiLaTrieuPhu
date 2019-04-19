package com.nhomjava.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDao {
	private static final String driverClassName="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static final String url="jdbc:sqlserver://localhost:1433;databaseName=AILATRIEUPHU";
	private static final String username="abc";
	private static final String pass="12345";
	public Connection getConnection() {
		try {
			Class.forName(driverClassName);
			Connection conn=DriverManager.getConnection(url, username, pass);
			System.out.println("ket noi thanh cong !!");
			
			return conn;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("ket noi khong thanh cong!!");
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	

	
}
