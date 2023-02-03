package edu.unlv.mis768.labwork4;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class WriteFileDemo {

	public static void main(String[] args) throws FileNotFoundException {
		// declare variables
		String fileName; // name of the file to store the data
		String friendName; // name of a friend to be written to the file
		int numOfFriends;  // number of friends to be entered by the user
		
		// Scanner object for keyboard input
		Scanner kb = new Scanner(System.in);
		
		// get user input for number of friend
		System.out.print("How many friends do you have?");
		numOfFriends = kb.nextInt();
		
		// Consume the remaining newline character
		kb.nextLine();
		
	
		// get the filename
		System.out.print("Please enter the file name where you would like to store the data: ");
		fileName = kb.nextLine();
		
		PrintWriter outputFile = new PrintWriter(fileName);
		for(int i = 0; i < numOfFriends; i++) {
			System.out.println("Please enter the name of friend " + (i+1));
			friendName = kb.nextLine();
			
			outputFile.println(friendName);
		}
		
		outputFile.close();
		
		System.out.println("File has been saved");
		
	}

}
