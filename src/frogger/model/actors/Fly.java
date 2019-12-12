package frogger.model.actors;

import javafx.scene.image.Image;

/**
 * @author scyyx1
 * Represent a fly class to generate the image of fly.
 */
public class Fly extends Actor {

	
	/**
	 * A constructor to initialize the fly image.
	 * @param dim The size of the image
	 * @param x The x position of the image.
	 * @param y The y position of the image.
	 */
	public Fly(int dim, int x, int y) {
		Image image = new Image("file:resource/fly/fly.png", dim, dim, true, true);
		setImage(image);
		setX(x);
		setY(y);
	}

}
