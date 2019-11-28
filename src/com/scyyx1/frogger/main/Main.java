package com.scyyx1.frogger.main;

import javafx.application.Application;
import javafx.scene.Scene;

import javafx.stage.Stage;


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
	    int width = 600;
	    int height = 800;
	    StartWindow startwindow = new StartWindow(width, height);
	    Scene startscene  = new Scene(startwindow,width,height);
	    
		primaryStage.setScene(startscene);
		primaryStage.show();

	}
	




   
}
