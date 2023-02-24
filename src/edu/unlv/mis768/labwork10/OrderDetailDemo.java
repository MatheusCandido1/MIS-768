package edu.unlv.mis768.labwork10;

import javax.swing.JOptionPane;

public class OrderDetailDemo {

	public static void main(String[] args) {
		String productName = JOptionPane.showInputDialog("Please enter the product name: ");
		String productType = JOptionPane.showInputDialog("Please enter the product type: ");
		double price = Double.parseDouble((JOptionPane.showInputDialog("Please enter the product price: ")));
		
		Product item = new Product(productName, productType, price);
		
		int quan = Integer.parseInt(JOptionPane.showInputDialog("Please enter the quantity: "));
		
		OrderDetail line = new OrderDetail(quan, item);
		
		JOptionPane.showConfirmDialog(null, "The tax is: " + line.calcTax());
		JOptionPane.showConfirmDialog(null, "The subtotal is: " + line.getSubTotal());
		
	}

}
