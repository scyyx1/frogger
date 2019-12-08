package frogger.model;

import java.util.ArrayList;

import frogger.model.actors.Actor;
import frogger.model.actors.ActorFactory;
import frogger.model.actors.Log;

public class GenerateLogs extends GenerateActors {

	@Override
	public ArrayList<Actor> createActors(int level) {
		// TODO Auto-generated method stub
		ArrayList<Actor> logs = new ArrayList<>();
		logs.add(new ActorFactory().createLog("file:resource/logs/log3.png", 150, 200, 166, level *0.35));
		logs.add(new ActorFactory().createLog("file:resource/logs/log3.png", 150, 400, 166, level *0.35));
		logs.add(new ActorFactory().createLog("file:resource/logs/log3.png", 150, 600, 166, level *0.35));
		if(level <= 3) {
			logs.add(new ActorFactory().createLog("file:resource/logs/log3.png", 150, 0, 166, level * 0.35));
		}
		logs.add(new ActorFactory().createLog("file:resource/logs/logs.png", 250, 0, 276, -level *0.5));
		logs.add(new ActorFactory().createLog("file:resource/logs/logs.png", 250, 400, 276, -level *0.5));
		logs.add(new ActorFactory().createLog("file:resource/logs/log3.png", 150, 50, 329, level *0.35));
		logs.add(new ActorFactory().createLog("file:resource/logs/log3.png", 150, 270, 329, level *0.35));
		logs.add(new ActorFactory().createLog("file:resource/logs/log3.png", 150, 490, 329, level *0.35));
		return logs;
	}

}
