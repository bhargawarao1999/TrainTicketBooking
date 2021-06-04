package com.vm.trainricket.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
	public static Connection getConnection() throws Exception
	{
		return DriverManager.getConnection(JDBCProperties.URL,JDBCProperties.USERNAME,JDBCProperties.PASSWORD);
	}
}
