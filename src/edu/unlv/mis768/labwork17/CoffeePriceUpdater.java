package edu.unlv.mis768.labwork17;


import java.util.Scanner;
import java.sql.*;

public class CoffeePriceUpdater {

	public static void main(String[] args) {
	    // Create named constants for the URL, user name and password
	    final String DB_URL = "jdbc:mysql://localhost:3306/CoffeeShopData";
	    final String USER_NAME = "root";
	    final String PASSWORD = "";
	    
		String prodNum;      // To hold the product number
	    double price;        // To hold the price
	    
	    
	    // Create a Scanner object for keyboard input.
	    Scanner keyboard = new Scanner(System.in);
	    try {
	    	// Create a connection to the database.
	        Connection conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);

	        // Get the product number for the desired coffee.
	        System.out.print("Enter the product number: ");
	        prodNum = keyboard.nextLine();
	        
	        // Display the coffee's current data.
	        if (findProduct(conn, prodNum)) {
	            // Ask for the new price
	            System.out.print("What is the new price?");
	            double updatePrice = keyboard.nextDouble();
	            
	            // call the method to update the price
	            updatePrice(conn, prodNum, updatePrice);

	          }
	          else  {
	        	// The specified product number was not found.
	            System.out.println("That product was not found.");
	          }

	          // Close the connection.
	          conn.close();
	       }
	       catch(Exception ex) {
	          System.out.println("ERROR: " + ex.getMessage());
	       }
	    }

		/**
	      The findAndDisplayProduct method finds a specified coffee
	      @param conn A Connection object to the database.
	      @param prodNum The product number for the desired coffee.
	      @return true or false to indicate whether the product was found.
	    */

	    public static boolean findProduct(Connection conn, String prodNum) throws SQLException {
	    	boolean productFound = false; // Flag

	        // Create a SELECT statement to get the specified row from the Coffee table.
	        String sqlStatement = "SELECT * FROM Coffee WHERE prodNum=?";

	        // instantiate a PrepareStatement object using the SQL command
	        PreparedStatement prepStmt = conn.prepareStatement(sqlStatement);
	        
	        // provide the values for query.
	        prepStmt.setString(1,  prodNum);
			
	       // Send the SELECT statement to the DBMS.
	       ResultSet result = prepStmt.executeQuery();

	       // If the result is not empty (i.e., have data to be read)
	       if (result.next()) {
	             // Set the flag to indicate the product was found.
	             productFound = true;
	       }

	       return productFound;
	    }

	    /**
	      The updatePrice method updates a specified coffee's price.
	      @param conn A Connection object to the database.
	      @param prodNum The product number for the desired coffee.
	      @param price The product's new price.
	    */

	    public static void updatePrice(Connection conn, String prodNum, double price) throws SQLException {
	       // Create an UPDATE statement to update the price for the specified product number.
	       String sqlStatement = "UPDATE coffee SET price = ? WHERE prodNum = ?;";

	        // instantiate a PrepareStatement object using the SQL command
	        PreparedStatement prepStmt = conn.prepareStatement(sqlStatement);
	        
	        // provide the values for Update command.
	        prepStmt.setDouble(1, price);
	        prepStmt.setString(2, prodNum);
	       // Send the UPDATE statement to the DBMS.
	       int rows = prepStmt.executeUpdate();

	       // Display the results.
	       System.out.println(rows + " row(s) updated.");
	    }

}
