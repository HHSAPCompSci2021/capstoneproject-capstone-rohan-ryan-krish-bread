package buildClasses;
import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.JButton;
import javax.swing.JFrame;

import main.DrawingSurface;
import processing.core.PImage;
import rocket.Engine;
import rocket.Fuel;
import rocket.Material;
import screenClasses.ScreenSwitcher;
import screenClasses.Sidebar;

/**
 * 
 * This class represents the second rocket build screen 
 *
 */
public class Build2 extends BuildScreen {

	private DrawingSurface surface;
	private Rectangle button;
//	private Sidebar sidebar;
	/**
	 * This constructor instantiates the drawing surface and button to move onto the launch
	 * @param surface the DrawingSurface that the build will be drawn on
	 */
	public Build2(DrawingSurface surface) {
		super(800,600,surface);
		this.surface = surface;
		
		button = new Rectangle(425,550,150,30);
	}
	
	public void setup() {
		super.setup();
		
		PImage img = surface.loadImage("img/rocket.png"); // change later; just a temp variable for testing 
		Engine closedCycle = new Engine(img, 20,20,20,20, "Closed Cycle", 1, 1,1); // change wieght and reliabilty params
		engines.add(closedCycle);
		
		sideBar.setup(surface);
		
		//Fuel RP1 = new Fuel(img, 20,20,20,20, "RP-1");

	}
	
	/**
	 * Draws the rocket and displays the screen for making the rocket
	 */
	public void draw() {
		
		
		surface.background(255);
		
		PImage image1 = surface.loadImage("img/steel plating.jpg");
		surface.image(image1, 0, 10, 250, 200);
		surface.image(image1, 250, 10, 250, 200);
		surface.image(image1, 500, 10, 250, 200);
		surface.image(image1, 750, 10, 250, 200);
		
		surface.image(image1, 0, 210, 250, 200);
		surface.image(image1, 250, 210, 250, 200);
		surface.image(image1, 500, 210, 250, 200);
		surface.image(image1, 750, 210, 250, 200);
		
		surface.image(image1, 0, 410, 250, 200);
		surface.image(image1, 250, 410, 250, 200);
		surface.image(image1, 500, 410, 250, 200);
		surface.image(image1, 750, 410, 250, 200);
		
		rocket.draw(surface);
		sideBar.draw(surface);
		data.draw(surface);
		
		super.draw();
		
		surface.fill(0);
		surface.text("Level 1 Build", 10, 20);
		surface.fill(255);
		
//		if (rocket == null) {
//			System.out.println("debug");	
//		}
		
		if (sideBar.getEngineVis() == false) {
			sideBar.setVisible();
		}
		
		if (sideBar.getMaterialVis() == false) {
			sideBar.setVisible();
		}
		
		if (sideBar.getFuelVis() == false) {
			sideBar.setVisible();
		}
		
		
//		materials.get(0).draw(surface);
		
		surface.rect(button.x, button.y, button.width, button.height, 10, 10, 10, 10);
		surface.fill(0);
		String str = "Launch";
		float w = surface.textWidth(str);
		surface.text(str, button.x+button.width/2-w/2, button.y+button.height/2+3);
		surface.fill(255);
		
	//  sidebar.draw(surface);
		
	}
	
	/**
	 * detects where the mouse was pressed, and activates the button if it was pressed
	 */
	public void mousePressed() {
		Point p = surface.actualCoordinatesToAssumed(new Point(surface.mouseX,surface.mouseY));
		if (button.contains(p)) {
			sideBar.hide();
			surface.switchScreen(ScreenSwitcher.LAUNCH_2);
		}
			
	}

}
