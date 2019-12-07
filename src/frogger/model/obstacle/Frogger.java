package frogger.model.obstacle;

import java.util.ArrayList;

import frogger.model.Actor;
import frogger.model.DeathChecking;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;

public class Frogger extends Actor {

	
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
	private double w = 800;
	private int imageSize = 40;
	private boolean eatFly = false;
	private boolean crocodileDeath = true;
	int imgSize = 40;
	private Image imgW1;
	private Image imgA1;
	private Image imgS1;
	private Image imgD1;
	private Image imgW2;
	private Image imgA2;
	private Image imgS2;
	private Image imgD2;
	private ArrayList<End> inter = new ArrayList<End>();
	
	public Frogger(int points) {
		imgW1 = new Image("file:resource/frogs/froggerUp.png", imgSize, imgSize, true, true);
		imgA1 = new Image("file:resource/frogs/froggerLeft.png", imgSize, imgSize, true, true);
		imgS1 = new Image("file:resource/frogs/froggerDown.png", imgSize, imgSize, true, true);
		imgD1 = new Image("file:resource/frogs/froggerRight.png", imgSize, imgSize, true, true);
		imgW2 = new Image("file:resource/frogs/froggerUpJump.png", imgSize, imgSize, true, true);
		imgA2 = new Image("file:resource/frogs/froggerLeftJump.png", imgSize, imgSize, true, true);
		imgS2 = new Image("file:resource/frogs/froggerDownJump.png", imgSize, imgSize, true, true);
		imgD2 = new Image("file:resource/frogs/froggerRightJump.png", imgSize, imgSize, true, true);
		
		this.points = points;
		init();
	}
	public Frogger() {
		imgW1 = new Image("file:resource/frogs/froggerUp.png", imgSize, imgSize, true, true);
		imgA1 = new Image("file:resource/frogs/froggerLeft.png", imgSize, imgSize, true, true);
		imgS1 = new Image("file:resource/frogs/froggerDown.png", imgSize, imgSize, true, true);
		imgD1 = new Image("file:resource/frogs/froggerRight.png", imgSize, imgSize, true, true);
		imgW2 = new Image("file:resource/frogs/froggerUpJump.png", imgSize, imgSize, true, true);
		imgA2 = new Image("file:resource/frogs/froggerLeftJump.png", imgSize, imgSize, true, true);
		imgS2 = new Image("file:resource/frogs/froggerDownJump.png", imgSize, imgSize, true, true);
		imgD2 = new Image("file:resource/frogs/froggerRightJump.png", imgSize, imgSize, true, true);
		points = 0;
		init();
	}
	public int getPrev_points() {
		return prev_points;
	}
	@Override
	public void act(long now) {
		// TODO Auto-generated method stub
		boundaryCheck();
		collisionCheck();
		checkDeath(now);

	}
	
	public void checkDeath(long now) {
		DeathChecking death = new DeathChecking(this);
		int carDeath = death.carDeathCheck(now);
		if(carDeath != 0) {
			if(carDeath == 4) {
				init();
			}else {
				setImage(new Image("file:resource/deaths/cardeath" + carDeath + ".png", imgSize, imgSize, true, true));
			}
		}
		int waterDeath = death.waterDeathCheck(now);
		if(waterDeath != 0) {
			if(waterDeath == 5) {
				init();
			}else {
				setImage(new Image("file:resource/deaths/waterdeath" + waterDeath + ".png", imgSize, imgSize, true, true));
			}
		}
	}
	
	public void init() {
		setX(300);
		setY(679.8+movement);
		setImage(new Image("file:resource/frogs/froggerUp.png", imgSize, imgSize, true, true));

	}
	
	public int getCarD() {
		return carD;
	}
	
	public void setCarD(int carD) {
		this.carD = carD;
	}
	
	public void setNoMove(boolean noMove) {
		this.noMove = noMove;
	}
	public boolean getStop() {
		return (lives == 0 || end == 1);
	}
	public int getLives() {
		return lives;
	}
	public void setDead() {
		this.dead = false;
	}
	public void setLives(int lives) {
		this.lives = lives;
	}
	public void setCarDeath(boolean carDeath) {
		this.carDeath = carDeath;
	}
	
	public void setDead(boolean dead) {
		this.dead = dead;
	}
	
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		// TODO Auto-generated method stub
		this.points = points;
	}
	public void setChangeScore(boolean changeScore) {
		this.changeScore = changeScore;
	}
	public void setPrev_points(int prev_points) {
		this.prev_points = prev_points;
	}
	public boolean isWaterDeath() {
		return waterDeath;
	}
	public void setWaterDeath(boolean waterDeath) {
		this.waterDeath = waterDeath;
	}
	
	public void updateStatus(Image image, double x, double y) {
		move(x, y);
		setImage(image);
	}
	
	public void update(Image image) {
		setImage(image);
	}
	public boolean isNoMove() {
		// TODO Auto-generated method stub
		return noMove;
	}
	public boolean isJump() {
		// TODO Auto-generated method stub
		return jump;
	}
	public void setJump(boolean jump) {
		// TODO Auto-generated method stub
		this.jump = jump;
		
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
	public double getMovement() {
		// TODO Auto-generated method stub
		return movement;
	}
	public double getMovementX() {
		return movementX;
	}
	public void setMovementX(double movementX) {
		this.movementX = movementX;
	}
	public double getW() {
		return w;
	}
	public void setW(double w) {
		this.w = w;
	}
	public void boundaryCheck() {
		if (getY()<0 || getY()>734) {
			setY(679.8+movement);
		}
		if (getX()<0) {
			move(movement*2, 0);
		}
		if (getX()>600) {
			move(-movement*2, 0);
		}
	}
	public boolean isCarDeath() {
		return carDeath;
	}
	public void collisionCheck() {
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
				setWaterDeath(true);
			} else {
				move(-1,0);
			}
		}
		else if(getIntersectingObjects(Crocodile.class).size() >=  1) {
			move(1, 0);
		}
		else if(getIntersectingObjects(CrocodileHead.class).size() >= 1) {
			if (getIntersectingObjects(CrocodileHead.class).get(0).isEaten()) {
				waterDeath = true;
			}else {
				move(-1, 0);
			}
		}
		else if (getIntersectingObjects(End.class).size() >= 1) {
			inter = ((ArrayList<End>) getIntersectingObjects(End.class));
			// frog get into same end 
			if (getIntersectingObjects(End.class).get(0).isActivated()) {
				w = getY();
				Alert alert = new Alert(AlertType.ERROR);
        		alert.setTitle("HIT WRONG END");
        		alert.setContentText("This End is already been taken");
        		alert.show();
			}else {
				if(getIntersectingObjects(Fly.class).size() >= 1) {
					setPoints(points + 200);
					eatFly = true;
				}
				setPoints(getPoints() + 50);
				setChangeScore(true);
				setW(800);
				getIntersectingObjects(End.class).get(0).setEnd();
				end++;
			}
			setPrev_points(getPoints());
			init();
		}
		else if (getY()<413){
			setWaterDeath(true);
		}
	}
	public boolean isDead() {
		return dead;
	}
	public boolean changeScore() {
		// TODO Auto-generated method stub
		return changeScore;
	}



}
