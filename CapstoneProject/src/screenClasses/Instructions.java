package screenClasses;

import java.awt.Point;
import java.awt.Rectangle;

import main.DrawingSurface;

public class Instructions extends Screen{

	private DrawingSurface surface;
	private Rectangle button;
	
	public Instructions(int width, int height, DrawingSurface surface) {
		super(width, height);
		this.surface = surface;
		
		button = new Rectangle(625, 550, 150, 30);
	}
	
	public void draw() {
		surface.background(255);
			
		surface.fill(0);
		surface.text("Read the README", 10, 20);
        surface.fill(255);
		
		surface.rect(button.x, button.y, button.width, button.height, 10, 10, 10, 10);
		surface.fill(0);
		String str = "Back To Level Select";
		float w = surface.textWidth(str);
		surface.text(str, button.x+button.width/2-w/2, button.y+button.height/2+3);
		surface.fill(255);
	}
	
	/**
	 * detects where the mouse was pressed, and activates the button if it was pressed
	 */
	public void mousePressed() {
		Point p = surface.actualCoordinatesToAssumed(new Point(surface.mouseX,surface.mouseY));
		if (button.contains(p)) {
			surface.switchScreen(ScreenSwitcher.LEVEL_SELECT);
		}			
	}
}
