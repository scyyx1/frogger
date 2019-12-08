package frogger.control;

import frogger.main.Main;
import frogger.view.GameEngine;
import frogger.view.StartWindow;
import frogger.view.WindowFactory;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class DifficultyWindowController {
	
	public void easyButtonAction(Stage stage) {
    	GameEngine gameEngine = new GameEngine(1);
    	Scene scene  = new Scene(gameEngine.asView(), 600, 800);
    	Main.getStage().close();
    	stage.setScene(scene);
    	stage.setResizable(false);
    	stage.show();
	}
	
	public void mediumButtonAction(Stage stage) {
		GameEngine gameEngine = new GameEngine(2);
		Scene scene  = new Scene(gameEngine.asView(), 600, 800);
		Main.getStage().close();
		stage.setScene(scene);
		stage.setResizable(false);
		stage.show();
	}
	
	public void difficultButtonAction(Stage stage) {
		GameEngine gameEngine = new GameEngine(3);
		Scene scene  = new Scene(gameEngine.asView(), 600, 800);
		Main.getStage().close();
		stage.setScene(scene);
		stage.setResizable(false);
		stage.show();
	}
	
	public void backButtonAction() {
		StartWindow startwindow = new WindowFactory().createStartWindow();
	    Scene startscene  = new Scene(startwindow, 500, 500);
	    startscene.getStylesheets().add("file:resource/application.css");
	    Main.getStage().setScene(startscene);
	}
}
