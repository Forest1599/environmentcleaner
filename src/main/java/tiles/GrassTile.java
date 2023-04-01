package tiles;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import player.Player;

public class GrassTile extends Tile{

	public GrassTile(GraphicsContext gc, double x, double y) {
		super(gc, x, y);
		super.setImage(new Image(GrassTile.class.getResource("grass.png").toExternalForm()));
		super.walkable = true;
	}
	
}
