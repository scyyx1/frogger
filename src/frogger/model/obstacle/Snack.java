package frogger.model.obstacle;

import frogger.model.Actor;
import javafx.scene.image.Image;

public class Snack extends Actor{

	private int speed;
	private Image snake1;
	private Image snake2;
	private Image snake3;
	public Snack(int xpos, int ypos, int speed, int width, int height) {
		snake1 = new Image("file:resource/snakes/snake1.png", width, height, true, true);
		snake2 = new Image("file:resource/snakes/snake2.png", width, height, true, true);
		snake3 = new Image("file:resource/snakes/snake3.png", width, height, true, true);
		setX(xpos);
		setY(ypos);
		setImage(snake1);
		this.speed = speed;
	}

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
