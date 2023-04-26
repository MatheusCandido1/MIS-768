package edu.unlv.mis768.ce6;

// Import required java libraries
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

// Define class to access the database
public class CoffeeDAOImpl implements CoffeeDAO {
	// Implement the methods from the interface
	@Override
	// Define the method to get all the coffees from the database
	public List<Coffee> getAllCoffees() {
		// Create a list to hold the Coffee objects
        List<Coffee> coffeeList = new ArrayList<Coffee>();
        
        try {
			// Get a connection
			Connection conn = CoffeeDBUtil.getDBConnection();
			// Create a statement
			Statement stmt = conn.createStatement(
            		ResultSet.TYPE_SCROLL_INSENSITIVE,
            		ResultSet.CONCUR_READ_ONLY);
			
			// Create a SQL query
			String sql = "SELECT * from " + CoffeeDBConstants.COFFEE_TABLE_NAME;
			//Execute the query.
            ResultSet result = stmt.executeQuery(sql);
            
            //Get the number of rows.
            result.last();                 // Move to last row
            int numRows = result.getRow(); // Get row number
            result.first();                // Move to first row

            for (int row = 0; row < numRows; row++) {
            	// create a new object and fill the field with the values from the result set.
            	Coffee coffee = new Coffee();
            	coffee.setDescription(result.getString("description"));
            	coffee.setProdNum(result.getString("prodNum"));
            	coffee.setPrice(result.getDouble("Price"));
            	//Add the object to the list
            	coffeeList.add(coffee);
               // Go to the next row in the ResultSet.
               result.next();
            }
            // close the database connection
            stmt.close();
            CoffeeDBUtil.closeDBConnection(conn);
   
			
		} catch (Exception ex) {
			System.out.println("ERROR: " + ex.getMessage());
		}
		// return the result
		return coffeeList;
	}
	// Define the method to insert a coffee from the database
	@Override
	public boolean insertCoffee(Coffee coffee) {
		// Create a boolean flag to indicate if the insert was successful
		boolean flag=false;
		try {
			// Get a connetion
			Connection conn = CoffeeDBUtil.getDBConnection();
			// Create a statement
			Statement stmt = conn.createStatement();
			
			// Create a SQL query
			String sql = "INSERT INTO " + CoffeeDBConstants.COFFEE_TABLE_NAME+
					     " VALUES ('"+
					     coffee.getProdNum()+"', '"+
					     coffee.getDescription()+"', '"+
					     coffee.getPrice()+"')";
			//Execute the query.
			int rows = stmt.executeUpdate(sql);
			// Check if the insert was successful
			if (rows ==1)
				flag=true;
				
			// close the database connection
            stmt.close();
            CoffeeDBUtil.closeDBConnection(conn);
   
			
		} catch (Exception ex) {
			// Print the error message
			System.out.println("ERROR: " + ex.getMessage());
		}
		// return the result
		return flag;
	}
	// Define the method to get a list of expensive coffees from the database
	@Override
	public List<Coffee> getExpensiveCoffees() {
		// Create a list to hold the Coffee objects
		 List<Coffee> coffeeList = new ArrayList<Coffee>();
	        
	        try {
				// Get a connetion
				Connection conn = CoffeeDBUtil.getDBConnection();
				// Create a statement
				Statement stmt = conn.createStatement(
	            		ResultSet.TYPE_SCROLL_INSENSITIVE,
	            		ResultSet.CONCUR_READ_ONLY);
				
				// Create a SQL query
				String sql = "SELECT * from " + CoffeeDBConstants.COFFEE_TABLE_NAME + " where price > 10";
				//Execute the query.
	            ResultSet result = stmt.executeQuery(sql);
	            
	            //Get the number of rows.
	            result.last();                 // Move to last row
	            int numRows = result.getRow(); // Get row number
	            result.first();                // Move to first row

	            for (int row = 0; row < numRows; row++) {
	            	// create a new object and fill the field with the values from the result set.
	            	Coffee coffee = new Coffee();
	            	coffee.setDescription(result.getString("description"));
	            	coffee.setProdNum(result.getString("prodNum"));
	            	coffee.setPrice(result.getDouble("Price"));
	            	//Add the object to the list
	            	coffeeList.add(coffee);
	               // Go to the next row in the ResultSet.
	               result.next();
	            }
	            // close the database connection
	            stmt.close();
	            CoffeeDBUtil.closeDBConnection(conn);
	   
				
			} catch (Exception ex) {
				System.out.println("ERROR: " + ex.getMessage());
			}
			// return the result
			return coffeeList;
	}

}
