package edu.unlv.mis768.ia5;

public interface CoffeeDAO {
	/**
	    * This method retrieves a coffee record based on the given product number.
	    * @param prodNum Represents the primary key, product number.
	    * @return a coffee object
	    */
   public Coffee getCoffeeById(String prodNum);
}
