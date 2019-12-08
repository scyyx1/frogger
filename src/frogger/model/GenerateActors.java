package frogger.model;

import java.util.ArrayList;

import frogger.model.actors.Actor;
import frogger.model.actors.ActorFactory;

public abstract class GenerateActors {

	public abstract ArrayList<Actor> createActors(int level);
}
