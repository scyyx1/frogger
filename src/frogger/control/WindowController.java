package frogger.control;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import frogger.main.Main;
import frogger.model.Person;
import frogger.model.ScoreCompare;
import frogger.model.actors.Frogger;
import frogger.view.DifficultyWindow;
import frogger.view.GameEngine;
import frogger.view.HelpWindow;
import frogger.view.ScoreWindow;
import frogger.view.StartWindow;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class WindowController {

	private Frogger frog;
	public WindowController() {
	}
	public WindowController(Frogger frog) {
		this.frog = frog;
	};
	
	public void startButtonAction() {
		DifficultyWindow dw = new DifficultyWindow();
    	Scene scene = new Scene(dw, 500, 500);
    	scene.getStylesheets().add("file:resource/application.css");
    	Main.getStage().setScene(scene);
	}
	
	public void helpButtonAction() {
    	HelpWindow hw = new HelpWindow();
    	Scene scene = new Scene(hw, 500, 500);
    	scene.getStylesheets().add("file:resource/application.css");
    	Main.getStage().setScene(scene);
	}
	
	public void exitButtonAction() {
		Main.getStage().close();
    	System.exit(0);
	}
	
	public void easyButtonAction(Stage stage) {
    	GameEngine gameEngine = new GameEngine(1);
    	Scene scene  = new Scene(gameEngine.asView(), 600, 800);
    	Main.getStage().close();
    	stage.setScene(scene);
    	stage.setResizable(false);
    	stage.show();
	}
	
	public void mediumButtonAction(Stage stage) {
		GameEngine gameEngine = new GameEngine(2);
		Scene scene  = new Scene(gameEngine.asView(), 600, 800);
		Main.getStage().close();
		stage.setScene(scene);
		stage.setResizable(false);
		stage.show();
	}
	
	public void difficultButtonAction(Stage stage) {
		GameEngine gameEngine = new GameEngine(3);
		Scene scene  = new Scene(gameEngine.asView(), 600, 800);
		Main.getStage().close();
		stage.setScene(scene);
		stage.setResizable(false);
		stage.show();
	}
	
	public void backButtonAction() {
		StartWindow startwindow = new StartWindow();
	    Scene startscene  = new Scene(startwindow, 500, 500);
	    startscene.getStylesheets().add("file:resource/application.css");
	    Main.getStage().setScene(startscene);
	}
	
	public void enterButtonAction(TextField username) {
		String name = username.getText();
    	if("".equals(name)) {
    		name = "NoName";
    	}
    	ArrayList<Person> lines = new ArrayList<>();
    	try {
    		BufferedReader reader = new BufferedReader(new FileReader("resource/scores/scores.txt"));
    		String currentLine = reader.readLine();
    		while(currentLine != null) {
    			
    			String[] personDetail = currentLine.split(" ");
           
                String uname = personDetail[0];
                int scores = Integer.valueOf(personDetail[1]);
                lines.add(new Person(uname, scores));
    			currentLine = reader.readLine();
    		}
    		reader.close();
    		lines.add(new Person(name, frog.getPoints()));
    		Collections.sort(lines, new ScoreCompare());
    		BufferedWriter writer = new BufferedWriter(new FileWriter("resource/scores/scores.txt"));
    		for (Person line : lines)
            {
                writer.write(line.name);
                writer.write(" " + line.score);
                writer.newLine();
            }
    		writer.close();
    	}catch (IOException e1){
    		e1.printStackTrace();
    	}
    	
    	ScoreWindow score = new ScoreWindow();
    	Scene scene  = new Scene(score, 600, 800);
    	scene.getStylesheets().add("file:resource/application.css");
    	DifficultyWindow.getStage().setScene(scene);
	}
	
	public void restartButtonAction() {
		DifficultyWindow dw = new DifficultyWindow();
    	Scene scene = new Scene(dw, 500, 500);
    	scene.getStylesheets().add("file:resource/application.css");
    	Main.getStage().setScene(scene);
    	Main.getStage().show();
		DifficultyWindow.getStage().close();
	}
}
