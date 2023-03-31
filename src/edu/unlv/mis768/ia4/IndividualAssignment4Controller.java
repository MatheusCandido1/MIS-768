package edu.unlv.mis768.ia4;

import java.text.DecimalFormat;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

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
    

    DecimalFormat currency = new DecimalFormat("0.00");
    
    public void saveButtonListener() {
    	CustomerOrder order = new CustomerOrder();
    	
    	order.setOilChange(oilChangeCheckBox.isSelected());
    	order.setLubeJob(lubeJobCheckBox.isSelected());
    	order.setRadiatorFlush(radiatorFlushCheckBox.isSelected());
    	order.setTireRotation(tireRotationCheckBox.isSelected());
    	order.setTransmissionFlush(transmissionFlushCheckBox.isSelected());
    	order.setInspection(inspectionCheckBox.isSelected());
    	order.setMufflerReplacement(mufflerReplacementCheckBox.isSelected());
    	
    	if(!laborTextField.getText().isEmpty()) 
    		order.setLaborPrice(Double.parseDouble(laborTextField.getText()));
    	
    	if(!partsTextField.getText().isEmpty())
    		order.setPartPrice(Double.parseDouble(partsTextField.getText()));
    	
    	if(FifteenDiscountRadioButton.isSelected()) {
    		order.setDiscount(0.15);
    	} else if(tenDiscountRadioButton.isSelected()) {
    		order.setDiscount(0.10);
    	} else {
    		order.setDiscount(0);
    	}
    	
    	totalValueLabel.setText("$ " + currency.format(order.getTotal()));
    	
    	
    }
    
    public void resetFields() { 
    	this.oilChangeCheckBox.setSelected(false);
    	this.lubeJobCheckBox.setSelected(false);
    	this.radiatorFlushCheckBox.setSelected(false);
    	this.tireRotationCheckBox.setSelected(false);
    	this.transmissionFlushCheckBox.setSelected(false);
    	this.inspectionCheckBox.setSelected(false);
    	this.mufflerReplacementCheckBox.setSelected(false);
    	this.laborTextField.setText("");
    	this.partsTextField.setText("");
    	this.noDiscountRadioButton.setSelected(true);
    	this.totalValueLabel.setText("$ 0.00");
    }
    
    public void resetButtonListener() {
    	resetFields();
    }

}
