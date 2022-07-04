package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
	
	private static Stage stg;
	
	
	@Override
	public void start(Stage primaryStage) throws Exception{
			
			stg = primaryStage;
			primaryStage.setResizable(false);
			
			Parent root = FXMLLoader.load(getClass().getResource("/views/LoginView.fxml")); 
			primaryStage.setTitle("Automação Gerencial do Restaurante");
			primaryStage.setScene(new Scene(root));
			primaryStage.show();
			
	}
	
	public void mudarCena(String Fxml) throws IOException{
		Parent Pane; 
		Pane = FXMLLoader.load(getClass().getResource(Fxml)); 
		stg.getScene().setRoot(Pane);
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
