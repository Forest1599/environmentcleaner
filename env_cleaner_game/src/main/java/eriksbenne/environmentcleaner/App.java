package eriksbenne.environmentcleaner;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import player.Player;
import tiles.TileGenerator;
import trash.Trash;
import trash.TrashFactory;
import trash.TrashGenerator;

import java.util.ArrayList;
import java.util.Iterator;
import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;


public class App extends Application {
	
	// Settings
	private final int sceneWidth = 800;
	private final int sceneHeight = 600;
	private final int tileSize = 32;
	
	Pane root;
	Scene scene;
	Canvas canvas;
	GraphicsContext gc;
	Player player;
	ArrayList<Trash> trashList = new ArrayList<Trash>();
	
	int count = 0;
	int score = 0;
	
	TileGenerator tileGenerator;
//	TrashGenerator trashGenerator;
	
    public static void main(String[] args) {
        launch();
    }
    
    AnimationTimer timer = new AnimationTimer() {
    	
    	public void handle(long now) {
    		
    		Iterator<Trash> trashIterator = trashList.iterator();
    		
    		while (trashIterator.hasNext()) {
    			Trash trash = trashIterator.next();
    			if(player.intersects(trash)) {
    				trashIterator.remove();
    				score += 1;
    			}
    		}
    		
    		gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
    		
    		tileGenerator.update();
    		
    		player.update();
    		for(Trash trash : trashList) {
    			trash.update();
    		}
    		
    		String scoreText = "Score: " + score;
    		gc.fillText(scoreText, 360 , 30);
    		gc.strokeText(scoreText, 360 , 30);
    		    		
    }};
    
    EventHandler<KeyEvent> keyboardHandler = new EventHandler<KeyEvent>() {

		@Override
		public void handle(KeyEvent event) {
			// TODO Auto-generated method stub
			player.handleMovement(event, tileGenerator.getGameBoard(), tileSize);
		}
    	
    };
    
    @Override
    public void start(Stage primaryStage){
    	
        primaryStage.setTitle("Environmnet cleaner app");
        
        root = new Pane();
        scene = new Scene( root, 800, 600 );
        canvas = new Canvas( 800, 600);
        gc = canvas.getGraphicsContext2D();
        
        primaryStage.setScene(scene);
        primaryStage.show();
            
        root.getChildren().add(canvas);
        
        player = new Player(gc, scene, tileSize);

        TrashFactory trashFactory = new TrashFactory(gc);
        
        // For creating random generated trash
        int max = 20;
        int min = 400;
        
        for(int i = 0; i < 10; i++) {
        	int num1 = (int)Math.floor(Math.random() * (max - min + 1) + min);
        	int num2 = (int)Math.floor(Math.random() * (max - min + 1) + min);
        	trashList.add(trashFactory.createProduct("glass", num1, num2));
        }
        
        
        tileGenerator = new TileGenerator(gc, player);
        
        TrashGenerator trashGenerator = new TrashGenerator(gc, player);
        trashGenerator.populateTrash();
        
        scene.setOnKeyPressed(keyboardHandler);
        timer.start();
    	
    }


}