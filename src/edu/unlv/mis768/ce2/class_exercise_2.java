/*
 * Author: Matheus Candido Carvalho
 * Purpose: The purpose of this program is to store the description and the amount of 
 * items or categories that the user wants to store. After storing this information, the
 * program uses the values to calculate the total.
 * Date: 02/08/2023
 */

package edu.unlv.mis768.ce2;

// Import the Scanner and ArrayList classes
import java.util.Scanner;
import java.util.ArrayList;

// Create main class for the program
 public class class_exercise_2 {
	// Create the main method
	public static void main(String[] args) {
		// Create a Scanner object to read input
		Scanner kb = new Scanner(System.in);
		
		// Create an ArrayList to store the amounts
		ArrayList<Double> amounts = new ArrayList<Double>();
		// Create an ArrayList to store the descriptions
		ArrayList<String> descriptions = new ArrayList<String>();
		
		// Create variables to store the description and amount
		String description;
		double amount;
		// Create a variable to store the user's response
		char addMoreItens;
		// Create a variable to store the total amount
		double total = 0;
		
		// Prompt the user to enter the description and amount
		do {
		System.out.print("Please enter the item description:");
		description = kb.next();
		

		System.out.print("Please enter the the amount:");
		amount = kb.nextDouble();
		
		// Add the description and amount to the ArrayList
		descriptions.add(description);
		amounts.add(amount);
		
		// Prompt the user to enter more items
		System.out.print("Do you have more item to enter? (Y/N)");
		addMoreItens = kb.next().toUpperCase().charAt(0);
		
		// Validate the user's response and prompt the user to enter again if the response is Y
		} while (addMoreItens == 'Y');
		
		// Display the summary header
		System.out.println("=======================================");
		System.out.println("Summary:");


		// Loop through the ArrayList and display the description and amount
		for(int i = 0; i < amounts.size(); i++) {
			System.out.printf("%20s  %8.2f%n", descriptions.get(i), amounts.get(i));
			// Accumulate the total amount
			total += amounts.get(i);
		}
		// Display the total amount
		System.out.println("=======================================");
		System.out.printf("%20s  %8.2f", "Total Amount:", total);
		
	}

}
