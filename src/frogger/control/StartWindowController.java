package frogger.control;

import frogger.main.Main;
import frogger.view.DifficultyWindow;
import frogger.view.HelpWindow;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;

/**
 * @author scyyx1
 * Represents the controller for start window.
 * Contains some button action set for start window.
 * User can open the game or go to help window to look the instruction or can exit the game.
 */
public class StartWindowController {
	
	/**
	 * Handle the events when the start button is pressed.
	 * Switch to the difficulty window to allow the user to select the difficulty level. 
	 */
	public void startButtonAction() {
		DifficultyWindow difficultyWindow = new DifficultyWindow();
    	createWindow(difficultyWindow, 500, 500);
	}
	
	/**
	 * Handle the events when the help button is pressed.
	 * Switch to help window to allow user to see the instructions of the game.
	 */
	public void helpButtonAction() {
    	HelpWindow helpWindow = new HelpWindow();
    	createWindow(helpWindow, 500, 500);
	}
	
	/**
	 * Handle the events when the button is pressed.
	 * Exit the game.
	 */
	public void exitButtonAction() {
		Main.getStage().close();
    	System.exit(0);
	}
	
	/**
	 * Switch to a window from the start window.
	 * @param pane The pane that wanted to be switched.
	 * @param width The width of the pane.
	 * @param height The height of the pane.
	 */
	public void createWindow(Pane pane, int width, int height) {
		Scene scene = new Scene(pane, width, height);
		scene.getStylesheets().add("file:resource/application.css");
    	Main.getStage().setScene(scene);
	}
}
