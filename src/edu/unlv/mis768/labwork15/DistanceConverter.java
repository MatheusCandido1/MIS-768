package edu.unlv.mis768.labwork15;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.event.*;

	public class DistanceConverter extends Application {
		
		private TextField kiloTextField;
		private Label resultLabel;

		public class ButtonClickHandle implements EventHandler<ActionEvent> {
			@Override
			public void handle(ActionEvent arg0) {
				double kilo = Double.parseDouble(kiloTextField.getText());
				double miles = kilo * 0.6214;
				resultLabel.setText("The result is: " + miles + " miles.");
			}
		}

		@Override
		public void start(Stage primaryStage) {
			//controls
		      Label promptLabel = new Label("Enter a distance in kilometer");
		      kiloTextField = new TextField();
		      Button calcButton = new Button("Convert");
		      resultLabel = new Label("");
		      
		      calcButton.setOnAction(new ButtonClickHandle());
		      //layout manager
		      VBox vbox = new VBox(20, promptLabel, kiloTextField, calcButton, resultLabel);
		      
		      //center align the controls
		      vbox.setAlignment(Pos.CENTER);
		      
		      //set the layout to the scene
		      Scene scene = new Scene(vbox, 300, 150);
		      
		      // Add the Scene to the Stage.
		      primaryStage.setScene(scene);
		      
		      // Show the window.
		      primaryStage.show();
		}

		public static void main(String[] args) {
			launch(args);
		}

	
}
