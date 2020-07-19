package com.firstgame.main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

//this class is the main class that runs the game

public class Game extends Canvas implements Runnable{
	
	private static final long serialVersionUID = -6494256809522819072L;

	public static final int WIDTH = 1920, HEIGHT = 1200;
	
	private Thread thread;  //create a thread to use
	private boolean running = false; //defaults to not running
	
	private Handler handler; //instance of handler
	
	
	public Game() {
		new Window(WIDTH, HEIGHT, "Let's build a Game!", this);
		
		handler = new Handler();
		
		handler.addObject(new Player(100,100, ID.Player));
	}
	
	public synchronized void start() {
		thread = new Thread(this); //this is a new instance of the thread
		thread.start(); //start the thread
		running = true;
	}
	
	public synchronized void stop(){
		try {
			thread.join();
			running = false;
		}catch(Exception e) {
			e.printStackTrace(); //if it doesn't work, it will help us figure out why.
		}
	}

	public void run() {
		//this is the game loop, that allows us to update the game.
		//this code is just made by someone else. Don't totally worry about what it is doing.
		
		/*
		 * "lastTime", "now," and "ns" are used to calculate "delta." amountOfTicks is the amount of tics/second, and ns is the amount of nanoseconds/tick.
		 * When delta is calculated, you have (now-lastTime)/(ns/tick), but now and lastTime  are in nanoseconds, so it has units "tick". 
		 * We then add this to delta, and keep going.
		 * Whenever delta+=1, one tick has passed, and we therefore call the command tick() [[[which is explained in the video]]], 
		 * and reset delta to 0 in the while(delta>=1) loop.
		 * the if(running) loop updates the window (by rendering again), and increases the frames with 1.
		 * the if(System.currentTimeMillis()-timer>1000) loop writes out the FPS once per second by checking if 
		 * the current time is more than 1000 milliseconds (1 second) larger than "timer" was.
		 * IF so, we update "timer" to be 1 second later (timer+=1000;), and print the amount of frames that have passed, 
		 * and set frames to 0. Since this event happens once every second, the value "frames" is the frames per second.
		 * stop() stops the game.
		 */
		
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		while(running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while(delta >= 1){
				tick();
				delta--;
			}
			if(running)
				render();
			frames++;
			
			if(System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				System.out.println("FPS: " + frames);
				frames = 0;
			}
		}
		stop();					
	}
	

	
	private void tick() {
		// TODO Auto-generated method stub
		
		handler.tick();
		
	}
	
	private void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null) {
			this.createBufferStrategy(3); //how many buffers it creates
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		
		g.setColor(Color.black);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		handler.render(g);
		
		g.dispose();
		bs.show();
	}



	public static void main(String args[]) {
		new Game();
	}
	
}
