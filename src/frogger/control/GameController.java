package frogger.control;

import frogger.model.FroggerImg;
import frogger.model.GameModel;
import frogger.model.actors.Frogger;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;


/**
 * @author scyyx1
 * 
 * Represents the controller for the main game world.
 * Contains some keyboard events during player interacting with the system.
 */

public class GameController{
	
	/**
	 * An frogger object which is need to act in game.
	 */
	private Frogger frogger;
	
	/**
	 * A game model
	 */
	private GameModel model;
	/**
	 * The parameter used to record how many times user press the keyboard.
	 */
	private int keyBoardPress;
	
	
	/**
	 * A constructor to initialize set up the frogger and the game model.
	 * 
	 * @param model The game model which stores key data of the game.
	 */
	public GameController(GameModel model) {
		this.model = model;
		this.frogger = model.getFrog();
	}
	
	
	/**
	 * Update the status in model.
	 * @param now the current time.
	 */
	public void updateStatus(long now) {
		model.updateModel(now);
	}
	
	/**
	 * Handle the event when keyboard is pressed.
	 * If certain event happen, the model will change its internal state according to the event action.
	 * if frog is moved, use event to get key code and update the frogger status and the key press count.
	 * 
	 * @param event This event should be the one connected with the game world
	 * 				to get the react from the player.
	 */
	public void checkKeyBoardPress(KeyEvent event) {
		if (!frogger.isStopMoving()) {
			if(event.getCode() == KeyCode.W) {
				if(frogger.isJump()) {
					frogger.setChangeScore(false);
					frogger.updateStatus(new FroggerImg().getImgWInit(), 0, -frogger.getMovementVertical()*2);
					
				}else {
					frogger.updateStatus(new FroggerImg().getImgWJump(), 0, -frogger.getMovementVertical()*2);
				}
				if(pressValid()) {
                	keyBoardPress++;
                }
			}
			else if (event.getCode() == KeyCode.S) {
				if(frogger.isJump()) {
					frogger.updateStatus(new FroggerImg().getImgSInit(), 0, frogger.getMovementVertical()*2);
				}else {
					frogger.updateStatus(new FroggerImg().getImgSJump(), 0, frogger.getMovementVertical()*2);
				}
			}
			else if (event.getCode() == KeyCode.D) {
				if(frogger.isJump()) {
					frogger.updateStatus(new FroggerImg().getImgDInit(), frogger.getMovementHorizon()*2, 0);
				}else {
					frogger.updateStatus(new FroggerImg().getImgDJump(), frogger.getMovementHorizon()*2, 0);
				}
			}
			else if (event.getCode() == KeyCode.A) {
				if(frogger.isJump()) {
					frogger.updateStatus(new FroggerImg().getImgAInit(), -frogger.getMovementHorizon()*2, 0);
				}else {
					frogger.updateStatus(new FroggerImg().getImgAJump(), -frogger.getMovementHorizon()*2, 0);
				}
			}
			frogger.setJump(!frogger.isJump());
		}
	}
	
	/**
	 * Handle the event when keyboard is released.
	 * If certain event happened, the model will change its internal status according to the event action.
	 * if frog is moved, use event to get key code and update the status and initialize the key press count to zero.
	 * 
	 * @param event This event should be the one connected with Frogger
	 * 				to make sure frogger can update its move and status.
	 */
	public void checkKeyBoardRelease(KeyEvent event) {
		
		if (!frogger.isStopMoving()) {
			if(event.getCode() == KeyCode.W) {
				
				updateFroggerDataWhenRelease();
				keyBoardPress = 0;
				frogger.setImage(new FroggerImg().getImgWInit());

			}
			else if (event.getCode() == KeyCode.A) {
				frogger.setImage(new FroggerImg().getImgAInit());

			}
			else if (event.getCode() == KeyCode.S) {
				frogger.setImage(new FroggerImg().getImgSInit());

			}
			else if (event.getCode() == KeyCode.D) {
				frogger.setImage(new FroggerImg().getImgDInit());

			}
			frogger.setJump(false);
		}
	}
	
	/**
	 * Update the points and the y position of last score line record.
	 * Set the change score to true.
	 */
	public void updateFroggerDataWhenRelease() {
		if(pressValid()) {
			frogger.setPoints(frogger.getPoints() + 10 * keyBoardPress);
			frogger.setLastScoreLineRecord(frogger.getY());
			frogger.setChangeScore(true);
		}
	}
	
	/**
	 * Check whether current frogger's y position is less than the last score line record
	 * @return true if the frogger's y is less than the last score line record.
	 */
	public boolean pressValid() {
		return frogger.getY() < frogger.getLastScoreLineRecord();
	}
	
	
	

	

	
	
	
}

