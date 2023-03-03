/*
 * Author: Matheus Candido Carvalho
 * Purpose: The purpose of this program is to create a class named Shipment that will be used in the Main class. This class
 * will have private fields for the frequent shipper number and a list of the packages. It will also have a constructor, get and set
 * methods for the attributes and methods to calculate the subtotal, bulk discount, frequent shipper discount and total.
 * Date: 03/02/2023
 */
 package edu.unlv.mis768.ia3;
// Importing the ArrayList class
import java.util.ArrayList;
// Creating the Shipment class
public class Shipment {
	// Declaring the constant for the frequent shipper discount rate
	private static double FREQUENT_SHIPPER_DISCOUNT_RATE = 0.05;
	// Declaring the private fields
	private String frequentShipperNumber;
	private ArrayList<Package> packages = new ArrayList<Package>();

	// Creating the constructor
	public Shipment() {}
	
	// Create the get method for the frequent shipper number
	public String getFrequentShipperNumber() {
		return frequentShipperNumber;
	}
	// Create the set method for the frequent shipper number
	public void setFrequentShipperNumber(String frequentShipperNumber) {
		this.frequentShipperNumber = frequentShipperNumber;
	}


	/**
	 * This method checks if the user is a frequent shipper
	 * and applies the discount if the conditions are matched
	 * @return Frequent Shipper Discount
	 */
	public double getFrequentShipperDiscount() {
		// If the frequent shipper number is 0, then the discount is 0
		if(this.frequentShipperNumber.equals("0")) {
			return 0;
		} else {
			// If the frequent shipper number is not 0, then the discount is 5% of the subtotal
			return FREQUENT_SHIPPER_DISCOUNT_RATE * this.getSubTotal();
		}
		
	}

	/**
	 * This method checks if the bulk discount
	 * should be applied for this shipment
	 * by checking the subtotal value 
	 * @return Bulk Discount
	 */
	public double getBulkDiscount() {
		// If the subtotal is greater than 250, then the discount is 25
		if(this.getSubTotal() > 250.00) {
			return 25.00;
		} 
		// if this is not the case, then the discount is 0
		return 0;
	}


	/**
	 * This method calculates the total
	 * including the possible discounts
	 * @return Total cost of the shipment
	 */
	public double getTotal() {
		// The total is the subtotal minus the bulk discount minus the frequent shipper discount
		return this.getSubTotal() - this.getBulkDiscount() - this.getFrequentShipperDiscount();
	}
	// Create the get method to get the packages
	public ArrayList<Package> getPackages() {
		return packages;
	}
	// Create the set method to set the packages
	public void addPackage(Package newPackage) {
		this.packages.add(newPackage);
	}

	/**
	 * This method calculates the subtotal
	 * looping through the list of packages
	 * included in the shipment and
	 * accumulating the values
	 * @return Subtotal Cost of the shipment
	 */
	public double getSubTotal() {
		// The subtotal is the sum of the shipping cost of each package
		double subtotal = 0;
		for(Package pack: packages) {
			subtotal += pack.getShippingCost();
		}
		// Return the subtotal
		return subtotal;
	}
}

