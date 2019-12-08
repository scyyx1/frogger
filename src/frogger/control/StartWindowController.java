package frogger.control;

import frogger.main.Main;
import frogger.view.DifficultyWindow;
import frogger.view.HelpWindow;
import frogger.view.WindowFactory;
import javafx.scene.Scene;

public class StartWindowController {
	public void startButtonAction() {
		DifficultyWindow dw = new WindowFactory().createDifficultyWindow();
    	Scene scene = new Scene(dw, 500, 500);
    	scene.getStylesheets().add("file:resource/application.css");
    	Main.getStage().setScene(scene);
	}
	
	public void helpButtonAction() {
    	HelpWindow hw = new WindowFactory().createHelpWindow();
    	Scene scene = new Scene(hw, 500, 500);
    	scene.getStylesheets().add("file:resource/application.css");
    	Main.getStage().setScene(scene);
	}
	
	public void exitButtonAction() {
		Main.getStage().close();
    	System.exit(0);
	}
}
