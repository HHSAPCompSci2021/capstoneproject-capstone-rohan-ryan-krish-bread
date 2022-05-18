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
//	public ArrayList<Material> materials = new ArrayList<>();
	public Material(PImage image, double x, double y, double width, double height, String name, double weight) {
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
	
	public PImage getImage() {
		return image;
	}
	
	public void setVis() {
		hide = false;
	}
	
	public void hide() {
		hide = true;
	}
	
	public String getName() {
		return name;
	}
	
	public double getWeight() {
		return weight;
	}
	
	public void setX(double x) {
		this.x = x;
	}
	
	public void setY(double y) {
		this.y = y;
	}
	
	public void setWidth(double w) {
		width = w;
	}
	
	public void setHeight(double h) {
		height = h;
	}
	
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
