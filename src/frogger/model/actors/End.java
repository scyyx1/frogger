package frogger.model.actors;

import javafx.scene.image.Image;

/**
 * @author scyyx1
 * Represent an end class and generate the image of end.
 * Contains the status of end.
 */
public class End extends Actor{
	
	/**
	 * The status of the end image of whether it is activated.
	 */
	private boolean activated = false;
	
	/**
	 * A constructor to initialize the end image.
	 * @param x The x position of the image.
	 * @param y The y position of the image.
	 */
	public End(int x, int y) {
		setX(x);
		setY(y);
		setImage(new Image("file:resource/backgrounds/End.png", 60, 60, true, true));
	}
	
	/**
	 * Set the image to be the frog end.
	 * Change the status of activated. 
	 */
	public void setEnd() {
		setImage(new Image("file:resource/frogs/FrogEnd.png", 70, 70, true, true));
		activated = true;
	}
	
	public boolean isActivated() {
		return activated;
	}
	
	/**
	 * How the end image will act.
	 * @param now The current time.
	 */
	@Override
	public void act(long now) {
		// TODO Auto-generated method st
	}
	

}
