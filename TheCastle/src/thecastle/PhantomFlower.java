package thecastle;

import java.util.Random;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class PhantomFlower extends Sprite{
	public int speed;
	public boolean isAttacking;
	public final static Image ATTACK_FLOWER = new Image("images/pfattack.png", 53,50, false, false);
	public final static Image REST_FLOWER = new Image("images/pfrest.png", 53,50, false, false); 

	
	public PhantomFlower (int x, int y) {
		super(x,y);
		Random r = new Random();
		int speed;
		do {
			speed = r.nextInt(5);
			this.speed = speed;
		}while(speed<3);
		this.isAttacking=false;
	}
	
	//method to set the image to the image view node
	void render(GraphicsContext gc, Image img){
		gc.drawImage(img, this.x, this.y);   
	}
}