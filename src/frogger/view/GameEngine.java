package frogger.view;

import frogger.control.GameController;
import frogger.model.GameModel;

public class GameEngine {

	private GameModel gameModel;
	private GameWorld gameWorld;
	private GameController gameController;
	public GameEngine(int difficultyLevel) {
		gameModel = new GameModel();
		gameWorld = new GameWorld(gameModel, difficultyLevel);
	}
	
	public GameEngine(int difficultyLevel, int points) {
		gameModel = new GameModel(points);
		gameWorld = new GameWorld(gameModel, difficultyLevel);
	}
	public GameWorld asView() {
		return gameWorld;
	}
	
}
