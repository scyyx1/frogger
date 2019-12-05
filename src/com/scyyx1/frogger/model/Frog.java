package com.scyyx1.frogger.model;

import java.util.ArrayList;

import com.scyyx1.frogger.obstacle_view.End;

import javafx.scene.image.Image;

public class Frog extends Actor{

	private int points;
	private int end = 0;
	private boolean jump = false;
	private boolean noMove = false;
	private double movement = 13.3333333*2;
	private double movementX = 10.666666*2;
	private boolean carDeath = false;
	private boolean waterDeath = false;
	private boolean dead = false;
	private boolean stop = false;
	private int lives = 3;
	private boolean changeScore = false;
	private int prev_points = 0;
	private int carD = 0;
	private int count = 0;
	private double w = 800;
	private int imageSize = 40;
	private boolean eatFly = false;
	private boolean crocodileDeath = true;



	public boolean isCrocodileDeath() {
		return crocodileDeath;
	}


	public void setCrocodileDeath(boolean crocodileDeath) {
		this.crocodileDeath = crocodileDeath;
	}


	public boolean isEatFly() {
		return eatFly;
	}


	public void setEatFly(boolean eatFly) {
		this.eatFly = eatFly;
	}

	ArrayList<End> inter = new ArrayList<End>();
	
	
	private Image imgW1;
	private Image imgA1;
	private Image imgS1;
	private Image imgD1;
	private Image imgW2;
	private Image imgA2;
	private Image imgS2;
	private Image imgD2;
	int imgSize = 40;
	public Frog() {
		imgW1 = new Image("file:resource/frogs/froggerUp.png", imgSize, imgSize, true, true);
		imgA1 = new Image("file:resource/frogs/froggerLeft.png", imgSize, imgSize, true, true);
		imgS1 = new Image("file:resource/frogs/froggerDown.png", imgSize, imgSize, true, true);
		imgD1 = new Image("file:resource/frogs/froggerRight.png", imgSize, imgSize, true, true);
		imgW2 = new Image("file:resource/frogs/froggerUpJump.png", imgSize, imgSize, true, true);
		imgA2 = new Image("file:resource/frogs/froggerLeftJump.png", imgSize, imgSize, true, true);
		imgS2 = new Image("file:resource/frogs/froggerDownJump.png", imgSize, imgSize, true, true);
		imgD2 = new Image("file:resource/frogs/froggerRightJump.png", imgSize, imgSize, true, true);
	}
	
	
	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	public boolean isJump() {
		return jump;
	}

	public void setJump(boolean jump) {
		this.jump = jump;
	}

	public boolean isNoMove() {
		return noMove;
	}

	public void setNoMove(boolean noMove) {
		this.noMove = noMove;
	}

	public double getMovement() {
		return movement;
	}

	public void setMovement(double movement) {
		this.movement = movement;
	}

	public double getMovementX() {
		return movementX;
	}

	public void setMovementX(double movementX) {
		this.movementX = movementX;
	}

	public boolean isCarDeath() {
		return carDeath;
	}

	public void setCarDeath(boolean carDeath) {
		this.carDeath = carDeath;
	}

	public boolean isWaterDeath() {
		return waterDeath;
	}

	public void setWaterDeath(boolean waterDeath) {
		this.waterDeath = waterDeath;
	}

	public boolean isChangeScore() {
		return changeScore;
	}

	public void setChangeScore(boolean changeScore) {
		this.changeScore = changeScore;
	}

	public int getPrev_points() {
		return prev_points;
	}

	public void setPrev_points(int prev_points) {
		this.prev_points = prev_points;
	}

	public int getCarD() {
		return carD;
	}

	public void setCarD(int carD) {
		this.carD = carD;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public double getW() {
		return w;
	}

	public void setW(double w) {
		this.w = w;
	}

	public ArrayList<End> getInter() {
		return inter;
	}

	public void setInter(ArrayList<End> inter) {
		this.inter = inter;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public void setDead(boolean dead) {
		this.dead = dead;
	}

	public void setStop(boolean stop) {
		this.stop = stop;
	}

	public void setLives(int lives) {
		this.lives = lives;
	}

	public boolean getStop() {
		return (lives == 0 || end == 1);
	}
	
	public int getPoints() {
		return points;
	}
	
	public int getPrevPoints() {
		return prev_points;
	}
	public int getLives() {
		return lives;
	}
	public boolean changeScore() {
		if (changeScore) {
			changeScore = false;
			return true;
		}
		return false;
		
	}
	public boolean isDead() {
		return dead;
	}
	public void setDead() {
		this.dead = false;
	}
	
	public Image getImgW1() {
		return imgW1;
	}
	public Image getImgA1() {
		return imgA1;
	}
	public Image getImgS1() {
		return imgS1;
	}
	public Image getImgD1() {
		return imgD1;
	}
	public Image getImgW2() {
		return imgW2;
	}
	public Image getImgA2() {
		return imgA2;
	}
	public Image getImgS2() {
		return imgS2;
	}
	public Image getImgD2() {
		return imgD2;
	}

	public int getImageSize() {
		return imageSize;
	}

	@Override
	public void act(long now) {
		// TODO Auto-generated method stub
		
	}
	
}

