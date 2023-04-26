package edu.unlv.mis768.ia5;

import java.sql.Connection;
import java.sql.Statement;


public class UnpaidOrderDAOImpl implements UnpaidOrderDAO {

	@Override
	// Define the method to insert a new unpaid order.
	public boolean insertUpaidOrder(UnpaidOrder unpaidOrder) {
		// Define a flag to indicate if the insert is successful.
		boolean flag=false;
		try {
			// Get a connection to the database.
			Connection conn = CoffeeDBUtil.getDBConnection();
			Statement stmt = conn.createStatement();
			
			// Define the SQL string.
			String sql = "INSERT INTO " + CoffeeDBConstants.UNPAID_ORDER_TABLE_NAME+
					     " VALUES ('"+
					     unpaidOrder.getCustomerNumber()+"', '"+
					     unpaidOrder.getProdNum()+"', '"+
					     unpaidOrder.getOrderDate()+"', '"+
					     unpaidOrder.getQuantity()+"', '"+
					     unpaidOrder.getPrice()+"')";
			//Execute the query.
			int rows = stmt.executeUpdate(sql);
			// If the insert is successful, set the flag to true.
			if (rows ==1)
				flag=true;
			// Close the connection.
            stmt.close();
            CoffeeDBUtil.closeDBConnection(conn);
   
			
		} catch (Exception ex) {
			System.out.println("ERROR: " + ex.getMessage());
		}
		// Return the flag.
		return flag;
	}
	
	

}
