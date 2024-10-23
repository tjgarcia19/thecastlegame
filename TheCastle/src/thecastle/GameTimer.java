package thecastle;

import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.Random;
import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.util.concurrent.TimeUnit;

public class GameTimer extends AnimationTimer{
	private Stage stage;
	private GraphicsContext gc;
	private Scene theScene;
	private Image bg;
	private Prince prince;
	public char[][] room;
	public int x;
	public int y;
	public ArrayList<ImageView> cells;
	public ArrayList<Integer> keyInventory;
	public int count;
	public char prev;
	private int roomNum;
	private boolean isd1Closed;
	private boolean isd2Closed;
	private boolean isd3Closed;
	private boolean isd4Closed;
	private boolean isk1Present;
	private boolean isk2Present;
	private boolean isk3Present;
	private boolean isk4Present;
	private Key key1;
	private Key key2;
	private Key key3;
	private Key key4;
	private Door door1;
	private Door door2;
	private Door door3;
	private Door door4;
	private Knight knight1;
	private Knight knight2;
	private Knight knight3;
	private Knight knight4;
	private Knight knight5;
	private PhantomFlower flower1;
	private PhantomFlower flower2;
	private PhantomFlower flower3;
	private Wizard wizard1;
	private Wizard wizard2;
	private Wizard wizard3;
	private Wizard wizard4;
	private Wizard wizard5;
	private FireSpirit fire;
	private FireSpirit fire2;
	private FireSpirit fire3;
	private FireSpirit fire4;
	private FireSpirit fire5;
	private AttackCat cat1;
	private AttackCat cat2;
	private AttackCat cat3;
	private AttackCat cat4;
	private AttackCat cat5;
	private Elevator elevator1;
	private Elevator elevator2;
	private Elevator elevator3;
	private Moveables brick1;
	private Moveables brick2;
	private Moveables brick3;
	private Moveables honey1;
	private Moveables honey2;
	private Moveables honey3;
	private Moveables brick4;
	private Moveables honey4;
	private Moveables brick5;
	private Moveables honey5;
	private Moveables brick6;
	private Moveables honey6;
	public String direction;
	private Font fontss;
	private char[][] prevRoom;
	private long startSpawn;
	private Princess princess;
	
	
	public GameTimer(Stage stage, GraphicsContext gc, Scene theScene, Image bg, char[][] room, ArrayList<ImageView> cells, ArrayList<Integer> keyInventory,int roomNum){
		this.stage = stage;
		this.gc = gc;
		this.theScene = theScene;
		this.bg = bg;
		this.room = room;
		this.prince = new Prince(0,550);
		this.startSpawn = System.nanoTime();	//get current nanotime
		this.x=0;
		this.y=0;
		this.cells=cells;
		this.count=0;
		this.keyInventory = keyInventory;
		this.roomNum=roomNum;
		this.fontss = Font.font("Times New Roman",FontWeight.BOLD,20);
		this.key1=new Key(0,0,Key.k1);
		this.key2=new Key(0,0,Key.k2);
		this.key3=new Key(0,0,Key.k3);
		this.key4=new Key(0,0,Key.k4);
		this.door1=new Door(0,0,Door.d1);
		this.door2=new Door(0,0,Door.d2);
		this.door3=new Door(0,0,Door.d3);
		this.door4=new Door(0,0,Door.d4);
		this.knight1 = new Knight(318,550,318,636);
		this.knight2 = new Knight(265,450,265,530);
		this.knight3 = new Knight(106,250,106,318);
		this.knight4 = new Knight(265,200,265,477);
		this.knight5 = new Knight(106,150,106,477);
		this.flower1 = new PhantomFlower(106,500);
		this.flower2 = new PhantomFlower(106,300);
		this.flower3 = new PhantomFlower(477,250);
		this.wizard1 = new Wizard(53,200,53,265);
		this.wizard2 = new Wizard(318,350,318,477);
		this.wizard3 = new Wizard(583,400,583,689);
		this.wizard4 = new Wizard(371,200,371,636);
		this.wizard5 = new Wizard(318,500,318,636);
		this.fire=new FireSpirit(583,300,300,450);
		this.fire2=new FireSpirit(742,300,300,450);
		this.fire3=new FireSpirit(159,450,450,550);
		this.fire4=new FireSpirit(583,350,350,550);
		this.fire5=new FireSpirit(53,100,100,300);
		this.cat1=new AttackCat(53,400,53,159);
		this.cat2=new AttackCat(318,500,318,477);
		this.cat3=new AttackCat(636,400,636,742);
		this.cat4=new AttackCat(265,550,265,583);
		this.cat5=new AttackCat(318,400,318,530);
		this.elevator1 = new Elevator(645,280,100,280);
		this.elevator2 = new Elevator(750,150,150,580);
		this.elevator3 = new Elevator(325,200,200,580);
		this.brick1 = new Moveables(265,550, Moveables.BRICK);
		this.brick2 = new Moveables(530,350, Moveables.BRICK);
		this.brick3 = new Moveables(212,200, Moveables.BRICK);
		this.honey1 = new Moveables(318,200, Moveables.HONEYJAR);
		this.honey2 = new Moveables(583,200, Moveables.HONEYJAR);
		this.honey3 = new Moveables(265,350, Moveables.HONEYJAR);
		this.honey4 = new Moveables(477,150, Moveables.HONEYJAR);
		this.brick4 = new Moveables(477,550, Moveables.BRICK);
		this.honey5 = new Moveables(212,400, Moveables.HONEYJAR);
		this.brick5 = new Moveables(530,500, Moveables.BRICK);
		this.honey6 = new Moveables(636,550, Moveables.HONEYJAR);
		this.brick6 = new Moveables(318,250, Moveables.BRICK);
		this.princess = new Princess( 106,500);
		
		//call method to handle mouse click event
		this.handleKeyPressEvent();
	}
	
	private void setFontss(){
		this.gc.setFont(this.fontss);
		// this.gc.setFill(Color.WHITE);
		this.gc.setStroke(Color.WHITE);
		this.gc.setLineWidth(5);
	}

	private void showScore(){
		// System.out.println("HEWO");
		String text = "Score: "+(NextScene.points);
		String text2 = "Health: "+(NextScene.health);
		this.gc.fillText(text,50,50);
		this.gc.fillText(text2,50,70);
		// this.gc.strokeText(text,0,0);
	}
	
	private void setNextScene(String btnName, Image bg, ArrayList<Integer> keyInventory,int roomNum, int x, int y){
		NextScene next = new NextScene(btnName, this.stage, bg, keyInventory,roomNum,x,y);
		stage.setScene(next.getScene());
	}
	
	@Override
	public void handle(long currentNanoTime) {
		this.gc.clearRect(0,100, NextScene.MAP_WIDTH, NextScene.MAP_HEIGHT);
		this.gc.drawImage(this.bg, 0, 100); //always changes the background image
		this.gc.clearRect(0,100, NextScene.MAP_WIDTH, NextScene.MAP_HEIGHT);
		this.gc.getFill();
		this.gc.drawImage(this.bg, 0, 100); //always changes the background image
		this.gc.clearRect(50,35, 100,60);
		// this.gc.Rect(100,35,100,30);
		// Font theFont = Font.font("Times New Roman",FontWeight.BOLD,30);
		// this.gc.setFont(theFont);
		// this.gc.fillText("Points"+NextScene.points,100,50);
		this.setFontss();
		this.showScore();
		// this.showHealth();
		System.out.println("POINTS: "+NextScene.points);
		System.out.println("HEALTH: "+NextScene.health);

		if (NextScene.health == 0 || NextScene.health<0){
			// this.view.setImage(gameOver);
			System.out.println("GAME OVER. YOU LOSE");
			this.stop();
			setNextScene("play", Maps.gameover, this.keyInventory,2,9,1);

			// System.exit(0);
		}
		int i,j;
		int prevCount=this.count;
		this.cells.get(prevCount).setImage(null);
		this.count=0;
		this.isd1Closed=false;
		this.isd2Closed=false;
		this.isd3Closed=false;
		this.isd4Closed=false;
		this.isk1Present=false;
		this.isk2Present=false;
		this.isk3Present=false;
		this.isk4Present=false;
		for(i=0; i <10; i++){
			for(j=0; j<15; j++){
				if(this.room[i][j] == 'P'){
					this.x = i;
					this.y = j;
				}
				if(this.room[i][j] == '1') this.isk1Present=true;
				if(this.room[i][j] == '2') this.isk2Present=true;
				if(this.room[i][j] == '3') this.isk3Present=true;
				if(this.room[i][j] == '4') this.isk4Present=true;
				if(this.room[i][j] == 'A') this.isd1Closed=true;
				if(this.room[i][j] == 'B') this.isd2Closed=true;
				if(this.room[i][j] == 'C') this.isd3Closed=true;
				if(this.room[i][j] == 'D') this.isd4Closed=true;

			}
		}
		
		System.out.println((this.y)*53);
		System.out.println((this.x)*50+100);
		this.prince.setPosition(this.y*53, this.x*50+100);
		long currentSec = TimeUnit.NANOSECONDS.toSeconds(currentNanoTime);
		long startSec = TimeUnit.NANOSECONDS.toSeconds(this.startSpawn);

		
		
		
		for(i=0;i<10;i++){
			for(j=0;j<15;j++) System.out.print(" "+room[i][j]+" ");
			System.out.println();
		}
//		for(i=0;i<this.keyInventory.size();i++) {
//			System.out.println(this.keyInventory.get(i));
//		}
		boolean toBreak=false;
		for(i=0;i<10;i++){
			for(j=0;j<15;j++) {
				if(this.x==i && this.y==j) {
					toBreak = true;
					break;
				}else this.count++;
			}
			if(toBreak) break;
		}
		
		//rendering of the catcher
//		this.prince.render(this.cells.get(count));
		this.prince.render(gc);
		this.prince.move();
		
		
		//CHANGING SCENE!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!1
		if(this.roomNum==1) {
			if(this.isk1Present) this.key1.render(gc,159,500);
			if(this.isk2Present) this.key2.render(gc, 106,200);
			if(this.isd1Closed) this.door1.render(gc,212,550);
			if(this.isd2Closed) this.door2.render(gc,742,550);
			/////////////////////////////////////////////////////////////
			if(this.brick1.collidesWith(this.knight1)) knight1.die();
			if(this.brick2.collidesWith(this.knight2)) knight2.die();
			
			checkHealth(this.knight1,this.prince);
			checkHealth(this.knight2,this.prince);
			checkHealth(this.knight3,this.prince);
			
			/////////////////////////////////////////////////////////////
			brick1.render(gc);
			brick2.render(gc);
			if(this.brick1.collidesWith(this.prince)) brick1.move(this.direction);
			if(this.brick2.collidesWith(this.prince)) brick2.move(this.direction);
			/////////////////////////////////////////////////////////////
			if(this.x==9 && this.y==14) {
				this.stop();
				setNextScene("play", Maps.map2, this.keyInventory,2,9,1);
			}
		}else if(this.roomNum==2) {
			if(this.isk1Present) this.key1.render(gc,265,350);
			if(this.isk2Present) this.key2.render(gc,265,250);
			if(this.isk4Present) this.key4.render(gc,371,350);
			if(this.isd1Closed) this.door1.render(gc,742,550);
			if(this.isd2Closed) this.door2.render(gc,424,450);
			if(this.isd3Closed) this.door3.render(gc,212,550);
			/////////////////////////////////////////////////
			brick3.render(gc);
			if(this.brick3.collidesWith(this.prince)) brick3.move(this.direction);
			if(this.brick3.collidesWith(knight4)) knight4.die();
			honey6.render(gc);
			if(this.honey6.collidesWith(this.prince)) honey6.move(this.direction);
			if(this.honey6.collidesWith(this.cat4)) cat4.die();
			this.elevator1.move();
			this.elevator1.render(gc);
			this.flower1.setPosition(106,500);
			this.flower2.setPosition(106,300);
			this.flower3.setPosition(477,250);
			this.flower1.render(gc, PhantomFlower.REST_FLOWER);
			this.flower2.render(gc, PhantomFlower.REST_FLOWER);
			this.flower3.render(gc, PhantomFlower.REST_FLOWER);
			this.knight4.move();
			if(knight4.isAlive()) this.knight4.render(gc);
			this.fire4.move();
			this.fire4.render(gc);
			this.cat4.move();
			if(this.cat4.isAlive()) this.cat4.render(gc);
			/////////////////////////////////////////////////////////////
			if((currentSec-startSec)%this.flower1.speed==0) {
				this.flower1.render(gc, PhantomFlower.ATTACK_FLOWER);
			}
			if((currentSec-startSec)%this.flower2.speed==0) {
				this.flower2.render(gc, PhantomFlower.ATTACK_FLOWER);
			}
			if((currentSec-startSec)%this.flower3.speed==0) {
				this.flower3.render(gc, PhantomFlower.ATTACK_FLOWER);
			}
			////////////////////////////////////////////////////////////
			if(this.x==0 && this.y==12) {
				this.stop();
				setNextScene("play", Maps.map5,this.keyInventory,5,9,11);
			}else if(this.x==9 && this.y==0) {
				this.stop();
				setNextScene("play", Maps.map1, this.keyInventory,1,9,13);
			}else if(this.x==6 && this.y==14) {
				this.stop();
				setNextScene("play", Maps.map3,this.keyInventory,3,6,1);
			}
			else if(this.x==9 && this.y==14) {
				this.stop();
				setNextScene("play", Maps.map3,this.keyInventory,3,9,1);
			}
		}else if(this.roomNum==3) {
			if(this.isk1Present) this.key1.render(gc,477,150);
			if(this.isk2Present) this.key2.render(gc,477,350);
			if(this.isk3Present) this.key3.render(gc,106,450);
			if(this.isk4Present) this.key4.render(gc,212,500);
			if(this.isd1Closed) this.door1.render(gc,0,400);
			///////////////////////////////////////////////////////////
			brick5.render(gc);
			if(this.brick5.collidesWith(this.prince)) brick5.move(this.direction);
			honey5.render(gc);
			if(this.honey5.collidesWith(this.prince)) honey5.move(this.direction);
			this.flower1.setPosition(106,200);
			this.flower2.setPosition(265,150);
			this.flower3.setPosition(424,200);
			this.flower1.render(gc, PhantomFlower.REST_FLOWER);
			this.flower2.render(gc, PhantomFlower.REST_FLOWER);
			this.flower3.render(gc, PhantomFlower.REST_FLOWER);
//			this.cat1.move();
//			this.cat2.move();
//			this.cat3.move();
			if(this.honey5.collidesWith(this.cat1)) this.cat1.die();
			if(this.brick5.collidesWith(this.cat2)) this.cat2.die();
//			if(cat1.isAlive()) this.cat1.render(gc);
//			if(cat2.isAlive()) this.cat2.render(gc);
			this.cat3.render(gc);
			this.fire3.move();
			this.fire3.render(gc);
			
			if((currentSec-startSec)%this.flower1.speed==0) {
				this.flower1.render(gc, PhantomFlower.ATTACK_FLOWER);
			}
			if((currentSec-startSec)%this.flower2.speed==0) {
				this.flower2.render(gc, PhantomFlower.ATTACK_FLOWER);
			}
			if((currentSec-startSec)%this.flower3.speed==0) {
				this.flower3.render(gc, PhantomFlower.ATTACK_FLOWER);
			}
			checkCat(this.cat1,this.prince);
			checkCat(this.cat2,this.prince);
			checkCat(this.cat3,this.prince);
			//////////////////////////////////////////////////////////
			if(this.x==0 && this.y==11) {
				this.stop();
				setNextScene("play", Maps.map6,this.keyInventory, 6,9,10);
			}
			else if(this.x==6 && this.y==0) {
				this.stop();
				setNextScene("play", Maps.map2,this.keyInventory, 2,6,13);
			}else if(this.x==9 && this.y==0) {
				this.stop();
				setNextScene("play", Maps.map2,this.keyInventory, 2,9,13);
			}
		}else if(this.roomNum==4) {
			if(this.isk3Present) this.key3.render(gc,636,300);
			if(this.isd4Closed) this.door4.render(gc,106,300);
			if(this.isd3Closed) this.door3.render(gc,265,500);
			/////////////////////////////////////////////////////
			this.flower1.setPosition(530,100);
			this.flower2.setPosition(424,250);
			this.flower3.setPosition(583,350);
			this.flower1.render(gc, PhantomFlower.REST_FLOWER);
			this.flower2.render(gc, PhantomFlower.REST_FLOWER);
			this.flower3.render(gc, PhantomFlower.REST_FLOWER);
			this.knight5.move();
			this.wizard5.move();
			this.cat5.move();
			this.fire5.move();
			this.knight5.render(gc);
			this.wizard5.render(gc);
			this.cat5.render(gc);
			this.fire5.render(gc);
			brick6.render(gc);
			if(this.brick6.collidesWith(this.prince)) brick6.move(this.direction);
			this.princess.render(gc);
			if(this.prince.collidesWith(this.princess)) {
				this.stop();
				setNextScene("play", Maps.winBG ,this.keyInventory, 0,0,0);
			}
			/////////////////////////////////////////////////////
			/////////////////////////////////////////////////////////////
			if((currentSec-startSec)%this.flower1.speed==0) {
			this.flower1.render(gc, PhantomFlower.ATTACK_FLOWER);
			}
			if((currentSec-startSec)%this.flower2.speed==0) {
			this.flower2.render(gc, PhantomFlower.ATTACK_FLOWER);
			}
			if((currentSec-startSec)%this.flower3.speed==0) {
			this.flower3.render(gc, PhantomFlower.ATTACK_FLOWER);
			}
			////////////////////////////////////////////////////////////
			if(this.x==2 && this.y==14) {
				this.stop();
				setNextScene("play", Maps.map5,this.keyInventory, 5,2,1);
			}
		}else if(this.roomNum==5) {
			if(this.isk3Present) this.key3.render(gc,583,300);
			if(this.isd2Closed) this.door2.render(gc,530,550);
			if(this.isd4Closed) this.door4.render(gc,0,200);
			/////////////////////////////////////////////////////
			this.elevator2.move();
			this.elevator2.render(gc);
//			this.wizard1.move();
//			this.wizard2.move();
//			this.wizard3.move();
			checkWizard(this.wizard1,this.prince);
			checkWizard(this.wizard2,this.prince);
			checkWizard(this.wizard3,this.prince);
			if(this.honey1.collidesWith(wizard1)) wizard1.die();
			if(this.honey2.collidesWith(wizard3)) wizard3.die();
			if(this.honey3.collidesWith(wizard2)) wizard2.die();
//			if(wizard1.isAlive()) this.wizard1.render(gc);
//			if(wizard2.isAlive()) this.wizard2.render(gc);
//			if(wizard3.isAlive()) this.wizard3.render(gc);
			this.honey1.render(gc);
			this.honey2.render(gc);
			this.honey3.render(gc);
			if(this.honey1.collidesWith(this.prince)) honey1.move(this.direction);
			if(this.honey2.collidesWith(this.prince)) honey2.move(this.direction);
			if(this.honey3.collidesWith(this.prince)) honey3.move(this.direction);
			
			///////////////////////////////////////////////////////
			if(this.x==9 && this.y==12) {
				this.stop();
				setNextScene("play", Maps.map2, this.keyInventory, 2, 1,12);
			}else if(this.x==2 && this.y==0) {
				this.stop();
				setNextScene("play", Maps.map4,this.keyInventory, 4,2,13);
			}else if(this.x==2 && this.y==14) {
				this.stop();
				setNextScene("play", Maps.map6,this.keyInventory,6,2,1);
			}
		}else if(this.roomNum==6) {
			if(this.isk1Present) this.key1.render(gc,636,150);
			if(this.isk2Present) this.key2.render(gc,424,300);
			if(this.isd1Closed) this.door1.render(gc,530,450);
			if(this.isd2Closed) this.door2.render(gc,742,550);
			if(this.isd3Closed) this.door3.render(gc,159,200);
			///////////////////////////////////////////////////////
			
			////////////////////////////////////////////////////////
			this.elevator3.move();
			this.elevator3.render(gc);
			this.brick4.render(gc);
			this.honey4.render(gc);
			checkFire(this.fire,this.prince);
			checkFire(this.fire2,this.prince);
			checkWizard(this.wizard4,this.prince);
			checkHealth(this.knight4,this.prince);
			if(this.honey4.collidesWith(this.prince)) honey4.move(this.direction);
			if(this.brick4.collidesWith(this.prince)) brick4.move(this.direction);
			
			
			/////////////////////////////////////////////////////////
			if(this.x==9 && this.y==1) {
				this.stop();
				setNextScene("play", Maps.map3,this.keyInventory, 3,0,1);
			}else if(this.x==2 && this.y==0) {
				this.stop();
				setNextScene("play", Maps.map5,this.keyInventory, 5,2,13);
			}
			else if(this.x==9 && this.y==14) {
				this.stop();
				setNextScene("play", Maps.map3,this.keyInventory, 3,0,14);
			}else if(this.x==9 && this.y==11) {
				this.stop();
				setNextScene("play", Maps.map3,this.keyInventory, 3, 1,11);
			}
		}
	}
	
	private void checkHealth(Knight knight, Prince prince){
		if(knight.isAlive()){
			knight.move();
			knight.render(gc);
		}
		if(knight.collidesWith(prince)){
			System.out.println(knight.isAlive());
			if(knight.isAlive()){
				NextScene.health = NextScene.health-1;
		}
		knight.die();
}
}

private void checkFire(FireSpirit knight, Prince prince){
		if(knight.isAlive()){
			knight.move();
			knight.render(gc);
		}
		if(knight.collidesWith(prince)){
			System.out.println(knight.isAlive());
			if(knight.isAlive()){
				NextScene.health = NextScene.health-1;
		}
		knight.die();
}
}

private void checkCat(AttackCat knight, Prince prince){
		if(knight.isAlive()){
			knight.move();
			knight.render(gc);
		}
		if(knight.collidesWith(prince)){
			System.out.println(knight.isAlive());
			if(knight.isAlive()){
				NextScene.health = NextScene.health-1;
		}
		knight.die();
}
}

private void checkWizard(Wizard knight, Prince prince){
		if(knight.isAlive()){
			knight.move();
			knight.render(gc);
		}
		if(knight.collidesWith(prince)){
			System.out.println(knight.isAlive());
			if(knight.isAlive()){
				NextScene.health = NextScene.health-1;
		}
		knight.die();
}
}

//void flowerCheck(PhantomFlower flower,Prince prince,int x, int y,long currentSec, long startSec){
//	if (flower.isAlive()){
//			flower.render(gc,PhantomFlower.REST_FLOWER);
//			if((currentSec-startSec)%flower.speed==0) {
//			flower.render(gc, PhantomFlower.ATTACK_FLOWER);
//			flower.setPosition(x,y);
//			System.out.println("X"+x);
//			System.out.println("Y"+y);
//		}
//	}
//	if (prince.collidesWith(flower)){
//		System.out.println("hi");
//		System.out.println(flower.isAlive());
//		if(flower.isAlive()){
//			NextScene.health = NextScene.health-1;
//			flower.die();
//		}
//	}
//}
	
	//method that will listen and handle the key press events
	private void handleKeyPressEvent() {
		theScene.setOnKeyPressed(new EventHandler<KeyEvent>(){
			public void handle(KeyEvent e){
            	KeyCode code = e.getCode();
                movePrince(code, room);
			}
			
		});
		
		theScene.setOnKeyReleased(new EventHandler<KeyEvent>(){
			public void handle(KeyEvent e){
				KeyCode code = e.getCode();
				stopPrince(code);
			}
		});
    }
	
	//method that will move the catcher depending on the key pressed
	private void movePrince(KeyCode ke, char[][] board) {
		if(ke==KeyCode.UP) {
//			this.prince.setDY(-10);
			
			try{
				char temp = board[x-1][y];
				if(board[x-1][y] == ' '){
					board[x-1][y] = 'P';
					if(prev=='_') board[x][y] = '_';
					else board[x][y] = ' ';
					prev = temp;
				}else if(board[x-1][y] == 'X' || board[x-1][y] == '_')board[x][y] = 'P';
				else if(board[x-1][y] == '1' || board[x-1][y] == '2' || board[x-1][y] == '3'|| board[x-1][y] == '4'){
					NextScene.points = NextScene.points+10;
					String key="0";
					if(board[x-1][y] == '1') key = "1";
					else if(board[x-1][y] == '2') key = "2";
					else if(board[x-1][y] == '3') key = "3";
					else if(board[x-1][y] == '4') key = "4";
					keyInventory.add(Integer.parseInt(key));
					board[x-1][y] = ' ';
					board[x][y] = 'P';
				}else if (board[x-1][y] == 'V'){
					NextScene.health = NextScene.health-1;
				}
			}catch(ArrayIndexOutOfBoundsException e){}
		}
		if(ke==KeyCode.DOWN) {
//			this.prince.setDY(10);
			try{

				char temp = board[x+1][y];
				if(board[x+1][y] == ' '){
					if(prev == '_'){ //prev == '_' &&
						board[x][y] = 'P';
					}else{
						board[x+1][y] = 'P';
						board[x][y] = ' ';
					}
					// prev = temp;
				}else if(board[x+1][y] == '_'){
					if(prev=='_'){
						board[x][y] = 'P';
					}else{
						board[x+1][y] = 'P';
						board[x][y] = ' ';
					}
					prev = temp;
				}
				else if(board[x+1][y] == 'X'){
					board[x][y] = 'P';
					prev = temp;
				}else if(board[x+1][y] == '1' || board[x+1][y] == '2' || board[x+1][y] == '3' || board[x+1][y] == '4'){
						NextScene.points = NextScene.points+10;
						String key="0";
						if(board[x+1][y] == '1') key = "1";
						else if(board[x+1][y] == '2') key = "2";
						else if(board[x+1][y] == '3') key = "3";
						else if(board[x+1][y] == '4') key = "4";
						keyInventory.add(Integer.parseInt(key));
						board[x+1][y] = ' ';
						board[x][y] = 'P';
					prev = temp;
				}else if (board[x+1][y] == 'V'){
					NextScene.health = NextScene.health-1;
				}	
			}catch(ArrayIndexOutOfBoundsException e) {}
		}
		if(ke==KeyCode.RIGHT) {
//			this.prince.setDX(10);
			this.direction="right";
			try{
				char temp=board[x][y+1];
				if(board[x][y+1] == ' '){
					board[x][y+1] = 'P';
					if(prev=='_') board[x][y] = '_';
					else board[x][y] = ' ';
					prev=temp;
				}else if(board[x][y+1] == '_'){
					board[x][y+1] = 'P';
					if(prev==' ') board[x][y] = ' ';
					else board[x][y] = '_';
					prev=temp;
				}else if(board[x][y+1] == 'X'){
					board[x][y] = 'P';
				}else if(board[x][y+1] == '1' || board[x][y+1] == '2' || board[x][y+1] == '3' || board[x][y+1] == '4'){
					NextScene.points = NextScene.points+10;
					String key="0";
					if(board[x][y+1] == '1') key = "1";
					else if(board[x][y+1] == '2') key = "2";
					else if(board[x][y+1] == '3') key = "3";
					else if(board[x][y+1] == '4') key = "4";
					keyInventory.add(Integer.parseInt(key));
					board[x][y+1] = ' ';
					board[x][y] = 'P';
				}else if(board[x][y+1] == 'A' || board[x][y+1] == 'B'||board[x][y+1] == 'C'||board[x][y+1] == 'D'){
					if(board[x][y+1] == 'A') {
						int index=keyInventory.indexOf(1);
						if(index!=-1){
							board[x][y+1] = '_';
							board[x][y] = 'P';
							keyInventory.remove(index);
						}
					}else if(board[x][y+1] == 'B'){
						int index=keyInventory.indexOf(2);
						if(index!=-1){
							board[x][y+1] = '_';
							board[x][y] = 'P';
							keyInventory.remove(index);
						}
					}else if(board[x][y+1] == 'C'){
						int index=keyInventory.indexOf(3);
						if(index!=-1){
							board[x][y+1] = '_';
							board[x][y] = 'P';
							keyInventory.remove(index);
						}
					}else if(board[x][y+1] == 'D'){
						int index=keyInventory.indexOf(4);
						if(index!=-1){
							board[x][y+1] = '_';
							board[x][y] = 'P';
							keyInventory.remove(index);
						}
					}
				}else if (board[x][y+1] == 'V'){
					NextScene.health = NextScene.health-1;
				}

			}catch(ArrayIndexOutOfBoundsException e){}
		}
		if(ke==KeyCode.LEFT) {
//			this.prince.setDX(-10);
			this.direction="left";
			try{
				char temp = board[x][y-1];
				if(board[x][y-1] == ' '){
					board[x][y-1] = 'P';
					if(prev=='_') board[x][y] = '_';
					else board[x][y] = ' ';
					prev = temp;
				}else if(board[x][y-1] == '_'){
					board[x][y-1] = 'P';
					if(prev==' ') board[x][y] = ' ';
					else board[x][y] = '_';
					prev = temp;
				}
				else if(board[x][y-1] == 'X'){
					board[x][y] = 'P';
				}else if(board[x][y-1] == '1' || board[x][y-1] == '2' || board[x][y-1] == '3'|| board[x][y-1] == '4'){
					NextScene.points = NextScene.points+10;
					String key="0";
					if(board[x][y-1] == '1') key = "1";
					else if(board[x][y-1] == '2') key = "2";
					else if(board[x][y-1] == '3') key = "3";
					else if(board[x][y-1] == '4') key = "4";
					keyInventory.add(Integer.parseInt(key));
					board[x][y-1] = ' ';
					board[x][y] = 'P';
				}else if(board[x][y-1] == 'A' || board[x][y-1] == 'B' || board[x][y-1] == 'C' || board[x][y-1] == 'D'){
					if(board[x][y-1] == 'A') {
						int index=keyInventory.indexOf(1);
						if(index!=-1){
							board[x][y-1] = '_';
							board[x][y] = 'P';
							keyInventory.remove(index);
						}
					}else if(board[x][y-1] == 'B'){
						int index=keyInventory.indexOf(2);
						if(index!=-1){
							board[x][y-1] = '_';
							board[x][y] = 'P';
							keyInventory.remove(index);
						}
					}else if(board[x][y-1] == 'C'){
						int index=keyInventory.indexOf(3);
						if(index!=-1){
							board[x][y-1] = '_';
							board[x][y] = 'P';
							keyInventory.remove(index);
						}
					}else if(board[x][y-1] == 'D'){
						int index=keyInventory.indexOf(4);
						if(index!=-1){
							board[x][y-1] = '_';
							board[x][y] = 'P';
							keyInventory.remove(index);
						}
					}
				}else if (board[x][y-1] == 'V'){
					NextScene.health = NextScene.health-1;
				}
			}catch(ArrayIndexOutOfBoundsException e){}
		}
		System.out.println(ke+" key pressed.");
   	}
	
	//method that will stop the catcher's movement; set the ship's DX and DY to 0
	private void stopPrince(KeyCode ke){
		this.prince.setDX(0);
		this.prince.setDY(0);
	}
}

