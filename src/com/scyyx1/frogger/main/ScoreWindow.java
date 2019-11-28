package com.scyyx1.frogger.main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.scyyx1.frogger.frog.Animal;
import com.scyyx1.frogger.world.MyStage;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class ScoreWindow extends MyStage{

	
	public ScoreWindow(Animal animal, double width, double height) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("You Have Won The Game!");
		alert.setHeaderText("Your High Score: "+animal.getPoints()+"!");
		alert.setContentText("Highest Possible Score: 800");
		alert.show();
		Button again = new Button("again");
		again.setOnAction(new EventHandler<ActionEvent>() {
		    @Override 
		    public void handle(ActionEvent e) {
		    	GameModel gm = new GameModel();
		    	GameWindow game = new GameWindow(gm, width, height);
		    	GameController wc = new GameController(gm, game);
		    	Scene scene  = new Scene(wc.asView(),width,height);
		    	Main.getStage().setScene(scene);

		    }
		});
		again.setLayoutX(200);
		again.setLayoutY(250);
		setStyle("-fx-background-color: black;");
		getChildren().add(again);

		Label label = new Label("High Scores");
        label.setFont(new Font("Arial", 20));
        label.setTextFill(Color.web("#FFFFFF"));
        getChildren().add(label);
		ArrayList<Label> labels = new ArrayList<>();
		try {
            FileReader fr = new FileReader("resource/scores/scores.txt");
            BufferedReader br = new BufferedReader(fr);
            FileReader frNames = new FileReader("resource/scores/names.txt");
            BufferedReader brNames = new BufferedReader(frNames);
            for (int i = 0; i < 5; i++) {
            	labels.add(new Label(brNames.readLine()));
            }
            for (int i = 0; i < 5; i++) {
            	labels.add(new Label(br.readLine()));
            }
            frNames.close();
            brNames.close();
            br.close();
            fr.close();
        } catch (IOException e1) {
            e1.printStackTrace();
        }

		for (int i = 0; i < labels.size(); i++) {
            Label l = labels.get(i);
            int X = 140;
            int Y = (198 + i * 70);
            l.setFont(new Font("Snap ITC", 25));
            l.setTextFill(Color.web("#0076a3"));
            if (i > 4) {
                X = 400;
                Y = (198 + (i - 5) * 70);
                l.setFont(new Font("Snap ITC", 25));
                l.setTextFill(Color.web("#0076a3"));
            }

            l.setTranslateX(X);
            l.setTranslateY(Y);

            getChildren().add(l);
        }
        
 

		
		
	}
}
