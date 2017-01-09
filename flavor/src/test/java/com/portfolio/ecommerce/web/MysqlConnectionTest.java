package com.portfolio.ecommerce.web;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

public class MysqlConnectionTest {

	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://127.0.0.1:3306/jqgrid";
	private static final String USER = "root";
	private static final String PW = "root";
	
	@Test
	public void testConnection() throws Exception{
		
		Class.forName(DRIVER);
		
		try(Connection con = DriverManager.getConnection(URL,USER,PW)) {
			
			System.out.println(con);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
			
}
