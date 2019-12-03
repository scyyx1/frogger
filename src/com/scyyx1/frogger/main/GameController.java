package com.scyyx1.frogger.main;

import com.scyyx1.frogger.digit.Digit;
import com.scyyx1.frogger.frog.Animal;

import javafx.animation.AnimationTimer;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class GameController {

	private GameModel model;
	private GameWindow view;
	Group digits = new Group();
	Group prev_digits = new Group();
	Group frogLives = new Group();
	public GameController(GameModel model, GameWindow view) {
		this.model = model;
		this.view = view;
		createDigit();
		createFrogLives(frogLives);
		view.getChildren().add(frogLives);
		start();
	}
	
	public void updateWidth(double width) {
		model.setWidth(width);
	}
	
	public void updateHeight(double height) {
		model.setHeight(height);
	}
	
	public void start() {
		view.start();
		view.playMusic();
    	model.setTimer(createTimer(model.getAnimal()));
        model.getTimer().start();
    }
	
	public AnimationTimer createTimer(Animal animal) {

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
            	if(animal.isDead()) {
            		setNumberPrev(animal.getPrevPoints(), prev_digits);
            		createFrogLives(frogLives);
            		animal.setDead();
            	}
            	if (animal.changeScore()) {
            		setNumber(animal.getPoints(), digits);
            	}
            	if (animal.getStop()) {
            		System.out.print("STOPP:");
            		view.stopMusic();
            		view.stop();
            		stop1();
            		if(animal.getLives() == 0) {
            			GameOver gameover = new GameOver(animal);
            			Scene scene  = new Scene(gameover, 600, 800);
            			scene.getStylesheets().add("file:resource/application.css");
        		    	DifficultyWindow.getStage().setScene(scene);
            		}else {
            			WinGame winGame = new WinGame(animal);
	    		    	Scene scene  = new Scene(winGame, 600, 800);
	    		    	scene.getStylesheets().add("file:resource/application.css");
	    		    	DifficultyWindow.getStage().setScene(scene);
            		}
            	}
            }
        };
        return timer;
    }
	
	public void setNumber(int n, Group g) {
		g.getChildren().clear();
    	int shift = 0;
    	if(n == 0) {
    		g.getChildren().add(new Digit(0, 30, 450, 35));
    	}
    	while (n > 0) {
    		  int d = n / 10;
    		  int k = n - d * 10;
    		  n = d;
    		  g.getChildren().add(new Digit(k, 30, 450 - shift, 35));
    		  shift+=30;
    	}
    }
	
	public void setNumberPrev(int n, Group g) {
		g.getChildren().clear();
    	int shift = 0;
    	if(n == 0) {
    		g.getChildren().add(new Digit(0, 30, 170, 35));
    	}
    	while (n > 0) {
    		  int d = n / 10;
    		  int k = n - d * 10;
    		  n = d;
    		  g.getChildren().add(new Digit(k, 30, 170 - shift, 35));
    		  shift+=30;
    		}
    }
	
	public void stop1() {
        model.getTimer().stop();
    }
	
	public GameWindow asView() {
		return view;
	}
	
	public void createFrogLives(Group g) {
		g.getChildren().clear();
		int lives = model.getAnimal().getLives();
		for(int i = 0; i < lives; i++) {
			Image frog = new Image("file:resource/frogs/froggerUp.png", 20, 20, false, false);
			ImageView frogLive = new ImageView(frog);
			frogLive.setX(0 + (i * 20));
			frogLive.setY(750);
			g.getChildren().add(frogLive);
		}
	}
	
	public void createDigit() {
		setNumber(0, digits);
		view.getChildren().add(digits);
		setNumberPrev(0, prev_digits);
		view.getChildren().add(prev_digits);
	}
	
}

