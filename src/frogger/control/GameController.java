package frogger.control;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import frogger.model.Digit;
import frogger.model.GameModel;
import frogger.model.actors.Actor;
import frogger.model.actors.Fly;
import frogger.model.actors.Frogger;
import frogger.view.DifficultyWindow;
import frogger.view.GameOver;
import frogger.view.GameWorld;
import frogger.view.WinGame;
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
	private Frogger frog;
	private int keyBoardPress;
	
	public GameController(GameModel model) {
		this.model = model;
		this.frog = model.getFrog();
	}
	

	public void updateWidth(double width) {
		model.setWidth(width);
	}
	
	public void updateHeight(double height) {
		model.setHeight(height);
	}
	
	public void checkKeyBoardPress(KeyEvent event) {
		if (!frog.isNoMove()) {
			if(event.getCode() == KeyCode.W) {
				if(frog.isJump()) {
					frog.setChangeScore(false);
					frog.setJump(false);
					frog.updateStatus(frog.getImgW1(), 0, -frog.getMovement()*2);
					
				}else {
					frog.setJump(true);
					frog.updateStatus(frog.getImgW2(), 0, -frog.getMovement()*2);
				}
				
				if(frog.getW() > frog.getY()) {
                	keyBoardPress++;
                }

			}
			else if (event.getCode() == KeyCode.S) {
				if(frog.isJump()) {
					frog.setJump(false);
					frog.updateStatus(frog.getImgS1(), 0, frog.getMovement()*2);
				}else {
					frog.setJump(true);
					frog.updateStatus(frog.getImgS1(), 0, frog.getMovement()*2);
				}
			}
			else if (event.getCode() == KeyCode.D) {
				if(frog.isJump()) {
					frog.setJump(false);
					frog.updateStatus(frog.getImgD1(), frog.getMovementX()*2, 0);
				}else {
					frog.setJump(true);
					frog.updateStatus(frog.getImgD2(), frog.getMovementX()*2, 0);
				}
			}
			else if (event.getCode() == KeyCode.A) {
				if(frog.isJump()) {
					frog.setJump(false);
					frog.updateStatus(frog.getImgA1(), -frog.getMovementX()*2, 0);
				}else {
					frog.setJump(true);
					frog.updateStatus(frog.getImgA2(), -frog.getMovementX()*2, 0);
				}
			}
		}
	}
	
	public void checkKeyBoardRelease(KeyEvent event) {
		if (!frog.isNoMove()) {
			if(event.getCode() == KeyCode.W) {
				if(frog.getY() < frog.getW()) {
					frog.setPoints(frog.getPoints() + 10 * keyBoardPress);
					frog.setW(frog.getY());
					frog.setChangeScore(true);
				}
				keyBoardPress = 0;
				frog.setImage(frog.getImgW1());
				frog.setJump(false);
			}
			else if (event.getCode() == KeyCode.A) {
				frog.setImage(frog.getImgA1());
				frog.setJump(false);
			}
			else if (event.getCode() == KeyCode.S) {
				frog.setImage(frog.getImgS1());
				frog.setJump(false);
			}
			else if (event.getCode() == KeyCode.D) {
				frog.setImage(frog.getImgD1());
				frog.setJump(false);
			}
		}
	}
	
	
	

	

	
	
	
}

