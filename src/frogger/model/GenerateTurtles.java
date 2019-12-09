package frogger.model;

import java.util.ArrayList;

import frogger.model.actors.Actor;
import frogger.model.actors.ActorFactory;

/**
 * @author scyyx1
 * Represents a class to generate the crocodiles list in the game.
 * Contains a function to return a list.
 */
public class GenerateTurtles extends GenerateActors {

	/**
	 * Get an arraylist of the turtles type.
	 * @param level The level of current game.
	 * @param difficultyLevel The difficulty level of current game.
	 * @return the list of turtles.
	 */
	@Override
	public ArrayList<Actor> createActors(int level, int difficultyLevel) {
		// TODO Auto-generated method stub
		ArrayList<Actor> turtles = new ArrayList<>();
		int speed = 1;

		if(level > 3) {
			speed = 2;
		}
		if(difficultyLevel == 1) {
			turtles.add(ActorFactory.getInstance().createTurtle(300, 376, -speed, 130, 130));
			turtles.add(ActorFactory.getInstance().createTurtle(500, 376, -speed, 130, 130));
			turtles.add(ActorFactory.getInstance().createTurtle(700, 376, -speed, 130, 130));
		}else if(difficultyLevel == 2) {
			turtles.add(ActorFactory.getInstance().createTurtle(300, 376, -speed, 130, 130));
			turtles.add(ActorFactory.getInstance().createWetTurtle(500, 376, -speed, 130, 130));
			turtles.add(ActorFactory.getInstance().createTurtle(700, 376, -speed, 130, 130));
		}else {
			turtles.add(ActorFactory.getInstance().createWetTurtle(300, 376, -speed, 130, 130));
			turtles.add(ActorFactory.getInstance().createWetTurtle(500, 376, -speed, 130, 130));
			turtles.add(ActorFactory.getInstance().createWetTurtle(700, 376, -speed, 130, 130));
		}
		turtles.add(ActorFactory.getInstance().createWetTurtle(200, 217, -speed, 130, 130));
		turtles.add(ActorFactory.getInstance().createWetTurtle(400, 217, -speed, 130, 130));
		turtles.add(ActorFactory.getInstance().createWetTurtle(600, 217, -speed, 130, 130));
		
		return turtles;

	}

}
