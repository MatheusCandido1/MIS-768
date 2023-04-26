package edu.unlv.mis768.ia5;

import java.util.List;

public interface CustomerDAO {
	   
	   /**
	    * This method retrieves a customer record based on the given customer number.
	    * @param CNo Represents the primary key, customer number.
	    * @return a customer object
	    */
	   public Customer getCustomerById(String CNo);
}
