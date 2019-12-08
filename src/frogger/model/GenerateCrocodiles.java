package frogger.model;

import java.util.ArrayList;

import frogger.model.actors.Actor;
import frogger.model.actors.ActorFactory;
import frogger.model.actors.CrocodileBody;
import frogger.model.actors.CrocodileHead;

public class GenerateCrocodiles extends GenerateActors {

	@Override
	public ArrayList<Actor> createActors(int level) {
		// TODO Auto-generated method stub
		
		ArrayList<Actor> crocodiles = new ArrayList<>();
		if(level <= 3) {
			return null;
		}else {
			crocodiles.add(new ActorFactory().createCrocodile(0,  150,  level*0.35, 100,  100));
			crocodiles.add(new ActorFactory().createCrocodileHead(90,  150,  level*0.35, 70,  70));
			return crocodiles;
		}
	}

}
