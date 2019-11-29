package com.scyyx1.frogger.main;


import com.scyyx1.frogger.world.MyStage;
import com.scyyx1.frogger.main.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;





public class StartWindow extends MyStage {

	private Button start;
	public static Stage stage;
	public StartWindow() {
		Label title = new Label("FROGGER");
		title.setLayoutX(120);
		title.setLayoutY(80);
		title.setFont(Font.font("Verdana", FontWeight.BOLD, 30));
		title.setTextFill(Color.CORAL);
		
		getChildren().add(title);
		start = new Button("start");
		start.setOnAction(new EventHandler<ActionEvent>() {
		    @Override 
		    public void handle(ActionEvent e) {
		    	stage = new Stage();
		    	GameModel gm = new GameModel();
		    	GameWindow game = new GameWindow(gm);
		    	GameController wc = new GameController(gm, game);
		    	Scene scene  = new Scene(wc.asView(), 600, 800);
		    	Main.getStage().close();
		    	stage.setScene(scene);
		    	stage.setResizable(false);
		    	stage.show();
//		    	ScoreWindow score = new ScoreWindow(width, height);
//		    	Scene scene  = new Scene(score, width,height);
//		    	Main.getStage().setScene(scene);
//		    	WinGame wg = new WinGame();
//		    	Scene scene  = new Scene(wg,width,height);
//		    	Main.getStage().setScene(scene);
		    	
		    }
		});
		start.setLayoutX(150);
		start.setLayoutY(150);
		setStyle("-fx-background-color: black;");
		getChildren().add(start);
		
		Button help = new Button("help");
		help.setLayoutX(150);
		help.setLayoutY(200);
		getChildren().add(help);
		
		Button exit = new Button("exit");
		exit.setLayoutX(150);
		exit.setLayoutY(250);
		exit.setOnAction(new EventHandler<ActionEvent>() {
		    @Override 
		    public void handle(ActionEvent e) {
		    	Main.getStage().close();
		    	System.exit(0);
		    	
		    }
		});
		getChildren().add(exit);
	}
	
	public static Stage getStage() {
		return stage;
	}

}
