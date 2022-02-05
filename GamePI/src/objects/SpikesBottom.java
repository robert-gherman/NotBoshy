package objects;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;
import java.util.Timer;

import Window.Game;
import framework.GameObject;
import framework.ObjectId;
import framework.Texture;
import java.awt.Color;


public class SpikesBottom extends GameObject {
	
	Texture tex = Game.getInstance();
	
	 
     Timer timer;
	
    boolean movingUp = true;
	private int type;
	
	public SpikesBottom(float x, float y, int type, ObjectId id) {
		super(x, y, id);
		this.type = type;
	}

	
	public void tick(LinkedList<GameObject> object) {
		// TODO Auto-generated method stub
//		if(movingUp)
//		{
//		   y-=1;
//		}
//		else
//		{
//		   y+=1;
//		}
//
//		if (y == 500) // turn around and go the other way
//		{
//		    movingUp = false;
//		}
//		else if (y == 200) // turn around and go the other way
//		{
//		    movingUp = true;
//		}
		y = y - 1;
		if (y == 470)
			y = 640;
		
		
	}

	
	public void render(Graphics g) {
		
		
		if(type == 1) {
//			g.setColor(Color.red);
//        g.fillRect((int)x,(int)y,32,200);
        g.drawImage(tex.spike[0], (int)x, (int)y, 32, 32, null);
        
        
        
		}
        
        else if(type == 2) {
        	g.drawImage(tex.spike[1], (int)x, (int)y, 32, 32, null);
			if(y <= 635) {
//				g.setColor(Color.red);
//		        g.fillRect((int)x,(int)(y+30),32,200);
				g.drawImage(tex.spike[0], (int)x, (int)(y+30), 32, 32, null);
			}
        }
		
     
		
	}

	public Rectangle getBounds() {
		return new Rectangle((int)x, (int) y,32,32);
	}


	public int getType() {
		return type;
	}


	public void setType(int type) {
		this.type = type;
	}
	

}
