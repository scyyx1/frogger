package frogger.model.actors;

import javafx.scene.image.Image;

public class CrocodileBody extends Actor {

	private Image crocodileBody;
	private double moveSpeed;
	
	public CrocodileBody(int xPosition, int yPosition, double moveSpeed, int imageWidth, int imageHeight) {
		crocodileBody = new Image("file:resource/crocodiles/Crocodile.png", imageWidth, imageHeight, true, true);
		
		setX(xPosition);
		setY(yPosition);
		this.moveSpeed = moveSpeed;
		setImage(crocodileBody);
	}
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
