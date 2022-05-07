package buildClasses;
import main.DrawingSurface;
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
	protected Rocket rocket;
	private Sidebar sideBar;
	
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
	}
	
	/**
	 * Makes a new Rocket that will be changed and added to in the building process
	 */
	public void spawnRocket() {
		rocket = new Rocket(surface.loadImage("img/rocket.png"), 100,100);
	}
	
	/**
	 * Makes the SideBar that will display the parts for the Rocket during the building process
	 */
	public void spawnSideBar() {
	//	sideBar = new Sidebar();
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
		
	}
	
	
}
