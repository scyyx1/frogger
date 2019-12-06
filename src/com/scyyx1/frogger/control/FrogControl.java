package com.scyyx1.frogger.control;

import java.util.ArrayList;

import com.scyyx1.frogger.model.Actor;
import com.scyyx1.frogger.model.Frog;
import com.scyyx1.frogger.obstacle_view.Crocodile;
import com.scyyx1.frogger.obstacle_view.CrocodileHead;
import com.scyyx1.frogger.obstacle_view.End;
import com.scyyx1.frogger.obstacle_view.Fly;
import com.scyyx1.frogger.obstacle_view.FrogView;
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

	private Frog frog;
	private FrogView view;
	private int keyBoardPress = 0;
	public FrogControl(Frog frog, FrogView view) {
		this.frog = frog;
		this.view = view;
	}

	public void checkKeyBoardPress(KeyEvent event) {
		if (!frog.isNoMove()) {
			if(event.getCode() == KeyCode.W) {
				System.out.println(view.getY() + " " + frog.getW());
				if(frog.isJump()) {
					frog.setChangeScore(false);
					frog.setJump(false);
					view.updateStatus(frog.getImgW1(), 0, -frog.getMovement()*2);
					
				}else {
					frog.setJump(true);
					view.updateStatus(frog.getImgW2(), 0, -frog.getMovement()*2);
				}
				
				if(frog.getW() > view.getY()) {
                	keyBoardPress++;
                }

			}
			else if (event.getCode() == KeyCode.S) {
				if(frog.isJump()) {
					frog.setJump(false);
					view.updateStatus(frog.getImgS1(), 0, frog.getMovement()*2);
				}else {
					frog.setJump(true);
					view.updateStatus(frog.getImgW1(), 0, frog.getMovement()*2);
				}
			}
			else if (event.getCode() == KeyCode.D) {
				if(frog.isJump()) {
					frog.setJump(false);
					view.updateStatus(frog.getImgD1(), frog.getMovementX()*2, 0);
				}else {
					frog.setJump(true);
					view.updateStatus(frog.getImgD2(), frog.getMovementX()*2, 0);
				}
			}
			else if (event.getCode() == KeyCode.A) {
				if(frog.isJump()) {
					frog.setJump(false);
					view.updateStatus(frog.getImgA1(), -frog.getMovementX()*2, 0);
				}else {
					frog.setJump(true);
					view.updateStatus(frog.getImgA1(), -frog.getMovementX()*2, 0);
				}
			}
		}
	}
	
	public void checkKeyBoardRelease(KeyEvent event) {
		if (!frog.isNoMove()) {
			if(event.getCode() == KeyCode.W) {
				if(view.getY() < frog.getW()) {
					frog.setPoints(frog.getPoints() + 10 * keyBoardPress);
					frog.setW(view.getY());
					frog.setChangeScore(true);
				}
				keyBoardPress = 0;
				view.setImage(frog.getImgW1());
				frog.setJump(false);
			}
			else if (event.getCode() == KeyCode.A) {
				view.setImage(frog.getImgA1());
				frog.setJump(false);
			}
			else if (event.getCode() == KeyCode.S) {
				view.setImage(frog.getImgS1());
				frog.setJump(false);
			}
			else if (event.getCode() == KeyCode.D) {
				view.setImage(frog.getImgD1());
				frog.setJump(false);
			}
		}
	}

}

