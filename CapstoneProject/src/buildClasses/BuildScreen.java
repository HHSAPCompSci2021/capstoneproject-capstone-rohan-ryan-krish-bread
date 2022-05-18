package buildClasses;
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
 * 
 * Provides layout for build screens
 *
 */
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
		engineLoc = new Rectangle(300, 150, 100, 30);
		meterialLoc = new Rectangle(300, 180, 100, 30);
		fuelLoc = new Rectangle(300, 210, 100, 30);
		currentDrag = null;
	}
	
	/**
	 * Makes a new Rocket that will be changed and added to in the building process
	 */
	public void spawnRocket() {
	//	img = surface.loadImage("img/rocket.png");
		rocket = new Rocket(400,100,50,250);
		
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
	
	public void spawnDataDisplay() {
		data = new Data(rocket.getEngine(), rocket.getMaterial(), rocket.getFuel(),600,50,200,600);
	}
	
	/**
	 * sets up the Rocket and SideBar for the build
	 * fills up lists with default values (level 1 values)
	 */
	public void setup() {
		
		PImage img = surface.loadImage("img/rocket.png"); // change later; just a temp variable for testing 
		Engine pressureFed = new Engine(img, 20,20,20,20, "pressureFed", 500, 0.95, 100000);
		Fuel RP1 = new Fuel(img, 400,20,20,20, "RP-1", 1000);
		Material steel = new Material(surface.loadImage("img/Steel-PNG-File.png"), 300, 170, 20, 20, "Steel", 1000);
		
		engines.add(pressureFed);
		materials.add(steel);
		fuels.add(RP1);
		
		spawnRocket();
		spawnSideBar();
		spawnDataDisplay();
	}
	
	/**
	 * Is a method that is to be overridden in its subclasses
	 */
	public void draw() {
		
	
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
		surface.noFill();
		surface.rect(engineLoc.x,engineLoc.y,engineLoc.width,engineLoc.height);
		surface.rect(meterialLoc.x,meterialLoc.y,meterialLoc.width,meterialLoc.height);
		surface.rect(fuelLoc.x,fuelLoc.y,fuelLoc.width,fuelLoc.height);
		
		
		
//		if (rocket.getEngine() != null) {
//			System.out.println(rocket.getEngine().getName());
//		}
	
	}
	
	public void dragThisOne(Rectangle r) {
		if (r.contains(surface.mouseX,surface.mouseY)) {
			currentDrag = r;
			dragOffsetX = surface.mouseX - r.x;
			dragOffsetY = surface.mouseY - r.y;
		}
	}
	
//	public Rocket getRocket() {
//		return rocket;
//	}
	
	public void mousePressed() {
		dragThisOne(r1);
		dragThisOne(r2);
		dragThisOne(r3);
	}

	public void mouseReleased() {
		currentDrag = null;
		if (engineLoc.contains(surface.mouseX,surface.mouseY)) {
			r1.x = engineLoc.x;
			r1.y = engineLoc.y;
			
			for (int i = 0; i < engines.size(); i++) {
				
				if (sideBar.getESelected().equals(engines.get(i).getName())) {
					rocket.setEngine(engines.get(i));
					engines.get(i).setVis();
				}
				
				
			}
			
			//rocket.setEngine(engines.get(0));
			
		}
		
		
		if (meterialLoc.contains(surface.mouseX,surface.mouseY)) {
			r2.x = meterialLoc.x;
			r2.y = meterialLoc.y;
			
			for (int i = 0; i < materials.size(); i++) {
				
				if (sideBar.getMSelected().equals(materials.get(i).getName())) {
					rocket.setMaterial(materials.get(i));
					materials.get(i).setVis();
				}
				
			}
			
			//rocket.setMaterial(materials.get(0));
		}
		
		if (fuelLoc.contains(surface.mouseX,surface.mouseY)) {
			r3.x = fuelLoc.x;
			r3.y = fuelLoc.y;
			
			for (int i = 0; i < fuels.size(); i++) {
				
				if (sideBar.getFSelected().equals(fuels.get(i).getName())) {
					rocket.setFuel(fuels.get(i));
					fuels.get(i).setVis();
				}
				
			}
			
			//rocket.setFuel(fuels.get(0));
		}
		
	}
	
	public void mouseDragged() {
		if (currentDrag != null) {
			currentDrag.x = surface.mouseX - dragOffsetX;
			currentDrag.y = surface.mouseY - dragOffsetY;
			
		}
	}
	
	
}
