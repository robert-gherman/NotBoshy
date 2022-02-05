package objects;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

import Window.Game;
import framework.GameObject;
import framework.ObjectId;
import framework.Texture;
import java.awt.Color;


public class Block extends GameObject {
	
	Texture tex = Game.getInstance();
	
	
	private int type;
	
	public Block(float x, float y, int type, ObjectId id) {
		super(x, y, id);
		// TODO Auto-generated constructor stub
		this.type = type;
	}


	public void tick(LinkedList<GameObject> object) {
		// TODO Auto-generated method stub
		
	}


	public void render(Graphics g) {
//		g.setColor(Color.white);
//		g.fillRect((int)x,(int)y, 32,32);
		//g.drawRect((int)x,(int)y, 32 , 32);
		
		// dirt block == 0
		if(type == 0) {
			g.drawImage(tex.block[0], (int)x, (int)y, null);
			
		}
		// grass block == 1
		if(type == 1) {
			g.drawImage(tex.block[1], (int)x, (int)y, null);
			
		}
		
		// invisible block == 2
		if(type == 2) {
			g.setColor(Color.white);
			g.fillRect((int)x,(int)y, 32,32);
			
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
