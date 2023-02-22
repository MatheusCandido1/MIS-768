package edu.unlv.mis768.ia3;

import java.util.ArrayList;

public class Shipment {

	private static double FREQUENT_SHIPPER_DISCOUNT_RATE = 0.05;
	
	private String frequentShipperNumber;
	private ArrayList<Package> packages = new ArrayList<Package>();
	
	public Shipment() {}
	
	public String getFrequentShipperNumber() {
		return frequentShipperNumber;
	}

	public void setFrequentShipperNumber(String frequentShipperNumber) {
		this.frequentShipperNumber = frequentShipperNumber;
	}

	
	public double getFrequentShipperDiscount() {
		if(this.frequentShipperNumber.equals("0")) {
			return 0;
		} else {
			return FREQUENT_SHIPPER_DISCOUNT_RATE * this.getSubTotal();
		}
		
	}
	
	public double getBulkDiscount() {
		if(this.getSubTotal() > 250.00) {
			return 25.00;
		} 
		return 0;
	}

	public double getTotal() {
		return this.getSubTotal() - this.getBulkDiscount() - this.getFrequentShipperDiscount();
	}

	public ArrayList<Package> getPackages() {
		return packages;
	}

	public void setPackages(Package newPackage) {
		this.packages.add(newPackage);
	}
	
	public double getSubTotal() {
		double subtotal = 0;
		for(Package pack: packages) {
			subtotal += pack.getShippingCost();
		}
		return subtotal;
	}
}
