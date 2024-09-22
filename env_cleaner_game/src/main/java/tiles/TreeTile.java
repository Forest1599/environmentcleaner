package tiles;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import player.Player;

public class TreeTile extends Tile{

	public TreeTile(GraphicsContext gc, double worldX, double worldY) {
		super(gc, worldX, worldY);
		super.setImage(new Image(TreeTile.class.getResource("tree.png").toExternalForm()));
		super.walkable = false;
	}

}
