package Window;

import framework.GameObject;

public class Camera {
	
	private float x,y;

	public Camera(float x, float y) {
		super();
		this.x = x;
		this.y = y;
	}

	public void tick(GameObject player) {
		// map 1
		if(-(player.getX()) < -Game.WIDTH)
		x = -Game.WIDTH;
		else
			if(-(player.getX()) > -Game.WIDTH)
			x=0;
		//System.out.println(x);
	}
	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}
	
}
