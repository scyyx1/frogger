package frogger.view;

import java.io.File;
import java.util.ArrayList;

import frogger.control.GameController;
import frogger.model.Digit;
import frogger.model.GameModel;
import frogger.model.GenerateCrocodiles;
import frogger.model.GenerateEnds;
import frogger.model.GenerateLogs;
import frogger.model.GenerateTurtles;
import frogger.model.GenerateVehicles;

import frogger.model.World;
import frogger.model.actors.Actor;
import frogger.model.actors.ActorFactory;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class GameWorld extends World{
	
	MediaPlayer mediaPlayer;
	private GameModel model;
	private GameController controller;
	private Rectangle remainTime;
	private GroupsCollection groups;
	
	public GameWorld(GameModel model, int level) {
		this.model = model;
		this.controller = new GameController(model);
		
		
		createGameWorld(level);
		
		bindKeyBoardEvent();

		start();

	}
	
	public void createGameWorld(int level) {

		createLayout(level);

		createObstacle(level);

		initilizeTheGame();
		
	}

	public void createLayout(int level){
		
		createBackground();
		createLabels();
		createGroups();
		createCountDown();
		
	}

	public void createObstacle(int level) {
		createLog(level);
		createCrocodile(level);
		createSnack(level);
		createTurtle(level);
		createVehicle(level);
		createFrog();
	}
	
	public void initilizeTheGame() {
		
		setNumber(0, groups.getCurrentScore(), 450);
		setNumber(0, groups.getPreviousScore(), 170);
		createFrogLives();
		playMusic();
	}
	
	public void createLabels() {
		Label scoreList = new Label("Score Each Round");
		scoreList.setLayoutX(0);
		scoreList.setLayoutY(0);
		scoreList.setFont(Font.font("Mouse"));
		scoreList.setTextFill(Color.CORNSILK);
		getChildren().add(scoreList);
		
		Label previousScore = new Label("PREV-SCORE");
		previousScore.setLayoutX(120);
		previousScore.setLayoutY(5);
		previousScore.setFont(Font.font("Mouse", FontWeight.BOLD, 30));
		previousScore.setTextFill(Color.CORNSILK);
		getChildren().add(previousScore);
		
		Label currentScore = new Label("SCORE");
		currentScore.setLayoutX(400);
		currentScore.setLayoutY(5);
		currentScore.setFont(Font.font("Mouse", FontWeight.BOLD, 30));
		currentScore.setTextFill(Color.CORNSILK);
		getChildren().add(currentScore);
		
		Label level = new Label("LEVEL: " + model.getLevel());
		level.setLayoutX(160);
		level.setLayoutY(755);
		level.setFont(Font.font("Mouse", FontWeight.BOLD, 30));
		level.setTextFill(Color.CORNSILK);
		getChildren().add(level);
		
		
	}
	
	public void createCountDown(){
		Label time = new Label("TIME");
		time.setLayoutX(320);
		time.setLayoutY(755);
		time.setFont(Font.font("Mouse", FontWeight.BOLD, 30));
		time.setTextFill(Color.DARKGREEN);
		getChildren().add(time);
		
		remainTime = new Rectangle(200, 30, Color.DARKGREEN);
		remainTime.setX(400);
		remainTime.setY(760);
		getChildren().add(remainTime);
	}
	
	public void createVehicle(int level) {
	
		ArrayList<Actor> vehicles = new GenerateVehicles().createActors(level);
		for(Actor vehicle: vehicles) {
			add(vehicle);
		}
	}
	
	public void createTurtle(int level) {
		
		ArrayList<Actor> turtles = new GenerateTurtles().createActors(level);
		for (Actor turtle : turtles) {
			add(turtle);
		}
	}

	public void createCrocodile(int level) {
		
		ArrayList<Actor> crocodiles = new GenerateCrocodiles().createActors(level);
		if(crocodiles != null) {
			for (Actor crocodile : crocodiles) {
				add(crocodile);
			}
		}
		
	}
	
	public void createLog(int level) {

		ArrayList<Actor> logs = new GenerateLogs().createActors(level);
		for(Actor log : logs) {
			add(log);
		}
	}
	
	public void createSnack(int level) {
		if(level > 2) {
			add(new ActorFactory().createSnack(600, 430, -1, 100, 100));
		}
	}
	
	public void createBackground() {

		add(new ActorFactory().createBackgroundImage("file:resource/backgrounds/background.png", 600, 800));
		ArrayList<Actor> ends = new GenerateEnds().createActors();
		for(Actor end : ends) {
			add(end);
		}
		
	}
	
	public void createFrog() {
		add(model.getFrog());
	}
	
	public void createGroups() {
		
		groups = new GroupsCollection();
		getChildren().add(groups.getCurrentScore());
		getChildren().add(groups.getPreviousScore());
		getChildren().add(groups.getFrogLivesGroup());
		getChildren().add(groups.getScoreListGroup());
		
	}

	public void createFrogLives() {
		groups.getFrogLivesGroup().getChildren().clear();
		int lives = model.getFrog().getLives();
		for(int i = 0; i < lives; i++) {
			Image frog = new Image("file:resource/frogs/froggerUp.png", 20, 20, false, false);
			ImageView frogLive = new ImageView(frog);
			frogLive.setX(0 + (i * 20));
			frogLive.setY(750);
			groups.getFrogLivesGroup().getChildren().add(frogLive);
		}
	}
		
	public void createFlys() {
		int[] endArray = {13, 141, 269, 398, 528};
		int index = (int) (Math.random() * endArray.length);
		add(new ActorFactory().createFly(60, endArray[index], 96));
	}
	
	public Rectangle getRemainTime() {
		return remainTime;
	}
	
	@Override
	public void act(long now) {
		model.updateModel(now);
		if(model.isGenerateFly()) {
			createFlys();
		}
		if(model.getChangeRec() > 0) {
			getRemainTime().setWidth(200 * (1 - model.getChangeRec()));
		}
		if(model.isChangeScore()) {

			setNumber(model.getFrog().getPoints(), groups.getCurrentScore(), 450);
		}
		if(model.isChangePrev()) {
			setNumber(model.getFrog().getPrev_points(), groups.getPreviousScore(), 170);
    		setScoreList(model.getFrog().getPoints());
    		createFrogLives();
		}
		if(model.isStop()) {
			stopMusic();
			stop();
			if(model.isSwitchToGameOver()) {
				GameOverWindow gameover = new GameOverWindow(model.getFrog());
				Scene scene  = new Scene(gameover, 600, 800);
				scene.getStylesheets().add("file:resource/application.css");
		    	DifficultyWindow.getStage().setScene(scene);
			}else {
				GameEngine gameEngine = new GameEngine(model.getLevel() + 1,model.getFrog().getPoints());
				Scene scene = new Scene(gameEngine.asView(), 600, 800);
				DifficultyWindow.getStage().setScene(scene);
			}
		}
    }
	
	public void playMusic() {
		String musicFile = "resource/song/Frogger Main Song Theme (loop).mp3";   
		Media sound = new Media(new File(musicFile).toURI().toString());
		mediaPlayer = new MediaPlayer(sound);
		mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
	    mediaPlayer.play();
	}
	
	public void stopMusic() {
		mediaPlayer.stop();
	}

	public void setNumber(int n, Group g, int xPos) {
		g.getChildren().clear();
    	int shift = 0;
    	if(n == 0) {
    		g.getChildren().add(new Digit(0, 30, xPos, 35));
    	}
    	while (n > 0) {
    		  int d = n / 10;
    		  int k = n - d * 10;
    		  n = d;
    		  g.getChildren().add(new Digit(k, 30, xPos - shift, 35));
    		  shift+=30;
    	}
    	
    	
    }
	
	public void setScoreList(int score) {
		groups.getScoreListGroup().getChildren().clear();
		ArrayList<String> list = model.getScoreList();
		model.getScoreList().add(Integer.toString(score));
		for(int i = 0; i < list.size(); i++) {
			 Label scoreLabel = new Label(i+1 + ": " + list.get(i));
			 scoreLabel.setFont(Font.font("Mouse"));
			 scoreLabel.setTextFill(Color.CORNSILK);
			 int X = 0;
			 int Y = (20 + i * 20);
			 scoreLabel.setTranslateX(X);
			 scoreLabel.setTranslateY(Y);
			 groups.getScoreListGroup().getChildren().add(scoreLabel);
		}
	}

	public void bindKeyBoardEvent() {

		setOnKeyPressed(e->{
			controller.checkKeyBoardPress(e);
		});
		
		setOnKeyReleased(e->{
			controller.checkKeyBoardRelease(e);
		});
	}
}

