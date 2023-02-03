package edu.unlv.mis768.labwork3;

import java.util.Scanner;

public class GradePointCalculatorWithSwitch{
	
	public static void print(String text) {
		System.out.println(text);
	}
	
	public static void main(String[] args) {
		char grade;       // A character entered by the user
		          
		      // Create a Scanner object for keyboard input.
		Scanner keyboard = new Scanner(System.in);
		      
		      // Get one of the numbers 1, 2, or 3 from the user.
		System.out.print("Enter A, B, or C: ");
		      // there is no nextChar() method
		      // we need to use next().charAt(0). 
		      // next() returns the next word in the input as a string 
		      // and charAt(0) function returns the first character in that string.
		grade = keyboard.next().toUpperCase().charAt(0); 

		      // Determine the grade point entered.
		switch (grade) {
		 	case 'A':
				  print("4.0");
				  break;
		 	case 'B': 
				 print("3.0");
				 break;
		 	case 'C': 
				 print("2.0");
				 break;
		 	default:
		      	print("0.0");
		      	break;
		}
	}

}
