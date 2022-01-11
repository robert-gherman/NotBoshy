package objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

import Window.Animation;
import Window.Game;
import Window.Handler;
import framework.GameObject;
import framework.Keyboard;
import framework.ObjectId;
import framework.Texture;

public class Player extends GameObject {
	public int width = 32, height = 64;
	private float gravity = 0.5f;
	private final float MAX_SPEED = 10;
	private Handler handler;
	Graphics g;
	Texture tex = Game.getInstance();
	
	private Animation playerWalk;
	private Animation playerWalk_Left;
	public Player(float x, float y,Handler handler, ObjectId id) {
		super(x, y, id);
		// TODO Auto-generated constructor stub
		this.handler = handler;
		this.playerWalk = new Animation(4, tex.player[1],tex.player[2],tex.player[3],tex.player[4],tex.player[5],
				tex.player[6],tex.player[7],tex.player[8],tex.player[9],tex.player[10] );
		this.playerWalk_Left = new Animation(4 ,tex.player_reverse[1],tex.player_reverse[2],tex.player_reverse[3],tex.player_reverse[4],tex.player_reverse[5],
				tex.player_reverse[6],tex.player_reverse[7],tex.player_reverse[8],tex.player_reverse[9],tex.player_reverse[10] );
	}

	
	public void tick(LinkedList<GameObject> object) { 
		// TODO Auto-generated method stub
		x += velX;
		y += velY;
		
		if(falling || jumping) {
			velY += gravity;
			
			if(velY > MAX_SPEED)
				velY = MAX_SPEED;
		}
		Collision(object);
		//System.out.println(x);
		if(Keyboard.movingRight == true) {
			
			x += 1;
		}
		else if(Keyboard.movingLeft == true) {
			x -= 1;
		}
		if(velX > 0)
		playerWalk.runAnimation();
		else
		playerWalk_Left.runAnimation();
			
			
	}
	
	private void Collision(LinkedList<GameObject> object) {
		
		for(int i=0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getId() == ObjectId.Enemy) {
				// width = 32, height = 64 
			
				if(getBoundsTop().intersects(tempObject.getBounds())) {
					 
				        g.setColor(Color.WHITE);
				        g.drawString("Game Over!", 90, 70); 
					
				}
				if(getBounds().intersects(tempObject.getBounds())) {
					
				        g.setColor(Color.WHITE);
				        g.drawString("Game Over!", 90 , 70 ); 
				}
				
				if(getBoundsRight().intersects(tempObject.getBounds())) {
					
				        g.setColor(Color.WHITE);
				        g.drawString("Game Over!", 90, 70); 
				}
					
					
					
				if(getBoundsLeft().intersects(tempObject.getBounds())) {
					 
				        g.setColor(Color.WHITE);
				        g.drawString("Game Over!", 90 , 70 ); 
				}
					
					
					
			}
			
			if(tempObject.getId() == ObjectId.Block) {
				// width = 32, height = 64 
			
				if(getBoundsTop().intersects(tempObject.getBounds())) {
					y = tempObject.getY() + (float)((height/2));
					velY=0;
					
				}
				if(getBounds().intersects(tempObject.getBounds())) {
					y = tempObject.getY() - height;
					velY=0;
					falling = false;
					jumping = false;
				}
				else 
					falling = true;
				
				if(getBoundsRight().intersects(tempObject.getBounds())) 
					x = tempObject.getX() - tempObject.getBounds().width;
					
					
				if(getBoundsLeft().intersects(tempObject.getBounds())) 
					x = tempObject.getX() + tempObject.getBounds().width;
					
					
			}
		
	}
}
	
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		
		// !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		// ultima pozitie dupa mers left ii spre dreapta
		if(velX > 0) 
			playerWalk.drawAnimation(g, (int)x, (int)y, 32, 64);
		else if(velX < 0)
			playerWalk_Left.drawAnimation(g, (int)x, (int)y, 32, 64);
		else
			g.drawImage(tex.player[0], (int)x, (int)y, 32, 64, null);
		
		
	}


	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return new Rectangle((int)((int)x + (width/2)-((width/2/2))), (int)((int) y+ (height/2)),(int)width/2,(int)height/2);
	}
	
	public Rectangle getBoundsRight() {
		// TODO Auto-generated method stub
		return new Rectangle((int)((int)x+width - 5), (int) y+5,(int)5,(int)height-10);
	}
	
	public Rectangle getBoundsLeft() {
		// TODO Auto-generated method stub
		return new Rectangle((int)x, (int) y+5,(int)5,(int)height-10);
	}
	
	public Rectangle getBoundsTop() {
		// TODO Auto-generated method stub
		return new Rectangle((int)((int)x + (width/2)-((width/2/2))), (int) y,(int)width/2,(int)height/2);
	}

}
