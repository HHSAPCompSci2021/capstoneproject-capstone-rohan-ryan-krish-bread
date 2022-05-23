package buildClasses;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import main.DrawingSurface;
import processing.core.PImage;
import rocket.Data;
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
 * Provides layout and general set up for build screens
 * @author Ryan Wagner, Krish Jhurani, Rohan Gupta
 */

// 
public class BuildScreen extends Screen{
	
	private DrawingSurface surface;
	public Rocket rocket;
	protected Sidebar sideBar;
	protected Data data;
	protected PImage img;
	
	protected List<Engine> engines;
	protected List<Fuel> fuels;
	protected List<Material> materials;
	
	private Rectangle r1, r2, r3, engineLoc, meterialLoc, fuelLoc;
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
		
		r1 = new Rectangle(25, 150, 100, 30);
		r2 = new Rectangle(25, 255, 100, 30);
		r3 = new Rectangle(25, 360, 100, 30);
		
		engineLoc = new Rectangle(300, 150, 100, 30); // move these so that they correspond
		meterialLoc = new Rectangle(300, 180, 100, 30);
		fuelLoc = new Rectangle(300, 210, 100, 30);
		currentDrag = null;
	}
	
	/**
	 * Makes a new Rocket that will be changed and added to in the building process
	 */
	public void spawnRocket() {
		img = surface.loadImage("img/BuildShuttle-removebg-preview.png");
		rocket = new Rocket(img,400,100,200,250);
		
//		rocket.setEngine(engines.get(0));
//		rocket.setMaterial(materials.get(0));
//		rocket.setFuel(fuels.get(0));
		
//		rocket.getEngine().setX(rocket.getX());
//		rocket.getEngine().setY(rocket.getY());
//		
//		rocket.getMaterial().setX(rocket.getX());
//		rocket.getMaterial().setY(rocket.getY());
//		
//		rocket.getFuel().setX(rocket.getX());
//		rocket.getFuel().setY(rocket.getY());
	}
	
	/**
	 * Makes the SideBar that will display the parts for the Rocket during the building process
	 */
	public void spawnSideBar() {
		sideBar = new Sidebar(0, 50, 200, 600, engines, fuels, materials);
	}
	
	/**
	 * Creates the data that will be displayed on the builds
	 */
	public void spawnDataDisplay() {
		data = new Data(rocket.getEngine(), rocket.getMaterial(), rocket.getFuel(),600,50,200,600);
	}
	
	/**
	 * Sets up the Rocket, SideBar and Data for the build
	 * Fills up lists with default values (level 1 values)
	 */
	public void setup() {
		
		PImage img = surface.loadImage("img/rocket.png"); // change later; just a temp variable for testing 
	//	PImage merlin = surface.loadImage("img/merlin1d.png"); // change later; just a temp variable for testing 
		
		Engine pressureFed = new Engine(surface.loadImage("img/merlin1d.png"), 20,20,20,50, "pressureFed", 500, 0.95, 100000);

	//	Engine closedCycle = new Engine(merlin, 20,20,20,20, "Closed Cycle", 1, 1,1); // change wieght and reliabilty params
	//	Material steel = new Material(surface.loadImage("img/Steel-PNG-File.png"), 300, 170, 20, 20, "Steel", 1000);
	//	Fuel RP1 = new Fuel(img, 400,20,20,20, "RP-1", 1000);

		Fuel RP1 = new Fuel(img, 400,20,20,20, "RP-1", 1000);
		Material steel = new Material(surface.loadImage("img/steel plating.jpg"), 300, 170, 20, 20, "Steel", 1000);

		
		engines.add(pressureFed);
	//	engines.add(closedCycle);
		materials.add(steel);
		fuels.add(RP1);
		
		spawnRocket();
		spawnSideBar();
		spawnDataDisplay();
	}
	
	/**
	 * Draws the drop down lists to the build along with drop locations for rocket customization
	 * @post rectangles, drop down lists, and text will be drawn to the DrawingSurface
	 */
	public void draw() {
			
		surface.fill(255);
		surface.rect(engineLoc.x,engineLoc.y,engineLoc.width,engineLoc.height);
		surface.rect(meterialLoc.x,meterialLoc.y,meterialLoc.width,meterialLoc.height);
		surface.rect(fuelLoc.x,fuelLoc.y,fuelLoc.width,fuelLoc.height);
	
		if (!sideBar.getList("e").getSelectedText().equals("Engines")) {
			surface.fill(225);
			surface.rect(r1.x,r1.y,r1.width,r1.height);
			surface.fill(0);
			surface.text(sideBar.getList("e").getSelectedText(), r1.x+15, r1.y+15);
		}
		if (!sideBar.getList("m").getSelectedText().equals("Materials")) {
			surface.fill(225);
			surface.rect(r2.x,r2.y,r2.width,r2.height);
			surface.fill(0);
			surface.text(sideBar.getList("m").getSelectedText(), r2.x+15, r2.y+15);
		}
		if (!sideBar.getList("f").getSelectedText().equals("Fuels")) {
			surface.fill(225);
			surface.rect(r3.x,r3.y,r3.width,r3.height);
			surface.fill(0);
			surface.text(sideBar.getList("f").getSelectedText(), r3.x+15, r3.y+15);
		}		
		
//		if (rocket.getEngine() != null) {
//			System.out.println(rocket.getEngine().getName());
//		}
	
	}
	
	/**
	 * Keeps track of data for dragging the customization box
	 * @param r Rectangle that is to be dragged
	 */
	public void dragThisOne(Rectangle r) {
		Point p = surface.actualCoordinatesToAssumed(new Point(surface.mouseX,surface.mouseY));
		
		
		if (r.contains(p)) {
			currentDrag = r;
			dragOffsetX = surface.mouseX - r.x;
			dragOffsetY = surface.mouseY - r.y;
		}
		
//		if (r.contains(surface.mouseX,surface.mouseY)) {
//			currentDrag = r;
//			dragOffsetX = surface.mouseX - r.x;
//			dragOffsetY = surface.mouseY - r.y;
//		}
	}
	
	//public 
	
//	public Rocket getRocket() {
//		return rocket;
//	}
	
	/**
	 * Gets ready to drag the customization box's if mouse is pressed
	 */
	public void mousePressed() {
		dragThisOne(r1);
		dragThisOne(r2);
		dragThisOne(r3);
	}

	/**
	 * Clicks customization box's into place if they are close to the drop location
	 * @post location of customization boxe's could be changed
	 */
	public void mouseReleased() {
		currentDrag = null;
		Point p = surface.actualCoordinatesToAssumed(new Point(surface.mouseX,surface.mouseY));
		
		if (engineLoc.contains(p)) {
			r1.x = engineLoc.x;
			r1.y = engineLoc.y;	
			
			for (int i = 0; i < engines.size(); i++) {	
				if (sideBar.getESelected().equals(engines.get(i).getName())) {
					rocket.setEngine(engines.get(i));
					data.setEngine(engines.get(i));
					engines.get(i).setVis();
				}	
			}	
			//rocket.setEngine(engines.get(0));
		}
		
		
		if (meterialLoc.contains(p)) {
			r2.x = meterialLoc.x;
			r2.y = meterialLoc.y;	
			for (int i = 0; i < materials.size(); i++) {
				if (sideBar.getMSelected().equals(materials.get(i).getName())) {
					rocket.setMaterial(materials.get(i));
					data.setMaterial(materials.get(i));
					materials.get(i).setVis();
				}
			}	
			//rocket.setMaterial(materials.get(0));
		}
		
		if (fuelLoc.contains(p)) {
			r3.x = fuelLoc.x;
			r3.y = fuelLoc.y;	
			for (int i = 0; i < fuels.size(); i++) {	
				if (sideBar.getFSelected().equals(fuels.get(i).getName())) {
					rocket.setFuel(fuels.get(i));
					data.setFuel(fuels.get(i));
					fuels.get(i).setVis();
				}	
			}
			//rocket.setFuel(fuels.get(0));
		}
		
		if (r1.x != engineLoc.x && r1.y != engineLoc.y) {
				rocket.setEngine(null);
				data.setEngine(null);
		}
		
		if (r2.x != meterialLoc.x && r2.y != meterialLoc.y) {
			rocket.setMaterial(null);
			data.setMaterial(null);
		}
		
		if (r3.x != fuelLoc.x && r3.y != fuelLoc.y) {
			rocket.setFuel(null);
			data.setFuel(null);
		}
		
	}
	
	/**
	 * Drags the customization box that is currently being dragged
	 * @post coordinate of the box being dragged will change
	 */
	public void mouseDragged() {
		if (currentDrag != null) {
			currentDrag.x = surface.mouseX - dragOffsetX;
			currentDrag.y = surface.mouseY - dragOffsetY;
			
		}
	}
	
	
}
