package frogger;

import static org.junit.Assert.assertEquals;


import org.junit.jupiter.api.Test;

import frogger.model.FroggerImg;
import frogger.model.actors.ActorFactory;
import frogger.model.actors.End;
import frogger.model.actors.Frogger;
import frogger.model.actors.Vehicle;
import frogger.view.GameWorld;
import javafx.embed.swing.JFXPanel;

/**
 * @author scyyx1
 * Represent a test for frogger.Test it's death, movement and end.
 */
class FroggerTest {

	JFXPanel jfxPanel = new JFXPanel();
	Frogger frogger = new Frogger();
	GameWorld gameWorld = new GameWorld();
	Vehicle testCar = ActorFactory.getInstance().createVehicle("file:resource/vehicles/car1Left.png", 300,  597,  -1,  50,  50);
	End testEnd = ActorFactory.getInstance().createEnd(300, 96);
	
	/**
	 * Test whether the frogger can move and react to boundary correctly.
	 */
	@Test
	void movementTest() {
		frogger.updateStatus(new FroggerImg().getImgWInit(), 0, -400);
		assertEquals(306.46, frogger.getY(), 0.01d);
		frogger.updateStatus(new FroggerImg().getImgSInit(), 0, -800);
		frogger.boundaryCheck();
		assertEquals(706.46, frogger.getY(), 0.01d);
		frogger.updateStatus(new FroggerImg().getImgAInit(), -20, 0);
		assertEquals(280.0, frogger.getX(), 0.01d);
	}
	
	/**
	 * Test whether the frogger can hit by car death.
	 */
	@Test
	void carDeathTest() {
		frogger.updateStatus(new FroggerImg().getImgWInit(), 0, -110);
		gameWorld.add(frogger);
		gameWorld.add(testCar);
		frogger.collisionCheck();
		assertEquals(true, frogger.isCarDeath());
	}
	
	/**
	 * Test whether the frogger can sink.
	 */
	@Test
	void waterDeathTest() {
		frogger.updateStatus(new FroggerImg().getImgWInit(), 0, -300);
		gameWorld.add(frogger);
		frogger.transportObjectCheck();;
		assertEquals(true, frogger.isWaterDeath());
	}
	
	/**
	 * Test whether the frogger can reach end and react correctly.
	 */
	@Test
	void reachEndTest() {
		frogger.updateStatus(new FroggerImg().getImgWInit(), 0, -600);
		gameWorld.add(frogger);
		gameWorld.add(testEnd);
		frogger.reachEndCheck();
		assertEquals(1, frogger.getEndReached());
	}
	
	/**
	 * Test whether the frogger game can be end.
	 */
	@Test
	void endFroggerTest() {
		frogger.setLives(0);
		assertEquals(true, frogger.getGameStop());
		frogger.setLives(3);
		frogger.setLevel(5);
		assertEquals(5, frogger.getLevel());
	}
	
	/**
	 * Test it's initialization function is correct.
	 */
	@Test
	void InitializeTest() {
		frogger.updateStatus(new FroggerImg().getImgWInit(), 0, -600);
		frogger.initializeFrogger();
		assertEquals(706.46, frogger.getY(), 0.01d);
	}

}
