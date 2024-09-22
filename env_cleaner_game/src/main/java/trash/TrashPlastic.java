package trash;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import player.Player;

public class TrashPlastic extends Trash{

	public TrashPlastic(GraphicsContext gc, double x, double y) {
		super(gc, x, y);
		super.setImage(new Image(TrashPlastic.class.getResource("plastic.png").toExternalForm()));;
	}

}
