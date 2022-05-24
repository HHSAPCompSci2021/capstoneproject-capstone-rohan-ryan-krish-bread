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
import rocket.Rocket;
import screenClasses.ScreenSwitcher;
import screenClasses.Sidebar;

/**
 * This class represents the level two rocket build screen 
 * @author Ryan Wagner, Krish Jhurani, Rohan Gupta
 */
public class Build3 extends BuildScreen {

	private DrawingSurface surface;
	private Rectangle button;
	private boolean hide;
//	private Sidebar sidebar;
	
	/**
	 * Instantiates the drawing surface and button to move onto the launch
	 * @param surface the DrawingSurface that the build will be drawn on
	 */
	public Build3(DrawingSurface surface) {
		super(800,600,surface);
		this.surface = surface;
		
		button = new Rectangle(425,550,150,30);
		hide = true;
	}
	
	/**
	 * Sets up the Sidebar Rocket and Data for the build
	 */
	public void setup() {
		super.setup();
		
		PImage img = surface.loadImage("img/rocket.png"); // change later; just a temp variable for testing 
		Engine closedCycle1 = new Engine(img, 20,20,20,20, "Closed Cycle(OR)", 1500, 0.9, 200000);
		Engine closedCycle2 = new Engine(img, 20,20,20,20, "Closed Cycle(FR)", 1500, 0.9, 200000);// change wieght and reliabilty params
		Engine fullFlow = new Engine(img, 20,20,20,20, "Full Flow", 1750, 0.5, 300000 );
		Material carbonComp = new Material(img, 20,20,20,20, "Carbon Comp", 500, 100 );
		Fuel CH4 = new Fuel(img, 20,20,20,20, "CH4", 400 );
		
		Engine openCycle = new Engine(img, 20,20,20,20, "Open Cycle", 1500, 0.91, 170000 ); // change wieght and reliabilty params
		Fuel LH2 = new Fuel(img, 20,20,20,20, "LH2", 1000 );
		
	
		
		engines.add(closedCycle1);
		engines.add(closedCycle2);
		materials.add(carbonComp);
		fuels.add(CH4);
		
		engines.add(openCycle);
		fuels.add(LH2);
		
		sideBar.setup(surface);
		
		//Fuel RP1 = new Fuel(img, 20,20,20,20, "RP-1");

	}
	
	/**
	 * Draws the rocket and displays the screen for making the rocket
	 * @post DrawingSurface will have images, a Sidebar, Rocket, Data, and text drawn on it
	 */
	public void draw() {
		
		
		surface.background(255);
		
		PImage image1 = surface.loadImage("img/BuildBackground.png");
		surface.image(image1, 0, 0, 800, 600);
//		surface.image(image1, 250, 10, 250, 200);
//		surface.image(image1, 500, 10, 250, 200);
//		surface.image(image1, 750, 10, 250, 200);
//		
//		surface.image(image1, 0, 210, 250, 200);
//		surface.image(image1, 250, 210, 250, 200);
//		surface.image(image1, 500, 210, 250, 200);
//		surface.image(image1, 750, 210, 250, 200);
//		
//		surface.image(image1, 0, 410, 250, 200);
//		surface.image(image1, 250, 410, 250, 200);
//		surface.image(image1, 500, 410, 250, 200);
//		surface.image(image1, 750, 410, 250, 200);
		
		rocket.draw(surface);
		sideBar.draw(surface);
		data.draw(surface);
		
		super.draw();
		if (hide == false) {
			surface.text("Rocket will not launch without an engine." , 200, 300);
		}
		
		surface.fill(0);
		surface.text("Level 3 Build", 10, 20);
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
		
		if(rocket.getEngine() != null) {
			
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
	 * Gets the Rocket that is being built in this level
	 * @return rocket Rocket used in this build
	 */
	public Rocket getRocket() {
		return rocket;
	}
	
	/**
	 * Detects where the mouse was pressed, and activates the button if it was pressed
	 * @post screen will change if the launch button is pressed
	 */
	public void mousePressed() {
		Point p = surface.actualCoordinatesToAssumed(new Point(surface.mouseX,surface.mouseY));
		if (button.contains(p)) {
			
			if (rocket.getEngine() != null) {
				sideBar.hide();
				hide = true;
				surface.switchScreen(ScreenSwitcher.LAUNCH_3);
			}
			
			else {
				hide = false;
			}
			
		}
		super.mousePressed();
			
	}
	
	/**
	 * When mouse is released the super class mouseReleased() method is run
	 */
	public void mouseReleased() {
		super.mouseReleased();
	}
	
	/**
	 * When mouse is dragged the super class mouseDragged() method is run
	 */
	public void mouseDragged() {
		super.mouseDragged();
	}


}
