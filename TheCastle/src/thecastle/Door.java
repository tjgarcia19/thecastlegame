package thecastle;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Door extends Sprite{
	public static final Image d1 = new Image("images/bluedoor.png", 53,50, false, false);
	public static final Image d2 = new Image("images/greendoor.png", 53,50, false, false); 
	public static final Image d3 = new Image("images/reddoor.png", 53,50, false, false);
	public static final Image d4 = new Image("images/yellowdoor.png", 53,50, false, false); 
	
	public Door(int x, int y, Image door) {
		super(x,y);
		this.loadImage(door);
	}
	void render(GraphicsContext gc, int x, int y){
		gc.drawImage(this.img, x, y);
    }
}
