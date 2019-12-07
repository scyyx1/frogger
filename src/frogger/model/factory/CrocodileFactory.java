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
		crocodiles.add(new Crocodile(200, 217, 1, 100, 100));
		crocodiles.add(new CrocodileHead(290, 210, 1, 70, 70));
		return crocodiles;
	}

}
