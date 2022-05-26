package rocket;
// Represents fuels. Rocket class will make fuel objects

/**
 * Represents fuel for rocket
 * @author Rohan Gupta
 *
 */
import java.util.ArrayList;
import java.util.List;

import processing.core.PApplet;
import processing.core.PImage;
import screenClasses.Sidebar;
public class Fuel {
	
	private PImage image;
	private double x, y, width, height;
	private String name;
	private double weight;
	private boolean hide;
	/**
	 * Constructs a fuel object
	 * @param image the image of the specific type of fuel
	 * @param x the x-coordinate of fuel
	 * @param y the y-coordinate of the fuel
	 * @param width the width of the image of the fuel
	 * @param height the height of the image of the fuel
	 * @param name the name of the fuel
	 * @param weight how much the fuel weighs
	 */
	public Fuel(PImage image, double x, double y, double width, double height, String name, double weight) {
		this.image = image;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.name = name;
		this.weight = weight;
		hide = true;
	}
	/**
	 * Gets the image of the fuel
	 * @return the image of the type of fuel
	 */
	public PImage getImage() {
		return image;
	}
	/**
	 * Gets the weight of the fuel
	 * @return how much the fuel weighs
	 */
	public double getWeight() {
		return weight;
	}
	/**
	 * sets the x-coordinate of the fuel
	 * @param x x-coordinate of the fuel
	 */
	public void setX(double x) {
		this.x = x;
	}
	/**
	 * sets the y-coordinate of the fuel
	 * @param y y-coordinate of the fuel
	 */ 
	public void setY(double y) {
		this.y = y;
	}
	/**
	 * sets the width of the fuel 
	 * @param w width of the fuel 
	 */
	public void setWidth(double w) {
		width = w;
	}
	/**
	 * sets the height of the fuel
	 * @param h height of the fuel
	 */
	public void setHeight(double h) {
		height = h;
	}
	/**
	 * Gets the name of the type of fuel
	 * @return the name of the fuel
	 */
	public String getName() {
		return name;
	}
	/**
	 * Makes the fuel visible
	 */
	public void setVis() {
		hide = false;
	}
	/**
	 * Makes the fuel invisible 
	 */
	public void hide() {
		hide = true;
	}
	
	
	/**
	 * draws the fuel
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
