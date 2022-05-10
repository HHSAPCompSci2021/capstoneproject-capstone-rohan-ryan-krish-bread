package ScreenClasses;

import java.awt.Point;
import java.awt.Rectangle;

import main.DrawingSurface;

public class Launch1 extends LaunchScreen{

	private DrawingSurface surface;
	private Rectangle button;
	
	public Launch1(DrawingSurface surface) {
		super(800,600,surface);
		this.surface = surface;
		
		button = new Rectangle(800/2-100,600/2-50,200,100);
	}
	
	public void draw() {
		
		surface.background(100,100,255);
		
		surface.fill(0);
		surface.text("Launch 1", 10, 20);
		surface.fill(255);
		
		surface.rect(button.x, button.y, button.width, button.height, 10, 10, 10, 10);
		surface.fill(0);
		String str = "Back To Level Select";
		float w = surface.textWidth(str);
		surface.text(str, button.x+button.width/2-w/2, button.y+button.height/2);
		surface.fill(255);
		
	}
	
	public void mousePressed() {
		Point p = surface.actualCoordinatesToAssumed(new Point(surface.mouseX,surface.mouseY));
		if (button.contains(p)) 
			surface.switchScreen(ScreenSwitcher.LEVEL_SELECT);
	}

}