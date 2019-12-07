package com.scyyx1.frogger.control;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import com.scyyx1.frogger.model.Actor;
import com.scyyx1.frogger.model.Frogger;
import com.scyyx1.frogger.model.GameModel;
import com.scyyx1.frogger.model.GameWorld;
import com.scyyx1.frogger.obstacle_view.Digit;
import com.scyyx1.frogger.obstacle_view.Fly;
import com.scyyx1.frogger.view.DifficultyWindow;
import com.scyyx1.frogger.view.GameOver;
import com.scyyx1.frogger.view.WinGame;

import javafx.animation.AnimationTimer;
import javafx.beans.binding.DoubleBinding;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class GameController{

	private GameModel model;
	private GameWorld view;
	private long startTime;
	public int fly = 1;
	
	public GameController(GameModel model, GameWorld view) {
		this.model = model;
		this.view = view;		
		
	}
	

	public void updateWidth(double width) {
		model.setWidth(width);
	}
	
	public void updateHeight(double height) {
		model.setHeight(height);
	}
	
	
	

	

	
	
	
}

