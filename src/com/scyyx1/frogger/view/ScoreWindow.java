package com.scyyx1.frogger.view;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.scyyx1.frogger.control.WindowController;
import com.scyyx1.frogger.main.Main;
import com.scyyx1.frogger.model.GameWorld;
import com.scyyx1.frogger.obstacle_view.BackgroundImage;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class ScoreWindow extends Pane{

	private ArrayList<Label> labels = new ArrayList<>();
	public ScoreWindow() {
		
		WindowController controller = new WindowController();
		
		BackgroundImage background = new BackgroundImage("file:resource/backgrounds/background1.png", 600, 800);
		getChildren().add(background);
		
		Label label = new Label("HIGH SCORE");
		label.setLayoutX(130);
		label.setLayoutY(180);
		label.setFont(Font.font("Mouse", FontWeight.BOLD, 65));
		label.setTextFill(Color.CORNSILK);
        getChildren().add(label);

        
		try {
            FileReader fr = new FileReader("resource/scores/scores.txt");
            BufferedReader br = new BufferedReader(fr);
            for (int i = 0; i < 5; i++) {
            	String line = br.readLine();
            	if(line == null) {
            		break;
            	}
            	String[] personDetail = line.split(" ");
            	labels.add(new Label(i+1 + ":  " + personDetail[0]));
    			labels.add(new Label(personDetail[1]));

            }

            br.close();
            fr.close();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
		


		for (int i = 0; i < labels.size(); i++) {
            Label l = labels.get(i);
            int X = 140;
            int Y = (250 + i * 30);
            l.setFont(new Font("Mouse", 25));
            l.setTextFill(Color.CORNSILK);
            if (i % 2 != 0) {
                X = 400;
                Y = (250 + (i - 1) * 30);
                l.setFont(new Font("Mouse", 25));
                l.setTextFill(Color.CORNSILK);
            }

            l.setTranslateX(X);
            l.setTranslateY(Y);
            getChildren().add(l);
        }
		
		
		Button restart = new Button("TRY AGAIN");
		restart.setId("restart");
		restart.setOnAction(e->{
			controller.restartButtonAction();
		});
		restart.setLayoutX(150);
		restart.setLayoutY(600);
		getChildren().add(restart);
        
		Button exit = new Button("EXIT");
		exit.setOnAction(e->{
			controller.exitButtonAction();
		});
		exit.setLayoutX(200);
		exit.setLayoutY(650);
		getChildren().add(exit);
 

		
		
	}
}
