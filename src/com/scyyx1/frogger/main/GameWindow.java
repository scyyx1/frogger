package com.scyyx1.frogger.main;

import com.scyyx1.frogger.background.BackgroundImage;
import com.scyyx1.frogger.digit.Digit;
import com.scyyx1.frogger.frog.Animal;
import com.scyyx1.frogger.frog.End;
import com.scyyx1.frogger.obstacle.Log;
import com.scyyx1.frogger.obstacle.Turtle;
import com.scyyx1.frogger.obstacle.WetTurtle;
import com.scyyx1.frogger.world.MyStage;

import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class GameWindow extends MyStage{
	AnimationTimer timer;
	Animal animal;
	private double width;
	private double height;
	public GameWindow(double width, double height) {
		
		setWidth(width);
		setHeight(height);
		//Obstacle obstacle = new Obstacle("file:src/p4_group_8_repo/truck1Right.png", 25, 25, 3);
		//Obstacle obstacle1 = new Obstacle("file:src/p4_group_8_repo/truck2Right.png", 100, 100,2 );
		//Obstacle obstacle2 = new Obstacle("file:src/p4_group_8_repo/truck1Right.png",0,  150, 1);
		BackgroundImage froggerback = new BackgroundImage("file:resource/backgrounds/iKogsKW.png", width, height);
	    
		add(froggerback);
		
		add(new Log("file:resource/logs/log3.png", 150, 0, 160, 0.75));
		add(new Log("file:resource/logs/log3.png", 150, 220, 160, 0.75));
		add(new Log("file:resource/logs/log3.png", 150, 440, 160, 0.75));
		//background.add(new Log("file:src/p4_group_8_repo/log3.png", 150, 0, 166, 0.75));
		add(new Log("file:resource/logs/logs.png", 250, 0, 260, -2));
		add(new Log("file:resource/logs/logs.png", 250, 400, 260, -2));
		//background.add(new Log("file:src/p4_group_8_repo/logs.png", 300, 800, 276, -2));
		add(new Log("file:resource/logs/log3.png", 150, 50, 300, 0.75));
		add(new Log("file:resource/logs/log3.png", 150, 270, 300, 0.75));
		add(new Log("file:resource/logs/log3.png", 150, 490, 300, 0.75));
		//background.add(new Log("file:src/p4_group_8_repo/log3.png", 150, 570, 329, 0.75));
		
		add(new Turtle(500, 350, -1, 130, 130));
		add(new Turtle(300, 350, -1, 130, 130));
		add(new WetTurtle(700, 350, -1, 130, 130));
		add(new WetTurtle(600, 200, -1, 130, 130));
		add(new WetTurtle(400, 200, -1, 130, 130));
		add(new WetTurtle(200, 200, -1, 130, 130));
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
		//End end2 = new End();
		//End end3 = new End();
		//End end4 = new End();
		//End end5 = new End();
		add(new End(13,96));
		add(new End(141,96));
		add(new End(141 + 141-13,96));
		add(new End(141 + 141-13+141-13+1,96));
		add(new End(141 + 141-13+141-13+141-13+3,96));
		animal = new Animal("file:resource/frogs/froggerUp.png");
		add(animal);
//		mainstage.add(new Obstacle("file:resource/vehicles/truck1"+"Right.png", 0, 649, 1, 120, 120));
//		mainstage.add(new Obstacle("file:resource/vehicles/truck1"+"Right.png", 300, 649, 1, 120, 120));
//		mainstage.add(new Obstacle("file:resource/vehicles/truck1"+"Right.png", 600, 649, 1, 120, 120));
		//background.add(new Obstacle("file:src/p4_group_8_repo/truck1"+"Right.png", 720, 649, 1, 120, 120));
//		mainstage.add(new Obstacle("file:resource/vehicles/car1Left.png", 100, 597, -1, 50, 50));
//		mainstage.add(new Obstacle("file:resource/vehicles/car1Left.png", 250, 597, -1, 50, 50));
//		mainstage.add(new Obstacle("file:resource/vehicles/car1Left.png", 400, 597, -1, 50, 50));
//		mainstage.add(new Obstacle("file:resource/vehicles/car1Left.png", 550, 597, -1, 50, 50));
//		mainstage.add(new Obstacle("file:resource/vehicles/truck2Right.png", 0, 540, 1, 200, 200));
//		mainstage.add(new Obstacle("file:resource/vehicles/truck2Right.png", 500, 540, 1, 200, 200));
//		mainstage.add(new Obstacle("file:resource/vehicles/car1Left.png", 500, 490, -1, 50, 50));
		add(new Digit(0, 30, 570, 30));
		//background.add(obstacle);
		//background.add(obstacle1);
		//background.add(obstacle2);
		start();
		start1();
	}
	
	/**
	 * 
	 */
	public void start1() {
		this.playMusic();
    	createTimer1();
        timer.start();
    }

    public void stop1() {
        timer.stop();
    }
    
    public void createTimer1() {
        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
            	if (animal.changeScore()) {
            		setNumber(animal.getPoints());
            	}
            	if (animal.getStop()) {
            		System.out.print("STOPP:");
            		stopMusic();
            		this.stop();
            		stop1();
    		    	ScoreWindow score = new ScoreWindow(animal, width, height);
    		    	Scene scene  = new Scene(score,width,height);
    		    	Main.getStage().setScene(scene);
            	}
            }
        };
    }
    
    
    public void setWidth(double width) {
    	this.width = width;
    }
    public void setHeight(double height) {
    	this.height = height;
    }
    /**
     * @param n
     */
    public void setNumber(int n) {
    	int shift = 0;
    	while (n > 0) {
    		  int d = n / 10;
    		  int k = n - d * 10;
    		  n = d;
    		  add(new Digit(k, 30, 570 - shift, 30));
    		  shift+=30;
    		}
    }
}
