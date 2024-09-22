package tiles;

import javafx.scene.canvas.GraphicsContext;

public class TileFactory implements TileFactoryIF{
	
	private GraphicsContext gc;
	
	public TileFactory(GraphicsContext gc) {
		this.gc = gc;
	}
	
	@Override
	public Tile createProduct(int discrim, double worldX, double worldY) {
		Tile tile = null;
		
		if(discrim == 0) {
			tile = new GrassTile(gc, worldX, worldY);
		} else if(discrim == 1) {
			tile = new TreeTile(gc, worldX, worldY);
		}
		
		return tile;
	}
	
}
	

