package screenClasses;

import main.DrawingSurface;

public class LaunchScreen extends Screen{

	private DrawingSurface surface;
	
	public LaunchScreen(int width, int height, DrawingSurface surface) {
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