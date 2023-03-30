package edu.unlv.mis768.ce5;

import java.text.DecimalFormat;

import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ClassExercise5Controller {

    @FXML
    private Button btnAdd;

    @FXML
    private TextField txtHours;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtPayRate;

    @FXML
    private TextArea txtSummary;
    
    public void resetTextField() {
    	txtName.setText("");
    	txtHours.setText("");
    	txtPayRate.setText("");
    }
    
    public void addButtonListener() {
    	// Create payroll object and pass the values in the text fields as parameters
    	Payroll employeePayroll = new Payroll(txtName.getText(), Double.parseDouble(txtPayRate.getText()), Integer.parseInt(txtHours.getText()));
    	
    	
    	// Get the current value of the text area
    	String content = txtSummary.getText();
    	// Concatenate the value of the payroll object to the string that has previous payrolls
    	content += employeePayroll.toString() + '\n';
    	
    	// set it back to the Text Area
    	this.txtSummary.setText(content);
    	// Clear the text fields
    	resetTextField();
    }

}
