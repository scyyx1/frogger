package frogger.model.actors;

/**
 * @author scyyx1
 * Represents an actor which is able to move during game time.
 */
public abstract class MovingActor extends Actor {

	/**
     * The methods that how an actor act.
     * @param now The current time.
     */
    public abstract void act(long now);
    
    /**
     * Move dx position from current x and move dy position from current y of current actor.
     * @param dx The movement in x coordinate.
     * @param dy The movement in y coordinate.
     */
    public void move(double dx, double dy) {
        setX(getX() + dx);
        setY(getY() + dy);
    }
    
    /**
     * Check whether an actor is out of boundary.
     * If yes, reset it's x coordinate.
     * @param moveSpeed The moving speed of the image.
     */
    public void checkBoundaryAndReset(double moveSpeed){
    	if (getX() > 600 && moveSpeed>0)
			setX(-200);
		if (getX() < -75 && moveSpeed<0)
			setX(600);

    }



}
