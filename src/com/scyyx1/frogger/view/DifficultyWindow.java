package com.scyyx1.frogger.view;

import com.scyyx1.frogger.control.WindowController;
import com.scyyx1.frogger.main.Main;
import com.scyyx1.frogger.model.GameWorld;
import com.scyyx1.frogger.obstacle_view.BackgroundImage;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class DifficultyWindow extends Pane{
	public static Stage stage = new Stage();
	public DifficultyWindow() {
		
		WindowController controller = new WindowController();
		BackgroundImage background = new BackgroundImage("file:resource/backgrounds/startbackground.png", 500, 500);
		getChildren().add(background);
		
		Label title = new Label("SELECT DIFFICULTIES");
		title.setLayoutX(60);
		title.setLayoutY(50);
		title.setId("Difficulty");
		title.setTextFill(Color.CADETBLUE);
		getChildren().add(title);
		
		
		Button easy = new Button("EASY");
		easy.setOnAction(e->{
			controller.easyButtonAction(stage);
		});
		easy.setLayoutX(150);
		easy.setLayoutY(150);
		getChildren().add(easy);
		
		Button medium = new Button("MEDIUM");
		medium.setOnAction(e->{
			controller.mediumButtonAction(stage);
		});
		medium.setLayoutX(150);
		medium.setLayoutY(250);
		getChildren().add(medium);
		
		Button difficult = new Button("DIFFICULT");
		difficult.setOnAction(e->{
			controller.difficultButtonAction(stage);
		});
		difficult.setLayoutX(150);
		difficult.setLayoutY(350);
		getChildren().add(difficult);
		
		Button back = new Button("BACK");
		back.setOnAction(e ->{
			controller.backButtonAction();
		});
		back.setId("back");
		back.setLayoutX(0);
		back.setLayoutY(450);
		getChildren().add(back);
		
	}
	
	public static Stage getStage() {
		return stage;
	}
}
