package ui;
/**
 * This class manage the necessary attributes and methods to create and manage the game.
 * 
 * @author Lina Acosta, Mishell Arboleda, Maria Ordoñez
 */

import java.io.FileNotFoundException;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import model.Game;
import threads.GameScoreThread;
import threads.ImagesThread;
import threads.SaveGameThread;

public class GameController {
	private Game game;
	
    @FXML
    private TextField a;

    @FXML
    private TextField b;

    @FXML
    private Label score;
    @FXML
    private Label l1;

    @FXML
    private Label l2;

    @FXML
    private Label l3;

    @FXML
    private Label l4;

    @FXML
    private Label l5;

    @FXML
    private Label l6;

    @FXML
    private Label l7;

    @FXML
    private Label l8;

    @FXML
    private Label l9;
    
    @FXML
    private GridPane grid;

    @FXML
    /** this method allows to save the game. <br>
	 * @param event the event that is caused by the user to trigger the method.
	 * @throws IOException in the case of a problem reading or finding the file that recovers the game.
     * @throws ClassNotFoundException in the case of a problem finding the class to call a method.
	 */
    void save(ActionEvent event) throws IOException {
    	SaveGameThread sv = new SaveGameThread(game);
    	sv.start();
    }
    public Label getLabel() {
    	return score;
    }
    /** this method allows to show the image selected by the usuary. <br>
	 * @param event the event that is caused by the user to trigger the method.
	 * @throws IOException in the case of a problem reading or finding the file that recovers the image.
     * @throws ClassNotFoundException in the case of a problem finding the class to call a method.
     * @throws FileNotFoundException in the case that the recovering file of the scores does not exists.
	 */
	public void see(int number) throws FileNotFoundException, ClassNotFoundException, IOException, InterruptedException {
		String image = game.chooseA(number);
    	if(image != null) {
    		if(image.equals("ui/images/1.png") == true) {
        	    if(number == 1) {
        	    	Image im = new Image(image); 
            	    ImageView i = new ImageView(im);
            		i.setFitHeight(175);
            		i.setFitWidth(210);
            		l1.setGraphic(i);
            		ImagesThread it = new ImagesThread(i);
            		it.start();
        	    }else {
        	    	Image im = new Image(image); 
            	    ImageView i = new ImageView(im);
            		i.setFitHeight(175);
            		i.setFitWidth(210);
            		l5.setGraphic(i);
            		ImagesThread it = new ImagesThread(i);
            		it.start();
        	    }
        	}else if(image.equals("ui/images/2.png") == true) {
        	    if(number == 2) {
        	    	Image im = new Image(image); 
            	    ImageView i = new ImageView(im);
            		i.setFitHeight(175);
            		i.setFitWidth(210);
            		l2.setGraphic(i);
            		ImagesThread it = new ImagesThread(i);
            		it.start();
        	    }else {
        	    	Image im = new Image(image); 
            	    ImageView i = new ImageView(im);
            		i.setFitHeight(175);
            		i.setFitWidth(210);
            		l7.setGraphic(i);
            		ImagesThread it = new ImagesThread(i);
            		it.start();
        	    }
        	}else if(image.equals("ui/images/3.jpg") == true) {
        	    if(number == 3) {
        	    	Image im = new Image(image); 
            	    ImageView i = new ImageView(im);
            		i.setFitHeight(175);
            		i.setFitWidth(210);
            		l3.setGraphic(i);
            		ImagesThread it = new ImagesThread(i);
            		it.start();
        	    }else {
        	    	Image im = new Image(image); 
            	    ImageView i = new ImageView(im);
            		i.setFitHeight(175);
            		i.setFitWidth(210);
            		l4.setGraphic(i);
            		ImagesThread it = new ImagesThread(i);
            		it.start();
        	    }
        	}else if(image.equals("ui/images/4.jpg") == true) {
        	    if(number == 6) {
        	    	Image im = new Image(image); 
            	    ImageView i = new ImageView(im);
            		i.setFitHeight(175);
            		i.setFitWidth(210);
            		l6.setGraphic(i);
            		ImagesThread it = new ImagesThread(i);
            		it.start();
        	    }else {
        	    	Image im = new Image(image); 
            	    ImageView i = new ImageView(im);
            		i.setFitHeight(175);
            		i.setFitWidth(210);
            		l9.setGraphic(i);
            		ImagesThread it = new ImagesThread(i);
            		it.start();
        	    }
        	}
        	else if(image.equals("ui/images/5.png") == true) {
        		Image im = new Image(image); 
        	    ImageView i = new ImageView(im);
        		i.setFitHeight(175);
        		i.setFitWidth(210);
        		l8.setGraphic(i);
        		ImagesThread it = new ImagesThread(i);
        		it.start();
        	}
    	}
    }
	public TextField getA() {
    	return a;
    }
    public TextField getB() {
    	return b;
    }
	@FXML
	/** this method allows to show the images selected. <br>
	 * @param event the event that is caused by the user to trigger the method.
	 * @throws IOException in the case of a problem reading or finding the file that recovers the images
     * @throws ClassNotFoundException in the case of a problem finding the class to call a method.
	 */
    void show(ActionEvent event) throws IOException, ClassNotFoundException, InterruptedException {
		if(game != null) {
			int first = Integer.parseInt(a.getText());
	    	int second = Integer.parseInt(b.getText());
	    	see(first);
	    	see(second);
	    	if(game.chooseA(first).equals(game.chooseA(second)) == true) {
	    		if(first == 1 || first == 5) {
	    			Image im = new Image("ui/images/1.png"); 
	        	    ImageView i = new ImageView(im);
	        		i.setFitHeight(175);
	        		i.setFitWidth(210);
	        		l5.setGraphic(i);
	        		Image im2 = new Image("ui/images/1.png"); 
	        	    ImageView i2 = new ImageView(im2);
	        		i2.setFitHeight(175);
	        		i2.setFitWidth(210);
	        		l1.setGraphic(i2);
	        		GameScoreThread gs = new GameScoreThread(game,this);
		        	gs.start();
		        	game.score(first, second);
		        	score.setText(game.getScore() + "");
	    		}else if(first == 2 || first == 7) {
	    			Image im = new Image("ui/images/2.png"); 
	        	    ImageView i = new ImageView(im);
	        		i.setFitHeight(175);
	        		i.setFitWidth(210);
	        		l7.setGraphic(i);
	        		Image im2 = new Image("ui/images/2.png"); 
	        	    ImageView i2 = new ImageView(im2);
	        		i2.setFitHeight(175);
	        		i2.setFitWidth(210);
	        		l2.setGraphic(i2);
	        		GameScoreThread gs = new GameScoreThread(game,this);
		        	gs.start();
		        	game.score(first, second);
		        	score.setText(game.getScore() + "");
	    		}else if(first == 3 || first == 4) {
	    			Image im = new Image("ui/images/3.jpg"); 
	        	    ImageView i = new ImageView(im);
	        		i.setFitHeight(175);
	        		i.setFitWidth(210);
	        		l4.setGraphic(i);
	        		Image im2 = new Image("ui/images/3.jpg"); 
	        	    ImageView i2 = new ImageView(im2);
	        		i2.setFitHeight(175);
	        		i2.setFitWidth(210);
	        		l3.setGraphic(i2);
	        		GameScoreThread gs = new GameScoreThread(game,this);
		        	gs.start();
		        	game.score(first, second);
		        	score.setText(game.getScore() + "");
	    		}else if(first == 6 || first == 9) {
	    			Image im = new Image("ui/images/4.jpg"); 
	        	    ImageView i = new ImageView(im);
	        		i.setFitHeight(175);
	        		i.setFitWidth(210);
	        		l9.setGraphic(i);
	        		Image im2 = new Image("ui/images/4.jpg"); 
	        	    ImageView i2 = new ImageView(im2);
	        		i2.setFitHeight(175);
	        		i2.setFitWidth(210);
	        		l6.setGraphic(i2);
	        		GameScoreThread gs = new GameScoreThread(game,this);
		        	gs.start();
		        	game.score(first, second);
		        	score.setText(game.getScore() + "");
	    		}else if(first == 8 || second == 8) {
	    			Image im = new Image("ui/images/5.png"); 
	        	    ImageView i = new ImageView(im);
	        		i.setFitHeight(175);
	        		i.setFitWidth(210);
	        		l8.setGraphic(i);
	        		ImagesThread it = new ImagesThread(i);
	        		it.start();
	        		GameScoreThread gs = new GameScoreThread(game,this);
		        	gs.start();
		        	game.score(first, second);
		        	score.setText(game.getScore() + "");
	    		}
	    	}
		}else {
			game = new Game(0);
		}
    }
    /**
     * This method handles a new event into the stage, showing the options of the second screen
     * @throws IOException if the fxml file can't be correctly loaded. 
     */
    public void seeOptions() throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("game.fxml"));
    	Parent root1 = (Parent) fxmlLoader.load();
    	Stage stage = new Stage();
    	stage.setTitle("Game!");
    	stage.centerOnScreen();
    	stage.setResizable(false);
    	stage.setScene(new Scene(root1));  
    	stage.show();
    }
}
