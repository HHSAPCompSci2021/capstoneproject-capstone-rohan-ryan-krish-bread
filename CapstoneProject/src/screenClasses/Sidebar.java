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
import processing.core.PImage;
import rocket.Engine;
import rocket.Fuel;
import rocket.Material;
import g4p_controls.*;
import main.DrawingSurface;

/**
*Class represents the Sidebar for the BuildScreens,that displays the parts menu
* @author Rohan Gupta
*/
public class Sidebar {
		
	GDropList elist;
	GDropList flist;
	GDropList mlist;
	
	private List<Engine> engines;
	private List<Fuel> fuels;
	private List<Material> materials;
	private double x,y;
	private double width, height;
	
	/**
	* Constructs the sidebar for the buildscreens
	* @param x x coord for  sidebar
	* @param y y coord for  sidebar
	* @param width width for  sidebar
	* @param height oeight of sidebar
	* @param e x coord for  sidebar
	* @param f x coord for  sidebar
	* @param m x coord for  sidebar
	*/
	public Sidebar(double x, double y, double width, double height, List<Engine> e, List<Fuel> f, List<Material> m) {
		
		engines = e;
		fuels = f;
		materials = m;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		
		
	}
	
	/**
	 * makes the dropdown menus and fills them with values 
	 * @param p PApplet on which to draw dropdowns 
	 */
	public void setup (PApplet p) {
		
		G4P.setInputFont("Times New Roman", G4P.PLAIN, 14); // New for G4P V4.3
		G4P.setGlobalColorScheme(GCScheme.BLUE_SCHEME);
		elist = new GDropList(p, 25, 100, 100, 100, 0);
		elist.setVisible(false);
		
		G4P.setInputFont("Times New Roman", G4P.PLAIN, 14); // New for G4P V4.3
		G4P.setGlobalColorScheme(GCScheme.BLUE_SCHEME);
		mlist = new GDropList(p, 25, 200, 100, 100, 0);
		mlist.setVisible(false);
		
		G4P.setInputFont("Times New Roman", G4P.PLAIN, 14); // New for G4P V4.3
		G4P.setGlobalColorScheme(GCScheme.BLUE_SCHEME);
		flist = new GDropList(p, 25, 300, 100, 100, 0);
		flist.setVisible(false);
		
		List<String> engines = new ArrayList<String>();
		List<String> materials = new ArrayList<String>();
		List<String> fuels = new ArrayList<String>();
		
		engines.add("Engines");
		for (int i = 0; i < this.engines.size(); i++) {
			if (!engines.get(i).equals(this.engines.get(i).getName())) {
				engines.add(this.engines.get(i).getName());
			}
		}
		
		elist.setItems(engines, 0);
		
		materials.add("Materials");
		for (int i = 0; i < this.materials.size(); i++) {
			materials.add(this.materials.get(i).getName());
		}
		mlist.setItems(materials, 0);
		
		fuels.add("Fuels");
		for (int i = 0; i < this.fuels.size(); i++) {
			fuels.add(this.fuels.get(i).getName());
		}
		flist.setItems(fuels, 0);	
		
	}
	
	/**
	 * gets the selected engine from the list
	 * @return the selected engine from the list
	 */
	public String getESelected() {
		return elist.getSelectedText();
	}
	
	/**
	 * gets the selected material from the list
	 * @return the selected material from the list
	 */
	public String getMSelected() {
		return mlist.getSelectedText();
	}
	
	/**
	 * gets the selected fuel from the list
	 * @return the selected fuel from the list
	 */
	public String getFSelected() {
		return flist.getSelectedText();
	}
	
	/**
	 * gets the visibility of the engine
	 * @return The visibility of the engine
	 */
	public boolean getEngineVis() {
		return elist.isVisible();
	}
	
	/**
	 * gets the visibility of the material
	 * @return The visibility of the material
	 */
	public boolean getMaterialVis() {
		return mlist.isVisible();
	}
	
	/**
	 * gets the visibility of the fuel
	 * @return The visibility of the fuel
	 */
	public boolean getFuelVis() {
		return flist.isVisible();
	}
	
	/**
	 * sets all of the lists to visible
	 */
	public void setVisible() {
		elist.setVisible(true);
		mlist.setVisible(true);
		flist.setVisible(true);
	}
	
	/**
	 * sets all of the lists to not visible
	 */
	public void hide() {
		elist.setVisible(false);
		mlist.setVisible(false);
		flist.setVisible(false);
		
	}
	
	/**
	 * 
	 * @param p DrawingSurface used to draw side bar
	 * @post DraiwngSurface p will have a rectangle drawn to it
	 */
	public void draw(PApplet p) {
		p.noFill();
		p.stroke(211, 211, 211);
		p.rect((float)x, (float)y, (float)width,(float)height);

	}
	/**
	 * Gets the drop down list that is specified 
	 * @param list String that represents what list should be returned
	 * @return The specified list
	 */
	public GDropList getList(String list) {
		if (list.equals("e")) {
			return elist;
		}
		if (list.equals("f")) {
			return flist;
		}
		if (list.equals("m")) {
			return mlist;
		}
		return null;
	}
	
}
