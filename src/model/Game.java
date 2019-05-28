package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class Game {
	private int score;
	private Game gamToSave;
	/**
	 * <b>Game Constructor</b><br>
	 * This constructor creates the game<br>
	 * @throws IOException in the case of a problem reading or finding the file that recovers the scores.
	 * @throws ClassNotFoundException in the case of a problem finding the class to call a method.
	 * @throws FileNotFoundException in the case that the recovering file of the scores does not exists.
	 */
	public Game(int s) throws FileNotFoundException, ClassNotFoundException, IOException {
		score = s;
		load();
	}
	/**
	 * This method allows to recover the state of the Game <br>
	 * @throws IOException in the case of a problem reading or finding the file that recovers the game.
	 * @throws ClassNotFoundException in the case of a problem finding the class to call a method.
	 * @throws FileNotFoundException in the case that the recovering game does not exists.
	 */
    public void load() throws FileNotFoundException, IOException, ClassNotFoundException{
		File gameS = new File("data/gameSave");
		if(gameS.exists()) {
			ObjectInputStream myLoader = new ObjectInputStream(new FileInputStream(gameS));
			gamToSave =   (Game) myLoader.readObject();
			myLoader.close();
		}
		else {
			gamToSave = null;
		}
	}
    /**
	 * This method allows to save the game<br>
	 * @throws IOException in the case of a problem reading or finding the file that recovers the game. 
	 * @throws FileNotFoundException in the case that the recovering file of the game does not exists
	 */
    public void saveGame() throws FileNotFoundException, IOException, ClassNotFoundException {
		File gameS = new File("data/gameSave");
		ObjectOutputStream mySavior = new ObjectOutputStream(new FileOutputStream(gameS));
		mySavior.writeObject(gameS);
		mySavior.close();
	}
    public Game getGameToSave() {
    	return gamToSave;
    }
    /**
	 * this method allows to get the information related with the image selected.<br>
	 * <b>Pre:</b> the game has been previously created
	 * <b>Pre:</b> the image exists<br>
	 * <b>Pos:</b> a url of the image<br>
	 * @return a String that contains the url of the image selected
	 */
	public String chooseA(int a) {
		String url = "";
		if(a == 1 || a == 5) {
			url = "ui/images/1.png";
		}else if(a == 2|| a == 7) {
			url = "ui/images/2.png";
		}else if(a == 3 || a == 4) {
			url = "ui/images/3.jpg";
		}else if(a == 6 || a == 9) {
			url = "ui/images/4.jpg";
		}else if(a == 8) {
			url = "ui/images/5.png";
		}else {
			url = null;
		}
		return url;
	}
	/**
	 * This method increases the score of the player <br>
	 * <b>Pre:</b> the game exists.<br>
	 * <b>Post:</b> the Score is increased. <br> 
	 */
	public void score(int a, int b) throws FileNotFoundException {
		score = score + 50;
	}
	/**
	 * this method allows to change the score with the new value that arrives as a parameter 
	 * @param s the score of the actual score
	 *<b>Pre:</b> the game exists<br>
	 *<b>Pos:</b> the value of the attribute is succesfully changed<br> 
	 */
	public void setScore(int s) {
		score =  s;
	}
	/**
	 * This method returns the current score associated with the current game<br>
	 * @return an int that represents the score of the game
	 */
	public int getScore() {
		return score;
	}
}
