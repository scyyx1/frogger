package frogger.model.factory;

import java.util.ArrayList;

import frogger.model.Actor;
import frogger.model.obstacle.Log;

public class LogFactory extends ActorFactory {

	@Override
	public ArrayList<Actor> createActors(int level) {
		// TODO Auto-generated method stub
		ArrayList<Actor> logs = new ArrayList<>();
		logs.add(new Log("file:resource/logs/log3.png", 150, 0, 166, level * 0.75));

		logs.add(new Log("file:resource/logs/log3.png", 150, 220, 166, level *0.75));
		logs.add(new Log("file:resource/logs/log3.png", 150, 440, 166, level *0.75));
		logs.add(new Log("file:resource/logs/logs.png", 250, 0, 276, -2));
		logs.add(new Log("file:resource/logs/logs.png", 250, 400, 276, -2));
		logs.add(new Log("file:resource/logs/log3.png", 150, 50, 329, level *0.75));
		logs.add(new Log("file:resource/logs/log3.png", 150, 270, 329, level *0.75));
		logs.add(new Log("file:resource/logs/log3.png", 150, 490, 329, level *0.75));
		return logs;
	}

}
