package frogger.util;

import javafx.scene.Group;

/**
 * @author scyyx1
 * Represents a collection of groups.
 * Used to display the information required by the game world.
 * Contains four groups.
 */
public class GroupsCollection {

	/**
	 * A group to display current score.
	 */
	private Group currentScore;
	
	/**
	 * A group to display highest score in the file.
	 */
	private Group highestScore;
	
	/**
	 * A group to display frog lives.
	 */
	private Group frogLivesGroup;
	
	/**
	 * A group to display score list.
	 */
	private Group scoreListGroup;
	
	/**
	 * A Constructor to initialize the group.
	 */
	public GroupsCollection() {
		currentScore = new Group();
		highestScore = new Group();
		frogLivesGroup = new Group();
		scoreListGroup = new Group();
	}
	
	/**
	 * Get the frog lives group
	 * @return frog lives group
	 */
	public Group getFrogLivesGroup() {
		return frogLivesGroup;
	}
	
	/**
	 * Get the score list group.
	 * @return score list group.
	 */
	
	public Group getScoreListGroup() {
		return scoreListGroup;
	}

	/**
	 * Get the current score group.
	 * @return current score group.
	 */
	
	public Group getCurrentScore() {
		return currentScore;
	}

	/**
	 * Get the highest score group.
	 * @return highest score group.
	 */

	public Group getHighestScore() {
		return highestScore;
	}
	
	

}
