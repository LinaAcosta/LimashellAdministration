package threads;
/**
 * This class manage the necessary attributes and methods to create and manage threads that helps the program to run with concurrency.
 * 
 * @author Lina Acosta, Mishell Arboleda, Maria Ordoñez
 */
import java.io.FileNotFoundException;

import model.Game;
import ui.GameController;

public class GameScoreThread extends Thread{
	private Game game;
	private GameController gameC;
	public GameScoreThread(Game g, GameController gc) {
		game = g;
		gameC = gc;
	}
	public void run() {
		while(!false) {
			try {
				game.score(Integer.parseInt(gameC.getA().getText()), Integer.parseInt(gameC.getB().getText()));
				sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (NumberFormatException e) {
			    System.out.print(" ");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
	}
}
