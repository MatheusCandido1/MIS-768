/*
 * Author: Matheus Candido Carvalho
 * Purpose: The purpose of this program is to calculate the shipping cost of one or many packages.
 * Date: 03/02/2023
 */

package edu.unlv.mis768.ia3;

// Import the Scanner class
import java.util.Scanner;
// Import the DecimalFormat class
import java.text.DecimalFormat;

// Create the Main class
public class IndividualAssignment3 {
	// Create the main method
	public static void main(String[] args) {
		// Create packageNumber variable and set it to 1
		int packageNumber = 1;
		// Create morePackages variable to set it to Y or N
		char morePackages;
		// Create isPackageValid variable to set it to false
		// This variable will be used to check if the package is valid and if the packageNumber should be incremented
		boolean isPackageValid = false;

		// Create a new DecimalFormat object to format the currency
	    DecimalFormat currency = new DecimalFormat("#,##0.00");

		// Create a new Scanner object to read the user input
		Scanner kb = new Scanner(System.in);
		
		// Print the welcome message
		System.out.println("Welcome to the percel service station. Please enter the weight and the size of your packages.");

		// Create a new Shipment object
		Shipment shipment = new Shipment();
		
		// Create a do-while loop to ask the user if he has more packages to ship
		do {	
			// Create the variables to store the weight, length, width and height of the package
			double weight = 0;
			double length;
			double width;
			double height;
			
			// Print the message to ask the user to enter the data for the package
			System.out.println("==Please enter the data for package " + packageNumber + "==");

			// Ask the user to enter the weight of the package
			System.out.print("Please enter the weight of the package in pounds: ");
			weight = kb.nextDouble();

			// Create a while loop to check if the weight is greater than 0 if not, ask the user to enter again
			while(weight <= 0) {
				System.out.print("The number should be greater than 0. Please enter again: ");
				weight = kb.nextDouble();
			}
			// Create a if statement to check if the weight is less than or equal to 120
			if (weight <= 120) {
				// Ask the user to enter the length of the package
				System.out.print("Please enter the length of the package in inches: ");
				// Store the user input in the length variable
				length = kb.nextDouble();
				// Create a while loop to check if the length is greater than 0 if not, ask the user to enter again
				while(length <= 0) {
					System.out.print("The number should be greater than 0. Please enter again: ");
					length = kb.nextDouble();
				}
				
				// Ask the user to enter the width of the package
				System.out.print("Please enter the width of the package in inches: ");
				// Store the user input in the width variable
				width = kb.nextDouble();
				// Create a while loop to check if the width is greater than 0 if not, ask the user to enter again
				while(width <= 0) {
					System.out.print("The number should be greater than 0. Please enter again: ");
					width = kb.nextDouble();
				}
				// Ask the user to enter the height of the package
				System.out.print("Please enter the height of the package in inches: ");
				// Store the user input in the height variable
				height = kb.nextDouble();
				// Create a while loop to check if the height is greater than 0 if not, ask the user to enter again
				while(height <= 0) {
					System.out.print("The number should be greater than 0. Please enter again: ");
					height = kb.nextDouble();
				}
				// Create a if statement to check if the sum of the length, width and height is less than or equal to 100
				if((length + width + height) <= 100) {
					// Create a new Package object
					Package newPackage = new Package(weight, length, width, height);
					// Add the new package to the shipment
					shipment.addPackage(newPackage);
					// Print the package information
					System.out.println(newPackage);
					// Set the isPackageValid variable to true
					isPackageValid = true;
					// Print the shipping cost
					System.out.println("The shipping cost is $" + currency.format(newPackage.getShippingCost()));
					
				// If the sum of the length, width and height is greater than 100, print the message 
				} else {
					System.out.println("Cannot accept oversize package.");
				}
				// If the weight is greater than 120, print the message
			} else {
				System.out.println("Cannot accept over weight package.");
			}
			// Ask the user if he has more packages to ship
			System.out.print("Do you have more packages to ship? (Y/N)");
			// Store the user input in the morePackages variable
			morePackages = kb.next().toUpperCase().charAt(0);
			// Check if package is valid and increment the packageNumber variable
			if(isPackageValid) {
				packageNumber++;
			}
		// Create a while loop to check if the user input is Y
		} while (morePackages == 'Y');
		
		// Decrement the packageNumber variable to match the correct number of packages
		packageNumber -= 1;
		
		// Ask the user to enter his frequent-shipper number
		System.out.print("Please enter your frequent-shipper number(enter 0 if you do not have one): ");
		// Store the user input in the frequentShipperNumber variable
		shipment.setFrequentShipperNumber(kb.next());
		// Print the total number of packages
		System.out.println("Total " + packageNumber + " package(s) to ship.");
		// Print the subtotal package cost
		System.out.println("Package cost: $" + currency.format(shipment.getSubTotal()));
		// Check if the shipment has a frequent shipper discount
		if(shipment.getFrequentShipperDiscount()> 0) {
			// Print the frequent shipper discount
			System.out.println("Frequent shipper discount: -$" + currency.format(shipment.getFrequentShipperDiscount()));
		}
		// Check if the shipment has a bulk discount
		if(shipment.getBulkDiscount() > 0) {
			// Print the bulk discount
			System.out.println("Bulk discount: -$" + currency.format(shipment.getBulkDiscount()));
		}
		// Print the total cost
		System.out.println("Grad Total: $" + currency.format(shipment.getTotal()));
		
	}
}
