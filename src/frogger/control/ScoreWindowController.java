package frogger.control;

import frogger.main.Main;
import frogger.view.DifficultyWindow;
import frogger.view.WindowFactory;
import javafx.scene.Scene;

/**
 * @author scyyx1
 * Represents the controller for score window.
 * Contains some button action set for score window.
 */
public class ScoreWindowController {

	
	/**
	 * Handle the events when the button is pressed.
	 * Switch to the difficulty window to allow user re-select the game difficulty.
	 * 
	 */
	public void restartButtonAction() {
		DifficultyWindow.getStage().close();
		DifficultyWindow dw = new WindowFactory().createDifficultyWindow();
    	Scene scene = new Scene(dw, 500, 500);
    	scene.getStylesheets().add("file:resource/application.css");
    	Main.getStage().setScene(scene);
    	Main.getStage().show();
	}
	
	/**
	 * Handle the events when the button is pressed.
	 * Exit the game.
	 */
	public void exitButtonAction() {
		Main.getStage().close();
    	System.exit(0);
	}
}
