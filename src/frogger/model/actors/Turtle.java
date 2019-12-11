package frogger.model.actors;

import javafx.scene.image.Image;

/**
 * @author scyyx1
 * Represent a turtle class to generate the image of turtle.
 * Contains three images of turtle and the speed it moves.
 */
public class Turtle extends Actor{
	
	/**
	 * The image of turtle 1
	 */
	private Image turtle1;
	
	/**
	 * The image of turtle 2
	 */
	private Image turtle2;
	
	/**
	 * The image of turtle 3
	 */
	private Image turtle3;
	
	/**
	 * The move speed of the image.
	 */
	private int speed;
	
	/**
	 * Switch between image turtle 1 2 and 3 to let it be dynamic.
	 * Move the tutles.
	 * Change the status of turtles.
	 * If the image outside the boundary, reset it. 
	 * @param now The current time.
	 */
	@Override
	public void act(long now) {

				if (now/900000000  % 3 ==0) {
					setImage(turtle2);
					
				}
				else if (now/900000000 % 3 == 1) {
					setImage(turtle1);
					
				}
				else if (now/900000000 %3 == 2) {
					setImage(turtle3);
					
				}
			
		move(speed , 0);
		if (getX() > 600 && speed>0)
			setX(-200);
		if (getX() < -75 && speed<0)
			setX(600);
	}
	
	/**
	 * A constructor to initialize the turtle image.
	 * @param xpos The x position of the image.
	 * @param ypos The y position of the image.
	 * @param speed The move speed of the image.
	 * @param width The width of the image. 
	 * @param height The height of the image.
	 */
	public Turtle(int xpos, int ypos, int speed, int width, int height) {
		turtle1 = new Image("file:resource/turtleAnimations/TurtleAnimation1.png", width, height, true, true);
		turtle2 = new Image("file:resource/turtleAnimations/TurtleAnimation2.png", width, height, true, true);
		turtle3 = new Image("file:resource/turtleAnimations/TurtleAnimation3.png", width, height, true, true);
		setX(xpos);
		setY(ypos);
		this.speed = speed;
		setImage(turtle2);
	}
}
