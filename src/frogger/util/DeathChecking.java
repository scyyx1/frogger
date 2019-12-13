package frogger.util;

import frogger.model.actors.Frogger;
import javafx.scene.image.Image;

/**
 * @author scyyx1
 * Represent the class for death checking.
 * Check the status of the frog and check whether it is death or not.
 */
public class DeathChecking {
	
	/**
	 * The frogger object used to check death
	 */
	private Frogger frogger;
	
	/**
	 * A constructor to initialize the frogger.
	 * @param frogger The frogger should be the one used in the game.
	 */
	public DeathChecking(Frogger frogger) {
		this.frogger = frogger;
		
	}
	
	/**
	 * Check whether frogger is car death or water death.
	 * If true, set corresponding animation by current frame count and death type, or update the status.
	 * @param now The current time.
	 */
	public void deathCheck(long now) {
		if(frogger.isCarDeath() || frogger.isWaterDeath()) {
			String deathType;
			if(frogger.isCarDeath()) {
				deathType = "cardeath";
			}else {
				deathType = "waterdeath";
			}
			frogger.setNoMove(true);
			int deathAnimationFrameCount = frogger.getDeathAnimationFrameCount();
			if((now) % 11 == 0) {
				frogger.setDeathAnimationFrameCount(deathAnimationFrameCount + 1);
			}
			if(deathAnimationFrameCount == 1) {
				displayAnimation(deathType, deathAnimationFrameCount);
			}
			if(deathAnimationFrameCount == 2) {
				displayAnimation(deathType, deathAnimationFrameCount);
			}
			if(deathAnimationFrameCount == 3) {
				displayAnimation(deathType, deathAnimationFrameCount);
			}
			if(deathAnimationFrameCount == 4) {
				if(frogger.isCarDeath()) {
					frogger.setCarDeath(false);
					reviveFrogger();
				}else {
					displayAnimation(deathType, deathAnimationFrameCount);
				}
			}
			if(deathAnimationFrameCount == 5) {
				frogger.setWaterDeath(false);
				reviveFrogger();
			}
		}
	}
	
	/**
	 * Display the image of current death type and current frame number.
	 * @param deathType The death type of frogger.
	 * @param number The current frame number
	 */
	public void displayAnimation(String deathType, int number) {
		frogger.setImage(new Image("file:resource/deaths/" + deathType + number + ".png", frogger.getImgSize(), frogger.getImgSize(), true, true));
	}
	
	/**
	 * Revive the frogger by resetting the data inside frogger.
	 */
	public void reviveFrogger() {
		frogger.initializeFrogger();
		frogger.setLives(frogger.getLives() - 1);
		frogger.setDeathAnimationFrameCount(0);
		frogger.setDead(true);
		frogger.setNoMove(false);
		int getPoints = frogger.getPoints();
		if (getPoints>50) {
			frogger.setPoints(getPoints - 50);
			frogger.setChangeScore(true);
		}
		frogger.setPrev_points(frogger.getPoints());
	}
}
