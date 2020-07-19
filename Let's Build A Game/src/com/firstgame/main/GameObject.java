package com.firstgame.main;

import java.awt.Graphics;

//abstract class. This is what we refer to as all the objects.
//Let's say we have a player and enemy object. They both will be a game object (this class).
//Even things like coins and stuff will be this. 

public abstract class GameObject {

	protected int x, y; // protected means it can only be accessed by objects that inherit the game
						// object.
	protected ID id;
	protected int velX, velY;

	public GameObject(int x, int y, ID id) {
		/*
		 * Whatever we put in the parameters, these will transfer that to the stuff
		 * here.
		 */
		this.x = x;
		this.y = y;
		this.id = id;
	}

	public abstract void tick();

	public abstract void render(Graphics g);

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void setId(ID id) {
		this.id = id;
	}

	public ID getID() {
		return id;
	}

	public void setVelX(int velX) {
		this.velX = velX;
	}

	public void setVelY(int velY) {
		this.velY = velY;
	}

	public int getVelX() {
		return velX;
	}

	public int getVelY() {
		return velY;
	}
}
