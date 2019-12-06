package com.scyyx1.frogger.control;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import com.scyyx1.frogger.model.Actor;
import com.scyyx1.frogger.model.Frog;
import com.scyyx1.frogger.model.GameModel;
import com.scyyx1.frogger.obstacle_view.Digit;
import com.scyyx1.frogger.obstacle_view.Fly;
import com.scyyx1.frogger.view.DifficultyWindow;
import com.scyyx1.frogger.view.GameOver;
import com.scyyx1.frogger.view.GameWindow;
import com.scyyx1.frogger.view.WinGame;

import javafx.animation.AnimationTimer;
import javafx.beans.binding.DoubleBinding;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class GameController{

	private GameModel model;
	private GameWindow view;
	private GameController controller;
	int count = 0;
	ProgressBar progress;
	private Rectangle time;
	DoubleProperty tp = new SimpleDoubleProperty(1.0);
	private long startTime;
	public int fly = 1;
	public GameController(GameModel model, GameWindow view) {
		this.model = model;
		this.view = view;
		Label label = new Label("TIME");
		label.setLayoutX(320);
		label.setLayoutY(755);
		label.setFont(Font.font("Mouse", FontWeight.BOLD, 30));
		label.setTextFill(Color.DARKGREEN);
        view.getChildren().add(label);
		time = new Rectangle(200, 30, Color.DARKGREEN);
		time.setX(400);
		time.setY(760);
		startTime = System.nanoTime();
		
		view.getChildren().add(time);
		start();
		
	}
	

	public void updateWidth(double width) {
		model.setWidth(width);
	}
	
	public void updateHeight(double height) {
		model.setHeight(height);
	}
	
	public void start() {

		setNumber(0, view.getScoreGroup());
		setNumberPrev(0, view.getPreviousScoreGroup());
		createFrogLives(view.getFrogLives());
		view.start();
		view.playMusic();
    	model.setTimer(createTimer(model.getFrog()));
        model.getTimer().start();
    }
	
	public AnimationTimer createTimer(Frog frog) {

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
            	double elapsedTime =  (now - startTime) / 1000000000.0;
            	if(elapsedTime < 30) {
            		if(elapsedTime > 5 && fly > 0) {
            			generateFly();
            			fly = 0;
            		}
            		time.setWidth(200 * (1 - elapsedTime / 30));
            	}else {
            		frog.setLives(0);
            	}
            	if(frog.isDead()) {
            		setNumberPrev(frog.getPrevPoints(), view.getPreviousScoreGroup());
            		setScoreList(frog.getPoints());
            		createFrogLives(view.getFrogLives());
            		frog.setDead();
            	}
            	if (frog.changeScore()) {
            		setNumber(frog.getPoints(), view.getScoreGroup());
            	}
            	if (frog.getStop()) {
            		System.out.print("STOPP:");
            		view.stopMusic();
            		view.stop();
            		stop1();
            		if(frog.getLives() == 0) {
            			GameOver gameover = new GameOver(frog);
            			Scene scene  = new Scene(gameover, 600, 800);
            			scene.getStylesheets().add("file:resource/application.css");
        		    	DifficultyWindow.getStage().setScene(scene);
            		}else {
            			model.setLevel(model.getLevel()+1);
            			GameWindow gameWindow = new GameWindow(model, model.getLevel());
            			model.getFrog().setLives(frog.getLives());
            			model.getFrog().setPoints(frog.getPoints());
            			controller = new GameController(model, gameWindow);
            			Scene scene = new Scene(gameWindow, 600, 800);
            			DifficultyWindow.getStage().setScene(scene);
            		}
            	}
            }
        };
        return timer;
    }
	
	public void setNumber(int n, Group group) {
		group.getChildren().clear();
    	int shift = 0;
    	if(n == 0) {
    		group.getChildren().add(new Digit(0, 30, 450, 35));
    	}
    	while (n > 0) {
    		  int d = n / 10;
    		  int k = n - d * 10;
    		  n = d;
    		  group.getChildren().add(new Digit(k, 30, 450 - shift, 35));
    		  shift+=30;
    	}
    }
	
	public void setNumberPrev(int n, Group group) {
		group.getChildren().clear();
    	int shift = 0;
    	if(n == 0) {
    		group.getChildren().add(new Digit(0, 30, 170, 35));
    	}
    	while (n > 0) {
    		  int d = n / 10;
    		  int k = n - d * 10;
    		  n = d;
    		  group.getChildren().add(new Digit(k, 30, 170 - shift, 35));
    		  shift+=30;
    		}
    }
	
	public void stop1() {
        model.getTimer().stop();
    }
	
	public void createFrogLives(Group group) {
		group.getChildren().clear();
		int lives = model.getFrog().getLives();
		for(int i = 0; i < lives; i++) {
			Image frog = new Image("file:resource/frogs/froggerUp.png", 20, 20, false, false);
			ImageView frogLive = new ImageView(frog);
			frogLive.setX(0 + (i * 20));
			frogLive.setY(750);
			group.getChildren().add(frogLive);
		}
	}
	
	
	public void setScoreList(int score) {
		view.getLabelGroup().getChildren().clear();
		model.getScores().add(Integer.toString(score));
		for(int i = 0; i < model.getScores().size(); i++) {
			 Label scoreLabel = new Label(i+1 + ": " + model.getScores().get(i));
			 scoreLabel.setTextFill(Color.CORNSILK);
			 int X = 0;
			 int Y = (20 + i * 20);
			 scoreLabel.setTranslateX(X);
			 scoreLabel.setTranslateY(Y);
	         view.getLabelGroup().getChildren().add(scoreLabel);
		}
	}
	
	public void generateFly() {
		int[] endArray = {13, 141, 269, 398, 528};
		int index = (int) (Math.random() * endArray.length);
		view.add(new Fly(60, endArray[index], 96));
	}
	
	
	
}

