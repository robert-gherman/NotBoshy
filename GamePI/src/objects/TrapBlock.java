package objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.LinkedList;

import Window.Game;
import framework.GameObject;
import framework.ObjectId;
import framework.Texture;

public class TrapBlock extends GameObject {
	
	Texture tex = Game.getInstance();
	
	
	
	
	public TrapBlock(float x, float y, ObjectId id) {
		super(x, y, id);
		// TODO Auto-generated constructor stub
		
	}


	public void tick(LinkedList<GameObject> object) {
		// TODO Auto-generated method stub
		
	}


	public void render(Graphics g) {
//		g.setColor(Color.white);
//		g.fillRect((int)x,(int)y, 32,32);
		//g.drawRect((int)x,(int)y, 32 , 32);
		
		
	
	
		//g.drawImage(tex.block[1], (int)x, (int)y, null);
		
		

		
	}

	public void paint(Graphics g) {
		g.setColor(Color.red);
		g.fillRect(608 , 224, 32,32);
	}
	public void paint2(Graphics g) {
		g.drawImage(tex.block[1], 608, 224, null);
	}
	
	public Rectangle getBounds() {
		return new Rectangle((int)x, (int) y,32,32);
	}
	

}
