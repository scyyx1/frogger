package frogger.model.actors;

import javafx.scene.image.Image;

/**
 * @author scyyx1
 * Represent a background image object used as background.
 */
public class BackgroundImage extends Actor{
	
	/**
	 * A constructor to initialize the image of background.
	 * @param imageLink The image link of the background.
	 * @param width The width of the image.
	 * @param height The height of the image.
	 */
	public BackgroundImage(String imageLink, double width, double height) {
		setImage(new Image(imageLink, width, height, false, false));
	}


}
