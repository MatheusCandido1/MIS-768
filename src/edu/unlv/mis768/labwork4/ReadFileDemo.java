package edu.unlv.mis768.labwork4;

import java.io.*;
import java.util.Scanner;

public class ReadFileDemo {

	public static void main(String[] args) throws IOException  {
		// Create a Scanner object for keyboard input.
	      Scanner keyboard = new Scanner(System.in);
	      String line;

	      // Get the file name.
	      System.out.print("Enter the name of a file: ");
	      String fileName = keyboard.nextLine();

	      // Open the file.
	      File file = new File(fileName);
	      Scanner inputFile = new Scanner(file);

	      System.out.println("The names in the file are:");
	      
	      while (inputFile.hasNext()) {
		      // Read the first line from the file.
		      line = inputFile.nextLine();
		      // Display the line.
		      System.out.println(line);
	    	  
	      }
	      
	      // Close the file.
	      inputFile.close();
	}
}
