package frogger.control;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import frogger.main.Main;
import frogger.model.Person;
import frogger.model.ScoreCompare;
import frogger.model.actors.Frogger;
import frogger.view.DifficultyWindow;
import frogger.view.GameEngine;
import frogger.view.HelpWindow;
import frogger.view.ScoreWindow;
import frogger.view.StartWindow;
import frogger.view.WindowFactory;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class WindowController {

	private Frogger frog;
	public WindowController() {
	}
	public WindowController(Frogger frog) {
		this.frog = frog;
	};

	
	public void restartButtonAction() {
		DifficultyWindow dw = new WindowFactory().createDifficultyWindow();
    	Scene scene = new Scene(dw, 500, 500);
    	scene.getStylesheets().add("file:resource/application.css");
    	Main.getStage().setScene(scene);
    	Main.getStage().show();
		DifficultyWindow.getStage().close();
	}
}
