package frogger.model.actors;


import frogger.util.DeathChecking;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;

/**
 * @author scyyx1
 * Represents a frogger in the game and generate the data needed in the frogger
 */
public class Frogger extends MovingActor {

	
	/**
	 * The current points that player got.
	 */
	private int currentPoints;
	
	/**
	 * The number of ends that player has already reached.
	 */
	private int activatedEnd = 0;
	
	/**
	 * Whether the frogger is in jumping status.
	 */
	private boolean jump = false;
	
	/**
	 * Whether the frogger is stop moving.
	 */
	private boolean stopMoving = false;
	
	/**
	 * The vertical movement that half step included.
	 */
	private final double movementVertical = 13.3333333*2;
	
	/**
	 * The horizontal movement that half step included.
	 */
	private final double movementHorizon = 10.666666*2;
	
	/**
	 * Whether the frogger is hitted by car.
	 */
	private boolean carDeath = false;
	
	/**
	 * Whether the frogger is sunk in water.
	 */
	private boolean waterDeath = false;
	
	/**
	 * Whether the frogger is dead.
	 */
	private boolean dead = false;
	
	/**
	 * The total lives that a frogger has.
	 */
	private int lives = 3;
	
	/**
	 * Whether can change the score.
	 */
	private boolean changeScore = false;
	
	/**
	 * The count of current dead animation frame.
	 */
	private int deathAnimationFrameCount = 0;
	
	/**
	 * The last score line recorded in the game.
	 */
	private double lastScoreLineRecord = 800;
	
	/**
	 * The game level of current game.
	 */
	private int level;
	
	/**
	 * The image size.
	 */
	private final int imgSize = 40;
	

	/**
	 * A constructor to initialize the frogger position and points.
	 * @param points The points that a frogger has.
	 */
	public Frogger(int points) {
		
		this.currentPoints = points;
		initializeFrogger();
	}
	
	/**
	 * A constructor to initialize the frogger position and points
	 */
	public Frogger() {

		currentPoints = 0;
		initializeFrogger();
	}
	
	/**
	 * Initialize the frogger position.
	 */
	public void initializeFrogger() {
		setX(300);
		setY(679.8+movementVertical);
		setImage(new Image("file:resource/frogs/froggerUp.png", imgSize, imgSize, true, true));

	}
	
	/**
	 * Carry on some boundary checking, collision checking and death checking of the frogger.
	 */
	@Override
	public void act(long now) {

		boundaryCheck();
		updateFroggerMovement();
		checkDeath(now);

	}
	
	/**
	 * Check whether it exceeds the boundary.
	 */
	public void boundaryCheck() {
		
		if (getY()<0 || getY()>734) {
			setY(679.8+movementVertical);
		}
		if (getX()<0) {
			move(movementVertical*2, 0);
		}
		if (getX()>600) {
			move(-movementVertical*2, 0);
		}
	}
		
	/**
	 * Update the frogger movement in the game. Calling methods to check for collision, transporting or reaching end.
	 * And update frogger status when they intersecting with other actors.
	 */
	public void updateFroggerMovement() {
		
		collisionCheck();
		transportObjectCheck();
		reachEndCheck();
	}
	
	/**
	 * Check whether frogger is collided with other objects.
	 * If yes, update frogger status.
	 */
	public void collisionCheck() {
		if (getIntersectingObjects(Vehicle.class).size() >= 1) {
			carDeath = true;
		}
		else if(getIntersectingObjects(Snake.class).size() >= 1) {
			carDeath = true;
		}
	}
	
	/**
	 * Check whether the frogger is on trasporting object.
	 * If yes, update the frogger data and move with the object.
	 */
	public void transportObjectCheck() {
		if(getIntersectingObjects(CrocodileBody.class).size() >=  1) {
			move(level * 0.35, 0);
		}else if (getIntersectingObjects(Log.class).size() >= 1 && !stopMoving) {
			if(getIntersectingObjects(Log.class).get(0).getLeft())
				move(-0.5*level,0);
			else
				move (.35*level,0);
		}
		else if (getIntersectingObjects(Turtle.class).size() >= 1 && !stopMoving) {
			if(level > 3 ) {
				move(-2, 0);
			}else {
				move(-1,0);
			}
		}else if (getIntersectingObjects(WetTurtle.class).size() >= 1) {
			if (getIntersectingObjects(WetTurtle.class).get(0).isSunk()) {
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
		}else if(getIntersectingObjects(CrocodileHead.class).size() >= 1) {
			if (getIntersectingObjects(CrocodileHead.class).get(0).isEaten()) {
				waterDeath = true;
			}else {
				move(level*0.35, 0);
			}
		}else if (getY()<413){
			waterDeath = true;
		}
	}
	
	/**
	 * Check whether the frogger reach the end points and whether they enter the same end that previously reached.
	 * If reached the new end, update the frogger data.
	 * If reached the same end, show alert message.
	 */
	public void reachEndCheck() {
		if (getIntersectingObjects(End.class).size() >= 1) {
			if (getIntersectingObjects(End.class).get(0).isActivated()) {
				lastScoreLineRecord = getY();
				showAlertSameEnd();
			}else {
				if(getIntersectingObjects(Fly.class).size() >= 1) {
					currentPoints += 200;
				}
				currentPoints += 50;
				setChangeScore(true);
				setLastScoreLineRecord(800);
				getIntersectingObjects(End.class).get(0).setEnd();
				activatedEnd++;
			}
			initializeFrogger();
		}
	}
	
	/**
	 * Checking whether the frogger is dead or not and set the death image at some specific time.
	 * @param now The current time.
	 */
	public void checkDeath(long now) {
		DeathChecking deathChecking = new DeathChecking(this);
		deathChecking.deathCheck(now);
	}
	
	/**
	 * Display an alert when the end is hitted twice.
	 */
	public void showAlertSameEnd() {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("HIT WRONG END");
		alert.setContentText("This End is already been taken");
		alert.show();
	}
	
	/**
	 * Update the status of frogger, included it's image and it's x position and y position.
	 * @param image The image of current frogger.
	 * @param x The x position of current image.
	 * @param y The y position of current image.
	 */
	public void updateStatus(Image image, double x, double y) {
		move(x, y);
		setImage(image);
	}
	
	
	
	/**
	 * Check whether the condition of stopping the game is matched.
	 * @return true if lives equals to zero or end reaches five.
	 */
	public boolean getGameStop() {
		return (lives == 0 || activatedEnd == 1);
	}
	
	public int getDeathAnimationFrameCount() {
		return deathAnimationFrameCount;
	}
	public void setDeathAnimationFrameCount(int frameCount) {
		this.deathAnimationFrameCount = frameCount;
	}
	public void setNoMove(boolean noMove) {
		this.stopMoving = noMove;
	}
	public int getLives() {
		return lives;
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
		return currentPoints;
	}
	public void setPoints(int points) {
		this.currentPoints = points;
	}
	public void setChangeScore(boolean changeScore) {
		this.changeScore = changeScore;
	}
	public boolean isWaterDeath() {
		return waterDeath;
	}
	public void setWaterDeath(boolean waterDeath) {
		this.waterDeath = waterDeath;
	}
	public boolean isStopMoving() {
		return stopMoving;
	}
	public boolean isJump() {
		return jump;
	}
	public void setJump(boolean jump) {
		this.jump = jump;
		
	}
	public double getMovementVertical() {
		return movementVertical;
	}
	public double getMovementHorizon() {
		return movementHorizon;
	}

	public double getLastScoreLineRecord() {
		return lastScoreLineRecord;
	}
	public void setLastScoreLineRecord(double lastScoreLineRecord) {
		this.lastScoreLineRecord = lastScoreLineRecord;
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

	public int getEndReached() {
		return activatedEnd;
	}
	
	public int getImgSize() {
		return imgSize;
	}


}
