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
	protected double x,y,width,height;
	protected GraphicsContext gc;
	
	
	protected Rectangle collisionArea;
	protected boolean solidObject = false;
	
	public GameObject(GraphicsContext gc, double x, double y) {
		this.gc = gc;
		this.x = x;
		this.y = y;
	}
	
	public void update() { 
		if(img!=null) {
			gc.drawImage(img,x,y, img.getWidth(), img.getHeight());
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
		return new Rectangle2D(x, y, width, height);
	}
	
	public Image getImage() {
		return img;
	}
}
