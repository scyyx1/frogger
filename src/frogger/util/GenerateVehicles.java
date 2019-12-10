package frogger.util;

import java.util.ArrayList;

import frogger.model.actors.Actor;
import frogger.model.actors.ActorFactory;

/**
 * @author scyyx1
 * Represents a class to generate the vehicles list in the game.
 * Contains a function to return a vehicle list.
 */
public class GenerateVehicles extends GenerateActors {

	/**
	 * Get an arraylist of the vehicles type.
	 * @param level The level of current game.
	 * @param difficultyLevel The difficulty level of current game.
	 * @return the list of vehicles.
	 */
	@Override
	public ArrayList<Actor> createActors(int level, int difficultyLevel) {
		// TODO Auto-generated method stub
		System.out.println(level + " " + difficultyLevel);
		ArrayList<Actor> vehicles = new ArrayList<>();
		int speed = 1;

		if (level > 3) {
			speed = 2;
		}
		vehicles.add(ActorFactory.getInstance().createVehicle("file:resource/vehicles/car1Left.png", 100, 597, -speed, 50, 50));
		if(difficultyLevel == 3) {
			vehicles.add(ActorFactory.getInstance().createVehicle("file:resource/vehicles/car1Left.png", 150, 597, -speed, 50, 50));

		}
		vehicles.add(ActorFactory.getInstance().createVehicle("file:resource/vehicles/car1Left.png", 300, 597, -speed, 50, 50));
		if(difficultyLevel != 1) {
			vehicles.add(ActorFactory.getInstance().createVehicle("file:resource/vehicles/car1Left.png", 450, 597, -speed, 50, 50));
		}
		vehicles.add(ActorFactory.getInstance().createVehicle("file:resource/vehicles/car1Left.png", 500, 490, -speed - 1, 50, 50));

		vehicles.add(ActorFactory.getInstance().createVehicle("file:resource/vehicles/truck1Right.png", 0, 649, speed, 120, 120));
		if(difficultyLevel != 1) {
			vehicles.add(ActorFactory.getInstance().createVehicle("file:resource/vehicles/truck1Right.png", 600, 649, speed, 120, 120));
		}
		vehicles.add(ActorFactory.getInstance().createVehicle("file:resource/vehicles/truck1Right.png", 300, 649, speed, 120, 120));
		vehicles.add(ActorFactory.getInstance().createVehicle("file:resource/vehicles/truck2Right.png", 0, 540, speed, 200, 200));
		if(difficultyLevel != 1) {
			vehicles.add(ActorFactory.getInstance().createVehicle("file:resource/vehicles/truck2Right.png", 500, 540, speed, 200, 200));
		}


		return vehicles;
	}
}
