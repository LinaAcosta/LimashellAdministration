package model;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.jupiter.api.Test;

class GameTest {
    private void setupScenary1() {
		
	}
    private Game game;
    private void setupScenary2() throws FileNotFoundException, ClassNotFoundException, IOException {
    	game = new Game(0);
    }

	@Test
    void testManager() throws FileNotFoundException, ClassNotFoundException, IOException {
		setupScenary1();
		int score = 50;
		Game g = new Game(score);
		assertNotNull("The new game is null", g);
		assertTrue("The Game's score have the wrong value", (score == g.getScore()));
	}
	@Test
	void testScore() throws ClassNotFoundException, IOException {
		setupScenary2();
		game.score(1, 5);
		assertTrue("The Game's score have the wrong value", (game.getScore() == 50));
		game.score(2, 7);
		assertTrue("The Game's score have the wrong value", (game.getScore() == 100));
		game.score(3, 4);
		assertTrue("The Game's score have the wrong value", (game.getScore() == 150));
		game.score(6, 9);
		assertTrue("The Game's score have the wrong value", (game.getScore() == 200));
	}
}
