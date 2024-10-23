package thecastle;

import java.util.Random;
import javafx.scene.image.Image;

public class FireSpirit extends Sprite{
	private int max;
	private int min;
	private String direction;
	private boolean alive;
	private int speed;
	
	public final static Image FIRE_IMAGE = new Image("images/flame.gif", 40,50, false, false); 

	
	public FireSpirit(int x, int y, int min, int max) {
		super(x,y);
		this.min=min;
		this.max=max;
		Random r = new Random();
		int speed;
		do {
			speed = r.nextInt(4);
			this.speed = speed;
		}while(speed == 0);
		this.direction = "Up";
		this.loadImage(FireSpirit.FIRE_IMAGE);
	}
	
	public void move() {
		this.x += this.dx;
		if(this.y + this.dy < this.min) {	
			this.setDY(this.speed);
			this.direction = "Up";
		}else if(this.y + this.dy > this.max) {
			this.setDY(-this.speed);
			this.direction = "Down";
		}else {
			if(this.direction.equals("Down")) {
				this.setDY(-this.speed);
			}else {
				this.setDY(this.speed);
			}
			this.y += this.dy;
		}
	}
	
	public boolean isAlive(){
		if(this.alive) return true;
		return false;
	} 

	public void die(){
    	this.alive = false;
    }
}
