package exercici1;

import java.awt.Event;
import java.beans.EventHandler;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ex1  extends Application{


	@Override
	public void start(Stage primaryStage) throws Exception {
		VBox root = new VBox();
		Scene  sc = new Scene(root,1920,400);
		primaryStage.setScene(sc);
		primaryStage.show();
		
		ChoiceBox<String> choice = new ChoiceBox<String>(FXCollections.observableArrayList("D->H","H->D"));
		choice.setValue("D->H");
		
		
		EventHandler<ActionEvent> handler = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent handler) {
				
			}
			
		};
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}
