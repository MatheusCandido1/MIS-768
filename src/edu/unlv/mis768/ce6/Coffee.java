package edu.unlv.mis768.ce6;

public class Coffee {
	// Fields
	String description;
	String prodNum;
	Double price;
	
	// Default constructor
	Coffee() {}
	
	// Constructor with parameters
	Coffee(String description, String prodNum, Double price) {
		super();
		this.description = description;
		this.prodNum = prodNum;
		this.price = price;
	}
	
	// Create get description function
	public String getDescription() {
		return description;
	}

	// Create set description function
	public void setDescription(String description) {
		this.description = description;
	}

	// Create get prodNum function
	public String getProdNum() {
		return prodNum;
	}

	// Create set prodNum function
	public void setProdNum(String prodNum) {
		this.prodNum = prodNum;
	}

	// Create get price function
	public Double getPrice() {
		return price;
	}

	// Create set price function
	public void setPrice(Double price) {
		this.price = price;
	}

}
