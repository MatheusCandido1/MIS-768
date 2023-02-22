package edu.unlv.mis768.labwork10;

public class Stock {
	//field
	private String symbol;
	private double sharePrice;
	
	//Constructor
	public Stock(String sym, double price){
		symbol = sym;
		sharePrice = price;
	}

	//getters and setters
	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public double getSharePrice() {
		return sharePrice;
	}

	public void setSharePrice(double sharePrice) {
		this.sharePrice = sharePrice;
	}
	
	// copy method
	public Stock copy() {
		// instantiate a new Stock Object
		Stock newObj = new Stock(this.symbol, this.sharePrice);
		return newObj;
	}
	
	// toString method
	public String toString() {
		return "The symbol is "+symbol+", and the price is $"+this.sharePrice;
	}
	
	// overwrite the equals method
	public boolean equals(Stock s2) {
		if(this.symbol.equals(s2.symbol) && this.sharePrice == s2.sharePrice)
			return true;
		else
			return false;
	}

}
