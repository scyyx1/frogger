package frogger.model.actors;

public class ActorFactory {

	
	
	public BackgroundImage createBackgroundImage(String imageLink, int width, int height) {
		return new BackgroundImage(imageLink, width, height);
	}
	
	public Vehicle createVehicle(String imageLink, int xPos, int yPos, int speed, int width, int height){
		return new Vehicle(imageLink, xPos, yPos, speed, width, height);
	}
	
	public Turtle createTurtle(int xPos, int yPos, int speed, int width, int height) {
		return new Turtle(xPos, yPos, speed, width, height);
	}
	
	public WetTurtle createWetTurtle(int xPos, int yPos, int speed, int width, int height) {
		return new WetTurtle(xPos, yPos, speed, width, height);
	}
	
	public Crocodile createCrocodile(int xPos, int yPos, double speed, int width, int height) {
		return new Crocodile(xPos, yPos, speed, width, height);
	}
	
	public CrocodileHead createCrocodileHead(int xPos, int yPos, double speed, int width, int height) {
		return new CrocodileHead(xPos, yPos, speed, width, height);
	}
	
	public Log createLog(String imageLink, int size, int xPos, int yPos, double speed) {
		return new Log(imageLink, size, xPos, yPos, speed);
	}
	
	public End createEnd(int xPos, int yPos) {
		return new End(xPos, yPos);
	}
	
	public Fly createFly(int dim, int xPos, int yPos) {
		return new Fly(dim, xPos, yPos);
	}
	
	public Frogger createFrogger() {
		return new Frogger();
	}
	
	public Frogger createFrogger(int points) {
		return new Frogger(points);
	}
	
	public Snack createSnack(int xPos, int yPos, int speed, int width, int height) {
		return new Snack(xPos, yPos, speed, width, height);
	}
}
