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
	
	Texture tex = Game.getInstance();
	
	public Enemy(float x, float y,Handler handler, ObjectId id) {
		super(x, y, id);
		// TODO Auto-generated constructor stub
		this.handler = handler;
		
	}

	
	public void tick(LinkedList<GameObject> object) { 
		// TODO Auto-generated method stub

//		if(velX > 0)
//		playerWalk.runAnimation();
//		else
//		playerWalk_Left.runAnimation();
			
			
	}
	
	private void Collision(LinkedList<GameObject> object) {
		
		for(int i=0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
			
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
		g.setColor(Color.blue);
		g.fillRect((int)x,(int)y, 32,32);
		
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
