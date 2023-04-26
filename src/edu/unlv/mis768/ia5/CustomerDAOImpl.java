package edu.unlv.mis768.ia5;

// Import required packages
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class CustomerDAOImpl implements CustomerDAO {
	// Define method to get customer by customer number
	public Customer getCustomerById(String CNo) {
		try {
			// Get a connection to the database
			Connection conn = CoffeeDBUtil.getDBConnection();
			Statement stmt = conn.createStatement(
            		ResultSet.TYPE_SCROLL_INSENSITIVE,
            		ResultSet.CONCUR_READ_ONLY);
			// Define the query
			String sql = "SELECT * from " + CoffeeDBConstants.CUSTOMER_TABLE_NAME + " where customerNumber = '" + CNo + "'";
			//Execute the query.
            ResultSet result = stmt.executeQuery(sql);
            

            //Get the number of rows.
            result.last();                 // Move to last row
            int numRows = result.getRow(); // Get row number
            result.first();        
            // If there is a result, get the customer information
            if(result.getRow() == 1) {
    			Customer customer = new Customer();
    			customer.setCusNo(result.getString("CustomerNumber"));
    			customer.setCusName(result.getString("Name"));
    			customer.setCusAddress(result.getString("Address"));
    			customer.setCusCity(result.getString("City"));
            	customer.setCusState(result.getString("State"));
            	customer.setCusZip(result.getString("Zip"));
            	return customer;
            }
		} catch (Exception ex) {
			System.out.println("ERROR: " + ex.getMessage());
		}
		return null;
	}

	
}
