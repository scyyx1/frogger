package com.scyyx1.frogger.main;


import com.scyyx1.frogger.world.MyStage;
import com.scyyx1.frogger.main.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
		Image image = new Image("file:resource/frogs/frog.jpg", 240, 180, false, false);
		ImageView icon = new ImageView(image);
		icon.setX(250);
		icon.setY(120);
		getChildren().add(icon);
		start = new Button("start");
		start.setOnAction(new EventHandler<ActionEvent>() {
		    @Override 
		    public void handle(ActionEvent e) {
		    	DifficultyWindow dw = new DifficultyWindow();
		    	Scene scene = new Scene(dw, 400, 400);
		    	Main.getStage().setScene(scene);
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
		help.setOnAction(new EventHandler<ActionEvent>() {
		    @Override 
		    public void handle(ActionEvent e) {
		    	Stage helpStage = new Stage();
		    	HelpWindow hw = new HelpWindow();
		    	Scene scene = new Scene(hw, 500, 500);
		    	helpStage.setScene(scene);
		    	helpStage.show();
		    	
		    }
		});
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
