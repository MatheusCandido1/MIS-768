package edu.unlv.mis768.ia3;


public class Package {
	private static double PRICE_PER_POUND = 3.05;
	private double weight;
	private double length;
	private double width;
	private double height;
	
	public Package() {}
	
	public Package(double weight, double length, double width, double height) {
		setWeight(weight);
		setLength(length);
		setWidth(width);
		setHeight(height);
	}
	

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight =weight;
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = Math.ceil(length);
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = Math.ceil(width);
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = Math.ceil(height);
	}
	
	public String toString() {
		return "The package's actual weight is " 
				+ this.getWeight() + " pounds and the dimensional weight is " 
					+ this.calculateDimensionalWeight() 
					+ "("+this.getLength()+"X"+this.getWidth()+"X"+this.getHeight()+")";
	}
	
	public double calculateDimensionalWeight() {
		double cubicValue = Math.ceil(length) * Math.ceil(height) * Math.ceil(width);
		double dimesionalValue = cubicValue / 166;
		return Math.ceil(dimesionalValue);
	}
	
	public double getBillableWeight() {
		return Math.max(weight, calculateDimensionalWeight());
	}
	
	public double getShippingCost() {
		return getBillableWeight() * PRICE_PER_POUND;
	}
	
}
