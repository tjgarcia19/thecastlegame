package thecastle;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Moveables extends Sprite{
	public String direction;
	public Moveables(int x, int y, Image img) {
		super(x,y);
		this.loadImage(img);
	}
	public static final Image HONEYJAR = new Image("images/honeyjar.png", 53,50, false, false);
	public static final Image BRICK = new Image("images/brick.png", 53,50, false, false); 
	
	void render(GraphicsContext gc, int x, int y){
		this.x=x;
		this.y=y;
		gc.drawImage(this.img, x, y);
    }
	
	void move(String direction) {
		this.direction = direction;
		if(direction.equals("right")) {
			if(this.x+53 > 800){//do nothing
			}else this.x+=53;
		}
		else if(direction.equals("left")) {
			if(this.x-53 < 0){//do nothing
			}else this.x-=53;
		}
	}
}
