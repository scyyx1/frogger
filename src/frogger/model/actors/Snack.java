package frogger.model.actors;

import javafx.scene.image.Image;

/**
 * @author scyyx1
 * Represent a snack class to generate the image of snack.
 * Contains three images of snack and the speed it moves.
 */
public class Snack extends Actor{

	/**
	 * The move speed of the image.
	 */
	private int speed;
	
	/**
	 * The image of snack 1
	 */
	private Image snake1;
	
	/**
	 * The image of snack 2
	 */
	private Image snake2;
	
	/**
	 * The image of snack 3
	 */
	private Image snake3;
	
	/**
	 * A constructor to initialize the snack image.
	 * @param xpos The x position of the image.
	 * @param ypos The y position of the image.
	 * @param speed The move speed of the image.
	 * @param width The width of the image.
	 * @param height The height of the image.
	 */
	public Snack(int xpos, int ypos, int speed, int width, int height) {
		snake1 = new Image("file:resource/snakes/snake1.png", width, height, true, true);
		snake2 = new Image("file:resource/snakes/snake2.png", width, height, true, true);
		snake3 = new Image("file:resource/snakes/snake3.png", width, height, true, true);
		setX(xpos);
		setY(ypos);
		setImage(snake1);
		this.speed = speed;
	}

	/**
	 * Switch between image snack1 2 and 3 to let it be dynamic.
	 * Move the snack.
	 * Change the status of snacks.
	 * @param now The current time.
	 */
	@Override
	public void act(long now) {
		// TODO Auto-generated method stub
		if (now/900000000  % 3 ==0) {
			setImage(snake1);
			
		}
		else if (now/900000000 % 3 == 1) {
			setImage(snake2);
			
		}
		else if (now/900000000 %3 == 2) {
			setImage(snake3);
			
		}
		move(speed , 0);
		if (getX() > 600 && speed>0)
			setX(-200);
		if (getX() < -50 && speed<0)
			setX(600);
	}
}
