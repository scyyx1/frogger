package frogger.view;

import frogger.control.WindowController;
import frogger.obstacle_view.BackgroundImage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class HelpWindow extends Pane{

	
	public HelpWindow() {
		
		WindowController controller = new WindowController();
		getChildren().add(new BackgroundImage("file:resource/backgrounds/startbackground.png", 500, 500));
		
		Label title = new Label("INFOMATION");
		title.setLayoutX(110);
		title.setLayoutY(50);
		title.setId("infomation");
		title.setTextFill(Color.CADETBLUE);
		getChildren().add(title);
		
		Button back = new Button("BACK");
		back.setOnAction(e ->{
			controller.backButtonAction();
		});
		back.setId("back");
		back.setLayoutX(200);
		back.setLayoutY(450);
		getChildren().add(back);

	}
}
