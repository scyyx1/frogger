package frogger.model.factory;

import java.util.ArrayList;

import frogger.model.Actor;

public abstract class ActorFactory {

	public abstract ArrayList<Actor> createActors(int level);
	
	
}
