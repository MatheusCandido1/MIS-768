package edu.unlv.mis768.ia4;

// Import Decimal Formatter
import java.text.DecimalFormat;

// Import all used javaFX components and controls
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

// Create the main controller
public class IndividualAssignment4Controller {

	@FXML
    private RadioButton FifteenDiscountRadioButton;

    @FXML
    private ToggleGroup discountGroup;

    @FXML
    private CheckBox inspectionCheckBox;

    @FXML
    private TextField laborTextField;

    @FXML
    private CheckBox lubeJobCheckBox;

    @FXML
    private CheckBox mufflerReplacementCheckBox;

    @FXML
    private RadioButton noDiscountRadioButton;

    @FXML
    private CheckBox oilChangeCheckBox;

    @FXML
    private TextField partsTextField;

    @FXML
    private CheckBox radiatorFlushCheckBox;

    @FXML
    private Button saveButton;

    @FXML
    private RadioButton tenDiscountRadioButton;

    @FXML
    private CheckBox tireRotationCheckBox;

    @FXML
    private Label totalValueLabel;

    @FXML
    private CheckBox transmissionFlushCheckBox;
    
    @FXML
    private Button resetButton;
    
    // Create a DecimalFormat object to format output
    DecimalFormat currency = new DecimalFormat("0.00");
    
    // Create the save button listener
    public void saveButtonListener() {
        // Create a CustomerOrder object
    	CustomerOrder order = new CustomerOrder();
    	
        // Get the value from the oil change check box and set the oilChange field
    	order.setOilChange(oilChangeCheckBox.isSelected());
        // Get the value from the lube job check box and set the lubeJob field
    	order.setLubeJob(lubeJobCheckBox.isSelected());
        // Get the value from the radiator flush check box and set the radiatorFlush field
    	order.setRadiatorFlush(radiatorFlushCheckBox.isSelected());
        // Get the value from the tire rotation check box and set the tireRotation field
    	order.setTireRotation(tireRotationCheckBox.isSelected());
        // Get the value from the transmission flush check box and set the transmissionFlush field
    	order.setTransmissionFlush(transmissionFlushCheckBox.isSelected());
        // Get the value from the inspection check box and set the inspection field
    	order.setInspection(inspectionCheckBox.isSelected());
        // Get the value from the muffler replacement check box and set the mufflerReplacement field
    	order.setMufflerReplacement(mufflerReplacementCheckBox.isSelected());
    	
        // Check if the labor text field is not empty
    	if(!laborTextField.getText().isEmpty()) 
            // Get the value from the labor text field and set the laborPrice field
    		order.setLaborPrice(Double.parseDouble(laborTextField.getText()));
    	// Check if the parts text field is not empty
    	if(!partsTextField.getText().isEmpty())
            // Get the value from the parts text field and set the partPrice field
    		order.setPartPrice(Double.parseDouble(partsTextField.getText()));
    	// Check if the 15% discount radio button is selected
    	if(FifteenDiscountRadioButton.isSelected()) {
            // Set the discount field to 0.15
    		order.setDiscount(0.15);
        // Check if the 10% discount radio button is selected
    	} else if(tenDiscountRadioButton.isSelected()) {
            // Set the discount field to 0.10
    		order.setDiscount(0.10);
    	} else {
            // Set the discount field to 0
    		order.setDiscount(0);
    	}
    	// Set and format the total label with the total value
    	totalValueLabel.setText("$ " + currency.format(order.getTotal()));
    	
    	
    }
    // Create the reset button listener
    public void resetFields() { 
        // Clear the oil change check box
    	this.oilChangeCheckBox.setSelected(false);
        // Clear the lube job check box
    	this.lubeJobCheckBox.setSelected(false);
        // Clear the radiator flush check box
    	this.radiatorFlushCheckBox.setSelected(false);
        // Clear the tire rotation check box
    	this.tireRotationCheckBox.setSelected(false);
        // Clear the transmission flush check box
    	this.transmissionFlushCheckBox.setSelected(false);
        // Clear the inspection check box
    	this.inspectionCheckBox.setSelected(false);
        // Clear the muffler replacement check box
    	this.mufflerReplacementCheckBox.setSelected(false);
        // Clear the labor text field
    	this.laborTextField.setText("");
        // Clear the parts text field
    	this.partsTextField.setText("");
        // Select the no discount radio button
    	this.noDiscountRadioButton.setSelected(true);
        // Set the total value label to $0.00
    	this.totalValueLabel.setText("$ 0.00");
    }
    // Create the reset button listener
    public void resetButtonListener() {
        // Call the resetFields method
    	resetFields();
    }

}
