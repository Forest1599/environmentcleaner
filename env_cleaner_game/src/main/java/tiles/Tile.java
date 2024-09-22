package tiles;

import eriksbenne.environmentcleaner.GameObject;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.shape.Rectangle;

public class Tile extends GameObject{
	boolean walkable;
	
	public Tile(GraphicsContext gc, double worldX, double worldY) {
		super(gc, worldX, worldY);
	}
	
	public void setX(double x) {
		this.screenX = x;
	}
	
	public void setY(double y) {
		this.screenY = y;
	}
	
	
	public boolean isWalkable() {
		return walkable;
	}
	
	
}
