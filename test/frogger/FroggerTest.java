package frogger;

import static org.junit.Assert.assertEquals;


import org.junit.jupiter.api.Test;

import frogger.model.actors.ActorFactory;
import frogger.model.actors.Frogger;
import frogger.model.actors.FroggerImg;
import frogger.model.actors.Vehicle;
import frogger.view.GameEngine;
import javafx.embed.swing.JFXPanel;

class FroggerTest {

	JFXPanel jfxPanel = new JFXPanel();
	Frogger frogger = new Frogger();
	GameEngine gameEngine = new GameEngine(1);
	Vehicle testCar = ActorFactory.getInstance().createVehicle("file:resource/vehicles/car1Left.png", 300, 597, -1, 50, 50);
	
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
		gameEngine.asView().add(frogger);
		gameEngine.asView().add(testCar);
		frogger.collisionCheck();
		assertEquals(true, frogger.isCarDeath());
	}

}
