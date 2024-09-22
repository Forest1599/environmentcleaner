package trash;

import javafx.scene.canvas.GraphicsContext;

public class TrashFactory implements FactoryTrashIF{
	private GraphicsContext gc;
	
	public TrashFactory(GraphicsContext gc) {
		this.gc = gc;
	}
	
	
	public Trash createProduct(String discrim, double x, double y) {
		Trash gameObject = null;
		
		if(discrim.equals("plastic")) {
			gameObject = new TrashPlastic(gc, x, y);
		} else if(discrim.equals("cardboard")) {
			gameObject = new TrashCardboard(gc, x, y);
		} else if(discrim.equals("glass")) {
			gameObject = new TrashGlass(gc, x, y);
		}
		
		return gameObject;
	}
	
	

}
