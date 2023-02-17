package edu.unlv.mis768.ia3;

import java.util.Scanner;

public class individual_assignment_3 {

	public static void main(String[] args) {
		int packageNumber = 1;
		char morePackages;

		Scanner kb = new Scanner(System.in);
		
		System.out.println("Welcome to the percel service station. Please enter the weight and the size of your packages.");
		
		do {	
			System.out.println("==Please enter the data for package " + packageNumber + "==");
			
			System.out.println("Please enter the weight of the package in pounds: ");
			System.out.println("Please enter the length of the package in inches: ");
			System.out.println("Please enter the width of the package in inches: ");
			System.out.println("Please enter the height of the package in inches: ");
			
			System.out.println("Do you have more packages to ship?");
			morePackages = kb.next().toUpperCase().charAt(0);
			packageNumber++;
			
		} while (morePackages == 'Y');
		
		packageNumber -= 1;
		
		System.out.println("Please enter your frequent-shipper number(enter 0 if you do not have one)");
		System.out.println("Total " + packageNumber + " package(s) to ship.");
		
		
		
	}

}
 