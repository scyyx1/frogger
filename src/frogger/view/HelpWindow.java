package frogger.view;

import frogger.control.HelpWindowController;
import frogger.model.actors.BackgroundImage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

/**
 * @author scyyx1
 * Represent a help window to allow user to know the basic operation and rules of the game.
 * Contains a label, a button and a background image to display the rule.
 */
public class HelpWindow extends Pane implements BasicWindowGUI{

	
	/**
	 * A constructor to initialize the help window
	 */
	
	public HelpWindow() {
		

		createBackground();
		
		createButton();
		
		createLabel();

	}

	/**
	 * Create the background of the help window.
	 * Add it into the scene.
	 */
	@Override
	public void createBackground() {
		// TODO Auto-generated method stub
		getChildren().add(new BackgroundImage("file:resource/backgrounds/helpWindow.png", 500, 500));
	}

	/**
	 * Create the buttons in the help window.
	 * Add a help window controller to control the help window.
	 * Add them into the scene.
	 */
	@Override
	public void createButton() {
		HelpWindowController controller = new HelpWindowController();
		// TODO Auto-generated method stub
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
	
	/**
	 * Create the labels in the help window.
	 * Add them into the scene.
	 */
	
	@Override
	public void createLabel() {
		// TODO Auto-generated method stub
		Label title = new Label("INFOMATION");
		title.setLayoutX(110);
		title.setLayoutY(50);
		title.setId("infomation");
		title.setTextFill(Color.CADETBLUE);
		getChildren().add(title);
	}
}
