package com.scyyx1.frogger.view;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.scyyx1.frogger.main.Main;
import com.scyyx1.frogger.model.MyStage;
import com.scyyx1.frogger.obstacle_view.BackgroundImage;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class ScoreWindow extends MyStage{

	
	public ScoreWindow() {
		BackgroundImage background = new BackgroundImage("file:resource/backgrounds/background1.png", 600, 800);
	    
		add(background);
		Label label = new Label("HIGH SCORE");
		label.setLayoutX(130);
		label.setLayoutY(180);
		label.setFont(Font.font("Verdana", FontWeight.BOLD, 50));
		label.setTextFill(Color.CORNSILK);
        getChildren().add(label);
		ArrayList<Label> labels = new ArrayList<>();
		ArrayList<String>names = new ArrayList<>();
		ArrayList<String>scores = new ArrayList<>();
		try {
            FileReader fr = new FileReader("resource/scores/scores.txt");
            BufferedReader br = new BufferedReader(fr);
            for (int i = 0; i < 5; i++) {
            	String line = br.readLine();
            	if(line == null) {
            		break;
            	}
            	String[] personDetail = line.split(" ");
            	names.add(personDetail[0]);
            	scores.add(personDetail[1]);

            }

            br.close();
            fr.close();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
		
		labels.add(new Label(names.get(0)));
		labels.add(new Label(names.get(1)));
		labels.add(new Label(names.get(2)));
		labels.add(new Label(names.get(3)));
		labels.add(new Label(names.get(4)));
		labels.add(new Label(scores.get(0)));
		labels.add(new Label(scores.get(1)));
		labels.add(new Label(scores.get(2)));
		labels.add(new Label(scores.get(3)));
		labels.add(new Label(scores.get(4)));


		for (int i = 0; i < labels.size(); i++) {
            Label l = labels.get(i);
            int X = 140;
            int Y = (250 + i * 70);
            l.setFont(new Font("Verdana", 25));
            l.setTextFill(Color.CORNSILK);
            if (i > 4) {
                X = 400;
                Y = (250 + (i - 5) * 70);
                l.setFont(new Font("Verdana", 25));
                l.setTextFill(Color.CORNSILK);
            }

            l.setTranslateX(X);
            l.setTranslateY(Y);

            getChildren().add(l);
        }
		
		Button restart = new Button("TRY AGAIN");
		restart.setId("restart");
		restart.setOnAction(new EventHandler<ActionEvent>() {
		    @Override 
		    public void handle(ActionEvent e) {
		    	DifficultyWindow dw = new DifficultyWindow();
		    	Scene scene = new Scene(dw, 500, 500);
		    	scene.getStylesheets().add("file:resource/application.css");
		    	Main.getStage().setScene(scene);
		    	Main.getStage().show();
				DifficultyWindow.getStage().close();

		    }
		});
		restart.setLayoutX(150);
		restart.setLayoutY(600);
		getChildren().add(restart);
        
		Button exit = new Button("EXIT");
		exit.setOnAction(new EventHandler<ActionEvent>() {
		    @Override 
		    public void handle(ActionEvent e) {
		    	System.exit(0);
		    }
		});
		exit.setLayoutX(200);
		exit.setLayoutY(650);
		getChildren().add(exit);
 

		
		
	}
}
