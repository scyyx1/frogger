package frogger.control;

import frogger.main.Main;
import frogger.view.GameEngine;
import frogger.view.StartWindow;
import frogger.view.WindowFactory;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @author scyyx1
 * Represents the controller for difficulty window.
 * Contains some button action set for difficulty window.
 */
public class DifficultyWindowController {
	
	
	/**
	 * Handle the events when the button is pressed.
	 * Switch to the game scene to the easy level.
	 * 
	 * @param stage 
	 * 		This stage should be the one where the user want to display the scene.
	 * 
	 */
	public void easyButtonAction(Stage stage) {
    	GameEngine gameEngine = new GameEngine(1);
    	updateToGameScene(stage, gameEngine, 600, 800);
	}
	
	
	/** 
	 * Handle the events when the button is pressed.
	 * Switch to the game scene to the medium level.
	 * 
	 * @param stage 
	 * 		This stage should be the one where the user want to display the scene.
	 */
	public void mediumButtonAction(Stage stage) {
		GameEngine gameEngine = new GameEngine(2);
		updateToGameScene(stage, gameEngine, 600, 800);
	}
	
	/** 
	 * Handle the events when the button is pressed.
	 * Switch to the game scene to the difficult level.
	 * 
	 * @param stage
	 * 		This stage should be the one where the user want to display the scene.
	 */
	public void difficultButtonAction(Stage stage) {
		GameEngine gameEngine = new GameEngine(3);
		updateToGameScene(stage, gameEngine, 600, 800);
	}
	
	/** 
	 * Handle the events when the button is pressed.
	 * Switch the scene back to the start window.
	 * 
	 */
	public void backButtonAction() {
		StartWindow startwindow = new WindowFactory().createStartWindow();
	    Scene startscene  = new Scene(startwindow, 500, 500);
	    startscene.getStylesheets().add("file:resource/application.css");
	    Main.getStage().setScene(startscene);
	}
	
	
	/** 
	 * Switch the scene in the stage to be the view in game engine.
	 * Close the stage in main to keep only one stage at a time.
	 * 
	 * @param stage This stage should be the one where the user want to display the scene.
	 * @param gameEngine The game engine set up by specific game level.
	 * @param width The width of the scene.
	 * @param height The height of the scene.
	 */
	public void updateToGameScene(Stage stage, GameEngine gameEngine, int width, int height) {
		Scene scene = new Scene(gameEngine.asView(), width, height);
		Main.getStage().close();
		stage.setScene(scene);
		stage.setResizable(false);
		stage.show();
	}
}
