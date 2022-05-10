package BuildClasses;
import java.util.ArrayList;
import java.util.List;

import main.DrawingSurface;
import processing.core.PApplet;
import processing.core.PImage;
import rocket.Engine;
import rocket.Fuel;
import rocket.Material;
import rocket.Rocket;
import screenClasses.Screen;
import screenClasses.Sidebar;

// All build screens have the rocket
// all build screens have sidebar
// all build screens have data display
// all build screens have button to click once done
// build screens have lists of materials, engines, etc. Subclasses add to these lists depending on level
/**
 * 
 * Provides layout for build screens
 *
 */
public class BuildScreen extends Screen {
	
	private DrawingSurface surface;
	protected Rocket rocket;
	protected Sidebar sideBar;
	protected PImage img;
	
	protected List<Engine> engines;
	protected List<Fuel> fuels;
	protected List<Material> materials;
	boolean overRocket;
	boolean isDraggingRocket;
	int rocketWidth, rocketHeight;
	double rocketX, rocketY;
	double xOffset, yOffset;
	// arraylists; hold fuels in one, materials in other, etc
	
	/**
	 * Instantiates the variables that BuildScreens will use
	 * @param width Width of the BuildScreen
	 * @param height Height of the BuildScreen
	 * @param surface DrawingSurface that the BuildScreens's will be drawn on
	 */
	public BuildScreen(int w, int h, DrawingSurface surface) {
		super(w, h);
		
		this.surface = surface;
		overRocket = false;
//		rocketHeight = rocket.getImage().height;
//		rocketWidth = rocket.getImage().width;
//		rocketX = rocket.getX();
//		rocketY = rocket.getY();
		isDraggingRocket = false;
		engines = new ArrayList<Engine>();
	}
	
	/**
	 * Makes a new Rocket that will be changed and added to in the building process
	 */
	public void spawnRocket() {
	//	img = surface.loadImage("img/rocket.png");
		rocket = new Rocket(surface.loadImage("img/rocket1.png"), 300,100);
		this.rocketHeight = rocket.getImage().height;
		this.rocketWidth = rocket.getImage().width;
		this.rocketX = rocket.getX();
		this.rocketY = rocket.getY();
	}
	public PImage getRocketImage() {
		return rocket.getImage();
	}
	/**
	 * Makes the SideBar that will display the parts for the Rocket during the building process
	 */
	public void spawnSideBar() {
		Build1 b = new Build1(surface);
		// Different side bar for level one, level 2, level 3, level 4, and level 5.
		sideBar = new Sidebar(b, 0, 0, 100, 600);
	}
	
	/**
	 * sets up the Rocket and SideBar for the build
	 */
	
	public void setup() {
		spawnRocket();
		spawnSideBar();
	}
	
	/**
	 * Is a method that is to be overridden in its subclasses
	 */
	
	public void draw() {
		if (surface.mouseX > rocketX-rocketWidth && surface.mouseX < rocketX+rocketWidth&& 
			      surface.mouseY > rocketY-rocketHeight&& surface.mouseY < rocketY+rocketHeight) {
			    overRocket = !isDraggingRocket;  
	}
		surface.image(rocket.getImage(), (float)rocketX, (float)rocketY);
	}
//	public void mouseDragged() {
//		
//	}
	
	public void mousePressed() {
		System.out.println("H");
		  if(overRocket) { 
		    isDraggingRocket = true; 
		    
//		    fill(255, 255, 255);
		  } else {
			  isDraggingRocket = false;
		  }
		  xOffset = surface.mouseX-rocketX; 
		  yOffset = surface.mouseY-rocketY; 

		}
	
		public void mouseDragged() {
		  if(isDraggingRocket) {
		    rocketX = surface.mouseX-xOffset; 
		    rocketY = surface.mouseY-yOffset; 
		  }
		}

		public void mouseReleased() {
			isDraggingRocket = false;
		}
	
}
