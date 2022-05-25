package rocket;
import java.util.ArrayList;
import java.util.List;

import processing.core.PApplet;
import processing.core.PImage;
import screenClasses.Sidebar;

// represents materials. Rocket class will make material objects 

public class Material {
	
//	private static List<Material> materials;
	private PImage image;
	private double x, y, width, height;
	private String name;
	private double weight;
	private boolean hide;
	private double durability;
//	public ArrayList<Material> materials = new ArrayList<>();
	public Material(PImage image, double x, double y, double width, double height, String name, double weight, double durabilty) {
	//	materials = new ArrayList<>();
		this.image = image;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.name = name;
		this.weight = weight;
		hide = true;
		//
		
	}
	
//	public static List<Material> getMaterials() {
//		return materials;
//	}
	
	/**
	 * gets the image of the material
	 * @return image of this material
	 */
	public PImage getImage() {
		return image;
	}
	
	/**
	 * makes the material visible
	 */
	public void setVis() {
		hide = false;
	}
	
	/**
	 * hides the material
	 */
	public void hide() {
		hide = true;
	}
	
	/**
	 * gets the name 
	 * @return get the name of the material
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * gets the durability of this material
	 * @return durability of this material
	 */
	public double getDura() {
		return durability;
	}
	
	/**
	 * gets the weight of the material
	 * @return weight of the material
	 */
	public double getWeight() {
		return weight;
	}
	
	/**
	 * sets the x-coordinate of the material 
	 * @param x x-coordinate of the material 
	 */
	public void setX(double x) {
		this.x = x;
	}
	
	/**
	 * sets the y-coordinate of the material 
	 * @param y y-coordiate of the material 
	 */
	public void setY(double y) {
		this.y = y;
	}
	
	/**
	 * sets the width of the material 
	 * @param w width of the material 
	 */
	public void setWidth(double w) {
		width = w;
	}
	
	/**
	 * sets the height of the materials 
	 * @param h height of the materials 
	 */
	public void setHeight(double h) {
		height = h;
	}
	
	/**
	 * draws the material 
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
