package frogger.view;

import frogger.control.GameController;
import frogger.model.GameModel;

public class GameEngine {

	private GameModel gameModel;
	private GameWorld gameWorld;

	public GameEngine(int difficultyLevel) {
		gameModel = new GameModel();
		gameModel.setLevel(difficultyLevel);
		gameWorld = new GameWorld(gameModel, difficultyLevel);
	}
	
	public GameEngine(int level, int points) {
		gameModel = new GameModel(points);
		gameModel.setLevel(level);
		gameWorld = new GameWorld(gameModel, level);
	}
	public GameWorld asView() {
		return gameWorld;
	}
	
}
