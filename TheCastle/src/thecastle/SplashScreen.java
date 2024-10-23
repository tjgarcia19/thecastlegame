package thecastle;

import java.util.ArrayList;

import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class SplashScreen {
	private Scene scene;
	private Stage stage;
	private Canvas canvas;
	private Group root;
	private GraphicsContext gc;
	public ArrayList<Integer> keyInventory;

	public final static int WINDOW_WIDTH = 800;
	public final static int WINDOW_HEIGHT = 600;

	
	public final Image bg = new Image("images/SplashScreen.png",800,600,false,false);
	
	
	public SplashScreen() {
		this.root = new Group();
		this.scene = new Scene(root, SplashScreen.WINDOW_WIDTH,SplashScreen.WINDOW_HEIGHT,Color.WHITE);	
		this.canvas = new Canvas(SplashScreen.WINDOW_WIDTH,SplashScreen.WINDOW_HEIGHT);	
		this.gc = canvas.getGraphicsContext2D();
		this.keyInventory = new ArrayList<Integer>();
	}

	//method to add the stage elements
	public void setStage(Stage stage) {
		Image newGame = new Image("images/NewGame.png", 150,40, false, false);
		Image howTo = new Image("images/How.png", 150,40, false, false);
		Image exit = new Image("images/Exit.png", 150,40, false, false);
		ImageView newIV = new ImageView(newGame);
		ImageView howIV = new ImageView(howTo);
		ImageView exitIV = new ImageView(exit);
		newIV.setLayoutX(340); howIV.setLayoutX(340); exitIV.setLayoutX(340);
		newIV.setLayoutY(315); howIV.setLayoutY(375); exitIV.setLayoutY(435);
		
		newIV.setOnMouseClicked(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
					handleButtonClick("play", Maps.map1, 1);
			}
		});
		
		howIV.setOnMouseClicked(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
					handleButtonClick("howTo", Maps.hw, 1);
			}
		});
		
		exitIV.setOnMouseClicked(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
					handleButtonClick("exit", bg, 1);
			}
		});
		
		this.stage = stage;
		//draw the background to the canvas at location x=0, y=60
		this.gc.drawImage( bg, 0, 0 );     
		this.root.getChildren().add(canvas);
		this.root.getChildren().add(newIV);
		this.root.getChildren().add(howIV);
		this.root.getChildren().add(exitIV);	
		this.stage.setTitle("The Castle");
		this.stage.setScene(this.scene);
		this.stage.show();
	}
	
	private void handleButtonClick(String btnName, Image bg, int roomNum){
		if(btnName.equals("play")){
			System.out.println("New Game!");
			setNextScene("play", bg, this.keyInventory ,roomNum, 9,0);
		}else if(btnName.equals("howTo")) {
			System.out.println("Instructions!");
			setNextScene("howTo", bg, this.keyInventory ,roomNum,9,0);
		}else{
			System.exit(0);
		}
	}
	
	private void setNextScene(String btnName, Image bg, ArrayList<Integer> keyInventory,int roomNum, int x, int y){
		NextScene next = new NextScene(btnName, this.stage, bg, keyInventory, roomNum, x, y);
		stage.setScene(next.getScene());
	}
	
}
