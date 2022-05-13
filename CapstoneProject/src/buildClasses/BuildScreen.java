package buildClasses;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import main.DrawingSurface;
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
public class BuildScreen extends Screen{
	
	private DrawingSurface surface;
	public Rocket rocket;
	protected Sidebar sideBar;
	protected PImage img;
	
	protected List<Engine> engines;
	protected List<Fuel> fuels;
	protected List<Material> materials;
	
	private Rectangle r1;
	private Rectangle fuelLoc;
	private Rectangle currentDrag;
	private int dragOffsetX, dragOffsetY;
	
	// arraylists; hold fuels in one, materials in other, etc
	
	/**
	 * Instantiates the variables that BuildScreens will use
	 * @param width Width of the BuildScreen
	 * @param height Height of the BuildScreen
	 * @param surface DrawingSurface that the BuildScreens's will be drawn on
	 */
	public BuildScreen(int width, int height, DrawingSurface surface) {
		super(width, height);
		this.surface = surface;
		
		engines = new ArrayList<Engine>();
		materials = new ArrayList<Material>();
		fuels = new ArrayList<Fuel>();
		
		r1 = new Rectangle(30,150,100,30);
		fuelLoc = new Rectangle(300, 150, 100, 30);
		currentDrag = null;
	}
	
	/**
	 * Makes a new Rocket that will be changed and added to in the building process
	 */
	public void spawnRocket() {
	//	img = surface.loadImage("img/rocket.png");
		rocket = new Rocket(surface.loadImage("img/rocket.png"), 300,100);
	}
	
	/**
	 * Makes the SideBar that will display the parts for the Rocket during the building process
	 */
	public void spawnSideBar() {
		
		sideBar = new Sidebar(0, 0, 100, 600, engines, fuels, materials);
		
	}
	
	/**
	 * sets up the Rocket and SideBar for the build
	 * fills up lists with default values (level 1 values)
	 */
	public void setup() {
		
		PImage img = surface.loadImage("img/rocket.png"); // change later; just a temp variable for testing 
		Engine pressureFed = new Engine(img, 20,20,20,20, "pressureFed");
		Fuel RP1 = new Fuel(img, 20,20,20,20, "RP-1");
		
		engines.add(pressureFed);
		materials.add(new Material(surface.loadImage("img/Steel-PNG-File.png"), 300, 170, 20, 20, "Steel"));
		fuels.add(RP1);
		
		spawnRocket();
		spawnSideBar();
	}
	
	/**
	 * Is a method that is to be overridden in its subclasses
	 */
	public void draw() {
		surface.fill(255);
		surface.rect(r1.x,r1.y,r1.width,r1.height);
		surface.fill(0);
		surface.text("pressureFed", r1.x+15, r1.y+15);
		surface.noFill();
		surface.rect(fuelLoc.x,fuelLoc.y,fuelLoc.width,fuelLoc.height);
	}
	
	public void dragThisOne(Rectangle r) {
		if (r.contains(surface.mouseX,surface.mouseY)) {
			currentDrag = r;
			dragOffsetX = surface.mouseX - r.x;
			dragOffsetY = surface.mouseY - r.y;
		}
	}
	
	public void mousePressed() {
		dragThisOne(r1);
	}

	public void mouseReleased() {
		currentDrag = null;
		if (fuelLoc.contains(surface.mouseX,surface.mouseY)) {
			r1.x = fuelLoc.x;
			r1.y = fuelLoc.y;
		}
	}
	
	public void mouseDragged() {
		if (currentDrag != null) {
			currentDrag.x = surface.mouseX - dragOffsetX;
			currentDrag.y = surface.mouseY - dragOffsetY;
			
		}
	}
	
	
}
