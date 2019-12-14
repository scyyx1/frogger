package frogger.model;

import java.util.ArrayList;

import frogger.model.actors.ActorFactory;
import frogger.model.actors.Frogger;

/**
 * @author scyyx1
 * Represent the game model of game world.
 * Set up the frogger and some game status of the game.
 * Contains methods to initialize all status in game and update the status.
 */
public class GameModel {

	/**
	 * A frogger used in the game.
	 */
	private Frogger frogger;
	
	/**
	 * Number of flys generated in the game view.
	 */
	private int numberOfFly = 1;
	
	/**
	 * Whether is possible to generate the fly
	 */
	private boolean generateFly = false;
	
	/**
	 * The start time of the game.
	 */
	private long startTime;
	
	/**
	 * The remaining time divided by the total time of the game to get the percentage of remaining time.
	 */
	private double remainTimePercentage = 0;
	
	/**
	 * The total time of game in each level.
	 */
	private int gameTotalTime = 180;
	
	/**
	 * Whether it is possible to change previous score in the view.
	 */
	private boolean resetLiveNumber;
	
	/**
	 * Whether it is possible to change the score in the view.
	 */
	private boolean viewChangeScore;
	
	/**
	 * Whether the game wins.
	 */
	private boolean winStatus;
	
	/**
	 * Whether the view can be stopped.
	 */
	private boolean stopView;
	
	/**
	 * The level of the current game.
	 */
	private int level;
	
	/**
	 * The maximum level of the game.
	 */
	private int maximumLevel = 5;
	
	/**
	 * Whether the view can switch to game over.
	 */
	private boolean switchToGameOver;
	
	/**
	 * An array list to store the score into a list.
	 */
	private ArrayList<String> scoreList = new ArrayList<>(); 
	
	/**
	 * A constructor to create a frogger for the game and setup the start time of the game.
	 */
	public GameModel() {
		frogger = ActorFactory.getInstance().createFrogger();
		startTime = System.nanoTime();

	}
	
	/**
	 * A constructor to create a frogger for the game with existing points and setup the start time of the game.
	 * @param points The points of the game
	 */
	public GameModel(int points) {
		frogger = ActorFactory.getInstance().createFrogger(points);
		startTime = System.nanoTime();
	}
	
	/**
	 * Initialize the status in game model to default value.
	 */
	public void initializeStatus() {
		resetLiveNumber = false;
		viewChangeScore = false;
		generateFly = false;
		winStatus = false;
		remainTimePercentage = 0;
		switchToGameOver = false;
		stopView = false;
	}
	
	/**
	 * Gets the remain time of the game in double number.
	 * @param now The current time
	 * @return The remain time
	 */
	public double checkRemainTime(long now) {
		double elapsedTime =  (now - startTime) / 1000000000.0;
		if(elapsedTime < gameTotalTime) {
			if(elapsedTime > gameTotalTime / 10 && numberOfFly > 0) {
				generateFly = true;
				numberOfFly--;
			}
			return elapsedTime / gameTotalTime;
		}
		else {
			frogger.setLives(0);
			return 0;
		}
	}
	
	/**
	 * Change the status in model in the status of stopping the game.
	 */
	public void stopTheGame() {
		System.out.print("STOPP:");
		if(frogger.getLives() == 0 || level == maximumLevel) {
			if(level == maximumLevel) {
				winStatus = true;
			}
			switchToGameOver = true;
		}
		stopView = true;
	}
	/**
	 * Update the model in the main game
	 * @param now The current time.
	 */
	public void updateModel(long now) {
		initializeStatus();
		
		remainTimePercentage = checkRemainTime(now);
		
		if (frogger.isDead()) {
			resetLiveNumber = true;
			viewChangeScore = true;
			frogger.setDead(false);
		}
		if(frogger.changeScore()) {
			viewChangeScore = true;
		}
		if(frogger.getGameStop()) {
			stopTheGame();
		}
	}
	
	public boolean isGenerateFly() {
		return generateFly;
	}

	public double getRemainTimePercentage() {
		return remainTimePercentage;
	}

	public boolean isSwitchToGameOver() {
		return switchToGameOver;
	}

	public boolean canStopView() {
		return stopView;
	}

	public boolean canResetLiveNumber() {
		return resetLiveNumber;
	}

	public boolean canViewChangeScore() {
		return viewChangeScore;
	}

	
	public long getStartTime() {
		return startTime;
	}

	public boolean getWinStatus() {
		return winStatus;
	}

	public ArrayList<String> getScoreList() {
		return scoreList;
	}

	public void setFrog(Frogger frog) {
		this.frogger = frog;
	}
	public Frogger getFrog() {
		return frogger;
	}
	public int getLevel() {

		return level;
	}
	public void setLevel(int level) {

		frogger.setLevel(level);
		this.level = level;
	}
	public void setFly(int fly) {
		this.numberOfFly = fly;
	}

	public int getFly() {
		return numberOfFly;
	}
}
