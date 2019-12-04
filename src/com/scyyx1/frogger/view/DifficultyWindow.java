package com.scyyx1.frogger.view;

import com.scyyx1.frogger.control.WindowController;
import com.scyyx1.frogger.main.Main;
import com.scyyx1.frogger.model.MyStage;
import com.scyyx1.frogger.obstacle_view.BackgroundImage;

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
		
		WindowController controller = new WindowController();
		BackgroundImage background = new BackgroundImage("file:resource/backgrounds/startbackground.png", 500, 500);
		add(background);
		
		Label title = new Label("SELECT DIFFICULTIES");
		title.setLayoutX(70);
		title.setLayoutY(50);
		title.setId("Difficulty");
		title.setTextFill(Color.CADETBLUE);
		getChildren().add(title);
		
		
		Button easy = new Button("EASY");
		easy.setOnAction(e->{
			controller.easyButtonAction(stage);
		});
		Button medium = new Button("MEDIUM");
		medium.setOnAction(e->{
			controller.mediumButtonAction(stage);
		});
		Button difficult = new Button("DIFFICULT");
		difficult.setOnAction(e->{
			controller.difficultButtonAction(stage);
		});
		Button back = new Button("BACK");
		back.setOnAction(e ->{
			controller.backButtonAction();
		});
		back.setId("back");
		easy.setLayoutX(150);
		easy.setLayoutY(150);
		medium.setLayoutX(150);
		medium.setLayoutY(250);
		difficult.setLayoutX(150);
		difficult.setLayoutY(350);
		back.setLayoutX(0);
		back.setLayoutY(450);
		getChildren().add(easy);
		getChildren().add(medium);
		getChildren().add(difficult);
		getChildren().add(back);
		
	}
	
	public static Stage getStage() {
		return stage;
	}
}
