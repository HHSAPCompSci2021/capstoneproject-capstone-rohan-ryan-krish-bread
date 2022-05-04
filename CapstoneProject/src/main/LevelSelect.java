package main;

import java.awt.Point;
import java.awt.Rectangle;

import screenClasses.Screen;
import screenClasses.ScreenSwitcher;

public class LevelSelect extends Screen{

	private DrawingSurface surface;
	private Rectangle button;
	
	public LevelSelect(int width, int height, DrawingSurface surface) {
		super(width, height);
		this.surface = surface;
		
		button = new Rectangle(800/2-100,600/2-50,200,100);
	}
	
	public void draw() {
		
		surface.background(255, 0,255);
		surface.rect(button.x, button.y, button.width, button.height, 10, 10, 10, 10);
		String str = "Click me!";
		float w = surface.textWidth(str);
		surface.text(str, button.x+button.width/2-w/2, button.y+button.height/2);
	
		
	}
	
	public void mousePressed() {
		Point p = surface.actualCoordinatesToAssumed(new Point(surface.mouseX,surface.mouseY));
		if (button.contains(p)) 
			surface.switchScreen(ScreenSwitcher.BUILD_1);
	}

}
