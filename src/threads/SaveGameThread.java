package threads;
/**
 * This class manage the necessary attributes and methods to create and manage threads that helps the program to run with concurrency.
 * 
 * @author Lina Acosta, Mishell Arboleda, Maria Ordoñez
 */
import java.io.IOException;
import model.Game;

public class SaveGameThread extends Thread{
	private Game game;
	public SaveGameThread(Game g) {
		game = g;
	}
	public void run() {
		while(!false) {
			try {
				game.saveGame();
				sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
