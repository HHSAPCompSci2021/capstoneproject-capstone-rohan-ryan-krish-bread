package rocket;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;

import processing.core.PApplet;
import processing.core.PImage;
import screenClasses.Sidebar;

import java.util.LinkedHashMap;

// Represents the rocket itself. Each build and launch screen will have a rocket object and draw it
/**
*Class reprenting the rocket that is drawn on both the build and launch screens
 */
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
	
	/**
	* Contructs a rocket object with the image of the rocket, x and y coords, and dimensions
	* @param img image of the rocket to be drawn on both build and launch screens 
	* @param x x-coord of the rocket 
	* @param y y-coord of the rocket
	* @param width width of the rocket
	* @param height height of the rocket
	 */
	public Rocket(PImage img, double x, double y, double width, double height) {
		super(x,y,width,height);
		dir = 0;
		this.img = img;
		System.out.println(img);
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
	/**
	* Sets the rocket's material 
	* @param mat material to be set
	 */
	public void setMaterial(Material mat) {
		material = mat;
	}
	
	/**
	* hides the rocket's engine so that it is not drawn 
	* @param isVisible whether or not the engine is to be visble or not
	 */
	public void ehide(boolean isVisible) {
		eHide = isVisible;
	}
	/**
	* hides the rocket's material so that it is not drawn 
	* @param isVisible whether or not the material is to be visble or not
	 */
	public void mhide(boolean isVisible) {
		mHide = isVisible;
	}
	
	/**
	* hides the rocket's fuel so that it is not drawn 
	* @param isVisible whether or not the fuel is to be visble or not
	 */
	public void fhide(boolean isVisible) {
		fHide = isVisible;
	}

	/**
	* Sets the rocket's engine 
	* @param e engine to be set
	 */
	public void setEngine(Engine e) {
		engine = e;
	}
	
	/**
	* Sets the rocket's fuel 
	* @param f fuel to be set
	 */
	public void setFuel(Fuel f) {
		fuel = f;
	}

	/**
	* Sets the state of the rocket and whether or not it is blown up. Setting to true results in the rocket blowing up, and setting to false results in rocket drawing and flying normally
	* @param s whether or not rocket is to be blown up
	 */
	public void setState(boolean s) {
		blownUp = s;
	}

	/**
	* Sets the rocket's width 
	* @param w width to be set
	 */
	public void setWidth(double w) {
		width = w;
	}
	/**
	* Sets the rocket's height 
	* @param h height to be set
	 */
	public void setHeight(double h) {
		height = h;
	}

	/**
	* Sets the rocket's x-coord 
	* @param xVal x-coord to be set
	 */
	public void setImageX(double xVal) {
		this.x = xVal;
	}

	/**
	* Sets the rocket's y-coord 
	* @param yVal y-coord to be set
	 */
	public void setImageY(double yVal) {
		this.y = yVal;
	}

	/**
	* Gets the rocket's current material
	* @return current material of the rocket
	 */
	public Material getMaterial() {
		return material;
	}
	/**
	* Gets the rocket's current x-coord
	* @return current x-coord of the rocket
	 */
	public double getX() {
		return x;
	}
	/**
	* Gets the rocket's current y-coord
	* @return current y-coord of the rocket
	 */
	public double getY() {
		return y;
	}
	
	/**
	* Gets the rocket's current velocity in the x-direction
	* @return current x-velocity of the rocket
	 */
	public double getVX() {
		return vx;
	}
	/**
	* Gets the rocket's current velocity in the y-direction
	* @return current y-velocity of the rocket
	 */
	public double getVY() {
		return vy;
	}
	
	/**
	* Gets the rocket's current image
	* @return current image of the rocket
	 */
	public PImage getImage() {
		return img;
	}

	/**
	* Gets the rocket's current engine
	* @return current engine of the rocket
	 */
	public Engine getEngine() {
		return engine;
	}
	
	/**
	* Gets the rocket's current fuel
	* @return current fuel of the rocket
	 */
	public Fuel getFuel() {
		return fuel;
	}

	/**
	*Calculates and updates the angle of tilt or rotation for the rocket 
	 */
	
	public void act() {
		
	//	System.out.println(dir);
		dir += vel;
		//engine.setDir(dir);
		
		if (moving) {
		//	moveByAmount(vx*Math.cos(Math.toRadians(dir + 90)), vy*Math.sin(Math.toRadians(dir + 90)));
		}
			
		
//		dir = Math.atan(((double)this.y-y)/(this.x-x));
//		if (this.x > x)
//			dir += Math.PI;
	}
	
	/**
	*Updates the velocity at which the rocket tilts / rotates
	@param vel amount to increase tiliting velocity by
	 */
	public void tilt(double vel) {
		this.vel += vel;
	}
	public void stopTilt() {
		this.vel = 0;
	}
	
	/**
	*Accelerates the the rocket and updates its velocity
	@param vx amount to increase x-velocity by
	@param vy amount to increase y-velocity by
	 */
	public void accelerate(double vx, double vy) {
		this.vx += vx;
		this.vy += vy;
		
	}
	
	/**
	*Gets the angle at which the rocket is facing
	*@return angle at which rocket is facing
	 */
	public double getDirection() {
		return dir;
	}
	
	/**
	*Sets the angle of rotation for rocket
	*@param angle at which to rotate rocket 
	 */
	public void setDirection(double dir) {
		this.dir = dir;
	}
	
	/**
	* Sets the rocket's move state. Setting to true results in rocket moving / flying, setting to false results in rocket not moving
	 */
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
			
			
			if (engine != null && material != null) {
				
				if (material.getName().equals("Steel")) { // height * sin(dir) = x
					
					img = drawer.loadImage("img/image-removebg-preview-steel-removebg-preview.png");
				}
				
				else if (material.getName().equals("Carbon Comp")) {
					img = drawer.loadImage("img/image-removebg-preview-cc-removebg-preview.png");
				}
			}
			
			else if (engine != null && material == null) {
				img = drawer.loadImage("img/image-removebg-preview.png");
			}
			
			else {
				img = drawer.loadImage("img/BuildShuttle-removebg-preview.png");
			}
			
//			if (material != null) {
//				
//				material.setX(x);
//				material.setY(y);
//				material.setWidth(width);
//				material.setHeight(height);
//				
//				material.draw(drawer);
//				
//					
//			}
//
//			if (fuel != null) {
//	
//				fuel.draw(drawer);
//		
//			}
			
			
				
		}
			
		else {
			drawer.image(drawer.loadImage("img/Explosion.png"), (float) x, (float) y);
		}
			
		
		
	}
	
	
	

}
