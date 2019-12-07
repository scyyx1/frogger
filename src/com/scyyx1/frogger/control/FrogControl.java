package com.scyyx1.frogger.control;

import java.util.ArrayList;

import com.scyyx1.frogger.model.Actor;
import com.scyyx1.frogger.model.Frogger;
import com.scyyx1.frogger.obstacle_view.Crocodile;
import com.scyyx1.frogger.obstacle_view.CrocodileHead;
import com.scyyx1.frogger.obstacle_view.End;
import com.scyyx1.frogger.obstacle_view.Fly;
import com.scyyx1.frogger.obstacle_view.Log;
import com.scyyx1.frogger.obstacle_view.Turtle;
import com.scyyx1.frogger.obstacle_view.Vehicle;
import com.scyyx1.frogger.obstacle_view.WetTurtle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class FrogControl{

	private Frogger frog;
	private int keyBoardPress = 0;
	
	public FrogControl(Frogger frog) {
		this.frog = frog;
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

