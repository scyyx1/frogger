package com.scyyx1.frogger.main;


import com.scyyx1.frogger.world.MyStage;
import com.scyyx1.frogger.main.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;




public class StartWindow extends MyStage {
	private double width;
	private double height;
	private Button start;
	private Button score;
	private Button quit;
	public StartWindow(double width, double height) {
		Button start = new Button("start");
		start.setOnAction(new EventHandler<ActionEvent>() {
		    @Override 
		    public void handle(ActionEvent e) {
		    	GameWindow game = new GameWindow();
		    	Scene scene  = new Scene(game,width,height);
		    	Main.getStage().setScene(scene);
		    }
		});
		start.setLayoutX(200);
		start.setLayoutY(250);
		setStyle("-fx-background-color: black;");
		getChildren().add(start);
	}
	

}
