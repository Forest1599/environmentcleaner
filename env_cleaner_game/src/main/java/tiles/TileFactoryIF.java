package tiles;

public interface TileFactoryIF {
	Tile createProduct(int discrim, double worldX, double worldY);
}
