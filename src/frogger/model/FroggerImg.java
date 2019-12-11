package frogger.model;

import javafx.scene.image.Image;

/**
 * @author scyyx1
 * Represents the images used for displaying the status of frogger.
 */
public class FroggerImg {

	/**
	 * The image size
	 */
	private int imgSize = 40;
	
	/**
	 * The initial image for moving up the frogger
	 */
	private Image imgWInit = new Image("file:resource/frogs/froggerUp.png", imgSize, imgSize, true, true);
	
	/**
	 * The initial image for moving  left the frogger
	 */
	private Image imgAInit = new Image("file:resource/frogs/froggerLeft.png", imgSize, imgSize, true, true);
	
	/**
	 * The initial image for moving  down the frogger
	 */
	private Image imgSInit = new Image("file:resource/frogs/froggerDown.png", imgSize, imgSize, true, true);
	
	/**
	 * The initial image for moving  right the frogger
	 */
	private Image imgDInit = new Image("file:resource/frogs/froggerRight.png", imgSize, imgSize, true, true);
	
	
	/**
	 * The jumping image for moving  up the frogger
	 */
	private Image imgWJump = new Image("file:resource/frogs/froggerUpJump.png", imgSize, imgSize, true, true);
	
	/**
	 * The jumping image for moving  left the frogger
	 */
	private Image imgAJump = new Image("file:resource/frogs/froggerLeftJump.png", imgSize, imgSize, true, true);
	
	/**
	 * The jumping image for moving  down the frogger
	 */
	private Image imgSJump = new Image("file:resource/frogs/froggerDownJump.png", imgSize, imgSize, true, true);
	
	/**
	 * The jumping image for moving right the frogger
	 */
	private Image imgDJump = new Image("file:resource/frogs/froggerRightJump.png", imgSize, imgSize, true, true);
	
	public Image getImgWInit() {
		return imgWInit;
	}
	public Image getImgAInit() {
		return imgAInit;
	}
	public Image getImgSInit() {
		return imgSInit;
	}
	public Image getImgDInit() {
		return imgDInit;
	}
	public Image getImgWJump() {
		return imgWJump;
	}
	public Image getImgAJump() {
		return imgAJump;
	}
	public Image getImgSJump() {
		return imgSJump;
	}
	public Image getImgDJump() {
		return imgDJump;
	}
}
