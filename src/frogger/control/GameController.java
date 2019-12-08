package frogger.control;

import frogger.model.GameModel;
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
	private Frogger frog;
	
	
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
		this.frog = model.getFrog();
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
		if (!frog.isStopMoving()) {
			if(event.getCode() == KeyCode.W) {
				if(frog.isJump()) {
					frog.setChangeScore(false);
					frog.updateStatus(frog.getImgWInit(), 0, -frog.getMovement()*2);
					
				}else {
					frog.updateStatus(frog.getImgWJump(), 0, -frog.getMovement()*2);
				}
				
				if(frog.getW() > frog.getY()) {
                	keyBoardPress++;
                }

			}
			else if (event.getCode() == KeyCode.S) {
				if(frog.isJump()) {

					frog.updateStatus(frog.getImgSInit(), 0, frog.getMovement()*2);
				}else {

					frog.updateStatus(frog.getImgSJump(), 0, frog.getMovement()*2);
				}
			}
			else if (event.getCode() == KeyCode.D) {
				if(frog.isJump()) {

					frog.updateStatus(frog.getImgDInit(), frog.getMovementX()*2, 0);
				}else {

					frog.updateStatus(frog.getImgDJump(), frog.getMovementX()*2, 0);
				}
			}
			else if (event.getCode() == KeyCode.A) {
				if(frog.isJump()) {

					frog.updateStatus(frog.getImgAInit(), -frog.getMovementX()*2, 0);
				}else {

					frog.updateStatus(frog.getImgAJump(), -frog.getMovementX()*2, 0);
				}
			}
			frog.setJump(!frog.isJump());
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
		
		if (!frog.isStopMoving()) {
			if(event.getCode() == KeyCode.W) {
				if(frog.getY() < frog.getW()) {
					frog.setPoints(frog.getPoints() + 10 * keyBoardPress);
					frog.setW(frog.getY());
					frog.setChangeScore(true);
				}
				keyBoardPress = 0;
				frog.setImage(frog.getImgWInit());

			}
			else if (event.getCode() == KeyCode.A) {
				frog.setImage(frog.getImgAInit());

			}
			else if (event.getCode() == KeyCode.S) {
				frog.setImage(frog.getImgSInit());

			}
			else if (event.getCode() == KeyCode.D) {
				frog.setImage(frog.getImgDInit());

			}
			frog.setJump(false);
		}
	}
	
	
	

	

	
	
	
}

