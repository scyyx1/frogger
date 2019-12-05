package com.scyyx1.frogger.view;

import com.scyyx1.frogger.control.GameController;
import com.scyyx1.frogger.model.GameModel;

public class GameEngine {

	private GameModel gameModel;
	private GameWindow gameWindow;
	private GameController gameController;
	public GameEngine(int difficultyLevel) {
		gameModel = new GameModel();
		gameWindow = new GameWindow(gameModel, difficultyLevel);
    	gameController = new GameController(gameModel, gameWindow);
	}
	
	public GameWindow asView() {
		return gameWindow;
	}
	
}
