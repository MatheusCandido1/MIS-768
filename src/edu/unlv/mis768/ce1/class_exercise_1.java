package edu.unlv.mis768.ce1;


import java.util.Scanner;

public class class_exercise_1 {

	public static void main(String[] args) {

		Scanner keyboard = new Scanner(System.in);
		
		double population = 0;
		int projectedGrowthRate = 0;
		int yearsToPredict = 0;
	      
		System.out.print("Please enter the current population in millions:");
		population = keyboard.nextDouble();
		

		System.out.print("Please enter the projected growth rate (%):");
		projectedGrowthRate = keyboard.nextInt();
		

		System.out.print("Please enter the number of years to predict:");
		yearsToPredict = keyboard.nextInt();
		
		
		System.out.println("\nYear          Population");
		System.out.println("=========================");
		

		double newPopulation = population;
		
		for (int year = 0; year < yearsToPredict+1; year++) {
			System.out.printf("%3d%21.2f%n", year, newPopulation);
			newPopulation = newPopulation * (1 + ( (double) projectedGrowthRate / 100));
		}
		
	}

}
