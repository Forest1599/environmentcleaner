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
	
	// Collision Area offset for more accurate collision
	private final int collisionAreaXOffset = 4, collisionAreaYOffset = 12;
	
	// Speed
	private double dx=5;
	private double dy=5;
	
	
	public Player(GraphicsContext gc, Scene scene, int tileSize) {
		
		super(gc, tileSize * 5, tileSize * 5);
				
		screenX = scene.getWidth() / 2;
		screenY = scene.getHeight() / 2;
		
		super.setImage(new Image(Player.class.getResource("player.png").toExternalForm()));
		
		collisionArea = new Rectangle(worldX + collisionAreaXOffset,
				worldY + collisionAreaYOffset, 15, 12);
		
	}
	

	public void handleMovement(KeyEvent event, ArrayList<ArrayList<Tile>> gameBoard, int tileSize) {
		
		// Collision points
		int leftCollisionXCol = (int) (this.collisionArea.getX() / tileSize);
		int rightCollisionXCol = (int) ((this.collisionArea.getX() + this.collisionArea.getWidth()) / tileSize);
		int topCollisionYRow = (int) (this.collisionArea.getY() / tileSize);
		int bottomCollisionYRow = (int) ((this.collisionArea.getY() + this.collisionArea.getHeight()) / tileSize);

		Tile tile1, tile2;
		
		if(event.getCode()==KeyCode.D) {
			rightCollisionXCol = (int) (this.collisionArea.getX() + this.collisionArea.getWidth() + dx) / tileSize;
			tile1 = gameBoard.get(topCollisionYRow).get(rightCollisionXCol);
			tile2 = gameBoard.get(bottomCollisionYRow).get(rightCollisionXCol);
			
			if(tile1.isWalkable() && tile2.isWalkable()) {
				this.moveRight();
			}
			
		}else if(event.getCode()==KeyCode.A) {
			leftCollisionXCol = (int) (this.collisionArea.getX() - dx) / tileSize;
			tile1 = gameBoard.get(topCollisionYRow).get(leftCollisionXCol);
			tile2 = gameBoard.get(bottomCollisionYRow).get(leftCollisionXCol);
			
			if(tile1.isWalkable() && tile2.isWalkable()) {
				this.moveLeft();
			}
			
		}else if(event.getCode()==KeyCode.S) {
			bottomCollisionYRow = (int) (this.collisionArea.getY() + this.collisionArea.getHeight() + dy) / tileSize;
			tile1 = gameBoard.get(bottomCollisionYRow).get(rightCollisionXCol);
			tile2 = gameBoard.get(bottomCollisionYRow).get(leftCollisionXCol);
			
			if(tile1.isWalkable() && tile2.isWalkable()) {
				this.moveDown();
			}
			
			
		}else if(event.getCode()==KeyCode.W) {
			
			topCollisionYRow = (int) (this.collisionArea.getY() - dy) / tileSize;
			tile1 = gameBoard.get(topCollisionYRow).get(rightCollisionXCol);
			tile2 = gameBoard.get(topCollisionYRow).get(leftCollisionXCol);
			
			if(tile1.isWalkable() && tile2.isWalkable()) {
				this.moveUp();
			}
		}
	}
	
	public Rectangle getColissionArea() {
		return super.collisionArea;
	}
	
	public void moveRight(){
		worldX+=dx;
		collisionArea.setX(worldX + collisionAreaXOffset);
	}
	
	public void moveLeft() {
		worldX -= dx;
		collisionArea.setX(worldX + collisionAreaXOffset);
	}
	
	public void moveUp() {
		worldY -= dy;
		collisionArea.setY(worldY + collisionAreaYOffset);
	}
	
	public void moveDown() {
		worldY += dy;
		collisionArea.setY(worldY + collisionAreaYOffset);
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
