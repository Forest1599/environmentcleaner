package tiles;

import eriksbenne.environmentcleaner.GameObject;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.shape.Rectangle;

public class Tile extends GameObject{
	boolean walkable;
	
	public Tile(GraphicsContext gc, double x, double y) {
		super(gc, x, y);
//		super.collisionArea =  new Rectangle(x, y, 32, 32);
	}
	
	public void setX(double x) {
		this.x = x;
//		collisionArea.setX(x);
	}
	
	public void setY(double y) {
		this.y = y;
//		collisionArea.setY(x);
	}
	
	public boolean isWalkable() {
		return walkable;
	}
	
	
}
