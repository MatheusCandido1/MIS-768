package edu.unlv.mis768.ia3;

import java.util.Scanner;

import java.text.DecimalFormat;

public class individual_assignment_3 {

	public static void main(String[] args) {
		int packageNumber = 1;
		char morePackages;
		boolean isPackageValid = false;

	    DecimalFormat currency = new DecimalFormat("#,##0.00");

		Scanner kb = new Scanner(System.in);
		
		System.out.println("Welcome to the percel service station. Please enter the weight and the size of your packages.");

		Shipment shipment = new Shipment();
		
		do {	
			double weight = 0;
			double length;
			double width;
			double height;
			
			
			System.out.println("==Please enter the data for package " + packageNumber + "==");

			System.out.print("Please enter the weight of the package in pounds: ");
			weight = kb.nextDouble();

			while(weight <= 0) {
				System.out.print("The number should be greater than 0. Please enter again: ");
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
					System.out.println(newPackage);
					isPackageValid = true;
					System.out.println("The shipping cost is $" + currency.format(newPackage.getShippingCost()));
					
					
				} else {
					System.out.println("Cannot accept oversize package.");
				}
				
			} else {
				System.out.println("Cannot accept over weight package.");
			}
			
			System.out.print("Do you have more packages to ship?");
			morePackages = kb.next().toUpperCase().charAt(0);
			if(isPackageValid) {
				packageNumber++;
			}
			
		} while (morePackages == 'Y');
		
		packageNumber -= 1;
		
		System.out.println("Please enter your frequent-shipper number(enter 0 if you do not have one)");
		shipment.setFrequentShipperNumber(kb.next());
		
		System.out.println("Total " + packageNumber + " package(s) to ship.");
		System.out.println("Package cost: $" + currency.format(shipment.getSubTotal()));
		if(shipment.getFrequentShipperDiscount()> 0) {
			System.out.println("Frequent shipper discount: -$" + currency.format(shipment.getFrequentShipperDiscount()));
		}
		if(shipment.getBulkDiscount() > 0) {
			System.out.println("Bulk discount: -$" + currency.format(shipment.getBulkDiscount()));
		}
		System.out.println("Grad Total: $" + currency.format(shipment.getTotal()));
		
	}
	

}
 