package frogger.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import frogger.model.Player;
import frogger.model.ScoreCompare;

/**
 * @author scyyx1
 * Represent a class to modified the file in the game system.
 * Contains the methods of read and update the file and sort and write the file.
 */
public class FileModified {
	
	/**
	 * The final score that a player got.
	 */
	private int finalScore;
	
	/**
	 * The name of the player.
	 */
	private String name;
	
	/**
	 * The arraylist to store the list of players.
	 */
	private ArrayList<Player> players = new ArrayList<>();
	
	public FileModified(String name, int finalScore) {
		this.name = name;
		this.finalScore = finalScore;
	}
	
	
	/**
	 * Update the text inside the score text file by adding new player's infomation.
	 * @throws IOException
	 */
	public void updateFile()throws IOException{
		readFileFromScore();
		players.add(new Player(name, finalScore));
		Collections.sort(players, new ScoreCompare());
		writeFileToScore();
	}
	
	/**
	 * Read the scores file and put them in an array list with Player object
	 * @throws IOException 
	 */
	public void readFileFromScore() throws IOException{
		BufferedReader reader = new BufferedReader(new FileReader("resource/scores/scores.txt"));
		String currentLine = reader.readLine();
		while(currentLine != null) {
			
			String[] personDetail = currentLine.split(" ");
       
            String uname = personDetail[0];
            int scores = Integer.valueOf(personDetail[1]);
            players.add(new Player(uname, scores));
			currentLine = reader.readLine();
		}
		reader.close();
	}
	
	
	/**
	 * Write the date in players list into the score file.
	 * @throws IOException
	 */
	public void writeFileToScore() throws IOException{
		BufferedWriter writer = new BufferedWriter(new FileWriter("resource/scores/scores.txt"));
		for (Player player : players)
        {
            writer.write(player.name);
            writer.write(" " + player.score);
            writer.newLine();
        }
		writer.close();
	}
	
	/**
	 * Gets a list of player stored in the file.
	 * @return An array list with player object.
	 */
	public ArrayList<Player> getPlayersList() {
		return players;
	}
}
