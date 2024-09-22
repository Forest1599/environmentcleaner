package trash;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import player.Player;

public class TrashCardboard extends Trash{

	public TrashCardboard(GraphicsContext gc, double x, double y) {
		super(gc, x, y);
		super.setImage(new Image(TrashCardboard.class.getResource("cardboard.png").toExternalForm()));;
	}

}
