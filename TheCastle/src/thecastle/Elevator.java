package thecastle;

import javafx.scene.image.Image;

public class Elevator extends Sprite{
	private int max;
	private int min;
	private String direction;
	private int speed;
	
	public final static Image ELEVATOR_IMAGE = new Image("images/elevator.png",45,20, false, false); 

	
	public Elevator(int x, int y, int min, int max) {
		super(x,y);
		this.min=min;
		this.max=max;
		this.speed=2;
		this.direction = "Up";
		this.loadImage(Elevator.ELEVATOR_IMAGE);
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
}
