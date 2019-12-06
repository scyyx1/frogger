package com.scyyx1.frogger.obstacle_view;

import com.scyyx1.frogger.model.Actor;

import javafx.scene.image.Image;

public class CrocodileHead extends Actor {

	private Image crocodileHead1;
	private Image crocodileHead2;
	private int speed;
	private boolean eaten;
	public boolean isEaten() {
		return eaten;
	}
	@Override
	public void act(long now) {
		// TODO Auto-generated method stub
		if (now/900000000 % 2 == 1) {
			setImage(crocodileHead1);
			eaten = true;
		}else if (now/900000000 % 2 == 0){
			setImage(crocodileHead2);
			eaten = false;
		}
	
		move(speed , 0);
		if (getX() > 600 && speed>0)
			setX(-200);
		if (getX() < -75 && speed<0)
			setX(600);

	}
	
	public CrocodileHead(int xpos, int ypos, int speed, int width, int height) {
		crocodileHead1 = new Image("file:resource/turtleAnimations/TurtleAnimation4Wet.png", width, height, true, true);
		crocodileHead2 = new Image("file:resource/turtleAnimations/TurtleAnimation2.png", width, height, true, true);
		setX(xpos);
		setY(ypos);
		this.speed = speed;
		setImage(crocodileHead2);
	}

}