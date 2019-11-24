package com.scyyx1.frogger.background;

import com.scyyx1.frogger.frog.Actor;

import javafx.scene.image.Image;

public class BackgroundImage extends Actor{


	
	@Override
	public void act(long now) {
		
		
	}
	
	public BackgroundImage(String imageLink, double width, double height) {
		setImage(new Image(imageLink, width, height, false, false));
	}


}
