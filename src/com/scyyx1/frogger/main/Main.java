package com.scyyx1.frogger.main;

import java.io.InputStream;

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
	    StartWindow startwindow = new StartWindow();
	    Scene startscene  = new Scene(startwindow, 500, 500);
	    startscene.getStylesheets().add("file:resource/application.css");
	    
		primaryStage.setScene(startscene);
		primaryStage.setResizable(false);
		primaryStage.initStyle(StageStyle.UNDECORATED);
		primaryStage.show();

	}
	




   
}
