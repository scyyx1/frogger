package frogger.model;

import java.util.Comparator;

public class ScoreCompare implements Comparator<Player>{

	@Override
	public int compare(Player p1, Player p2) {
		return p2.score - p1.score;
	}
}
