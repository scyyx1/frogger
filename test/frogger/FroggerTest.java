package frogger;

import static org.junit.Assert.assertEquals;


import org.junit.jupiter.api.Test;

import frogger.model.actors.ActorFactory;
import frogger.model.actors.End;
import frogger.model.actors.Frogger;
import frogger.model.actors.FroggerImg;
import frogger.model.actors.Vehicle;
import frogger.view.GameWorld;
import javafx.embed.swing.JFXPanel;

class FroggerTest {

	JFXPanel jfxPanel = new JFXPanel();
	Frogger frogger = new Frogger();
	GameWorld gameWorld = new GameWorld();
	Vehicle testCar = ActorFactory.getInstance().createVehicle("file:resource/vehicles/car1Left.png", 300,  597,  -1,  50,  50);
	End testEnd = ActorFactory.getInstance().createEnd(300, 96);
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
	
	@Test
	void carDeathTest() {
		frogger.updateStatus(new FroggerImg().getImgWInit(), 0, -110);
		gameWorld.add(frogger);
		gameWorld.add(testCar);
		frogger.collisionCheck();
		assertEquals(true, frogger.isCarDeath());
	}
	
	@Test
	void waterDeathTest() {
		frogger.updateStatus(new FroggerImg().getImgWInit(), 0, -300);
		gameWorld.add(frogger);
		frogger.transportObjectCheck();;
		assertEquals(true, frogger.isWaterDeath());
	}
	
	@Test
	void reachEndTest() {
		frogger.updateStatus(new FroggerImg().getImgWInit(), 0, -600);
		gameWorld.add(frogger);
		gameWorld.add(testEnd);
		frogger.reachEndCheck();
		assertEquals(1, frogger.getEndReached());
	}
	
	@Test
	void endFroggerTest() {
		frogger.setLives(0);
		assertEquals(true, frogger.getGameStop());
		frogger.setLives(3);
		frogger.setLevel(5);
		assertEquals(5, frogger.getLevel());
	}
	
	@Test
	void InitializeTest() {
		frogger.updateStatus(new FroggerImg().getImgWInit(), 0, -600);
		frogger.initializeFrogger();
		assertEquals(706.46, frogger.getY(), 0.01d);
	}

}
