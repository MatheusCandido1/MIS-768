package edu.unlv.mis768.labwork13;

public class NegativeAmount extends Exception {
	public NegativeAmount() {
		super("Error: The amount is negative");
	}
}
