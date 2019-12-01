package com.scyyx1.frogger.main;

import java.io.FileInputStream;

import com.scyyx1.frogger.background.BackgroundImage;
import com.scyyx1.frogger.digit.Digit;
import com.scyyx1.frogger.frog.Animal;
import com.scyyx1.frogger.frog.End;
import com.scyyx1.frogger.obstacle.Log;
import com.scyyx1.frogger.obstacle.Vehicle;
import com.scyyx1.frogger.obstacle.Turtle;
import com.scyyx1.frogger.obstacle.WetTurtle;
import com.scyyx1.frogger.world.MyStage;

import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;



public class GameWindow extends MyStage{
	private GameModel model;
	
	public GameWindow(GameModel model, int level) {
		this.model = model;
		createObject(level);
	}
	
	public void createObject(int level) {
		
		//Obstacle obstacle = new Obstacle("file:src/p4_group_8_repo/truck1Right.png", 25, 25, 3);
		//Obstacle obstacle1 = new Obstacle("file:src/p4_group_8_repo/truck2Right.png", 100, 100,2 );
		//Obstacle obstacle2 = new Obstacle("file:src/p4_group_8_repo/truck1Right.png",0,  150, 1);
		createBackground();
		createScore();
		createLog(level);
		createTurtle(level);
		createVehicle(level);

		//background.add(obstacle);
		//background.add(obstacle1);
		//background.add(obstacle2);
		
	}

	public void createScore() {
		Label hScore = new Label("PREV-SCORE");
		hScore.setLayoutX(120);
		hScore.setLayoutY(5);
		hScore.setFont(Font.font("Verdana", FontWeight.BOLD, 30));
		hScore.setTextFill(Color.CORNSILK);
		getChildren().add(hScore);
		
		Label cScore = new Label("SCORE");
		cScore.setLayoutX(400);
		cScore.setLayoutY(5);
		cScore.setFont(Font.font("Verdana", FontWeight.BOLD, 30));
		cScore.setTextFill(Color.CORNSILK);
		getChildren().add(cScore);

	}
	
	public void createVehicle(int level) {
		
		add(new Vehicle("file:resource/vehicles/truck1Right.png", 0, 649, level, 120, 120));
		add(new Vehicle("file:resource/vehicles/truck1Right.png", 300, 649, level, 120, 120));
		add(new Vehicle("file:resource/vehicles/truck1Right.png", 600, 649, level, 120, 120));
		//add(new Obstacle("file:src/p4_group_8_repo/truck1"+"Right.png", 720, 649, 1, 120, 120));
		
		add(new Vehicle("file:resource/vehicles/car1Left.png", 100, 597, -level, 50, 50));
		add(new Vehicle("file:resource/vehicles/car1Left.png", 250, 597, -level, 50, 50));
		add(new Vehicle("file:resource/vehicles/car1Left.png", 400, 597, -level, 50, 50));
		add(new Vehicle("file:resource/vehicles/car1Left.png", 550, 597, -level, 50, 50));
		add(new Vehicle("file:resource/vehicles/truck2Right.png", 0, 540, level, 200, 200));
		add(new Vehicle("file:resource/vehicles/truck2Right.png", 500, 540, level, 200, 200));
		add(new Vehicle("file:resource/vehicles/car1Left.png", 500, 490, -level, 50, 50));
	}
	
	public void createTurtle(int level) {
		
		add(new Turtle(500, 376, -level, 130, 130));
		add(new Turtle(300, 376, -level, 130, 130));
		add(new WetTurtle(700, 376, -level, 130, 130));
		add(new WetTurtle(600, 217, -level, 130, 130));
		add(new WetTurtle(400, 217, -level, 130, 130));
		add(new WetTurtle(200, 217, -level, 130, 130));
	}

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
				//background.add(new Log("file:src/p4_group_8_repo/log2.png", 100, 200, -1));
				//background.add(new Log("file:src/p4_group_8_repo/log2.png", 200, 200, -1));
				//background.add(new Log("file:src/p4_group_8_repo/log2.png", 100, 220, 1));
				//background.add(new Log("file:src/p4_group_8_repo/log2.png", 200, 220, 1));
				//background.add(new Log("file:src/p4_group_8_repo/log2.png", 400, 220, 1));
	}
	
	public void createBackground() {
		BackgroundImage froggerback = new BackgroundImage("file:resource/backgrounds/background.png", 600, 800);
	    
		add(froggerback);
		add(new End(13,96));
		add(new End(141,96));
		add(new End(141 + 141-13,96));
		add(new End(141 + 141-13+141-13+1,96));
		add(new End(141 + 141-13+141-13+141-13+3,96));
		Animal animal = new Animal("file:resource/frogs/froggerUp.png");
		add(animal);
		model.setAnimal(animal);
	}
	
    
    
    
   
    
}
