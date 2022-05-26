package screenClasses;
import javax.swing.JFrame;

import rocket.Rocket;

/**
 * This is an abstract class that is used as a template for something all screens have
 * @author Ryan Wagner, Rohan Gupta, Krish Jhurani
 */
public abstract class Screen {

	/**
	 * Is the width and height of the screen
	 */
	public final int DRAWING_WIDTH, DRAWING_HEIGHT;
//	public Rocket rocket;
	
	/**
	 * Sets the specified width and height of the screen
	 * @param width Width of the screen
	 * @param height Height of the screen
	 */
	public Screen(int width, int height) {
		this.DRAWING_WIDTH = width;
		this.DRAWING_HEIGHT = height;
	}
	
	/**
	 * Setup of the screen
	 */
	public void setup() {
		
	}
	
	/**
	 * Draws things to the DrawingSurface
	 */
	public void draw() {
		
	}
	
	/**
	 * Performs an action when the mouse is pressed
	 */
	public void mousePressed() {
		
	}
	
	/**
	 * Performs an action when the mouse is moved
	 */
	public void mouseMoved() {
		
	}
	
	/**
	 * Performs an action when the mouse is dragged
	 */
	public void mouseDragged() {
		
	}
	
	/**
	 * Performs an action when the mouse is released
	 */
	public void mouseReleased() {
		
	}
	
	/**
	 * Performs an action when the key is pressed
	 */
	public void keyPressed() {
		
	}
	
	/**
	 * Performs an action when the key is released
	 */
	public void keyReleased() {
		
	}
	
	
}
