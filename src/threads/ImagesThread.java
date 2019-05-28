package threads;
/**
 * This class manage the necessary attributes and methods to create and manage threads that helps the program to run with concurrency.
 * 
 * @author Lina Acosta, Mishell Arboleda, Maria Ordoñez
 */
import javafx.scene.image.ImageView;
public class ImagesThread extends Thread{
	private ImageView image;
	public ImagesThread(ImageView i) {
		image = i;
	}
	public void run() {
		while(!false) {
			try {
				sleep(5000);
				image.setVisible(false);
			} catch (InterruptedException e) {
				e.printStackTrace();
		}
	   }
	}

}
