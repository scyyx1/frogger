package frogger.model.actors;

import java.util.ArrayList;

import frogger.model.DeathChecking;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;

public class Frogger extends Actor {

	
	private int points;
	private int end = 0;
	private boolean jump = false;
	private boolean stopMoving = false;
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
	private boolean eatFly = false;
	private boolean crocodileDeath = true;
	private int level;
	int imgSize = 40;
	private Image imgWInit = new Image("file:resource/frogs/froggerUp.png", imgSize, imgSize, true, true);
	private Image imgAInit = new Image("file:resource/frogs/froggerLeft.png", imgSize, imgSize, true, true);
	private Image imgSInit = new Image("file:resource/frogs/froggerDown.png", imgSize, imgSize, true, true);
	private Image imgDInit = new Image("file:resource/frogs/froggerRight.png", imgSize, imgSize, true, true);
	private Image imgWJump = new Image("file:resource/frogs/froggerUpJump.png", imgSize, imgSize, true, true);
	private Image imgAJump = new Image("file:resource/frogs/froggerLeftJump.png", imgSize, imgSize, true, true);
	private Image imgSJump = new Image("file:resource/frogs/froggerDownJump.png", imgSize, imgSize, true, true);
	private Image imgDJump = new Image("file:resource/frogs/froggerRightJump.png", imgSize, imgSize, true, true);
	private ArrayList<End> inter = new ArrayList<End>();
	
	public Frogger(int points) {
		
		this.points = points;
		init();
	}
	public Frogger() {

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
	public void collisionCheck() {
		if (getIntersectingObjects(Vehicle.class).size() >= 1) {
			carDeath = true;
		}
		if (getX() == 240 && getY() == 82) {
			stop = true;
		}
		if (getIntersectingObjects(Log.class).size() >= 1 && !stopMoving) {
			if(getIntersectingObjects(Log.class).get(0).getLeft())
				move(-0.5*level,0);
			else
				move (.35*level,0);
		}
		else if (getIntersectingObjects(Turtle.class).size() >= 1 && !stopMoving) {
			if(level >3 ) {
				move(-2, 0);
			}else {
				move(-1,0);
			}
			
		}
		else if (getIntersectingObjects(WetTurtle.class).size() >= 1) {
			if (getIntersectingObjects(WetTurtle.class).get(0).isSunk()) {
				setWaterDeath(true);
			} else {
				if(level > 3) {
					move(-2,0);
				}else {
					move(-1,0);
				}
				
			}
		}
		else if(getIntersectingObjects(CrocodileBody.class).size() >=  1) {
			move(level * 0.35, 0);
		}
		else if(getIntersectingObjects(CrocodileHead.class).size() >= 1) {
			if (getIntersectingObjects(CrocodileHead.class).get(0).isEaten()) {
				waterDeath = true;
			}else {
				move(level*0.35, 0);
			}
		}
		else if(getIntersectingObjects(Snack.class).size() >= 1) {
			carDeath = true;
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
	
	
	public void updateStatus(Image image, double x, double y) {
		move(x, y);
		setImage(image);
	}
	
	public void update(Image image) {
		setImage(image);
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
		this.stopMoving = noMove;
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
	
	
	public boolean isStopMoving() {
		// TODO Auto-generated method stub
		return stopMoving;
	}
	public boolean isJump() {
		// TODO Auto-generated method stub
		return jump;
	}
	public void setJump(boolean jump) {
		// TODO Auto-generated method stub
		this.jump = jump;
		
	}
	
	public Image getImgWInit() {
		return imgWInit;
	}
	public Image getImgAInit() {
		return imgAInit;
	}
	public Image getImgSInit() {
		return imgSInit;
	}
	public Image getImgDInit() {
		return imgDInit;
	}
	public Image getImgWJump() {
		return imgWJump;
	}
	public Image getImgAJump() {
		return imgAJump;
	}
	public Image getImgSJump() {
		return imgSJump;
	}
	public Image getImgDJump() {
		return imgDJump;
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
	
	public boolean isDead() {
		return dead;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public boolean changeScore() {
		return changeScore;
	}



}
