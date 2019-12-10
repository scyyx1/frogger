package frogger;

import static org.junit.jupiter.api.Assertions.*;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import org.junit.jupiter.api.Test;

import frogger.model.Player;
import frogger.model.ScoreCompare;
import frogger.util.FileModified;

class FileAccessTest {

	FileModified fileModifiedTest1 = new FileModified("Test1", 1);
	FileModified fileModifiedTest2 = new FileModified("Test2", 2);
	@Test
	void UpdateFiletest() throws IOException {
		fileModifiedTest1.updateFile();
		ArrayList<Player> testPlayers1 = fileModifiedTest1.getPlayersList();
		fileModifiedTest2.updateFile();
		ArrayList<Player> testPlayers2 = fileModifiedTest2.getPlayersList();
		assertEquals(testPlayers1.size()+1, testPlayers2.size());
		testPlayers1.add(new Player("Test2", 2));
		Collections.sort(testPlayers1, new ScoreCompare());
		for(int i = 0; i < testPlayers2.size(); i++) {
			assertEquals(testPlayers1.get(i).score, testPlayers2.get(i).score);
		}
		
		
	}

}
