package rocket;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;

import processing.core.PApplet;
import processing.core.PImage;
import screenClasses.Sidebar;

import java.util.LinkedHashMap;

// Represents the rocket itself. Each build and launch screen will have a rocket object and draw it
public class Rocket extends Rectangle2D.Double {

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
	private boolean eHide, fHide, mHide;
	private double dir;
	private double vel; // turning velocity
	private double vx, vy;
	private boolean moving;
	
	//private double x,y,width,height;
	private PImage img;
	
	
	public Rocket(PImage img, double x, double y, double width, double height) {
		super(x,y,width,height);
		dir = 0;
		this.img = img;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		
		eHide = true;
		mHide = true;
		fHide = true;
		
		vel = 0;
		vx = 0;
		vy = 0;
		
		blownUp = false;
		moving  = false;
		
		
	}
	
	// setters
	public void setMaterial(Material mat) {
		material = mat;
	}
	
	public void ehide(boolean isVisible) {
		eHide = isVisible;
	}
	
	public void mhide(boolean isVisible) {
		mHide = isVisible;
	}
	
	public void fhide(boolean isVisible) {
		fHide = isVisible;
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
	public void setImageXAndY(double xVal, double yVal) {
		this.x = xVal;
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
	
	public void act() {
		
	//	System.out.println(dir);
		dir += vel;
		
		if (moving) {
			moveByAmount(1.5*Math.cos(Math.toRadians(dir + 90)), 1.5*Math.sin(Math.toRadians(dir + 90)));
		}
			
		
//		dir = Math.atan(((double)this.y-y)/(this.x-x));
//		if (this.x > x)
//			dir += Math.PI;
	}
	
	public void accelerate(double vel) {
		this.vel += vel;
		
	}
	
	public double getDirection() {
		return dir;
	}
	
	public void moveForward(boolean moving) {
		this.moving = moving;
	}
	
	public boolean getMoving() {
		return moving;
	}
	
	
	public void moveByAmount(double x, double y) { 
		
		System.out.println(super.x + "," + super.y);
		super.x -= x;
		super.y -= y;
	}

	public void applyWindowLimits(int windowWidth, int windowHeight) {
		x = Math.min(x,windowWidth-width);
		y = Math.min(y,windowHeight-height);
		x = Math.max(0,x);
		y = Math.max(0,y);
	}
	
	public boolean getState() {
		return blownUp;
	}
	
	public void draw(PApplet drawer) { // change
		
		//if (img != null) {
		
		
			
		if (blownUp == false) {
			
			drawer.fill(255);
			drawer.pushMatrix();
			drawer.translate((float)(x+width/2), (float)(y+height/2));
			drawer.rotate((float)Math.toRadians(dir));
			drawer.image(img,(int)(-width/2),(int)(-height/2),(int)width,(int)height);
			drawer.popMatrix();
		//	drawer.triangle((float)x,(float)y,(float)(x+(width/2)),(float)(y-50),(float)(x+width),(float)y);
			
			if (engine != null) {
				
				engine.setX(x);
				engine.setY(y+height);
				engine.setWidth(width);
				engine.setHeight(50);
				
				engine.draw(drawer);
					
			}
			
			if (material != null) {
				
				material.setX(x);
				material.setY(y);
				material.setWidth(width);
				material.setHeight(height);
				
				material.draw(drawer);
				
					
			}

			if (fuel != null) {
	
				fuel.draw(drawer);
		
			}
			
			
				
		}
			
		else {
			drawer.image(drawer.loadImage("img/th.png"),(float)x,(float)y,(float)50,(float)50);
		}
			
		// if material not null, then draw it
		
	}
	
	
	

}
