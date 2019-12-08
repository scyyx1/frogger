package frogger.control;

import frogger.main.Main;
import frogger.view.DifficultyWindow;
import frogger.view.HelpWindow;
import frogger.view.WindowFactory;
import javafx.scene.Scene;

/**
 * @author scyyx1
 * Represents the controller for start window.
 * Contains some button action set for start window.
 */
public class StartWindowController {
	
	/**
	 * Handle the events when the button is pressed.
	 * Switch to the difficulty window to allow the user to select the difficulty level. 
	 */
	public void startButtonAction() {
		DifficultyWindow difficultyWindow = new WindowFactory().createDifficultyWindow();
    	Scene scene = new Scene(difficultyWindow, 500, 500);
    	scene.getStylesheets().add("file:resource/application.css");
    	Main.getStage().setScene(scene);
	}
	
	/**
	 * Handle the events when the button is pressed.
	 * Switch to help window to allow user to see the instructions of the game.
	 */
	public void helpButtonAction() {
    	HelpWindow helpWindow = new WindowFactory().createHelpWindow();
    	Scene scene = new Scene(helpWindow, 500, 500);
    	scene.getStylesheets().add("file:resource/application.css");
    	Main.getStage().setScene(scene);
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
