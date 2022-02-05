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


public class SpikesTop extends GameObject {
	
	Texture tex = Game.getInstance();
	
	 
     Timer timer;
	
    boolean movingUp = true;
	private int type;
	
	public SpikesTop(float x, float y, int type, ObjectId id) {
		super(x, y, id);
		this.type = type;
	}

	
	public void tick(LinkedList<GameObject> object) {
		// TODO Auto-generated method stub
		y = y + 1;
		if (y == 169 && type == 1)
			y = -200;
		else if(y==169 && type == 2){
			y= - 70 ;
		}
		
		System.out.println(y);
	}

	
	public void render(Graphics g) {
		
		
		if(type == 1) {
//			g.setColor(Color.red);
//        g.fillRect((int)x,(int)y,32,200);
        g.drawImage(tex.spike[0], (int)x, (int)(y), 32, 32, null);
        if( y > -5 )
        	 g.drawImage(tex.spike[2], (int)x, (int)(y+ 32), 32, 32, null);
        
		}
        
        else if(type == 2) {
        	g.drawImage(tex.spike[2], (int)x, (int)y, 32, 32, null);
			if(y > -5 ) {
				g.drawImage(tex.spike[0], (int)x, (int)(y-32), 32, 32, null);
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
