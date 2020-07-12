package com.firstgame.main;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

//this is the class that creates the window that the game runs in.

public class Window extends Canvas{

	/**
	 * Teh purpose of this class is just to create the window. So we will need a width, height and title.
	 */
	private static final long serialVersionUID = -1366450581141666846L;
	
	public Window(int width, int height, String title, Game game){
		JFrame frame = new JFrame(title);  //created a JFrame, the window of our game.  Frame.something means referring back to the jframe. 
		
		//create the dimensions of the window		
		
		frame.setPreferredSize(new Dimension(width, height));
		frame.setMaximumSize(new Dimension(width, height));	
		frame.setMinimumSize(new Dimension(width, height));
		
		//functions of the window
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //allows the window to actual stop the thread
		frame.setResizable(false); //window cannot be resized
		frame.setLocationRelativeTo(null); //not needed but now the window starts in the window
		frame.add(game); //this actually puts the game in the window
		frame.setVisible(true); //makes you be able to see it
		game.start(); // something from the game class that we are creating. We are now running the start method.
	}
	
}
