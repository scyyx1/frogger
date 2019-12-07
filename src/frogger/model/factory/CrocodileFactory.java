package frogger.model.factory;

import java.util.ArrayList;

import frogger.model.Actor;
import frogger.model.obstacle.Crocodile;
import frogger.model.obstacle.CrocodileHead;

public class CrocodileFactory extends ActorFactory {

	@Override
	public ArrayList<Actor> createActors(int level) {
		// TODO Auto-generated method stub
		
		ArrayList<Actor> crocodiles = new ArrayList<>();
		if(level <= 3) {
			return null;
		}else {
			crocodiles.add(new Crocodile(0, 150, level * 0.35, 100, 100));
			crocodiles.add(new CrocodileHead(90, 150, level * 0.35, 70, 70));
			return crocodiles;
		}
	}

}
