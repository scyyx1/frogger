package frogger.view;

/**
 * @author scyyx1
 * An interface of basic gui, which can be used by different windows.
 */
public interface BasicGUI {
	
	/**
	 * Create the background of this GUI.
	 */
	public void createBackground();
	
	/**
	 * Create the button of this GUI.
	 */
	public void createButton();
	
	
	/**
	 * Create the label of this GUI.
	 */
	public void createLabel();
}
