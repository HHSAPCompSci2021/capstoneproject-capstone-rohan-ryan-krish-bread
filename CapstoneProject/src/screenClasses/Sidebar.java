package screenClasses;
// represents sidebar for build screens
// constructor takes in dimensions for sidebar, and arraylists of parts
// when the user selects a part from the sidebar, the item will be dragged and dropped
//// when drag and dropping, remove selected item from arraylist, and set the Rocket's corresponding field equal to item. 
////// ArrayLists will be modified by BuildScreen, as it is in charge of drag n drop, and subclasses of BuildScreen will add parts to the lists to exapnd options as levels progress
////// each part's object (material, engine, etc.) will have a string representing its name. draw / setup method will loop through lists and store the names in a string array. This string array is to be used in the displaying of the dropdown menu.
import java.util.ArrayList;
import java.util.List;

import buildClasses.BuildScreen;
import processing.core.PApplet;
import rocket.Engine;
import rocket.Fuel;
import rocket.Material;
import g4p_controls.*;
import main.DrawingSurface;

public class Sidebar {
	
//	private Engine engines;
//	private Fuel fuels;
//	private Material materials;
	
	GDropList eList;
	GDropList fList;
	GDropList mList;
	
	private List<Engine> engines;
	private List<Fuel> fuels;
	private List<Material> materials;
	private double x,y;
	private double width, height;
	
	public Sidebar(double x, double y, double width, double height, List<Engine> e, List<Fuel> f, List<Material> m) {
//		e = Engine.getEngine();
//		f = Fuel.getFuel();
//		m = Material.getMaterials(); 
		
		engines = e;
		fuels = f;
		materials = m;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		
		 
		
	}
	
	public void setup (PApplet p) {
		
		G4P.setInputFont("Times New Roman", G4P.PLAIN, 14); // New for G4P V4.3
		G4P.setGlobalColorScheme(GCScheme.PURPLE_SCHEME);
		eList = new GDropList(p, 25, 100, 100, 100, 0);
		eList.setVisible(false);
		
		G4P.setInputFont("Times New Roman", G4P.PLAIN, 14); // New for G4P V4.3
		G4P.setGlobalColorScheme(GCScheme.PURPLE_SCHEME);
		mList = new GDropList(p, 25, 200, 100, 100, 0);
		mList.setVisible(false);
		
		G4P.setInputFont("Times New Roman", G4P.PLAIN, 14); // New for G4P V4.3
		G4P.setGlobalColorScheme(GCScheme.PURPLE_SCHEME);
		fList = new GDropList(p, 25, 300, 100, 100, 0);
		fList.setVisible(false);
		
		List<String> engines = new ArrayList<String>();
		List<String> materials = new ArrayList<String>();
		List<String> fuels = new ArrayList<String>();
		
		for (int i = 0; i < this.engines.size(); i++) {
			engines.add(this.engines.get(i).getName());
		}
		eList.setItems(engines, 0);
		
		for (int i = 0; i < this.materials.size(); i++) {
			materials.add(this.materials.get(i).getName());
		}
		mList.setItems(materials, 0);
		
		for (int i = 0; i < this.fuels.size(); i++) {
			fuels.add(this.fuels.get(i).getName());
		}
		fList.setItems(fuels, 0);
		//list.addEventHandler(this, "handleEngineList");
	//	System.out.println("Item selected:" + list.getSelectedText());
		
		
	}
	
	public boolean getEngineVis() {
		return eList.isVisible();
	}
	
	public boolean getMaterialVis() {
		return mList.isVisible();
	}
	
	public boolean getFuelVis() {
		return fList.isVisible();
	}
	
	public void setVisible() {
		eList.setVisible(true);
		mList.setVisible(true);
		fList.setVisible(true);
	}
	
	public void hide() {
		eList.setVisible(false);
		mList.setVisible(false);
		fList.setVisible(false);
		
	}
	
	public void draw(PApplet p) {
		p.rect(0, 50, 200, 600);
		
		//setup(p);
	}
	
	public void handleDropListEvents(GDropList list, GEvent event) {

	}
}
