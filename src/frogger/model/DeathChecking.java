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
	
	public int carDeathCheck(long now) {
		if (frogger.isCarDeath()) {
			frogger.setNoMove(true);
			if ((now)% 11 ==0) {
				frogger.setCarD(frogger.getCarD()+1);
			}
			if (frogger.getCarD()==1) {
				return 1;
			}
			if (frogger.getCarD()==2) {
				return 2;
			}
			if (frogger.getCarD()==3) {
				return 3;
			}
			if (frogger.getCarD() == 4) {
				frogger.setLives(frogger.getLives()-1);
				frogger.setCarDeath(false);
				frogger.setCarD(0);
				frogger.setDead(true);
				frogger.setNoMove(false);
				if (frogger.getPoints()>50) {
					frogger.setPoints(frogger.getPoints() - 50);
					frogger.setChangeScore(true);
				}
				frogger.setPrev_points(frogger.getPoints());
				return 4;
			}
			
		}
		return 0;
	}
	
	public int waterDeathCheck(long now) {
		if (frogger.isWaterDeath()) {
			frogger.setNoMove(true);
			if ((now)% 11 ==0) {
				frogger.setCarD(frogger.getCarD()+1);
			}
			if (frogger.getCarD()==1) {
				return 1;
			}
			if (frogger.getCarD()==2) {
				return 2;
			}
			if (frogger.getCarD()==3) {
				return 3;
			}
			if (frogger.getCarD() == 4) {
				return 4;
			}
			if (frogger.getCarD() == 5) {
				frogger.setLives(frogger.getLives()-1);
				frogger.setWaterDeath(false);
				frogger.setCarD(0);
				frogger.setDead(true);
				frogger.setNoMove(false);
				if (frogger.getPoints()>50) {
					frogger.setPoints(frogger.getPoints() - 50);
					frogger.setChangeScore(true);
				}
				frogger.setPrev_points(frogger.getPoints());
				return 5;
			}
			
		}
		return 0;
	}
}
