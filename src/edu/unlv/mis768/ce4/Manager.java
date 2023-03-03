/*
 * Author: Matheus Candido Carvalho
 * Purpose: The purpose of this program is to create a Manager class that will be used in the main class.
 * It will have the private attributes for level and the methods to get/set level, calculate salary
 * and the To String method to represent the manager class into a string when printed.
 * Date: 03/02/2023
 */

package edu.unlv.mis768.ce4;

// Import the necessary packages
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

// Create the Manager class and extend the Staff class
public class Manager extends Staff {
	// Create the constant to store the stipend multiplier 
	private static int STIPEND_MULTIPLIER = 150;
	// Create the list of levels
	ArrayList<Integer> LEVELS_LIST = new ArrayList<>(List.of(2,3,4,5));
	
	// Create the level attribute
	private int level;
	
	// Create the constructor
	public Manager() {
		// Call the super constructor
		super();
	}
	// Create the constructor
	public int getLevel() {
		// Return the level
		return level;
	}

	// Create the set level method
	public void setLevel(int level) {
		// Check if the level is in the list
		if (LEVELS_LIST.contains(level))
			this.level = level;
		else {
			// If not, set the level to 1
			this.level = 1;	
		}
	}
	/**
	 * This method calculates the salary of the manager
	 * @return the salary of the manager
	 */
	@Override
	public double calcSalary() {
		// Return the salary of the manager by calling the super class method and adding the stipend
		return super.calcSalary() + (level * STIPEND_MULTIPLIER);
	}
	
	/**
	 * This method returns the string representation of the manager
	 * @return the string representation of the manager
	 */
	public String toString() {
		// Create the decimal format object
	    DecimalFormat currency = new DecimalFormat("0.00");
	    // Return the string representation of the manager
		return "Name: " + getName() + "\n"
				+ "Level: " + getLevel() + "\n"
				+ "Salary: $" + currency.format(calcSalary());
	}
	
}
