package com.scyyx1.frogger.main;

import java.util.List;

import com.scyyx1.frogger.background.BackgroundImage;
import com.scyyx1.frogger.frog.Animal;
import com.scyyx1.frogger.digit.Digit;
import com.scyyx1.frogger.frog.End;
import com.scyyx1.frogger.obstacle.*;

import com.scyyx1.frogger.world.MyStage;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.*;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application {
	AnimationTimer timer;
	MyStage mainstage;
	MyStage startstage;
	MyStage scorestage;
	Animal animal;
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
