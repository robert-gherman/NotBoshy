package framework;

import java.awt.image.BufferedImage;

import Window.BufferedImageLoader;

public class Texture {
	
	SpriteSheet bs, ps, ps2;
	private BufferedImage block_sheet = null;
	private BufferedImage player_sheet = null;
	private BufferedImage player_sheet2 = null;
	
	public BufferedImage[] block = new BufferedImage[2];
	public BufferedImage[] player = new BufferedImage[11];
	public BufferedImage[] player_reverse = new BufferedImage[11];
	
	
	public Texture() {
		
		BufferedImageLoader loader = new BufferedImageLoader();
		try {
			block_sheet = loader.loadImage("block_sheet.png");
			player_sheet = loader.loadImage("player_sheet.png");
			player_sheet2 = loader.loadImage("player_sheet_flipped.png");
			
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Image not found");
		}
		
		bs = new SpriteSheet(block_sheet);
		ps = new SpriteSheet(player_sheet);
		ps2 = new SpriteSheet(player_sheet2);
		getTexture();
		
	}
	public void getTexture() {
		block[0] = bs.grabImage(1, 1, 32, 32);
		block[1] = bs.grabImage(2, 1, 32, 32);
		
		player[0] = ps.grabImage(1, 1, 24, 24);// idle player
		player[1] = ps.grabImage(2, 1, 24, 24);
		player[2] = ps.grabImage(3, 1, 24, 24);
		player[3] = ps.grabImage(4, 1, 24, 24);
		player[4] = ps.grabImage(5, 1, 24, 24);
		player[5] = ps.grabImage(6, 1, 24, 24);
		player[6] = ps.grabImage(7, 1, 24, 24);
		player[7] = ps.grabImage(8, 1, 24, 24);
		player[8] = ps.grabImage(9, 1, 24, 24);
		player[9] = ps.grabImage(10, 1, 24, 24);
		player[10] = ps.grabImage(11, 1, 24, 24);
		
		player_reverse[0] = ps2.grabImage(24, 1, 24, 24);// idle player
		player_reverse[1] = ps2.grabImage(23, 1, 24, 24);
		player_reverse[2] = ps2.grabImage(22, 1, 24, 24);
		player_reverse[3] = ps2.grabImage(21, 1, 24, 24);
		player_reverse[4] = ps2.grabImage(20, 1, 24, 24);
		player_reverse[5] = ps2.grabImage(19, 1, 24, 24);
		player_reverse[6] = ps2.grabImage(18, 1, 24, 24);
		player_reverse[7] = ps2.grabImage(17, 1, 24, 24);
		player_reverse[8] = ps2.grabImage(16, 1, 24, 24);
		player_reverse[9] = ps2.grabImage(15, 1, 24, 24);
		player_reverse[10] = ps2.grabImage(14, 1, 24, 24);
		
		
	}
}
