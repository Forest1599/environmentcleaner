package trash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import javafx.scene.canvas.GraphicsContext;
import player.Player;
import tiles.Tile;

public class TrashGenerator {
	private GraphicsContext gc;
	private ArrayList<Trash> trashList;
	private Player player;
	
	public TrashGenerator(GraphicsContext gc, Player player) {
		this.gc = gc;
//		trashList = populateTrash(); 
		this.player = player;
	}
	
	private BufferedReader getFileBufferedReader() {
		
		BufferedReader bufferedReader = null;
		
		InputStream inputStream = getClass().getResourceAsStream("/Trash/trashLocations");
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
	
	
	public ArrayList<Trash> populateTrash(){
		ArrayList<Trash> trashList = new ArrayList<Trash>();
		TrashFactory trashFactory = new TrashFactory(gc);
//		BufferedReader bufferedReader = getFileBufferedReader();
//		
//		String line = readLine(bufferedReader);
//		
//		while(line != null) {
//			String[] trashLocation = line.split(" "); // Splits the row into tile types
//			
//			for(String t : trashLocation) {
//				System.out.println(t);
//			}
//			
//			
//			line = readLine(bufferedReader);
////			trashList.add(trashFactory.createProduct(, 0, 0))
//		}
		
		
		
		
		return trashList;
		
		
	}
	
}
