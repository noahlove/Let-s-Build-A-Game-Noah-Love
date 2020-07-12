package com.firstgame.main;

import java.awt.Canvas;

//this class is the main class that runs the game

public class Game extends Canvas implements Runnable{
	

	private static final long serialVersionUID = -6494256809522819072L;

	public static final int WIDTH = 1920, HEIGHT = 1200;
	private boolean running = false; //defaults to not running
	private Thread thread;  //create a thread to use
	
	
	public Game() {
		new Window(WIDTH, HEIGHT, "Let's build a Game!", this);
	}
	
	public synchronized void start() {
		thread = new Thread(this); //this is a new instance of the thread
		thread.start(); //start the thread
	}
	
	public synchronized void stop() {
		try {
			thread.join();
			running = false;
		}catch(Exception e) {
			e.printStackTrace(); //if it doesn't work, it will help us figure out why.
		}
	}

	public void run() {
		
					
	}
	
	public static void main(String args[]) {
		new Game();
	}
	
}
