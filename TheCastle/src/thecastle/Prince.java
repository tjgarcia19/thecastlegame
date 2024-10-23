package thecastle;

import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

class Prince extends Sprite{
	public final static Image prince = new Image("images/prince.png", 53,50, false, false); 
	
	public Prince(int x, int y) {
		super(x,y);
		this.loadImage(Prince.prince);
	}
	
//	void render(ImageView iv){	
//		iv.setImage(this.img);
//		//set x and y position of the image view
//		iv.setLayoutX(this.x);
//		iv.setLayoutY(this.y);
//        
//    }
	
	public void move() {
		if(this.x + this.dx < 0) {//do nothing
		}else if(this.x + this.dx > 747) {//do nothing
		}else { this.x += this.dx; //move x position
		}
		if(this.y + this.dy < 100) {//do nothing
		}else if(this.y + this.dy > 550) {//do nothing
		}else { this.y += this.dy; //move y position
		}
		
//		if(this.x + this.dx < 0) {//do nothing
//		}else if(this.x + this.dx >53) {//do nothing
//		}else { this.x += this.dx; //move x position
//		}
//		if(this.y + this.dy < 100) {//do nothing
//		}else if(this.y + this.dy > 50) {//do nothing
//		}else { this.y += this.dy; //move y position
//		}
	}
}