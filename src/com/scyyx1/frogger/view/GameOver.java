package com.scyyx1.frogger.view;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import com.scyyx1.frogger.control.WindowController;
import com.scyyx1.frogger.model.Frogger;
import com.scyyx1.frogger.model.GameWorld;
import com.scyyx1.frogger.model.Person;
import com.scyyx1.frogger.model.ScoreCompare;
import com.scyyx1.frogger.obstacle_view.BackgroundImage;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class GameOver extends Pane{
	public GameOver(Frogger frog) {
		
		WindowController controller = new WindowController(frog);
		
		BackgroundImage background = new BackgroundImage("file:resource/backgrounds/background1.png", 600, 800);
		getChildren().add(background);
		
		Label title = new Label("GAME OVER");
		title.setLayoutX(140);
		title.setLayoutY(180);
		title.setFont(Font.font("Mouse", FontWeight.BOLD, 65));
		title.setTextFill(Color.CORNSILK);
		getChildren().add(title);

		
		TextField username = new TextField();
		username.setPromptText("Enter your name");
		username.setPrefColumnCount(10);
		username.setLayoutX(200);
		username.setLayoutY(300);
		getChildren().add(username);
		
		Button enter = new Button("ENTER");
		enter.getStyleClass().add("ok");
		enter.setOnAction(e->{
			controller.enterButtonAction(username);
		});
		enter.setLayoutX(200);
		enter.setLayoutY(400);
		getChildren().add(enter);
	}
	
}
