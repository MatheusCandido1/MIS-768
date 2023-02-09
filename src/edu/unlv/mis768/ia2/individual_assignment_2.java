/*
 * Author: Matheus Candido Carvalho
 * Purpose: The purpose of this program is to record and calculate the GPA given the 
 * information provided by user. The program also gives the user the option to
 * export the grades and results to a txt file.
 * Date: 02/08/2023
 */

package edu.unlv.mis768.ia2;

// Importing the necessary libraries
import java.util.ArrayList;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.text.DecimalFormat;

// Create main class
public class individual_assignment_2 {

	// Instantiating the decimal format object globally to be used in the whole program
    static DecimalFormat df = new DecimalFormat("0.00");

	// Create main method
	public static void main(String[] args) throws IOException {
		// Instantiating the Scanner object to read user input
		Scanner kb = new Scanner(System.in);
		
		// Create a variable to store the user input and a counter to keep track of the number of courses
		char insertCourse;
		int counter = 1;
		// Print the welcome message
		System.out.println("This program prints the transcript and calculates the GPA, based on the courses entered");
		System.out.println("Please enter the courses below.");
		
		// Create an ArrayList of the Class Course to store the courses 
		ArrayList<Course> courses = new ArrayList<Course>();
		// Create a do-while loop to ask the user if he wants to insert more courses
		do {
			// Create a new object of the Class Course
			Course course = new Course();
			
			// Ask the user to enter the course number
			System.out.print("Number of course " + counter +  ":");
			course.setNumber(kb.next().toUpperCase());
			
			// Ask the user to enter the credit hours of the course
			System.out.print("Credit Hours of course " + counter +  ":");
			course.setCredits(kb.nextInt());
			
			// Ask the user to enter the letter grade of the course
			System.out.print("Letter grade of course " + counter +  ":");
			course.setGrade(kb.next().toUpperCase());
			
			// Add the course to the ArrayList
			courses.add(course);
			
			// Ask the user if he wants to insert more courses
			System.out.println("More courses? (Y/N)");
			// Store the user input in the variable insertCourse
			insertCourse = kb.next().toUpperCase().charAt(0);
			// Increment the counter
			counter++;
		// Repeat the loop while the user wants to insert more courses
		} while(insertCourse == 'Y');
		
		// Createq a variable to store the GPA and call the method to calculate the GPA
		double gpa = calculateGPA(courses);
		
		// Print the GPA
		System.out.println("The GPA is " + df.format(gpa));
		
		// Create a variable to store the user input and ask the user if he wants to save the results to a file
		char saveInFile;
		
		// Ask the user if he wants to save the results to a file
		System.out.print("Would you like to save the result to a file (Y/N)");
		
		// Store the user input in the variable saveInFile
		saveInFile = kb.next().toUpperCase().charAt(0);
		
		// If the user wants to save the results to a file, call the method to generate the file
		if(saveInFile == 'Y') {
			// Create a variable to store the file name
			String fileName;
			// Ask the user to enter the file name
			System.out.print("Please enter the file name for the transcript:");
			// Store the user input in the variable fileName
			fileName = kb.next();
			// Call the method to generate the file
			generateFileWithRecords(courses, fileName, gpa);
		}
	}
	// Create a method to generate the file with the results
	private static void generateFileWithRecords(ArrayList<Course> courses, String fileName, double gpa) throws IOException  {
		// Create a PrintWriter object to write to the file
		PrintWriter outputFile = new PrintWriter(fileName);
		
		// Print the header of the file
		outputFile.println("COURSE\t\tCREDIT\t\tGRADE\t\tGRADE POINT");
		
		// Loop through the ArrayList and print the information of each course
		courses.forEach((course) -> outputFile.println(course.getNumber()+"\t\t\t"+course.getCredits()+"\t\t\t"+course.getGrade()+"\t\t\t"+df.format(course.getPoints())));
		// Print the footer of the file
		outputFile.println("=========================");
		// Print the GPA
		outputFile.println("GPA: " + df.format(gpa));
		// Close the file
		outputFile.close();
		
	}
	
	// Create a method to calculate the GPA
	private static double calculateGPA(ArrayList<Course> courses) {
		// Create a variable to store the sum of the points times the credits
		double sumOfPointsTimesCredits = 0.00;
		
		// Create a variable to store the total credit hours
		int totalCreditHours = 0;
		
		// Loop through the ArrayList and calculate the sum of the points times the credits and the total credit hours
		for(int i = 0; i < courses.size(); i++) {
			// Check if the course has credit hours
			if(courses.get(i).getCredits() > 0) {
				// Add the credit hours to the total credit hours
				totalCreditHours += courses.get(i).getCredits();
				// Add the points times the credits to the sum of the points times the credits
				sumOfPointsTimesCredits += courses.get(i).getPoints() * courses.get(i).getCredits();
			} 
		}
		// Check if the total credit hours is 0, if it is, return 0.00
		if(totalCreditHours == 0) return 0.00;
		
		// Calculate the GPA
		double gpa = sumOfPointsTimesCredits / totalCreditHours;

		// Return the GPA
		return gpa;
	}

}
