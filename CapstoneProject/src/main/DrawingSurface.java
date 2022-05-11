package main;

import java.awt.Point;
import java.util.ArrayList;

import buildClasses.Build1;
import buildClasses.Build2;
import processing.core.PApplet;
import screenClasses.Screen;
import screenClasses.ScreenSwitcher;
import screenClasses.Sidebar;
import screenClasses.Launch1;
import screenClasses.Launch2;

/**
 * 
 * This class holds and keeps track of screens that can be changed and drawn on
 *
 */
public class DrawingSurface extends PApplet implements ScreenSwitcher {

	public float ratioX, ratioY;
	
	private ArrayList<Integer> keys;
	private Sidebar sidebar;
	private Screen activeScreen;
	private ArrayList<Screen> screens;

	
	public DrawingSurface() {
		
		
		screens = new ArrayList<Screen>();
		
		keys = new ArrayList<Integer>();
		
		LevelSelect levels = new LevelSelect(800, 600, this);
		screens.add(levels);
		
		Build1 buildScreen1 = new Build1(this);
		screens.add(buildScreen1);
		
		Build2 buildScreen2 = new Build2(this);
		screens.add(buildScreen2);
		
		Launch1 launchScreen1 = new Launch1(this);
		screens.add(launchScreen1);
		
		Launch2 launchScreen2 = new Launch2(this);
		screens.add(launchScreen2);
		
		activeScreen = screens.get(0);
	}
	
	public void setup() {
		
		for (Screen s : screens)
			s.setup();
	}
	
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
	
	public void keyPressed() {
		keys.add(keyCode);
		if (key == ESC) {
			key = 0;
		} // This prevents a processing program from closing on escape key
		
	}

	public void keyReleased() {
		while(keys.contains(keyCode))
			keys.remove(new Integer(keyCode));
	}

	public boolean isPressed(Integer code) {
		return keys.contains(code);
	}
	
	public void mousePressed() {
		activeScreen.mousePressed();
		//changeVisibility();
	}
	
	public void mouseMoved() {
		activeScreen.mouseMoved();
	}
	
	public void mouseDragged() {
		activeScreen.mouseDragged();
	}
	
	public void mouseReleased() {
		activeScreen.mouseReleased();
	}
	
	public Point assumedCoordinatesToActual(Point assumed) {
		return new Point((int)(assumed.getX()*ratioX), (int)(assumed.getY()*ratioY));
	}

	public Point actualCoordinatesToAssumed(Point actual) {
		return new Point((int)(actual.getX()/ratioX) , (int)(actual.getY()/ratioY));
	}
	
	public Screen getActiveScreen() {
		return activeScreen;
	}
	
	public ArrayList<Screen> getScreens(){
		return screens;
	}

	@Override
	public void switchScreen(int i) {
		activeScreen = screens.get(i);
	}

}