package frogger.model;

import java.util.ArrayList;

import frogger.model.actors.Actor;
import frogger.model.actors.ActorFactory;
import frogger.model.actors.Turtle;
import frogger.model.actors.WetTurtle;

public class GenerateTurtles extends GenerateActors {

	@Override
	public ArrayList<Actor> createActors(int level, int difficultyLevel) {
		// TODO Auto-generated method stub
		ArrayList<Actor> turtles = new ArrayList<>();
		int speed = 1;

		if(level > 3) {
			speed = 2;
		}
		if(difficultyLevel == 1) {
			turtles.add(new ActorFactory().createTurtle(300, 376, -speed, 130, 130));
			turtles.add(new ActorFactory().createTurtle(500, 376, -speed, 130, 130));
			turtles.add(new ActorFactory().createTurtle(700, 376, -speed, 130, 130));
		}else if(difficultyLevel == 2) {
			turtles.add(new ActorFactory().createTurtle(300, 376, -speed, 130, 130));
			turtles.add(new ActorFactory().createWetTurtle(500, 376, -speed, 130, 130));
			turtles.add(new ActorFactory().createTurtle(700, 376, -speed, 130, 130));
		}else {
			turtles.add(new ActorFactory().createWetTurtle(300, 376, -speed, 130, 130));
			turtles.add(new ActorFactory().createWetTurtle(500, 376, -speed, 130, 130));
			turtles.add(new ActorFactory().createWetTurtle(700, 376, -speed, 130, 130));
		}
		turtles.add(new ActorFactory().createWetTurtle(200, 217, -speed, 130, 130));
		turtles.add(new ActorFactory().createWetTurtle(400, 217, -speed, 130, 130));
		turtles.add(new ActorFactory().createWetTurtle(600, 217, -speed, 130, 130));
		
		return turtles;

	}

}
