package com.scyyx1.frogger.view;

import java.io.FileInputStream;
import java.util.Random;

import com.scyyx1.frogger.model.GameModel;
import com.scyyx1.frogger.model.MyStage;
import com.scyyx1.frogger.obstacle_view.BackgroundImage;
import com.scyyx1.frogger.obstacle_view.Crocodile;
import com.scyyx1.frogger.obstacle_view.CrocodileHead;
import com.scyyx1.frogger.obstacle_view.Digit;
import com.scyyx1.frogger.obstacle_view.End;
import com.scyyx1.frogger.obstacle_view.FrogView;
import com.scyyx1.frogger.obstacle_view.Log;
import com.scyyx1.frogger.obstacle_view.Turtle;
import com.scyyx1.frogger.obstacle_view.Vehicle;
import com.scyyx1.frogger.obstacle_view.WetTurtle;

import javafx.animation.Animation;
import javafx.animation.Timeline;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;



public class GameWindow extends MyStage{
	private GameModel model;
	private Group scoreGroup = new Group();
	private Group previousScoreGroup = new Group();
	private Group livesGroup = new Group();
	private Group labelGroup = new Group();
	
	
	public GameWindow(GameModel model, int level) {
		this.model = model;
		model.setLevel(level);
		createObject(level);
	}
	
	public void createObject(int level) {
		
		//Obstacle obstacle = new Obstacle("file:src/p4_group_8_repo/truck1Right.png", 25, 25, 3);
		//Obstacle obstacle1 = new Obstacle("file:src/p4_group_8_repo/truck2Right.png", 100, 100,2 );
		//Obstacle obstacle2 = new Obstacle("file:src/p4_group_8_repo/truck1Right.png",0,  150, 1);
		createBackground();
		createScore();
		createLog(level);
		createCrocodile();
		createTurtle(level);
		//createVehicle(level);
		createFrog();
		createGroups();
		//background.add(obstacle);
		//background.add(obstacle1);
		//background.add(obstacle2);
		
	}

	public void createScore() {
		Label scoreList = new Label("Score Each Round");
		scoreList.setLayoutX(0);
		scoreList.setLayoutY(0);
		scoreList.setTextFill(Color.CORNSILK);
		getChildren().add(scoreList);
		Label hScore = new Label("PREV-SCORE");
		hScore.setLayoutX(120);
		hScore.setLayoutY(5);
		hScore.setFont(Font.font("Mouse", FontWeight.BOLD, 30));
		hScore.setTextFill(Color.CORNSILK);
		getChildren().add(hScore);
		
		Label cScore = new Label("SCORE");
		cScore.setLayoutX(400);
		cScore.setLayoutY(5);
		cScore.setFont(Font.font("Mouse", FontWeight.BOLD, 30));
		cScore.setTextFill(Color.CORNSILK);
		getChildren().add(cScore);

	}
	
	// add the vehicle
	public void createVehicle(int level) {
	
		int speed = 1;
		if (level > 3) {
			speed = 2;
		}
		for(int i = 0; i < 5; i++) {
			if (i == 4) {
				add(new Vehicle("file:resource/vehicles/car1Left.png", 500, 490, -speed, 50, 50));
			}else {
				add(new Vehicle("file:resource/vehicles/car1Left.png", 100+150 * i, 597, -speed, 50, 50));
			}
		}
		for(int i = 0; i < 3; i++) {
			 add(new Vehicle("file:resource/vehicles/truck1Right.png", 0 + 300 * i, 649, speed, 120, 120));
		}
		for(int i = 0; i < 2; i++) {
			 add(new Vehicle("file:resource/vehicles/truck2Right.png", 0 + 500 * i, 540, speed, 200, 200));
		}
	}
	
	// add the turtle
	public void createTurtle(int level) {
		
		int speed = 1;
		if(level > 3) {
			speed = 2;
		}
		for(int i = 0; i < 2; i++) {
			add(new Turtle(300 + 200 * i, 376, -speed, 130, 130));
		}
		for(int i = 0; i < 4; i++) {
			if (i == 3) {
				add(new WetTurtle(700, 376, -speed, 130, 130));
			}else {
				//add(new WetTurtle(200 + 200 * i, 217, -speed, 130, 130));
			}
		}
	}

	// add the log
	public void createLog(int level) {
		//background.add(new Log("file:src/p4_group_8_repo/log3.png", 150, 570, 329, 0.75));
		add(new Log("file:resource/logs/log3.png", 150, 0, 166, level * 0.75));
		add(new Log("file:resource/logs/log3.png", 150, 220, 166, level *0.75));
		add(new Log("file:resource/logs/log3.png", 150, 440, 166, level *0.75));
		//background.add(new Log("file:src/p4_group_8_repo/log3.png", 150, 0, 166, 0.75));
		add(new Log("file:resource/logs/logs.png", 250, 0, 276, -2));
		add(new Log("file:resource/logs/logs.png", 250, 400, 276, -2));
		//background.add(new Log("file:src/p4_group_8_repo/logs.png", 300, 800, 276, -2));
		add(new Log("file:resource/logs/log3.png", 150, 50, 329, level *0.75));
		add(new Log("file:resource/logs/log3.png", 150, 270, 329, level *0.75));
		add(new Log("file:resource/logs/log3.png", 150, 490, 329, level *0.75));
		//background.add(new Log("file:src/p4_group_8_repo/log2.png", 200, 100, 1));
		//background.add(new Log("file:src/p4_group_8_repo/log2.png", 0, 100, 1));
		//background.add(new Log("file:src/p4_group_8_repo/log2.png", 100, 120, -1));
		//background.add(new Log("file:src/p4_group_8_repo/log2.png", 200, 120, -1));
		//background.add(new Log("file:src/p4_group_8_repo/log2.png", 100, 140, 1));
		//background.add(new Log("file:src/p4_group_8_repo/log2.png", 200, 140, 1));
		//background.add(new Log("file:src/p4_group_8_repo/log2.png", 100, 160, -1));
		//background.add(new Log("file:src/p4_group_8_repo/log2.png", 300, 160, -1));
		//background.add(new Log("file:src/p4_group_8_repo/log2.png", 100, 180, 1));				
		//background.add(new Log("file:src/p4_group_8_repo/log2.png", 200, 180, 1));
		//background.add(new Log("file:src/p4_group_8_repo/log2.png", 100, 200,-1));
		//background.add(new Log("file:src/p4_group_8_repo/log2.png", 200, 200 -1));
		//background.add(new Log("file:src/p4_group_8_repo/log2.png", 100, 220, 1));
		//background.add(new Log("file:src/p4_group_8_repo/log2.png", 200, 220, 1));
		//background.add(new Log("file:src/p4_group_8_repo/log2.png", 400, 220, 1));
	}
	
	// add the background
	public void createBackground() {
		
		BackgroundImage froggerback = new BackgroundImage("file:resource/backgrounds/background.png", 600, 800);
		add(froggerback);
		add(new End(13,96));
		add(new End(141,96));
		add(new End(141 + 141-13,96));
		add(new End(141 + 141-13+141-13+1,96));
		add(new End(141 + 141-13+141-13+141-13+3,96));
		
	}
	
	
	public void createFrog() {
		FrogView frogView = new FrogView("file:resource/frogs/froggerUp.png");
		add(frogView);
		model.setFrogView(frogView);
		model.setFrog(frogView.getFrog());
	}
	
	public void createGroups() {
		getChildren().add(scoreGroup);
		getChildren().add(previousScoreGroup);
		getChildren().add(livesGroup);
		getChildren().add(labelGroup);
	}
	
	
	public Group getScoreGroup() {
		return scoreGroup;
	}


	public Group getPreviousScoreGroup() {
		return previousScoreGroup;
	}


	public Group getFrogLives() {
		return livesGroup;
	}


	public Group getLabelGroup() {
		return labelGroup;
	}
	
	public void createCrocodile() {
		add(new Crocodile(200, 217, 1, 130, 130));
		add(new CrocodileHead(320, 217, 1, 130, 130));
	}

    
    
   
    
}
