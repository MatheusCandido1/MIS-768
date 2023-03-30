package edu.unlv.mis768.labwork15;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class TemperatureConverterController {

    @FXML
    private TextField celsiusTextField;

    @FXML
    private Button convertButton;

    @FXML
    private Label outputLabel;
    
    public void convertButtonListener() {
    	double celsiusDegree = Double.parseDouble(celsiusTextField.getText());
    	
    	double farenheitDegree = celsiusDegree * 1.8 + 32;
    	
    	outputLabel.setText("It is  "+ farenheitDegree + " degrees Fahrenheit");
    }

}
