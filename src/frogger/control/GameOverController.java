package frogger.control;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import frogger.model.Player;
import frogger.model.ScoreCompare;
import frogger.model.actors.Frogger;
import frogger.view.DifficultyWindow;
import frogger.view.ScoreWindow;
import frogger.view.WindowFactory;
import javafx.scene.Scene;
import javafx.scene.control.TextField;

/**
 * @author scyyx1
 * Represents the controller for the game over window
 * Contains some button action for entering the data and a text field to store the username
 */
public class GameOverController {
	
	/**
	 * The frogger object in the main game.
	 */
	private Frogger frogger;
	
	/**
	 * The name of the player.
	 */
	private String name;
	
	/**
	 * The arraylist to store the list of players.
	 */
	private ArrayList<Player> players;
	
	
	/** 
	 * A constructor to initialize the frogger
	 * @param frogger The frogger should be the one used in the game
	 */
	public GameOverController(Frogger frogger) {
		this.frogger = frogger;
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
    	players = new ArrayList<>();
		try {
	    	readFileAndUpdate();
	    	players.add(new Player(name, frogger.getPoints()));
	    
	    	
	    	sortAndWriteFile();
	    
		}catch(IOException e1) {
			e1.printStackTrace();
		}
		
		ScoreWindow scoreWindow = new WindowFactory().createScoreWindow();
    	Scene scene  = new Scene(scoreWindow, 600, 800);
    	scene.getStylesheets().add("file:resource/application.css");
    	DifficultyWindow.getStage().setScene(scene);
		
	}
	
	/**
	 * Read the scores file and put them in an array list with Player object
	 * Add the new player data into the list 
	 * @throws IOException 
	 */
	public void readFileAndUpdate() throws IOException{
		BufferedReader reader = new BufferedReader(new FileReader("resource/scores/scores.txt"));
		String currentLine = reader.readLine();
		while(currentLine != null) {
			
			String[] personDetail = currentLine.split(" ");
       
            String uname = personDetail[0];
            int scores = Integer.valueOf(personDetail[1]);
            players.add(new Player(uname, scores));
			currentLine = reader.readLine();
			players.add(new Player(name, frogger.getPoints()));
		}
		reader.close();
	}
	
	
	/**
	 * Sort the data in an array list and re-write it back to the file
	 * @throws IOException
	 */
	public void sortAndWriteFile() throws IOException{
		Collections.sort(players, new ScoreCompare());
		BufferedWriter writer = new BufferedWriter(new FileWriter("resource/scores/scores.txt"));
		for (Player player : players)
        {
            writer.write(player.name);
            writer.write(" " + player.score);
            writer.newLine();
        }
		writer.close();
	}
}

