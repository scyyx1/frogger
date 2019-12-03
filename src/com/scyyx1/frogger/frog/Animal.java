package com.scyyx1.frogger.frog;

import java.util.ArrayList;

import com.scyyx1.frogger.obstacle.*;

import javafx.event.EventHandler;

import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;


public class Animal extends Actor {
	Image imgW1;
	Image imgA1;
	Image imgS1;
	Image imgD1;
	Image imgW2;
	Image imgA2;
	Image imgS2;
	Image imgD2;
	int points = 0;
	int end = 0;
	private boolean second = false;
	boolean noMove = false;
	double movement = 13.3333333*2;
	double movementX = 10.666666*2;
	int imgSize = 40;
	boolean carDeath = false;
	boolean waterDeath = false;
	boolean dead = false;
	boolean stop = false;
	int lives = 3;
	boolean changeScore = false;
	private int prev_points = 0;
	int carD = 0;
	int count = 0;
	double w = 800;
	ArrayList<End> inter = new ArrayList<End>();
	public Animal(String imageLink) {
		setImage(new Image(imageLink, imgSize, imgSize, true, true));
		setX(300);
		setY(679.8+movement);
		imgW1 = new Image("file:resource/frogs/froggerUp.png", imgSize, imgSize, true, true);
		imgA1 = new Image("file:resource/frogs/froggerLeft.png", imgSize, imgSize, true, true);
		imgS1 = new Image("file:resource/frogs/froggerDown.png", imgSize, imgSize, true, true);
		imgD1 = new Image("file:resource/frogs/froggerRight.png", imgSize, imgSize, true, true);
		imgW2 = new Image("file:resource/frogs/froggerUpJump.png", imgSize, imgSize, true, true);
		imgA2 = new Image("file:resource/frogs/froggerLeftJump.png", imgSize, imgSize, true, true);
		imgS2 = new Image("file:resource/frogs/froggerDownJump.png", imgSize, imgSize, true, true);
		imgD2 = new Image("file:resource/frogs/froggerRightJump.png", imgSize, imgSize, true, true);
		setOnKeyPressed(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent event){
				if (noMove) {
					
				}
				else {
				// long press 
				if (second) {
					if (event.getCode() == KeyCode.W) {	  
		                move(0, -movement*2);
		                if(w > getY()) {
		                	count++;
		                }
		                changeScore = false;
		                setImage(imgW1);
		                second = false;
		            }
		            else if (event.getCode() == KeyCode.A) {	            	
		            	 move(-movementX, 0);
		            	 setImage(imgA1);
		            	 second = false;
		            }
		            else if (event.getCode() == KeyCode.S) {	            	
		            	 move(0, movement*2);
		            	 setImage(imgS1);
		            	 second = false;
		            }
		            else if (event.getCode() == KeyCode.D) {	            	
		            	 move(movementX, 0);
		            	 setImage(imgD1);
		            	 second = false;
		            }
				}
				// single press
				else if (event.getCode() == KeyCode.W) {	            	
	                move(0, -movement*2);
	                setImage(imgW2);
	                if(w > getY()) {
	                	count++;
	                }
	                second = true;
	            }
	            else if (event.getCode() == KeyCode.A) {	            	
	            	 move(-movementX*2, 0);
	            	 setImage(imgA2);
	            	 second = true;
	            }
	            else if (event.getCode() == KeyCode.S) {	            	
	            	 move(0, movement*2);
	            	 setImage(imgS2);
	            	 second = true;
	            }
	            else if (event.getCode() == KeyCode.D) {	            	
	            	 move(movementX*2, 0);
	            	 setImage(imgD2);
	            	 second = true;
	            }
	        }
			}
		});	
		setOnKeyReleased(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent event) {
				if (noMove) {}
				else {
				if (event.getCode() == KeyCode.W) {	  
					System.out.println(w + ", " + getY());
					if (getY() < w) {
						changeScore = true;
						points+=10 * count;
						w = getY();
						count = 0;
					}
	                //move(0, -movement);
	                setImage(imgW1);
	                second = false;
	            }
	            else if (event.getCode() == KeyCode.A) {	            	
	            	 //move(-movementX, 0);
	            	 setImage(imgA1);
	            	 second = false;
	            }
	            else if (event.getCode() == KeyCode.S) {	            	
	            	 //move(0, movement);
	            	 setImage(imgS1);
	            	 second = false;
	            }
	            else if (event.getCode() == KeyCode.D) {	            	
	            	 //move(movementX, 0);
	            	 setImage(imgD1);
	            	 second = false;
	            }
	        }
			}
			
		});
	}
	
	@Override
	public void act(long now) {
		int bounds = 0;
		// check whether the frog head the boundary
		if (getY()<0 || getY()>734) {
			//setX(300);
			setY(679.8+movement);
		}
		// when frog head to left wall bounce back
		if (getX()<0) {
			move(movement*2, 0);
		}
		// hit by car
		if (carDeath) {
			noMove = true;
			if ((now)% 11 ==0) {
				carD++;
			}
			if (carD==1) {
				setImage(new Image("file:resource/deaths/cardeath1.png", imgSize, imgSize, true, true));
			}
			if (carD==2) {
				setImage(new Image("file:resource/deaths/cardeath2.png", imgSize, imgSize, true, true));
			}
			if (carD==3) {
				setImage(new Image("file:resource/deaths/cardeath3.png", imgSize, imgSize, true, true));
			}
			if (carD == 4) {
				setX(300);
				setY(679.8+movement);
				lives--;
				carDeath = false;
				carD = 0;
				dead = true;
				setImage(new Image("file:resource/frogs/froggerUp.png", imgSize, imgSize, true, true));
				noMove = false;
				if (points>50) {
					points-=50;
					prev_points = points;
					changeScore = true;
				}
			}
			
		}
		// drown in water
		if (waterDeath) {
			noMove = true;
			if ((now)% 11 ==0) {
				carD++;
			}
			if (carD==1) {
				setImage(new Image("file:resource/deaths/waterdeath1.png", imgSize,imgSize , true, true));
			}
			if (carD==2) {
				setImage(new Image("file:resource/deaths/waterdeath2.png", imgSize,imgSize , true, true));
			}
			if (carD==3) {
				setImage(new Image("file:resource/deaths/waterdeath3.png", imgSize,imgSize , true, true));
			}
			if (carD == 4) {
				setImage(new Image("file:resource/deaths/waterdeath4.png", imgSize,imgSize , true, true));
			}
			if (carD == 5) {
				setX(300);
				setY(679.8+movement);
				waterDeath = false;
				carD = 0;
				lives--;
				dead = true;
				setImage(new Image("file:resource/frogs/froggerUp.png", imgSize, imgSize, true, true));
				noMove = false;
				if (points>50) {
					points-=50;
					prev_points = points;
					changeScore = true;
				}
			}
			
		}
		
		// when frog head to right wall
		if (getX()>600) {
			move(-movement*2, 0);
		}
		if (getIntersectingObjects(Vehicle.class).size() >= 1) {
			carDeath = true;
		}
		if (getX() == 240 && getY() == 82) {
			stop = true;
		}
		if (getIntersectingObjects(Log.class).size() >= 1 && !noMove) {
			if(getIntersectingObjects(Log.class).get(0).getLeft())
				move(-2,0);
			else
				move (.75,0);
		}
		else if (getIntersectingObjects(Turtle.class).size() >= 1 && !noMove) {
			move(-1,0);
		}
		else if (getIntersectingObjects(WetTurtle.class).size() >= 1) {
			if (getIntersectingObjects(WetTurtle.class).get(0).isSunk()) {
				waterDeath = true;
			} else {
				move(-1,0);
			}
		}
		
		else if (getIntersectingObjects(End.class).size() >= 1) {
			inter = (ArrayList<End>) getIntersectingObjects(End.class);
			// frog get into same end 
			if (getIntersectingObjects(End.class).get(0).isActivated()) {
				w = getY();
				System.out.println(points + " "+ end);
			}else {
				points+=50;
				changeScore = true;
				w=800;
				getIntersectingObjects(End.class).get(0).setEnd();
				end++;
			}
			prev_points = points;
			setX(300);
			setY(679.8+movement);
		}
		else if (getY()<413){
			waterDeath = true;
			//setX(300);
			//setY(679.8+movement);
		}
	}
	public boolean getStop() {
		return (lives == 0 || end == 3);
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

}
