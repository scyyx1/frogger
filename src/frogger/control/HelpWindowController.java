package frogger.control;

import frogger.main.Main;
import frogger.view.StartWindow;
import frogger.view.WindowFactory;
import javafx.scene.Scene;

public class HelpWindowController {
	public void backButtonAction() {
		StartWindow startwindow = new WindowFactory().createStartWindow();
	    Scene startscene  = new Scene(startwindow, 500, 500);
	    startscene.getStylesheets().add("file:resource/application.css");
	    Main.getStage().setScene(startscene);
	}
}
