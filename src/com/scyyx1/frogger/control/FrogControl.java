package com.scyyx1.frogger.control;

import java.util.ArrayList;

import com.scyyx1.frogger.model.Actor;
import com.scyyx1.frogger.model.Frog;
import com.scyyx1.frogger.obstacle_view.End;
import com.scyyx1.frogger.obstacle_view.FrogView;
import com.scyyx1.frogger.obstacle_view.Log;
import com.scyyx1.frogger.obstacle_view.Turtle;
import com.scyyx1.frogger.obstacle_view.Vehicle;
import com.scyyx1.frogger.obstacle_view.WetTurtle;

import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class FrogControl extends Actor{

	Frog frog;
	FrogView frogView;
	private int keyBoardPress = 0;
	public FrogControl(Frog frog, FrogView frogView) {
		this.frog = frog;
		this.frogView = frogView;
		
		checkKeyBoardCondition();
	}

	public void checkKeyBoardCondition() {
		frogView.setOnKeyPressed(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent event){
				
				if (!frog.isNoMove()) {
					if(event.getCode() == KeyCode.W) {
						if(frog.getW() > getY()) {
		                	keyBoardPress++;
		                }
						System.out.println(frog.isJump());
						if(frog.isJump()) {
							frog.setChangeScore(false);
							frog.setJump(false);
							frogView.update(frog.getImgW1(), 0, -frog.getMovement()*2);
						}else {
							frog.setJump(true);
							frogView.update(frog.getImgW2(), 0, -frog.getMovement()*2);
						}
					}
					else if (event.getCode() == KeyCode.S) {
						if(frog.isJump()) {
							frog.setJump(false);
							frogView.update(frog.getImgS1(), 0, frog.getMovement()*2);
						}else {
							frog.setJump(true);
							frogView.update(frog.getImgS2(), 0, frog.getMovement()*2);
						}
					}
					else if (event.getCode() == KeyCode.D) {
						if(frog.isJump()) {
							frog.setJump(false);
							frogView.update(frog.getImgD1(), frog.getMovementX()*2, 0);
						}else {
							frog.setJump(true);
							frogView.update(frog.getImgD2(), frog.getMovementX()*2, 0);
						}
					}
					else if (event.getCode() == KeyCode.A) {
						if(frog.isJump()) {
							frog.setJump(false);
							frogView.update(frog.getImgA1(), -frog.getMovementX()*2, 0);
						}else {
							frog.setJump(true);
							frogView.update(frog.getImgA2(), -frog.getMovementX()*2, 0);
						}
					}
				}
			}
		});	
		
		frogView.setOnKeyReleased(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent event) {
				if (!frog.isNoMove()) {
					if(event.getCode() == KeyCode.W) {
						if(frogView.getY() < frog.getW()) {
							frog.setPoints(frog.getPoints() + 10 * keyBoardPress);
							frog.setW(frogView.getY());
							frog.setChangeScore(true);
						}
						keyBoardPress = 0;
						frogView.update(frog.getImgW1());
						frog.setJump(false);
					}
					else if (event.getCode() == KeyCode.A) {
						frogView.update(frog.getImgA1());
						frog.setJump(false);
					}
					else if (event.getCode() == KeyCode.S) {
						frogView.update(frog.getImgS1());
						frog.setJump(false);
					}
					else if (event.getCode() == KeyCode.D) {
						frogView.update(frog.getImgD1());
						frog.setJump(false);
					}
				}
			}
			
		});
	}
	
	
	@Override
	public void act(long now) {
		
		boundaryCheck();
		// hit by car
		carDeathCheck(now);
		// drown in water
		waterDeathCheck(now);

		collisionCheck();
	}
	
	public void boundaryCheck() {
		if (frogView.getY()<0 || frogView.getY()>734) {
			frogView.setY(679.8+frog.getMovement());
		}
		if (frogView.getX()<0) {
			frogView.move(frog.getMovement()*2, 0);
		}
		if (frogView.getX()>600) {
			frogView.move(-frog.getMovement()*2, 0);
		}
	}
	
	public void carDeathCheck(long now) {
		int imgSize = frog.getImageSize();
		if (frog.isCarDeath()) {
			frog.setNoMove(true);
			if ((now)% 11 ==0) {
				frog.setCarD(frog.getCarD()+1);
			}
			if (frog.getCarD()==1) {
				frogView.setImage(new Image("file:resource/deaths/cardeath1.png", imgSize, imgSize, true, true));
			}
			if (frog.getCarD()==2) {
				frogView.setImage(new Image("file:resource/deaths/cardeath2.png", imgSize, imgSize, true, true));
			}
			if (frog.getCarD()==3) {
				frogView.setImage(new Image("file:resource/deaths/cardeath3.png", imgSize, imgSize, true, true));
			}
			if (frog.getCarD() == 4) {
				frogView.setX(300);
				frogView.setY(679.8+frog.getMovement());
				frog.setLives(frog.getLives()-1);
				frog.setCarDeath(false);
				frog.setCarD(0);
				frog.setDead(true);
				frogView.setImage(new Image("file:resource/frogs/froggerUp.png", imgSize, imgSize, true, true));
				frog.setNoMove(false);
				if (frog.getPoints()>50) {
					frog.setPoints(frog.getPoints() - 50);
					frog.setChangeScore(true);
				}
				frog.setPrev_points(frog.getPoints());
			}
			
		}
	}
	
	public void waterDeathCheck(long now) {
		int imgSize = frog.getImageSize();
		if (frog.isWaterDeath()) {
			frog.setNoMove(true);
			if ((now)% 11 ==0) {
				frog.setCarD(frog.getCarD()+1);
			}
			if (frog.getCarD()==1) {
				frogView.setImage(new Image("file:resource/deaths/waterdeath1.png", imgSize,imgSize , true, true));
			}
			if (frog.getCarD()==2) {
				frogView.setImage(new Image("file:resource/deaths/waterdeath2.png", imgSize,imgSize , true, true));
			}
			if (frog.getCarD()==3) {
				frogView.setImage(new Image("file:resource/deaths/waterdeath3.png", imgSize,imgSize , true, true));
			}
			if (frog.getCarD() == 4) {
				frogView.setImage(new Image("file:resource/deaths/waterdeath4.png", imgSize,imgSize , true, true));
			}
			if (frog.getCarD() == 5) {
				frogView.setX(300);
				frogView.setY(679.8+frog.getMovement());
				frog.setLives(frog.getLives()-1);
				frog.setWaterDeath(false);
				frog.setCarD(0);
				frog.setDead(true);
				frogView.setImage(new Image("file:resource/frogs/froggerUp.png", imgSize, imgSize, true, true));
				frog.setNoMove(false);
				if (frog.getPoints()>50) {
					frog.setPoints(frog.getPoints() - 50);
					frog.setChangeScore(true);
				}
				frog.setPrev_points(frog.getPoints());
				frogView.setImage(new Image("file:resource/frogs/froggerUp.png", imgSize, imgSize, true, true));
			}
			
		}
	}
	
	public void collisionCheck() {
		if (frogView.getIntersectingObjects(Vehicle.class).size() >= 1) {
			frog.setCarDeath(true);;
		}
		if (frogView.getX() == 240 && frogView.getY() == 82) {
			frog.setStop(true);
		}
		if (frogView.getIntersectingObjects(Log.class).size() >= 1 && !frog.isNoMove()) {
			if(frogView.getIntersectingObjects(Log.class).get(0).getLeft())
				frogView.move(-2,0);
			else
				frogView.move (.75,0);
		}
		else if (frogView.getIntersectingObjects(Turtle.class).size() >= 1 && !frog.isNoMove()) {
			frogView.move(-1,0);
		}
		else if (frogView.getIntersectingObjects(WetTurtle.class).size() >= 1) {
			if (frogView.getIntersectingObjects(WetTurtle.class).get(0).isSunk()) {
				frog.setWaterDeath(true);
			} else {
				frogView.move(-1,0);
			}
		}
		
		else if (frogView.getIntersectingObjects(End.class).size() >= 1) {
			frog.setInter((ArrayList<End>) frogView.getIntersectingObjects(End.class));
			// frog get into same end 
			if (frogView.getIntersectingObjects(End.class).get(0).isActivated()) {
				frog.setW(frogView.getY());
				Alert alert = new Alert(AlertType.ERROR);
        		alert.setTitle("HIT WRONG END");
        		alert.setContentText("This End is already been taken");
        		alert.show();
			}else {

				frog.setPoints(frog.getPoints() + 50);
				frog.setChangeScore(true);
				frog.setW(800);
				frogView.getIntersectingObjects(End.class).get(0).setEnd();
				frog.setEnd(frog.getEnd()+1);
			}
			frog.setPrev_points(frog.getPoints());
			frogView.setX(300);
			frogView.setY(679.8+frog.getMovement());
		}
		else if (frogView.getY()<413){
			frog.setWaterDeath(true);
			//setX(300);
			//setY(679.8+movement);
		}
	}
}

