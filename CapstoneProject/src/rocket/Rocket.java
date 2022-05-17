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
	
	private double x,y,width,height;
	private PImage img;
	
	
	public Rocket(double x, double y, double width, double height) {
		//this.img = img;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		
		
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
	public void setImageX(double xVal) {
		this.x = xVal;
	}
	public void setImageY(double yVal) {
		this.y = yVal;
	}
	// getters
	public Material getMaterial() {
		return material;
	}
	public double getX() {
		return x;
	}
	public double getY() {
		return y;
	}
	public PImage getImage() {
		return img;
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
	
	public void draw(PApplet drawer) { // change
		
		//if (img != null) {
			
			if (blownUp == false) {
				drawer.noFill();
				drawer.rect((float)x,(float)y,(float)50,(float)250);
			}
			
			else {
				drawer.image(drawer.loadImage("img/th.png"),(float)x,(float)y,(float)50,(float)50);
			}
	
			
		
		// if material not null, then draw it
		
	}
	
	
	

}
