/*
 * Author: Matheus Candido Carvalho
 * Purpose: The porpuse of this program is to calculate the scores of two tests based on the number of questions and misses and compare them.
 * Date: 02/16/2023
 */
package edu.unlv.mis768.ce3;

// Import the Scanner class
import java.util.Scanner;

// Create the main class
public class class_exercise_3 {

	// Create the main function
	public static void main(String[] args) {
		// Create the Scanner object
		Scanner kb = new Scanner(System.in);
		
		// Create the variables to store user input
		int numQuestions;
		int numMissed;

		// Print the message to the user
		System.out.print("Please enter the number of questions for the first test: ");

		// Store the user input in the variable
		numQuestions = kb.nextInt();
		// Create the first test object
		Test test1 = new Test(numQuestions);
		// Print the message to the user
		System.out.print("Please enter the number of quesitons missed for the first test: ");
		// Store the user input in the variable
		numMissed = kb.nextInt();
		
		// Set the number of missed questions for the first test
		test1.setNumMissed(numMissed);
		
		// Print the first test object
		System.out.println(test1);
		// Print the message to the user
		System.out.print("Please enter the number of questions for the second test: ");
		// Store the user input in the variable
		numQuestions = kb.nextInt();
		// Create the second test object
		Test test2 = new Test(numQuestions);
		// Print the message to the user
		System.out.print("Please enter the number of quesitons missed for the second test: ");

		// Store the user input in the variable
		numMissed = kb.nextInt();
		
		// Set the number of missed questions for the second test
		test2.setNumMissed(numMissed);
		
		// Print the second test object
		System.out.println(test2);
		
		// Compare the scores of the tests
		if(test1.equals(test2))
			// If the scores are the same, print the message to the user
			System.out.print("The scores of the tests are the same");
		else
			// If the scores are not the same, print the message to the user
			System.out.print("The scores of the tests are not the same");
		
	}

}
