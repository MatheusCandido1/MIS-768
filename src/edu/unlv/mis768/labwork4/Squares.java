package edu.unlv.mis768.labwork4;

import java.util.Scanner;

public class Squares {

	public static void main(String[] args) {
		int number; // Loop control variable
		
		// Scanner object for keyboard input
		Scanner kb = new Scanner(System.in);
		
		// Get user input for the size of the square table
		System.out.print("Please enter an integer for printing the squares table: ");
		number = kb.nextInt();
		
		// print the table header
		System.out.println("Number   Number Squared");
		System.out.println("-----------------------");
		
		// use a loop to print from 1 to the number entered
		for(int i = 1; i <= number; i++) {
	         System.out.println(i + "\t\t" + (int)Math.pow(i, 2));
	    }
	}

}
