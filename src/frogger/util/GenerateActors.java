package frogger.util;

import java.util.ArrayList;

import frogger.model.actors.Actor;

/**
 * @author scyyx1
 * Represents a class to generate certain actors list.
 * Contains a function to return a list.
 */
public abstract class GenerateActors {

	/**
	 * Get an arraylist of an actor type.
	 * @param level The level of current game.
	 * @param difficultyLevel The difficulty level of current game.
	 * @return the list of certain actor type.
	 */
	public abstract ArrayList<Actor> createActors(int level, int difficultyLevel);
}
