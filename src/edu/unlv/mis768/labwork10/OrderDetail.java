package edu.unlv.mis768.labwork10;

public class OrderDetail {

	private int quantity;
	private Product item;
	

	public OrderDetail() {}
	
	public OrderDetail(int quantity, Product item) {
		this.quantity = quantity;
		this.item = item;
	}


	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Product getItem() {
		return item;
	}

	public void setItem(Product item) {
		this.item = item;
	}
	
	public double calcTax() {
		if(item.getType().equalsIgnoreCase("food"))
			return 0;
		else
			return this.getSubTotal() * 0.06;
	}
	
	public double getSubTotal() {
		return item.getUnitPrice() * quantity;
	}

}
