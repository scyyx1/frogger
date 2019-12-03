package com.scyyx1.frogger.main;

import com.scyyx1.frogger.background.BackgroundImage;
import com.scyyx1.frogger.world.MyStage;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class DifficultyWindow extends MyStage{
	public static Stage stage;
	public DifficultyWindow() {
		
		BackgroundImage background = new BackgroundImage("file:resource/backgrounds/startbackground.png", 500, 500);

		add(background);
		Label title = new Label("SELECT DIFFICULTIES");
		title.setLayoutX(70);
		title.setLayoutY(50);
		title.setFont(Font.font("Verdana", FontWeight.BOLD, 30));
		title.setTextFill(Color.CADETBLUE);
		
		getChildren().add(title);
		Button easy = new Button("EASY");
		easy.setOnAction(new EventHandler<ActionEvent>() {
		    @Override 
		    public void handle(ActionEvent e) {
		    	stage = new Stage();
		    	GameModel gm = new GameModel();
		    	GameWindow game = new GameWindow(gm, 1);
		    	GameController wc = new GameController(gm, game);
		    	Scene scene  = new Scene(wc.asView(), 600, 800);
		    	Main.getStage().close();
		    	stage.setScene(scene);
		    	stage.setResizable(false);
		    	stage.show();

		    }
		});
		Button medium = new Button("MEDIUM");
		medium.setOnAction(new EventHandler<ActionEvent>() {
		    @Override 
		    public void handle(ActionEvent e) {
		    	stage = new Stage();
		    	GameModel gm = new GameModel();
		    	GameWindow game = new GameWindow(gm, 2);
		    	GameController wc = new GameController(gm, game);
		    	Scene scene  = new Scene(wc.asView(), 600, 800);
		    	Main.getStage().close();
		    	stage.setScene(scene);
		    	stage.setResizable(false);
		    	stage.show();

		    }
		});
		Button difficult = new Button("DIFFICULT");
		difficult.setOnAction(new EventHandler<ActionEvent>() {
		    @Override 
		    public void handle(ActionEvent e) {
		    	stage = new Stage();
		    	GameModel gm = new GameModel();
		    	GameWindow game = new GameWindow(gm, 3);
		    	GameController wc = new GameController(gm, game);
		    	Scene scene  = new Scene(wc.asView(), 600, 800);
		    	Main.getStage().close();
		    	stage.setScene(scene);
		    	stage.setResizable(false);
		    	stage.show();
		    }
		});
		easy.setLayoutX(150);
		easy.setLayoutY(150);
		medium.setLayoutX(150);
		medium.setLayoutY(250);
		difficult.setLayoutX(150);
		difficult.setLayoutY(350);
		getChildren().add(easy);
		getChildren().add(medium);
		getChildren().add(difficult);
		
	}
	
	public static Stage getStage() {
		return stage;
	}
}
