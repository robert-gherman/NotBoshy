package Window;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
public class Window{

	
	public  Window(int w, int h, String title, Game game) {
		game.setPreferredSize(new Dimension(w,h));
		game.setMaximumSize(new Dimension(w,h));
		game.setMinimumSize(new Dimension(w,h));
		
		JFrame frame = new JFrame(title);
		frame.add(game);
		// Size the frame
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		game.start();
	}
	
}