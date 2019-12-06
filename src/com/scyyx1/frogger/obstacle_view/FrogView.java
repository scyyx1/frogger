package com.scyyx1.frogger.obstacle_view;

import java.util.ArrayList;

import com.scyyx1.frogger.control.FrogControl;
import com.scyyx1.frogger.model.Actor;
import com.scyyx1.frogger.model.DeathChecking;
import com.scyyx1.frogger.model.Frog;

import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class FrogView extends Actor{

	private Frog frog;
	private FrogControl controller;
	public FrogView(String imageLink) {
		frog = new Frog();
		controller = new FrogControl(frog, this);
		init();
		checkKeyBoardCondition();
	}
	
	@Override
	public void act(long now) {
		
		boundaryCheck();
		collisionCheck();
		checkDeath(now);

		
	}
	
	public void updateStatus(Image image, double x, double y) {
		move(x, y);
		setImage(image);
	}
	
	public void update(Image image) {
		setImage(image);
	}
	
	public Frog getFrog() {
		return frog;
	}
	
	public void checkKeyBoardCondition() {

		setOnKeyPressed(e->{
			controller.checkKeyBoardPress(e);
		});
		
		setOnKeyReleased(e->{
			controller.checkKeyBoardRelease(e);
		});
	}

	public void boundaryCheck() {
		if (getY()<0 || getY()>734) {
			setY(679.8+frog.getMovement());
		}
		if (getX()<0) {
			move(frog.getMovement()*2, 0);
		}
		if (getX()>600) {
			move(-frog.getMovement()*2, 0);
		}
	}
	
	public void checkDeath(long now) {
		DeathChecking death = new DeathChecking(frog);
		int carDeath = death.carDeathCheck(now);
		if(carDeath != 0) {
			if(carDeath == 4) {
				init();
			}else {
				setImage(new Image("file:resource/deaths/cardeath" + carDeath + ".png", frog.getImageSize(), frog.getImageSize(), true, true));
			}
		}
		int waterDeath = death.waterDeathCheck(now);
		if(waterDeath != 0) {
			if(waterDeath == 5) {
				init();
			}else {
				setImage(new Image("file:resource/deaths/waterdeath" + waterDeath + ".png", frog.getImageSize(), frog.getImageSize(), true, true));
			}
		}
	}
	
	public void collisionCheck() {
		if (getIntersectingObjects(Vehicle.class).size() >= 1) {
			frog.setCarDeath(true);;
		}
		if (getX() == 240 && getY() == 82) {
			frog.setStop(true);
		}
		if (getIntersectingObjects(Log.class).size() >= 1 && !frog.isNoMove()) {
			if(getIntersectingObjects(Log.class).get(0).getLeft())
				move(-2,0);
			else
				move (.75,0);
		}
		else if (getIntersectingObjects(Turtle.class).size() >= 1 && !frog.isNoMove()) {
			move(-1,0);
		}
		else if (getIntersectingObjects(WetTurtle.class).size() >= 1) {
			if (getIntersectingObjects(WetTurtle.class).get(0).isSunk()) {
				frog.setWaterDeath(true);
			} else {
				move(-1,0);
			}
		}
		else if(getIntersectingObjects(Crocodile.class).size() >=  1) {
			move(1, 0);
		}
		else if(getIntersectingObjects(CrocodileHead.class).size() >= 1) {
			if (getIntersectingObjects(CrocodileHead.class).get(0).isEaten()) {
				frog.setWaterDeath(true);
			}else {
				move(-1, 0);
			}
		}
		else if (getIntersectingObjects(End.class).size() >= 1) {
			frog.setInter((ArrayList<End>) getIntersectingObjects(End.class));
			// frog get into same end 
			if (getIntersectingObjects(End.class).get(0).isActivated()) {
				frog.setW(getY());
				Alert alert = new Alert(AlertType.ERROR);
        		alert.setTitle("HIT WRONG END");
        		alert.setContentText("This End is already been taken");
        		alert.show();
			}else {
				if(getIntersectingObjects(Fly.class).size() >= 1) {
					frog.setPoints(frog.getPoints() + 200);
					frog.setEatFly(true);
				}
				frog.setPoints(frog.getPoints() + 50);
				frog.setChangeScore(true);
				frog.setW(800);
				getIntersectingObjects(End.class).get(0).setEnd();
				frog.setEnd(frog.getEnd()+1);
			}
			frog.setPrev_points(frog.getPoints());
			init();
		}
		else if (getY()<413){
			frog.setWaterDeath(true);
		}
	}
	
	public void init() {
		setX(300);
		setY(679.8+frog.getMovement());
		setImage(new Image("file:resource/frogs/froggerUp.png", frog.getImageSize(), frog.getImageSize(), true, true));

	}
	
	

}
