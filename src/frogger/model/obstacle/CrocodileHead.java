package frogger.model.obstacle;

import frogger.model.Actor;
import javafx.scene.image.Image;

public class CrocodileHead extends Actor {

	private Image crocodileOpen;
	private Image crocodileClose;
	private int speed;
	private boolean eaten;
	public boolean isEaten() {
		return eaten;
	}
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
			setX(-200);
		if (getX() < -75 && speed<0)
			setX(600);

	}
	
	public CrocodileHead(int xpos, int ypos, int speed, int width, int height) {
		crocodileOpen = new Image("file:resource/crocodiles/MouthOpen.png", width, height, true, true);
		crocodileClose = new Image("file:resource/crocodiles/MouthShut.png", width, height, true, true);
		setX(xpos);
		setY(ypos);
		this.speed = speed;
		setImage(crocodileClose);
	}

}
