package frogger.view;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import frogger.control.GameController;
import frogger.model.Digit;
import frogger.model.GameModel;
import frogger.model.World;
import frogger.model.actors.Actor;
import frogger.model.actors.ActorFactory;
import frogger.util.FileModified;
import frogger.util.GameEngine;
import frogger.util.GenerateCrocodiles;
import frogger.util.GenerateEnds;
import frogger.util.GenerateLogs;
import frogger.util.GenerateTurtles;
import frogger.util.GenerateVehicles;
import frogger.util.GroupsCollection;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/**
 * @author scyyx1
 * Represent the game world, generate the game element used in the world.
 * Contains different types of actors, game model and game controller etc.
 */
public class GameWorld extends World implements BasicGUI{
	
	/**
	 * A media player to play music
	 */
	private MediaPlayer mediaPlayer;
	
	/**
	 * A game model used in the game world.
	 */
	private GameModel model;
	
	/**
	 * A game controller to control the movement of internal model.
	 */
	private GameController controller;
	
	/**
	 * A rectangle to present the remain time of the game.
	 */
	private Rectangle remainTime;
	
	/**
	 * A group collection that preserve the groups needed to be used in the game world.
	 */
	private GroupsCollection groups;
	
	/**
	 * The difficulty level of current game world.
	 */
	private int difficultyLevel;
	
	/**
	 * A constructor to initialize the game world.
	 * Set up the game model, the difficulty level and the current game level.
	 * Add a controller to control the game world.
	 * Bind the keyboard event and start the game.
	 * @param model The model used in the game world.
	 * @param difficultyLevel The difficulty in current game
	 * @param level The level in current game.
	 */
	public GameWorld(GameModel model, int difficultyLevel, int level) {
		this.model = model;
		this.controller = new GameController(model);
		this.difficultyLevel = difficultyLevel;
		
		createGameWorld(level);
		
		bindKeyBoardEvent();

		start();

	}
	
	/**
	 * This constructor is built for testing.
	 */
	public GameWorld() {
		
	}
	
	/**
	 * Create the game world.
	 * @param level The level in current game
	 */
	public void createGameWorld(int level) {

		createLayout();

		createObstacle(level);

		initializeTheGame();
		
	}

	/**
	 * Create the layout of the game.
	 */
	public void createLayout(){
		
		createBackground();
		createLabel();
		createGroups();
		createCountDown();
		
	}

	/**
	 * Create the obstacles(actors) needed in the game world.
	 * @param level The level in current game.
	 */
	public void createObstacle(int level) {
		createLog(level, difficultyLevel);
		createCrocodile(level, difficultyLevel);
		createSnack(level, difficultyLevel);
		createTurtle(level, difficultyLevel);
		createVehicle(level, difficultyLevel);
		createFrog();
	}
	
	/**
	 * Initialize the game and set up the data needed in the scene.
	 */
	public void initializeTheGame() {
		
		setNumber(0, groups.getCurrentScore(), 450);
		setHiScore();
		createFrogLives();
		playMusic();
	}
	
	/**
	 * Get the highest score in the file and display it on screen.
	 */
	public void setHiScore() {
		FileModified fileModified = new FileModified();
		try {
			fileModified.readFileFromScore();
		}catch(IOException e1){
			e1.printStackTrace();
		}
		setNumber(fileModified.getFirstScore(),groups.getHighestScore(), 170);
	}
	
	/**
	 * Create labels in game world view.
	 * Add them into the view.
	 */
	@Override
	public void createLabel() {
		Label scoreList = new Label("Score Each Round");
		scoreList.setLayoutX(0);
		scoreList.setLayoutY(0);
		scoreList.setFont(Font.font("Mouse"));
		scoreList.setTextFill(Color.CORNSILK);
		getChildren().add(scoreList);
		
		Label previousScore = new Label("HI-SCORE");
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
	
	/**
	 * Create a count down in the game world.
	 * Add it into the view.
	 */
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
	
	/**
	 * Create and add the vehicles needed into the scene.
	 * @param level The level in current game.
	 * @param difficultyLevel The difficulty in current game.
	 */
	public void createVehicle(int level, int difficultyLevel) {
	
		ArrayList<Actor> vehicles = new GenerateVehicles().createActors(level, difficultyLevel);
		for(Actor vehicle: vehicles) {
			add(vehicle);
		}
	}
	
	/**
	 * Create and add the turtles needed into the scene.
	 * @param level The level in current game.
	 * @param difficultyLevel The difficulty in current game.
	 */
	public void createTurtle(int level, int difficultyLevel) {
		
		ArrayList<Actor> turtles = new GenerateTurtles().createActors(level, difficultyLevel);
		for (Actor turtle : turtles) {
			add(turtle);
		}
	}
	
	/**
	 * Create and add the crocodile needed into the scene.
	 * @param level The level in current game.
	 * @param difficultyLevel The difficulty in current game.
	 */
	public void createCrocodile(int level, int difficultyLevel) {
		
		ArrayList<Actor> crocodiles = new GenerateCrocodiles().createActors(level, difficultyLevel);
		if(crocodiles != null) {
			for (Actor crocodile : crocodiles) {
				add(crocodile);
			}
		}
		
	}
	
	/**
	 * Create and add the logs needed into the scene.
	 * @param level The level in current game.
	 * @param difficultyLevel The difficulty in current game.
	 */
	public void createLog(int level, int difficultyLevel) {

		ArrayList<Actor> logs = new GenerateLogs().createActors(level, difficultyLevel);
		for(Actor log : logs) {
			add(log);
		}
	}
	
	/**
	 * Create and add the snacks needed into the scene.
	 * @param level The level in current game.
	 * @param difficultyLevel The difficulty in current game.
	 */
	public void createSnack(int level, int difficultyLevel) {
		int speed = 1;
		if(level > 2) {
			speed = 2;
		}
		if(difficultyLevel != 1) {
			add(ActorFactory.getInstance().createSnake(600, 430, -speed, 100, 100));
		}
		
	}
	
	/**
	 * Create background image of the game world.
	 * Add it into the scene.
	 */
	public void createBackground() {

		add(ActorFactory.getInstance().createBackgroundImage("file:resource/backgrounds/background.png", 600, 800));
		ArrayList<Actor> ends = new GenerateEnds().createActors();
		for(Actor end : ends) {
			add(end);
		}
		
	}
	
	/**
	 * Add the frog initialized in the model into the scene.
	 */
	public void createFrog() {
		add(model.getFrog());
	}
	
	/**
	 * Create and add the groups needed into the system.
	 */
	public void createGroups() {
		
		groups = new GroupsCollection();
		getChildren().add(groups.getCurrentScore());
		getChildren().add(groups.getHighestScore());
		getChildren().add(groups.getFrogLivesGroup());
		getChildren().add(groups.getScoreListGroup());
		
	}

	/**
	 * Create the current lives and add it into the scene.
	 */
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
	
	/**
	 * Create and add the fly randomly into the scene.
	 */
	public void createFlys() {
		int[] endArray = {13, 141, 269, 398, 528};
		int index = (int) (Math.random() * endArray.length);
		add(ActorFactory.getInstance().createFly(60, endArray[index], 96));
	}
	
	public Rectangle getRemainTime() {
		return remainTime;
	}
	
	/**
	 * Update the model and the view each circulation.
	 * @param now The current time.
	 */
	@Override
	public void act(long now) {
		controller.updateStatus(now);
		updateView();
    }
	
	/**
	 * Update current view based on current game model
	 */
	public void updateView() {
		if(model.isGenerateFly()) {
			createFlys();
		}
		if(model.getRemainTimePercentage() > 0) {
			getRemainTime().setWidth(200 * (1 - model.getRemainTimePercentage()));
		}
		if(model.canViewChangeScore()) {
			setNumber(model.getFrog().getPoints(), groups.getCurrentScore(), 450);
		}
		if(model.canResetLiveNumber()) {
    		setScoreList(model.getFrog().getPoints());
    		createFrogLives();
		}
		if(model.canStopView()) {
			stopMusic();
			stop();
			if(model.isSwitchToGameOver()) {
				GameOverWindow gameover = new GameOverWindow(model.getFrog().getPoints(), model.getWinStatus());
				switchScene(gameover, 600, 800);
			}else {
				GameEngine gameEngine = new GameEngine(model.getLevel() + 1, difficultyLevel, model.getFrog().getPoints());
				switchScene(gameEngine.asView(), 600, 800);
			}
		}
	}
	
	/**
	 * Switch the scene in the one user want.
	 * @param pane The pane used to convert to scene.
	 * @param width The width of the pane.
	 * @param height The height of pane.
	 */
	public void switchScene(Pane pane, int width, int height) {
		Scene scene = new Scene(pane, width, height);
		scene.getStylesheets().add("file:resource/application.css");
		DifficultyWindow.getStage().setScene(scene);
	}
	
	/**
	 * Start playing the music in the game world.
	 */
	public void playMusic() {
		String musicFile = "resource/song/Frogger Main Song Theme (loop).mp3";   
		Media sound = new Media(new File(musicFile).toURI().toString());
		mediaPlayer = new MediaPlayer(sound);
		mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
	    mediaPlayer.play();
	}
	
	/**
	 * Stop the music in the game world.
	 */
	public void stopMusic() {
		mediaPlayer.stop();
	}

	/**
	 * Set the number displayed on the scene.
	 * @param number The number that you want to display
	 * @param group The group that want to display the number
	 * @param xPos The x position of the number
	 */
	public void setNumber(int number, Group group, int xPos) {
		group.getChildren().clear();
    	int shift = 0;
    	if(number == 0) {
    		group.getChildren().add(new Digit(0, 30, xPos, 35));
    	}
    	while (number > 0) {
    		int d = number / 10;
    		int k = number - d * 10;
    		number = d;
    		group.getChildren().add(new Digit(k, 30, xPos - shift, 35));
   		  	shift+=30;
    	}
    	
    	
    }
	
	/**
	 * Set the score list displayed on the scene
	 * @param score The score that want to be added into the scene.
	 */
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

	/**
	 * Bind the key board event.
	 */
	public void bindKeyBoardEvent() {

		setOnKeyPressed(e->{
			controller.checkKeyBoardPress(e);
		});
		
		setOnKeyReleased(e->{
			controller.checkKeyBoardRelease(e);
		});
	}

}

