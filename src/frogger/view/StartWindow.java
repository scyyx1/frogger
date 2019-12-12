package frogger.view;



import frogger.control.StartWindowController;
import frogger.model.actors.BackgroundImage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


/**
 * @author scyyx1
 * Represents a start window to allow user to start the game or look at the general operation of the game.
 * Contains some labels, buttons, background and a stage to display the scene.
 */
public class StartWindow extends Pane implements BasicWindowGUI{


	/**
	 * A stage to display the start window.
	 */
	public static Stage stage;
	
	/**
	 * A constructor to initialize the start window.
	 */
	public StartWindow() {

		
		createBackground();
		
		createLabel();
		
		createIcon();
		
		createButton();
	}
	
	/**
	 * Gets the stage of this start window for future display.
	 * @return current stage.
	 */
	public static Stage getStage() {
		return stage;
	}

	/**
	 * Create the background of the start window.
	 * Add it into the scene.
	 */
	@Override
	public void createBackground() {
		// TODO Auto-generated method stub
		getChildren().add(new BackgroundImage("file:resource/backgrounds/startbackground.png", 500, 500));
	}

	/**
	 * Create the buttons in the start window.
	 * Add a start window controller to control the start window.
	 * Add them into the scene.
	 */
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
	
	/**
	 * Create the labels in the difficulty window.
	 * Add them into the scene.
	 */
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
	
	/**
	 * Create an icon for the start window.
	 * Add it into the scene.
	 */
	public void createIcon() {
		Image image = new Image("file:resource/frogs/frog.png", 200, 200, false, false);
		ImageView icon = new ImageView(image);
		icon.setX(150);
		icon.setY(300);
		getChildren().add(icon);
	}

}
