package frogger.view;

import frogger.model.GameModel;

public class GameEngine {

	private GameModel gameModel;
	private GameWorld gameWorld;

	public GameEngine(int difficultyLevel) {
		gameModel = new GameModel();
		gameModel.setLevel(1);
		gameWorld = new WindowFactory().createGameWorld(gameModel, difficultyLevel, 1);
	}
	
	public GameEngine(int level, int points, int difficultyLevel) {
		gameModel = new GameModel(points);
		gameModel.setLevel(level);
		gameWorld = new WindowFactory().createGameWorld(gameModel, difficultyLevel, level);
	}
	public GameWorld asView() {
		return gameWorld;
	}
	
}
