package kr.ac.kopo.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	/*
	public Connection getConnection(String url, String user, String password) {
		Connection conn = null;
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conn = DriverManager.getConnection(url, user, password);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	
	public Connection getConnection() {
		
		String url 		= "jdbc:oracle:thin:@localhost:1521:xe";
		String user 	= "hr";
		String password = "hr";
	
		return getConnection(url, user, password);
	}
	*/
	
	public Connection getConnection() {
		
		Connection conn = null;
		try {
			// 1단계 : 오라클 드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			// 2단계  : DB접속 후 Connection 객체 얻기
			String url 		= "jdbc:oracle:thin:@localhost:1521/free";
			String user 	= "hr";
			String password = "hr";
			
			conn = DriverManager.getConnection(url, user, password);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	
}
