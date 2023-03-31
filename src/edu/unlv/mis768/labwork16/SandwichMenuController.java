package edu.unlv.mis768.labwork16;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.stage.*;

public class SandwichMenuController {

    @FXML
    private Button nextButton;

    @FXML
    private RadioButton cheeseBurgerRadioButton;

    @FXML
    private RadioButton chickenSandwichRadioButton;

    @FXML
    private RadioButton tofuBurgerRadioButton;
    
    /**
     * Event handler for the "Next" Button 
     * It will determined which sandwich is selected and pass it to the next scene
     * @throws IOException 
     */
    public void changeSceneToSideMenu(ActionEvent e) throws IOException {
    	// prepare the string to be sent to the next window
    	String item = "";
    	// check which radio button is slected, and set the string accordingly
    	if(this.cheeseBurgerRadioButton.isSelected()) {
    		item = "Cheese Burguer";
    	} else if(this.chickenSandwichRadioButton.isSelected()) {
    		item = "Chicken Sandwich";
    	} else {
    		item = "Tofu Burguer";
    	}
    		
    	// Instantiate the FXMLLoader object for loading the UI 
    	FXMLLoader loader = new FXMLLoader();
    	// specify the file location
    	loader.setLocation(getClass().getResource("SideMenu.fxml"));
    	
    	// specify the file location for the FXML file for the next window
    	try {
    		// the object representing the root node of the scene; load the UI
    		Parent parent = loader.load();
   	
			// set the scene
			Scene scene = new Scene(parent);
    	   	
	    	// get the current window; i.e. the stage
			SideMenuController controller = loader.getController();
			
			controller.initData(item);
	    	// change the title of the window
	    	Stage stage = (Stage)((Node)e.getSource()).getScene().getWindow();
	    	// change the title of the window
	    	stage.setTitle("Side Menu");
	    	// set the scene for the stage
	    	stage.setScene(scene);
	    	// show the stage
	    	stage.show();
			} catch (IOException e1) {
				
				System.out.print(e1.getMessage());
			}
    }
    
}
