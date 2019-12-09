package frogger.view;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import frogger.control.ScoreWindowController;
import frogger.model.actors.BackgroundImage;
import javafx.scene.layout.Pane;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;


/**
 * @author scyyx1
 * Represents a score window to display the score stored in a file.
 * Only top five scores and your score will be displayed.
 * Contains some labels, buttons and a background.
 */
public class ScoreWindow extends Pane implements BasicGUI{

	/**
	 * An array list to store top five scores in the file.
	 */
	private ArrayList<Label> scores = new ArrayList<>();
	
	/**
	 * A label to score player's current score.
	 */
	private Label currentPlayerScore;
	
	/**
	 * A constructor to initialize the score window.
	 * @param currentPlayerScore The label to store current player score
	 */
	public ScoreWindow(Label currentPlayerScore) {

		this.currentPlayerScore = currentPlayerScore;
		createBackground();

		createLabel();

        
		try {
			
            readFile();
            
        } catch (IOException e1) {
            e1.printStackTrace();
        }
		
		printScore();
		
		createButton();
		
	}
	
	/**
	 * Read the top five scores in file and put them in an array list.
	 * @throws IOException
	 */
	public void readFile() throws IOException{
		FileReader fr = new FileReader("resource/scores/scores.txt");
        BufferedReader br = new BufferedReader(fr);
        for (int i = 0; i < 5; i++) {
        	String line = br.readLine();
        	if(line == null) {
        		break;
        	}
        	String[] personDetail = line.split(" ");
        	scores.add(new Label(i+1 + ":  " + personDetail[0]));
			scores.add(new Label(personDetail[1]));

        }

        br.close();
        fr.close();
	}
	
	/**
	 * Print the data in the array list, put them in the label.
	 * Use label to display.
	 */
	public void printScore() {
		for (int i = 0; i < scores.size(); i++) {
            Label l = scores.get(i);
            int X = 140;
            int Y = (250 + i * 30);
            l.setFont(new Font("Mouse", 25));
            l.setTextFill(Color.CORNSILK);
            if (i % 2 != 0) {
                X = 400;
                Y = (250 + (i - 1) * 30);
                l.setFont(new Font("Mouse", 25));
                l.setTextFill(Color.CORNSILK);
            }

            l.setTranslateX(X);
            l.setTranslateY(Y);
            getChildren().add(l);
        }
		
	}
	
	/**
	 * Create the background of the score window.
	 * Add it into the scene.
	 */
	@Override
	public void createBackground() {
		// TODO Auto-generated method stub
		BackgroundImage background = new BackgroundImage("file:resource/backgrounds/background1.png", 600, 800);
		getChildren().add(background);
	}
	/**
	 * Create the buttons in the score window.
	 * Add them into the scene.
	 */
	@Override
	public void createButton() {
		ScoreWindowController controller = new ScoreWindowController();
		// TODO Auto-generated method stub
		Button restart = new Button("TRY AGAIN");
		restart.setId("restart");
		restart.setOnAction(e->{
			controller.restartButtonAction();
		});
		restart.setLayoutX(150);
		restart.setLayoutY(650);
		getChildren().add(restart);
        
		Button exit = new Button("EXIT");
		exit.setOnAction(e->{
			controller.exitButtonAction();
		});
		exit.setLayoutX(200);
		exit.setLayoutY(700);
		getChildren().add(exit);
	}
	
	/**
	 * Create the labels in the score window.
	 * Add them into the scene.
	 */
	@Override
	public void createLabel() {
		// TODO Auto-generated method stub
		Label label = new Label("HIGH SCORE");
		label.setLayoutX(130);
		label.setLayoutY(180);
		label.setFont(Font.font("Mouse", FontWeight.BOLD, 65));
		label.setTextFill(Color.CORNSILK);
        getChildren().add(label);

        currentPlayerScore.setLayoutX(100);
        currentPlayerScore.setLayoutY(600);
        currentPlayerScore.setFont(Font.font("Mouse", FontWeight.BOLD, 25));
		currentPlayerScore.setTextFill(Color.CORNSILK);
		getChildren().add(currentPlayerScore);
       
	}
}
