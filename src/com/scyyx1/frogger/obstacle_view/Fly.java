package com.scyyx1.frogger.obstacle_view;

import com.scyyx1.frogger.model.Actor;

import javafx.scene.image.Image;

public class Fly extends Actor {

	@Override
	public void act(long now) {
		// TODO Auto-generated method stub

	}
	
	public Fly(int dim, int x, int y) {
		Image image = new Image("file:resource/fly/fly.png", dim, dim, true, true);
		setImage(image);
		setX(x);
		setY(y);
	}

}
