package edu.unlv.mis768.labwork15;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

public class ColorWindowController {

    @FXML
    private CheckBox bgCheckBox;

    @FXML
    private VBox vBox;

    @FXML
    private CheckBox redFontCheckBox;
    
	// Action Listener that handles the events of Check box
    public void checkboxListener() {
    	

		vBox.setStyle("");

		redFontCheckBox.setStyle("");
		bgCheckBox.setStyle("");
    	
    	// verify whether redFontCheckBox is checked.
    	// if so, change the text to red; otherwise remove the style
    	if(this.redFontCheckBox.isSelected()) {
    		redFontCheckBox.setStyle("-fx-text-fill:red;");
    		bgCheckBox.setStyle("-fx-text-fill:red;");
    	} 
    	
    	if(this.bgCheckBox.isSelected()) {
    		vBox.setStyle("-fx-background-color: yellow");
    	} 
    	
    	// verify whether bgCheckBox is checked.
    	// if so, change the background to yellow; otherwise remove the style
		
    }


}
