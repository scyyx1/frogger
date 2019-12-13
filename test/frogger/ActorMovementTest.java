package frogger;

import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Test;
import frogger.model.actors.ActorFactory;
import frogger.model.actors.CrocodileBody;
import frogger.model.actors.CrocodileHead;
import frogger.model.actors.Log;
import frogger.model.actors.Turtle;
import frogger.model.actors.Vehicle;
import frogger.model.actors.WetTurtle;
import javafx.embed.swing.JFXPanel;

/**
 * @author scyyx1
 * Represent a JUnit case for different actors movement testing.
 *
 */
class ActorMovementTest {

	JFXPanel jfxPanel = new JFXPanel();
	WetTurtle testWetTurtle = ActorFactory.getInstance().createWetTurtle(300, 376, -1, 130, 130);
	Turtle testTurtle = ActorFactory.getInstance().createTurtle(300, 217, -1, 130, 130);
	Log testLog = ActorFactory.getInstance().createLog("file:resource/logs/log3.png", 150, 300, 166, 1);
	CrocodileBody testCrocodileBody = ActorFactory.getInstance().createCrocodileBody(0,  150,  1, 100,  100);
	CrocodileHead testCrocodileHead = ActorFactory.getInstance().createCrocodileHead(90,  150,  1, 70,  70);
	Vehicle testCar = ActorFactory.getInstance().createVehicle("file:resource/vehicles/car1Left.png", 300,  597,  -1,  50,  50);
	
	
	/**
	 * Test whether wet turtle can move and react to boundary correctly.
	 */
	@Test
	void wetTurtleMovementTest() {
		testWetTurtle.move(-1, 0);
		assertEquals(299, testWetTurtle.getX(), 0.01d);
		testWetTurtle.move(-375, 0);
		testWetTurtle.checkBoundaryAndReset(-1);
		assertEquals(600, testWetTurtle.getX(), 0.01d);
	}
	
	/**
	 * Test whether turtle can move and react to boundary correctly.
	 */
	@Test
	void turtleMovementTest() {
		testTurtle.move(-1, 0);
		assertEquals(299, testTurtle.getX(), 0.01d);
		testTurtle.move(-375, 0);
		testTurtle.checkBoundaryAndReset(-1);
		assertEquals(600, testTurtle.getX(), 0.01d);
	}
	
	/**
	 * Test whether log can move and react to boundary correctly.
	 */
	@Test
	void logMovementTest() {
		testLog.move(-1, 0);
		assertEquals(299, testLog.getX(), 0.01d);
		testLog.move(-375, 0);
		testLog.checkBoundaryAndReset(-1);
		assertEquals(700, testLog.getX(), 0.01d);
	}
	
	/**
	 * Test whether crocodile can move and react to boundary correctly.
	 */
	@Test
	void crocodileMovementTest() {
		testCrocodileBody.move(1, 0);
		assertEquals(1, testCrocodileBody.getX(), 0.01d);
		testCrocodileHead.move(1, 0);
		assertEquals(91, testCrocodileHead.getX(), 0.01d);
		testCrocodileBody.move(600, 0);
		testCrocodileBody.checkBoundaryAndReset(1);
		assertEquals(-180, testCrocodileBody.getX(), 0.01d);
		testCrocodileHead.move(600, 0);
		testCrocodileHead.checkBoundaryAndReset(1);
		assertEquals(-180, testCrocodileBody.getX(), 0.01d);
	}
	
	/**
	 * Test whether vehicle can move and react to boundary correctly.
	 */
	@Test
	void vehicleMovementTest() {
		testCar.move(-1, 0);
		assertEquals(299, testCar.getX(), 0.01d);
		testCar.move(-375, 0);
		testCar.checkBoundaryAndReset(-1);
		assertEquals(600, testCar.getX(), 0.01d);
	}
	
	
	

}
