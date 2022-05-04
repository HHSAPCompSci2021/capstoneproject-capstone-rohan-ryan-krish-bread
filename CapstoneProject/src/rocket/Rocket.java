package rocket;
import java.util.ArrayList;
import java.util.List;

import screenClasses.Sidebar;

import java.util.LinkedHashMap;

// Represents the rocket itself. Each build and launch screen will have a rocket object and draw it
public class Rocket {

	// state of the rocket. If rocket still flying / not blown up, then draw the rocket. Else (rocket has blown up) and draw an explosion 
	// Rocket HAS-A data 
	// Rocket HAS-A material 
	// Rocket HAS-A fuel 
	// Rocket HAS-A engine
	private List<Sidebar> items;
	
	
	public Rocket() {
		items = new ArrayList<>();
		// TODO Auto-generated constructor stub
	}
	
	
	
	// draw the rocket
	// other methods

}
