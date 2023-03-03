/*
 * Author: Matheus Candido Carvalho
 * Purpose: The purpose of this program is to create a class named Package that will be used in the Main class. This class
 * will have private fields for the weight, length, width, height. It will also have a constructor, get and set
 * methods for the attributes and methods to calculate the dimensional weight, billable weight and shipping cost.
 * Date: 03/02/2023
 */
package edu.unlv.mis768.ia3;
// Create the Package class
public class Package {
	// Create constant for the price per pound
	private static double PRICE_PER_POUND = 3.05;
	// Create the private fields
	private double weight;
	private double length;
	private double width;
	private double height;
	
	// Create the constructor
	public Package() {}
	

	/**
	 * This method creates the parametrized constructor
	 * and sets all values for the attributes of the class
	 * @return
	 */
	public Package(double weight, double length, double width, double height) {
		setWeight(weight);
		setLength(length);
		setWidth(width);
		setHeight(height);
	}
	
	// Create the get method for weight
	public double getWeight() {
		return weight;
	}
	// Create the set method for the weight
	public void setWeight(double weight) {
		this.weight =weight;
	}
	// Create the get method for the length
	public double getLength() {
		return length;
	}
	// Create the set method for the length
	public void setLength(double length) {
		// Round up the value to nearest whole number
		this.length = Math.ceil(length);
	}
	// Create the get method for the width
	public double getWidth() {
		return width;
	}
	// Create the set method for the width
	public void setWidth(double width) {
		// Round up the value to nearest whole number
		this.width = Math.ceil(width);
	}
	// Create the get method for the height
	public double getHeight() {
		return height;
	}
	// Create the set method for the height
	public void setHeight(double height) {
		// Round up the value to nearest whole number
		this.height = Math.ceil(height);
	}
	// Create the toString method
	public String toString() {
		return "The package's actual weight is " 
				+ this.getWeight() + " pounds and the dimensional weight is " 
					+ this.calculateDimensionalWeight() 
					+ "("+this.getLength()+"X"+this.getWidth()+"X"+this.getHeight()+").";
	}
	/**
	 * This method calculates the dimensional weight
	 * of the package using its dimensions
	 * @return dimensional weight of the package
	 */
	public double calculateDimensionalWeight() {
		// Return the cubic value divided by 166
		double cubicValue = Math.ceil(length) * Math.ceil(height) * Math.ceil(width);
		double dimensionalValue = cubicValue / 166;
		return Math.ceil(dimensionalValue);
	}

	/**
	 * This method get the highest of the two dimensions
	 * and set it as the billable weight
	 * @return Billable Weight of the Package
	 */
	public double getBillableWeight() {
		// If the weight is greater than the dimensional weight, return the weight
		return Math.max(weight, calculateDimensionalWeight());
	}

	/**
	 * This method calculates the
	 * shipping cost of the package by multiplying the 
	 * price per pound and the billable weight
	 * @return Shipping Cost
	 */
	public double getShippingCost() {
		// Return the billable weight multiplied by the price per pound
		return getBillableWeight() * PRICE_PER_POUND;
	}
	
}
