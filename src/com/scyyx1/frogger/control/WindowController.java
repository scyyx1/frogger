package com.scyyx1.frogger.control;

import com.scyyx1.frogger.main.Main;
import com.scyyx1.frogger.view.DifficultyWindow;
import com.scyyx1.frogger.view.GameEngine;
import com.scyyx1.frogger.view.HelpWindow;
import com.scyyx1.frogger.view.StartWindow;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class WindowController {

	public WindowController() {
//		startWindow.getStartButton().setOnAction(e ->{
//			DifficultyWindow dw = new DifficultyWindow();
//	    	Scene scene = new Scene(dw, 500, 500);
//	    	scene.getStylesheets().add("file:resource/application.css");
//	    	Main.getStage().setScene(scene);
//	    	ScoreWindow score = new ScoreWindow(width, height);
//	    	Scene scene  = new Scene(score, width,height);
//	    	Main.getStage().setScene(scene);
//	    	WinGame wg = new WinGame();
//	    	Scene scene  = new Scene(wg,6);
//	    	Main.getStage().setScene(scene);
//		});
//		
//		startWindow.getHelpButton().setOnAction(e->{
//			Stage helpStage = new Stage();
//	    	HelpWindow hw = new HelpWindow();
//	    	Scene scene = new Scene(hw, 500, 500);
//	    	helpStage.setScene(scene);
//	    	helpStage.show();
//		});
//		
//		startWindow.getExitButton().setOnAction(e->{
//			Main.getStage().close();
//	    	System.exit(0);
//		});
	}
	
	public void startButtonAction() {
		DifficultyWindow dw = new DifficultyWindow();
    	Scene scene = new Scene(dw, 500, 500);
    	scene.getStylesheets().add("file:resource/application.css");
    	Main.getStage().setScene(scene);
	}
	
	public void helpButtonAction() {
		Stage helpStage = new Stage();
    	HelpWindow hw = new HelpWindow();
    	Scene scene = new Scene(hw, 500, 500);
    	helpStage.setScene(scene);
    	helpStage.show();
	}
	
	public void exitButtonAction() {
		Main.getStage().close();
    	System.exit(0);
	}
	
	public void easyButtonAction(Stage stage) {
		stage = new Stage();
    	GameEngine gameEngine = new GameEngine(1);
    	Scene scene  = new Scene(gameEngine.asView(), 600, 800);
    	Main.getStage().close();
    	stage.setScene(scene);
    	stage.setResizable(false);
    	stage.show();
	}
	
	public void mediumButtonAction(Stage stage) {
		stage = new Stage();
		GameEngine gameEngine = new GameEngine(2);
		Scene scene  = new Scene(gameEngine.asView(), 600, 800);
		Main.getStage().close();
		stage.setScene(scene);
		stage.setResizable(false);
		stage.show();
	}
	
	public void difficultButtonAction(Stage stage) {
		stage = new Stage();
		GameEngine gameEngine = new GameEngine(3);
		Scene scene  = new Scene(gameEngine.asView(), 600, 800);
		Main.getStage().close();
		stage.setScene(scene);
		stage.setResizable(false);
		stage.show();
	}
	
	public void backButtonAction() {
		StartWindow startwindow = new StartWindow();
	    Scene startscene  = new Scene(startwindow, 500, 500);
	    startscene.getStylesheets().add("file:resource/application.css");
	    Main.getStage().setScene(startscene);
	}
}
