package edu.unlv.mis768.labwork13;

import java.util.Scanner;

public class BankAccountDemo {

	public static void main(String[] args) {
		// Scanner object for keyboard input
		Scanner kb = new Scanner(System.in);
		
		System.out.println("Please enter the starting balance of the account:");
		double balance = kb.nextDouble();
		

		try {
			BankAccount account = new BankAccount(balance);
		} catch (NegativeStartingBalance e) {
			System.out.println(e.getMessage());
		}


	}

}
