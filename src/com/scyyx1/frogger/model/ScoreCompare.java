package com.scyyx1.frogger.model;

import java.util.Comparator;

public class ScoreCompare implements Comparator<Person>{

	@Override
	public int compare(Person p1, Person p2) {
		return p2.score - p1.score;
	}
}
