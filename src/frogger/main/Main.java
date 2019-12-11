package frogger.main;


import frogger.view.StartWindow;
import frogger.view.WindowFactory;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


/**
 * @author scyyx1
 * Represents the main function of the game.
 * Allow user to start the launch the system.
 */
public class Main extends Application {
	
	/**
	 * The stage in the main class for displaying the scene.
	 */
	public static Stage startStage;
	
	/**
	 * Main function to launch the system.
	 * 
	 * @param args 
	 */
	public static void main(String[] args) {
		launch(args);
	}

	/**
	 * Gets the stage of this main class.
	 * 
	 * @return current stage
	 */
	public static Stage getStage() {
		return startStage;
	}
	
	/**
	 * To start the system and switch it to start window.
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {
		startStage = primaryStage;
		createStartWindow(primaryStage);

	}
	
	/**
	 * Create the start window and set the startScene to the stage.
	 * Setup some design of the scene.
	 * @param stage This stage should be the stage initialize in the main class.
	 */
	public void createStartWindow(Stage stage) {
		StartWindow startWindow = new WindowFactory().createStartWindow();
	    Scene startScene  = new Scene(startWindow, 500, 500);
	    startScene.getStylesheets().add("file:resource/application.css");
	    
	    stage.setScene(startScene);
	    stage.setResizable(false);
	    stage.initStyle(StageStyle.UNDECORATED);
	    stage.show();
	}
	




   
}
