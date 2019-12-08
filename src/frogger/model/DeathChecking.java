package frogger.model;

import frogger.model.actors.Frogger;

public class DeathChecking {
	private Frogger frog;
	public DeathChecking(Frogger frog) {
		this.frog = frog;
	}
	
	public int carDeathCheck(long now) {
		if (frog.isCarDeath()) {
			frog.setNoMove(true);
			if ((now)% 11 ==0) {
				frog.setCarD(frog.getCarD()+1);
			}
			if (frog.getCarD()==1) {
				return 1;
			}
			if (frog.getCarD()==2) {
				return 2;
			}
			if (frog.getCarD()==3) {
				return 3;
			}
			if (frog.getCarD() == 4) {
				frog.setLives(frog.getLives()-1);
				frog.setCarDeath(false);
				frog.setCarD(0);
				frog.setDead(true);
				frog.setNoMove(false);
				if (frog.getPoints()>50) {
					frog.setPoints(frog.getPoints() - 50);
					frog.setChangeScore(true);
				}
				frog.setPrev_points(frog.getPoints());
				return 4;
			}
			
		}
		return 0;
	}
	
	public int waterDeathCheck(long now) {
		if (frog.isWaterDeath()) {
			frog.setNoMove(true);
			if ((now)% 11 ==0) {
				frog.setCarD(frog.getCarD()+1);
			}
			if (frog.getCarD()==1) {
				return 1;
			}
			if (frog.getCarD()==2) {
				return 2;
			}
			if (frog.getCarD()==3) {
				return 3;
			}
			if (frog.getCarD() == 4) {
				return 4;
			}
			if (frog.getCarD() == 5) {
				frog.setLives(frog.getLives()-1);
				frog.setWaterDeath(false);
				frog.setCarD(0);
				frog.setDead(true);
				frog.setNoMove(false);
				if (frog.getPoints()>50) {
					frog.setPoints(frog.getPoints() - 50);
					frog.setChangeScore(true);
				}
				frog.setPrev_points(frog.getPoints());
				return 5;
			}
			
		}
		return 0;
	}
}
