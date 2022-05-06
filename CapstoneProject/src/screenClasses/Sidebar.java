package screenClasses;
// represents sidebar for build screens

import java.util.ArrayList;
import java.util.List;

import processing.core.PApplet;
import rocket.Engine;
import rocket.Fuel;
import rocket.Material;

public class Sidebar {
	private Engine engines;
	private Fuel fuels;
	private Material materials;
	public Sidebar(List<Engine> e, List<Fuel> f, List<Material> m) {
		e = Engine.getEngine();
		f = Fuel.getFuel();
		m = Material.getMaterials();
		
	}
	public void draw(PApplet p) {
		p.rect(0, 50, 200, 600);
	}
	
}
