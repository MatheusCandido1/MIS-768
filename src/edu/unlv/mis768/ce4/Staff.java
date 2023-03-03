/*
 * Author: Matheus Candido Carvalho
 * Purpose: The purpose of this program is to create a Staff class that will be used in the main class.
 * It will have the private attributes for name, pay rate and hours worked, including also the setters and getters
 * for those attributes, it will also include the calculate salary method 
 * and the To String method to represent the Staff class into a string when printed.
 * Date: 03/02/2023
 */
package edu.unlv.mis768.ce4;

// Import DecimalFormat package
import java.text.DecimalFormat;

public class Staff {
	// Fields
	private String name; // name of the employee
	private double payRate; // the hourly pay rate for the employee
	private double hours; // the number of hours worked
	
	// constants
	final double REGULAR_HOURS = 40; // the regular working hours
	final double MIN_WAGE = 13.5;  // Minimum wage allowed
	
	/* Constructor 
	 * set the default value for experience point*/
	public Staff() {
		payRate = MIN_WAGE;
	}
	// Create method to get the name
	public String getName() {
		return name;
	}
	// Create method to set the name
	public void setName(String name) {
		this.name = name;
	}
	// Create method to get the pay rate
	public double getPayRate() {
		return payRate;
	}

	/**
	 * Set the pay rate of the employee. Make sure it is not less than the minimum wage 
	 * @param rate Hourly pay rate
	 */
	public void setPayRate(double rate) {
		if (rate< MIN_WAGE )
			rate =  MIN_WAGE;
		payRate = rate;
	}
	// Create method to get the hours
	public double getHours() {
		return hours;
	}
	// Create method to set the hours
	public void setHours(double h) {
		// make sure the hours are between 0 and 50
		if (h <0)
			h=0;
		else if(h>50)
			h=50;
			
		this.hours = h;
	}

	/**
	 * calculate salary based on the number of hours given. Overtime pay is 1.5
	 * @param numOfHours Hours worked.
	 * @return Salary for the employee
	 */
	public double calcSalary() {
		// regular pay
		double salary = hours * payRate;
		
		// if worked overtime
		if (hours >REGULAR_HOURS) {
			// add the additional 0.8 * BASE_PAY to the salary
			salary += (hours-REGULAR_HOURS)*payRate*0.5;
		}
		return salary;
	}	
	
	// Override the toString method
	public String toString() {
		// format the salary to 2 decimal places
	    DecimalFormat currency = new DecimalFormat("0.00");
	    // return the name and salary
		return "Name: " + getName() + "\n"
				+ "Salary: $" + currency.format(calcSalary());
	}
	
}
