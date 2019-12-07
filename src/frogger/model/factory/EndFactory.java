package frogger.model.factory;

import java.util.ArrayList;

import frogger.model.Actor;
import frogger.model.obstacle.End;

public class EndFactory extends ActorFactory {

	@Override
	public ArrayList<Actor> createActors(int level) {
		// TODO Auto-generated method stub
		ArrayList<Actor> ends = new ArrayList<>();
		ends.add(new End(13,96));
		ends.add(new End(141,96));
		ends.add(new End(141 + 141-13,96));
		ends.add(new End(141 + 141-13+141-13+1,96));
		ends.add(new End(141 + 141-13+141-13+141-13+3,96));
		return ends;
	}

}
