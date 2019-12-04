package com.scyyx1.frogger.control;

import java.util.ArrayList;

import com.scyyx1.frogger.model.Actor;
import com.scyyx1.frogger.model.Frog;
import com.scyyx1.frogger.model.GameModel;
import com.scyyx1.frogger.obstacle_view.Digit;
import com.scyyx1.frogger.view.GameWindow;

import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class GameController{

	private GameModel model;
	private GameWindow view;
	int count = 0;
	//FrogControl frogControl;
	
	public GameController(GameModel model, GameWindow view) {
		this.model = model;
		this.view = view;
		FrogControl frogControl = new FrogControl(model.getFrog(), model.getFrogView());
		view.add(frogControl);
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
//            			GameOver gameover = new GameOver(frog);
//            			Scene scene  = new Scene(gameover, 600, 800);
//            			scene.getStylesheets().add("file:resource/application.css");
//        		    	DifficultyWindow.getStage().setScene(scene);
            		}else {
//            			WinGame winGame = new WinGame(frog);
//	    		    	Scene scene  = new Scene(winGame, 600, 800);
//	    		    	scene.getStylesheets().add("file:resource/application.css");
//	    		    	DifficultyWindow.getStage().setScene(scene);
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
	
	
}

