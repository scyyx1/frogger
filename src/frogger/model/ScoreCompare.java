package frogger.model;

import java.util.Comparator;

/**
 * @author scyyx1
 * Represent score compare class to compare the score between two players.
 * Contains a compare method.
 */
public class ScoreCompare implements Comparator<Player>{

	/**
	 * Gets an integer of whether one player's score is higher than the other.
	 * @param p1 The first player.
	 * @param p2 The second player.
	 */
	@Override
	public int compare(Player p1, Player p2) {
		return p2.score - p1.score;
	}
}
