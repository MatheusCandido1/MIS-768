package edu.unlv.mis768.ia5;

// Importing libraries
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

// Define Controller class
public class IndividualAssingment5Controller {
	// Define FXML components
	@FXML
    private Label customerNumberErrorLabel;

    @FXML
    private TextField customerNumberTextField;

    @FXML
    private Label productNumberErrorLabel;

    @FXML
    private TextField productNumberTextField;

    @FXML
    private TextField quantityTextField;

    @FXML
    private Label resetButton;

    @FXML
    private Button saveButton;
    
	// Define formatter for currency
    private static final DecimalFormat df = new DecimalFormat("0.00");
    
	// Define initialize method
    public void initialize() {
		// Call setLayout method
    	setLayout();
    }
    
	// Define today method
    public String today() {
		// Define today variable as LocalDateTime now
		LocalDateTime today = LocalDateTime.now();
		// Define formatter as YYYY-MM-dd
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYY-MM-dd"); 
		// Return today formatted as formatter
        return today.format(formatter);
    }
    // Define saveButtonListener method
    public void saveButtonListener() {
		// Define currentCustomer from getCustomerById method
    	Customer currentCustomer = getCustomerById();
		// Define currentCoffee from getCoffeeById method
    	Coffee currentCoffee = getCoffeeById();
		// Check If currentCustomer is null
    	if (currentCustomer == null) {
			// Set customerNumberErrorLabel to visible
    	    customerNumberErrorLabel.setVisible(true);
			// Set the border of customerNumberTextField to red
    	    customerNumberTextField.setStyle("-fx-text-box-border: #FE4E4E; -fx-focus-color: #FE4E4E;");
    	}
		// Check if currentCoffee is null
    	if (currentCoffee == null) {
			// Set productNumberErrorLabel to visible
    	    productNumberErrorLabel.setVisible(true);
			// Set the border of productNumberTextField to red
    	    productNumberTextField.setStyle("-fx-text-box-border: #FE4E4E; -fx-focus-color: #FE4E4E;");
    	}
		// Check if currentCustomer and currentCoffee are not null
    	if ((currentCustomer != null) && (currentCoffee != null)) {
			// Define quantity variable
    		int quantity;
			// Try to parse quantityTextField to integer
    		try {
				// Set quantity to the parsed value
    			quantity = Integer.parseInt(quantityTextField.getText()); 
    		} catch(NumberFormatException ex) {
				// Set quantity to 0
    			quantity = 0;
    		}
			// Define today variable as today()
            String today = today();
			// Define price variable as quantity * currentCoffee.getPrice()
            double price = quantity * currentCoffee.getPrice();
            // Define unpaidOrder as new UnpaidOrder
            UnpaidOrder unpaidOrder = new UnpaidOrder();
			// Set unpaidOrder attributes
            unpaidOrder.setCustomerNumber(customerNumberTextField.getText());
            unpaidOrder.setProdNum(productNumberTextField.getText());
            unpaidOrder.setOrderDate(today);
            unpaidOrder.setQuantity(quantity);
            unpaidOrder.setPrice(Double.parseDouble(df.format(price)));
            
			// Define unpaidOrderDAOImpl as new UnpaidOrderDAOImpl
		    UnpaidOrderDAOImpl unpaidOrderDAOImpl = new UnpaidOrderDAOImpl();
			// Check if insertUnpaidOrder returns true
		    if(unpaidOrderDAOImpl.insertUpaidOrder(unpaidOrder)) {
				// Define confirm as new Alert
		    	Alert confirm = new Alert(AlertType.INFORMATION);
				// Set confirm attributes
			    confirm.setTitle("Order");
			    confirm.setContentText("Order created!");
				// Show confirm
			    confirm.show();
				// Call clearFields method
				clearFields();
		    } else {
				// Define confirm as new Alert
		    	Alert confirm = new Alert(AlertType.ERROR);
				// Set confirm attributes
		    	confirm.setTitle("Order");
		    	confirm.setContentText("Order could not be created.");
				// Show confirm
		    	confirm.showAndWait();
		    }
    	}
    	
    	
    }
    // Define resetButtonListener method
    public void resetButtonListener() {
		// Call cleafFields method
    	clearFields();
    }
    // Define clearFields method
    public void clearFields() {
		// Set customerNumberTextField, productNumberTextField and quantityTextField to empty
    	customerNumberTextField.setText("");
    	productNumberTextField.setText("");
    	quantityTextField.setText("");
		// Call resetFields method
    	resetFields();

    }
    // Define resetFields method
    public void resetFields() {
		// Call resetCustomerComponents and resetProductComponents methods
    	resetCustomerComponents();
    	resetProductComponents();
    }
    // Define resetCustomerComponents method
    public void resetCustomerComponents() {
		// Set customerNumberErrorLabel to invisible
    	customerNumberErrorLabel.setVisible(false);
		// Set the border of customerNumberTextField to default
		customerNumberTextField.setStyle("");
    }
    // Define resetProductComponents method
    public void resetProductComponents() {
		// Set productNumberErrorLabel to invisible
    	productNumberErrorLabel.setVisible(false);
		// Set the border of productNumberTextField to default
		productNumberTextField.setStyle("");
    }
    // Define setLayout method
    public void setLayout() {
		// Call resetFields method
		resetFields();
    }
    // Define getCustomerById method
    public Customer getCustomerById() {
		// Call resetCustomerComponents method
    	resetCustomerComponents();
		// Define customerDAO as new CustomerDAOImpl
    	CustomerDAOImpl customerDAO = new CustomerDAOImpl();
    	// Call getCustomerById method from customerDAO using customerNumberTextField as parameter
    	Customer customer = customerDAO.getCustomerById(customerNumberTextField.getText());
    	// Return customer
    	return customer;
    }
    // Define getCoffeeById method
    public Coffee getCoffeeById() {
		// Call resetProductComponents method
    	resetProductComponents();
		// Define coffeeDAO as new CoffeeDAOImpl
    	CoffeeDAOImpl coffeeDAO = new CoffeeDAOImpl();
    	// Call getCoffeeById method from coffeeDAO using productNumberTextField as parameter
    	Coffee coffee = coffeeDAO.getCoffeeById(productNumberTextField.getText());
    	// Return coffee
    	return coffee;
    }
}
