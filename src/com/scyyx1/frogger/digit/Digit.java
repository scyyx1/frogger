package com.scyyx1.frogger.digit;

import com.scyyx1.frogger.frog.Actor;

import javafx.scene.image.Image;

public class Digit extends Actor{
	int dim;
	Image im1;
	@Override
	public void act(long now) {
		// TODO Auto-generated method stub
		
	}
	
	public Digit(int n, int dim, int x, int y) {
		im1 = new Image("file:resource/digits"+n+".png", dim, dim, true, true);
		setImage(im1);
		setX(x);
		setY(y);
	}
	
}
