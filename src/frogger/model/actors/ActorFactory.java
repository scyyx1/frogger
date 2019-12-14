package frogger.model.actors;

/**
 * @author scyyx1
 * An actor factory to create different kinds of actors.
 */


public class ActorFactory {

	/**
	 * Create a singleton instance of actor factory.
	 */
	private static final ActorFactory actorFactory = new ActorFactory();
	
	/**
	 * Set the constructor to disable other class initialize the actor factory class.
	 */
	private ActorFactory() {
		
	}
	
	/**
	 * Gets the instance of actor factory.
	 * @return The actor factory in the system.
	 */
	public static ActorFactory getInstance() {
		return actorFactory;
	}
	
	/**
	 * Gets a background image object.
	 * @param imageLink The image link of the image.
	 * @param width The width of the image.
	 * @param height The height of the image.
	 * @return The background image object.
	 */
	public BackgroundImage createBackgroundImage(String imageLink, int width, int height) {
		return new BackgroundImage(imageLink, width, height);
	}
	
	/**
	 * Gets a vehicle object.
	 * @param imageLink The image link of the image.
	 * @param xPos The x position of the image.
	 * @param yPos The y position of the image.
	 * @param speed The speed of the image.
	 * @param width The width of the image.
	 * @param height The height of the image.
	 * @return The vehicle object.
	 */
	public Vehicle createVehicle(String imageLink, int xPos, int yPos, int speed, int width, int height){
		return new Vehicle(imageLink, xPos, yPos, speed, width, height);
	}
	
	/**
	 * Gets a turtle object.
	 * @param xPos The x position of the image.
	 * @param yPos The y position of the image.
	 * @param speed The speed of the image.
	 * @param width The width of the image.
	 * @param height The height of the image.
	 * @return The turtle object.
	 */
	public Turtle createTurtle(int xPos, int yPos, int speed, int width, int height) {
		return new Turtle(xPos, yPos, speed, width, height);
	}
	
	/**
	 * Gets a wet turtle object.
	 * @param xPos The x position of the image.
	 * @param yPos The y position of the image.
	 * @param speed The speed of the image.
	 * @param width The width of the image.
	 * @param height The height of the image.
	 * @return The wet turtle object.
	 */
	public WetTurtle createWetTurtle(int xPos, int yPos, int speed, int width, int height) {
		return new WetTurtle(xPos, yPos, speed, width, height);
	}
	
	/**
	 * Gets a crocodile body object.
	 * @param xPos The x position of the image.
	 * @param yPos The y position of the image.
	 * @param speed The speed of the image.
	 * @param width The width of the image.
	 * @param height The height of the image.
	 * @return The crocodile body object.
	 */
	public CrocodileBody createCrocodileBody(int xPos, int yPos, double speed, int width, int height) {
		return new CrocodileBody(xPos, yPos, speed, width, height);
	}
	
	/**
	 * Gets a crocodile head object.
	 * @param xPos The x position of the image.
	 * @param yPos The y position of the image.
	 * @param speed The speed of the image.
	 * @param width The width of the image.
	 * @param height The height of the image.
	 * @return The crocodile head object.
	 */
	public CrocodileHead createCrocodileHead(int xPos, int yPos, double speed, int width, int height) {
		return new CrocodileHead(xPos, yPos, speed, width, height);
	}
	
	/**
	 * Gets a log object.
	 * @param imageLink The image link of the image.
	 * @param size The size of the image.
	 * @param xPos The x position of the image.
	 * @param yPos The y position of the image.
	 * @param speed The speed of the image.
	 * @return The log object.
	 */
	public Log createLog(String imageLink, int size, int xPos, int yPos, double speed) {
		return new Log(imageLink, size, xPos, yPos, speed);
	}
	
	/**
	 * Gets an end object.
	 * @param xPos The x position of the image.
	 * @param yPos The y position of the image.
	 * @return The end object.
	 */ 
	public End createEnd(int xPos, int yPos) {
		return new End(xPos, yPos);
	}
	
	/**
	 * Gets a fly object
	 * @param dim The size of the image.
	 * @param xPos The x position of the image.
	 * @param yPos The y position of the image.
	 * @return The fly object
	 */
	public Fly createFly(int dim, int xPos, int yPos) {
		return new Fly(dim, xPos, yPos);
	}
	
	/**
	 * Gets a frogger object
	 * @return The frogger object
	 */
	public Frogger createFrogger() {
		return new Frogger();
	}
	
	/**
	 * Gets a frogger object
	 * @param points The initial points of the frogger.
	 * @return The frogger object
	 */
	public Frogger createFrogger(int points) {
		return new Frogger(points);
	}
	
	/**
	 * Gets a snake object.
	 * @param xPos The x position of the image.
	 * @param yPos The y position of the image.
	 * @param speed The speed of the image.
	 * @param width The width of the image.
	 * @param height The height of the image.
	 * @return The snake object.
	 */
	public Snake createSnake(int xPos, int yPos, int speed, int width, int height) {
		return new Snake(xPos, yPos, speed, width, height);
	}
}
