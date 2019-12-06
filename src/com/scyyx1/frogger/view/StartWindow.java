package com.scyyx1.frogger.view;



import com.scyyx1.frogger.control.WindowController;
import com.scyyx1.frogger.main.Main;
import com.scyyx1.frogger.model.MyStage;
import com.scyyx1.frogger.obstacle_view.BackgroundImage;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;





public class StartWindow extends MyStage {


	public static Stage stage;
	public StartWindow() {

		WindowController controller = new WindowController();
		add(new BackgroundImage("file:resource/backgrounds/startbackground.png", 500, 500));
		
		Label title = new Label("FROGGER");
		title.setLayoutX(120);
		title.setLayoutY(50);
		title.setId("title");
		title.setTextFill(Color.CADETBLUE);
		getChildren().add(title);
		
		
		Image image = new Image("file:resource/frogs/frog.png", 200, 200, false, false);
		ImageView icon = new ImageView(image);
		icon.setX(150);
		icon.setY(300);
		getChildren().add(icon);
		
		
		Button start = new Button("START");
		start.setOnAction(e->{
			controller.startButtonAction();
		});
		start.setLayoutX(150);
		start.setLayoutY(150);
		getChildren().add(start);
		
		Button help = new Button("HELP");
		help.setLayoutX(150);
		help.setLayoutY(200);
		help.setOnAction(e->{
			controller.helpButtonAction();
		});
		getChildren().add(help);
		
		Button exit = new Button("EXIT");
		exit.setLayoutX(150);
		exit.setLayoutY(250);
		exit.setOnAction(e->{
			controller.exitButtonAction();
		});
		getChildren().add(exit);
	}
	
	public static Stage getStage() {
		return stage;
	}

}
