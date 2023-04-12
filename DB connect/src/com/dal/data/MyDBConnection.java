package com.dal.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyDBConnection {
	static Connection con;

	public static Connection getDbConnection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:lotus", "system", "eniya1");
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return con;
	}

	public static void main(String[] args) {
		System.out.println(getDbConnection());
	}

}