package frogger.util;

import java.util.ArrayList;

import frogger.model.actors.Actor;
import frogger.model.actors.ActorFactory;

/**
 * @author scyyx1
 * Represents a class to generate the log list in the game.
 * Contains a function to return a log list.
 */
public class GenerateLogs extends GenerateActors {

	/**
	 * Get an arraylist of the logs type by the difficulty level and current game level.
	 * @param level The level of current game.
	 * @param difficultyLevel The difficulty level of current game.
	 * @return the list of logs.
	 */
	@Override
	public ArrayList<Actor> createActors(int level, int difficultyLevel) {
		// TODO Auto-generated method stub
		ArrayList<Actor> logs = new ArrayList<>();
		logs.add(ActorFactory.getInstance().createLog("file:resource/logs/log3.png", 150, 200, 166, level *0.35));
		logs.add(ActorFactory.getInstance().createLog("file:resource/logs/log3.png", 150, 600, 166, level *0.35));
		if(difficultyLevel == 1) {
			logs.add(ActorFactory.getInstance().createLog("file:resource/logs/log3.png", 150, 0, 166, level * 0.35));
			logs.add(ActorFactory.getInstance().createLog("file:resource/logs/log3.png", 150, 400, 166, level *0.35));
		}
		else if(difficultyLevel == 2) {
			logs.add(ActorFactory.getInstance().createLog("file:resource/logs/log3.png", 150, 400, 166, level * 0.35));
		}
		logs.add(ActorFactory.getInstance().createLog("file:resource/logs/logs.png", 250, 0, 276, -level *0.5));
		logs.add(ActorFactory.getInstance().createLog("file:resource/logs/logs.png", 250, 400, 276, -level *0.5));
		logs.add(ActorFactory.getInstance().createLog("file:resource/logs/log3.png", 150, 50, 329, level *0.35));
		logs.add(ActorFactory.getInstance().createLog("file:resource/logs/log3.png", 150, 270, 329, level *0.35));
		logs.add(ActorFactory.getInstance().createLog("file:resource/logs/log3.png", 150, 490, 329, level *0.35));
		return logs;
	}

}
