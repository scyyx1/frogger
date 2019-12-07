package frogger.model.factory;

import java.util.ArrayList;

import frogger.model.Actor;
import frogger.model.obstacle.Vehicle;

public class VehicleFactory extends ActorFactory {

	@Override
	public ArrayList<Actor> createActors(int level) {
		// TODO Auto-generated method stub
		
		ArrayList<Actor> vehicles = new ArrayList<>();
		int speed = 1;
		if (level > 3) {
			speed = 2;
		}
		for(int i = 0; i < 5; i++) {
			if (i == 4) {
				vehicles.add(new Vehicle("file:resource/vehicles/car1Left.png", 500, 490, -speed, 50, 50));
			}else {
				vehicles.add(new Vehicle("file:resource/vehicles/car1Left.png", 100+150 * i, 597, -speed, 50, 50));
			}
		}
		for(int i = 0; i < 3; i++) {
			 vehicles.add(new Vehicle("file:resource/vehicles/truck1Right.png", 0 + 300 * i, 649, speed, 120, 120));
		}
		for(int i = 0; i < 2; i++) {
			 vehicles.add(new Vehicle("file:resource/vehicles/truck2Right.png", 0 + 500 * i, 540, speed, 200, 200));
		}
		return vehicles;
	}
}
