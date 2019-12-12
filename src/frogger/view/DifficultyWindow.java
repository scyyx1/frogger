package frogger.view;

import frogger.control.DifficultyWindowController;
import frogger.model.actors.BackgroundImage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


/**
 * @author scyyx1
 * Represents a difficulty window to allow user to select different difficulties.
 * Contains some labels, buttons, background and a stage to display the content.
 */
public class DifficultyWindow extends Pane implements BasicWindowGUI{
	
	/**
	 * A stage to display the difficulty window.
	 */
	public static Stage difficultyStage;
	
	/**
	 * A constructor to initialize the difficulty window.
	 */
	public DifficultyWindow() {
		
		difficultyStage = new Stage();
		createBackground();
		
		createLabel();
		
		createButton();
		
	}
	
	/**
	 * Gets the stage of this difficulty class for future display.
	 * @return current stage
	 */
	public static Stage getStage() {
		return difficultyStage;
	}

	/**
	 * Create the background of the difficulty window.
	 * Add it into the scene.
	 */
	@Override
	public void createBackground() {
		
		BackgroundImage background = new BackgroundImage("file:resource/backgrounds/startbackground.png", 500, 500);
		getChildren().add(background);
	}

	/**
	 * Create the buttons in the difficulty window.
	 * Add a difficulty window controller to control the difficulty window.
	 * Add them into the scene.
	 */
	@Override
	public void createButton() {
		DifficultyWindowController controller = new DifficultyWindowController();
		
		Button easy = new Button("EASY");
		easy.setOnAction(e->{
			controller.easyButtonAction(difficultyStage);
		});
		easy.setLayoutX(150);
		easy.setLayoutY(150);
		getChildren().add(easy);
		
		Button medium = new Button("MEDIUM");
		medium.setOnAction(e->{
			controller.mediumButtonAction(difficultyStage);
		});
		medium.setLayoutX(150);
		medium.setLayoutY(250);
		getChildren().add(medium);
		
		Button difficult = new Button("DIFFICULT");
		difficult.setOnAction(e->{
			controller.difficultButtonAction(difficultyStage);
		});
		difficult.setLayoutX(150);
		difficult.setLayoutY(350);
		getChildren().add(difficult);
		
		Button back = new Button("BACK");
		back.setOnAction(e ->{
			controller.backButtonAction();
		});
		back.setId("back");
		back.setLayoutX(0);
		back.setLayoutY(450);
		getChildren().add(back);
	}

	/**
	 * Create the labels in the difficulty window.
	 * Add them into the scene.
	 */
	@Override
	public void createLabel() {
		
		Label title = new Label("SELECT DIFFICULTIES");
		title.setLayoutX(60);
		title.setLayoutY(50);
		title.setId("Difficulty");
		title.setTextFill(Color.CADETBLUE);
		getChildren().add(title);
	}
}
