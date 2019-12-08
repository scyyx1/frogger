package frogger.control;

import frogger.main.Main;
import frogger.view.DifficultyWindow;
import frogger.view.WindowFactory;
import javafx.scene.Scene;

public class ScoreWindowController {

	public void restartButtonAction() {
		DifficultyWindow dw = new WindowFactory().createDifficultyWindow();
    	Scene scene = new Scene(dw, 500, 500);
    	scene.getStylesheets().add("file:resource/application.css");
    	Main.getStage().setScene(scene);
    	Main.getStage().show();
		DifficultyWindow.getStage().close();
	}
	
	public void exitButtonAction() {
		Main.getStage().close();
    	System.exit(0);
	}
}
