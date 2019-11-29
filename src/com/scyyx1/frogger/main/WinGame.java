package com.scyyx1.frogger.main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import com.scyyx1.frogger.frog.Animal;
import com.scyyx1.frogger.world.MyStage;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class WinGame extends MyStage implements Comparator<Person>{

	
	public WinGame(Animal animal) {
		TextField username = new TextField();
		username.setPromptText("Enter your name");
		username.setPrefColumnCount(10);
		getChildren().add(username);
		
		Button ok = new Button("OK");
		ok.setOnAction(new EventHandler<ActionEvent>() {
		    @Override 
		    public void handle(ActionEvent e) {
		    	String name = username.getText();
		    	if("".equals(name)) {
		    		name = "No Name";
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
		    		lines.add(new Person(name, animal.getPoints()));
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
		    	StartWindow.getStage().setScene(scene);
		    }
		});
		ok.setLayoutX(200);
		ok.setLayoutY(400);
		getChildren().add(ok);
	}
	@Override
	public int compare(Person p1, Person p2) {
		return p1.score - p2.score;
	}
}

