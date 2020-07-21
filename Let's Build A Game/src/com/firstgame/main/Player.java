package com.firstgame.main;

import java.awt.Color;
import java.awt.Graphics;

public class Player extends GameObject {

	public Player(int x, int y, ID id) {
		super(x, y, id);
		
		//velX = 1;
		//velY = 1;
	}

	public void tick() {
		x += velX; //this would just make our x do the velocity every tick
		y += velY;

	}

	public void render(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(x, y, 32, 32);

	}

}
