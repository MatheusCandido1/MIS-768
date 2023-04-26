package edu.unlv.mis768.ce6;

// Import the necessary Java libraries
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

// Define the CoffeeViewController class
public class CoffeeViewController {

	// Define the FXML instance variable for the CoffeListTableView
    @FXML
    private TableView<Coffee> coffeeListTableView;

	// Define the FXML instance variables for the expensiveCoffeesCheckBox
    @FXML
    private CheckBox expensiveCoffeesCheckBox;
	// Define the FXML instance variables for the searchTextField
    @FXML
    private TextField searchTextField;
    // Define the FXML instance variables for the searchButton
    @FXML
    private TableColumn<Coffee, String> descriptionColumn;
	// Define the FXML instance variables for the descriptionColumn
    @FXML
    private TableColumn<Coffee, Double> priceColumn;
	// Define the FXML instance variables for the priceColumn
    @FXML
    private TableColumn<Coffee, String> productNumberColumn;
    // Define the FXML instance variables for the productNumberColumn
    @FXML
    private TextArea descriptionTextArea;
   	// Define the FXML instance variables for the descriptionTextArea
    @FXML
    private TextField priceTextField;
	// Define the FXML instance variables for the priceTextField
    @FXML
    private TextField productNumberTextField;
	// Define the FXML instance variables for the productNumberTextField
    @FXML
    private Button saveButton;
	// Create decimal format for currency
    DecimalFormat currency = new DecimalFormat("0.00");
	
	// Define the initTableView method
    public void initTableView() {
		// Set the cell value factory for the productNumberColumn
    	productNumberColumn.setCellValueFactory(new PropertyValueFactory<Coffee, String>("prodNum"));
		// Set the cell value factory for the descriptionColumn
    	descriptionColumn.setCellValueFactory(new PropertyValueFactory<Coffee, String>("description"));
		// Set the cell value factory for the priceColumn
    	priceColumn.setCellValueFactory(new PropertyValueFactory<Coffee, Double>("price"));
		// Format the price column to display currency
    	priceColumn.setCellFactory(tc -> new TableCell<Coffee, Double>() {
    	    @Override
    	    protected void updateItem(Double value, boolean empty) {
    	        super.updateItem(value, empty) ;
    	        if (empty) {
    	            setText(null);
    	        } else {
    	            setText("$" + currency.format(value.doubleValue()));
    	        }
    	    }
    	});

    }
    // Define the getCoffeeList method
    public List<Coffee> getCoffeeList(boolean getExpensiveCoffees) {
		// Create a new CoffeeDAOImpl object
    	CoffeeDAOImpl coffeeDAO = new CoffeeDAOImpl();
		// Declare the List for the result data
		List<Coffee> coffeeList =  new ArrayList<Coffee>();
		// Check if the getExpensiveCoffees parameter is true
		if (getExpensiveCoffees) {
			// Get the expensive coffee list
			coffeeList = coffeeDAO.getExpensiveCoffees();
		} else {
			// Get the coffee list
			coffeeList = coffeeDAO.getAllCoffees();
		}
		// Return the coffee list
		return coffeeList;
    }
    // Define the initialize method
    public void initialize() {
		// Set the column resize policy for avoiding the horizontal scroll bar
    	coffeeListTableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		// Call the initTableView method
    	initTableView();
		// Call the filterCoffeeList method with the getExpensiveCoffees parameter set to false
    	filterCoffeeList(false);
		
    }
    // Define the filterCoffeeList method with the shouldFilter parameter which indicates if the expensive coffee list should be displayed
    public void filterCoffeeList(boolean shouldFilter) {
		// Get the coffee list from the getCoffeeList method and pass the shouldFilter parameter
    	ObservableList <Coffee> observableCoffeeList = FXCollections.observableArrayList(getCoffeeList(shouldFilter));		
    	// Display at the TableView
    	coffeeListTableView.setItems(observableCoffeeList);
    }
    // Define the expensiveCoffeesCheckBoxListener method
    public void expensiveCoffeesCheckBoxListener() {
		// Call the filterCoffeeList method with the expensiveCoffeesCheckBox value
    	filterCoffeeList(expensiveCoffeesCheckBox.isSelected());
    }
    // Define the resetFields method
    public void resetFields() {
		// Clear the productNumberTextField
    	productNumberTextField.setText("");
		// Clear the descriptionTextArea
    	descriptionTextArea.setText("");
		// Clear the priceTextField
    	priceTextField.setText("");
    }
    // Define the saveButtonListener method
    public void saveButtonListener() {
		// Get the values from the productNumberTextField, descriptionTextArea and priceTextField
    	String productNumber = productNumberTextField.getText();
    	String description = descriptionTextArea.getText();
    	String price = priceTextField.getText();
    	// Check if the productNumber, description and price are not empty
    	if(productNumber.length()  < 1 || description.length()  < 1 || price.length() < 1) {
			// Display an error message
    		Alert alert = new Alert(AlertType.WARNING);
    		alert.setTitle("Coffee");
    		alert.setContentText("All fields are required");
    		alert.show();
    		return;
    	}
    	// Create a new Coffee object		
    	Coffee coffee = new Coffee(productNumber, description, Double.parseDouble(price));
		// Create a new CoffeeDAOImpl object
    	CoffeeDAOImpl coffeeDAO = new CoffeeDAOImpl();
    	// Call the insertCoffee method from the CoffeeDAOImpl object and pass the coffee object
    	if(coffeeDAO.insertCoffee(coffee)) {
			// If the insertCoffee method returns true, display a confirmation message
    		Alert confirm = new Alert(AlertType.INFORMATION);
	    	confirm.setTitle("Coffee");
	    	confirm.setContentText("Coffee created!");

	    	confirm.show();
	    	// Get the coffee list from the getCoffeeList method and pass the expensiveCoffeesCheckBox value to refresh the list
        	filterCoffeeList(expensiveCoffeesCheckBox.isSelected());
			// Call the resetFields method
        	resetFields();
    	} else {
			// If the insertCoffee method returns false, display an error message
    		Alert confirm = new Alert(AlertType.ERROR);
	    	confirm.setTitle("Coffee");
	    	confirm.setContentText("Coffee could not be created.");

	    	confirm.showAndWait();
    	}
    	
    }

}
