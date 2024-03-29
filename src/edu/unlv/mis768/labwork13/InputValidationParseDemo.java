package edu.unlv.mis768.labwork13;


import javax.swing.JOptionPane;

public class InputValidationParseDemo {

	public static void main(String[] args) {
		// declare an integer variable to be entered by the user
		int number = 0;
		
		try {
		// get the value from Input Dialog and parse the value to integer
		number = Integer.parseInt(JOptionPane.showInputDialog("Please enter a integer"));
		} catch(NumberFormatException ex) {
			JOptionPane.showMessageDialog(null, "The value entered is not an integer");
		}

		// Show the value
		JOptionPane.showMessageDialog(null, "The value entered is: "+number);
	}

}
