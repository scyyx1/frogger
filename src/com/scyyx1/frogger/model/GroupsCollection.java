package com.scyyx1.frogger.model;

import com.scyyx1.frogger.obstacle_view.Digit;

import javafx.scene.Group;

public class GroupsCollection {

	private Group currentScore;
	private Group previousScore;
	private Group frogLivesGroup = new Group();
	private Group scoreListGroup = new Group();
	public GroupsCollection() {
		currentScore = new Group();
		previousScore = new Group();
		frogLivesGroup = new Group();
		scoreListGroup = new Group();
	}
	
	public Group getFrogLivesGroup() {
		return frogLivesGroup;
	}

	public Group getScoreListGroup() {
		return scoreListGroup;
	}

	public Group getCurrentScore() {
		return currentScore;
	}


	public Group getPreviousScore() {
		return previousScore;
	}
	
	

}
