package rocket;
import java.util.ArrayList;
import java.util.List;

import processing.core.PApplet;
import processing.core.PImage;
import screenClasses.Sidebar;

import java.util.LinkedHashMap;

// Represents the rocket itself. Each build and launch screen will have a rocket object and draw it
public class Rocket {

	// state of the rocket. If rocket still flying / not blown up, then draw the rocket. Else (rocket has blown up) and draw an explosion 
	// Rocket HAS-A data 
	// Rocket HAS-A material 
	// Rocket HAS-A fuel 
	// Rocket HAS-A engine
	
	//private List<Sidebar> items;
	
	private Material material;
	private Engine engine;
	private Fuel fuel;
	private Data data;
	private boolean blownUp;
	
	private double x,y;
	private PImage img;
	
	
	public Rocket(PImage img, double x, double y) {
		this.img = img;
		this.x = x;
		this.y = y;
		blownUp = false;
	}
	
	// setters
	public void setMaterial(Material mat) {
		material = mat;
	}
	
	public void setEngine(Engine e) {
		engine = e;
	}
	
	public void setFuel(Fuel f) {
		fuel = f;
	}
	
	public void setState(boolean s) {
		blownUp = s;
	}
	
	// getters
	public Material getMaterial() {
		return material;
	}
	
	public Engine getEngine() {
		return engine;
	}
	
	public Fuel getFuel() {
		return fuel;
	}
	
	public boolean getState() {
		return blownUp;
	}
	public PImage getImage() {
		return img;
	}
	public void mouseDragged() {
		
	}
	public void draw(PApplet drawer) {
		
		if (img != null)
			drawer.image(img,(float)x,(float)y,(float)50,(float)50);
		else {
			drawer.fill(100);
			drawer.rect((float)x,(float)y,(float)50,(float)50);
		}
		
		// if material not null, then draw it
		
	}
	
	
	

}
