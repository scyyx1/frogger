package frogger.util;

import java.util.ArrayList;

import frogger.model.actors.Actor;
import frogger.model.actors.ActorFactory;

/**
 * @author scyyx1
 * Represents a class to generate the crocodiles list in the game.
 * Contains a function to return a list.
 */
public class GenerateCrocodiles extends GenerateActors {

	/**
	 * Get an arraylist of the crocodile type.
	 * @param level The level of current game.
	 * @param difficultyLevel The difficulty level of current game.
	 * @return the list of crocodiles.
	 */
	@Override
	public ArrayList<Actor> createActors(int level, int difficultyLevel) {
		
		ArrayList<Actor> crocodiles = new ArrayList<>();
		if(difficultyLevel == 1) {
			return null;
		}
		else{
			if(difficultyLevel == 3) {
				crocodiles.add(ActorFactory.getInstance().createCrocodileBody(400,  150,  level*0.35, 100,  100));
				crocodiles.add(ActorFactory.getInstance().createCrocodileHead(490,  150,  level*0.35, 70,  70));
			}
			crocodiles.add(ActorFactory.getInstance().createCrocodileBody(0,  150,  level*0.35, 100,  100));
			crocodiles.add(ActorFactory.getInstance().createCrocodileHead(90,  150,  level*0.35, 70,  70));
		}	
		return crocodiles;

	}

}
