package frogger.view;



import frogger.control.StartWindowController;
import frogger.control.WindowController;
import frogger.main.Main;
import frogger.model.actors.BackgroundImage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;





public class StartWindow extends Pane implements GUIFactory{


	public static Stage stage;
	public StartWindow() {

		
		createBackground();
		
		createLabel();
		
		createIcon();
		
		createButton();
	}
	
	public static Stage getStage() {
		return stage;
	}

	@Override
	public void createBackground() {
		// TODO Auto-generated method stub
		getChildren().add(new BackgroundImage("file:resource/backgrounds/startbackground.png", 500, 500));
	}

	@Override
	public void createButton() {
		StartWindowController controller = new StartWindowController();
		// TODO Auto-generated method stub
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

	@Override
	public void createLabel() {
		// TODO Auto-generated method stub
		Label title = new Label("FROGGER");
		title.setLayoutX(120);
		title.setLayoutY(50);
		title.setId("title");
		title.setTextFill(Color.CADETBLUE);
		getChildren().add(title);
	}
	
	public void createIcon() {
		Image image = new Image("file:resource/frogs/frog.png", 200, 200, false, false);
		ImageView icon = new ImageView(image);
		icon.setX(150);
		icon.setY(300);
		getChildren().add(icon);
	}

}
