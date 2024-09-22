package tiles;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

import javafx.scene.canvas.GraphicsContext;
import player.Player;

public class TileGenerator {
	private GraphicsContext gc;
	private ArrayList<ArrayList<Tile>> gameBoard;
	private Player player;
	
	public TileGenerator(GraphicsContext gc, Player player) {
		this.gc = gc;
		gameBoard = createGameBoard();
		this.player = player;
	}
	
	private BufferedReader getFileBufferedReader() {
		
		BufferedReader bufferedReader = null;
		
		InputStream inputStream = getClass().getResourceAsStream("/Maps/map1");
		bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

		
		return bufferedReader;
		
	}
	
	private String readLine(BufferedReader br) {
		String line = "";
		
		try {
			line = br.readLine();
		}catch(IOException e) {
			System.out.println("The file could not be read");
		}
		return line;
		
	}
	
	public ArrayList<ArrayList<Tile>> createGameBoard(){
		ArrayList<ArrayList<Tile>> gameBoard = new ArrayList<ArrayList<Tile>>();
		TileFactory tileFactory = new TileFactory(gc);
		BufferedReader bufferedReader = getFileBufferedReader();
		
		// Tile positions
		int x = 0; 
		int y = 0;
		
		String line = readLine(bufferedReader);
		Tile tile = null;
		
		int col = 0;

		while(line != null) {	
			
			String[] mapNums = line.split(" "); // Splits the row into tile types
			ArrayList<Tile> tempArray = new ArrayList<Tile>();
			
			while(col < mapNums.length) {
				
				int tileNum = Integer.parseInt(mapNums[col]); // The tile type
				
				tile = tileFactory.createProduct(tileNum, x , y);
				tempArray.add(tile);
				
				x += tile.getImage().getWidth();
				col++;
			}
			
			x = 0;
			y += tile.getImage().getHeight();
			col = 0;
			
			gameBoard.add(tempArray);
			line = readLine(bufferedReader); // reads the next line
			
		}	
		
		
		return gameBoard;
		
	}
	
	public ArrayList<ArrayList<Tile>> getGameBoard(){
		return gameBoard;
	}
	

	
	public void update() {
		
//		double worldX = 0;
//		double worldY = 0;
		double screenX = 0;
		double screenY = 0;
		
		// the world location
		int col = 0;
		int row = 0;
		
		while(row < gameBoard.size()) {
			
			// the world position of the tiles
			Tile tile = gameBoard.get(row).get(col);
//			worldX = col * tile.getImage().getWidth();
//			worldY = row * tile.getImage().getHeight();
			screenX = tile.getWorldX() - player.getWorldX() + player.getScreenX();
			screenY = tile.getWorldY() - player.getWorldY() + player.getScreenY();
			
//			System.out.println("worldX" + player.getWorldX());
//			System.out.println("worldY" + player.getWorldY());
//			System.out.println("screenX" + screenX);
//			System.out.println("screenY" + screenY);
//			
			tile.setX(screenX);
			tile.setY(screenY);

			
			col++;
			
			if(col == gameBoard.get(row).size()) {
				col = 0;
				row++;
			}
			tile.update();
		}
	}
	
	// Used to draw the map
//	public void update() {
//		int col = 0;
//		int row = 0;
//		
//		while(row < gameBoard.size()) {
//			gameBoard.get(row).get(col).update();
//			col++;
//			
//			if(col == gameBoard.get(row).size()) {
//				col = 0;
//				row++;
//			}
//		}
//	}
	
	
	// For testing only
	//	private Tile[][] populateGameBoard(){
	//		Tile[][] gameBoard = new Tile[maxRow][maxCol];
	//		
	//		int x = 0;
	//		int y = 0;
	//		
	//		Tile grassTile = null;
	//		
	//		for(int row = 0; row < maxRow; row++) {
	//			for(int col = 0; col < maxCol; col++) {
	//				grassTile = new TreeTile(gc, x, y);
	//				x += grassTile.getImage().getWidth();
	//				gameBoard[row][col] = grassTile;
	//			}
	//			y += grassTile.getImage().getHeight();
	//			x = 0;
	//		}
	//		
	//		
	//		return gameBoard;
	//	}
	
}
