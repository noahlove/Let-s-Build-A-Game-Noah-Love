package com.firstgame.main;

import java.awt.Canvas;

public class Game extends Canvas implements Runnable{
	

	private static final long serialVersionUID = -6494256809522819072L;

	public static final int WIDTH = 1920, HEIGHT = 1200;
	
	public Game() {
		new Window(WIDTH, HEIGHT, "Let's build a Game!", this);
	}
	
	public synchronized void start() {
				
	}

	public void run() {
		
					
	}
	
	public static void main(String args[]) {
		new Game();
	}
	
}
