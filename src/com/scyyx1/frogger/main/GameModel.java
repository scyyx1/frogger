package com.scyyx1.frogger.main;

import com.scyyx1.frogger.frog.Animal;

import javafx.animation.AnimationTimer;

public class GameModel {

	private double width;
	private double height;
	private AnimationTimer timer;
	private Animal animal;
	
	public Animal getAnimal() {
		return animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}

	public AnimationTimer getTimer() {
		return timer;
	}

	public void setTimer(AnimationTimer timer) {
		this.timer = timer;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getWidth() {
		return width;
	}
	
	public void setWidth(double width) {
		this.width = width;
	}
}
