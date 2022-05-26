package rocket;

import processing.core.PApplet;
import processing.core.PImage;

/**
 * Represents meteors for level 3
 * @author Krish Jhurani
 *
 */
public class Meteor {
	private PImage img;
	private double x, y;
	public Meteor(PImage img, double x, double y) {
		this.img = img;
		this.x = x;
		this.y = y;
	}
	/**
	 * Gets the image of the meteor
	 * @return The meteor image
	 */
	public PImage img() {
		return img;
	}
	/**
	 * Gets the X value of the meteor
	 * @return The x-value of the meteor
	 */
	public double getX() {
		return x;
	}
	/**
	 * Gets the Y value of the meteor
	 * @return The y-value of the meteor
	 */
	public double getY() {
		return y;
	}
	
	/**
	 * Sets the y-value of the meteor
	 * @param yVal new y-value
	 */
	public void setMeteorY(double yVal) {
		this.y = yVal;
	}
	
	/**
	 * changes the y-value of the meteor
	 */
	public void change() {
		this.y++;
	}
	
	/**
	 * Draws the meteor to the DrawingSurface
	 * @param drawer DrawingSurface that the meteor will be drawn on
	 */
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
