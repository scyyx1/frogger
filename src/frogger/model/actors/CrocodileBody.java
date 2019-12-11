package frogger.model.actors;

import javafx.scene.image.Image;

/**
 * @author scyyx1
 * Represent a crocodile body to generate the image of crocodile body.
 * Contains an image of crodile body and the speed it moves.
 */
public class CrocodileBody extends Actor {

	/**
	 * The image of crocodile body.
	 */
	private Image crocodileBody;
	
	/**
	 * The move speed of the image.
	 */
	private double moveSpeed;
	
	/**
	 * A constructor to initialize the crocodile body image.
	 * @param xPosition The x position of the image.
	 * @param yPosition The y position of the image.
	 * @param moveSpeed The move speed of the image.
	 * @param imageWidth The width of the image.
	 * @param imageHeight The height of the image.
	 */
	public CrocodileBody(int xPosition, int yPosition, double moveSpeed, int imageWidth, int imageHeight) {
		crocodileBody = new Image("file:resource/crocodiles/Crocodile.png", imageWidth, imageHeight, true, true);
		this.moveSpeed = moveSpeed;
		setX(xPosition);
		setY(yPosition);
		setImage(crocodileBody);
	}
	
	/**
	 * Move the image at given speed. If the image outside the boundary, reset it. 
	 * @param now The current time.
	 */
	@Override
	public void act(long now) {
		// TODO Auto-generated method stub
		setImage(crocodileBody);
	
		move(moveSpeed , 0);
		
		if (getX() > 600 && moveSpeed>0)
			setX(-180);
		if (getX() < -75 && moveSpeed<0)
			setX(700);

	}

}
