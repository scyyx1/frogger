package frogger.util;

import frogger.model.GameModel;
import frogger.view.GameWorld;

/**
 * @author scyyx1
 * A class to generate the whole game system, include game model and game world.
 */
public class GameEngine {

	/**
	 * A game model to store the data
	 */
	private GameModel gameModel;
	
	/**
	 * A game world to display the game view.
	 */
	private GameWorld gameWorld;

	/**
	 * A constructor to generate the game system and initialize the game model and game world.
	 * @param difficultyLevel The difficulty level player selected.
	 */
	public GameEngine(int difficultyLevel) {
		gameModel = new GameModel();
		gameModel.setLevel(1);
		gameWorld = new GameWorld(gameModel, difficultyLevel, 1);
	}
	
	
	/**
	 * A constructor to generate the game system and initialize the game model and game world with existing points.
	 * @param level The current game level.
	 * @param difficultyLevel The difficuty level of the game.
	 * @param points The points that previous game has.
	 */
	public GameEngine(int level, int difficultyLevel, int points) {
		gameModel = new GameModel(points);
		gameModel.setLevel(level);
		gameWorld = new GameWorld(gameModel, difficultyLevel, level);
	}
	
	/**
	 * Gets the game world object.
	 * @return A game world.
	 */
	public GameWorld asView() {
		return gameWorld;
	}
	
}
