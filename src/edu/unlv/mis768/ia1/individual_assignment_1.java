/*
 * Author: Matheus Candido Carvalho
 * Purpose: The purpose of this program is to calculate the amount of income tax that an user 
 * would pay due to his/gher income.
 */

package edu.unlv.mis768.ia1;

// Import Scanner lib
import java.util.Scanner;


public class individual_assignment_1 {
	
	// Create function to format value to currency
	public static String formatToCurrency(double value) {
		return "$" + value; 
		
	}
	
	// Create function to calculate the income tax based on the income
	public static String getIncomeTax (double income) {
		// Create 7 constans to register the percentages
		final double TAX_PERCENTAGE_LEVEL_1 = 0.10;
		final double TAX_PERCENTAGE_LEVEL_2 = 0.12;
		final double TAX_PERCENTAGE_LEVEL_3 = 0.22;
		final double TAX_PERCENTAGE_LEVEL_4 = 0.24;
		final double TAX_PERCENTAGE_LEVEL_5 = 0.32;
		final double TAX_PERCENTAGE_LEVEL_6 = 0.35;
		final double TAX_PERCENTAGE_LEVEL_7 = 0.37;
		
		// Create 5 constants to register the ranges
		final double RANGE_2 = 41775 - 10275;
		final double RANGE_3 = 89075 - 41775;
		final double RANGE_4 = 170050 - 89075;
		final double RANGE_5 = 215950 - 170050;
		final double RANGE_6 = 539900 - 215950;
		
		// Create and initialize incomeTax variable to store value
		double incomeTax = 0;
		
		// The conditions below are calculating and accumulating the tax income value based on the income 
		if((income > 0) && (income <= 10275)) {
			incomeTax = (income - 10275) * TAX_PERCENTAGE_LEVEL_1;
			incomeTax = Math.ceil(incomeTax);
			return formatToCurrency(incomeTax);
		}
		
		// The conditions below are calculating and accumulating the tax income value based on the income 
		if((income > 10275) && (income <= 41775)) {
			incomeTax = 10275 * TAX_PERCENTAGE_LEVEL_1 + (income - 10275) * TAX_PERCENTAGE_LEVEL_2;
			incomeTax = Math.ceil(incomeTax);
			return formatToCurrency(incomeTax);
		}
		
		// The conditions below are calculating and accumulating the tax income value based on the income 
		if((income > 41775) && (income <= 89075)) {
			incomeTax = 10275 * TAX_PERCENTAGE_LEVEL_1 + (RANGE_2) * TAX_PERCENTAGE_LEVEL_2 + (income - 41775) * TAX_PERCENTAGE_LEVEL_3;
			incomeTax = Math.ceil(incomeTax);
			return formatToCurrency(incomeTax);

		}
		
		// The conditions below are calculating and accumulating the tax income value based on the income 
		if((income > 89075) && (income <= 170050)) {
			incomeTax = 10275 * TAX_PERCENTAGE_LEVEL_1 + (RANGE_2) * TAX_PERCENTAGE_LEVEL_2 + (RANGE_3) * TAX_PERCENTAGE_LEVEL_3 + (income - 89075) * TAX_PERCENTAGE_LEVEL_4;
			incomeTax = Math.ceil(incomeTax);
			return formatToCurrency(incomeTax);
		}
		
		// The conditions below are calculating and accumulating the tax income value based on the income 
		if((income > 170050) && (income <= 215950)) {
			incomeTax = 10275 * TAX_PERCENTAGE_LEVEL_1 + (RANGE_2) * TAX_PERCENTAGE_LEVEL_2 + (RANGE_3) * TAX_PERCENTAGE_LEVEL_3 + (RANGE_4) * TAX_PERCENTAGE_LEVEL_4 + (income - 170050) * TAX_PERCENTAGE_LEVEL_5;
			incomeTax = Math.ceil(incomeTax);
			return formatToCurrency(incomeTax);
			
		}
		
		// The conditions below are calculating and accumulating the tax income value based on the income 
		if((income > 215950) && (income <= 539900)) {
			incomeTax = 10275 * TAX_PERCENTAGE_LEVEL_1 + (RANGE_2) * TAX_PERCENTAGE_LEVEL_2 + (RANGE_3) * TAX_PERCENTAGE_LEVEL_3 + (RANGE_4) * TAX_PERCENTAGE_LEVEL_4 + (RANGE_5) * TAX_PERCENTAGE_LEVEL_5 + (income - 215950) * TAX_PERCENTAGE_LEVEL_6;
			incomeTax = Math.ceil(incomeTax);
			return formatToCurrency(incomeTax);
		}
		
		// The conditions below are calculating and accumulating the tax income value based on the income 
		if(income >  539900) {
			incomeTax = 10275 * TAX_PERCENTAGE_LEVEL_1 + (RANGE_2) * TAX_PERCENTAGE_LEVEL_2 + (RANGE_3) * TAX_PERCENTAGE_LEVEL_3 + (RANGE_4) * TAX_PERCENTAGE_LEVEL_4 + (RANGE_5) * TAX_PERCENTAGE_LEVEL_5 + (RANGE_6) * TAX_PERCENTAGE_LEVEL_6 + (income - 539900) * TAX_PERCENTAGE_LEVEL_7;
			incomeTax = Math.ceil(incomeTax);
			return formatToCurrency(incomeTax);
		}
		
		// If the income is 0, the program will return the initial value of the variable	
		else {
			return formatToCurrency(incomeTax);
		}
	}
	
	
	// Create main function
	public static void main(String[] args) {
		
		// Create income variable to store income value
		double income;
		
		// Initialize scanner/keyboard to get inputs from keyboard
		Scanner keyboard = new Scanner(System.in);
	      
		// Print request for income amount from user
		System.out.print("Please enter your income amount (enter 0 to end):");
		
		// Get value from user
		income = keyboard.nextDouble(); 
		
		// Check if value is positive
		if(income < 0) {
			// Print statement
			System.out.println("The income cannot be negative.");
		} else {
			// Print the total due calling the function that calculates it
			System.out.print("The total tax due is " + getIncomeTax(income));
		}

	}

}