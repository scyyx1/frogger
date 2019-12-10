package frogger.control;

import java.io.IOException;
import frogger.util.FileModified;
import frogger.view.DifficultyWindow;
import frogger.view.ScoreWindow;
import frogger.view.WindowFactory;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * @author scyyx1
 * Represents the controller for the game over window
 * Contains some button action for entering the data and a text field to store the username
 */
public class GameOverController {
	
	/**
	 * The final score that a player got.
	 */
	private int finalScore;
	
	/**
	 * The name of the player.
	 */
	private String name;
	
	
	/**
	 * The label to display current play infomation.
	 */
	private Label currentPlayerInfo;
	/** 
	 * A constructor to initialize the final score that user have
	 * @param frogger The frogger should be the one used in the game
	 */
	public GameOverController(int finalScore) {
		this.finalScore = finalScore;
	}
	
	/**
	 * Handle the event when the button is pressed
	 * Get the name in the textfield and its score and put it in an arrayList with Player Object.
	 * Rewrite the data in the file to keep it in descending order
	 * Switch to score window after finish processing data
	 * @param username This username should be the string that
	 * 				   player typed in the text field
	 */
	public void enterButtonAction(TextField username){
		name = username.getText();
    	if("".equals(name)) {
    		name = "NoName";
    	}
		try {
			FileModified fileModified = new FileModified(name, finalScore);
	    	fileModified.updateFile();
	    	
			currentPlayerInfo = new Label("YOU: Name: " + name + " Score: " + finalScore);
	    	
		}catch(IOException e1) {
			e1.printStackTrace();
		}
		
		ScoreWindow scoreWindow = new WindowFactory().createScoreWindow(currentPlayerInfo);
    	Scene scene  = new Scene(scoreWindow, 600, 800);
    	scene.getStylesheets().add("file:resource/application.css");
    	DifficultyWindow.getStage().setScene(scene);
		
	}
	
	
	

}

