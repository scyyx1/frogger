package frogger.model;



import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * @author scyyx1
 * Represents a digit class to display certain digit at certain place on the screen.
 * Contains an image of digit.
 */
public class Digit extends ImageView{
	
	/**
	 * An image of certain number digit.
	 */
	private Image digitImg;

	/**
	 * A constructor to initialize the data of the digit image.
	 * Set the number, dimension, x position and y position.
	 * @param number The number of digit.
	 * @param dimension The size of the digit image.
	 * @param xPos The x position of the digit image.
	 * @param yPos The y position of the digit image.
	 */
	public Digit(int number, int dimension, int xPos, int yPos) {
		digitImg = new Image("file:resource/digits/"+number+".png", dimension, dimension, true, true);
		setImage(digitImg);
		setX(xPos);
		setY(yPos);
	}
	
}
