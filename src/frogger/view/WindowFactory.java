package frogger.view;

import frogger.model.GameModel;
import frogger.model.actors.Frogger;

public class WindowFactory {

	public StartWindow createStartWindow() {
		return new StartWindow();
	}
	
	public HelpWindow createHelpWindow() {
		return new HelpWindow();
	}
	
	public DifficultyWindow createDifficultyWindow() {
		return new DifficultyWindow();
	}
	
	public GameWorld createGameWorld (GameModel gameModel, int level) {
		return new GameWorld(gameModel, level);
	}
	public GameOverWindow createGameOverWindow(Frogger frogger) {
		return new GameOverWindow(frogger);
	}
	
	public ScoreWindow createScoreWindow() {
		return new ScoreWindow();
	}
	
}
