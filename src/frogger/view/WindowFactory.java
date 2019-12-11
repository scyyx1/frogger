package frogger.view;

import frogger.model.GameModel;
import javafx.scene.control.Label;

/**
 * @author scyyx1
 * Represents a window factory to create different kinds of windows.
 * Contains some functions to return.
 */
public class WindowFactory {

	/**
	 * Get the start window object.
	 * @return the start window class.
	 */
	public StartWindow createStartWindow() {
		return new StartWindow();
	}
	
	/**
	 * Get the help window object.
	 * @return the help window class.
	 */
	public HelpWindow createHelpWindow() {
		return new HelpWindow();
	}
	
	/**
	 * Get the difficult window object.
	 * @return the difficult window class.
	 */
	public DifficultyWindow createDifficultyWindow() {
		return new DifficultyWindow();
	}
	
	/**
	 * Get the game world object.
	 * @return the game world class.
	 */
	public GameWorld createGameWorld (GameModel gameModel, int difficultyLevel, int level) {
		return new GameWorld(gameModel, difficultyLevel, level);
	}
	
	/**
	 * Get the game over window object.
	 * @return the game over window class.
	 */
	public GameOverWindow createGameOverWindow(int finalScore, boolean winStatus) {
		return new GameOverWindow(finalScore, winStatus);
	}
	
	/**
	 * Get the score window object.
	 * @return the score window class.
	 */
	public ScoreWindow createScoreWindow(Label yourScore) {
		return new ScoreWindow(yourScore);
	}

	
}
