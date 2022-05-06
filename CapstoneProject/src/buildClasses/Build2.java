package buildClasses;
import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.JButton;
import javax.swing.JFrame;

import main.DrawingSurface;
import screenClasses.ScreenSwitcher;

/**
 * 
 * This class represents the second rocket build screen 
 *
 */
public class Build2 extends BuildScreen {

	private DrawingSurface surface;
	private Rectangle button;
	
	/**
	 * This constructor instantiates the drawing surface and button to move onto the launch
	 * @param surface the DrawingSurface that the build will be drawn on
	 */
	public Build2(DrawingSurface surface) {
		super(800,600,surface);
		this.surface = surface;
		
		button = new Rectangle(800/2-100,600/2-50,200,100);
	}
	
	/**
	 * Draws the rocket and displays the screen for making the rocket
	 */
	public void draw() {
		
		surface.background(0,255,0);
		
		surface.fill(0);
		surface.text("Build 2", 10, 20);
		surface.fill(255);
		
		surface.rect(button.x, button.y, button.width, button.height, 10, 10, 10, 10);
		surface.fill(0);
		String str = "To Launch 2";
		float w = surface.textWidth(str);
		surface.text(str, button.x+button.width/2-w/2, button.y+button.height/2);
		surface.fill(255);
		
	}
	
	/**
	 * detects where the mouse was pressed, and activates the button if it was pressed
	 */
	public void mousePressed() {
		Point p = surface.actualCoordinatesToAssumed(new Point(surface.mouseX,surface.mouseY));
		if (button.contains(p)) 
			surface.switchScreen(ScreenSwitcher.LAUNCH_2);
	}

}
