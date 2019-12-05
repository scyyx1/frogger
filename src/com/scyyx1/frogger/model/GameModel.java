package com.scyyx1.frogger.model;

import java.util.ArrayList;

import com.scyyx1.frogger.obstacle_view.FrogView;
import com.scyyx1.frogger.obstacle_view.Vehicle;

import javafx.animation.AnimationTimer;

public class GameModel {

	private double width;
	private double height;
	private AnimationTimer timer;
	private Frog frog;
	private FrogView frogView;
	private int level;
	
	public GameModel() {
		
	}
	public FrogView getFrogView() {
		return frogView;
	}
	public void setFrogView(FrogView frogView) {
		this.frogView = frogView;
	}

	private ArrayList<String> scores = new ArrayList<>(); 
	public ArrayList<String> getScores() {
		return scores;
	}

	public void setScores(ArrayList<String> scores) {
		this.scores = scores;
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
	public void setFrog(Frog frog) {
		this.frog = frog;
	}
	public Frog getFrog() {
		return frog;
	}
	public int getLevel() {
		// TODO Auto-generated method stub
		return level;
	}
	public void setLevel(int level) {
		// TODO Auto-generated method stub
		 this.level = level;
	}
}
