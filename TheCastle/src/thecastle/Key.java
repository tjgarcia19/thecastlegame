package thecastle;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Key extends Sprite{
	public static final Image k1 = new Image("images/bluekey.png", 53,50, false, false);
	public static final Image k2 = new Image("images/greenkey.png", 53,50, false, false); 
	public static final Image k3 = new Image("images/redkey.png", 53,50, false, false);
	public static final Image k4 = new Image("images/yellowkey.png", 53,50, false, false); 
	
	public Key(int x, int y, Image key) {
		super(x,y);
		this.loadImage(key);
	}
	
	void render(GraphicsContext gc, int x, int y){
		gc.drawImage(this.img, x, y);
    }
}
