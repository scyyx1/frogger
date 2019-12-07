package com.scyyx1.frogger.model;

import java.io.File;
import java.util.ArrayList;

import com.scyyx1.frogger.control.GameController;
import com.scyyx1.frogger.obstacle_view.BackgroundImage;
import com.scyyx1.frogger.obstacle_view.Crocodile;
import com.scyyx1.frogger.obstacle_view.CrocodileHead;
import com.scyyx1.frogger.obstacle_view.Digit;
import com.scyyx1.frogger.obstacle_view.End;
import com.scyyx1.frogger.obstacle_view.Fly;
import com.scyyx1.frogger.obstacle_view.Log;
import com.scyyx1.frogger.obstacle_view.Turtle;
import com.scyyx1.frogger.obstacle_view.Vehicle;
import com.scyyx1.frogger.obstacle_view.WetTurtle;
import com.scyyx1.frogger.view.DifficultyWindow;
import com.scyyx1.frogger.view.GameEngine;
import com.scyyx1.frogger.view.GameOver;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.util.Duration;

public class GameWorld extends World{
	
	MediaPlayer mediaPlayer;
	private GameModel model;
	private GameController controller;
	private Rectangle remainTime;
	private GroupsCollection groups;
	
	public GameWorld(GameModel model, int level) {
		this.model = model;
		model.setLevel(level);
		createObject(level);
		start();

	}
	public void createObject(int level) {

		createBackground();
		createLabels();
		createLog(level);
		//createCrocodile();
		createTurtle(level);
		//createVehicle(level);
		createFrog();
		createGroups();
		createCountDown();
		setNumber(0);
		setNumberPrev(0);
		createFrogLives();
		playMusic();
		
	}

	public void createLabels() {
		
		Label scoreList = new Label("Score Each Round");
		scoreList.setLayoutX(0);
		scoreList.setLayoutY(0);
		scoreList.setFont(Font.font("Mouse"));
		scoreList.setTextFill(Color.CORNSILK);
		getChildren().add(scoreList);
		
		Label previousScore = new Label("PREV-SCORE");
		previousScore.setLayoutX(120);
		previousScore.setLayoutY(5);
		previousScore.setFont(Font.font("Mouse", FontWeight.BOLD, 30));
		previousScore.setTextFill(Color.CORNSILK);
		getChildren().add(previousScore);
		
		Label currentScore = new Label("SCORE");
		currentScore.setLayoutX(400);
		currentScore.setLayoutY(5);
		currentScore.setFont(Font.font("Mouse", FontWeight.BOLD, 30));
		currentScore.setTextFill(Color.CORNSILK);
		getChildren().add(currentScore);
		
		
		
		

	}
	
	public void createCountDown(){
		Label time = new Label("TIME");
		time.setLayoutX(320);
		time.setLayoutY(755);
		time.setFont(Font.font("Mouse", FontWeight.BOLD, 30));
		time.setTextFill(Color.DARKGREEN);
		getChildren().add(time);
		
		remainTime = new Rectangle(200, 30, Color.DARKGREEN);
		remainTime.setX(400);
		remainTime.setY(760);
		getChildren().add(remainTime);
	}
	
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
				add(new WetTurtle(200 + 200 * i, 217, -speed, 130, 130));
			}
		}
	}

	public void createCrocodile() {
		
		add(new Crocodile(200, 217, 1, 130, 130));
		add(new CrocodileHead(200, 217, 1, 130, 130));
	}
	
	public void createLog(int level) {

		add(new Log("file:resource/logs/log3.png", 150, 0, 166, level * 0.75));
		add(new Log("file:resource/logs/log3.png", 150, 220, 166, level *0.75));
		add(new Log("file:resource/logs/log3.png", 150, 440, 166, level *0.75));
		add(new Log("file:resource/logs/logs.png", 250, 0, 276, -2));
		add(new Log("file:resource/logs/logs.png", 250, 400, 276, -2));
		add(new Log("file:resource/logs/log3.png", 150, 50, 329, level *0.75));
		add(new Log("file:resource/logs/log3.png", 150, 270, 329, level *0.75));
		add(new Log("file:resource/logs/log3.png", 150, 490, 329, level *0.75));
	}
	
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
		add(model.getFrog());
	}
	
	public void createGroups() {
		
		groups = new GroupsCollection();
		getChildren().add(groups.getCurrentScore());
		getChildren().add(groups.getPreviousScore());
		getChildren().add(groups.getFrogLivesGroup());
		getChildren().add(groups.getScoreListGroup());
		
	}

	
	public void createFrogLives() {
		groups.getFrogLivesGroup().getChildren().clear();
		int lives = model.getFrog().getLives();
		for(int i = 0; i < lives; i++) {
			Image frog = new Image("file:resource/frogs/froggerUp.png", 20, 20, false, false);
			ImageView frogLive = new ImageView(frog);
			frogLive.setX(0 + (i * 20));
			frogLive.setY(750);
			groups.getFrogLivesGroup().getChildren().add(frogLive);
		}
	}
	

	
	public void generateFly() {
		int[] endArray = {13, 141, 269, 398, 528};
		int index = (int) (Math.random() * endArray.length);
		add(new Fly(60, endArray[index], 96));
	}
	
	
	public Rectangle getRemainTime() {
		return remainTime;
	}
	
	
	@Override
	public void act(long now) {
		model.updateModel(now);
		if(model.isGenerateFly()) {
			generateFly();
		}
		if(model.getChangeRec() > 0) {
			getRemainTime().setWidth(200 * (1 - model.getChangeRec()));
		}
		if(model.isChangeScore()) {
			setNumber(model.getFrog().getPoints());
		}
		if(model.isChangePrev()) {
			setNumberPrev(model.getFrog().getPrev_points());
    		setScoreList(model.getFrog().getPoints());
    		createFrogLives();
		}
		if(model.isStop()) {
			stopMusic();
			stop();
			if(model.isSwitchToGameOver()) {
				GameOver gameover = new GameOver(model.getFrog());
				Scene scene  = new Scene(gameover, 600, 800);
				scene.getStylesheets().add("file:resource/application.css");
		    	DifficultyWindow.getStage().setScene(scene);
			}else {
				GameEngine gameEngine = new GameEngine(model.getLevel() + 1, model.getFrog().getPoints());
				Scene scene = new Scene(gameEngine.asView(), 600, 800);
				DifficultyWindow.getStage().setScene(scene);
			}
		}
    }
	
	public void playMusic() {
		String musicFile = "resource/song/Frogger Main Song Theme (loop).mp3";   
		Media sound = new Media(new File(musicFile).toURI().toString());
		mediaPlayer = new MediaPlayer(sound);
		mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
	    mediaPlayer.play();
	}
	
	public void stopMusic() {
		mediaPlayer.stop();
	}

	public void setNumber(int n) {
		groups.getCurrentScore().getChildren().clear();
    	int shift = 0;
    	if(n == 0) {
    		groups.getCurrentScore().getChildren().add(new Digit(0, 30, 450, 35));
    	}
    	while (n > 0) {
    		  int d = n / 10;
    		  int k = n - d * 10;
    		  n = d;
    		  groups.getCurrentScore().getChildren().add(new Digit(k, 30, 450 - shift, 35));
    		  shift+=30;
    	}
    	
    	
    }

	public void setNumberPrev(int n) {

		groups.getPreviousScore().getChildren().clear();
    	int shift = 0;
    	if(n == 0) {
    		groups.getPreviousScore().getChildren().add(new Digit(0, 30, 170, 35));
    	}
    	while (n > 0) {
    		  int d = n / 10;
    		  int k = n - d * 10;
    		  n = d;
    		  groups.getPreviousScore().getChildren().add(new Digit(k, 30, 170 - shift, 35));
    		  shift+=30;
    		}
    }
	
	public void setScoreList(int score) {
		groups.getScoreListGroup().getChildren().clear();
		ArrayList<String> list = model.getScoreList();
		model.getScoreList().add(Integer.toString(score));
		for(int i = 0; i < list.size(); i++) {
			 Label scoreLabel = new Label(i+1 + ": " + list.get(i));
			 scoreLabel.setTextFill(Color.CORNSILK);
			 int X = 0;
			 int Y = (20 + i * 20);
			 scoreLabel.setTranslateX(X);
			 scoreLabel.setTranslateY(Y);
			 groups.getScoreListGroup().getChildren().add(scoreLabel);
		}
	}
}

