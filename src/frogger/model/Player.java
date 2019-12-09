package frogger.model;

/**
 * @author scyyx1
 * Represents a player's name and score in the game.
 */
public class Player {
	/**
	 * A player's name.
	 */
	public String name;
	
	/**
	 * A player's score.
	 */
	public int score;
	
	/**
	 * A constructor to initialize the player data.
	 * @param name The name of the player.
	 * @param score The score that player got.
	 */
	public Player(String name, int score) 
    {
        this.name = name;
         
        this.score = score;
    }
}
