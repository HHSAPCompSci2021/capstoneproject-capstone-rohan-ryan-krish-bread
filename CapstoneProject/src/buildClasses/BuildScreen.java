package buildClasses;
import main.DrawingSurface;
import screenClasses.Screen;

// Provides layout for build screens
// All build screens have the rocket
// all build screens have sidebar
// all build screens have data display
// all build screens have button to click once done
// build screens have lists of materials, engines, etc. Subclasses add to these lists depending on level

public class BuildScreen extends Screen{
	
	private DrawingSurface surface;
	//private Rocket rocket;
	//priavte SideBar sideBar;
	// arraylists; hold fuels in one, materials in other, etc
	
	public BuildScreen(int width, int height, DrawingSurface surface) { // Instantiate arraylists here, subclasses of BuildScreen will fill them up 
		super(width, height);
		this.surface = surface;
	}
	
	public void spawnRocket() {
		//rocket = new Rocket();
	}
	
	public void spawnSideBar() {
		//sideBar = new SideBar();
	}
	
	public void setup() {
		spawnRocket();
		spawnSideBar();
	}
	
	public void draw() {
		
	}
	
	
}
