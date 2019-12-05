package com.scyyx1.frogger.obstacle_view;

import com.scyyx1.frogger.model.Actor;
import com.scyyx1.frogger.model.Frog;

import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;

public class FrogView extends Actor{

	private Frog frog;
	public FrogView(String imageLink) {
		frog = new Frog();
		setImage(new Image(imageLink, frog.getImageSize(), frog.getImageSize(), true, true));
		setX(300);
		setY(679.8+frog.getMovement());
	}
	@Override
	public void act(long now) {
		// TODO Auto-generated method stub
		
	}
	
	public void update(Image image, double x, double y) {
		move(x, y);
		setImage(image);
	}
	
	public void update(Image image) {
		setImage(image);
	}
	public Frog getFrog() {
		return frog;
	}

}
