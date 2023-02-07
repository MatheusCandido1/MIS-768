/*
 * Author: Matheus Candido Carvalho
 * Purpose: The purpose of this program is to project the city population using the current
 * population, the projected growth year and the number of years to predict. After computing
 * these information, the program will print the project population for each year.
 * Date: 02/07/2023
 */

package edu.unlv.mis768.ce1;


// Import Scanner to use Keyboard input
import java.util.Scanner;

// Create main class
public class class_exercise_1 {

	// Create main function
	public static void main(String[] args) {
		

		// Initialize scanner/keyboard to get inputs from keyboard
		Scanner keyboard = new Scanner(System.in);
		
		// Initialize variables with type and initial value 
		double population = 0;
		int projectedGrowthRate = 0;
		int yearsToPredict = 0;
	      
		// Ask the user to input the current population in millions
		System.out.print("Please enter the current population in millions:");
		population = keyboard.nextDouble();
		
		// Ask the user to input the projected growth rate
		System.out.print("Please enter the projected growth rate (%):");
		projectedGrowthRate = keyboard.nextInt();
			
		// Ask the user to input the number of years to predict
		System.out.print("Please enter the number of years to predict:");
		yearsToPredict = keyboard.nextInt();
		
		// Print the header of the program
		System.out.println("\nYear          Population");
		System.out.println("=========================");
		
		// Store the year 0 population into a new variable
		double newPopulation = population;
		
		// Loop through all years until reaching the last year of the prediction
		for (int year = 0; year < yearsToPredict+1; year++) {
			// Print the year and new population formatting the output
			System.out.printf("%3d%21.2f%n", year, newPopulation);
			// replace the value of new population variable with the amount from the previous year multiplied by the growth rate.
			newPopulation = newPopulation * (1 + ( (double) projectedGrowthRate / 100));
		}
		
	}

}
