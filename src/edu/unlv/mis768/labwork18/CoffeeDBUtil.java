package edu.unlv.mis768.labwork18;

import java.sql.*;


public class CoffeeDBUtil {
	/**
	 * This method establishes the DB connection
	 * @return a database connection
	 */
	public static Connection getDBConnection(){
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(CoffeeDBConstants.DB_URL, CoffeeDBConstants.USER_NAME, CoffeeDBConstants.PASSWORD);
		} catch (Exception ex) {
			System.out.println("ERROR: " + ex.getMessage());
		}
		
		
		
		return conn;
		
	}

	/**
	 * This method closes the DB connection
	 * @param the connection to be closed
	 */
	public static void closeDBConnection(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (Exception ex) {
				System.out.println("ERROR: " + ex.getMessage());
			}
		}
	}

	
}
