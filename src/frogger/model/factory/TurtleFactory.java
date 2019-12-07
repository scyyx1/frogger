package frogger.model.factory;

import java.util.ArrayList;

import frogger.model.Actor;
import frogger.model.obstacle.Turtle;
import frogger.model.obstacle.WetTurtle;

public class TurtleFactory extends ActorFactory {

	@Override
	public ArrayList<Actor> createActors(int level) {
		// TODO Auto-generated method stub
		ArrayList<Actor> turtles = new ArrayList<>();
		int speed = 1;
		if(level > 3) {
			speed = 2;
		}
		for(int i = 0; i < 2; i++) {
			turtles.add(new Turtle(300 + 200 * i, 376, -speed, 130, 130));
		}
		for(int i = 0; i < 4; i++) {
			if (i == 3) {
				turtles.add(new WetTurtle(700, 376, -speed, 130, 130));
			}else {
				//add(new WetTurtle(200 + 200 * i, 217, -speed, 130, 130));
			}
		}
		return turtles;

	}

}
