package Window;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import framework.Keyboard;
import framework.ObjectId;
import framework.Texture;
import objects.Block;
import objects.Enemy;
import objects.Player;
// double jump 
public class Game extends Canvas implements Runnable{

	private static final long serialVersionUID = -8921419424614180143L;
	
	private boolean running = false;
	private Thread thread;
	
	public static int WIDTH,HEIGHT;
	
	public BufferedImage level = null;
	public BufferedImage background = null;
	
	// create multiple objects
	Handler handler;
	Camera cam;
	static Texture tex;
	
	public void init() {
		WIDTH = getWidth();
		HEIGHT = getHeight();
		
		tex = new Texture();
		
		
		handler = new Handler();
		
		handler.addObject(new Enemy(450, 275, handler, ObjectId.Enemy));
		
		cam = new Camera(0, 0);
		
		BufferedImageLoader loader = new BufferedImageLoader();
		level = loader.loadImage("map1.png");
		background = loader.loadImage("background.png");
		
		loadImageLevel(level);
		
		//handler.addObject(new Player(100, 100,handler, ObjectId.Player));
		
		//handler.createLevel();
		
		this.addKeyListener(new Keyboard(handler));
		
	}
	
	
	
	// start thread
	synchronized void start() {
		// fail save method
		if(running)
			return;
		
		running=true;
		thread = new Thread(this);
		thread.start();
		
	}
	
	

	public  void  run() {
		
		init();
		this.requestFocus();
		
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int updates = 0;
		int frames = 0;
		while(running){
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while(delta >= 1){
				tick();
				updates++;
				delta--;
			}
			render();
			frames++;
					
			if(System.currentTimeMillis() - timer > 1000){
				timer += 1000;
				System.out.println("FPS: " + frames + " TICKS: " + updates);
				frames = 0;
				updates = 0;
			}
		}
	}
	// updates every second
	private void tick() {
		handler.tick();
		for(int i = 0; i<handler.object.size(); i++) {
			if(handler.object.get(i).getId() == ObjectId.Player) {
				cam.tick(handler.object.get(i));
			}
		}
		
		
	};
	
	
	// images
	private void render() {
		// control the fps
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null) {
			// 3 pre_loaded images
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		Graphics2D g2d = (Graphics2D) g;
		
		// draw here 
		g.drawImage(background, 0, 0, getWidth(), getHeight(), null);
		//g.fillRect(0, 0, getWidth(), getHeight());
		g2d.translate(cam.getX(), cam.getY());
		handler.render(g);
		g2d.translate(-cam.getX(), -cam.getY());
		g.dispose();
		bs.show();
	};
	
	private void loadImageLevel(BufferedImage image) {
			int w = image.getWidth();
			int h = image.getHeight();
			
			for(int xx = 0; xx < h; xx++) {
				for(int yy = 0; yy < w; yy++) {
					int pixel = image.getRGB(xx, yy);
					Color c = new Color(image.getRGB(xx, yy));
					int red = (pixel >> 16) & 0xff;
					int green = (pixel >> 8) & 0xff;
					int blue = (pixel) & 0xff;
					
					if( red == 0 && green == 255 && blue == 0 )
						handler.addObject(new Block(xx*32, yy*32, 2, ObjectId.Block));
					if(red == 0 && green == 255 && blue == 0)
						handler.addObject(new Block(xx*32, yy*32, 1, ObjectId.Block));
					if(red == 48 && green == 48 && blue == 48)
						handler.addObject(new Block(xx*32, yy*32, 0, ObjectId.Block));
					if(red == 255 && green == 255 && blue == 255)
						handler.addObject(new Block(xx*32, yy*32, 3, ObjectId.Block));
					if( red == 0 && green == 0 && blue == 255 )
						handler.addObject(new Player(xx*32, yy*32,handler, ObjectId.Player));
				}
			}
			
			
	}
	
	public static Texture getInstance() {
		return tex;
	}
	public static void main(String args[]) {
		
		new Window(900, 700, "NotBoshy", new Game());
		
	}

}
