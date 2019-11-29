package com.scyyx1.frogger.main;

import com.scyyx1.frogger.digit.Digit;
import com.scyyx1.frogger.frog.Animal;

import javafx.animation.AnimationTimer;
import javafx.scene.Scene;

public class GameController {

	private GameModel model;
	private GameWindow view;
	
	public GameController(GameModel model, GameWindow view) {
		this.model = model;
		this.view = view;
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
            	if (animal.changeScore()) {
            		setNumber(animal.getPoints());
            		if(animal.isDead()) {
            			setNumberPrev(animal.getPoints());
            			animal.setDead();
            		}
            	}
            	if (animal.getStop()) {
            		System.out.print("STOPP:");
            		view.stopMusic();
            		view.stop();
            		stop1();
            		WinGame winGame = new WinGame(animal);
    		    	Scene scene  = new Scene(winGame, 600, 800);
    		    	StartWindow.getStage().setScene(scene);
            	}
            }
        };
        return timer;
    }
	
	public void setNumber(int n) {
    	int shift = 0;
    	while (n > 0) {
    		  int d = n / 10;
    		  int k = n - d * 10;
    		  n = d;
    		  view.add(new Digit(k, 30, 450 - shift, 35));
    		  shift+=30;
    		}
    }
	
	public void setNumberPrev(int n) {
    	int shift = 0;
    	while (n > 0) {
    		  int d = n / 10;
    		  int k = n - d * 10;
    		  n = d;
    		  view.add(new Digit(k, 30, 170 - shift, 35));
    		  shift+=30;
    		}
    }
	
	public void stop1() {
        model.getTimer().stop();
    }
	
	public GameWindow asView() {
		return view;
	}
}

