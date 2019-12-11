package frogger.control;

import frogger.main.Main;
import frogger.view.StartWindow;
import frogger.view.WindowFactory;
import javafx.scene.Scene;

/**
 * @author scyyx1
 * Represents the controller for the help window.
 * Contains a back button to enable user switch back to the start window.
 */
public class HelpWindowController {
	
	/**
	 * Handle the events when the back button is pressed.
	 * Switch the scene back to the start window.
	 */
	public void backButtonAction() {
		StartWindow startwindow = new WindowFactory().createStartWindow();
	    Scene startscene  = new Scene(startwindow, 500, 500);
	    startscene.getStylesheets().add("file:resource/application.css");
	    Main.getStage().setScene(startscene);
	}
}
