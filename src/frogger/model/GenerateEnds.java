package frogger.model;

import java.util.ArrayList;

import frogger.model.actors.Actor;
import frogger.model.actors.ActorFactory;
import frogger.model.actors.End;

/**
 * @author scyyx1
 * Represents a class to generate the ends list in the game.
 * Contains a function to return a list.
 */
public class GenerateEnds {

	/**
	 * Get an arraylist of the end type.
	 * @return the list of end.
	 */
	public ArrayList<Actor> createActors() {
		// TODO Auto-generated method stub
		ArrayList<Actor> ends = new ArrayList<>();
		ends.add(new ActorFactory().createEnd(13,  96));
		ends.add(new ActorFactory().createEnd(141, 96));
		ends.add(new ActorFactory().createEnd(141 + 141-13,96));
		ends.add(new ActorFactory().createEnd(141 + 141-13+141-13+1,96));
		ends.add(new ActorFactory().createEnd(141 + 141-13+141-13+141-13+3,96));
		return ends;
	}

}
