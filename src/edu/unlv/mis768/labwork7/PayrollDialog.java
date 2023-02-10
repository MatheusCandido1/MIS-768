package edu.unlv.mis768.labwork7;

import javax.swing.JOptionPane;

public class PayrollDialog {

	public static void main(String[] args) {
		// declare variables
		String inputString; // for reading input
		String empName; // the employee's name
		int hours; // the employee's working hours
		double grossPay; // the grossPay to be calculated
		
		// get the name using a input box
		empName = JOptionPane.showInputDialog("Please enter employee's name:");
		
		
		// get the hours using a input box
		hours = Integer.parseInt(JOptionPane.showInputDialog("Hours worked?"));

		
		// declare an Employee object
		Employee someone = new Employee();
		someone.setName(empName);
		
		// Show the result in a message box
		grossPay = someone.calcSalary(hours);
		JOptionPane.showMessageDialog(null, grossPay);
		
		System.exit(0);
	}

}
