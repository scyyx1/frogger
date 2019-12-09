package frogger.control;

import frogger.model.GameModel;
import frogger.model.actors.FroggerImg;
import frogger.model.actors.Frogger;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;


/**
 * @author scyyx1
 * 
 * Represents the controller for the main game world.
 * Contains some keyboard event during player interacting with the system.
 */

public class GameController{
	
	/**
	 * Gets the object named frogger.
	 */
	private Frogger frogger;
	
	
	/**
	 * The parameter used to record how many times user press the keyboard.
	 */
	private int keyBoardPress;
	
	
	/**
	 * A constructor to initialize frogger.
	 * 
	 * @param model The model should remains the key data of the game.
	 */
	public GameController(GameModel model) {
		this.frogger = model.getFrog();
	}
	
	/**
	 * Handle the event when keyboard is pressed.
	 * If certain event happen, the model will change its internal state according to the event action.
	 * if frog is moved, use event to get key code and update the status and the key press count.
	 * 
	 * @param event This event should be the one connected with Frogger
	 * 				to make sure frogger can update its move and status.
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
				if(frogger.getLastScoreLineRecord() > frogger.getY()) {
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
				if(frogger.getY() < frogger.getLastScoreLineRecord()) {
					frogger.setPoints(frogger.getPoints() + 10 * keyBoardPress);
					frogger.setLastScoreLineRecord(frogger.getY());
					frogger.setChangeScore(true);
				}
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
	
	
	

	

	
	
	
}

