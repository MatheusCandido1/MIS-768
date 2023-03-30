package edu.unlv.mis768.labwork15;

	import javafx.fxml.FXML;
	import javafx.scene.control.Button;
	import javafx.scene.control.ComboBox;
	import javafx.scene.control.TextArea;

	public class ShowSelectionController {

	    @FXML
	    private Button clearButton;

	    @FXML
	    private ComboBox<String> selectionComboBox;

	    @FXML
	    private TextArea contentTextArea;
	    
		/**
	     * The method will be called when FXML file is loaded
	     */
	    public void initialize() {
	    	// this items are for configuring the combobox
	    	selectionComboBox.getItems().addAll("Penn & Teller", "Carrot Top", "Blue Man Group", "Cirque du Soleil");
	    }
	    
		/**
	     * Action Listener for the button
	     */
	    public void buttonListener() {
	    	// clear the text in the Text Area
	    	this.contentTextArea.setText("");
	    }

		/**
	     * Action Listener for the combobox
	     */
	    public void comboboxListener() {
	    	// retrieve current content of the Text Area
	    	String content = contentTextArea.getText();
	    	
	    	// add the value in the combo box
	    	content += this.selectionComboBox.getValue()+"\n";
	    	
	    	// set it back to the Text Area
	    	this.contentTextArea.setText(content);

	    }
	}

