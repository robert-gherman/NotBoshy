package framework;


import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
// FFS
public class GameOver  extends JPanel {
	public GameOver(){
		this.setSize(100,100);
	}
	public void paint(Graphics g){
		Graphics2D g2 = (Graphics2D) g;
		    g2.drawString("GAME OVER!", 100, 100);
	}
}
