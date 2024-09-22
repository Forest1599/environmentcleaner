package eriksbenne.environmentcleaner;

import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.shape.Rectangle;

public class GameObject {
	protected Image img;
	protected double screenX, screenY;
	protected double worldX, worldY;
	protected double width,height;
	protected GraphicsContext gc;
	protected Rectangle collisionArea;
	
	public GameObject(GraphicsContext gc, double worldX, double worldY) {
		this.gc = gc;
		this.worldX = worldX;
		this.worldY = worldY;
	}
	
//	public GameObject(GraphicsContext gc) {
//		this.gc = gc;
//	}
	
	public void update() { 
		if(img!=null) {
			gc.drawImage(img, screenX, screenY, img.getWidth(), img.getHeight());
		}
	}
	
	public boolean intersects(GameObject gameObject) {
		boolean intersected = false;
		
		if(gameObject.getBoundary().intersects(this.getBoundary())) {
			intersected = true;
		}
		
		return intersected;
	}
	
	public void setImage(Image image) {
		img = image;
		width = image.getWidth();
		height = image.getHeight();
	}
	
	public Rectangle2D getBoundary() {
		return new Rectangle2D(screenX, screenY, width, height);
	}
	
	public Image getImage() {
		return img;
	}
	
	public double getWorldX() {
		return worldX;
	}
	
	public double getWorldY() {
		return worldY;
	}
}
