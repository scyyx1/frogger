package frogger.model;

import java.util.ArrayList;

import frogger.model.actors.ActorFactory;
import frogger.model.actors.Frogger;
import frogger.view.GameWorld;
import frogger.view.GroupsCollection;


public class GameModel {

	private double width;
	private double height;
	private Frogger frog;
	private int fly = 1;
	private boolean generateFly = false;
	private long startTime;
	private double changeRec = 0;
	private boolean changePrev = false;
	private boolean changeScore = false;
	private boolean stop;
	private int level;
	private GroupsCollection groups;
	private ArrayList<String> scoreList = new ArrayList<>(); 
	
	public GameModel() {
		frog = new ActorFactory().createFrogger();
		groups = new GroupsCollection();
		startTime = System.nanoTime();

	}
	
	public GameModel(int points) {
		frog = new Frogger(points);
		groups = new GroupsCollection();
		startTime = System.nanoTime();
	}
	
	
	public boolean isGenerateFly() {
		return generateFly;
	}

	public double getChangeRec() {
		return changeRec;
	}

	public boolean isSwitchToGameOver() {
		return switchToGameOver;
	}

	public boolean isStop() {
		return stop;
	}

	private boolean switchToGameOver;
	public boolean isChangePrev() {
		return changePrev;
	}

	public boolean isChangeScore() {
		return changeScore;
	}

	
	public long getStartTime() {
		return startTime;
	}

	public void setStartTime(long startTime) {
		this.startTime = startTime;
	}

	public void updateModel(long now) {
		changePrev = false;
		changeScore = false;
		generateFly = false;
		changeRec = 0;
		switchToGameOver = false;
		stop = false;
		double elapsedTime =  (now - startTime) / 1000000000.0;
		if(elapsedTime < 180) {
			if(elapsedTime > 5 && fly > 0) {
				generateFly = true;
				fly = 0;
			}
			changeRec = elapsedTime / 180;
		}
		else {
			frog.setLives(0);
		}
		if (frog.isDead()) {
			changePrev = true;
			changeScore = true;
			frog.setDead();
		}
		if(frog.changeScore()) {
			changeScore = true;
		}
		if(frog.getStop()) {
			System.out.print("STOPP:");
			if(frog.getLives() == 0) {
				switchToGameOver = true;
			}
			stop = true;
		}
	}
	public void addGroupsCollection(GameWorld view) {
		view.getChildren().add(groups.getCurrentScore());
		view.getChildren().add(groups.getPreviousScore());
		view.getChildren().add(groups.getFrogLivesGroup());
		view.getChildren().add(groups.getScoreListGroup());
	}
	public ArrayList<String> getScoreList() {
		return scoreList;
	}


	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getWidth() {
		return width;
	}
	
	public void setWidth(double width) {
		this.width = width;
	}
	public void setFrog(Frogger frog) {
		this.frog = frog;
	}
	public Frogger getFrog() {
		return frog;
	}
	public int getLevel() {

		return level;
	}
	public void setLevel(int level) {

		frog.setLevel(level);
		 this.level = level;
	}
	public void setFly(int fly) {
		this.fly = fly;
	}

	public int getFly() {
		return fly;
	}
}
