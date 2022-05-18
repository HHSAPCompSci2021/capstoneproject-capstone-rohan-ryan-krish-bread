package rocket;
import java.util.List;

import processing.core.PApplet;
import processing.core.PImage;
import screenClasses.Sidebar;

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
	
	// 
	// counter for how many times draw is called.
	// check if reliabilty less than equal to math.random every 60 times
	
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
	
	public double getReliability() {
		return reliability;
	}
	
	public double getThrust() {
		return thurst;
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
