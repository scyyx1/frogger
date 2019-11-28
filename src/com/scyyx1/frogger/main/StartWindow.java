package com.scyyx1.frogger.main;


import com.scyyx1.frogger.world.MyStage;
import com.scyyx1.frogger.main.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;





public class StartWindow extends MyStage {

	private Button start;

	public StartWindow(double width, double height) {
		start = new Button("start");
		start.setOnAction(new EventHandler<ActionEvent>() {
		    @Override 
		    public void handle(ActionEvent e) {
		    	GameModel gm = new GameModel();
		    	GameWindow game = new GameWindow(gm, width, height);
		    	GameController wc = new GameController(gm, game);
		    	Scene scene  = new Scene(wc.asView(),width,height);
		    	Main.getStage().setScene(scene);
//		    	ScoreWindow score = new ScoreWindow(width, height);
//		    	Scene scene  = new Scene(score, width,height);
//		    	Main.getStage().setScene(scene);
		    	
		    }
		});
		start.setLayoutX(200);
		start.setLayoutY(250);
		setStyle("-fx-background-color: black;");
		getChildren().add(start);
		
		Button help = new Button("help");
		help.setLayoutX(200);
		help.setLayoutY(400);
		getChildren().add(help);
		
		Button exit = new Button("exit");
		exit.setLayoutX(200);
		exit.setLayoutY(550);
		exit.setOnAction(new EventHandler<ActionEvent>() {
		    @Override 
		    public void handle(ActionEvent e) {
		    	Main.getStage().close();
		    	System.exit(0);
		    	
		    }
		});
		getChildren().add(exit);
	}
	

}
