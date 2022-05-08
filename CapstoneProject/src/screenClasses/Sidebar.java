package screenClasses;
// represents sidebar for build screens
// constructor takes in dimensions for sidebar, and arraylists of parts
// when the user selects a part from the sidebar, the item will be dragged and dropped
//// when drag and dropping, remove selected item from arraylist, and set the Rocket's corresponding field equal to item. 
////// ArrayLists will be modified by BuildScreen, as it is in charge of drag n drop, and subclasses of BuildScreen will add parts to the lists to exapnd options as levels progress
////// each part's object (material, engine, etc.) will have a string representing its name. draw / setup method will loop through lists and store the names in a string array. This string array is to be used in the displaying of the dropdown menu.
import java.util.ArrayList;
import java.util.List;

import buildClasses.Build1;
import buildClasses.Build2;
import buildClasses.BuildScreen;
import processing.core.PApplet;
import rocket.Engine;
import rocket.Fuel;
import rocket.Material;
import g4p_controls.*;

public class Sidebar {
	
//	private Engine engines;
//	private Fuel fuels;
//	private Material materials;
	
	GDropList list;
	
	private List<Engine> engines;
	private List<Fuel> fuels;
	private List<Material> materials;
	private double x,y;
	private double width, height;
	
	public Sidebar(BuildScreen buildScreen, double x, double y, double width, double height) {
//		e = Engine.getEngine();
//		f = Fuel.getFuel();
//		m = Material.getMaterials(); 
		this.engines = engines;
		this.fuels = fuels;
		this.materials = materials;
//		engines = e;
//		fuels = f;
//		materials = m;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		if(buildScreen.equals(Build1.getDifferingObjects())) {
			// Add stuff to ArrayLists accordingly
		}
		else if(buildScreen.equals(Build2.getBuildObjects())) {
			// Add stuff to ArrayLists accoridngly
		}
		// No need for ArrayLists in constructors, when you are just going to add the number of engines according to the 
		// level. 
		
		 
		
	}
	
	public void setup (PApplet p) {
		
		G4P.setInputFont("Times New Roman", G4P.PLAIN, 14); // New for G4P V4.3
		G4P.setGlobalColorScheme(GCScheme.PURPLE_SCHEME);
		list = new GDropList(p, 25, 100, 100, 100, 0);
		
//		List<String> engines = new ArrayList<String>();
//		
//		for (int i = 0; i < this.engines.size(); i++) {
//			
//			engines.add(this.engines.get(i).getName());
//		}
//		
//
//		list.setItems(engines, 0);
		//list.addEventHandler(this, "handleEngineList");
		
		
	}
	
	public void draw(PApplet p) {
		p.rect(0, 50, 200, 600);
		
//		setup(p);
	}
	
	public void handleDropListEvents(GDropList list, GEvent event) {
		System.out.println("Item selected:" + list.getSelectedText());
		
	}
}
