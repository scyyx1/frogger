package frogger.main;

import java.io.InputStream;

import frogger.control.WindowController;
import frogger.view.StartWindow;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class Main extends Application {
	
	public static Stage stage;
	public static void main(String[] args) {
		launch(args);
	}

	public static Stage getStage() {
		return stage;
	}
	@Override
	public void start(Stage primaryStage) throws Exception {
		stage = primaryStage;
		createStartWindow(primaryStage);

	}
	
	public void createStartWindow(Stage stage) {
		StartWindow startWindow = new StartWindow();
	    Scene startScene  = new Scene(startWindow, 500, 500);
	    startScene.getStylesheets().add("file:resource/application.css");
	    
	    stage.setScene(startScene);
	    stage.setResizable(false);
	    stage.initStyle(StageStyle.UNDECORATED);
	    stage.show();
	}
	




   
}
