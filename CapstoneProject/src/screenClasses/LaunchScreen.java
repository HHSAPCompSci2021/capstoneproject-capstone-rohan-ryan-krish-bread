package screenClasses;

import java.util.ArrayList;
import java.util.List;

import main.DrawingSurface;
import processing.core.PImage;
import rocket.Engine;
import rocket.Fuel;
import rocket.Material;
import rocket.Rocket;

public class LaunchScreen extends Screen{

	private DrawingSurface surface;
//	protected Rocket rocket;
//	protected Sidebar sideBar;
//	protected PImage img;
//	protected List<Engine> engines;
//	protected List<Fuel> fuels;
//	protected List<Material> materials;
	
	// arraylists; hold fuels in one, materials in other, etc
	
	/**
	 * Instantiates the variables that BuildScreens will use
	 * @param width Width of the BuildScreen
	 * @param height Height of the BuildScreen
	 * @param surface DrawingSurface that the BuildScreens's will be drawn on
	 */
	public LaunchScreen(int width, int height, DrawingSurface surface) {
		super(width, height);
		this.surface = surface;
		
//		engines = new ArrayList<Engine>();
//		materials = new ArrayList<>();
	}
	
	/**
	 * Makes a new Rocket that will be changed and added to in the building process
	 */
	public void spawnCompletedRocket() {
	//	img = surface.loadImage("img/rocket.png");
		
	}
//	public void spawnMaterials() {
//		
//		materials.add(new Material(surface.loadImage("img/Steel-PNG-File.png"), 300, 170));
//		
//	}
	/**
	 * Makes the SideBar that will display the parts for the Rocket during the building process
	 */
//	public void spawnSideBar() {
//		
//		
//		sideBar = new Sidebar(0, 0, 100, 600, engines, fuels, materials);
//	}
	
	/**
	 * Sets up the Rocket and SideBar for the build
	 */
	public void setup() {
		spawnCompletedRocket();
	}
	
	/**
	 * Draws new instances of rocket, backgrounds, and text
	 */
	public void draw() {
		
	}

}