package framework;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import Window.Handler;

public class Keyboard extends KeyAdapter{
	public static boolean movingRight = false;
	public static boolean movingLeft = false;
	public int contor = 0;
	public int contor2 = 0;
	
	Handler handler;
	public Keyboard(Handler handler) {
		this.handler = handler;
	}
	
	public void keyPressed(KeyEvent e) {
	
		int key = e.getKeyCode();
		
		for(int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
			
			
			if(key == KeyEvent.VK_ENTER && tempObject.getId() == ObjectId.Player) {
					tempObject.setisGameOver(false);
					// start
					tempObject.setX(47);
					tempObject.setY(540);
					
//					tempObject.setX(380);
//					tempObject.setY(200);
//					tempObject.setX(260);
//					tempObject.setY(120);
					
					//finish
//					tempObject.setX(700);
//					tempObject.setY(20);
					tempObject.setHasIntersectTrap(false);
			}
			// touched the enemy u will not be able to move anymore cuz of if below
			if(tempObject.getisGameOver() == false) {
				
				
				
				if(tempObject.getId() == ObjectId.Player) {
				//  -> z
				if(key == 39) {
					tempObject.setVelX(4);
					movingRight = true;
				}
				// <-
				if(key == 37) {
					tempObject.setVelX(-4);
					movingLeft = true;
				}
				
				if(key == KeyEvent.VK_Z && tempObject.isJumping()==false) {
					// jump forever
					
					//System.out.println("INTRAT: " + contor);
					if( contor < 1)
					tempObject.setVelY(-9);
					else {
						tempObject.setJumping(true);
						contor = 0;
					}
					
					contor++;					
					
					if(tempObject.getVelY() != -9  ) {
						tempObject.setVelY(-9);
						contor = 0;
					}
						
					//System.out.println("IESIRE: " + contor );
					
				}
				
			
			}
			}
			
			
			
	
		}
		
		
		// VK_ESCAPE == ASCII code ESC
		if(key == KeyEvent.VK_ESCAPE) {
			System.exit(1);
		}
	}
	
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		
		for(int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
			
			
			if(tempObject.getId() == ObjectId.Player) {
				// <- -> 
				if(key == 39) {
					tempObject.setVelX(0);
					movingRight = false;
				}
				if(key == 37) {
					tempObject.setVelX(0);
					movingLeft = false;
				}
				
				
				}
				
			}
		
		
		}
	
}
