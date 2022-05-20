package rocket;
import java.util.List;

import processing.core.PApplet;
import processing.core.PImage;
import screenClasses.Sidebar;

/**
 * represents engines for rocket
 * @author rgupta770
 *
 */
// Represents engines. Rocket class will make engine objects 
public class Engine  {
	
	//private static List<Engine> engine;
	private PImage image;
	private double x, y, width, height;
	private String name;
	
	// data
	private double weight;
	private double reliability;
	private double thurst;
	private boolean hide;
	
	
	// counter for how many times draw is called.
	// check if reliabilty less than equal to math.random every 60 times
	
	/**
	 * constructs an engine object 
	 * @param image image of engine
	 * @param x x-cord at which to draw
	 * @param y y-cord at which to draw
	 * @param width width of engine
	 * @param height height of engine
	 * @param name name of engine
	 * @param weight weight of engine
	 * @param reliability reliability of engine
	 * @param thrust thrust of engine
	 */
	
	public Engine(PImage image, double x, double y, double width, double height, String name, double weight, double reliability, double thrust) {
		
		hide = true;
		this.image = image;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.name = name;
		
		this.weight = weight;
		this.reliability = reliability;
		this.thurst = thrust;
	
		// TODO Auto-generated constructor stub
	}
	
//	public static List<Engine> getEngine() {
//		return engine;
//	}
	
	/**
	 * gets the image of the rocket
	 * @return image of rocket
	 */
	public PImage getImage() {
		return image;
	}
	
	/**
	 * makes the engine visible
	 */
	public void setVis() {
		hide = false;
	}
	
	/**
	 * hides the engine
	 */
	public void hide() {
		hide = true;
	}
	
	/**
	 * gets the name 
	 * @return get the name of the engine
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * gets the weight of the engine
	 * @return weight of the engine
	 */
	public double getWeight() {
		return weight;
	}
	
	/**
	 * sets the x-coord of the engine 
	 * @param x x-coord of the engine 
	 */
	public void setX(double x) {
		this.x = x;
	}
	
	/**
	 * sets the y-coord of the engine 
	 * @param y y-coord of the engine 
	 */
	public void setY(double y) {
		this.y = y;
	}
	
	/**
	 * sets the width of the engine 
	 * @param w width of the engine 
	 */
	public void setWidth(double w) {
		width = w;
	}
	
	/**
	 * sets the height of the engine 
	 * @param h height of the engine 
	 */
	public void setHeight(double h) {
		height = h;
	}
	
	/**
	 * sets the reliabilty of the engine 
	 * @return the reliabilty of the engine 
	 */
	public double getReliability() {
		return reliability;
	}
	
	/**
	 * sets the thrust of the engine 
	 * @return the thrust of the engine 
	 */
	
	public double getThrust() {
		return thurst;
	}
	
	/**
	 * draws the engine 
	 * @param g PApplet on which to draw
	 */
	public void draw(PApplet g) {
		
		if (image != null) {
			
			if (hide == false) {
				g.image(image,(float)x,(float)y,(float)width,(float)height);
			}
			
		}
			
		else {
			g.fill(100);
			g.rect((float)x,(float)y,(float)width,(float)height);
		}
		
	}

}
