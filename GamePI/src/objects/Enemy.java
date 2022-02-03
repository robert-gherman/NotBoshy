package objects;

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
import java.awt.Color;

public class Enemy extends GameObject {

	public int width = 32, height = 64;
	private float gravity = 0.5f;
	private final float MAX_SPEED = 10;
	private Handler handler;
	
	private Animation enemyWalk;
	private Animation enemyWalkLeft;
	
	boolean walkLeft = true ,walkRight = false;
	Texture tex = Game.getInstance();
	
	public Enemy(float x, float y,Handler handler, ObjectId id) {
		super(x, y, id);
		// TODO Auto-generated constructor stub
		this.handler = handler;
		
		this.enemyWalk = new Animation(4, tex.enemy[0],tex.enemy[1],tex.enemy[2],tex.enemy[3]);
		this.enemyWalkLeft = new Animation(4, tex.enemy_reverse[0],tex.enemy_reverse[1],tex.enemy_reverse[2],tex.enemy_reverse[3]);
		
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

		// box in the enemy to perma walk
		 if (x > 375 && walkLeft == true){
			 x = x - 1;
			enemyWalkLeft.runAnimation();
			if( x == 375)
				walkLeft = false;
			
			
			
		}
		 else if(walkLeft == false) {
			 x = x + 1;
			 enemyWalk.runAnimation();
			
			 walkRight = true;
			 if( x == 485 )
				 walkLeft = true;
		 }

			
		
		
			
	}

	
	// Colision for player to run into blocks
	private void Collision(LinkedList<GameObject> object) {
		
		for(int i=0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getId() == ObjectId.Block ) {
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
//		g.setColor(Color.blue);
//		g.fillRect((int)x,(int)y, 32,32);


			// box in the enemy to perma walk
			 if (x > 375 && walkLeft == true) {	 				 
				 enemyWalkLeft.drawAnimation(g, (int)x, (int)y, 32, 64);
			 }
			 else if(walkLeft == false)
					enemyWalk.drawAnimation(g, (int)x, (int)y, 32, 64);

		
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
