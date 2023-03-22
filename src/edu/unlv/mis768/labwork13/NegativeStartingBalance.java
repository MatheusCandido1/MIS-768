package edu.unlv.mis768.labwork13;

public class NegativeStartingBalance extends Exception {
	/*
	 * @param amount
	 */
	public NegativeStartingBalance(double amount) {
		super("Error: Negative Starting Balance : $"+amount);
	}
}
