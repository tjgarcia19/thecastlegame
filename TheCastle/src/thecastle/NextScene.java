package thecastle;

import javafx.stage.Stage;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

import java.util.ArrayList;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.scene.Group;

public class NextScene{
//	private StackPane pane;
	private Stage stage;
	private Group pane;
	private Scene scene;
	private GraphicsContext gc;
	private Canvas canvas;
	private GridPane map;
	private char[][] room;
	private GameTimer gametimer;
	private ArrayList<ImageView> cells;
	private Image bg;
	private int roomNum;
	public ArrayList<Integer> keyInventory;
	private Prince prince;
	public static int points;
	public static int health = 9;
	
	
	public final static int MAX_CELLS = 150;
	public final static int MAP_NUM_ROWS = 10;
	public final static int MAP_NUM_COLS = 15;	
	public final static int MAP_WIDTH = 800;
	public final static int MAP_HEIGHT = 500;
	public final static int CELL_WIDTH = 53;
	public final static int CELL_HEIGHT = 50;
	
	public NextScene(String btnName, Stage stage, Image bg,ArrayList<Integer> keyInventory,int roomNum,int x, int y){ //result is either true or false
//		this.pane = new StackPane();
		this.stage =stage;
		this.pane = new Group();
		this.scene = new Scene(pane, SplashScreen.WINDOW_WIDTH,SplashScreen.WINDOW_HEIGHT);
		this.canvas = new Canvas(SplashScreen.WINDOW_WIDTH, SplashScreen.WINDOW_HEIGHT);
		this.gc = canvas.getGraphicsContext2D();
		this.map = new GridPane();
		this.room = new char[SplashScreen.WINDOW_WIDTH][SplashScreen.WINDOW_HEIGHT];
		this.cells = new ArrayList<ImageView>();
		this.bg = bg;
		this.roomNum=roomNum;
		this.keyInventory=keyInventory;
		this.prince = new Prince(0,0);
		this.setProperties(btnName, x, y);
	}
	
	private void setProperties(String btnName, int x, int y){
		this.gc.setFill(Color.BLACK);										//set font color of text
		this.gc.fillRect(0,0,SplashScreen.WINDOW_WIDTH,SplashScreen.WINDOW_HEIGHT);
//		Font theFont = Font.font("Times New Roman",FontWeight.BOLD,30);//set font type, style and size
//		this.gc.setFont(theFont);											
		
		if(btnName.equals("play")) {//if true the user wins
			this.gc.drawImage(bg, 0, 100);
			if(this.roomNum==1) this.setRoom1();
			else if(this.roomNum==2) this.setRoom2();
			else if(this.roomNum==3) this.setRoom3();
			else if(this.roomNum==4) this.setRoom4();
			else if(this.roomNum==5) this.setRoom5();
			else if(this.roomNum==6) this.setRoom6();
			this.room[x][y]='P';
			this.createMap();
			this.setGridPaneProperties();
			this.addGridPaneConstraints();
			for(ImageView cell: cells){
		    	 this.map.getChildren().add(cell);
		     }
			this.gametimer = new GameTimer(this.stage,this.gc, this.scene, this.bg, this.room, this.cells, this.keyInventory,this.roomNum);
			this.gametimer.start();
		}else {
			this.gc.drawImage(Maps.hw, 0, 100);
//			this.gc.setFill(Color.RED); //set font color of text
//			this.gc.fillText("HOW TO PLAY THE GAME", SplashScreen.WINDOW_WIDTH*0.4, SplashScreen.WINDOW_HEIGHT*0.3);
//			this.gc.fillText("Instructions Here", SplashScreen.WINDOW_WIDTH*0.4, SplashScreen.WINDOW_HEIGHT*0.4);
			Button backBtn = new Button("Back to Game");
			this.addEventHandler(backBtn);
			pane.getChildren().add(backBtn);
		}		
		pane.getChildren().add(this.canvas);
		pane.getChildren().add(map);	
		
	}
	
	private void addEventHandler(Button btn) {
		// TODO Auto-generated method stub
		btn.setOnMouseClicked(new EventHandler<MouseEvent>() {

			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
		
	}
	
	Scene getScene(){
		return this.scene;
	}
	
	public void setRoom1(){
		this.room = new char[][]{
			{'X','X','X','X','X','X','X','X','X','X','X','X','X','X','X'},
			{'X','X','X','X','X','X','X','X','X','X','X','X','X','X','X'},
			{'X','X','2',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','X'},
			{'X','X','_','_','_','_','_',' ',' ',' ','_','_','_','_','X'},
			{'X','X','X','X','X',' ',' ',' ',' ',' ',' ',' ',' ',' ','X'},
			{'X','X','X','X','X',' ',' ','_','_','_','_','_','_','_','X'},
			{' ','X','X','X','X',' ',' ',' ',' ',' ',' ',' ',' ',' ','X'},
			{' ',' ','X','X','X','_','_','_','_','_','_',' ',' ',' ','X'},
			{' ',' ','_','1','X',' ',' ',' ',' ',' ',' ',' ',' ',' ','X'},
			{'_','_','_','_','A','_','_','_','_','_','_','_','_','_','B'}
		};
	}
	
	public void setRoom2(){
		this.room = new char[][]{
		{'X','X','X','X','X','X','X','X','X','X','X',' ',' ','X','X'},
		{'X',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','X','X'},
		{'X',' ',' ','_','_','_','_','_','_','_',' ',' ',' ','X','X'},
		{'X',' ',' ',' ','X','2','_','_','_','_','_','_','_','X','X'},
		{'X','_','_',' ','X','X','X','X','X','X','X','X','X','X','X'},
		{'X',' ',' ',' ','X','1',' ','4','X',' ',' ',' ',' ',' ',' '},
		{'X',' ',' ','_','X',' ',' ',' ','X',' ',' ',' ',' ',' ','_'},
		{'X',' ',' ',' ','X','_','_','_','B','_',' ',' ',' ','_','X'},
		{'X','_','_',' ','X',' ',' ',' ',' ',' ',' ',' ','_',' ','X'},
		{'_','_','_','_','C','_','_','_','_','_','_','_','_','_','A'}	
		};
	}
	
	public void setRoom3(){
		this.room = new char[][]{
		{'X',' ','X','X','X','X','X','X','X','X','X',' ','X',' ',' '},
		{'X',' ',' ','_',' ','_',' ','_',' ','1',' ','_','X',' ',' '},
		{'X',' ','_',' ','_',' ','_',' ','_',' ','_','X','X',' ',' '},
		{'X','_','V','V','V','V','V','V','V','_','X','X','X',' ','_'},
		{'X','X','X','X','X','X','X','X','X','X','X','X','X',' ','X'},
		{'X',' ',' ',' ',' ',' ',' ',' ','X','2',' ',' ',' ',' ',' '},
		{'A','_','_','_','_','_',' ',' ','X','_','_',' ','_','_','_'},
		{' ',' ','3',' ',' ','X',' ',' ',' ',' ',' ',' ',' ',' ',' '},
		{' ',' ',' ',' ','4','X','_','_','_','_','_','_',' ',' ','X'},
		{'_','_','_','_','_','X',' ','_','_','_','_','_','_','X','X'}
	};
	}
	
	public void setRoom4(){
		this.room = new char[][]{
		{' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','_',' ',' ',' ',' '},
		{' ',' ','_','_','_','_','_','_','_','_','X','_',' ',' ',' '},
		{' ',' ','X',' ',' ',' ',' ',' ',' ',' ','X','X','_','_','_'},
		{' ',' ','X',' ',' ','_','_','_','_',' ','X','X','X','X','X'},
		{'_','_','D','_','_','X','V','V','V',' ',' ',' ','3','V','X'},
		{'X','X','X','X','X','X',' ',' ',' ',' ',' ','_',' ','V','X'},
		{'X',' ',' ',' ',' ','X','_','_','_','_','_',' ',' ','V','X'},
		{'X',' ',' ',' ',' ','X',' ',' ',' ',' ',' ',' ',' ','V','X'},
		{'X',' ',' ',' ',' ','C','_','_','_','_','_','_',' ','V','X'},
		{'X','X','X','X','X','X','X','X','X','X','X','X','X','X','X'}
	};
	}

	public void setRoom5(){
		this.room = new char[][]{
		{'X','X','X','X','X','X','X','X','X','X','V','V','V','V','V'},
		{'X',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
		{'D','_','_','_','_','_','_','_',' ',' ','_','_','_',' ',' '},
		{'X','X','X','X','X','X','X','X',' ',' ','X','X','X',' ',' '},
		{'X','V',' ',' ',' ',' ',' ',' ',' ',' ','X','3',' ',' ',' '},
		{'X','V',' ',' ','_','_','_','_','_','_','X',' ',' ',' ',' '},
		{'X','V',' ',' ','X','X','X','X','X','X','X','_','_','_',' '},
		{'X','V',' ','_','X','V',' ','V',' ','V','X','X','X','X',' '},
		{'X','V',' ',' ',' ',' ',' ',' ',' ',' ','X',' ',' ','X',' '},
		{'X','V','_','_','V','_','V','_','V','_','B','_','_','X','_'}
		
	};
	}

	public void setRoom6(){
		this.room = new char[][]{
		{'V','V','V','X','X','X','X','X','X','X','X','X','X','X','X'},
		{' ',' ',' ','X',' ','X','V',' ','_','_',' ','_','1',' ',' '},
		{'_','_','_','C',' ','X',' ',' ',' ',' ',' ',' ',' ',' ',' '},
		{'X','X','X','X',' ','X',' ','X','X','X','X','X','X',' ','_'},
		{'X',' ','_',' ',' ','X',' ','X','2',' ',' ',' ','X',' ',' '},
		{'X',' ','X','_',' ','X',' ','X',' ',' ',' ',' ','X','_',' '},
		{'X',' ','X',' ',' ','X',' ','X','X','X','X',' ','X',' ',' '},
		{'X',' ','X',' ',' ','X',' ',' ',' ','_','A','_','X',' ','_'},
		{'X',' ','X','V','V','X',' ',' ',' ',' ',' ',' ','X',' ','V'},
		{'X',' ','X',' ',' ','X','_','_','_','_','_',' ','X','_','B'}	
	};
	}
	
	private void createMap(){
		//create 9 image view nodes for the "land" cells
		for(int i=0;i<NextScene.MAP_NUM_ROWS;i++){
			for(int j=0;j<NextScene.MAP_NUM_COLS;j++){
				//create an image view node for each land element
				ImageView iv = new ImageView();
//				addToStage(this.prince,iv);

				//set image view style of each land element
				iv.setPreserveRatio(true);
				iv.setFitWidth(NextScene.CELL_WIDTH);
				iv.setFitHeight(NextScene.CELL_HEIGHT);
					
				//set id of the image view to i-j	(e.g. id: 1-0 for element in row 1 col 0 )
				iv.setId(Integer.toString(i)+"-"+Integer.toString(j));
				
				//add each image view created to the array list landCells
				this.cells.add(iv);
			}		
		}
	}
	
	//method to set size and location of the grid pane 
		private void setGridPaneProperties(){
			this.map.setPrefSize(NextScene.MAP_WIDTH, NextScene.MAP_HEIGHT);
			//set the map to x and y location; add border color to see the size of the gridpane/map  
//			this.map.setGridLinesVisible(true);
//		    this.map.setStyle("-fx-border-color: red ;");
			this.map.setLayoutX(0);
		    this.map.setLayoutY(100);
		}
		
		//method to add row and column constraints of the grid pane
		private void addGridPaneConstraints(){
			
			//set number of rows
			for(int i=0;i<NextScene.MAP_NUM_ROWS;i++){
				RowConstraints row = new RowConstraints();
				row.setPercentHeight(0);
				this.map.getRowConstraints().add(row);
			}
		    
		     //set the number of columns and width of each column (in %); 3 cols, width = 30%;
			for(int i=0;i<NextScene.MAP_NUM_COLS;i++){
				ColumnConstraints col = new ColumnConstraints();
				col.setPercentWidth(0);
				this.map.getColumnConstraints().add(col);
			}	  
		          
			 //loop that will add the image views / land images to the gridpane
		     int counter=0;
		     for(int row=0;row<NextScene.MAP_NUM_ROWS;row++){
		    	 for(int col=0;col<NextScene.MAP_NUM_COLS;col++){
		    		 //set each landCells arraylist element (imageview) to the gridpane/map's constraints
		    		 GridPane.setConstraints(cells.get(counter),col,row); 
		    		 counter++;
		    	 }
		     }   
		}
}