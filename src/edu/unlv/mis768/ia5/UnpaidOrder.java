package edu.unlv.mis768.ia5;

// Define the UnpaidOrder class
public class UnpaidOrder {
	// Define the attributes of the UnpaidOrder class
	String prodNum;
	String customerNumber;
	String orderDate;
	int quantity;
	double price;
	// Define the no-arg constructor of the UnpaidOrder class
	public UnpaidOrder() {
	}
	// Define the constructor of the UnpaidOrder class
	public UnpaidOrder(String prodNum, String customerNumber, String orderDate, int quantity, double price) {
		this.prodNum = prodNum;
		this.customerNumber = customerNumber;
		this.orderDate = orderDate;
		this.quantity = quantity;
		this.price = price;
	}
	// Define the getter and setter methods of the UnpaidOrder class
	public String getProdNum() {
		return prodNum;
	}
	public void setProdNum(String prodNum) {
		this.prodNum = prodNum;
	}
	public String getCustomerNumber() {
		return customerNumber;
	}
	public void setCustomerNumber(String customerNumber) {
		this.customerNumber = customerNumber;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
}
