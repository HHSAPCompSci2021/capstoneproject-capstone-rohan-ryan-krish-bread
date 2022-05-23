package main;

import java.awt.Point;
import java.util.ArrayList;

import buildClasses.Build1;
import buildClasses.Build2;
import buildClasses.Build3;
import buildClasses.Build4;
import processing.core.PApplet;
import screenClasses.Screen;
import screenClasses.ScreenSwitcher;
import screenClasses.Sidebar;
import screenClasses.Instructions;
import screenClasses.Launch1;
import screenClasses.Launch2;

/**
 * This class holds and keeps track of screens that can be changed and drawn on
 * @author Ryan Wagner, Krish Jhurani, Rohan Gupta
 */
public class DrawingSurface extends PApplet implements ScreenSwitcher {

	public float ratioX, ratioY;
	
	private ArrayList<Integer> keys;
	private Sidebar sidebar;
	private Screen activeScreen;
	private Build1 buildScreen1;
	private ArrayList<Screen> screens;

	/**
	 * Gives all of the variable values, and makes screens
	 */
	public DrawingSurface() {
		
		
		screens = new ArrayList<Screen>();
		
		keys = new ArrayList<Integer>();
		
		LevelSelect levels = new LevelSelect(800, 600, this);
		screens.add(levels);
		
		buildScreen1 = new Build1(this);
		screens.add(buildScreen1);
		
		Build2 buildScreen2 = new Build2(this);
		screens.add(buildScreen2);
		Build3 buildScreen3 = new Build3(this);
		screens.add(buildScreen3);
		Build4 buildScreen4 = new Build4(this);
		screens.add(buildScreen4);
		
		Launch1 launchScreen1 = new Launch1(this);
		screens.add(launchScreen1);
		
		Launch2 launchScreen2 = new Launch2(this);
		screens.add(launchScreen2);
		
		Instructions instructions = new Instructions(800, 600, this);
		screens.add(instructions);
		
		activeScreen = screens.get(0);
	}
	
	/**
	 * sets up all of the screens
	 */
	public void setup() {
		
		for (Screen s : screens)
			s.setup();
	}
	
	/**
	 * Draws the screen currently being used and the things on it
	 * Scales the current screen to the correct size
	 * @post DrawingSurface will be changed and will have things drawn on it
	 */
	public void draw() {
		ratioX = (float)width/activeScreen.DRAWING_WIDTH;
		ratioY = (float)height/activeScreen.DRAWING_HEIGHT;

		push();
		
		scale(ratioX, ratioY);
		
		activeScreen.draw();
//		Sidebar sidebar = new Sidebar();
//		sidebar.draw(this);
		pop();
	}
	
	/**
	 * Detects when a key is pressed, and uses the appropriate method for the current screen
	 */
	public void keyPressed() {
		keys.add(keyCode);
		if (key == ESC) {
			key = 0;
		} // This prevents a processing program from closing on escape key
		activeScreen.keyPressed();
	}

	/**
	 * Detects when a key is released, and uses the appropriate method for the current screen
	 */
	public void keyReleased() {
//		while(keys.contains(keyCode))
//			keys.remove(new Integer(keyCode));
		activeScreen.keyReleased();
	}
	
	/**
	 * Detects when the mouse is pressed, and uses the appropriate method for the current screen
	 */
	public void mousePressed() {
		activeScreen.mousePressed();
	}
	
	/**
	 * Detects when the mouse is moved, and uses the appropriate method for the current screen
	 */
	public void mouseMoved() {
		activeScreen.mouseMoved();
	}
	
	
	/**
	 * Detects when the mouse is dragged, and uses the appropriate method for the current screen
	 */
	public void mouseDragged() {
		activeScreen.mouseDragged();
	}
	
	/**
	 * Detects when the mouse is released, and uses the appropriate method for the current screen
	 */
	public void mouseReleased() {
		activeScreen.mouseReleased();
	}
	
	/**
	 * Converts the assumed coordinates to the actual coordinates
	 * @param assumed Point that contains the assumed coordinates 
	 * @return Returns a Point that contains the Actual coordinates
	 */
	public Point assumedCoordinatesToActual(Point assumed) {
		return new Point((int)(assumed.getX()*ratioX), (int)(assumed.getY()*ratioY));
	}

	/**
	 * Converts the actual coordinates to the assumed coordinates
	 * @param actual Point that contains the actual coordinates 
	 * @return Returns a Point that contains the assumed coordinates
	 */
	public Point actualCoordinatesToAssumed(Point actual) {
		return new Point((int)(actual.getX()/ratioX) , (int)(actual.getY()/ratioY));
	}
	
	/**
	 * Gets the current screen being displayed
	 * @return The Screen being displayed
	 */
	public Screen getActiveScreen() {
		return activeScreen;
	}
	
	/**
	 * Gets the level one build
	 * @return The build for level one
	 */
	public Build1 getBuild1() {
		return buildScreen1;
	}
	
	/**
	 * Gets all of the screen that can be displayed on the DrawingSurface
	 * @return The ArrayList of Screens
	 */
	public ArrayList<Screen> getScreens(){
		return screens;
	}

	/**
	 * Changed the screen that is currently being displayed
	 * @param i Int of the screen to be displayed 
	 */
	public void switchScreen(int i) {
		activeScreen = screens.get(i);
	}

}