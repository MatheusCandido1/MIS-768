package edu.unlv.mis768.ia3;

import java.util.Scanner;

public class individual_assignment_3 {

	public static void main(String[] args) {
		int packageNumber = 1;
		char morePackages;

		Scanner kb = new Scanner(System.in);
		
		System.out.println("Welcome to the percel service station. Please enter the weight and the size of your packages.");
		
		do {	
			double weight = 0;
			double length;
			double width;
			double height;
			
			Shipment shipment = new Shipment();
			
			System.out.println("==Please enter the data for package " + packageNumber + "==");

			System.out.print("Please enter the weight of the package in pounds: ");
			weight = kb.nextDouble();

			while(weight <= 0) {
				SSystem.out.print("The number should be greater than 0. Please enter again: ");
				weight = kb.nextDouble();
			}
			
			if (weight <= 120) {

				System.out.print("Please enter the length of the package in inches: ");
				
				length = kb.nextDouble();

				while(length <= 0) {
					System.out.print("The number should be greater than 0. Please enter again: ");
					length = kb.nextDouble();
				}
				
				
				System.out.print("Please enter the width of the package in inches: ");
				
				width = kb.nextDouble();

				while(width <= 0) {
					System.out.print("The number should be greater than 0. Please enter again: ");
					width = kb.nextDouble();
				}
				
				System.out.print("Please enter the height of the package in inches: ");
				
				height = kb.nextDouble();

				while(height <= 0) {
					System.out.print("The number should be greater than 0. Please enter again: ");
					height = kb.nextDouble();
				}
				
				if((length + width + height) <= 100) {
					Package newPackage = new Package(weight, length, width, height);
					shipment.setPackages(newPackage);
					System.out.printnewPackage.toString();
					
					
				} else {
					System.out.println("Cannot accept oversize package.");
				}
				
			} else {
				System.out.println("Cannot accept over weight package.");
			}
			
			System.out.print("Do you have more packages to ship?");
			morePackages = kb.next().toUpperCase().charAt(0);
			packageNumber++;
			
		} while (morePackages == 'Y');
		
		packageNumber -= 1;
		
		System.out.println("Please enter your frequent-shipper number(enter 0 if you do not have one)");
		System.out.println("Total " + packageNumber + " package(s) to ship.");
		
		
		
	}
	
	public static void print(String text) {
		System.out.println(text);
	}

}
 