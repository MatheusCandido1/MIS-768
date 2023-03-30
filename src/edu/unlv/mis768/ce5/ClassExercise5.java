package edu.unlv.mis768.ce5;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ClassExercise5 extends Application {

	@Override
	public void start(Stage primaryStage) throws IOException {
		Parent parent = FXMLLoader.load(getClass().getResource("ClassExercise5.fxml"));
		// set the scene
		Scene scene = new Scene(parent);
		
		// set the title of the window
		primaryStage.setTitle("Payment Summary");
		// set the scence for the stage
		primaryStage.setScene(scene);
		// show the stage
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
