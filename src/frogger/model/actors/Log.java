package frogger.model.actors;

import javafx.scene.image.Image;

/**
 * @author scyyx1
 * Represent a log class and generate the image of log.
 * Contains the move speed of the image.
 */
public class Log extends Actor {

	/**
	 * The move speed of the image.
	 */
	private double speed;
	
	/**
	 * How the log image will act.
	 * @param now The current time.
	 */
	@Override
	public void act(long now) {
		move(speed , 0);
		if (getX()>600 && speed>0)
			setX(-180);
		if (getX()<-300 && speed<0)
			setX(700);
	}
	
	/**
	 * A constructor to initialize the log image.
	 * @param imageLink The image link of the image.
	 * @param size The size of the image.
	 * @param xpos The x position of the image.
	 * @param ypos yPosition The y position of the image.
	 * @param speed The speed of the image.
	 */
	public Log(String imageLink, int size, int xpos, int ypos, double speed) {
		setImage(new Image(imageLink, size,size, true, true));
		setX(xpos);
		setY(ypos);
		this.speed = speed;
		
	}
	/**
	 * Check whether the speed is less than zero.
	 * @return whetehr speed is less than zero.
	 */
	public boolean getLeft() {
		return speed < 0;
	}
}