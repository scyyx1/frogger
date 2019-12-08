package frogger.view;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import frogger.control.GameOverController;
import frogger.model.Player;
import frogger.model.ScoreCompare;
import frogger.model.actors.BackgroundImage;
import frogger.model.actors.Frogger;
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

public class GameOverWindow extends Pane implements BasicGUI{
	
	private Frogger frogger;
	private TextField username;
	public GameOverWindow(Frogger frogger) {
		this.frogger = frogger;
		
		createBackground();
		
		createLabel();

		createTextField();
		
		createButton();

	}

	@Override
	public void createBackground() {
		// TODO Auto-generated method stub
		BackgroundImage background = new BackgroundImage("file:resource/backgrounds/background1.png", 600, 800);
		getChildren().add(background);
	}

	@Override
	public void createButton() {
		// TODO Auto-generated method stub
		GameOverController controller = new GameOverController(frogger);
		
		Button enter = new Button("ENTER");
		enter.getStyleClass().add("ok");
		enter.setOnAction(e->{

			controller.enterButtonAction(username);

		});
		enter.setLayoutX(200);
		enter.setLayoutY(400);
		getChildren().add(enter);
		
	}

	@Override
	public void createLabel() {
		// TODO Auto-generated method stub
		Label title = new Label("GAME OVER");
		title.setLayoutX(140);
		title.setLayoutY(180);
		title.setFont(Font.font("Mouse", FontWeight.BOLD, 65));
		title.setTextFill(Color.CORNSILK);
		getChildren().add(title);
	}
	
	public void createTextField() {
		
		username = new TextField();
		username.setPromptText("Enter your name");
		username.setPrefColumnCount(10);
		username.setLayoutX(200);
		username.setLayoutY(300);
		getChildren().add(username);
	}
	
}
