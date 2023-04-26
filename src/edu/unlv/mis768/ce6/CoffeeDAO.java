package edu.unlv.mis768.ce6;

import java.util.List;

import edu.unlv.mis768.labwork18.Customer;

public interface CoffeeDAO {
	/**
	 * This method gets all the coffees records.
	 * @return An List with coffees objects
	 */
   public List<Coffee> getAllCoffees();

	/**
	 * This method gets all the coffees records where the price is superior to 10 dollars.
	 * @return An List with coffees objects
	 */
   public List<Coffee> getExpensiveCoffees();
   
   /**
    * This method inserts a coffee record into the database
    * @param coffee a customer object
    * @return whether the insertion is successful or not
    */
   public boolean insertCoffee(Coffee coffee);
}
