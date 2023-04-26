package edu.unlv.mis768.labwork17;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestConnection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    final String DB_URL = "jdbc:mysql://localhost:3306/CoffeeShopData";
	    final String USERNAME = "root";
	    final String PASSWORD = "";
	    
	    try {
	    
	    	Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
	    	
	    	Statement stmt = conn.createStatement();
	    	
	    	String sql = "SELECT description, ProdNum, Price FROM coffee;";
	    	
	    	ResultSet result = stmt.executeQuery(sql);
	    	
	    	while (result.next()) {
	    		System.out.print("Description: " + result.getString("description"));
	    		System.out.print("\tNumber: " + result.getString("ProdNum"));
	    		System.out.println("\tPrice: " + result.getDouble("Price"));
	    	}
	    	
	    	conn.close();
	    	System.out.println("Database connection closed.");
	    
	    } catch(SQLException e) {
	    	System.out.println("Error: " + e.getMessage());
	    }

	}

}
