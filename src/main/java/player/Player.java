package player;

import java.util.ArrayList;

import eriksbenne.environmentcleaner.GameObject;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import tiles.Tile;

public class Player extends GameObject{
	
	// Screen position
	private double screenX, screenY;
	
	// World position
	private double worldX, worldY;
	private final int colissionAreaXOffset = 4, colissionAreaYOffset = 12;
	
	// Speed
	private double dx=5;
	private double dy=5;
	
	
	public Player(GraphicsContext gc, Scene scene, int tileSize) {
		
		super(gc, scene.getWidth() / 2, scene.getHeight() / 2);
		
		screenX = scene.getWidth() / 2;
		screenY = scene.getHeight() / 2; 
		
		worldX = tileSize * 5;
		worldY = tileSize * 5;
				
		super.setImage(new Image(Player.class.getResource("player.png").toExternalForm()));
		
		collisionArea = new Rectangle(worldX + colissionAreaXOffset,
				worldY + colissionAreaYOffset, 15, 12);
		
	}
	

	public void handleMovement(KeyEvent event, ArrayList<ArrayList<Tile>> gameBoard, int tileSize) {
		
		// Collision points
		int leftColissionXCol = (int) (this.collisionArea.getX() / tileSize);
		int rightColissionXCol = (int) ((this.collisionArea.getX() + this.collisionArea.getWidth()) / tileSize);
		int topColissionYRow = (int) (this.collisionArea.getY() / tileSize);
		int bottomColissionYRow = (int) ((this.collisionArea.getY() + this.collisionArea.getHeight()) / tileSize);

		Tile tile1, tile2;
		
		if(event.getCode()==KeyCode.D) {
			rightColissionXCol = (int) (this.collisionArea.getX() + this.collisionArea.getWidth() + dx) / tileSize;
			tile1 = gameBoard.get(topColissionYRow).get(rightColissionXCol);
			tile2 = gameBoard.get(bottomColissionYRow).get(rightColissionXCol);
			
			if(tile1.isWalkable() && tile2.isWalkable()) {
				this.moveRight();
			}
			
		}else if(event.getCode()==KeyCode.A) {
			leftColissionXCol = (int) (this.collisionArea.getX() - dx) / tileSize;
			tile1 = gameBoard.get(topColissionYRow).get(leftColissionXCol);
			tile2 = gameBoard.get(bottomColissionYRow).get(leftColissionXCol);
			
			if(tile1.isWalkable() && tile2.isWalkable()) {
				this.moveLeft();
			}
			
		}else if(event.getCode()==KeyCode.S) {
			bottomColissionYRow = (int) (this.collisionArea.getY() + this.collisionArea.getHeight() + dy) / tileSize;
			tile1 = gameBoard.get(bottomColissionYRow).get(rightColissionXCol);
			tile2 = gameBoard.get(bottomColissionYRow).get(leftColissionXCol);
			
			if(tile1.isWalkable() && tile2.isWalkable()) {
				this.moveDown();
			}
			
			
		}else if(event.getCode()==KeyCode.W) {
			
			topColissionYRow = (int) (this.collisionArea.getY() - dy) / tileSize;
			tile1 = gameBoard.get(topColissionYRow).get(rightColissionXCol);
			tile2 = gameBoard.get(topColissionYRow).get(leftColissionXCol);
			
			if(tile1.isWalkable() && tile2.isWalkable()) {
				this.moveUp();
			}
			
			
		}
	}
	
//	public Rectangle getColissionArea() {
//		return super.collisionArea;
//	}
	
	public void moveRight(){
		worldX+=dx;
		collisionArea.setX(worldX + colissionAreaXOffset);
	}
	
	public void moveLeft() {
		worldX -= dx;
		collisionArea.setX(worldX + colissionAreaXOffset);
	}
	
	public void moveUp() {
		worldY -= dy;
		collisionArea.setY(worldY + colissionAreaYOffset);
	}
	
	public void moveDown() {
		worldY += dy;
		collisionArea.setY(worldY + colissionAreaYOffset);
	}
	
	public double getWorldX() {
		return worldX;
	}
	
	public double getWorldY() {
		return worldY;
	}
	
	public double getScreenX() {
		return screenX;
	}
	
	public double getScreenY() {
		return screenY;
	}
	
	

}
