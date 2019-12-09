package frogger.model;

import frogger.model.actors.Frogger;

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
	 * Check whether car death is true.
	 * If true, certain death count will be outputed.
	 * @param now The current time.
	 * @return The death status count.
	 */
	public int carDeathCheck(long now) {
		if (frogger.isCarDeath()) {
			int deathStatusCount = frogger.getCarD();
			frogger.setNoMove(true);
			if ((now)% 11 ==0) {
				frogger.setCarD(deathStatusCount + 1);
			}
			if (deathStatusCount == 1) {
				return 1;
			}
			if (deathStatusCount == 2) {
				return 2;
			}
			if (deathStatusCount == 3) {
				return 3;
			}
			if (deathStatusCount == 4) {
				frogger.setCarDeath(false);
				reviveFrogger();
				return 4;
			}
			
		}
		return 0;
	}
	
	/**
	 * Check whether water death is true.
	 * If true, certain death count will be outputed.
	 * @param now The current time.
	 * @return The death status count.
	 */
	public int waterDeathCheck(long now) {
		if (frogger.isWaterDeath()) {
			int deathStatusCount = frogger.getCarD();
			frogger.setNoMove(true);
			if ((now)% 11 ==0) {
				frogger.setCarD(deathStatusCount + 1);
			}
			if (deathStatusCount==1) {
				return 1;
			}
			if (deathStatusCount==2) {
				return 2;
			}
			if (deathStatusCount==3) {
				return 3;
			}
			if (deathStatusCount==4) {
				return 4;
			}
			if (deathStatusCount==5) {
				frogger.setWaterDeath(false);
				reviveFrogger();
				return 5;
			}
			
		}
		return 0;
	}
	
	/**
	 * Revive the frogger by resetting the data inside frogger.
	 */
	public void reviveFrogger() {
		frogger.setLives(frogger.getLives() - 1);
		frogger.setCarD(0);
		frogger.setDead(true);
		frogger.setNoMove(false);
		if (frogger.getPoints()>50) {
			frogger.setPoints(frogger.getPoints() - 50);
			frogger.setChangeScore(true);
		}
		frogger.setPrev_points(frogger.getPoints());
	}
}
