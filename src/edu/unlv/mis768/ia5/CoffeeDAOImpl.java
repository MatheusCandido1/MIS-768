package edu.unlv.mis768.ia5;

// Import required java libraries
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

// Define class to access the database
public class CoffeeDAOImpl implements CoffeeDAO {

	@Override
	// Define method to get coffe by product number
	public Coffee getCoffeeById(String prodNum) {
		try {
			// Get a connection to the database
			Connection conn = CoffeeDBUtil.getDBConnection();
			Statement stmt = conn.createStatement(
            		ResultSet.TYPE_SCROLL_INSENSITIVE,
            		ResultSet.CONCUR_READ_ONLY);
			// Define the query
			String sql = "SELECT * from " + CoffeeDBConstants.COFFEE_TABLE_NAME + " where prodNum = '" + prodNum + "'";
			//Execute the query.
            ResultSet result = stmt.executeQuery(sql);
            

            //Get the number of rows.
            result.last();                 // Move to last row
            int numRows = result.getRow(); // Get row number
            result.first();        
            // If there is a row, return the coffee object
            if(result.getRow() == 1) {
    			Coffee coffee = new Coffee();
            	coffee.setProdNum(result.getString("prodNum"));
            	coffee.setDescription(result.getString("description"));
            	coffee.setPrice(result.getDouble("price"));
            	return coffee;
            }
           
			
		} catch (Exception ex) {
			System.out.println("ERROR: " + ex.getMessage());
		}
		return null;
	}

}
