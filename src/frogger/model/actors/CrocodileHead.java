package frogger.model.actors;

import javafx.scene.image.Image;

/**
 * @author scyyx1
 * Represent a crocodile head to generate the image of crocodile head.
 * Contains images of crodile head and the speed it moves and the is eaten data.
 */
public class CrocodileHead extends Actor {

	/**
	 * The image of crocodile mouth open.
	 */
	private Image crocodileOpen;
	/**
	 * The image of crocodile mouth close.
	 */
	private Image crocodileClose;
	/**
	 * The move speed of the image.
	 */
	private double speed;
	/**
	 * The status of whether is eaten.
	 */
	private boolean eaten;
	
	/**
	 * A constructor to initialize the crocodile head image and its status.
	 * @param xPosition The x position of the image.
	 * @param yPosition The y position of the image.
	 * @param moveSpeed The move speed of the image.
	 * @param imageWidth The width of the image.
	 * @param imageHeight The height of the image.
	 */
	public CrocodileHead(int xPosition, int yPosition, double moveSpeed, int imageWidth, int imageHeight) {
		crocodileOpen = new Image("file:resource/crocodiles/MouthOpen.png", imageWidth, imageHeight, true, true);
		crocodileClose = new Image("file:resource/crocodiles/MouthShut.png", imageWidth, imageHeight, true, true);
		setX(xPosition);
		setY(yPosition);
		this.speed = moveSpeed;
		setImage(crocodileClose);
	}
	/**
	 * How the image will act during different period.
	 * Switch between different status and move the image.
	 * @param now The current time.
	 */
	@Override
	public void act(long now) {
		// TODO Auto-generated method stub
		if (now/900000000 % 2 == 1) {
			setImage(crocodileOpen);
			eaten = true;
		}else if (now/900000000 % 2 == 0){
			setImage(crocodileClose);
			eaten = false;
		}
	
		move(speed , 0);
		if (getX() > 600 && speed>0)
			setX(-180);
		if (getX() < -75 && speed<0)
			setX(700);

	}
	public boolean isEaten() {
		return eaten;
	}

}
