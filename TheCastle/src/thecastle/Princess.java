package thecastle;

import javafx.scene.image.Image;

public class Princess extends Sprite{
	public static final Image princess = new Image("images/princess.png", 53, 50, false, false);
	public Princess(int x, int y) {
		super(x,y);
		this.loadImage(Princess.princess);
	}
}
