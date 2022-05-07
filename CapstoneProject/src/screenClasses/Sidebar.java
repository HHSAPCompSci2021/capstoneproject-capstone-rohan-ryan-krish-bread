package screenClasses;
// represents sidebar for build screens

import java.util.ArrayList;
import java.util.List;

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
	
	public void draw(PApplet p) {
		p.rect(0, 50, 200, 600);
		
		G4P.setInputFont("Times New Roman", G4P.PLAIN, 14); // New for G4P V4.3
		
		list = new GDropList(p, 25, 100, 100, 100, 0);
		
		List<String> engines = new ArrayList<String>();
		engines.add("Pressure Fed");
		engines.add("Open Cycle");
		engines.add("Closed Cycle");
		list.setItems(engines, 0);
	}
	
	public void handleDropListEvents(GDropList list, GEvent event) {
		System.out.println("Item selected:" + list.getSelectedText());
		
		// when item clicked on, get the object from the list, and do the drag n drop
	}
}
