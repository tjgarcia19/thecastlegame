package thecastle;

import java.util.Random;
import javafx.scene.image.Image;

public class AttackCat extends Sprite{
	private int max;
	private int min;
	private boolean alive;
	private String direction;
	private int speed;
	
	public final static Image CAT_IMAGE = new Image("images/cat.gif", 40,50, false, false); 

	
	public AttackCat(int x, int y, int min, int max) {
		super(x,y);
		this.min=min;
		this.max=max;
		Random r = new Random();
		int speed;
		do {
			speed = r.nextInt(4);
			this.speed = speed;
		}while(speed == 0);
		this.direction = "Right";
		this.alive = true;
		this.loadImage(AttackCat.CAT_IMAGE);
	}
	
	public void setRange(int min, int max) {
		this.min=min;
		this.max=max;
	}
	
	public boolean isAlive(){
		if(this.alive) return true;
		return false;
	} 

	public void die(){
    	this.alive = false;
    }
	
	public void move() {
		this.y += this.dy;
		if(this.x + this.dx < this.min) {	
			this.setDX(this.speed);
			this.direction = "Right";
		}else if(this.x + this.dx > this.max) {
			this.setDX(-this.speed);
			this.direction = "Left";
		}else {
			if(this.direction.equals("Left")) {
				this.setDX(-this.speed);
			}else {
				this.setDX(this.speed);
			}
			this.x += this.dx;
		}
	}
}
