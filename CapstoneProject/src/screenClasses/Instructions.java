package screenClasses;

import java.awt.Point;
import java.awt.Rectangle;

import main.DrawingSurface;
/**
 * Writes and displays the instructions for the program
 * @author Ryan Wagner
 *
 */
public class Instructions extends Screen{

	private DrawingSurface surface;
	private Rectangle button;
	/**
	 * The instructions of the program and how to use it
	 * @param width width of the instruction's text
	 * @param height height of the instruction's text
	 * @param surface the drawing surface on which to draw
	 */
	public Instructions(int width, int height, DrawingSurface surface) {
		super(width, height);
		this.surface = surface;
		
		button = new Rectangle(625, 550, 150, 30);
	}
	/**
	 * Displays the instructions
	 */
	public void draw() {
		surface.background(255);
			
		surface.fill(0);
		surface.textSize(20);
		surface.text("- Users will start by clicking the level 1 button."
			+ "\n" + "- In each level, the user will be given certain components to build a rocket."
			+ "\n" + "- Drag and drop different components of the rocket into their location."
			+ "\n" + "- After the rocket is built, there will be a test to see how efficient it is."
			+ "\n" + "- Each component has different results, so test multiple combinations of the"
			+ "\n" + "components in order to be successful!"
			+ "\n" + "- The rocket can be accelerated and decelerated using the keys W, and S."
			+ "\n" + "- Use keys A and D to change the direction of the rocket."
			+ "\n" + "- The rocket can move side to side using the left and right arrow keys."
			+ "\n" + "- When controlling side trajectory don't hold more that one key at a time."
			+ "\n" + "- Going into the darkness of space, or outside the window boundaries"
			+ "\n" + "will result in the rocket exploding."
			+ "\n" + ""
			+ "\n" + "note: the user is not ment to return to previous levels"
			+ "\n" + ""
			+ "\n" + "- Finally, have fun!", 10, 20);
        surface.fill(255);
		
		surface.rect(button.x, button.y, button.width, button.height, 10, 10, 10, 10);
		surface.fill(0);
		surface.textSize(13);
		String str = "Back To Level Select";
		float w = surface.textWidth(str);
		surface.text(str, button.x+button.width/2-w/2, button.y+button.height/2+3);
		surface.fill(255);
	}
	
	/**
	 * Detects where the mouse was pressed, and activates the button if it was pressed
	 */
	public void mousePressed() {
		Point p = surface.actualCoordinatesToAssumed(new Point(surface.mouseX,surface.mouseY));
		if (button.contains(p)) {
			surface.switchScreen(ScreenSwitcher.LEVEL_SELECT);
		}			
	}
}
