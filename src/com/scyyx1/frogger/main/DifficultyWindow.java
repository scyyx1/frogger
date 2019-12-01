package com.scyyx1.frogger.main;

import com.scyyx1.frogger.world.MyStage;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class DifficultyWindow extends MyStage{
	public static Stage stage;
	public DifficultyWindow() {
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
		easy.setLayoutX(170);
		easy.setLayoutY(100);
		medium.setLayoutX(170);
		medium.setLayoutY(200);
		difficult.setLayoutX(170);
		difficult.setLayoutY(300);
		getChildren().add(easy);
		getChildren().add(medium);
		getChildren().add(difficult);
		
	}
	
	public static Stage getStage() {
		return stage;
	}
}
