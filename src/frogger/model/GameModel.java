package frogger.model;

import java.util.ArrayList;

import frogger.model.actors.ActorFactory;
import frogger.model.actors.Frogger;
import frogger.view.GameWorld;
import frogger.view.GroupsCollection;


/**
 * @author scyyx1
 * Represent the game model of game world.
 * Set up the frogger and some game status of the game.
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
	 * The remaining time divided by the total time of the game to get the percentage.
	 */
	private double remainTimePercentage = 0;
	
	/**
	 * Whether it is possible to change previous score in the view.
	 */
	private boolean viewChangePrevScore;
	
	/**
	 * Whether it is possible to change the score in the view.
	 */
	private boolean viewChangeScore;
	
	/**
	 * Whether the game is win.
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
	 * Whether the view can switch to game over.
	 */
	private boolean switchToGameOver;
	
	/**
	 * An array list to store the score into a list.
	 */
	private ArrayList<String> scoreList = new ArrayList<>(); 
	
	public GameModel() {
		frogger = new ActorFactory().createFrogger();
		startTime = System.nanoTime();

	}
	
	public GameModel(int points) {
		frogger = new ActorFactory().createFrogger(points);
		startTime = System.nanoTime();
	}
	
	/**
	 * Initialize the status to default value.
	 */
	public void initializeStatus() {
		viewChangePrevScore = false;
		viewChangeScore = false;
		generateFly = false;
		winStatus = false;
		remainTimePercentage = 0;
		switchToGameOver = false;
		stopView = false;
	}
	
	/**
	 * Update the model in the game.
	 * @param now The current time.
	 */
	public void updateModel(long now) {

		initializeStatus();
		double elapsedTime =  (now - startTime) / 1000000000.0;
		if(elapsedTime < 180) {
			if(elapsedTime > 5 && numberOfFly > 0) {
				generateFly = true;
				numberOfFly = 0;
			}
			remainTimePercentage = elapsedTime / 180;
		}
		else {
			frogger.setLives(0);
		}
		if (frogger.isDead()) {
			viewChangePrevScore = true;
			viewChangeScore = true;
			frogger.setDead(false);
		}
		if(frogger.changeScore()) {
			viewChangeScore = true;
		}
		if(frogger.getStop()) {
			System.out.print("STOPP:");
			if(frogger.getLives() == 0 || level == 5) {
				if(level == 5) {
					winStatus = true;
				}
				switchToGameOver = true;
			}
			stopView = true;
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

	public boolean canChangePrevScore() {
		return viewChangePrevScore;
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
