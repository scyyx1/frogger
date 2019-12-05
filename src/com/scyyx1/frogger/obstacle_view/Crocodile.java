package com.scyyx1.frogger.obstacle_view;

import com.scyyx1.frogger.model.Actor;

import javafx.scene.image.Image;

public class Crocodile extends Actor {

	private Image crocodile1;
	private Image crocodile2;
	private Image crocodile3;
	private CrocodileHead crocodileHead;

	private int speed;
	@Override
	public void act(long now) {
		// TODO Auto-generated method stub
		if (now/900000000  % 2 ==0) {
			setImage(crocodile2);
			
		}
		else if (now/900000000 % 2 == 1) {
			setImage(crocodile1);
		}
	
		move(speed , 0);
		if (getX() > 600 && speed>0)
			setX(-200);
		if (getX() < -75 && speed<0)
			setX(600);

	}

	public Crocodile(int xpos, int ypos, int speed, int width, int height) {
		crocodile1 = new Image("file:resource/turtleAnimations/TurtleAnimation1.png", width, height, true, true);
		crocodile2 = new Image("file:resource/turtleAnimations/TurtleAnimation2.png", width, height, true, true);
		
		setX(xpos);
		setY(ypos);
		this.speed = speed;
		setImage(crocodile2);
	}
}
