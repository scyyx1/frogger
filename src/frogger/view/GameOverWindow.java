package frogger.view;

import frogger.control.GameOverController;
import frogger.model.actors.BackgroundImage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/**
 * @author scyyx1
 * Represent a game over window to allow user to enter their name
 * Contains some labels, buttons, background and a final score that a player got.
 */
public class GameOverWindow extends Pane implements BasicGUI{
	
	/**
	 * A final score that a player got.
	 */
	private int finalScore;
	
	/**
	 * The username that player entered.
	 */
	private TextField username;
	
	/**
	 * The status of whether the game is win
	 */
	private boolean winStatus;
	
	/**
	 * A constructor to initialize the game over window
	 * Pass the final score that a player got to the controller and save it into file
	 * @param finalScore The final score that a player got.
	 * @param winStatus The status of whether the game is win
	 */

	public GameOverWindow(int finalScore, boolean winStatus) {
		this.finalScore = finalScore;
		this.winStatus = winStatus;

		createBackground();
		
		createLabel();

		createTextField();
		
		createButton();

	}

	/**
	 * Create the background of the game over window.
	 * Add it into the scene.
	 */
	@Override
	public void createBackground() {
		// TODO Auto-generated method stub
		BackgroundImage background = new BackgroundImage("file:resource/backgrounds/background1.png", 600, 800);
		getChildren().add(background);
	}

	
	/**
	 * Create the buttons in the game over window.
	 * Add a game over window controller to control the game over window.
	 * Add them into the scene.
	 */
	@Override
	public void createButton() {
		// TODO Auto-generated method stub
		GameOverController controller = new GameOverController(finalScore);
		
		Button enter = new Button("ENTER");
		enter.getStyleClass().add("ok");
		enter.setOnAction(e->{

			controller.enterButtonAction(username);

		});
		enter.setLayoutX(200);
		enter.setLayoutY(400);
		getChildren().add(enter);
		
	}

	/**
	 * Create the labels in the game over window based on the winning status.
	 * Add them into the scene.
	 */
	@Override
	public void createLabel() {
		// TODO Auto-generated method stub
		Label title;
		if(winStatus) {
			 title = new Label("YOU   WIN");
		}else {
			 title = new Label("GAME OVER");
		}
		title.setLayoutX(140);
		title.setLayoutY(180);
		title.setFont(Font.font("Mouse", FontWeight.BOLD, 65));
		title.setTextFill(Color.CORNSILK);
		getChildren().add(title);
	}
	
	/**
	 * Create a text field in the game over window.
	 * Add it into the scene.
	 */
	public void createTextField() {
		
		username = new TextField();
		username.setPromptText("Enter your name");
		username.setPrefColumnCount(10);
		username.setLayoutX(200);
		username.setLayoutY(300);
		getChildren().add(username);
	}
	
}
