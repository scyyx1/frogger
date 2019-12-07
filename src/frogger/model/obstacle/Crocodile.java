package frogger.model.obstacle;

import frogger.model.Actor;
import javafx.scene.image.Image;

public class Crocodile extends Actor {

	private Image crocodile;

	private int speed;
	@Override
	public void act(long now) {
		// TODO Auto-generated method stub
		setImage(crocodile);
	
		move(speed , 0);
		if (getX() > 600 && speed>0)
			setX(-200);
		if (getX() < -75 && speed<0)
			setX(600);

	}

	public Crocodile(int xpos, int ypos, int speed, int width, int height) {
		crocodile = new Image("file:resource/crocodiles/Crocodile.png", width, height, true, true);
		
		setX(xpos);
		setY(ypos);
		this.speed = speed;
		setImage(crocodile);
	}
}
