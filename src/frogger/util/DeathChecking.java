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
	 * @param frog The frogger should be the one used in the game.
	 */
	public DeathChecking(Frogger frogger) {
		this.frogger = frogger;
		
	}
	
	/**
	 * Check whether car death is true..
	 * If true, set the frogger into certain images or update the status.
	 * @param now The current time.
	 */
	public void carDeathCheck(long now) {
		if (frogger.isCarDeath()) {
			int deathStatusCount = frogger.getCarDeathStatusCount();
			frogger.setNoMove(true);
			if ((now)% 11 ==0) {
				frogger.setDeathStatusCount(deathStatusCount + 1);
			}
			if(deathStatusCount == 1) {
				frogger.setImage(new Image("file:resource/deaths/cardeath1.png", frogger.getImgSize(), frogger.getImgSize(), true, true));
			}
			if(deathStatusCount == 2) {
				frogger.setImage(new Image("file:resource/deaths/cardeath2.png", frogger.getImgSize(), frogger.getImgSize(), true, true));
			}
			if(deathStatusCount == 3) {
				frogger.setImage(new Image("file:resource/deaths/cardeath3.png", frogger.getImgSize(), frogger.getImgSize(), true, true));
			}		
			if(deathStatusCount == 4) {
				frogger.setCarDeath(false);
				reviveFrogger();
			}		
		}

	}
	
	/**
	 * Check whether water death is true.
	 * If true, set the froger into certain images or update the status.
	 * @param now The current time.
	 */
	public void waterDeathCheck(long now) {
		if (frogger.isWaterDeath()) {
			int deathStatusCount = frogger.getCarDeathStatusCount();
			frogger.setNoMove(true);
			if ((now)% 11 ==0) {
				frogger.setDeathStatusCount(deathStatusCount + 1);
			}
			if(deathStatusCount == 1) {
				frogger.setImage(new Image("file:resource/deaths/waterdeath1.png", frogger.getImgSize(), frogger.getImgSize(), true, true));
			}
			if(deathStatusCount == 2) {
				frogger.setImage(new Image("file:resource/deaths/waterdeath2.png", frogger.getImgSize(), frogger.getImgSize(), true, true));
			}
			if(deathStatusCount == 3) {
				frogger.setImage(new Image("file:resource/deaths/waterdeath3.png", frogger.getImgSize(), frogger.getImgSize(), true, true));
			}	
			if(deathStatusCount == 4) {
				frogger.setImage(new Image("file:resource/deaths/waterdeath4.png", frogger.getImgSize(), frogger.getImgSize(), true, true));
			}	
			if(deathStatusCount == 5) {
				frogger.setWaterDeath(false);
				reviveFrogger();
			}
		}
	}
	
	/**
	 * Revive the frogger by resetting the data inside frogger.
	 */
	public void reviveFrogger() {
		frogger.initializeFrogger();
		frogger.setLives(frogger.getLives() - 1);
		frogger.setDeathStatusCount(0);
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
