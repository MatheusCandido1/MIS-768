package edu.unlv.mis768.ce2;

import java.util.Scanner;
import java.util.ArrayList;

 public class class_exercise_2 {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		
		ArrayList<Double> amounts = new ArrayList<Double>();
		ArrayList<String> descriptions = new ArrayList<String>();
		
		String description;
		double amount;
		char addMoreItens;
		double total = 0;
		
		do {
		System.out.println("Please enter the item description:");
		description = kb.next();
		

		System.out.println("Please enter the the amount:");
		amount = kb.nextDouble();
		
		descriptions.add(description);
		amounts.add(amount);
		

		System.out.println("Do you have more item to enter? (Y/N)");
		addMoreItens = kb.next().toUpperCase().charAt(0);
		
		
		} while (addMoreItens == 'Y');
		
		System.out.println("=======================================");
		System.out.println("Summary:");
		
		for(int i = 0; i < amounts.size(); i++) {
			System.out.printf("%20s ", descriptions.get(i));
			System.out.printf(" %.2f", amounts.get(i));
			System.out.println();
			total += amounts.get(i);
		}
		System.out.println("\n=======================================");
		System.out.printf("Total Amount: %.2f", total);
		
	}

}
