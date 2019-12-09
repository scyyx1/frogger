package frogger.model;

import java.util.ArrayList;

import frogger.model.actors.Actor;
import frogger.model.actors.ActorFactory;
import frogger.model.actors.CrocodileBody;
import frogger.model.actors.CrocodileHead;

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
				crocodiles.add(new ActorFactory().createCrocodileBody(400,  150,  level*0.35, 100,  100));
				crocodiles.add(new ActorFactory().createCrocodileHead(490,  150,  level*0.35, 70,  70));
			}
			crocodiles.add(new ActorFactory().createCrocodileBody(0,  150,  level*0.35, 100,  100));
			crocodiles.add(new ActorFactory().createCrocodileHead(90,  150,  level*0.35, 70,  70));
		}	
		return crocodiles;

	}

}
