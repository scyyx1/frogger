package frogger.control;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import frogger.model.Person;
import frogger.model.ScoreCompare;
import frogger.model.actors.Frogger;
import frogger.view.DifficultyWindow;
import frogger.view.ScoreWindow;
import frogger.view.WindowFactory;
import javafx.scene.Scene;
import javafx.scene.control.TextField;

public class GameOverController {
	private Frogger frogger;
	private String name;
	private ArrayList<Person> lines = new ArrayList<>();
	
	public GameOverController(Frogger frogger) {
		this.frogger = frogger;
	}
	
	public void enterButtonAction(TextField username){
		name = username.getText();
    	if("".equals(name)) {
    		name = "NoName";
    	}
    	ArrayList<Person> lines = new ArrayList<>();
		try {
	    	readAndUpdateFile();
	    	lines.add(new Person(name, frogger.getPoints()));
	    
	    	
	    	sortAndWriteFile();
	    
		}catch(IOException e1) {
			e1.printStackTrace();
		}
		
		ScoreWindow score = new WindowFactory().createScoreWindow();
    	Scene scene  = new Scene(score, 600, 800);
    	scene.getStylesheets().add("file:resource/application.css");
    	DifficultyWindow.getStage().setScene(scene);
		
	}
	
	public void readAndUpdateFile() throws IOException{
		BufferedReader reader = new BufferedReader(new FileReader("resource/scores/scores.txt"));
		String currentLine = reader.readLine();
		while(currentLine != null) {
			
			String[] personDetail = currentLine.split(" ");
       
            String uname = personDetail[0];
            int scores = Integer.valueOf(personDetail[1]);
            lines.add(new Person(uname, scores));
			currentLine = reader.readLine();
			lines.add(new Person(name, frogger.getPoints()));
		}
		reader.close();
	}
	
	public void sortAndWriteFile() throws IOException{
		Collections.sort(lines, new ScoreCompare());
		BufferedWriter writer = new BufferedWriter(new FileWriter("resource/scores/scores.txt"));
		for (Person line : lines)
        {
            writer.write(line.name);
            writer.write(" " + line.score);
            writer.newLine();
        }
		writer.close();
	}
}

