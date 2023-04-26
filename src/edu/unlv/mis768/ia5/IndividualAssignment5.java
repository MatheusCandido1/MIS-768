package edu.unlv.mis768.ia5;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class IndividualAssignment5 extends Application {

	@Override
	public void start(Stage primaryStage) throws IOException {
		// Set the FXML filename
		Parent parent = FXMLLoader.load(getClass().getResource("IndividualAssignment5.fxml"));
		// set the scene
		Scene scene = new Scene(parent);
		
		// set the title of the window
		primaryStage.setTitle("Coffee Shop");
		// set the scene for the stage
		primaryStage.setScene(scene);
		// show the stage
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
