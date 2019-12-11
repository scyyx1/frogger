package frogger.control;

import frogger.main.Main;
import frogger.util.GameEngine;
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
	 * Handle the events when the easy button is pressed.
	 * Switch to the game scene that is in easy level.
	 * 
	 * @param stage 
	 * 		This stage should be the one where the user want to display the scene.
	 * 
	 */
	public void easyButtonAction(Stage stage) {
    	GameEngine gameEngine = new GameEngine(1);
    	updateToGameScene(stage, gameEngine);
	}
	
	
	/** 
	 * Handle the events when the medium button is pressed.
	 * Switch to the game scene that is in medium level.
	 * 
	 * @param stage 
	 * 		This stage should be the one where the user want to display the scene.
	 */
	public void mediumButtonAction(Stage stage) {
		GameEngine gameEngine = new GameEngine(2);
		updateToGameScene(stage, gameEngine);
	}
	
	/** 
	 * Handle the events when the difficult button is pressed.
	 * Switch to the game scene that is in difficult level.
	 * 
	 * @param stage
	 * 		This stage should be the one where the user want to display the scene.
	 */
	public void difficultButtonAction(Stage stage) {
		GameEngine gameEngine = new GameEngine(3);
		updateToGameScene(stage, gameEngine);
	}
	
	/** 
	 * Handle the events when the back button is pressed.
	 * Switch the scene back to the start window.
	 */
	public void backButtonAction() {
		StartWindow startWindow = new WindowFactory().createStartWindow();
	    Scene startscene  = new Scene(startWindow, 500, 500);
	    startscene.getStylesheets().add("file:resource/application.css");
	    Main.getStage().setScene(startscene);
	}
	
	
	/** 
	 * Switch the scene in the stage to be the view in game engine.
	 * Close the stage in main to keep only one stage at a time.
	 * 
	 * @param stage This stage should be the one where the user want to display the scene.
	 * @param gameEngine The game engine set up by specific game level.
	 */
	public void updateToGameScene(Stage stage, GameEngine gameEngine) {
		Scene scene = new Scene(gameEngine.asView(), 600, 800);
		Main.getStage().close();
		stage.setScene(scene);
		stage.setResizable(false);
		stage.show();
	}
}
