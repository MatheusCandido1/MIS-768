package edu.unlv.mis768.labwork16;

import java.util.ArrayList;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.TreeTableColumn.CellEditEvent;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.*;


public class PayrollManagementController {

	// add the FXML controls of Table view and TableColumn here
	

    @FXML
    private TableColumn<Payroll, String> employeeNameColumn;

    @FXML
    private TextField hoursTextField;

    @FXML
    private TextField nameTextField;

    @FXML
    private TableColumn<Payroll, Integer> numberOfHoursColumn;

    @FXML
    private TableColumn<Payroll, Double> payRateColumn;

    @FXML
    private TextField rateTextField;

    @FXML
    private TextArea summaryTextArea;

    @FXML
    private TableView<Payroll> tableView;

    @FXML
    private Label totalLabel;

	
    /** 
     * For setting up initial values 
     */
	public void initialize() {
		// set up the columns in the table
		employeeNameColumn.setCellValueFactory(new PropertyValueFactory<Payroll, String>("empName"));
		payRateColumn.setCellValueFactory(new PropertyValueFactory<Payroll, Double>("payRate"));
		numberOfHoursColumn.setCellValueFactory(new PropertyValueFactory<Payroll, Integer>("numOfHours"));

			
	}

	/**
	 * Listener for addButton. It instantiate Payroll and set the filed values.
	 * Add the object to the TableView
	 */
	public void addButtonListener() {
		// create a Payroll object
		Payroll payroll = new Payroll();
		
		// set the values
		payroll.setEmpName(this.nameTextField.getText());
		payroll.setPayRate(this.rateTextField.getText());
		payroll.setNumOfHours(this.hoursTextField.getText());
		
		// get all the items from the table as a list, then add the new object to it
		// add it to the table
		tableView.getItems().add(payroll);
	}
	
	/**
	 * Listener of the deleteButton. Remove a selected object from the TableView
	 */
	public void deleteButtonListener() {
		// get the index of the item selected in the TableView
		int selectedRow = tableView.getSelectionModel().getSelectedIndex();
		
		// remove the row
		tableView.getItems().remove(selectedRow);
	}
	
	/**
	 * Listener for generateButton. Print the Payroll objects in the TextArea
	 * Also add the wages to total
	 */
	public void generateButtonListener() {
		// The string to show the content of each Payroll object
		String str="";
		// variable for the total pay		
		double total =0;
		
		// a loop to traverse the loop
		// each row is an Payroll object
		for(Payroll record: tableView.getItems()) {
			
			str += record.toString();
			total += record.calWage();
			System.out.println(total);
		}
		/* The following loop is the same as the above loop
	    for(int i =0;i<=tableView.getItems().size();i++) {
		// use the toString() method to display the content of the object
		str+= tableView.getItems().get(i).toString();
		// use the calWage() method to get the pay
		total+=tableView.getItems().get(i).calWage();
		}
		*/
		// display in the text area
		summaryTextArea.setText(str);
		// display the total in the label
		totalLabel.setText("Total payment: $"+total);
	}

}

