package framework;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;
public abstract class GameObject {
	protected float x,y;
	protected float velX = 0, velY = 0;
	protected ObjectId id;
	protected boolean falling = true;
	protected boolean jumping = false;
	
	protected boolean isGameOver = false;
	
	protected boolean hasIntersectTrap = false;
	

	public boolean isHasIntersectTrap() {
		return hasIntersectTrap;
	}

	public void setHasIntersectTrap(boolean hasIntersectTrap) {
		this.hasIntersectTrap = hasIntersectTrap;
	}

	public GameObject(float x, float y, ObjectId id) {
		super();
		this.x = x;
		this.y = y;
		this.id = id;
		
		
	}
	
	public boolean isFalling() {
		return falling;
	}

	public void setFalling(boolean falling) {
		this.falling = falling;
	}

	public boolean isJumping() {
		return jumping;
	}

	public void setJumping(boolean jumping) {
		this.jumping = jumping;
	}

	public abstract void tick(LinkedList<GameObject> object);
	public abstract void render (Graphics g);
	public abstract Rectangle getBounds();

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

	public float getVelX() {
		return velX;
	}

	public void setVelX(float velX) {
		this.velX = velX;
	}

	public float getVelY() {
		return velY;
	}

	public void setVelY(float velY) {
		this.velY = velY;
	}

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}
	
	public void setisGameOver(boolean isGameOver) {
		this.isGameOver = isGameOver;
	}

	public boolean getisGameOver() {
		return isGameOver;
	}

	

	
	
}
