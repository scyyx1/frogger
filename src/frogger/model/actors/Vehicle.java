package frogger.model.actors;

import javafx.scene.image.Image;

/**
 * @author scyyx1
 * Represent a vehicle class to generate the image of vehicle.
 * Contains the speed vehicle moves.
 */
public class Vehicle extends Actor {
	
	/**
	 * The move speed of image.
	 */
	private int speed;
	
	/**
	 * Change the status of vehicles and move the image.
	 * If the image outside the boundary, reset it. 
	 * @param now The current time.
	 */
	@Override
	public void act(long now) {
		move(speed , 0);
		if (getX() > 600 && speed>0)
			setX(-200);
		if (getX() < -50 && speed<0)
			setX(600);
	}
	
	/**
	 * A constructor to initialize the vehicle image.
	 * @param imageLink the image link of the image.
	 * @param xpos The x position of the image.
	 * @param ypos The y position of the image.
	 * @param speed The move speed of the image.
	 * @param width The width of the image. 
	 * @param height The height of the image.
	 */
	public Vehicle(String imageLink, int xpos, int ypos, int speed, int width, int height) {
		setImage(new Image(imageLink, width,height, true, true));
		setX(xpos);
		setY(ypos);
		this.speed = speed;
	}

}
