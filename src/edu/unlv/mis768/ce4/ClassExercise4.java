/*
 * Author: Matheus Candido Carvalho
 * Purpose: The purpose of this program is to calculate the salary of managers and staffs
 * Date: 03/02/2023
 */

package edu.unlv.mis768.ce4;

// Create Main class
public class ClassExercise4 {
	// Create main method
	public static void main(String[] args) {
		
		// Create an object of the Manager class
		Manager manager1 = new Manager();
		// Set the manager name
		manager1.setName("Matheus Manager");
		// Set the manager pay rate
		manager1.setPayRate(45.00);
		// Set the manager hours
		manager1.setHours(40);
		// Set the manager level
		manager1.setLevel(2);
		
		// Print the manager information
		System.out.println(manager1);
		// Print a separator
		System.out.println("======================");
		
		// Create an object of the Staff class
		Staff staff1 = new Staff();
		// Set the staff name
		staff1.setName("Matheus Staff");
		// Set the staff pay rate
		staff1.setPayRate(45.00);
		// Set the staff hours
		staff1.setHours(40);
		// Set the staff level
		System.out.println(staff1);
		

	}

}
