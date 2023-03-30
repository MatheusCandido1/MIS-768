package edu.unlv.mis768.labwork15;

import java.text.DecimalFormat;


import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class MetricConverterController {


    @FXML
    private Label lblResult;

    @FXML
    private RadioButton rdbFeet;

    @FXML
    private RadioButton rdbInches;

    @FXML
    private RadioButton rdbMiles;

    @FXML
    private TextField txtKilometer;

    @FXML
    private ToggleGroup unitRadioGroup;
    /**
     * Event listener for the radio buttons.
     * The three radio buttons shared the same action
     */

    public void radioButtonListener() {
    	// declaring variables
    	double kilo=0; // to be entered by the user 
    	String convertTo=""; // the unit of the result
    	double result = 0; // the resulting value to be calculated
    	
    	// formatter
    	DecimalFormat ft = new DecimalFormat("###,##0.00");
    	
    	// get user input
    	kilo = Double.parseDouble(txtKilometer.getText()); 
    			
    	// determine which radio button is selected
    	// convert the distance accordingly
    	if(this.rdbInches.isSelected()) {
    		result = kilo * 39370;
    		convertTo = "Inches";
    	} else if(this.rdbMiles.isSelected()) {
    		result = kilo * .6214;
    		convertTo = "Miles";
    	} else {
    		result = kilo * 3281;
    		convertTo = "Feet";
    	}
    	
    	// show the output
    	lblResult.setText("it is "+ft.format(result)+" "+convertTo);
    	
    }
}