package trash;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import player.Player;

public class TrashGlass extends Trash{

	public TrashGlass(GraphicsContext gc, double x, double y) {
		super(gc, x, y);
		super.setImage(new Image(TrashGlass.class.getResource("glass.png").toExternalForm()));;
	}
	
	// Other methods

}
