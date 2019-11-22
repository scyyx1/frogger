package com.scyyx1.frogger.background;

import com.scyyx1.frogger.frog.Actor;

import javafx.scene.image.Image;

public class BackgroundImage extends Actor{

	private double width;
	private double height;
	
	@Override
	public void act(long now) {
		
		
	}
	
	public BackgroundImage(String imageLink, double width, double height) {
		setWidth(width);
		setHeight(height);
		setImage(new Image(imageLink, width, height, true, true));
		
	}
	
	public void setWidth(double width) {
		this.width = width;
	}
	
	public void setHeight(double height) {
		this.height = height;
	}
	
	@Override
	public double getWidth() {
		return this.width;
	}
	
	@Override
	public double getHeight() {
		return this.height;
	}

}
