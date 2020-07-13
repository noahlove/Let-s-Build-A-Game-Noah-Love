package com.firstgame.main;

import java.awt.Graphics;
import java.util.LinkedList;

//this class will update and render all of our objects

public class Handler {
	
	//create a list of all the objects in the game
	LinkedList<GameObject> object = new LinkedList<GameObject>();
	
	//reiterates for as many objects as we have in the game
	public void tick() {
		for(int i = 0; i< object.size(); i++) {
			//for each object
			GameObject tempObject = object.get(i);
			//gets id of which object we are at. It gets the ith object.
			
			tempObject.tick();
		}
	}
	
	public void render(Graphics g) {
		for(int i = 0; i< object.size(); i++){
			GameObject tempObject = object.get(i);
			//render all the game objects
			tempObject.render(g);
			
			
		}
		
	}
	
	//function to add and remove game objects from the list

	public void addObject(GameObject object) {
		this.object.add(object);
	}
	public void removeObject(GameObject object) {
		this.object.remove(object);
	}
}
