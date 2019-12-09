package frogger.model.actors;

import javafx.scene.image.Image;

/**
 * @author scyyx1
 * Represent a wet turtle class to generate the image of wet turtle.
 * Contains four images of wet turtle and the speed it moves.
 */
public class WetTurtle extends Actor{
	
	/**
	 * The image of wet turtle 1
	 */
	private Image turtle1;
	
	/**
	 * The image of wet turtle 2
	 */
	private Image turtle2;
	
	/**
	 * The image of wet turtle 3
	 */
	private Image turtle3;
	
	/**
	 * The image of wet turtle 4
	 */
	private Image turtle4;
	
	/**
	 * The speed it moves.
	 */
	private int speed;
	
	/**
	 * whether it is sunk
	 */
	private boolean sunk = false;
	
	/**
	 * Switch between image wet turtle 1 2 3 and 4 to let it be dynamic.
	 * Move the wet tutles.
	 * Change the status of wet turtles.
	 * @param now The current time.
	 */
	@Override
	public void act(long now) {

				if (now/900000000  % 4 ==0) {
					setImage(turtle2);
					sunk = false;
					
				}
				else if (now/900000000 % 4 == 1) {
					setImage(turtle1);
					sunk = false;
				}
				else if (now/900000000 %4 == 2) {
					setImage(turtle3);
					sunk = false;
				} else if (now/900000000 %4 == 3) {
					setImage(turtle4);
					sunk = true;
				}
			
		move(speed , 0);
		if (getX() > 600 && speed>0)
			setX(-200);
		if (getX() < -75 && speed<0)
			setX(600);
	}
	
	/**
	 * A constructor to initialize the wet turtle image.
	 * @param xpos The x position of the image.
	 * @param ypos The y position of the image.
	 * @param speed The move speed of the image.
	 * @param width The width of the image. 
	 * @param height The height of the image.
	 */
	public WetTurtle(int xpos, int ypos, int speed, int width, int height) {
		turtle1 = new Image("file:resource/turtleAnimations/TurtleAnimation1.png", width, height, true, true);
		turtle2 = new Image("file:resource/turtleAnimations/TurtleAnimation2Wet.png", width, height, true, true);
		turtle3 = new Image("file:resource/turtleAnimations/TurtleAnimation3Wet.png", width, height, true, true);
		turtle4 = new Image("file:resource/turtleAnimations/TurtleAnimation4Wet.png", width, height, true, true);
		setX(xpos);
		setY(ypos);
		this.speed = speed;
		setImage(turtle2);
	}
	public boolean isSunk() {
		return sunk;
	}
}
